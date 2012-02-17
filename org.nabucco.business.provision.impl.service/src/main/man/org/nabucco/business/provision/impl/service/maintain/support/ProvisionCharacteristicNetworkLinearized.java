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

import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristic;
import org.nabucco.business.provision.facade.datatype.ProvisionRelation;

/**
 * 
 * ProvisionCharacteristicNetworkLinearized
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public final class ProvisionCharacteristicNetworkLinearized {

    private List<ProvisionCharacteristic> characteristics;

    private List<ProvisionRelation> relations;

    public ProvisionCharacteristicNetworkLinearized() {
        characteristics = new ArrayList<ProvisionCharacteristic>();
        relations = new ArrayList<ProvisionRelation>();
    }

    public List<ProvisionCharacteristic> getCharacteristics() {
        return characteristics;
    }

    public List<ProvisionRelation> getRelations() {
        return relations;
    }

    public void addRelation(ProvisionRelation relation) {
        relations.add(relation);
    }

    public void addCharacteristic(ProvisionCharacteristic characteristic) {
        characteristics.add(characteristic);
    }

}
