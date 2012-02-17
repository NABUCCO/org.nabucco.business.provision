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

import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionGroup;
import org.nabucco.business.provision.facade.datatype.ProvisionRelation;
import org.nabucco.business.provision.facade.message.ProvisionGroupMsg;
import org.nabucco.business.provision.facade.message.UnassignChildMsg;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;

public class UnassignChildServiceHandlerImpl extends UnassignChildServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProvisionGroupMsg unassignChild(UnassignChildMsg msg) throws MaintainException {

        ProvisionGroup parentGroup = msg.getParentGroup();
        ProvisionCharacteristic child = msg.getChild();

        Iterator<ProvisionRelation> iterator = parentGroup.getRelationList().iterator();
        while (iterator.hasNext()) {
            ProvisionRelation relation = iterator.next();
            if (relation.getCharacteristic().getId().equals(child.getId())) {
                relation.setDatatypeState(DatatypeState.DELETED);
                // iterator.remove();
                break;
            }
        }
        try {
            PersistenceManager persistenceManager = this.getPersistenceManager();
            parentGroup.setDatatypeState(DatatypeState.MODIFIED);
            persistenceManager.persist(parentGroup.getRelationList());
            persistenceManager.persist(parentGroup);
            parentGroup = persistenceManager.find(parentGroup);
            ProvisionGroupMsg result = new ProvisionGroupMsg();
            result.setProvisionGroup(parentGroup);
            return result;
        } catch (PersistenceException e) {
            throw new MaintainException("Failed to unassign child from ProvionGroup", e);
        }
    }

}
