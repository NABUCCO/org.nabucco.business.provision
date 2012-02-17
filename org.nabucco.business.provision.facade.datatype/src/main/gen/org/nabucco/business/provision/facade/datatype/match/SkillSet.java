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
import org.nabucco.business.provision.facade.datatype.match.PresentSkill;
import org.nabucco.business.provision.facade.datatype.match.SkillRefKey;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * SkillSet<p/>The Element groping list of skills to the reference key<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2011-11-23
 */
public class SkillSet extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;", "l5,n;u0,n;m1,1;" };

    public static final String SKILLLIST = "skillList";

    public static final String REFERENCEKEY = "referenceKey";

    /** referenced skill list */
    public NabuccoList<PresentSkill> skillList;

    /** The reference key of the set (can be the person id, project id etc.) */
    public SkillRefKey referenceKey;

    /** Constructs a new SkillSet instance. */
    public SkillSet() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the SkillSet.
     */
    protected void cloneObject(SkillSet clone) {
        super.cloneObject(clone);
        if ((this.skillList != null)) {
            clone.skillList = this.skillList.cloneCollection();
        }
        if ((this.getReferenceKey() != null)) {
            clone.setReferenceKey(this.getReferenceKey().cloneObject());
        }
    }

    /**
     * Getter for the SkillListJPA.
     *
     * @return the List<PresentSkill>.
     */
    List<PresentSkill> getSkillListJPA() {
        if ((this.skillList == null)) {
            this.skillList = new NabuccoListImpl<PresentSkill>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<PresentSkill>) this.skillList).getDelegate();
    }

    /**
     * Setter for the SkillListJPA.
     *
     * @param skillList the List<PresentSkill>.
     */
    void setSkillListJPA(List<PresentSkill> skillList) {
        if ((this.skillList == null)) {
            this.skillList = new NabuccoListImpl<PresentSkill>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<PresentSkill>) this.skillList).setDelegate(skillList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(SKILLLIST, PropertyDescriptorSupport.createCollection(SKILLLIST, PresentSkill.class, 3,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(REFERENCEKEY, PropertyDescriptorSupport.createBasetype(REFERENCEKEY, SkillRefKey.class, 4,
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
        properties.add(super.createProperty(SkillSet.getPropertyDescriptor(SKILLLIST), this.skillList, null));
        properties.add(super.createProperty(SkillSet.getPropertyDescriptor(REFERENCEKEY), this.referenceKey, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SKILLLIST) && (property.getType() == PresentSkill.class))) {
            this.skillList = ((NabuccoList<PresentSkill>) property.getInstance());
            return true;
        } else if ((property.getName().equals(REFERENCEKEY) && (property.getType() == SkillRefKey.class))) {
            this.setReferenceKey(((SkillRefKey) property.getInstance()));
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
        final SkillSet other = ((SkillSet) obj);
        if ((this.referenceKey == null)) {
            if ((other.referenceKey != null))
                return false;
        } else if ((!this.referenceKey.equals(other.referenceKey)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.referenceKey == null) ? 0 : this.referenceKey.hashCode()));
        return result;
    }

    @Override
    public SkillSet cloneObject() {
        SkillSet clone = new SkillSet();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * referenced skill list
     *
     * @return the NabuccoList<PresentSkill>.
     */
    public NabuccoList<PresentSkill> getSkillList() {
        if ((this.skillList == null)) {
            this.skillList = new NabuccoListImpl<PresentSkill>(NabuccoCollectionState.INITIALIZED);
        }
        return this.skillList;
    }

    /**
     * The reference key of the set (can be the person id, project id etc.)
     *
     * @return the SkillRefKey.
     */
    public SkillRefKey getReferenceKey() {
        return this.referenceKey;
    }

    /**
     * The reference key of the set (can be the person id, project id etc.)
     *
     * @param referenceKey the SkillRefKey.
     */
    public void setReferenceKey(SkillRefKey referenceKey) {
        this.referenceKey = referenceKey;
    }

    /**
     * The reference key of the set (can be the person id, project id etc.)
     *
     * @param referenceKey the String.
     */
    public void setReferenceKey(String referenceKey) {
        if ((this.referenceKey == null)) {
            if ((referenceKey == null)) {
                return;
            }
            this.referenceKey = new SkillRefKey();
        }
        this.referenceKey.setValue(referenceKey);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(SkillSet.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(SkillSet.class).getAllProperties();
    }
}
