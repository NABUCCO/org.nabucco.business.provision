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

import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionRelation;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollection;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;

/**
 * 
 * ProvisionCharacteristicNetworkLinearizer
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProvisionCharacteristicNetworkLinearizer {

    public ProvisionCharacteristicNetworkLinearized linearizeNetwork(ProvisionCharacteristic characteristic) {

        ProvisionCharacteristicNetworkLinearized networkLinearized = new ProvisionCharacteristicNetworkLinearized();

        linearize(characteristic, networkLinearized);

        return networkLinearized;
    }

    private void linearize(ProvisionCharacteristic sourceCharacteristic,
            ProvisionCharacteristicNetworkLinearized networkLinearized) {

        networkLinearized.addCharacteristic(sourceCharacteristic);

        NabuccoCollection<ProvisionRelation> list = sourceCharacteristic.getRelationList();

        // skip if list is lazy loaded
        if (list.getState() == NabuccoCollectionState.LAZY) {
            return;
        }

        for (ProvisionRelation relation : list) {
            networkLinearized.addRelation(relation);

            ProvisionCharacteristic targetCharacteristic = relation.getCharacteristic();
            if (!networkLinearized.getCharacteristics().contains(targetCharacteristic)) {
                linearize(targetCharacteristic, networkLinearized);
            }
        }
    }

}
