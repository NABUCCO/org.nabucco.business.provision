/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.business.provision.impl.service.match.algorithm;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import org.nabucco.business.provision.facade.datatype.ProvisionAssignment;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.business.provision.facade.datatype.Skill;
import org.nabucco.business.provision.facade.datatype.match.PresentSkill;
import org.nabucco.business.provision.facade.datatype.match.SkillMatchGroup;
import org.nabucco.business.provision.facade.datatype.match.SkillMatchItem;
import org.nabucco.business.provision.facade.datatype.match.SkillRefKey;
import org.nabucco.business.provision.facade.datatype.match.SkillReference;
import org.nabucco.business.provision.facade.datatype.match.SkillSet;
import org.nabucco.business.provision.facade.exception.ProvisionMatchException;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;

/**
 * StandardMatchingAlgorithm
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class StandardMatchingAlgorithm implements SkillMatchingAlgorithm {

    NabuccoLogger logger = NabuccoLoggingFactory.getInstance().getLogger(StandardMatchingAlgorithm.class);

    @Override
    public List<SkillMatchGroup> match(List<SkillReference> requiredSkills, List<SkillSet> presentSkillSets)
            throws ProvisionMatchException {

        List<SkillMatchGroup> result = new ArrayList<SkillMatchGroup>();

        for (SkillSet skillSet : presentSkillSets) {
            SkillMatchGroup matchingRes = this.matchSkillSet(requiredSkills, skillSet);
            result.add(matchingRes);
        }

        return result;
    }

    /**
     * Matches the skillSet (skills of one person, project etc)
     * 
     * @param requiredSkills
     *            required skills
     * @param presentSkillSet
     *            skillset to match
     * @return The evaluation of skill matching
     */
    private SkillMatchGroup matchSkillSet(List<SkillReference> requiredSkills, SkillSet presentSkillSet)
            throws ProvisionMatchException {
        SkillMatchGroup result = new SkillMatchGroup();

        SkillRefKey referenceKey = presentSkillSet.getReferenceKey();
        result.setSkillRefKey(referenceKey);

        NabuccoList<PresentSkill> presentSkillList = presentSkillSet.getSkillList();

        // If no required skills present, than every skill set is matching the requirements
        if (requiredSkills.size() == 0) {
            BigDecimal match = new BigDecimal(1);
            result.setSkillMatch(match);
            return result;
        }

        BigDecimal groupMatch = new BigDecimal(0);

        // Match every skill
        for (SkillReference requiredSkill : requiredSkills) {

            SkillMatchItem matchSingleSkill = this.matchSingleSkill(requiredSkill, presentSkillList);
            result.getMatchedSkillList().add(matchSingleSkill);

        }

        NabuccoList<SkillMatchItem> matchedSkillList = result.getMatchedSkillList();
        // Calculate average match
        for (SkillMatchItem singleMatchResult : matchedSkillList) {
            BigDecimal singleMatch = singleMatchResult.getSkillMatch().getValue();
            groupMatch = groupMatch.add(singleMatch);
        }

        if (matchedSkillList.size() > 0) {
            BigDecimal count = new BigDecimal(matchedSkillList.size());
            groupMatch = groupMatch.divide(count, MathContext.DECIMAL64);
            result.setSkillMatch(groupMatch);
        }
        return result;
    }

    /**
     * Matches the single skill with referenced one
     * 
     * @param requieredskill
     *            skill that is required
     * @param presentSkill
     *            skill that is avaliable
     * @return the skill match result
     */
    private SkillMatchItem matchSingleSkill(SkillReference requieredskill, NabuccoList<PresentSkill> presentSkillList)
            throws ProvisionMatchException {
        SkillMatchItem result = new SkillMatchItem();

        PresentSkill foundSkill = this.searchForSkill(presentSkillList, requieredskill);
        BigDecimal matchingResult = null;

        if (foundSkill == null) {
            // Skill is not avaliable
            matchingResult = BigDecimal.ZERO;
            ProvisionCharacteristic skill = requieredskill.getSkillAssignment().getCharacteristic();
            if (!skill.getCharacteristicType().equals(ProvisionCharacteristicType.SKILL)) {
                throw new ProvisionMatchException(
                        "Cannot assign skill to the result. Wrong provision characteristic type");
            }
            result.setMatchedSkill((Skill) skill);
        } else {
            ProvisionCharacteristic skill = requieredskill.getSkillAssignment().getCharacteristic();
            if (!skill.getCharacteristicType().equals(ProvisionCharacteristicType.SKILL)) {
                throw new ProvisionMatchException(
                        "Cannot assign skill to the result. Wrong provision characteristic type");
            }
            Skill matchedSkill = (Skill) skill;

            BigDecimal presentExperience = new BigDecimal(foundSkill.getSkillExperience().getValue());
            BigDecimal requiredExperience = new BigDecimal(requieredskill.getSkillWeight().getValue());

            if (requiredExperience.compareTo(BigDecimal.ZERO) == 0) {
                // If required experiance is 0 and skill is avaliable
                matchingResult = BigDecimal.ONE;
            } else {
                // The required skill is not 0 => need to be matched
                if (requiredExperience.compareTo(presentExperience) > 0) {
                    // The situation where the required skill is greater that available
                    switch (requieredskill.getSkillAssignment().getRequirementType()) {
                    case MANDATORY: {
                        // Mandatory skill is 0 or 100
                        matchingResult = BigDecimal.ZERO;
                        break;
                    }
                    case OPTIONAL: {
                        // Optional skill is between 0 and 100
                        matchingResult = presentExperience.divide(requiredExperience, MathContext.DECIMAL64);
                        break;
                    }
                    case RECOMMENDED: {
                        // Optional skill is between 0 and 100
                        matchingResult = presentExperience.divide(requiredExperience, MathContext.DECIMAL64);
                        break;
                    }
                    case SUGGESTED: {
                        // Optional skill is between 0 and 100
                        matchingResult = presentExperience.divide(requiredExperience, MathContext.DECIMAL64);
                        break;
                    }
                    case NONE: {
                        this.logger.debug("The requirement type of skill assignment is 'none'. ",
                                " Ignoring it and interpreting it as optional requirement type.");
                        // Optional skill is between 0 and 100
                        matchingResult = presentExperience.divide(requiredExperience, MathContext.DECIMAL64);
                        break;

                    }
                    default: {
                        throw new ProvisionMatchException(
                                "Cannot evaluate Skill. The requirement type is not supported.");
                    }
                    }

                } else {
                    matchingResult = BigDecimal.ONE;
                }
            }
            result.setMatchedSkill(matchedSkill);
        }

        if (matchingResult == null) {
            throw new ProvisionMatchException("Cannot calculate skill match. Matching result is 'null'.");
        }

        result.setSkillMatch(matchingResult);

        return result;
    }

    /**
     * Iterates list with presendSkills and search for the requiredSkill
     * 
     * @param presentSkillList
     *            the list of presentSkills
     * @param requiredSkill
     *            the requirer skill to search
     */
    private PresentSkill searchForSkill(NabuccoList<PresentSkill> presentSkillList, SkillReference requiredSkill) {
        PresentSkill foundSkill = null;

        // Search if the set contains required skill
        for (PresentSkill presentSkill : presentSkillList) {
            ProvisionAssignment reqSkill = requiredSkill.getSkillAssignment();
            ProvisionAssignment avaliableSkill = presentSkill.getSkillAssignment();

            ProvisionCharacteristic pSkill = avaliableSkill.getCharacteristic();
            ProvisionCharacteristic rSkill = reqSkill.getCharacteristic();
            if (pSkill.equals(rSkill)) {
                foundSkill = presentSkill;
                break;
            }
        }

        return foundSkill;
    }
}
