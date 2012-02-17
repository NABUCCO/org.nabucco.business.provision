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
package org.nabucco.business.provision.facade.message.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.Identifier;
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
 * ProvisionMatchRq<p/>Provision match request message<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-06-28
 */
public class ProvisionMatchRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m1,n;", "l0,n;u0,n;m0,n;",
            "l0,n;u0,n;m0,n;" };

    public static final String SOURCEID = "sourceId";

    public static final String TARGETIDLIST = "targetIdList";

    public static final String PROVISIONIDLIST = "provisionIdList";

    public static final String PROVISIONGROUPFUNCTIONALIDLIST = "provisionGroupFunctionalIdList";

    /** if null than no search for necessary provisions is done, the lists must be filled */
    private Identifier sourceId;

    private NabuccoList<Identifier> targetIdList;

    /** if this list is filled, no search is done - then sourceId may be null */
    private NabuccoList<Identifier> provisionIdList;

    /** if this list is filled, no search is done - then sourceId may be null */
    private NabuccoList<FunctionalIdentifier> provisionGroupFunctionalIdList;

    /** Constructs a new ProvisionMatchRq instance. */
    public ProvisionMatchRq() {
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
        propertyMap
                .put(SOURCEID, PropertyDescriptorSupport.createBasetype(SOURCEID, Identifier.class, 0,
                        PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(TARGETIDLIST, PropertyDescriptorSupport.createCollection(TARGETIDLIST, Identifier.class, 1,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(PROVISIONIDLIST, PropertyDescriptorSupport.createCollection(PROVISIONIDLIST, Identifier.class,
                2, PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(PROVISIONGROUPFUNCTIONALIDLIST, PropertyDescriptorSupport.createCollection(
                PROVISIONGROUPFUNCTIONALIDLIST, FunctionalIdentifier.class, 3, PROPERTY_CONSTRAINTS[3], false,
                PropertyAssociationType.COMPONENT));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProvisionMatchRq.getPropertyDescriptor(SOURCEID), this.sourceId));
        properties.add(super.createProperty(ProvisionMatchRq.getPropertyDescriptor(TARGETIDLIST), this.targetIdList));
        properties.add(super.createProperty(ProvisionMatchRq.getPropertyDescriptor(PROVISIONIDLIST),
                this.provisionIdList));
        properties.add(super.createProperty(ProvisionMatchRq.getPropertyDescriptor(PROVISIONGROUPFUNCTIONALIDLIST),
                this.provisionGroupFunctionalIdList));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SOURCEID) && (property.getType() == Identifier.class))) {
            this.setSourceId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TARGETIDLIST) && (property.getType() == Identifier.class))) {
            this.targetIdList = ((NabuccoList<Identifier>) property.getInstance());
            return true;
        } else if ((property.getName().equals(PROVISIONIDLIST) && (property.getType() == Identifier.class))) {
            this.provisionIdList = ((NabuccoList<Identifier>) property.getInstance());
            return true;
        } else if ((property.getName().equals(PROVISIONGROUPFUNCTIONALIDLIST) && (property.getType() == FunctionalIdentifier.class))) {
            this.provisionGroupFunctionalIdList = ((NabuccoList<FunctionalIdentifier>) property.getInstance());
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
        final ProvisionMatchRq other = ((ProvisionMatchRq) obj);
        if ((this.sourceId == null)) {
            if ((other.sourceId != null))
                return false;
        } else if ((!this.sourceId.equals(other.sourceId)))
            return false;
        if ((this.targetIdList == null)) {
            if ((other.targetIdList != null))
                return false;
        } else if ((!this.targetIdList.equals(other.targetIdList)))
            return false;
        if ((this.provisionIdList == null)) {
            if ((other.provisionIdList != null))
                return false;
        } else if ((!this.provisionIdList.equals(other.provisionIdList)))
            return false;
        if ((this.provisionGroupFunctionalIdList == null)) {
            if ((other.provisionGroupFunctionalIdList != null))
                return false;
        } else if ((!this.provisionGroupFunctionalIdList.equals(other.provisionGroupFunctionalIdList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.sourceId == null) ? 0 : this.sourceId.hashCode()));
        result = ((PRIME * result) + ((this.targetIdList == null) ? 0 : this.targetIdList.hashCode()));
        result = ((PRIME * result) + ((this.provisionIdList == null) ? 0 : this.provisionIdList.hashCode()));
        result = ((PRIME * result) + ((this.provisionGroupFunctionalIdList == null) ? 0
                : this.provisionGroupFunctionalIdList.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * if null than no search for necessary provisions is done, the lists must be filled
     *
     * @return the Identifier.
     */
    public Identifier getSourceId() {
        return this.sourceId;
    }

    /**
     * if null than no search for necessary provisions is done, the lists must be filled
     *
     * @param sourceId the Identifier.
     */
    public void setSourceId(Identifier sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * Missing description at method getTargetIdList.
     *
     * @return the NabuccoList<Identifier>.
     */
    public NabuccoList<Identifier> getTargetIdList() {
        if ((this.targetIdList == null)) {
            this.targetIdList = new NabuccoListImpl<Identifier>(NabuccoCollectionState.INITIALIZED);
        }
        return this.targetIdList;
    }

    /**
     * if this list is filled, no search is done - then sourceId may be null
     *
     * @return the NabuccoList<Identifier>.
     */
    public NabuccoList<Identifier> getProvisionIdList() {
        if ((this.provisionIdList == null)) {
            this.provisionIdList = new NabuccoListImpl<Identifier>(NabuccoCollectionState.INITIALIZED);
        }
        return this.provisionIdList;
    }

    /**
     * if this list is filled, no search is done - then sourceId may be null
     *
     * @return the NabuccoList<FunctionalIdentifier>.
     */
    public NabuccoList<FunctionalIdentifier> getProvisionGroupFunctionalIdList() {
        if ((this.provisionGroupFunctionalIdList == null)) {
            this.provisionGroupFunctionalIdList = new NabuccoListImpl<FunctionalIdentifier>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.provisionGroupFunctionalIdList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProvisionMatchRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProvisionMatchRq.class).getAllProperties();
    }
}
