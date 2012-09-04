/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.provision.facade.datatype.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.ProvisionAssignment;
import org.nabucco.business.provision.facade.datatype.match.SkillWeight;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * PresentSkill<p/>The Assignment of the skill to its level<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2011-11-24
 */
public class PresentSkill extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;u0,100;m1,1;" };

    public static final String SKILLASSIGNMENT = "skillAssignment";

    public static final String SKILLEXPERIENCE = "skillExperience";

    /** The present skill */
    public ProvisionAssignment skillAssignment;

    /** The experience of the skill */
    public SkillWeight skillExperience;

    /** Constructs a new PresentSkill instance. */
    public PresentSkill() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the PresentSkill.
     */
    protected void cloneObject(PresentSkill clone) {
        super.cloneObject(clone);
        if ((this.getSkillAssignment() != null)) {
            clone.setSkillAssignment(this.getSkillAssignment().cloneObject());
        }
        if ((this.getSkillExperience() != null)) {
            clone.setSkillExperience(this.getSkillExperience().cloneObject());
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
        propertyMap.put(SKILLASSIGNMENT, PropertyDescriptorSupport.createDatatype(SKILLASSIGNMENT,
                ProvisionAssignment.class, 3, PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(SKILLEXPERIENCE, PropertyDescriptorSupport.createBasetype(SKILLEXPERIENCE, SkillWeight.class,
                4, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PresentSkill.getPropertyDescriptor(SKILLASSIGNMENT),
                this.getSkillAssignment(), null));
        properties.add(super.createProperty(PresentSkill.getPropertyDescriptor(SKILLEXPERIENCE), this.skillExperience,
                null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SKILLASSIGNMENT) && (property.getType() == ProvisionAssignment.class))) {
            this.setSkillAssignment(((ProvisionAssignment) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SKILLEXPERIENCE) && (property.getType() == SkillWeight.class))) {
            this.setSkillExperience(((SkillWeight) property.getInstance()));
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
        final PresentSkill other = ((PresentSkill) obj);
        if ((this.skillAssignment == null)) {
            if ((other.skillAssignment != null))
                return false;
        } else if ((!this.skillAssignment.equals(other.skillAssignment)))
            return false;
        if ((this.skillExperience == null)) {
            if ((other.skillExperience != null))
                return false;
        } else if ((!this.skillExperience.equals(other.skillExperience)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.skillAssignment == null) ? 0 : this.skillAssignment.hashCode()));
        result = ((PRIME * result) + ((this.skillExperience == null) ? 0 : this.skillExperience.hashCode()));
        return result;
    }

    @Override
    public PresentSkill cloneObject() {
        PresentSkill clone = new PresentSkill();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * The present skill
     *
     * @param skillAssignment the ProvisionAssignment.
     */
    public void setSkillAssignment(ProvisionAssignment skillAssignment) {
        this.skillAssignment = skillAssignment;
    }

    /**
     * The present skill
     *
     * @return the ProvisionAssignment.
     */
    public ProvisionAssignment getSkillAssignment() {
        return this.skillAssignment;
    }

    /**
     * The experience of the skill
     *
     * @return the SkillWeight.
     */
    public SkillWeight getSkillExperience() {
        return this.skillExperience;
    }

    /**
     * The experience of the skill
     *
     * @param skillExperience the SkillWeight.
     */
    public void setSkillExperience(SkillWeight skillExperience) {
        this.skillExperience = skillExperience;
    }

    /**
     * The experience of the skill
     *
     * @param skillExperience the Integer.
     */
    public void setSkillExperience(Integer skillExperience) {
        if ((this.skillExperience == null)) {
            if ((skillExperience == null)) {
                return;
            }
            this.skillExperience = new SkillWeight();
        }
        this.skillExperience.setValue(skillExperience);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PresentSkill.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PresentSkill.class).getAllProperties();
    }
}
