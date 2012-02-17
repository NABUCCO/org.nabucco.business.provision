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

import java.util.Iterator;

import org.nabucco.business.provision.facade.datatype.Equipment;
import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionGroup;
import org.nabucco.business.provision.facade.datatype.ProvisionRelation;
import org.nabucco.business.provision.facade.datatype.Qualification;
import org.nabucco.business.provision.facade.datatype.Skill;
import org.nabucco.business.provision.facade.message.MoveProvisionCharacteristicMsg;
import org.nabucco.business.provision.facade.message.ProvisionGroupMsg;
import org.nabucco.business.provision.impl.service.maintain.support.ProvisionCharacteristicMaintainServiceSupport;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.CodeFacade;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.datatype.relation.RelationType;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;

/**
 * MoveProvisionCharacteristicServiceHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class MoveProvisionCharacteristicServiceHandlerImpl extends MoveProvisionCharacteristicServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProvisionGroupMsg moveProvisionCharacteristic(MoveProvisionCharacteristicMsg msg)
            throws MaintainException {
        ProvisionGroup parentGroup = msg.getParentGroup();
        ProvisionCharacteristic child = msg.getChild();
        ProvisionGroup targetGroup = msg.getTargetGroup();
        ProvisionGroupMsg result = new ProvisionGroupMsg();
        PersistenceManager persistenceManager = this.getPersistenceManager();

        // Remove from parent group if no root.
        if (parentGroup != null) {
            Iterator<ProvisionRelation> iterator = parentGroup.getRelationList().iterator();
            while (iterator.hasNext()) {
                ProvisionRelation relation = iterator.next();
                if (relation.getCharacteristic().getId().equals(child.getId())) {
                    relation.setDatatypeState(DatatypeState.DELETED);
                    break;
                }
            }
            try {
                parentGroup.setDatatypeState(DatatypeState.MODIFIED);
                persistenceManager.persist(parentGroup.getRelationList());
                persistenceManager.persist(parentGroup);
                parentGroup = persistenceManager.find(parentGroup);
                result.setProvisionGroup(parentGroup);
            } catch (PersistenceException e) {
                throw new MaintainException("Failed to unassign child from ProvionGroup", e);
            } catch (Exception e) {
                throw new MaintainException("Failed to unassign child from ProvionGroup", e);
            }
        }

        // Assign to new parent
        ProvisionGroup groupToBeStored = targetGroup;
        try {
            if (targetGroup != null) {

                ProvisionRelation relation = new ProvisionRelation();
                relation.setDatatypeState(DatatypeState.INITIALIZED);
                relation.setCharacteristic(child);
                relation.setRelationType(RelationType.HAS);

                String relationName;
                if (child instanceof ProvisionGroup) {
                    relationName = "provisiongroup";
                } else if (child instanceof Skill) {
                    relationName = "skill";
                } else if (child instanceof Equipment) {
                    relationName = "equipment";
                } else if (child instanceof Qualification) {
                    relationName = "qualification";
                } else {
                    throw new UnsupportedOperationException("Unsupported provision characteristic!");
                }
                relation.setFunctionalType(CodeFacade.getInstance().getCode(
                        ProvisionRelation.getFunctionalTypeCodePath(), new Name(relationName)));

                targetGroup.getRelationList().add(relation);
                targetGroup.setDatatypeState(DatatypeState.MODIFIED);

            } else { // Must be a root group
                groupToBeStored = (ProvisionGroup) child;
            }
            ProvisionCharacteristicMaintainServiceSupport maintainServiceSupport = new ProvisionCharacteristicMaintainServiceSupport(
                    persistenceManager);
            NabuccoCollectionAccessor.getInstance().loadCollection(groupToBeStored.getRelationList());
            maintainServiceSupport.maintainGroup(groupToBeStored);

            return result;
        } catch (Exception e) {
            throw new MaintainException("Failed to unassign child from ProvionGroup", e);
        }
    }

}
