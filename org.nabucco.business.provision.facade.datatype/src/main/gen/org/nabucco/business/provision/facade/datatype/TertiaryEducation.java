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
 * TertiaryEducation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-11
 */
public class TertiaryEducation extends Education implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final EducationType EDUCATIONTYPE_DEFAULT = EducationType.TERITARY;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;", "m0,1;", "m0,1;", "m0,1;", "m0,1;" };

    public static final String CATEGORY = "category";

    public static final String TERTIARYFORM = "tertiaryForm";

    public static final String FIELDOFSTUDY = "fieldOfStudy";

    public static final String FOCUS = "focus";

    public static final String TERTIARYGRADUATION = "tertiaryGraduation";

    private Code category;

    private Long categoryRefId;

    protected static final String CATEGORY_CODEPATH = "nabucco.business.provision.tertiaryeducation.category";

    private Code tertiaryForm;

    private Long tertiaryFormRefId;

    protected static final String TERTIARYFORM_CODEPATH = "nabucco.business.provision.tertiaryeducation.tertiaryform";

    private Code fieldOfStudy;

    private Long fieldOfStudyRefId;

    protected static final String FIELDOFSTUDY_CODEPATH = "nabucco.business.provision.tertiaryeducation.fieldofstudy";

    private Code focus;

    private Long focusRefId;

    protected static final String FOCUS_CODEPATH = "nabucco.business.provision.tertiaryeducation.focus";

    private Code tertiaryGraduation;

    private Long tertiaryGraduationRefId;

    protected static final String TERTIARYGRADUATION_CODEPATH = "nabucco.business.provision.education.tertiarygraduation";

    /** Constructs a new TertiaryEducation instance. */
    public TertiaryEducation() {
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
     * @param clone the TertiaryEducation.
     */
    protected void cloneObject(TertiaryEducation clone) {
        super.cloneObject(clone);
        clone.setEducationType(this.getEducationType());
        if ((this.getCategory() != null)) {
            clone.setCategory(this.getCategory().cloneObject());
        }
        if ((this.getCategoryRefId() != null)) {
            clone.setCategoryRefId(this.getCategoryRefId());
        }
        if ((this.getTertiaryForm() != null)) {
            clone.setTertiaryForm(this.getTertiaryForm().cloneObject());
        }
        if ((this.getTertiaryFormRefId() != null)) {
            clone.setTertiaryFormRefId(this.getTertiaryFormRefId());
        }
        if ((this.getFieldOfStudy() != null)) {
            clone.setFieldOfStudy(this.getFieldOfStudy().cloneObject());
        }
        if ((this.getFieldOfStudyRefId() != null)) {
            clone.setFieldOfStudyRefId(this.getFieldOfStudyRefId());
        }
        if ((this.getFocus() != null)) {
            clone.setFocus(this.getFocus().cloneObject());
        }
        if ((this.getFocusRefId() != null)) {
            clone.setFocusRefId(this.getFocusRefId());
        }
        if ((this.getTertiaryGraduation() != null)) {
            clone.setTertiaryGraduation(this.getTertiaryGraduation().cloneObject());
        }
        if ((this.getTertiaryGraduationRefId() != null)) {
            clone.setTertiaryGraduationRefId(this.getTertiaryGraduationRefId());
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
        propertyMap.put(CATEGORY, PropertyDescriptorSupport.createDatatype(CATEGORY, Code.class, 16,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, CATEGORY_CODEPATH));
        propertyMap.put(TERTIARYFORM, PropertyDescriptorSupport.createDatatype(TERTIARYFORM, Code.class, 17,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT, TERTIARYFORM_CODEPATH));
        propertyMap.put(FIELDOFSTUDY, PropertyDescriptorSupport.createDatatype(FIELDOFSTUDY, Code.class, 18,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT, FIELDOFSTUDY_CODEPATH));
        propertyMap.put(FOCUS, PropertyDescriptorSupport.createDatatype(FOCUS, Code.class, 19, PROPERTY_CONSTRAINTS[3],
                false, PropertyAssociationType.COMPONENT, FOCUS_CODEPATH));
        propertyMap.put(TERTIARYGRADUATION, PropertyDescriptorSupport.createDatatype(TERTIARYGRADUATION, Code.class,
                20, PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPONENT, TERTIARYGRADUATION_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(TertiaryEducation.getPropertyDescriptor(CATEGORY), this.getCategory(),
                this.categoryRefId));
        properties.add(super.createProperty(TertiaryEducation.getPropertyDescriptor(TERTIARYFORM),
                this.getTertiaryForm(), this.tertiaryFormRefId));
        properties.add(super.createProperty(TertiaryEducation.getPropertyDescriptor(FIELDOFSTUDY),
                this.getFieldOfStudy(), this.fieldOfStudyRefId));
        properties.add(super.createProperty(TertiaryEducation.getPropertyDescriptor(FOCUS), this.getFocus(),
                this.focusRefId));
        properties.add(super.createProperty(TertiaryEducation.getPropertyDescriptor(TERTIARYGRADUATION),
                this.getTertiaryGraduation(), this.tertiaryGraduationRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CATEGORY) && (property.getType() == Code.class))) {
            this.setCategory(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TERTIARYFORM) && (property.getType() == Code.class))) {
            this.setTertiaryForm(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FIELDOFSTUDY) && (property.getType() == Code.class))) {
            this.setFieldOfStudy(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(FOCUS) && (property.getType() == Code.class))) {
            this.setFocus(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TERTIARYGRADUATION) && (property.getType() == Code.class))) {
            this.setTertiaryGraduation(((Code) property.getInstance()));
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
        final TertiaryEducation other = ((TertiaryEducation) obj);
        if ((this.category == null)) {
            if ((other.category != null))
                return false;
        } else if ((!this.category.equals(other.category)))
            return false;
        if ((this.categoryRefId == null)) {
            if ((other.categoryRefId != null))
                return false;
        } else if ((!this.categoryRefId.equals(other.categoryRefId)))
            return false;
        if ((this.tertiaryForm == null)) {
            if ((other.tertiaryForm != null))
                return false;
        } else if ((!this.tertiaryForm.equals(other.tertiaryForm)))
            return false;
        if ((this.tertiaryFormRefId == null)) {
            if ((other.tertiaryFormRefId != null))
                return false;
        } else if ((!this.tertiaryFormRefId.equals(other.tertiaryFormRefId)))
            return false;
        if ((this.fieldOfStudy == null)) {
            if ((other.fieldOfStudy != null))
                return false;
        } else if ((!this.fieldOfStudy.equals(other.fieldOfStudy)))
            return false;
        if ((this.fieldOfStudyRefId == null)) {
            if ((other.fieldOfStudyRefId != null))
                return false;
        } else if ((!this.fieldOfStudyRefId.equals(other.fieldOfStudyRefId)))
            return false;
        if ((this.focus == null)) {
            if ((other.focus != null))
                return false;
        } else if ((!this.focus.equals(other.focus)))
            return false;
        if ((this.focusRefId == null)) {
            if ((other.focusRefId != null))
                return false;
        } else if ((!this.focusRefId.equals(other.focusRefId)))
            return false;
        if ((this.tertiaryGraduation == null)) {
            if ((other.tertiaryGraduation != null))
                return false;
        } else if ((!this.tertiaryGraduation.equals(other.tertiaryGraduation)))
            return false;
        if ((this.tertiaryGraduationRefId == null)) {
            if ((other.tertiaryGraduationRefId != null))
                return false;
        } else if ((!this.tertiaryGraduationRefId.equals(other.tertiaryGraduationRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.category == null) ? 0 : this.category.hashCode()));
        result = ((PRIME * result) + ((this.categoryRefId == null) ? 0 : this.categoryRefId.hashCode()));
        result = ((PRIME * result) + ((this.tertiaryForm == null) ? 0 : this.tertiaryForm.hashCode()));
        result = ((PRIME * result) + ((this.tertiaryFormRefId == null) ? 0 : this.tertiaryFormRefId.hashCode()));
        result = ((PRIME * result) + ((this.fieldOfStudy == null) ? 0 : this.fieldOfStudy.hashCode()));
        result = ((PRIME * result) + ((this.fieldOfStudyRefId == null) ? 0 : this.fieldOfStudyRefId.hashCode()));
        result = ((PRIME * result) + ((this.focus == null) ? 0 : this.focus.hashCode()));
        result = ((PRIME * result) + ((this.focusRefId == null) ? 0 : this.focusRefId.hashCode()));
        result = ((PRIME * result) + ((this.tertiaryGraduation == null) ? 0 : this.tertiaryGraduation.hashCode()));
        result = ((PRIME * result) + ((this.tertiaryGraduationRefId == null) ? 0 : this.tertiaryGraduationRefId
                .hashCode()));
        return result;
    }

    @Override
    public TertiaryEducation cloneObject() {
        TertiaryEducation clone = new TertiaryEducation();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setCategory.
     *
     * @param category the Code.
     */
    public void setCategory(Code category) {
        this.category = category;
        if ((category != null)) {
            this.setCategoryRefId(category.getId());
        } else {
            this.setCategoryRefId(null);
        }
    }

    /**
     * Missing description at method getCategory.
     *
     * @return the Code.
     */
    public Code getCategory() {
        return this.category;
    }

    /**
     * Getter for the CategoryRefId.
     *
     * @return the Long.
     */
    public Long getCategoryRefId() {
        return this.categoryRefId;
    }

    /**
     * Setter for the CategoryRefId.
     *
     * @param categoryRefId the Long.
     */
    public void setCategoryRefId(Long categoryRefId) {
        this.categoryRefId = categoryRefId;
    }

    /**
     * Missing description at method setTertiaryForm.
     *
     * @param tertiaryForm the Code.
     */
    public void setTertiaryForm(Code tertiaryForm) {
        this.tertiaryForm = tertiaryForm;
        if ((tertiaryForm != null)) {
            this.setTertiaryFormRefId(tertiaryForm.getId());
        } else {
            this.setTertiaryFormRefId(null);
        }
    }

    /**
     * Missing description at method getTertiaryForm.
     *
     * @return the Code.
     */
    public Code getTertiaryForm() {
        return this.tertiaryForm;
    }

    /**
     * Getter for the TertiaryFormRefId.
     *
     * @return the Long.
     */
    public Long getTertiaryFormRefId() {
        return this.tertiaryFormRefId;
    }

    /**
     * Setter for the TertiaryFormRefId.
     *
     * @param tertiaryFormRefId the Long.
     */
    public void setTertiaryFormRefId(Long tertiaryFormRefId) {
        this.tertiaryFormRefId = tertiaryFormRefId;
    }

    /**
     * Missing description at method setFieldOfStudy.
     *
     * @param fieldOfStudy the Code.
     */
    public void setFieldOfStudy(Code fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
        if ((fieldOfStudy != null)) {
            this.setFieldOfStudyRefId(fieldOfStudy.getId());
        } else {
            this.setFieldOfStudyRefId(null);
        }
    }

    /**
     * Missing description at method getFieldOfStudy.
     *
     * @return the Code.
     */
    public Code getFieldOfStudy() {
        return this.fieldOfStudy;
    }

    /**
     * Getter for the FieldOfStudyRefId.
     *
     * @return the Long.
     */
    public Long getFieldOfStudyRefId() {
        return this.fieldOfStudyRefId;
    }

    /**
     * Setter for the FieldOfStudyRefId.
     *
     * @param fieldOfStudyRefId the Long.
     */
    public void setFieldOfStudyRefId(Long fieldOfStudyRefId) {
        this.fieldOfStudyRefId = fieldOfStudyRefId;
    }

    /**
     * Missing description at method setFocus.
     *
     * @param focus the Code.
     */
    public void setFocus(Code focus) {
        this.focus = focus;
        if ((focus != null)) {
            this.setFocusRefId(focus.getId());
        } else {
            this.setFocusRefId(null);
        }
    }

    /**
     * Missing description at method getFocus.
     *
     * @return the Code.
     */
    public Code getFocus() {
        return this.focus;
    }

    /**
     * Getter for the FocusRefId.
     *
     * @return the Long.
     */
    public Long getFocusRefId() {
        return this.focusRefId;
    }

    /**
     * Setter for the FocusRefId.
     *
     * @param focusRefId the Long.
     */
    public void setFocusRefId(Long focusRefId) {
        this.focusRefId = focusRefId;
    }

    /**
     * Missing description at method setTertiaryGraduation.
     *
     * @param tertiaryGraduation the Code.
     */
    public void setTertiaryGraduation(Code tertiaryGraduation) {
        this.tertiaryGraduation = tertiaryGraduation;
        if ((tertiaryGraduation != null)) {
            this.setTertiaryGraduationRefId(tertiaryGraduation.getId());
        } else {
            this.setTertiaryGraduationRefId(null);
        }
    }

    /**
     * Missing description at method getTertiaryGraduation.
     *
     * @return the Code.
     */
    public Code getTertiaryGraduation() {
        return this.tertiaryGraduation;
    }

    /**
     * Getter for the TertiaryGraduationRefId.
     *
     * @return the Long.
     */
    public Long getTertiaryGraduationRefId() {
        return this.tertiaryGraduationRefId;
    }

    /**
     * Setter for the TertiaryGraduationRefId.
     *
     * @param tertiaryGraduationRefId the Long.
     */
    public void setTertiaryGraduationRefId(Long tertiaryGraduationRefId) {
        this.tertiaryGraduationRefId = tertiaryGraduationRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TertiaryEducation.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TertiaryEducation.class).getAllProperties();
    }

    /**
     * Getter for the CategoryCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getCategoryCodePath() {
        return new CodePath(CATEGORY_CODEPATH);
    }

    /**
     * Getter for the TertiaryFormCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getTertiaryFormCodePath() {
        return new CodePath(TERTIARYFORM_CODEPATH);
    }

    /**
     * Getter for the FieldOfStudyCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getFieldOfStudyCodePath() {
        return new CodePath(FIELDOFSTUDY_CODEPATH);
    }

    /**
     * Getter for the FocusCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getFocusCodePath() {
        return new CodePath(FOCUS_CODEPATH);
    }

    /**
     * Getter for the TertiaryGraduationCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getTertiaryGraduationCodePath() {
        return new CodePath(TERTIARYGRADUATION_CODEPATH);
    }
}
