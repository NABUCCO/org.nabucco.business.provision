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
package org.nabucco.business.provision.facade.component;

import org.nabucco.business.provision.facade.service.maintain.MaintainProvision;
import org.nabucco.business.provision.facade.service.match.MatchProvision;
import org.nabucco.business.provision.facade.service.produce.ProduceProvision;
import org.nabucco.business.provision.facade.service.resolve.ResolveProvision;
import org.nabucco.business.provision.facade.service.search.SearchProvision;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;

/**
 * ProvisionComponentLocal<p/>Provision component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public interface ProvisionComponentLocal extends ProvisionComponent {

    /**
     * Getter for the ComponentRelationServiceLocal.
     *
     * @return the ComponentRelationService.
     * @throws ServiceException
     */
    ComponentRelationService getComponentRelationServiceLocal() throws ServiceException;

    /**
     * Getter for the QueryFilterServiceLocal.
     *
     * @return the QueryFilterService.
     * @throws ServiceException
     */
    QueryFilterService getQueryFilterServiceLocal() throws ServiceException;

    /**
     * Getter for the MaintainProvisionLocal.
     *
     * @return the MaintainProvision.
     * @throws ServiceException
     */
    MaintainProvision getMaintainProvisionLocal() throws ServiceException;

    /**
     * Getter for the ProduceProvisionLocal.
     *
     * @return the ProduceProvision.
     * @throws ServiceException
     */
    ProduceProvision getProduceProvisionLocal() throws ServiceException;

    /**
     * Getter for the ResolveProvisionLocal.
     *
     * @return the ResolveProvision.
     * @throws ServiceException
     */
    ResolveProvision getResolveProvisionLocal() throws ServiceException;

    /**
     * Getter for the SearchProvisionLocal.
     *
     * @return the SearchProvision.
     * @throws ServiceException
     */
    SearchProvision getSearchProvisionLocal() throws ServiceException;

    /**
     * Getter for the MatchProvisionLocal.
     *
     * @return the MatchProvision.
     * @throws ServiceException
     */
    MatchProvision getMatchProvisionLocal() throws ServiceException;
}
