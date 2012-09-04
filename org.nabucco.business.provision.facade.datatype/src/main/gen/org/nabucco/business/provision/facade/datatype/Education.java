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
import org.nabucco.framework.base.facade.datatype.Amount;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * Education
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-11
 */
public class Education extends ProvisionCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final ProvisionCharacteristicType CHARACTERISTICTYPE_DEFAULT = ProvisionCharacteristicType.EDUCATION;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;u0,n;m0,1;", "l0,255;u0,n;m0,1;",
            "l0,255;u0,n;m0,1;", "m0,1;" };

    public static final String EDUCATIONTYPE = "educationType";

    public static final String GRADE = "grade";

    public static final String INSTITUTE = "institute";

    public static final String CITY = "city";

    public static final String COUNTRY = "country";

    protected EducationType educationType;

    private Amount grade;

    private Name institute;

    private Name city;

    private Code country;

    private Long countryRefId;

    protected static final String COUNTRY_CODEPATH = "nabucco.framework.country";

    /** Constructs a new Education instance. */
    public Education() {
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
     * @param clone the Education.
     */
    protected void cloneObject(Education clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        clone.setEducationType(this.getEducationType());
        if ((this.getGrade() != null)) {
            clone.setGrade(this.getGrade().cloneObject());
        }
        if ((this.getInstitute() != null)) {
            clone.setInstitute(this.getInstitute().cloneObject());
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
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ProvisionCharacteristic.class).getPropertyMap());
        propertyMap.put(EDUCATIONTYPE, PropertyDescriptorSupport.createEnumeration(EDUCATIONTYPE, EducationType.class,
                11, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(GRADE,
                PropertyDescriptorSupport.createBasetype(GRADE, Amount.class, 12, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(INSTITUTE,
                PropertyDescriptorSupport.createBasetype(INSTITUTE, Name.class, 13, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(CITY,
                PropertyDescriptorSupport.createBasetype(CITY, Name.class, 14, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(COUNTRY, PropertyDescriptorSupport.createDatatype(COUNTRY, Code.class, 15,
                PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPONENT, COUNTRY_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Education.getPropertyDescriptor(EDUCATIONTYPE), this.getEducationType(),
                null));
        properties.add(super.createProperty(Education.getPropertyDescriptor(GRADE), this.grade, null));
        properties.add(super.createProperty(Education.getPropertyDescriptor(INSTITUTE), this.institute, null));
        properties.add(super.createProperty(Education.getPropertyDescriptor(CITY), this.city, null));
        properties.add(super.createProperty(Education.getPropertyDescriptor(COUNTRY), this.getCountry(),
                this.countryRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(EDUCATIONTYPE) && (property.getType() == EducationType.class))) {
            this.setEducationType(((EducationType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(GRADE) && (property.getType() == Amount.class))) {
            this.setGrade(((Amount) property.getInstance()));
            return true;
        } else if ((property.getName().equals(INSTITUTE) && (property.getType() == Name.class))) {
            this.setInstitute(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CITY) && (property.getType() == Name.class))) {
            this.setCity(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(COUNTRY) && (property.getType() == Code.class))) {
            this.setCountry(((Code) property.getInstance()));
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
        final Education other = ((Education) obj);
        if ((this.educationType == null)) {
            if ((other.educationType != null))
                return false;
        } else if ((!this.educationType.equals(other.educationType)))
            return false;
        if ((this.grade == null)) {
            if ((other.grade != null))
                return false;
        } else if ((!this.grade.equals(other.grade)))
            return false;
        if ((this.institute == null)) {
            if ((other.institute != null))
                return false;
        } else if ((!this.institute.equals(other.institute)))
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
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.educationType == null) ? 0 : this.educationType.hashCode()));
        result = ((PRIME * result) + ((this.grade == null) ? 0 : this.grade.hashCode()));
        result = ((PRIME * result) + ((this.institute == null) ? 0 : this.institute.hashCode()));
        result = ((PRIME * result) + ((this.city == null) ? 0 : this.city.hashCode()));
        result = ((PRIME * result) + ((this.country == null) ? 0 : this.country.hashCode()));
        result = ((PRIME * result) + ((this.countryRefId == null) ? 0 : this.countryRefId.hashCode()));
        return result;
    }

    @Override
    public Education cloneObject() {
        Education clone = new Education();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getEducationType.
     *
     * @return the EducationType.
     */
    public EducationType getEducationType() {
        return this.educationType;
    }

    /**
     * Missing description at method setEducationType.
     *
     * @param educationType the EducationType.
     */
    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }

    /**
     * Missing description at method setEducationType.
     *
     * @param educationType the String.
     */
    public void setEducationType(String educationType) {
        if ((educationType == null)) {
            this.educationType = null;
        } else {
            this.educationType = EducationType.valueOf(educationType);
        }
    }

    /**
     * Missing description at method getGrade.
     *
     * @return the Amount.
     */
    public Amount getGrade() {
        return this.grade;
    }

    /**
     * Missing description at method setGrade.
     *
     * @param grade the Amount.
     */
    public void setGrade(Amount grade) {
        this.grade = grade;
    }

    /**
     * Missing description at method setGrade.
     *
     * @param grade the java.math.BigDecimal.
     */
    public void setGrade(java.math.BigDecimal grade) {
        if ((this.grade == null)) {
            if ((grade == null)) {
                return;
            }
            this.grade = new Amount();
        }
        this.grade.setValue(grade);
    }

    /**
     * Missing description at method getInstitute.
     *
     * @return the Name.
     */
    public Name getInstitute() {
        return this.institute;
    }

    /**
     * Missing description at method setInstitute.
     *
     * @param institute the Name.
     */
    public void setInstitute(Name institute) {
        this.institute = institute;
    }

    /**
     * Missing description at method setInstitute.
     *
     * @param institute the String.
     */
    public void setInstitute(String institute) {
        if ((this.institute == null)) {
            if ((institute == null)) {
                return;
            }
            this.institute = new Name();
        }
        this.institute.setValue(institute);
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
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Education.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Education.class).getAllProperties();
    }

    /**
     * Getter for the CountryCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getCountryCodePath() {
        return new CodePath(COUNTRY_CODEPATH);
    }
}
