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
import org.nabucco.business.provision.facade.datatype.ActivityArea;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * WorkExperience
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class WorkExperience extends ProvisionCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final ProvisionCharacteristicType CHARACTERISTICTYPE_DEFAULT = ProvisionCharacteristicType.WORK_EXPERICENCE;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m1,1;", "l0,255;u0,n;m1,1;",
            "l0,255;u0,n;m1,1;", "l0,255;u0,n;m0,1;", "m0,1;", "l0,n;u0,n;m0,1;", "m0,n;", "m0,n;", "m0,1;" };

    public static final String EMPLOYMENT = "employment";

    public static final String EMPLOYMENTDESCRIPTION = "employmentDescription";

    public static final String ORGANIZATION = "organization";

    public static final String CITY = "city";

    public static final String COUNTRY = "country";

    public static final String PROJECTEXPERIENCE = "projectExperience";

    public static final String SECTORLIST = "sectorList";

    public static final String ACTIVITYAREALIST = "activityAreaList";

    public static final String WORKEXPERIENCETYPE = "workExperienceType";

    private Name employment;

    private Description employmentDescription;

    private Name organization;

    private Name city;

    private Code country;

    private Long countryRefId;

    protected static final String COUNTRY_CODEPATH = "nabucco.framework.country";

    private Flag projectExperience;

    private NabuccoList<Sector> sectorList;

    private NabuccoList<ActivityArea> activityAreaList;

    private Code workExperienceType;

    private Long workExperienceTypeRefId;

    protected static final String WORKEXPERIENCETYPE_CODEPATH = "nabucco.business.provision.workexperiencetype";

    /** Constructs a new WorkExperience instance. */
    public WorkExperience() {
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
     * @param clone the WorkExperience.
     */
    protected void cloneObject(WorkExperience clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getEmployment() != null)) {
            clone.setEmployment(this.getEmployment().cloneObject());
        }
        if ((this.getEmploymentDescription() != null)) {
            clone.setEmploymentDescription(this.getEmploymentDescription().cloneObject());
        }
        if ((this.getOrganization() != null)) {
            clone.setOrganization(this.getOrganization().cloneObject());
        }
        if ((this.getCity() != null)) {
            clone.setCity(this.getCity().cloneObject());
        }
        if ((this.getCountry() != null)) {
            clone.setCountry(this.getCountry().cloneObject());
        }
        if ((this.getCountryRefId() != null)) {
            clone.setCountryRefId(this.getCountryRefId());
        }
        if ((this.getProjectExperience() != null)) {
            clone.setProjectExperience(this.getProjectExperience().cloneObject());
        }
        if ((this.sectorList != null)) {
            clone.sectorList = this.sectorList.cloneCollection();
        }
        if ((this.activityAreaList != null)) {
            clone.activityAreaList = this.activityAreaList.cloneCollection();
        }
        if ((this.getWorkExperienceType() != null)) {
            clone.setWorkExperienceType(this.getWorkExperienceType().cloneObject());
        }
        if ((this.getWorkExperienceTypeRefId() != null)) {
            clone.setWorkExperienceTypeRefId(this.getWorkExperienceTypeRefId());
        }
    }

    /**
     * Getter for the SectorListJPA.
     *
     * @return the List<Sector>.
     */
    List<Sector> getSectorListJPA() {
        if ((this.sectorList == null)) {
            this.sectorList = new NabuccoListImpl<Sector>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<Sector>) this.sectorList).getDelegate();
    }

    /**
     * Setter for the SectorListJPA.
     *
     * @param sectorList the List<Sector>.
     */
    void setSectorListJPA(List<Sector> sectorList) {
        if ((this.sectorList == null)) {
            this.sectorList = new NabuccoListImpl<Sector>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<Sector>) this.sectorList).setDelegate(sectorList);
    }

    /**
     * Getter for the ActivityAreaListJPA.
     *
     * @return the List<ActivityArea>.
     */
    List<ActivityArea> getActivityAreaListJPA() {
        if ((this.activityAreaList == null)) {
            this.activityAreaList = new NabuccoListImpl<ActivityArea>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ActivityArea>) this.activityAreaList).getDelegate();
    }

    /**
     * Setter for the ActivityAreaListJPA.
     *
     * @param activityAreaList the List<ActivityArea>.
     */
    void setActivityAreaListJPA(List<ActivityArea> activityAreaList) {
        if ((this.activityAreaList == null)) {
            this.activityAreaList = new NabuccoListImpl<ActivityArea>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ActivityArea>) this.activityAreaList).setDelegate(activityAreaList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ProvisionCharacteristic.class).getPropertyMap());
        propertyMap.put(EMPLOYMENT,
                PropertyDescriptorSupport.createBasetype(EMPLOYMENT, Name.class, 11, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(EMPLOYMENTDESCRIPTION, PropertyDescriptorSupport.createBasetype(EMPLOYMENTDESCRIPTION,
                Description.class, 12, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(ORGANIZATION,
                PropertyDescriptorSupport.createBasetype(ORGANIZATION, Name.class, 13, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(CITY,
                PropertyDescriptorSupport.createBasetype(CITY, Name.class, 14, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(COUNTRY, PropertyDescriptorSupport.createDatatype(COUNTRY, Code.class, 15,
                PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPONENT, COUNTRY_CODEPATH));
        propertyMap.put(PROJECTEXPERIENCE, PropertyDescriptorSupport.createBasetype(PROJECTEXPERIENCE, Flag.class, 16,
                PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(SECTORLIST, PropertyDescriptorSupport.createCollection(SECTORLIST, Sector.class, 17,
                PROPERTY_CONSTRAINTS[6], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(ACTIVITYAREALIST, PropertyDescriptorSupport.createCollection(ACTIVITYAREALIST,
                ActivityArea.class, 18, PROPERTY_CONSTRAINTS[7], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(WORKEXPERIENCETYPE, PropertyDescriptorSupport.createDatatype(WORKEXPERIENCETYPE, Code.class,
                19, PROPERTY_CONSTRAINTS[8], false, PropertyAssociationType.COMPONENT, WORKEXPERIENCETYPE_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(WorkExperience.getPropertyDescriptor(EMPLOYMENT), this.employment, null));
        properties.add(super.createProperty(WorkExperience.getPropertyDescriptor(EMPLOYMENTDESCRIPTION),
                this.employmentDescription, null));
        properties
                .add(super.createProperty(WorkExperience.getPropertyDescriptor(ORGANIZATION), this.organization, null));
        properties.add(super.createProperty(WorkExperience.getPropertyDescriptor(CITY), this.city, null));
        properties.add(super.createProperty(WorkExperience.getPropertyDescriptor(COUNTRY), this.getCountry(),
                this.countryRefId));
        properties.add(super.createProperty(WorkExperience.getPropertyDescriptor(PROJECTEXPERIENCE),
                this.projectExperience, null));
        properties.add(super.createProperty(WorkExperience.getPropertyDescriptor(SECTORLIST), this.sectorList, null));
        properties.add(super.createProperty(WorkExperience.getPropertyDescriptor(ACTIVITYAREALIST),
                this.activityAreaList, null));
        properties.add(super.createProperty(WorkExperience.getPropertyDescriptor(WORKEXPERIENCETYPE),
                this.getWorkExperienceType(), this.workExperienceTypeRefId));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(EMPLOYMENT) && (property.getType() == Name.class))) {
            this.setEmployment(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(EMPLOYMENTDESCRIPTION) && (property.getType() == Description.class))) {
            this.setEmploymentDescription(((Description) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ORGANIZATION) && (property.getType() == Name.class))) {
            this.setOrganization(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CITY) && (property.getType() == Name.class))) {
            this.setCity(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(COUNTRY) && (property.getType() == Code.class))) {
            this.setCountry(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROJECTEXPERIENCE) && (property.getType() == Flag.class))) {
            this.setProjectExperience(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SECTORLIST) && (property.getType() == Sector.class))) {
            this.sectorList = ((NabuccoList<Sector>) property.getInstance());
            return true;
        } else if ((property.getName().equals(ACTIVITYAREALIST) && (property.getType() == ActivityArea.class))) {
            this.activityAreaList = ((NabuccoList<ActivityArea>) property.getInstance());
            return true;
        } else if ((property.getName().equals(WORKEXPERIENCETYPE) && (property.getType() == Code.class))) {
            this.setWorkExperienceType(((Code) property.getInstance()));
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
        final WorkExperience other = ((WorkExperience) obj);
        if ((this.employment == null)) {
            if ((other.employment != null))
                return false;
        } else if ((!this.employment.equals(other.employment)))
            return false;
        if ((this.employmentDescription == null)) {
            if ((other.employmentDescription != null))
                return false;
        } else if ((!this.employmentDescription.equals(other.employmentDescription)))
            return false;
        if ((this.organization == null)) {
            if ((other.organization != null))
                return false;
        } else if ((!this.organization.equals(other.organization)))
            return false;
        if ((this.city == null)) {
            if ((other.city != null))
                return false;
        } else if ((!this.city.equals(other.city)))
            return false;
        if ((this.country == null)) {
            if ((other.country != null))
                return false;
        } else if ((!this.country.equals(other.country)))
            return false;
        if ((this.countryRefId == null)) {
            if ((other.countryRefId != null))
                return false;
        } else if ((!this.countryRefId.equals(other.countryRefId)))
            return false;
        if ((this.projectExperience == null)) {
            if ((other.projectExperience != null))
                return false;
        } else if ((!this.projectExperience.equals(other.projectExperience)))
            return false;
        if ((this.workExperienceType == null)) {
            if ((other.workExperienceType != null))
                return false;
        } else if ((!this.workExperienceType.equals(other.workExperienceType)))
            return false;
        if ((this.workExperienceTypeRefId == null)) {
            if ((other.workExperienceTypeRefId != null))
                return false;
        } else if ((!this.workExperienceTypeRefId.equals(other.workExperienceTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.employment == null) ? 0 : this.employment.hashCode()));
        result = ((PRIME * result) + ((this.employmentDescription == null) ? 0 : this.employmentDescription.hashCode()));
        result = ((PRIME * result) + ((this.organization == null) ? 0 : this.organization.hashCode()));
        result = ((PRIME * result) + ((this.city == null) ? 0 : this.city.hashCode()));
        result = ((PRIME * result) + ((this.country == null) ? 0 : this.country.hashCode()));
        result = ((PRIME * result) + ((this.countryRefId == null) ? 0 : this.countryRefId.hashCode()));
        result = ((PRIME * result) + ((this.projectExperience == null) ? 0 : this.projectExperience.hashCode()));
        result = ((PRIME * result) + ((this.workExperienceType == null) ? 0 : this.workExperienceType.hashCode()));
        result = ((PRIME * result) + ((this.workExperienceTypeRefId == null) ? 0 : this.workExperienceTypeRefId
                .hashCode()));
        return result;
    }

    @Override
    public WorkExperience cloneObject() {
        WorkExperience clone = new WorkExperience();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getEmployment.
     *
     * @return the Name.
     */
    public Name getEmployment() {
        return this.employment;
    }

    /**
     * Missing description at method setEmployment.
     *
     * @param employment the Name.
     */
    public void setEmployment(Name employment) {
        this.employment = employment;
    }

    /**
     * Missing description at method setEmployment.
     *
     * @param employment the String.
     */
    public void setEmployment(String employment) {
        if ((this.employment == null)) {
            if ((employment == null)) {
                return;
            }
            this.employment = new Name();
        }
        this.employment.setValue(employment);
    }

    /**
     * Missing description at method getEmploymentDescription.
     *
     * @return the Description.
     */
    public Description getEmploymentDescription() {
        return this.employmentDescription;
    }

    /**
     * Missing description at method setEmploymentDescription.
     *
     * @param employmentDescription the Description.
     */
    public void setEmploymentDescription(Description employmentDescription) {
        this.employmentDescription = employmentDescription;
    }

    /**
     * Missing description at method setEmploymentDescription.
     *
     * @param employmentDescription the String.
     */
    public void setEmploymentDescription(String employmentDescription) {
        if ((this.employmentDescription == null)) {
            if ((employmentDescription == null)) {
                return;
            }
            this.employmentDescription = new Description();
        }
        this.employmentDescription.setValue(employmentDescription);
    }

    /**
     * Missing description at method getOrganization.
     *
     * @return the Name.
     */
    public Name getOrganization() {
        return this.organization;
    }

    /**
     * Missing description at method setOrganization.
     *
     * @param organization the Name.
     */
    public void setOrganization(Name organization) {
        this.organization = organization;
    }

    /**
     * Missing description at method setOrganization.
     *
     * @param organization the String.
     */
    public void setOrganization(String organization) {
        if ((this.organization == null)) {
            if ((organization == null)) {
                return;
            }
            this.organization = new Name();
        }
        this.organization.setValue(organization);
    }

    /**
     * Missing description at method getCity.
     *
     * @return the Name.
     */
    public Name getCity() {
        return this.city;
    }

    /**
     * Missing description at method setCity.
     *
     * @param city the Name.
     */
    public void setCity(Name city) {
        this.city = city;
    }

    /**
     * Missing description at method setCity.
     *
     * @param city the String.
     */
    public void setCity(String city) {
        if ((this.city == null)) {
            if ((city == null)) {
                return;
            }
            this.city = new Name();
        }
        this.city.setValue(city);
    }

    /**
     * Missing description at method setCountry.
     *
     * @param country the Code.
     */
    public void setCountry(Code country) {
        this.country = country;
        if ((country != null)) {
            this.setCountryRefId(country.getId());
        } else {
            this.setCountryRefId(null);
        }
    }

    /**
     * Missing description at method getCountry.
     *
     * @return the Code.
     */
    public Code getCountry() {
        return this.country;
    }

    /**
     * Getter for the CountryRefId.
     *
     * @return the Long.
     */
    public Long getCountryRefId() {
        return this.countryRefId;
    }

    /**
     * Setter for the CountryRefId.
     *
     * @param countryRefId the Long.
     */
    public void setCountryRefId(Long countryRefId) {
        this.countryRefId = countryRefId;
    }

    /**
     * Missing description at method getProjectExperience.
     *
     * @return the Flag.
     */
    public Flag getProjectExperience() {
        return this.projectExperience;
    }

    /**
     * Missing description at method setProjectExperience.
     *
     * @param projectExperience the Flag.
     */
    public void setProjectExperience(Flag projectExperience) {
        this.projectExperience = projectExperience;
    }

    /**
     * Missing description at method setProjectExperience.
     *
     * @param projectExperience the Boolean.
     */
    public void setProjectExperience(Boolean projectExperience) {
        if ((this.projectExperience == null)) {
            if ((projectExperience == null)) {
                return;
            }
            this.projectExperience = new Flag();
        }
        this.projectExperience.setValue(projectExperience);
    }

    /**
     * Missing description at method getSectorList.
     *
     * @return the NabuccoList<Sector>.
     */
    public NabuccoList<Sector> getSectorList() {
        if ((this.sectorList == null)) {
            this.sectorList = new NabuccoListImpl<Sector>(NabuccoCollectionState.INITIALIZED);
        }
        return this.sectorList;
    }

    /**
     * Missing description at method getActivityAreaList.
     *
     * @return the NabuccoList<ActivityArea>.
     */
    public NabuccoList<ActivityArea> getActivityAreaList() {
        if ((this.activityAreaList == null)) {
            this.activityAreaList = new NabuccoListImpl<ActivityArea>(NabuccoCollectionState.INITIALIZED);
        }
        return this.activityAreaList;
    }

    /**
     * Missing description at method setWorkExperienceType.
     *
     * @param workExperienceType the Code.
     */
    public void setWorkExperienceType(Code workExperienceType) {
        this.workExperienceType = workExperienceType;
        if ((workExperienceType != null)) {
            this.setWorkExperienceTypeRefId(workExperienceType.getId());
        } else {
            this.setWorkExperienceTypeRefId(null);
        }
    }

    /**
     * Missing description at method getWorkExperienceType.
     *
     * @return the Code.
     */
    public Code getWorkExperienceType() {
        return this.workExperienceType;
    }

    /**
     * Getter for the WorkExperienceTypeRefId.
     *
     * @return the Long.
     */
    public Long getWorkExperienceTypeRefId() {
        return this.workExperienceTypeRefId;
    }

    /**
     * Setter for the WorkExperienceTypeRefId.
     *
     * @param workExperienceTypeRefId the Long.
     */
    public void setWorkExperienceTypeRefId(Long workExperienceTypeRefId) {
        this.workExperienceTypeRefId = workExperienceTypeRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(WorkExperience.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(WorkExperience.class).getAllProperties();
    }

    /**
     * Getter for the CountryCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getCountryCodePath() {
        return new CodePath(COUNTRY_CODEPATH);
    }

    /**
     * Getter for the WorkExperienceTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getWorkExperienceTypeCodePath() {
        return new CodePath(WORKEXPERIENCETYPE_CODEPATH);
    }
}
