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
 * SchoolEducation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-11
 */
public class SchoolEducation extends Education implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final EducationType EDUCATIONTYPE_DEFAULT = EducationType.SCHOOL;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;" };

    public static final String SCHOOLFORM = "schoolForm";

    public static final String SCHOOLGRADUATION = "schoolGraduation";

    private Code schoolForm;

    private Long schoolFormRefId;

    protected static final String SCHOOLFORM_CODEPATH = "nabucco.business.provision.schooleducation.schoolform";

    private Code schoolGraduation;

    private Long schoolGraduationRefId;

    protected static final String SCHOOLGRADUATION_CODEPATH = "nabucco.business.provision.education.schoolgraduation";

    /** Constructs a new SchoolEducation instance. */
    public SchoolEducation() {
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
     * @param clone the SchoolEducation.
     */
    protected void cloneObject(SchoolEducation clone) {
        super.cloneObject(clone);
        clone.setEducationType(this.getEducationType());
        if ((this.getSchoolForm() != null)) {
            clone.setSchoolForm(this.getSchoolForm().cloneObject());
        }
        if ((this.getSchoolFormRefId() != null)) {
            clone.setSchoolFormRefId(this.getSchoolFormRefId());
        }
        if ((this.getSchoolGraduation() != null)) {
            clone.setSchoolGraduation(this.getSchoolGraduation().cloneObject());
        }
        if ((this.getSchoolGraduationRefId() != null)) {
            clone.setSchoolGraduationRefId(this.getSchoolGraduationRefId());
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
        propertyMap.put(SCHOOLFORM, PropertyDescriptorSupport.createDatatype(SCHOOLFORM, Code.class, 16,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, SCHOOLFORM_CODEPATH));
        propertyMap.put(SCHOOLGRADUATION, PropertyDescriptorSupport.createDatatype(SCHOOLGRADUATION, Code.class, 17,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT, SCHOOLGRADUATION_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(SchoolEducation.getPropertyDescriptor(SCHOOLFORM), this.getSchoolForm(),
                this.schoolFormRefId));
        properties.add(super.createProperty(SchoolEducation.getPropertyDescriptor(SCHOOLGRADUATION),
                this.getSchoolGraduation(), this.schoolGraduationRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SCHOOLFORM) && (property.getType() == Code.class))) {
            this.setSchoolForm(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SCHOOLGRADUATION) && (property.getType() == Code.class))) {
            this.setSchoolGraduation(((Code) property.getInstance()));
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
        final SchoolEducation other = ((SchoolEducation) obj);
        if ((this.schoolForm == null)) {
            if ((other.schoolForm != null))
                return false;
        } else if ((!this.schoolForm.equals(other.schoolForm)))
            return false;
        if ((this.schoolFormRefId == null)) {
            if ((other.schoolFormRefId != null))
                return false;
        } else if ((!this.schoolFormRefId.equals(other.schoolFormRefId)))
            return false;
        if ((this.schoolGraduation == null)) {
            if ((other.schoolGraduation != null))
                return false;
        } else if ((!this.schoolGraduation.equals(other.schoolGraduation)))
            return false;
        if ((this.schoolGraduationRefId == null)) {
            if ((other.schoolGraduationRefId != null))
                return false;
        } else if ((!this.schoolGraduationRefId.equals(other.schoolGraduationRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.schoolForm == null) ? 0 : this.schoolForm.hashCode()));
        result = ((PRIME * result) + ((this.schoolFormRefId == null) ? 0 : this.schoolFormRefId.hashCode()));
        result = ((PRIME * result) + ((this.schoolGraduation == null) ? 0 : this.schoolGraduation.hashCode()));
        result = ((PRIME * result) + ((this.schoolGraduationRefId == null) ? 0 : this.schoolGraduationRefId.hashCode()));
        return result;
    }

    @Override
    public SchoolEducation cloneObject() {
        SchoolEducation clone = new SchoolEducation();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setSchoolForm.
     *
     * @param schoolForm the Code.
     */
    public void setSchoolForm(Code schoolForm) {
        this.schoolForm = schoolForm;
        if ((schoolForm != null)) {
            this.setSchoolFormRefId(schoolForm.getId());
        } else {
            this.setSchoolFormRefId(null);
        }
    }

    /**
     * Missing description at method getSchoolForm.
     *
     * @return the Code.
     */
    public Code getSchoolForm() {
        return this.schoolForm;
    }

    /**
     * Getter for the SchoolFormRefId.
     *
     * @return the Long.
     */
    public Long getSchoolFormRefId() {
        return this.schoolFormRefId;
    }

    /**
     * Setter for the SchoolFormRefId.
     *
     * @param schoolFormRefId the Long.
     */
    public void setSchoolFormRefId(Long schoolFormRefId) {
        this.schoolFormRefId = schoolFormRefId;
    }

    /**
     * Missing description at method setSchoolGraduation.
     *
     * @param schoolGraduation the Code.
     */
    public void setSchoolGraduation(Code schoolGraduation) {
        this.schoolGraduation = schoolGraduation;
        if ((schoolGraduation != null)) {
            this.setSchoolGraduationRefId(schoolGraduation.getId());
        } else {
            this.setSchoolGraduationRefId(null);
        }
    }

    /**
     * Missing description at method getSchoolGraduation.
     *
     * @return the Code.
     */
    public Code getSchoolGraduation() {
        return this.schoolGraduation;
    }

    /**
     * Getter for the SchoolGraduationRefId.
     *
     * @return the Long.
     */
    public Long getSchoolGraduationRefId() {
        return this.schoolGraduationRefId;
    }

    /**
     * Setter for the SchoolGraduationRefId.
     *
     * @param schoolGraduationRefId the Long.
     */
    public void setSchoolGraduationRefId(Long schoolGraduationRefId) {
        this.schoolGraduationRefId = schoolGraduationRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(SchoolEducation.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(SchoolEducation.class).getAllProperties();
    }

    /**
     * Getter for the SchoolFormCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getSchoolFormCodePath() {
        return new CodePath(SCHOOLFORM_CODEPATH);
    }

    /**
     * Getter for the SchoolGraduationCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getSchoolGraduationCodePath() {
        return new CodePath(SCHOOLGRADUATION_CODEPATH);
    }
}
