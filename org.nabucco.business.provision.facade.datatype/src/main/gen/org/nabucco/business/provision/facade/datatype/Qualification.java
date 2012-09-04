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
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * Qualification
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class Qualification extends ProvisionCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final ProvisionCharacteristicType CHARACTERISTICTYPE_DEFAULT = ProvisionCharacteristicType.QUALIFICATION;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;" };

    public static final String QUALIFICATIONTYPE = "qualificationType";

    private Code qualificationType;

    private Long qualificationTypeRefId;

    protected static final String QUALIFICATIONTYPE_CODEPATH = "nabucco.business.provision.qualificationtype";

    /** Constructs a new Qualification instance. */
    public Qualification() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        characteristicType = CHARACTERISTICTYPE_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the Qualification.
     */
    protected void cloneObject(Qualification clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getQualificationType() != null)) {
            clone.setQualificationType(this.getQualificationType().cloneObject());
        }
        if ((this.getQualificationTypeRefId() != null)) {
            clone.setQualificationTypeRefId(this.getQualificationTypeRefId());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ProvisionCharacteristic.class).getPropertyMap());
        propertyMap.put(QUALIFICATIONTYPE, PropertyDescriptorSupport.createDatatype(QUALIFICATIONTYPE, Code.class, 11,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, QUALIFICATIONTYPE_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Qualification.getPropertyDescriptor(QUALIFICATIONTYPE),
                this.getQualificationType(), this.qualificationTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(QUALIFICATIONTYPE) && (property.getType() == Code.class))) {
            this.setQualificationType(((Code) property.getInstance()));
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
        final Qualification other = ((Qualification) obj);
        if ((this.qualificationType == null)) {
            if ((other.qualificationType != null))
                return false;
        } else if ((!this.qualificationType.equals(other.qualificationType)))
            return false;
        if ((this.qualificationTypeRefId == null)) {
            if ((other.qualificationTypeRefId != null))
                return false;
        } else if ((!this.qualificationTypeRefId.equals(other.qualificationTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.qualificationType == null) ? 0 : this.qualificationType.hashCode()));
        result = ((PRIME * result) + ((this.qualificationTypeRefId == null) ? 0 : this.qualificationTypeRefId
                .hashCode()));
        return result;
    }

    @Override
    public Qualification cloneObject() {
        Qualification clone = new Qualification();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setQualificationType.
     *
     * @param qualificationType the Code.
     */
    public void setQualificationType(Code qualificationType) {
        this.qualificationType = qualificationType;
        if ((qualificationType != null)) {
            this.setQualificationTypeRefId(qualificationType.getId());
        } else {
            this.setQualificationTypeRefId(null);
        }
    }

    /**
     * Missing description at method getQualificationType.
     *
     * @return the Code.
     */
    public Code getQualificationType() {
        return this.qualificationType;
    }

    /**
     * Getter for the QualificationTypeRefId.
     *
     * @return the Long.
     */
    public Long getQualificationTypeRefId() {
        return this.qualificationTypeRefId;
    }

    /**
     * Setter for the QualificationTypeRefId.
     *
     * @param qualificationTypeRefId the Long.
     */
    public void setQualificationTypeRefId(Long qualificationTypeRefId) {
        this.qualificationTypeRefId = qualificationTypeRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Qualification.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Qualification.class).getAllProperties();
    }

    /**
     * Getter for the QualificationTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getQualificationTypeCodePath() {
        return new CodePath(QUALIFICATIONTYPE_CODEPATH);
    }
}
