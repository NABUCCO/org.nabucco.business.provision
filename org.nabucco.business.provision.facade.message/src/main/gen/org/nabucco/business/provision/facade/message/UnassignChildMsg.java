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
package org.nabucco.business.provision.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionGroup;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * UnassignChildMsg<p/>Message for unassigning a ProvisionCharacteristic from a group.<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-04-18
 */
public class UnassignChildMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;" };

    public static final String PARENTGROUP = "parentGroup";

    public static final String CHILD = "child";

    private ProvisionGroup parentGroup;

    private ProvisionCharacteristic child;

    /** Constructs a new UnassignChildMsg instance. */
    public UnassignChildMsg() {
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
        propertyMap.put(PARENTGROUP, PropertyDescriptorSupport.createDatatype(PARENTGROUP, ProvisionGroup.class, 0,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(CHILD, PropertyDescriptorSupport.createDatatype(CHILD, ProvisionCharacteristic.class, 1,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties
                .add(super.createProperty(UnassignChildMsg.getPropertyDescriptor(PARENTGROUP), this.getParentGroup()));
        properties.add(super.createProperty(UnassignChildMsg.getPropertyDescriptor(CHILD), this.getChild()));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PARENTGROUP) && (property.getType() == ProvisionGroup.class))) {
            this.setParentGroup(((ProvisionGroup) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CHILD) && (property.getType() == ProvisionCharacteristic.class))) {
            this.setChild(((ProvisionCharacteristic) property.getInstance()));
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
        final UnassignChildMsg other = ((UnassignChildMsg) obj);
        if ((this.parentGroup == null)) {
            if ((other.parentGroup != null))
                return false;
        } else if ((!this.parentGroup.equals(other.parentGroup)))
            return false;
        if ((this.child == null)) {
            if ((other.child != null))
                return false;
        } else if ((!this.child.equals(other.child)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.parentGroup == null) ? 0 : this.parentGroup.hashCode()));
        result = ((PRIME * result) + ((this.child == null) ? 0 : this.child.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getParentGroup.
     *
     * @return the ProvisionGroup.
     */
    public ProvisionGroup getParentGroup() {
        return this.parentGroup;
    }

    /**
     * Missing description at method setParentGroup.
     *
     * @param parentGroup the ProvisionGroup.
     */
    public void setParentGroup(ProvisionGroup parentGroup) {
        this.parentGroup = parentGroup;
    }

    /**
     * Missing description at method getChild.
     *
     * @return the ProvisionCharacteristic.
     */
    public ProvisionCharacteristic getChild() {
        return this.child;
    }

    /**
     * Missing description at method setChild.
     *
     * @param child the ProvisionCharacteristic.
     */
    public void setChild(ProvisionCharacteristic child) {
        this.child = child;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(UnassignChildMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(UnassignChildMsg.class).getAllProperties();
    }
}
