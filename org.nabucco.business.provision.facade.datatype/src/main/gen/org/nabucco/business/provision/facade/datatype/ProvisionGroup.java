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
package org.nabucco.business.provision.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.business.provision.facade.datatype.ProvisionGroupCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ProvisionGroup
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class ProvisionGroup extends ProvisionCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final ProvisionGroupCharacteristicType GROUPCHARACTERISTICTYPE_DEFAULT = ProvisionGroupCharacteristicType.SKILL;

    private static final ProvisionCharacteristicType CHARACTERISTICTYPE_DEFAULT = ProvisionCharacteristicType.PROVISION_GROUP;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    public static final String GROUPCHARACTERISTICTYPE = "groupCharacteristicType";

    private ProvisionGroupCharacteristicType groupCharacteristicType;

    /** Constructs a new ProvisionGroup instance. */
    public ProvisionGroup() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        characteristicType = CHARACTERISTICTYPE_DEFAULT;
        groupCharacteristicType = GROUPCHARACTERISTICTYPE_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the ProvisionGroup.
     */
    protected void cloneObject(ProvisionGroup clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        clone.setGroupCharacteristicType(this.getGroupCharacteristicType());
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ProvisionCharacteristic.class).getPropertyMap());
        propertyMap.put(GROUPCHARACTERISTICTYPE, PropertyDescriptorSupport.createEnumeration(GROUPCHARACTERISTICTYPE,
                ProvisionGroupCharacteristicType.class, 11, PROPERTY_CONSTRAINTS[0], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProvisionGroup.getPropertyDescriptor(GROUPCHARACTERISTICTYPE),
                this.getGroupCharacteristicType(), null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(GROUPCHARACTERISTICTYPE) && (property.getType() == ProvisionGroupCharacteristicType.class))) {
            this.setGroupCharacteristicType(((ProvisionGroupCharacteristicType) property.getInstance()));
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
        final ProvisionGroup other = ((ProvisionGroup) obj);
        if ((this.groupCharacteristicType == null)) {
            if ((other.groupCharacteristicType != null))
                return false;
        } else if ((!this.groupCharacteristicType.equals(other.groupCharacteristicType)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.groupCharacteristicType == null) ? 0 : this.groupCharacteristicType
                .hashCode()));
        return result;
    }

    @Override
    public ProvisionGroup cloneObject() {
        ProvisionGroup clone = new ProvisionGroup();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getGroupCharacteristicType.
     *
     * @return the ProvisionGroupCharacteristicType.
     */
    public ProvisionGroupCharacteristicType getGroupCharacteristicType() {
        return this.groupCharacteristicType;
    }

    /**
     * Missing description at method setGroupCharacteristicType.
     *
     * @param groupCharacteristicType the ProvisionGroupCharacteristicType.
     */
    public void setGroupCharacteristicType(ProvisionGroupCharacteristicType groupCharacteristicType) {
        this.groupCharacteristicType = groupCharacteristicType;
    }

    /**
     * Missing description at method setGroupCharacteristicType.
     *
     * @param groupCharacteristicType the String.
     */
    public void setGroupCharacteristicType(String groupCharacteristicType) {
        if ((groupCharacteristicType == null)) {
            this.groupCharacteristicType = null;
        } else {
            this.groupCharacteristicType = ProvisionGroupCharacteristicType.valueOf(groupCharacteristicType);
        }
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProvisionGroup.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProvisionGroup.class).getAllProperties();
    }
}
