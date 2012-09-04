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
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ProvisionAssignmentHistory
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProvisionAssignmentHistory extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "m1,1;", "m0,1;",
            "m0,1;" };

    public static final String DATEFROM = "dateFrom";

    public static final String DATETILL = "dateTill";

    public static final String CHARACTERISTICTYPE = "characteristicType";

    public static final String ACTION = "action";

    public static final String LEVEL = "level";

    private Date dateFrom;

    private Date dateTill;

    private ProvisionCharacteristicType characteristicType;

    private Code action;

    private Long actionRefId;

    protected static final String ACTION_CODEPATH = "nabucco.business.provision.action";

    private Code level;

    private Long levelRefId;

    protected static final String LEVEL_CODEPATH = "nabucco.business.provision.level";

    /** Constructs a new ProvisionAssignmentHistory instance. */
    public ProvisionAssignmentHistory() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProvisionAssignmentHistory.
     */
    protected void cloneObject(ProvisionAssignmentHistory clone) {
        super.cloneObject(clone);
        if ((this.getDateFrom() != null)) {
            clone.setDateFrom(this.getDateFrom().cloneObject());
        }
        if ((this.getDateTill() != null)) {
            clone.setDateTill(this.getDateTill().cloneObject());
        }
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getAction() != null)) {
            clone.setAction(this.getAction().cloneObject());
        }
        if ((this.getActionRefId() != null)) {
            clone.setActionRefId(this.getActionRefId());
        }
        if ((this.getLevel() != null)) {
            clone.setLevel(this.getLevel().cloneObject());
        }
        if ((this.getLevelRefId() != null)) {
            clone.setLevelRefId(this.getLevelRefId());
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
        propertyMap.put(DATEFROM,
                PropertyDescriptorSupport.createBasetype(DATEFROM, Date.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(DATETILL,
                PropertyDescriptorSupport.createBasetype(DATETILL, Date.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(CHARACTERISTICTYPE, PropertyDescriptorSupport.createEnumeration(CHARACTERISTICTYPE,
                ProvisionCharacteristicType.class, 5, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(ACTION, PropertyDescriptorSupport.createDatatype(ACTION, Code.class, 6,
                PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPONENT, ACTION_CODEPATH));
        propertyMap.put(LEVEL, PropertyDescriptorSupport.createDatatype(LEVEL, Code.class, 7, PROPERTY_CONSTRAINTS[4],
                false, PropertyAssociationType.COMPONENT, LEVEL_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProvisionAssignmentHistory.getPropertyDescriptor(DATEFROM), this.dateFrom,
                null));
        properties.add(super.createProperty(ProvisionAssignmentHistory.getPropertyDescriptor(DATETILL), this.dateTill,
                null));
        properties.add(super.createProperty(ProvisionAssignmentHistory.getPropertyDescriptor(CHARACTERISTICTYPE),
                this.getCharacteristicType(), null));
        properties.add(super.createProperty(ProvisionAssignmentHistory.getPropertyDescriptor(ACTION), this.getAction(),
                this.actionRefId));
        properties.add(super.createProperty(ProvisionAssignmentHistory.getPropertyDescriptor(LEVEL), this.getLevel(),
                this.levelRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(DATEFROM) && (property.getType() == Date.class))) {
            this.setDateFrom(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DATETILL) && (property.getType() == Date.class))) {
            this.setDateTill(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CHARACTERISTICTYPE) && (property.getType() == ProvisionCharacteristicType.class))) {
            this.setCharacteristicType(((ProvisionCharacteristicType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ACTION) && (property.getType() == Code.class))) {
            this.setAction(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(LEVEL) && (property.getType() == Code.class))) {
            this.setLevel(((Code) property.getInstance()));
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
        final ProvisionAssignmentHistory other = ((ProvisionAssignmentHistory) obj);
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
        if ((this.characteristicType == null)) {
            if ((other.characteristicType != null))
                return false;
        } else if ((!this.characteristicType.equals(other.characteristicType)))
            return false;
        if ((this.action == null)) {
            if ((other.action != null))
                return false;
        } else if ((!this.action.equals(other.action)))
            return false;
        if ((this.actionRefId == null)) {
            if ((other.actionRefId != null))
                return false;
        } else if ((!this.actionRefId.equals(other.actionRefId)))
            return false;
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
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.dateFrom == null) ? 0 : this.dateFrom.hashCode()));
        result = ((PRIME * result) + ((this.dateTill == null) ? 0 : this.dateTill.hashCode()));
        result = ((PRIME * result) + ((this.characteristicType == null) ? 0 : this.characteristicType.hashCode()));
        result = ((PRIME * result) + ((this.action == null) ? 0 : this.action.hashCode()));
        result = ((PRIME * result) + ((this.actionRefId == null) ? 0 : this.actionRefId.hashCode()));
        result = ((PRIME * result) + ((this.level == null) ? 0 : this.level.hashCode()));
        result = ((PRIME * result) + ((this.levelRefId == null) ? 0 : this.levelRefId.hashCode()));
        return result;
    }

    @Override
    public ProvisionAssignmentHistory cloneObject() {
        ProvisionAssignmentHistory clone = new ProvisionAssignmentHistory();
        this.cloneObject(clone);
        return clone;
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
     * Missing description at method setAction.
     *
     * @param action the Code.
     */
    public void setAction(Code action) {
        this.action = action;
        if ((action != null)) {
            this.setActionRefId(action.getId());
        } else {
            this.setActionRefId(null);
        }
    }

    /**
     * Missing description at method getAction.
     *
     * @return the Code.
     */
    public Code getAction() {
        return this.action;
    }

    /**
     * Getter for the ActionRefId.
     *
     * @return the Long.
     */
    public Long getActionRefId() {
        return this.actionRefId;
    }

    /**
     * Setter for the ActionRefId.
     *
     * @param actionRefId the Long.
     */
    public void setActionRefId(Long actionRefId) {
        this.actionRefId = actionRefId;
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
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProvisionAssignmentHistory.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProvisionAssignmentHistory.class).getAllProperties();
    }

    /**
     * Getter for the ActionCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getActionCodePath() {
        return new CodePath(ACTION_CODEPATH);
    }

    /**
     * Getter for the LevelCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getLevelCodePath() {
        return new CodePath(LEVEL_CODEPATH);
    }
}
