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
import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;

/**
 * ProvisionComponent<p/>Provision component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public interface ProvisionComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.business.provision";

    final String COMPONENT_PREFIX = "prov";

    final String JNDI_NAME = ((((JNDI_PREFIX + "/") + COMPONENT_NAME) + "/") + "org.nabucco.business.provision.facade.component.ProvisionComponent");

    /**
     * Getter for the MaintainProvision.
     *
     * @return the MaintainProvision.
     * @throws ServiceException
     */
    MaintainProvision getMaintainProvision() throws ServiceException;

    /**
     * Getter for the ProduceProvision.
     *
     * @return the ProduceProvision.
     * @throws ServiceException
     */
    ProduceProvision getProduceProvision() throws ServiceException;

    /**
     * Getter for the ResolveProvision.
     *
     * @return the ResolveProvision.
     * @throws ServiceException
     */
    ResolveProvision getResolveProvision() throws ServiceException;

    /**
     * Getter for the SearchProvision.
     *
     * @return the SearchProvision.
     * @throws ServiceException
     */
    SearchProvision getSearchProvision() throws ServiceException;

    /**
     * Getter for the MatchProvision.
     *
     * @return the MatchProvision.
     * @throws ServiceException
     */
    MatchProvision getMatchProvision() throws ServiceException;
}
