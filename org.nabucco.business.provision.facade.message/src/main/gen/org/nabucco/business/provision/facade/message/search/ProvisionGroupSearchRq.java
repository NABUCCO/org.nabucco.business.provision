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
package org.nabucco.business.provision.facade.message.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.ProvisionGroupCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProvisionGroupSearchRq<p/>Search message for ProvisionGroup<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProvisionGroupSearchRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "m0,1;", "l0,n;u0,n;m0,1;" };

    public static final String ROOT = "root";

    public static final String GROUPCHARACTERISTICTYPE = "groupCharacteristicType";

    public static final String FUNCTIONALID = "functionalId";

    private Flag root;

    private ProvisionGroupCharacteristicType groupCharacteristicType;

    private FunctionalIdentifier functionalId;

    /** Constructs a new ProvisionGroupSearchRq instance. */
    public ProvisionGroupSearchRq() {
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
        propertyMap.put(ROOT,
                PropertyDescriptorSupport.createBasetype(ROOT, Flag.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(GROUPCHARACTERISTICTYPE, PropertyDescriptorSupport.createEnumeration(GROUPCHARACTERISTICTYPE,
                ProvisionGroupCharacteristicType.class, 1, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(FUNCTIONALID, PropertyDescriptorSupport.createBasetype(FUNCTIONALID,
                FunctionalIdentifier.class, 2, PROPERTY_CONSTRAINTS[2], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProvisionGroupSearchRq.getPropertyDescriptor(ROOT), this.root));
        properties.add(super.createProperty(ProvisionGroupSearchRq.getPropertyDescriptor(GROUPCHARACTERISTICTYPE),
                this.getGroupCharacteristicType()));
        properties.add(super.createProperty(ProvisionGroupSearchRq.getPropertyDescriptor(FUNCTIONALID),
                this.functionalId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(ROOT) && (property.getType() == Flag.class))) {
            this.setRoot(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(GROUPCHARACTERISTICTYPE) && (property.getType() == ProvisionGroupCharacteristicType.class))) {
            this.setGroupCharacteristicType(((ProvisionGroupCharacteristicType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FUNCTIONALID) && (property.getType() == FunctionalIdentifier.class))) {
            this.setFunctionalId(((FunctionalIdentifier) property.getInstance()));
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
        final ProvisionGroupSearchRq other = ((ProvisionGroupSearchRq) obj);
        if ((this.root == null)) {
            if ((other.root != null))
                return false;
        } else if ((!this.root.equals(other.root)))
            return false;
        if ((this.groupCharacteristicType == null)) {
            if ((other.groupCharacteristicType != null))
                return false;
        } else if ((!this.groupCharacteristicType.equals(other.groupCharacteristicType)))
            return false;
        if ((this.functionalId == null)) {
            if ((other.functionalId != null))
                return false;
        } else if ((!this.functionalId.equals(other.functionalId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.root == null) ? 0 : this.root.hashCode()));
        result = ((PRIME * result) + ((this.groupCharacteristicType == null) ? 0 : this.groupCharacteristicType
                .hashCode()));
        result = ((PRIME * result) + ((this.functionalId == null) ? 0 : this.functionalId.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getRoot.
     *
     * @return the Flag.
     */
    public Flag getRoot() {
        return this.root;
    }

    /**
     * Missing description at method setRoot.
     *
     * @param root the Flag.
     */
    public void setRoot(Flag root) {
        this.root = root;
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
     * Missing description at method getFunctionalId.
     *
     * @return the FunctionalIdentifier.
     */
    public FunctionalIdentifier getFunctionalId() {
        return this.functionalId;
    }

    /**
     * Missing description at method setFunctionalId.
     *
     * @param functionalId the FunctionalIdentifier.
     */
    public void setFunctionalId(FunctionalIdentifier functionalId) {
        this.functionalId = functionalId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProvisionGroupSearchRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProvisionGroupSearchRq.class).getAllProperties();
    }
}
