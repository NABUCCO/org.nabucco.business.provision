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
package org.nabucco.business.provision.impl.service.match;

import java.util.List;

import org.nabucco.business.provision.facade.datatype.match.SkillMatchAlgorithmus;
import org.nabucco.business.provision.facade.datatype.match.SkillMatchGroup;
import org.nabucco.business.provision.facade.datatype.match.SkillReference;
import org.nabucco.business.provision.facade.datatype.match.SkillSet;
import org.nabucco.business.provision.facade.exception.ProvisionMatchException;
import org.nabucco.business.provision.facade.message.match.SkillMatchRq;
import org.nabucco.business.provision.facade.message.match.SkillMatchRs;
import org.nabucco.business.provision.impl.service.match.algorithm.SkillMatchingAlgorithm;
import org.nabucco.business.provision.impl.service.match.algorithm.StandardMatchingAlgorithm;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;

/**
 * MatchSkillsServiceHandler
 * 
 * Skillmatching algorithmus
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class MatchSkillsServiceHandlerImpl extends MatchSkillsServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected SkillMatchRs matchSkills(SkillMatchRq msg) throws ProvisionMatchException {
        NabuccoList<SkillReference> requiredSkills = msg.getRequiredSkills();

        if (requiredSkills == null) {
            throw new ProvisionMatchException("Cannot match skills. Required skills are 'null'");
        }

        NabuccoList<SkillSet> presentSkillSets = msg.getPresentSkillSets();

        if (presentSkillSets == null) {
            throw new ProvisionMatchException("Cannot match skills. Present skills are 'null'");
        }

        SkillMatchAlgorithmus algorithm = msg.getAlgorithm();

        if (algorithm == null) {
            throw new ProvisionMatchException("Cannot match skills. The algorithm is 'null'");
        }

        SkillMatchingAlgorithm matcher = this.getMatcherInstance(algorithm);
        List<SkillMatchGroup> matchResult = matcher.match(requiredSkills, presentSkillSets);

        SkillMatchRs result = new SkillMatchRs();
        result.getMatchResultList().addAll(matchResult);

        return result;
    }

    /**
     * Creates a new Matcher instance to the given algorithm
     * 
     * @param algorithm
     *            the algorithm to use
     * @return the instance
     * @throws ProvisionMatchException
     *             if no algorithm found
     */
    private SkillMatchingAlgorithm getMatcherInstance(SkillMatchAlgorithmus algorithm) throws ProvisionMatchException {
        switch (algorithm) {
        case STANDARD: {
            return new StandardMatchingAlgorithm();
        }
        default: {
            throw new ProvisionMatchException("The asked matching algorithm is not implemented yet");
        }
        }
    }

}
