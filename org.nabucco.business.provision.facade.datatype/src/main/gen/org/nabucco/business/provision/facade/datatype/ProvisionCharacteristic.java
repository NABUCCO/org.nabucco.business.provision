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
package org.nabucco.business.provision.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.business.provision.facade.datatype.ProvisionRelation;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.business.provision.Provision;
import org.nabucco.framework.base.facade.datatype.code.Code;
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
 * ProvisionCharacteristic
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public abstract class ProvisionCharacteristic extends Provision implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,n;" };

    public static final String CHARACTERISTICTYPE = "characteristicType";

    public static final String RELATIONLIST = "relationList";

    protected ProvisionCharacteristicType characteristicType;

    private NabuccoList<ProvisionRelation> relationList;

    private Long functionalTypeRefId;

    /** Constructs a new ProvisionCharacteristic instance. */
    public ProvisionCharacteristic() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProvisionCharacteristic.
     */
    protected void cloneObject(ProvisionCharacteristic clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.relationList != null)) {
            clone.relationList = this.relationList.cloneCollection();
        }
    }

    /**
     * Getter for the RelationListJPA.
     *
     * @return the List<ProvisionRelation>.
     */
    List<ProvisionRelation> getRelationListJPA() {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<ProvisionRelation>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ProvisionRelation>) this.relationList).getDelegate();
    }

    /**
     * Setter for the RelationListJPA.
     *
     * @param relationList the List<ProvisionRelation>.
     */
    void setRelationListJPA(List<ProvisionRelation> relationList) {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<ProvisionRelation>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ProvisionRelation>) this.relationList).setDelegate(relationList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(Provision.class).getPropertyMap());
        propertyMap.put(CHARACTERISTICTYPE, PropertyDescriptorSupport.createEnumeration(CHARACTERISTICTYPE,
                ProvisionCharacteristicType.class, 9, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(RELATIONLIST, PropertyDescriptorSupport.createCollection(RELATIONLIST, ProvisionRelation.class,
                10, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProvisionCharacteristic.getPropertyDescriptor(CHARACTERISTICTYPE),
                this.getCharacteristicType(), null));
        properties.add(super.createProperty(ProvisionCharacteristic.getPropertyDescriptor(RELATIONLIST),
                this.relationList, null));
        properties.add(super.createProperty(ProvisionCharacteristic.getPropertyDescriptor(FUNCTIONALTYPE),
                this.getFunctionalType(), this.functionalTypeRefId));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CHARACTERISTICTYPE) && (property.getType() == ProvisionCharacteristicType.class))) {
            this.setCharacteristicType(((ProvisionCharacteristicType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RELATIONLIST) && (property.getType() == ProvisionRelation.class))) {
            this.relationList = ((NabuccoList<ProvisionRelation>) property.getInstance());
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
        final ProvisionCharacteristic other = ((ProvisionCharacteristic) obj);
        if ((this.characteristicType == null)) {
            if ((other.characteristicType != null))
                return false;
        } else if ((!this.characteristicType.equals(other.characteristicType)))
            return false;
        if ((this.functionalTypeRefId == null)) {
            if ((other.functionalTypeRefId != null))
                return false;
        } else if ((!this.functionalTypeRefId.equals(other.functionalTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.characteristicType == null) ? 0 : this.characteristicType.hashCode()));
        result = ((PRIME * result) + ((this.functionalTypeRefId == null) ? 0 : this.functionalTypeRefId.hashCode()));
        return result;
    }

    @Override
    public abstract ProvisionCharacteristic cloneObject();

    /**
     * Missing description at method getCharacteristicType.
     *
     * @return the ProvisionCharacteristicType.
     */
    public ProvisionCharacteristicType getCharacteristicType() {
        return this.characteristicType;
    }

    /**
     * Missing description at method setCharacteristicType.
     *
     * @param characteristicType the ProvisionCharacteristicType.
     */
    public void setCharacteristicType(ProvisionCharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
    }

    /**
     * Missing description at method setCharacteristicType.
     *
     * @param characteristicType the String.
     */
    public void setCharacteristicType(String characteristicType) {
        if ((characteristicType == null)) {
            this.characteristicType = null;
        } else {
            this.characteristicType = ProvisionCharacteristicType.valueOf(characteristicType);
        }
    }

    /**
     * Missing description at method getRelationList.
     *
     * @return the NabuccoList<ProvisionRelation>.
     */
    public NabuccoList<ProvisionRelation> getRelationList() {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<ProvisionRelation>(NabuccoCollectionState.INITIALIZED);
        }
        return this.relationList;
    }

    /**
     * Getter for the FunctionalTypeRefId.
     *
     * @return the Long.
     */
    public Long getFunctionalTypeRefId() {
        return this.functionalTypeRefId;
    }

    /**
     * Setter for the FunctionalTypeRefId.
     *
     * @param functionalTypeRefId the Long.
     */
    public void setFunctionalTypeRefId(Long functionalTypeRefId) {
        this.functionalTypeRefId = functionalTypeRefId;
    }

    /**
     * Setter for the FunctionalType.
     *
     * @param functionalType the Code.
     */
    public void setFunctionalType(Code functionalType) {
        super.setFunctionalType(functionalType);
        if ((functionalType != null)) {
            this.setFunctionalTypeRefId(functionalType.getId());
        } else {
            this.setFunctionalTypeRefId(null);
        }
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProvisionCharacteristic.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProvisionCharacteristic.class).getAllProperties();
    }
}
