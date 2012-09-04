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
package org.nabucco.business.provision.facade.message.produce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.ProvisionUsageType;
import org.nabucco.business.provision.facade.datatype.RequirementType;
import org.nabucco.framework.base.facade.datatype.Number;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProvisionAssignmentProduceRq<p/>Default message for ProvisionAssignment datatype<p/>
 *
 * @version 1.0
 * @author Raffael Bieniek, PRODYNA AG, 2011-03-11
 */
public class ProvisionAssignmentProduceRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m1,1;", "m0,1;", "m1,1;" };

    public static final String AMOUNT = "amount";

    public static final String REQUIREMENTTYPE = "requirementType";

    public static final String USAGETYPE = "usageType";

    /** The number of provision assignments to produce */
    private Number amount;

    /** The type of provision assignment requirement */
    private RequirementType requirementType;

    /** The usage type of the provision assignment */
    private ProvisionUsageType usageType;

    /** Constructs a new ProvisionAssignmentProduceRq instance. */
    public ProvisionAssignmentProduceRq() {
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
        propertyMap.put(AMOUNT,
                PropertyDescriptorSupport.createBasetype(AMOUNT, Number.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(REQUIREMENTTYPE, PropertyDescriptorSupport.createEnumeration(REQUIREMENTTYPE,
                RequirementType.class, 1, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(USAGETYPE, PropertyDescriptorSupport.createEnumeration(USAGETYPE, ProvisionUsageType.class, 2,
                PROPERTY_CONSTRAINTS[2], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProvisionAssignmentProduceRq.getPropertyDescriptor(AMOUNT), this.amount));
        properties.add(super.createProperty(ProvisionAssignmentProduceRq.getPropertyDescriptor(REQUIREMENTTYPE),
                this.getRequirementType()));
        properties.add(super.createProperty(ProvisionAssignmentProduceRq.getPropertyDescriptor(USAGETYPE),
                this.getUsageType()));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(AMOUNT) && (property.getType() == Number.class))) {
            this.setAmount(((Number) property.getInstance()));
            return true;
        } else if ((property.getName().equals(REQUIREMENTTYPE) && (property.getType() == RequirementType.class))) {
            this.setRequirementType(((RequirementType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(USAGETYPE) && (property.getType() == ProvisionUsageType.class))) {
            this.setUsageType(((ProvisionUsageType) property.getInstance()));
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
        final ProvisionAssignmentProduceRq other = ((ProvisionAssignmentProduceRq) obj);
        if ((this.amount == null)) {
            if ((other.amount != null))
                return false;
        } else if ((!this.amount.equals(other.amount)))
            return false;
        if ((this.requirementType == null)) {
            if ((other.requirementType != null))
                return false;
        } else if ((!this.requirementType.equals(other.requirementType)))
            return false;
        if ((this.usageType == null)) {
            if ((other.usageType != null))
                return false;
        } else if ((!this.usageType.equals(other.usageType)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.amount == null) ? 0 : this.amount.hashCode()));
        result = ((PRIME * result) + ((this.requirementType == null) ? 0 : this.requirementType.hashCode()));
        result = ((PRIME * result) + ((this.usageType == null) ? 0 : this.usageType.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * The number of provision assignments to produce
     *
     * @return the Number.
     */
    public Number getAmount() {
        return this.amount;
    }

    /**
     * The number of provision assignments to produce
     *
     * @param amount the Number.
     */
    public void setAmount(Number amount) {
        this.amount = amount;
    }

    /**
     * The type of provision assignment requirement
     *
     * @return the RequirementType.
     */
    public RequirementType getRequirementType() {
        return this.requirementType;
    }

    /**
     * The type of provision assignment requirement
     *
     * @param requirementType the RequirementType.
     */
    public void setRequirementType(RequirementType requirementType) {
        this.requirementType = requirementType;
    }

    /**
     * The usage type of the provision assignment
     *
     * @return the ProvisionUsageType.
     */
    public ProvisionUsageType getUsageType() {
        return this.usageType;
    }

    /**
     * The usage type of the provision assignment
     *
     * @param usageType the ProvisionUsageType.
     */
    public void setUsageType(ProvisionUsageType usageType) {
        this.usageType = usageType;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProvisionAssignmentProduceRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProvisionAssignmentProduceRq.class).getAllProperties();
    }
}
