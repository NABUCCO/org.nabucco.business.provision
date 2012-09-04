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
package org.nabucco.business.provision.facade.message.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.match.SkillMatchAlgorithmus;
import org.nabucco.business.provision.facade.datatype.match.SkillReference;
import org.nabucco.business.provision.facade.datatype.match.SkillSet;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * SkillMatchRq<p/>Request for skill matching operation<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2011-11-23
 */
public class SkillMatchRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,n;", "m1,n;", "m1,1;" };

    public static final String REQUIREDSKILLS = "requiredSkills";

    public static final String PRESENTSKILLSETS = "presentSkillSets";

    public static final String ALGORITHM = "algorithm";

    /** Skills that specify the match requirement */
    private NabuccoList<SkillReference> requiredSkills;

    /** Skills to be matched */
    private NabuccoList<SkillSet> presentSkillSets;

    /** The algorithm to use for the matching */
    private SkillMatchAlgorithmus algorithm;

    /** Constructs a new SkillMatchRq instance. */
    public SkillMatchRq() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(REQUIREDSKILLS, PropertyDescriptorSupport.createCollection(REQUIREDSKILLS,
                SkillReference.class, 0, PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(PRESENTSKILLSETS, PropertyDescriptorSupport.createCollection(PRESENTSKILLSETS, SkillSet.class,
                1, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(ALGORITHM, PropertyDescriptorSupport.createEnumeration(ALGORITHM, SkillMatchAlgorithmus.class,
                2, PROPERTY_CONSTRAINTS[2], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(SkillMatchRq.getPropertyDescriptor(REQUIREDSKILLS), this.requiredSkills));
        properties
                .add(super.createProperty(SkillMatchRq.getPropertyDescriptor(PRESENTSKILLSETS), this.presentSkillSets));
        properties.add(super.createProperty(SkillMatchRq.getPropertyDescriptor(ALGORITHM), this.getAlgorithm()));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(REQUIREDSKILLS) && (property.getType() == SkillReference.class))) {
            this.requiredSkills = ((NabuccoList<SkillReference>) property.getInstance());
            return true;
        } else if ((property.getName().equals(PRESENTSKILLSETS) && (property.getType() == SkillSet.class))) {
            this.presentSkillSets = ((NabuccoList<SkillSet>) property.getInstance());
            return true;
        } else if ((property.getName().equals(ALGORITHM) && (property.getType() == SkillMatchAlgorithmus.class))) {
            this.setAlgorithm(((SkillMatchAlgorithmus) property.getInstance()));
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
        final SkillMatchRq other = ((SkillMatchRq) obj);
        if ((this.requiredSkills == null)) {
            if ((other.requiredSkills != null))
                return false;
        } else if ((!this.requiredSkills.equals(other.requiredSkills)))
            return false;
        if ((this.presentSkillSets == null)) {
            if ((other.presentSkillSets != null))
                return false;
        } else if ((!this.presentSkillSets.equals(other.presentSkillSets)))
            return false;
        if ((this.algorithm == null)) {
            if ((other.algorithm != null))
                return false;
        } else if ((!this.algorithm.equals(other.algorithm)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.requiredSkills == null) ? 0 : this.requiredSkills.hashCode()));
        result = ((PRIME * result) + ((this.presentSkillSets == null) ? 0 : this.presentSkillSets.hashCode()));
        result = ((PRIME * result) + ((this.algorithm == null) ? 0 : this.algorithm.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Skills that specify the match requirement
     *
     * @return the NabuccoList<SkillReference>.
     */
    public NabuccoList<SkillReference> getRequiredSkills() {
        if ((this.requiredSkills == null)) {
            this.requiredSkills = new NabuccoListImpl<SkillReference>(NabuccoCollectionState.INITIALIZED);
        }
        return this.requiredSkills;
    }

    /**
     * Skills to be matched
     *
     * @return the NabuccoList<SkillSet>.
     */
    public NabuccoList<SkillSet> getPresentSkillSets() {
        if ((this.presentSkillSets == null)) {
            this.presentSkillSets = new NabuccoListImpl<SkillSet>(NabuccoCollectionState.INITIALIZED);
        }
        return this.presentSkillSets;
    }

    /**
     * The algorithm to use for the matching
     *
     * @return the SkillMatchAlgorithmus.
     */
    public SkillMatchAlgorithmus getAlgorithm() {
        return this.algorithm;
    }

    /**
     * The algorithm to use for the matching
     *
     * @param algorithm the SkillMatchAlgorithmus.
     */
    public void setAlgorithm(SkillMatchAlgorithmus algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(SkillMatchRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(SkillMatchRq.class).getAllProperties();
    }
}
