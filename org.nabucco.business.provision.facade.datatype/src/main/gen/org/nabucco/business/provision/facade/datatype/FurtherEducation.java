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
import org.nabucco.business.provision.facade.datatype.Education;
import org.nabucco.business.provision.facade.datatype.EducationType;
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
 * FurtherEducation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-11
 */
public class FurtherEducation extends Education implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final EducationType EDUCATIONTYPE_DEFAULT = EducationType.FURTHER;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;" };

    public static final String FURTHERGRADUATION = "furtherGraduation";

    private Code furtherGraduation;

    private Long furtherGraduationRefId;

    protected static final String FURTHERGRADUATION_CODEPATH = "nabucco.business.provision.education.furthergraduation";

    /** Constructs a new FurtherEducation instance. */
    public FurtherEducation() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        educationType = EDUCATIONTYPE_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the FurtherEducation.
     */
    protected void cloneObject(FurtherEducation clone) {
        super.cloneObject(clone);
        clone.setEducationType(this.getEducationType());
        if ((this.getFurtherGraduation() != null)) {
            clone.setFurtherGraduation(this.getFurtherGraduation().cloneObject());
        }
        if ((this.getFurtherGraduationRefId() != null)) {
            clone.setFurtherGraduationRefId(this.getFurtherGraduationRefId());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(Education.class).getPropertyMap());
        propertyMap.put(FURTHERGRADUATION, PropertyDescriptorSupport.createDatatype(FURTHERGRADUATION, Code.class, 16,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, FURTHERGRADUATION_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(FurtherEducation.getPropertyDescriptor(FURTHERGRADUATION),
                this.getFurtherGraduation(), this.furtherGraduationRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(FURTHERGRADUATION) && (property.getType() == Code.class))) {
            this.setFurtherGraduation(((Code) property.getInstance()));
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
        final FurtherEducation other = ((FurtherEducation) obj);
        if ((this.furtherGraduation == null)) {
            if ((other.furtherGraduation != null))
                return false;
        } else if ((!this.furtherGraduation.equals(other.furtherGraduation)))
            return false;
        if ((this.furtherGraduationRefId == null)) {
            if ((other.furtherGraduationRefId != null))
                return false;
        } else if ((!this.furtherGraduationRefId.equals(other.furtherGraduationRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.furtherGraduation == null) ? 0 : this.furtherGraduation.hashCode()));
        result = ((PRIME * result) + ((this.furtherGraduationRefId == null) ? 0 : this.furtherGraduationRefId
                .hashCode()));
        return result;
    }

    @Override
    public FurtherEducation cloneObject() {
        FurtherEducation clone = new FurtherEducation();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setFurtherGraduation.
     *
     * @param furtherGraduation the Code.
     */
    public void setFurtherGraduation(Code furtherGraduation) {
        this.furtherGraduation = furtherGraduation;
        if ((furtherGraduation != null)) {
            this.setFurtherGraduationRefId(furtherGraduation.getId());
        } else {
            this.setFurtherGraduationRefId(null);
        }
    }

    /**
     * Missing description at method getFurtherGraduation.
     *
     * @return the Code.
     */
    public Code getFurtherGraduation() {
        return this.furtherGraduation;
    }

    /**
     * Getter for the FurtherGraduationRefId.
     *
     * @return the Long.
     */
    public Long getFurtherGraduationRefId() {
        return this.furtherGraduationRefId;
    }

    /**
     * Setter for the FurtherGraduationRefId.
     *
     * @param furtherGraduationRefId the Long.
     */
    public void setFurtherGraduationRefId(Long furtherGraduationRefId) {
        this.furtherGraduationRefId = furtherGraduationRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(FurtherEducation.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(FurtherEducation.class).getAllProperties();
    }

    /**
     * Getter for the FurtherGraduationCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getFurtherGraduationCodePath() {
        return new CodePath(FURTHERGRADUATION_CODEPATH);
    }
}
