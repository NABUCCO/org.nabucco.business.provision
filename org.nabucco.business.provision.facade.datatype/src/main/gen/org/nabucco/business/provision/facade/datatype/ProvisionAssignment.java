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
import org.nabucco.business.provision.facade.datatype.ProvisionAssignmentHistory;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.business.provision.facade.datatype.ProvisionSourceType;
import org.nabucco.business.provision.facade.datatype.ProvisionUsageType;
import org.nabucco.business.provision.facade.datatype.RequirementType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Number;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.date.PeriodType;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.datatype.text.LongDescription;

/**
 * ProvisionAssignment
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProvisionAssignment extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final ProvisionSourceType SOURCETYPE_DEFAULT = ProvisionSourceType.INTERN;

    private static final RequirementType REQUIREMENTTYPE_DEFAULT = RequirementType.NONE;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,4000;u0,n;m0,1;", "m1,1;", "m1,1;", "m1,1;", "l0,n;u0,n;m0,1;", "m0,1;", "m0,1;",
            "m1,1;", "m0,n;", "m1,1;" };

    public static final String LEVEL = "level";

    public static final String DATEFROM = "dateFrom";

    public static final String DATETILL = "dateTill";

    public static final String DATELASTUSED = "dateLastUsed";

    public static final String ADDITIONALS = "additionals";

    public static final String REQUIREMENTTYPE = "requirementType";

    public static final String PROVISIONUSAGETYPE = "provisionUsageType";

    public static final String CHARACTERISTICTYPE = "characteristicType";

    public static final String USAGEPERIODCOUNT = "usagePeriodCount";

    public static final String PERIODTYPE = "periodType";

    public static final String CATEGORY = "category";

    public static final String CHARACTERISTIC = "characteristic";

    public static final String HISTORYLIST = "historyList";

    public static final String SOURCETYPE = "sourceType";

    private Code level;

    private Long levelRefId;

    protected static final String LEVEL_CODEPATH = "nabucco.business.provision.level";

    private Date dateFrom;

    private Date dateTill;

    private Date dateLastUsed;

    private LongDescription additionals;

    private RequirementType requirementType;

    private ProvisionUsageType provisionUsageType;

    private ProvisionCharacteristicType characteristicType;

    /** The count of units specified by periodType */
    private Number usagePeriodCount;

    /** The type of period units */
    private PeriodType periodType;

    /** The category of the profilion assignment */
    private Code category;

    private Long categoryRefId;

    protected static final String CATEGORY_CODEPATH = "nabucco.business.provision.category";

    private ProvisionCharacteristic characteristic;

    private NabuccoList<ProvisionAssignmentHistory> historyList;

    private ProvisionSourceType sourceType;

    /** Constructs a new ProvisionAssignment instance. */
    public ProvisionAssignment() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        requirementType = REQUIREMENTTYPE_DEFAULT;
        sourceType = SOURCETYPE_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the ProvisionAssignment.
     */
    protected void cloneObject(ProvisionAssignment clone) {
        super.cloneObject(clone);
        if ((this.getLevel() != null)) {
            clone.setLevel(this.getLevel().cloneObject());
        }
        if ((this.getLevelRefId() != null)) {
            clone.setLevelRefId(this.getLevelRefId());
        }
        if ((this.getDateFrom() != null)) {
            clone.setDateFrom(this.getDateFrom().cloneObject());
        }
        if ((this.getDateTill() != null)) {
            clone.setDateTill(this.getDateTill().cloneObject());
        }
        if ((this.getDateLastUsed() != null)) {
            clone.setDateLastUsed(this.getDateLastUsed().cloneObject());
        }
        if ((this.getAdditionals() != null)) {
            clone.setAdditionals(this.getAdditionals().cloneObject());
        }
        clone.setRequirementType(this.getRequirementType());
        clone.setProvisionUsageType(this.getProvisionUsageType());
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getUsagePeriodCount() != null)) {
            clone.setUsagePeriodCount(this.getUsagePeriodCount().cloneObject());
        }
        clone.setPeriodType(this.getPeriodType());
        if ((this.getCategory() != null)) {
            clone.setCategory(this.getCategory().cloneObject());
        }
        if ((this.getCategoryRefId() != null)) {
            clone.setCategoryRefId(this.getCategoryRefId());
        }
        if ((this.getCharacteristic() != null)) {
            clone.setCharacteristic(this.getCharacteristic().cloneObject());
        }
        if ((this.historyList != null)) {
            clone.historyList = this.historyList.cloneCollection();
        }
        clone.setSourceType(this.getSourceType());
    }

    /**
     * Getter for the HistoryListJPA.
     *
     * @return the List<ProvisionAssignmentHistory>.
     */
    List<ProvisionAssignmentHistory> getHistoryListJPA() {
        if ((this.historyList == null)) {
            this.historyList = new NabuccoListImpl<ProvisionAssignmentHistory>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ProvisionAssignmentHistory>) this.historyList).getDelegate();
    }

    /**
     * Setter for the HistoryListJPA.
     *
     * @param historyList the List<ProvisionAssignmentHistory>.
     */
    void setHistoryListJPA(List<ProvisionAssignmentHistory> historyList) {
        if ((this.historyList == null)) {
            this.historyList = new NabuccoListImpl<ProvisionAssignmentHistory>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ProvisionAssignmentHistory>) this.historyList).setDelegate(historyList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(LEVEL, PropertyDescriptorSupport.createDatatype(LEVEL, Code.class, 3, PROPERTY_CONSTRAINTS[0],
                false, PropertyAssociationType.COMPONENT, LEVEL_CODEPATH));
        propertyMap.put(DATEFROM,
                PropertyDescriptorSupport.createBasetype(DATEFROM, Date.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(DATETILL,
                PropertyDescriptorSupport.createBasetype(DATETILL, Date.class, 5, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(DATELASTUSED,
                PropertyDescriptorSupport.createBasetype(DATELASTUSED, Date.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(ADDITIONALS, PropertyDescriptorSupport.createBasetype(ADDITIONALS, LongDescription.class, 7,
                PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(REQUIREMENTTYPE, PropertyDescriptorSupport.createEnumeration(REQUIREMENTTYPE,
                RequirementType.class, 8, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(PROVISIONUSAGETYPE, PropertyDescriptorSupport.createEnumeration(PROVISIONUSAGETYPE,
                ProvisionUsageType.class, 9, PROPERTY_CONSTRAINTS[6], false));
        propertyMap.put(CHARACTERISTICTYPE, PropertyDescriptorSupport.createEnumeration(CHARACTERISTICTYPE,
                ProvisionCharacteristicType.class, 10, PROPERTY_CONSTRAINTS[7], false));
        propertyMap.put(USAGEPERIODCOUNT, PropertyDescriptorSupport.createBasetype(USAGEPERIODCOUNT, Number.class, 11,
                PROPERTY_CONSTRAINTS[8], false));
        propertyMap.put(PERIODTYPE, PropertyDescriptorSupport.createEnumeration(PERIODTYPE, PeriodType.class, 12,
                PROPERTY_CONSTRAINTS[9], false));
        propertyMap.put(CATEGORY, PropertyDescriptorSupport.createDatatype(CATEGORY, Code.class, 13,
                PROPERTY_CONSTRAINTS[10], false, PropertyAssociationType.COMPONENT, CATEGORY_CODEPATH));
        propertyMap.put(CHARACTERISTIC, PropertyDescriptorSupport
                .createDatatype(CHARACTERISTIC, ProvisionCharacteristic.class, 14, PROPERTY_CONSTRAINTS[11], false,
                        PropertyAssociationType.AGGREGATION));
        propertyMap.put(HISTORYLIST, PropertyDescriptorSupport.createCollection(HISTORYLIST,
                ProvisionAssignmentHistory.class, 15, PROPERTY_CONSTRAINTS[12], false,
                PropertyAssociationType.COMPOSITION));
        propertyMap.put(SOURCETYPE, PropertyDescriptorSupport.createEnumeration(SOURCETYPE, ProvisionSourceType.class,
                16, PROPERTY_CONSTRAINTS[13], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(LEVEL), this.getLevel(),
                this.levelRefId));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(DATEFROM), this.dateFrom, null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(DATETILL), this.dateTill, null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(DATELASTUSED), this.dateLastUsed,
                null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(ADDITIONALS), this.additionals,
                null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(REQUIREMENTTYPE),
                this.getRequirementType(), null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(PROVISIONUSAGETYPE),
                this.getProvisionUsageType(), null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(CHARACTERISTICTYPE),
                this.getCharacteristicType(), null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(USAGEPERIODCOUNT),
                this.usagePeriodCount, null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(PERIODTYPE),
                this.getPeriodType(), null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(CATEGORY), this.getCategory(),
                this.categoryRefId));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(CHARACTERISTIC),
                this.getCharacteristic(), null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(HISTORYLIST), this.historyList,
                null));
        properties.add(super.createProperty(ProvisionAssignment.getPropertyDescriptor(SOURCETYPE),
                this.getSourceType(), null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(LEVEL) && (property.getType() == Code.class))) {
            this.setLevel(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DATEFROM) && (property.getType() == Date.class))) {
            this.setDateFrom(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DATETILL) && (property.getType() == Date.class))) {
            this.setDateTill(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DATELASTUSED) && (property.getType() == Date.class))) {
            this.setDateLastUsed(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ADDITIONALS) && (property.getType() == LongDescription.class))) {
            this.setAdditionals(((LongDescription) property.getInstance()));
            return true;
        } else if ((property.getName().equals(REQUIREMENTTYPE) && (property.getType() == RequirementType.class))) {
            this.setRequirementType(((RequirementType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROVISIONUSAGETYPE) && (property.getType() == ProvisionUsageType.class))) {
            this.setProvisionUsageType(((ProvisionUsageType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CHARACTERISTICTYPE) && (property.getType() == ProvisionCharacteristicType.class))) {
            this.setCharacteristicType(((ProvisionCharacteristicType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(USAGEPERIODCOUNT) && (property.getType() == Number.class))) {
            this.setUsagePeriodCount(((Number) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PERIODTYPE) && (property.getType() == PeriodType.class))) {
            this.setPeriodType(((PeriodType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CATEGORY) && (property.getType() == Code.class))) {
            this.setCategory(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CHARACTERISTIC) && (property.getType() == ProvisionCharacteristic.class))) {
            this.setCharacteristic(((ProvisionCharacteristic) property.getInstance()));
            return true;
        } else if ((property.getName().equals(HISTORYLIST) && (property.getType() == ProvisionAssignmentHistory.class))) {
            this.historyList = ((NabuccoList<ProvisionAssignmentHistory>) property.getInstance());
            return true;
        } else if ((property.getName().equals(SOURCETYPE) && (property.getType() == ProvisionSourceType.class))) {
            this.setSourceType(((ProvisionSourceType) property.getInstance()));
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
        final ProvisionAssignment other = ((ProvisionAssignment) obj);
        if ((this.level == null)) {
            if ((other.level != null))
                return false;
        } else if ((!this.level.equals(other.level)))
            return false;
        if ((this.levelRefId == null)) {
            if ((other.levelRefId != null))
                return false;
        } else if ((!this.levelRefId.equals(other.levelRefId)))
            return false;
        if ((this.dateFrom == null)) {
            if ((other.dateFrom != null))
                return false;
        } else if ((!this.dateFrom.equals(other.dateFrom)))
            return false;
        if ((this.dateTill == null)) {
            if ((other.dateTill != null))
                return false;
        } else if ((!this.dateTill.equals(other.dateTill)))
            return false;
        if ((this.dateLastUsed == null)) {
            if ((other.dateLastUsed != null))
                return false;
        } else if ((!this.dateLastUsed.equals(other.dateLastUsed)))
            return false;
        if ((this.additionals == null)) {
            if ((other.additionals != null))
                return false;
        } else if ((!this.additionals.equals(other.additionals)))
            return false;
        if ((this.requirementType == null)) {
            if ((other.requirementType != null))
                return false;
        } else if ((!this.requirementType.equals(other.requirementType)))
            return false;
        if ((this.provisionUsageType == null)) {
            if ((other.provisionUsageType != null))
                return false;
        } else if ((!this.provisionUsageType.equals(other.provisionUsageType)))
            return false;
        if ((this.characteristicType == null)) {
            if ((other.characteristicType != null))
                return false;
        } else if ((!this.characteristicType.equals(other.characteristicType)))
            return false;
        if ((this.usagePeriodCount == null)) {
            if ((other.usagePeriodCount != null))
                return false;
        } else if ((!this.usagePeriodCount.equals(other.usagePeriodCount)))
            return false;
        if ((this.periodType == null)) {
            if ((other.periodType != null))
                return false;
        } else if ((!this.periodType.equals(other.periodType)))
            return false;
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
        if ((this.characteristic == null)) {
            if ((other.characteristic != null))
                return false;
        } else if ((!this.characteristic.equals(other.characteristic)))
            return false;
        if ((this.sourceType == null)) {
            if ((other.sourceType != null))
                return false;
        } else if ((!this.sourceType.equals(other.sourceType)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.level == null) ? 0 : this.level.hashCode()));
        result = ((PRIME * result) + ((this.levelRefId == null) ? 0 : this.levelRefId.hashCode()));
        result = ((PRIME * result) + ((this.dateFrom == null) ? 0 : this.dateFrom.hashCode()));
        result = ((PRIME * result) + ((this.dateTill == null) ? 0 : this.dateTill.hashCode()));
        result = ((PRIME * result) + ((this.dateLastUsed == null) ? 0 : this.dateLastUsed.hashCode()));
        result = ((PRIME * result) + ((this.additionals == null) ? 0 : this.additionals.hashCode()));
        result = ((PRIME * result) + ((this.requirementType == null) ? 0 : this.requirementType.hashCode()));
        result = ((PRIME * result) + ((this.provisionUsageType == null) ? 0 : this.provisionUsageType.hashCode()));
        result = ((PRIME * result) + ((this.characteristicType == null) ? 0 : this.characteristicType.hashCode()));
        result = ((PRIME * result) + ((this.usagePeriodCount == null) ? 0 : this.usagePeriodCount.hashCode()));
        result = ((PRIME * result) + ((this.periodType == null) ? 0 : this.periodType.hashCode()));
        result = ((PRIME * result) + ((this.category == null) ? 0 : this.category.hashCode()));
        result = ((PRIME * result) + ((this.categoryRefId == null) ? 0 : this.categoryRefId.hashCode()));
        result = ((PRIME * result) + ((this.characteristic == null) ? 0 : this.characteristic.hashCode()));
        result = ((PRIME * result) + ((this.sourceType == null) ? 0 : this.sourceType.hashCode()));
        return result;
    }

    @Override
    public ProvisionAssignment cloneObject() {
        ProvisionAssignment clone = new ProvisionAssignment();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setLevel.
     *
     * @param level the Code.
     */
    public void setLevel(Code level) {
        this.level = level;
        if ((level != null)) {
            this.setLevelRefId(level.getId());
        } else {
            this.setLevelRefId(null);
        }
    }

    /**
     * Missing description at method getLevel.
     *
     * @return the Code.
     */
    public Code getLevel() {
        return this.level;
    }

    /**
     * Getter for the LevelRefId.
     *
     * @return the Long.
     */
    public Long getLevelRefId() {
        return this.levelRefId;
    }

    /**
     * Setter for the LevelRefId.
     *
     * @param levelRefId the Long.
     */
    public void setLevelRefId(Long levelRefId) {
        this.levelRefId = levelRefId;
    }

    /**
     * Missing description at method getDateFrom.
     *
     * @return the Date.
     */
    public Date getDateFrom() {
        return this.dateFrom;
    }

    /**
     * Missing description at method setDateFrom.
     *
     * @param dateFrom the Date.
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * Missing description at method setDateFrom.
     *
     * @param dateFrom the java.util.Date.
     */
    public void setDateFrom(java.util.Date dateFrom) {
        if ((this.dateFrom == null)) {
            if ((dateFrom == null)) {
                return;
            }
            this.dateFrom = new Date();
        }
        this.dateFrom.setValue(dateFrom);
    }

    /**
     * Missing description at method getDateTill.
     *
     * @return the Date.
     */
    public Date getDateTill() {
        return this.dateTill;
    }

    /**
     * Missing description at method setDateTill.
     *
     * @param dateTill the Date.
     */
    public void setDateTill(Date dateTill) {
        this.dateTill = dateTill;
    }

    /**
     * Missing description at method setDateTill.
     *
     * @param dateTill the java.util.Date.
     */
    public void setDateTill(java.util.Date dateTill) {
        if ((this.dateTill == null)) {
            if ((dateTill == null)) {
                return;
            }
            this.dateTill = new Date();
        }
        this.dateTill.setValue(dateTill);
    }

    /**
     * Missing description at method getDateLastUsed.
     *
     * @return the Date.
     */
    public Date getDateLastUsed() {
        return this.dateLastUsed;
    }

    /**
     * Missing description at method setDateLastUsed.
     *
     * @param dateLastUsed the Date.
     */
    public void setDateLastUsed(Date dateLastUsed) {
        this.dateLastUsed = dateLastUsed;
    }

    /**
     * Missing description at method setDateLastUsed.
     *
     * @param dateLastUsed the java.util.Date.
     */
    public void setDateLastUsed(java.util.Date dateLastUsed) {
        if ((this.dateLastUsed == null)) {
            if ((dateLastUsed == null)) {
                return;
            }
            this.dateLastUsed = new Date();
        }
        this.dateLastUsed.setValue(dateLastUsed);
    }

    /**
     * Missing description at method getAdditionals.
     *
     * @return the LongDescription.
     */
    public LongDescription getAdditionals() {
        return this.additionals;
    }

    /**
     * Missing description at method setAdditionals.
     *
     * @param additionals the LongDescription.
     */
    public void setAdditionals(LongDescription additionals) {
        this.additionals = additionals;
    }

    /**
     * Missing description at method setAdditionals.
     *
     * @param additionals the String.
     */
    public void setAdditionals(String additionals) {
        if ((this.additionals == null)) {
            if ((additionals == null)) {
                return;
            }
            this.additionals = new LongDescription();
        }
        this.additionals.setValue(additionals);
    }

    /**
     * Missing description at method getRequirementType.
     *
     * @return the RequirementType.
     */
    public RequirementType getRequirementType() {
        return this.requirementType;
    }

    /**
     * Missing description at method setRequirementType.
     *
     * @param requirementType the RequirementType.
     */
    public void setRequirementType(RequirementType requirementType) {
        this.requirementType = requirementType;
    }

    /**
     * Missing description at method setRequirementType.
     *
     * @param requirementType the String.
     */
    public void setRequirementType(String requirementType) {
        if ((requirementType == null)) {
            this.requirementType = null;
        } else {
            this.requirementType = RequirementType.valueOf(requirementType);
        }
    }

    /**
     * Missing description at method getProvisionUsageType.
     *
     * @return the ProvisionUsageType.
     */
    public ProvisionUsageType getProvisionUsageType() {
        return this.provisionUsageType;
    }

    /**
     * Missing description at method setProvisionUsageType.
     *
     * @param provisionUsageType the ProvisionUsageType.
     */
    public void setProvisionUsageType(ProvisionUsageType provisionUsageType) {
        this.provisionUsageType = provisionUsageType;
    }

    /**
     * Missing description at method setProvisionUsageType.
     *
     * @param provisionUsageType the String.
     */
    public void setProvisionUsageType(String provisionUsageType) {
        if ((provisionUsageType == null)) {
            this.provisionUsageType = null;
        } else {
            this.provisionUsageType = ProvisionUsageType.valueOf(provisionUsageType);
        }
    }

    /**
     * Missing description at method getCharacteristicType.
     *
     * @return the ProvisionCharacteristicType.
     */
    public ProvisionCharacteristicType getCharacteristicType() {
        return this.characteristicType;
    }

    /**
     * Missing description at method setCharacteristicType.
     *
     * @param characteristicType the ProvisionCharacteristicType.
     */
    public void setCharacteristicType(ProvisionCharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
    }

    /**
     * Missing description at method setCharacteristicType.
     *
     * @param characteristicType the String.
     */
    public void setCharacteristicType(String characteristicType) {
        if ((characteristicType == null)) {
            this.characteristicType = null;
        } else {
            this.characteristicType = ProvisionCharacteristicType.valueOf(characteristicType);
        }
    }

    /**
     * The count of units specified by periodType
     *
     * @return the Number.
     */
    public Number getUsagePeriodCount() {
        return this.usagePeriodCount;
    }

    /**
     * The count of units specified by periodType
     *
     * @param usagePeriodCount the Number.
     */
    public void setUsagePeriodCount(Number usagePeriodCount) {
        this.usagePeriodCount = usagePeriodCount;
    }

    /**
     * The count of units specified by periodType
     *
     * @param usagePeriodCount the Integer.
     */
    public void setUsagePeriodCount(Integer usagePeriodCount) {
        if ((this.usagePeriodCount == null)) {
            if ((usagePeriodCount == null)) {
                return;
            }
            this.usagePeriodCount = new Number();
        }
        this.usagePeriodCount.setValue(usagePeriodCount);
    }

    /**
     * The type of period units
     *
     * @return the PeriodType.
     */
    public PeriodType getPeriodType() {
        return this.periodType;
    }

    /**
     * The type of period units
     *
     * @param periodType the PeriodType.
     */
    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    /**
     * The type of period units
     *
     * @param periodType the String.
     */
    public void setPeriodType(String periodType) {
        if ((periodType == null)) {
            this.periodType = null;
        } else {
            this.periodType = PeriodType.valueOf(periodType);
        }
    }

    /**
     * The category of the profilion assignment
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
     * The category of the profilion assignment
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
     * Missing description at method setCharacteristic.
     *
     * @param characteristic the ProvisionCharacteristic.
     */
    public void setCharacteristic(ProvisionCharacteristic characteristic) {
        this.characteristic = characteristic;
    }

    /**
     * Missing description at method getCharacteristic.
     *
     * @return the ProvisionCharacteristic.
     */
    public ProvisionCharacteristic getCharacteristic() {
        return this.characteristic;
    }

    /**
     * Missing description at method getHistoryList.
     *
     * @return the NabuccoList<ProvisionAssignmentHistory>.
     */
    public NabuccoList<ProvisionAssignmentHistory> getHistoryList() {
        if ((this.historyList == null)) {
            this.historyList = new NabuccoListImpl<ProvisionAssignmentHistory>(NabuccoCollectionState.INITIALIZED);
        }
        return this.historyList;
    }

    /**
     * Missing description at method getSourceType.
     *
     * @return the ProvisionSourceType.
     */
    public ProvisionSourceType getSourceType() {
        return this.sourceType;
    }

    /**
     * Missing description at method setSourceType.
     *
     * @param sourceType the ProvisionSourceType.
     */
    public void setSourceType(ProvisionSourceType sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * Missing description at method setSourceType.
     *
     * @param sourceType the String.
     */
    public void setSourceType(String sourceType) {
        if ((sourceType == null)) {
            this.sourceType = null;
        } else {
            this.sourceType = ProvisionSourceType.valueOf(sourceType);
        }
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProvisionAssignment.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProvisionAssignment.class).getAllProperties();
    }

    /**
     * Getter for the LevelCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getLevelCodePath() {
        return new CodePath(LEVEL_CODEPATH);
    }

    /**
     * Getter for the CategoryCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getCategoryCodePath() {
        return new CodePath(CATEGORY_CODEPATH);
    }
}
