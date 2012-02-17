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
package org.nabucco.business.provision.impl.service.match;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.business.provision.facade.datatype.ProvisionCharacteristicType;
import org.nabucco.business.provision.facade.datatype.ProvisionUsageType;
import org.nabucco.business.provision.facade.exception.ProvisionMatchException;
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRq;
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRs;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * 
 * MatchServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class MatchServiceHandlerImpl extends MatchServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final NabuccoLogger LOGGER = NabuccoLoggingFactory.getInstance().getLogger(
            MatchServiceHandlerImpl.class);

    @Override
    protected ProvisionMatchRs match(ProvisionMatchRq msg) throws ProvisionMatchException {

        try {
            List<Long> providerIds = new ArrayList<Long>();
            for (Identifier targetId : msg.getTargetIdList()) {
                providerIds.add(targetId.getValue());
            }

            LOGGER.debug("Possible provider list is " + providerIds);

            if (providerIds.isEmpty()) {
                return new ProvisionMatchRs();
            }

            // ------------------------------------------------------------------------------

            // get mandatory provision group ids
            List<FunctionalIdentifier> provisionGroupFunctionalIds = getRequiredProvisionGroupFunctionalIds(msg);

            // get all person for each provision id
            matchProvisionGroups(providerIds, provisionGroupFunctionalIds);

            // ------------------------------------------------------------------------------

            if (providerIds.isEmpty()) {
                LOGGER.debug("Skip next operations due to no remaining provider.");
                return new ProvisionMatchRs();
            }

            // ------------------------------------------------------------------------------

            // get mandatory provision ids
            List<Long> provisionIds = getRequiredProvisionIds(msg);

            // get all person for each provision id
            matchProvisions(providerIds, provisionIds);

            // -------------------------------------------------------------------

            LOGGER.debug("Possible provider list was " + msg.getTargetIdList());
            LOGGER.debug("Real provider list is " + providerIds);

            ProvisionMatchRs response = new ProvisionMatchRs();
            for (Long providerId : providerIds) {
                response.getProviderIdList().add(new Identifier(providerId));
            }

            return response;

        } catch (Exception e) {
            throw new ProvisionMatchException(e);
        }
    }

    private List<FunctionalIdentifier> getRequiredProvisionGroupFunctionalIds(ProvisionMatchRq msg) throws Exception {

        List<FunctionalIdentifier> provisionGroupFunctionalIds = null;

        // if source id is not null then the required provision groups are determined by it
        // else the required provision groups provided by the request msg are used

        if (msg.getSourceId() != null) {
            LOGGER.debug("Start searching for necessary provision group functional ids.");

            StringBuilder queryString = new StringBuilder();
            queryString
                    .append("SELECT cr.target.characteristic.functionalId FROM ProvisionAssignmentComponentRelation cr");
            queryString.append(" WHERE cr.sourceId = :sourceId");
            queryString.append(" AND cr.target.provisionUsageType = :provisionUsageType");
            queryString.append(" AND cr.target.characteristicType = :characteristicType");

            NabuccoQuery<FunctionalIdentifier> query0 = super.getPersistenceManager().createQuery(
                    queryString.toString());
            query0.setParameter("sourceId", msg.getSourceId());
            query0.setParameter("provisionUsageType", ProvisionUsageType.REQUIRED);
            query0.setParameter("characteristicType", ProvisionCharacteristicType.PROVISION_GROUP);

            provisionGroupFunctionalIds = query0.getResultList();

        } else {
            LOGGER.debug("Using provided necessary provision group functional ids.");
            provisionGroupFunctionalIds = msg.getProvisionGroupFunctionalIdList();
        }

        LOGGER.debug("Found follwing necessary provision group functional ids: " + provisionGroupFunctionalIds);

        return provisionGroupFunctionalIds;
    }

    private List<Long> getRequiredProvisionIds(ProvisionMatchRq msg) throws Exception {

        List<Long> provisionIds = null;

        // if source id is not null then the required provisions are determined by it
        // else the required provisions provided by the request msg are used

        if (msg.getSourceId() != null) {
            LOGGER.debug("Start searching for necessary provision ids.");

            StringBuilder queryString = new StringBuilder();
            queryString.append("SELECT cr.target.characteristic.id FROM ProvisionAssignmentComponentRelation cr");
            queryString.append(" WHERE cr.sourceId = :sourceId");
            queryString.append(" AND cr.target.provisionUsageType = :provisionUsageType");
            queryString.append(" AND (cr.target.characteristicType = :characteristicType1");
            queryString.append(" OR cr.target.characteristicType = :characteristicType2)");

            NabuccoQuery<Long> query1 = super.getPersistenceManager().createQuery(queryString.toString());
            query1.setParameter("sourceId", msg.getSourceId());
            query1.setParameter("provisionUsageType", ProvisionUsageType.REQUIRED);
            query1.setParameter("characteristicType1", ProvisionCharacteristicType.SKILL);
            query1.setParameter("characteristicType2", ProvisionCharacteristicType.QUALIFICATION);

            provisionIds = query1.getResultList();

        } else {
            LOGGER.debug("Using provided necessary provision ids.");
            provisionIds = new ArrayList<Long>();
            for (Identifier provisionId : msg.getProvisionIdList()) {
                provisionIds.add(provisionId.getValue());
            }
        }

        LOGGER.debug("Found follwing necessary provision ids: " + provisionIds);

        return provisionIds;
    }

    private void matchProvisionGroups(List<Long> providerIds, List<FunctionalIdentifier> provisionGroupFunctionalIds)
            throws PersistenceException {

        for (FunctionalIdentifier provisionGroupFunctionalId : provisionGroupFunctionalIds) {
            LOGGER.debug("Search for provider of provisions in provision group with functional id "
                    + provisionGroupFunctionalId);

            if (providerIds.isEmpty()) {
                LOGGER.debug("Skip search because no possible provider is left over.");
                break;
            }

            StringBuilder queryString = new StringBuilder();
            queryString.append("SELECT DISTINCT cr.sourceId FROM ProvisionAssignmentComponentRelation cr");
            queryString.append(" WHERE cr.target.provisionUsageType = :provisionUsageType");
            queryString.append(" AND cr.target.characteristicType = :characteristicType");
            queryString.append(" AND cr.target.characteristic.functionalId LIKE :provisionGroupFunctionalId");

            NabuccoQuery<Identifier> query2 = super.getPersistenceManager().createQuery(queryString.toString());
            provisionGroupFunctionalId.setValue(provisionGroupFunctionalId.getValue() + "%");
            query2.setParameter("provisionGroupFunctionalId", provisionGroupFunctionalId);
            query2.setParameter("provisionUsageType", ProvisionUsageType.PROVIDED);
            query2.setParameter("characteristicType", ProvisionCharacteristicType.SKILL);

            List<Identifier> personSourceId = query2.getResultList();

            LOGGER.debug("Found follwing provider: " + personSourceId);

            // filter provider
            LOGGER.debug("Provider list is filtered.");

            // create tmp list
            List<Long> tmpList = new ArrayList<Long>();
            for (Identifier identifier : personSourceId) {
                tmpList.add(identifier.getValue());
            }

            // remove ids which are not contained
            List<Long> rmvList = new ArrayList<Long>();
            for (Long long1 : providerIds) {
                if (!tmpList.contains(long1)) {
                    rmvList.add(long1);
                }
            }
            providerIds.removeAll(rmvList);

            LOGGER.debug("Provider list is now " + providerIds);
        }
    }

    private void matchProvisions(List<Long> providerIds, List<Long> provisionIds) throws PersistenceException {

        for (Long provisionId : provisionIds) {
            LOGGER.debug("Search for provider of provision " + provisionId);

            if (providerIds.isEmpty()) {
                LOGGER.debug("Skip search because no possible provider is left over.");
                break;
            }

            StringBuilder queryString = new StringBuilder();
            queryString.append("SELECT cr.sourceId FROM ProvisionAssignmentComponentRelation cr");
            queryString.append(" WHERE cr.target.characteristic.id = :provisionId");
            queryString.append(" AND cr.target.provisionUsageType = :provisionUsageType");

            NabuccoQuery<Identifier> query2 = super.getPersistenceManager().createQuery(queryString.toString());
            query2.setParameter("provisionId", provisionId);
            query2.setParameter("provisionUsageType", ProvisionUsageType.PROVIDED);

            List<Identifier> personSourceId = query2.getResultList();

            LOGGER.debug("Found follwing provider: " + personSourceId);

            // filter provider
            LOGGER.debug("Provider list is filtered.");

            // create tmp list
            List<Long> tmpList = new ArrayList<Long>();
            for (Identifier identifier : personSourceId) {
                tmpList.add(identifier.getValue());
            }

            // remove ids which are not contained
            List<Long> rmvList = new ArrayList<Long>();
            for (Long long1 : providerIds) {
                if (!tmpList.contains(long1)) {
                    rmvList.add(long1);
                }
            }
            providerIds.removeAll(rmvList);

            LOGGER.debug("Provider list is now " + providerIds);
        }
    }
}
