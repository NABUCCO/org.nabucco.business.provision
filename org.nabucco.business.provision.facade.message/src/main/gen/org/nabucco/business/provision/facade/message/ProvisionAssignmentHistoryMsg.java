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
package org.nabucco.business.provision.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.ProvisionAssignmentHistory;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProvisionAssignmentHistoryMsg<p/>Default message for ProvisionAssignmentHistory datatype<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProvisionAssignmentHistoryMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    public static final String PROVISIONASSIGNMENTHISTORY = "provisionAssignmentHistory";

    private ProvisionAssignmentHistory provisionAssignmentHistory;

    /** Constructs a new ProvisionAssignmentHistoryMsg instance. */
    public ProvisionAssignmentHistoryMsg() {
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
        propertyMap.put(PROVISIONASSIGNMENTHISTORY, PropertyDescriptorSupport.createDatatype(
                PROVISIONASSIGNMENTHISTORY, ProvisionAssignmentHistory.class, 0, PROPERTY_CONSTRAINTS[0], false,
                PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                ProvisionAssignmentHistoryMsg.getPropertyDescriptor(PROVISIONASSIGNMENTHISTORY),
                this.getProvisionAssignmentHistory()));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROVISIONASSIGNMENTHISTORY) && (property.getType() == ProvisionAssignmentHistory.class))) {
            this.setProvisionAssignmentHistory(((ProvisionAssignmentHistory) property.getInstance()));
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
        final ProvisionAssignmentHistoryMsg other = ((ProvisionAssignmentHistoryMsg) obj);
        if ((this.provisionAssignmentHistory == null)) {
            if ((other.provisionAssignmentHistory != null))
                return false;
        } else if ((!this.provisionAssignmentHistory.equals(other.provisionAssignmentHistory)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.provisionAssignmentHistory == null) ? 0 : this.provisionAssignmentHistory
                .hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getProvisionAssignmentHistory.
     *
     * @return the ProvisionAssignmentHistory.
     */
    public ProvisionAssignmentHistory getProvisionAssignmentHistory() {
        return this.provisionAssignmentHistory;
    }

    /**
     * Missing description at method setProvisionAssignmentHistory.
     *
     * @param provisionAssignmentHistory the ProvisionAssignmentHistory.
     */
    public void setProvisionAssignmentHistory(ProvisionAssignmentHistory provisionAssignmentHistory) {
        this.provisionAssignmentHistory = provisionAssignmentHistory;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProvisionAssignmentHistoryMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProvisionAssignmentHistoryMsg.class).getAllProperties();
    }
}
