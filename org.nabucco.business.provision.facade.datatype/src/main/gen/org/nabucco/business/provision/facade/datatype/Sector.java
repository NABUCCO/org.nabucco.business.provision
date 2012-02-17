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
 * Sector
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-01-10
 */
public class Sector extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    public static final String SECTOR = "sector";

    private Code sector;

    private Long sectorRefId;

    protected static final String SECTOR_CODEPATH = "nabucco.business.sector";

    /** Constructs a new Sector instance. */
    public Sector() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the Sector.
     */
    protected void cloneObject(Sector clone) {
        super.cloneObject(clone);
        if ((this.getSector() != null)) {
            clone.setSector(this.getSector().cloneObject());
        }
        if ((this.getSectorRefId() != null)) {
            clone.setSectorRefId(this.getSectorRefId());
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
        propertyMap.put(SECTOR, PropertyDescriptorSupport.createDatatype(SECTOR, Code.class, 3,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, SECTOR_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(Sector.getPropertyDescriptor(SECTOR), this.getSector(), this.sectorRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SECTOR) && (property.getType() == Code.class))) {
            this.setSector(((Code) property.getInstance()));
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
        final Sector other = ((Sector) obj);
        if ((this.sector == null)) {
            if ((other.sector != null))
                return false;
        } else if ((!this.sector.equals(other.sector)))
            return false;
        if ((this.sectorRefId == null)) {
            if ((other.sectorRefId != null))
                return false;
        } else if ((!this.sectorRefId.equals(other.sectorRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.sector == null) ? 0 : this.sector.hashCode()));
        result = ((PRIME * result) + ((this.sectorRefId == null) ? 0 : this.sectorRefId.hashCode()));
        return result;
    }

    @Override
    public Sector cloneObject() {
        Sector clone = new Sector();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setSector.
     *
     * @param sector the Code.
     */
    public void setSector(Code sector) {
        this.sector = sector;
        if ((sector != null)) {
            this.setSectorRefId(sector.getId());
        } else {
            this.setSectorRefId(null);
        }
    }

    /**
     * Missing description at method getSector.
     *
     * @return the Code.
     */
    public Code getSector() {
        return this.sector;
    }

    /**
     * Getter for the SectorRefId.
     *
     * @return the Long.
     */
    public Long getSectorRefId() {
        return this.sectorRefId;
    }

    /**
     * Setter for the SectorRefId.
     *
     * @param sectorRefId the Long.
     */
    public void setSectorRefId(Long sectorRefId) {
        this.sectorRefId = sectorRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Sector.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Sector.class).getAllProperties();
    }

    /**
     * Getter for the SectorCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getSectorCodePath() {
        return new CodePath(SECTOR_CODEPATH);
    }
}
