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
 * JobEducation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-11
 */
public class JobEducation extends Education implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final EducationType EDUCATIONTYPE_DEFAULT = EducationType.JOB;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;" };

    public static final String JOBGRADUATION = "jobGraduation";

    private Code jobGraduation;

    private Long jobGraduationRefId;

    protected static final String JOBGRADUATION_CODEPATH = "nabucco.business.provision.education.jobgraduation";

    /** Constructs a new JobEducation instance. */
    public JobEducation() {
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
     * @param clone the JobEducation.
     */
    protected void cloneObject(JobEducation clone) {
        super.cloneObject(clone);
        clone.setEducationType(this.getEducationType());
        if ((this.getJobGraduation() != null)) {
            clone.setJobGraduation(this.getJobGraduation().cloneObject());
        }
        if ((this.getJobGraduationRefId() != null)) {
            clone.setJobGraduationRefId(this.getJobGraduationRefId());
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
        propertyMap.put(JOBGRADUATION, PropertyDescriptorSupport.createDatatype(JOBGRADUATION, Code.class, 16,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, JOBGRADUATION_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(JobEducation.getPropertyDescriptor(JOBGRADUATION), this.getJobGraduation(),
                this.jobGraduationRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(JOBGRADUATION) && (property.getType() == Code.class))) {
            this.setJobGraduation(((Code) property.getInstance()));
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
        final JobEducation other = ((JobEducation) obj);
        if ((this.jobGraduation == null)) {
            if ((other.jobGraduation != null))
                return false;
        } else if ((!this.jobGraduation.equals(other.jobGraduation)))
            return false;
        if ((this.jobGraduationRefId == null)) {
            if ((other.jobGraduationRefId != null))
                return false;
        } else if ((!this.jobGraduationRefId.equals(other.jobGraduationRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.jobGraduation == null) ? 0 : this.jobGraduation.hashCode()));
        result = ((PRIME * result) + ((this.jobGraduationRefId == null) ? 0 : this.jobGraduationRefId.hashCode()));
        return result;
    }

    @Override
    public JobEducation cloneObject() {
        JobEducation clone = new JobEducation();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setJobGraduation.
     *
     * @param jobGraduation the Code.
     */
    public void setJobGraduation(Code jobGraduation) {
        this.jobGraduation = jobGraduation;
        if ((jobGraduation != null)) {
            this.setJobGraduationRefId(jobGraduation.getId());
        } else {
            this.setJobGraduationRefId(null);
        }
    }

    /**
     * Missing description at method getJobGraduation.
     *
     * @return the Code.
     */
    public Code getJobGraduation() {
        return this.jobGraduation;
    }

    /**
     * Getter for the JobGraduationRefId.
     *
     * @return the Long.
     */
    public Long getJobGraduationRefId() {
        return this.jobGraduationRefId;
    }

    /**
     * Setter for the JobGraduationRefId.
     *
     * @param jobGraduationRefId the Long.
     */
    public void setJobGraduationRefId(Long jobGraduationRefId) {
        this.jobGraduationRefId = jobGraduationRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(JobEducation.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(JobEducation.class).getAllProperties();
    }

    /**
     * Getter for the JobGraduationCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getJobGraduationCodePath() {
        return new CodePath(JOBGRADUATION_CODEPATH);
    }
}
