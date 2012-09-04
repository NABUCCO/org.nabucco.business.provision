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
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ActivityArea
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-11
 */
public class ActivityArea extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    public static final String ACTIVITYAREA = "activityArea";

    private Code activityArea;

    private Long activityAreaRefId;

    protected static final String ACTIVITYAREA_CODEPATH = "nabucco.business.provision.activityarea";

    /** Constructs a new ActivityArea instance. */
    public ActivityArea() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ActivityArea.
     */
    protected void cloneObject(ActivityArea clone) {
        super.cloneObject(clone);
        if ((this.getActivityArea() != null)) {
            clone.setActivityArea(this.getActivityArea().cloneObject());
        }
        if ((this.getActivityAreaRefId() != null)) {
            clone.setActivityAreaRefId(this.getActivityAreaRefId());
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
        propertyMap.put(ACTIVITYAREA, PropertyDescriptorSupport.createDatatype(ACTIVITYAREA, Code.class, 3,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, ACTIVITYAREA_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ActivityArea.getPropertyDescriptor(ACTIVITYAREA), this.getActivityArea(),
                this.activityAreaRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(ACTIVITYAREA) && (property.getType() == Code.class))) {
            this.setActivityArea(((Code) property.getInstance()));
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
        final ActivityArea other = ((ActivityArea) obj);
        if ((this.activityArea == null)) {
            if ((other.activityArea != null))
                return false;
        } else if ((!this.activityArea.equals(other.activityArea)))
            return false;
        if ((this.activityAreaRefId == null)) {
            if ((other.activityAreaRefId != null))
                return false;
        } else if ((!this.activityAreaRefId.equals(other.activityAreaRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.activityArea == null) ? 0 : this.activityArea.hashCode()));
        result = ((PRIME * result) + ((this.activityAreaRefId == null) ? 0 : this.activityAreaRefId.hashCode()));
        return result;
    }

    @Override
    public ActivityArea cloneObject() {
        ActivityArea clone = new ActivityArea();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setActivityArea.
     *
     * @param activityArea the Code.
     */
    public void setActivityArea(Code activityArea) {
        this.activityArea = activityArea;
        if ((activityArea != null)) {
            this.setActivityAreaRefId(activityArea.getId());
        } else {
            this.setActivityAreaRefId(null);
        }
    }

    /**
     * Missing description at method getActivityArea.
     *
     * @return the Code.
     */
    public Code getActivityArea() {
        return this.activityArea;
    }

    /**
     * Getter for the ActivityAreaRefId.
     *
     * @return the Long.
     */
    public Long getActivityAreaRefId() {
        return this.activityAreaRefId;
    }

    /**
     * Setter for the ActivityAreaRefId.
     *
     * @param activityAreaRefId the Long.
     */
    public void setActivityAreaRefId(Long activityAreaRefId) {
        this.activityAreaRefId = activityAreaRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ActivityArea.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ActivityArea.class).getAllProperties();
    }

    /**
     * Getter for the ActivityAreaCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getActivityAreaCodePath() {
        return new CodePath(ACTIVITYAREA_CODEPATH);
    }
}
