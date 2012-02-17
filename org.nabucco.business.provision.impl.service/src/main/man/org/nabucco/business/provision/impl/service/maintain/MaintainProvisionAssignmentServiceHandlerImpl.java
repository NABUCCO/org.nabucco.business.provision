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
package org.nabucco.business.provision.impl.service.maintain;

import org.nabucco.business.provision.facade.datatype.Equipment;
import org.nabucco.business.provision.facade.datatype.ProvisionAssignment;
import org.nabucco.business.provision.facade.datatype.ProvisionAssignmentHistory;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.business.provision.facade.datatype.ProvisionGroup;
import org.nabucco.business.provision.facade.datatype.Qualification;
import org.nabucco.business.provision.facade.datatype.Skill;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentMsg;
import org.nabucco.business.provision.impl.service.maintain.support.ProvisionCharacteristicMaintainServiceSupport;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * MaintainProvisionAssignmentServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class MaintainProvisionAssignmentServiceHandlerImpl extends MaintainProvisionAssignmentServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProvisionAssignmentMsg maintainProvisionAssignment(ProvisionAssignmentMsg msg) throws MaintainException {

        ProvisionAssignment assignment = msg.getProvisionAssignment();
        try {
            if (assignment.getDatatypeState() == DatatypeState.DELETED) {
                assignment = this.delete(assignment);
            } else {
                assignment = this.update(assignment);
            }
        } catch (PersistenceException e) {
            throw new MaintainException("Error maintaining ProvisionAssignment.", e);
        }

        ProvisionAssignmentMsg response = new ProvisionAssignmentMsg();
        response.setProvisionAssignment(assignment);
        return response;
    }

    private ProvisionAssignment delete(ProvisionAssignment assignment) throws PersistenceException {

        NabuccoList<ProvisionAssignmentHistory> historyList = assignment.getHistoryList();
        for (ProvisionAssignmentHistory historyEntry : historyList) {
            historyEntry.setDatatypeState(DatatypeState.DELETED);
        }
        this.getPersistenceManager().persist(historyList);

        ProvisionCharacteristic characteristic = assignment.getCharacteristic();

        ProvisionAssignment deletedAssignment = this.getPersistenceManager().persist(assignment);

        if (this.isCharacteristicInCompositionRelation(characteristic)) {
            characteristic.setDatatypeState(DatatypeState.DELETED);

            try {
                ProvisionCharacteristicMaintainServiceSupport support = new ProvisionCharacteristicMaintainServiceSupport(
                        this.getPersistenceManager());
                support.maintain(characteristic);
                assignment.setCharacteristic(null);
            } catch (MaintainException e) {
                throw new PersistenceException("Cannot maintain provision assignment", e);
            }
        }

        return deletedAssignment;
    }

    private ProvisionAssignment update(ProvisionAssignment assignment) throws PersistenceException {

        ProvisionCharacteristic characteristic = assignment.getCharacteristic();

        // Set characteristic type automatically according to the assigned characteristic
        ProvisionCharacteristicType characteristicType = characteristic.getCharacteristicType();
        assignment.setCharacteristicType(characteristicType);
        //

        if (this.isCharacteristicInCompositionRelation(characteristic)) {
            try {
                ProvisionCharacteristicMaintainServiceSupport support = new ProvisionCharacteristicMaintainServiceSupport(
                        this.getPersistenceManager());
                assignment.setCharacteristic(support.maintain(characteristic));
            } catch (MaintainException e) {
                throw new PersistenceException("Cannot maintain provision assignment", e);
            }
        }

        ProvisionAssignment updatedAssignment = this.getPersistenceManager().persist(assignment);

        NabuccoCollectionAccessor collectionAccessor = NabuccoCollectionAccessor.getInstance();
        NabuccoList<ProvisionAssignmentHistory> historyList = assignment.getHistoryList();
        // TODO Only one new entry should be added
        // TODO Mayby the new entry is generated and added here!
        this.getPersistenceManager().persist(collectionAccessor.getAssignedList(historyList));

        return updatedAssignment;
    }

    private boolean isCharacteristicInCompositionRelation(ProvisionCharacteristic characteristic) {
        return !(characteristic instanceof Equipment)
                && !(characteristic instanceof Skill) && !(characteristic instanceof Qualification)
                && !(characteristic instanceof ProvisionGroup);
    }
}
