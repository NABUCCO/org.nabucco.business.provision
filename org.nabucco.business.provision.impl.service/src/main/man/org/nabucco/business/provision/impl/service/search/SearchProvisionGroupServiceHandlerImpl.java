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

import org.nabucco.business.provision.facade.datatype.ProvisionGroup;
import org.nabucco.business.provision.facade.datatype.ProvisionGroupCharacteristicType;
import org.nabucco.business.provision.facade.message.ProvisionGroupListMsg;
import org.nabucco.business.provision.facade.message.search.ProvisionGroupSearchRq;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * 
 * SearchProvisionGroupServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class SearchProvisionGroupServiceHandlerImpl extends SearchProvisionGroupServiceHandler {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected ProvisionGroupListMsg searchProvisionGroup(ProvisionGroupSearchRq msg) throws SearchException {

        try {
            NabuccoQuery<ProvisionGroup> query = null;
            List<ProvisionGroup> resultList = null;

            // determine searchParameter
            Flag root = msg.getRoot();
            ProvisionGroupCharacteristicType provisionGroupcharacteristicType = msg.getGroupCharacteristicType();

            StringBuilder queryString = new StringBuilder();
            queryString.append("SELECT pg FROM ProvisionGroup pg");
            queryString.append(" WHERE true = true");

            if ((root != null) && (root.getValue() != null) && root.getValue()) {
                queryString.append(" AND pg.id NOT IN (SELECT pr.characteristic.id FROM ProvisionRelation pr)");
            }
            if (provisionGroupcharacteristicType != null) {
                queryString.append(" AND pg.groupCharacteristicType = :type");
            }
            if (msg.getFunctionalId() != null) {
                queryString.append(" AND pg.functionalId = :functionalId");
            }

            query = super.getPersistenceManager().createQuery(queryString.toString());

            if (provisionGroupcharacteristicType != null) {
                query.setParameter("type", provisionGroupcharacteristicType);
            }
            if (msg.getFunctionalId() != null) {
                query.setParameter("functionalId", msg.getFunctionalId());
            }

            resultList = query.getResultList();

            ProvisionGroupListMsg response = new ProvisionGroupListMsg();
            response.getProvisionGroupList().addAll(resultList);
            return response;

        } catch (Exception e) {
            throw new SearchException(e);
        }
    }

}
