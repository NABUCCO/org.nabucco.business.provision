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
package org.nabucco.business.provision.impl.service.search;

import java.util.List;

import org.nabucco.business.provision.facade.datatype.Equipment;
import org.nabucco.business.provision.facade.message.EquipmentListMsg;
import org.nabucco.business.provision.facade.message.search.EquipmentSearchRq;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * 
 * SearchEquipmentServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class SearchEquipmentServiceHandlerImpl extends SearchEquipmentServiceHandler {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected EquipmentListMsg searchEquipment(EquipmentSearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT d FROM Equipment d");

        try {
            NabuccoQuery<Equipment> query = super.getPersistenceManager().createQuery(queryString.toString());

            List<Equipment> resultList;
            resultList = query.getResultList();

            EquipmentListMsg response = new EquipmentListMsg();
            response.getEquipmentList().addAll(resultList);
            return response;

        } catch (Exception e) {
            throw new SearchException(e);
        }

    }

}
