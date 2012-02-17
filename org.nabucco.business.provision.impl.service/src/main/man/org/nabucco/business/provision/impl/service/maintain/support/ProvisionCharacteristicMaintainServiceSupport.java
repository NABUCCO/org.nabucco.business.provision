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
package org.nabucco.business.provision.impl.service.maintain.support;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.business.provision.facade.datatype.ActivityArea;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionGroup;
import org.nabucco.business.provision.facade.datatype.ProvisionRelation;
import org.nabucco.business.provision.facade.datatype.Sector;
import org.nabucco.business.provision.facade.datatype.WorkExperience;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;

/**
 * 
 * MaintainProvisionCharacteristicServiceSupport
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProvisionCharacteristicMaintainServiceSupport {

    private static NabuccoLogger logger = NabuccoLoggingFactory.getInstance().getLogger(
            ProvisionCharacteristicMaintainServiceSupport.class);

    private PersistenceManager persistenceManager;

    public ProvisionCharacteristicMaintainServiceSupport(PersistenceManager persistenceManager)
            throws MaintainException {
        this.persistenceManager = persistenceManager;
    }

    public ProvisionCharacteristic maintain(ProvisionCharacteristic characteristic) throws MaintainException {
        // Check if the datatype is in a valid state for maintaining
        switch (characteristic.getDatatypeState()) {
        case INITIALIZED:
        case MODIFIED:
        case DELETED:
        case PERSISTENT:
            ProvisionCharacteristic maintainedCharacteristic;
            if (characteristic instanceof ProvisionGroup) {
                maintainedCharacteristic = this.maintainGroup((ProvisionGroup) characteristic);
            } else {
                maintainedCharacteristic = this.maintainCharacteristic(characteristic);
            }
            return maintainedCharacteristic;
        default:
            throw new MaintainException("Invalid datatype state!");
        }
    }

    public ProvisionGroup maintainGroup(ProvisionGroup group) throws MaintainException {
        logger.debug("Maintaining provision group.");

        if (group.getRelationList().getState().equals(NabuccoCollectionState.LAZY)) {
            throw new MaintainException("Cannot maintain an unresolved group!");
        }

        ProvisionGroup maintainedGroup;

        switch (group.getDatatypeState()) {

        case INITIALIZED:
            maintainedGroup = (ProvisionGroup) this.maintainCharacteristic(group);
            break;

        case MODIFIED:
            maintainedGroup = this.maintainModifiedGroup(group);
            break;

        case PERSISTENT:
            maintainedGroup = this.maintainModifiedGroup(group);
            break;

        case DELETED:
            if (group.getRelationList().isEmpty()) {
                maintainedGroup = (ProvisionGroup) this.maintainCharacteristic(group);
            } else { // We don't allow to delete a group with relations
                throw new MaintainException("Cannot delete a provision group with relations!");
            }
            break;

        default:
            throw new MaintainException("Unsupported datatype state!");
        }

        return maintainedGroup;
    }

    private ProvisionGroup maintainModifiedGroup(ProvisionGroup group) throws MaintainException {

        try {
            logger.debug("Maintaining modified provision group.");

            NabuccoList<ProvisionRelation> relationList = group.getRelationList();

            logger.debug("Create new relations.");
            for (ProvisionRelation relation : relationList.getAssignedElements()) {
                ProvisionCharacteristic characteristic = relation.getCharacteristic();
                this.maintainCharacteristic(characteristic);
                this.persistenceManager.persist(relation);
            }

            logger.debug("Remove unassigned relations.");
            for (ProvisionRelation relation : relationList.getUnassignedElements()) {
                ProvisionCharacteristic characteristic = relation.getCharacteristic();

                relation.setDatatypeState(DatatypeState.DELETED);
                relation.setCharacteristic(null);
                this.persistenceManager.persist(relation);

                characteristic.setDatatypeState(DatatypeState.DELETED);
                this.maintainCharacteristic(characteristic);

            }

        } catch (PersistenceException e) {
            throw new MaintainException("Error maintaining provision group.", e);
        }

        return (ProvisionGroup) this.maintainCharacteristic(group);
    }

    private ProvisionCharacteristic maintainCharacteristic(ProvisionCharacteristic characteristic)
            throws MaintainException {
        logger.debug("...maintaining provision characteristic...");

        if (characteristic instanceof WorkExperience) {
            return this.maintainWorkExperience((WorkExperience) characteristic);
        }

        try {
            characteristic = this.persistenceManager.persist(characteristic);
            characteristic.getRelationList().size();
            return characteristic;
        } catch (PersistenceException e) {
            throw new MaintainException("Failed to maintain provision characteristic!", e);
        }
    }

    private WorkExperience maintainWorkExperience(WorkExperience workExperience) throws MaintainException {
        logger.debug("...maintaining work experience.");
        try {
            if (workExperience.getDatatypeState() == DatatypeState.DELETED) {

                List<Sector> sectorsToDelete = new ArrayList<Sector>();
                for (Sector sector : workExperience.getSectorList()) {
                    sector.setDatatypeState(DatatypeState.DELETED);
                    sectorsToDelete.add(sector);
                }

                List<ActivityArea> activityAreasToDelete = new ArrayList<ActivityArea>();
                for (ActivityArea activityArea : workExperience.getActivityAreaList()) {
                    activityArea.setDatatypeState(DatatypeState.DELETED);
                    activityAreasToDelete.add(activityArea);
                }

                workExperience = this.persistenceManager.persist(workExperience);

                this.persistenceManager.persist(sectorsToDelete);
                this.persistenceManager.persist(activityAreasToDelete);

            } else {

                // TODO: fix that workaround
                NabuccoCollectionAccessor nbcCollectionAccessor = NabuccoCollectionAccessor.getInstance();

                List<Sector> unassignedSectorList = nbcCollectionAccessor.getUnassignedList(workExperience
                        .getSectorList());

                List<ActivityArea> unassignedActivityAreaList = nbcCollectionAccessor.getUnassignedList(workExperience
                        .getActivityAreaList());

                this.persistenceManager.persist(workExperience.getSectorList());
                this.persistenceManager.persist(workExperience.getActivityAreaList());
                workExperience = this.persistenceManager.persist(workExperience);

                if (unassignedSectorList.size() > 0) {
                    this.persistenceManager.persist(unassignedSectorList);
                }
                if (unassignedActivityAreaList.size() > 0) {
                    this.persistenceManager.persist(unassignedActivityAreaList);
                }

            }

            return workExperience;
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining WorkExperience.", pe);
        }
    }

}
