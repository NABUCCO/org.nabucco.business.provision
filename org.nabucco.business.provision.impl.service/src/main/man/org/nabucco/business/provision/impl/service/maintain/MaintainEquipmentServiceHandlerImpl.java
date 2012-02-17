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
import org.nabucco.business.provision.facade.message.EquipmentMsg;
import org.nabucco.business.provision.impl.service.maintain.support.ProvisionCharacteristicMaintainServiceSupport;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * 
 * MaintainEquipmentServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class MaintainEquipmentServiceHandlerImpl extends MaintainEquipmentServiceHandler {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected EquipmentMsg maintainEquipment(EquipmentMsg msg) throws MaintainException {

        ProvisionCharacteristicMaintainServiceSupport support = new ProvisionCharacteristicMaintainServiceSupport(
                getPersistenceManager());
        Equipment equipment = (Equipment) support.maintain(msg.getEquipment());

        EquipmentMsg response = new EquipmentMsg();
        response.setEquipment(equipment);
        return response;
    }

}
