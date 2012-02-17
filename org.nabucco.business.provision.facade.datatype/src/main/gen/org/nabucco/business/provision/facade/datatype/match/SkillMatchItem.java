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
package org.nabucco.business.provision.facade.datatype.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.Skill;
import org.nabucco.business.provision.facade.datatype.match.SkillMatch;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * SkillMatchItem<p/>The match result of the single skill<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2011-11-23
 */
public class SkillMatchItem extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;u0,n;m1,1;" };

    public static final String MATCHEDSKILL = "matchedSkill";

    public static final String SKILLMATCH = "skillMatch";

    /** The matched skill */
    public Skill matchedSkill;

    /** The match of the skill relative to the given skill requerement */
    public SkillMatch skillMatch;

    /** Constructs a new SkillMatchItem instance. */
    public SkillMatchItem() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the SkillMatchItem.
     */
    protected void cloneObject(SkillMatchItem clone) {
        super.cloneObject(clone);
        if ((this.getMatchedSkill() != null)) {
            clone.setMatchedSkill(this.getMatchedSkill().cloneObject());
        }
        if ((this.getSkillMatch() != null)) {
            clone.setSkillMatch(this.getSkillMatch().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(MATCHEDSKILL, PropertyDescriptorSupport.createDatatype(MATCHEDSKILL, Skill.class, 3,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(SKILLMATCH, PropertyDescriptorSupport.createBasetype(SKILLMATCH, SkillMatch.class, 4,
                PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(SkillMatchItem.getPropertyDescriptor(MATCHEDSKILL), this.getMatchedSkill(),
                null));
        properties.add(super.createProperty(SkillMatchItem.getPropertyDescriptor(SKILLMATCH), this.skillMatch, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(MATCHEDSKILL) && (property.getType() == Skill.class))) {
            this.setMatchedSkill(((Skill) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SKILLMATCH) && (property.getType() == SkillMatch.class))) {
            this.setSkillMatch(((SkillMatch) property.getInstance()));
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final SkillMatchItem other = ((SkillMatchItem) obj);
        if ((this.matchedSkill == null)) {
            if ((other.matchedSkill != null))
                return false;
        } else if ((!this.matchedSkill.equals(other.matchedSkill)))
            return false;
        if ((this.skillMatch == null)) {
            if ((other.skillMatch != null))
                return false;
        } else if ((!this.skillMatch.equals(other.skillMatch)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.matchedSkill == null) ? 0 : this.matchedSkill.hashCode()));
        result = ((PRIME * result) + ((this.skillMatch == null) ? 0 : this.skillMatch.hashCode()));
        return result;
    }

    @Override
    public SkillMatchItem cloneObject() {
        SkillMatchItem clone = new SkillMatchItem();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * The matched skill
     *
     * @param matchedSkill the Skill.
     */
    public void setMatchedSkill(Skill matchedSkill) {
        this.matchedSkill = matchedSkill;
    }

    /**
     * The matched skill
     *
     * @return the Skill.
     */
    public Skill getMatchedSkill() {
        return this.matchedSkill;
    }

    /**
     * The match of the skill relative to the given skill requerement
     *
     * @return the SkillMatch.
     */
    public SkillMatch getSkillMatch() {
        return this.skillMatch;
    }

    /**
     * The match of the skill relative to the given skill requerement
     *
     * @param skillMatch the SkillMatch.
     */
    public void setSkillMatch(SkillMatch skillMatch) {
        this.skillMatch = skillMatch;
    }

    /**
     * The match of the skill relative to the given skill requerement
     *
     * @param skillMatch the java.math.BigDecimal.
     */
    public void setSkillMatch(java.math.BigDecimal skillMatch) {
        if ((this.skillMatch == null)) {
            if ((skillMatch == null)) {
                return;
            }
            this.skillMatch = new SkillMatch();
        }
        this.skillMatch.setValue(skillMatch);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(SkillMatchItem.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(SkillMatchItem.class).getAllProperties();
    }
}
