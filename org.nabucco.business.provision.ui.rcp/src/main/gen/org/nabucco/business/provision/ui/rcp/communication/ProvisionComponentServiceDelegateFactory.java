/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.provision.ui.rcp.communication;

import org.nabucco.business.provision.facade.component.ProvisionComponent;
import org.nabucco.business.provision.facade.component.ProvisionComponentLocator;
import org.nabucco.business.provision.ui.rcp.communication.maintain.MaintainProvisionDelegate;
import org.nabucco.business.provision.ui.rcp.communication.match.MatchProvisionDelegate;
import org.nabucco.business.provision.ui.rcp.communication.produce.ProduceProvisionDelegate;
import org.nabucco.business.provision.ui.rcp.communication.resolve.ResolveProvisionDelegate;
import org.nabucco.business.provision.ui.rcp.communication.search.SearchProvisionDelegate;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateFactorySupport;

/**
 * ServiceDelegateFactoryTemplate<p/>Provision component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProvisionComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<ProvisionComponent> {

    private static ProvisionComponentServiceDelegateFactory instance = new ProvisionComponentServiceDelegateFactory();

    private MaintainProvisionDelegate maintainProvisionDelegate;

    private ProduceProvisionDelegate produceProvisionDelegate;

    private ResolveProvisionDelegate resolveProvisionDelegate;

    private SearchProvisionDelegate searchProvisionDelegate;

    private MatchProvisionDelegate matchProvisionDelegate;

    /** Constructs a new ProvisionComponentServiceDelegateFactory instance. */
    private ProvisionComponentServiceDelegateFactory() {
        super(ProvisionComponentLocator.getInstance());
    }

    /**
     * Getter for the MaintainProvision.
     *
     * @return the MaintainProvisionDelegate.
     * @throws ClientException
     */
    public MaintainProvisionDelegate getMaintainProvision() throws ClientException {
        try {
            if ((this.maintainProvisionDelegate == null)) {
                this.maintainProvisionDelegate = new MaintainProvisionDelegate(this.getComponent()
                        .getMaintainProvision());
            }
            return this.maintainProvisionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ProvisionComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainProvision", e);
        }
    }

    /**
     * Getter for the ProduceProvision.
     *
     * @return the ProduceProvisionDelegate.
     * @throws ClientException
     */
    public ProduceProvisionDelegate getProduceProvision() throws ClientException {
        try {
            if ((this.produceProvisionDelegate == null)) {
                this.produceProvisionDelegate = new ProduceProvisionDelegate(this.getComponent().getProduceProvision());
            }
            return this.produceProvisionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ProvisionComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceProvision", e);
        }
    }

    /**
     * Getter for the ResolveProvision.
     *
     * @return the ResolveProvisionDelegate.
     * @throws ClientException
     */
    public ResolveProvisionDelegate getResolveProvision() throws ClientException {
        try {
            if ((this.resolveProvisionDelegate == null)) {
                this.resolveProvisionDelegate = new ResolveProvisionDelegate(this.getComponent().getResolveProvision());
            }
            return this.resolveProvisionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ProvisionComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ResolveProvision", e);
        }
    }

    /**
     * Getter for the SearchProvision.
     *
     * @return the SearchProvisionDelegate.
     * @throws ClientException
     */
    public SearchProvisionDelegate getSearchProvision() throws ClientException {
        try {
            if ((this.searchProvisionDelegate == null)) {
                this.searchProvisionDelegate = new SearchProvisionDelegate(this.getComponent().getSearchProvision());
            }
            return this.searchProvisionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ProvisionComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchProvision", e);
        }
    }

    /**
     * Getter for the MatchProvision.
     *
     * @return the MatchProvisionDelegate.
     * @throws ClientException
     */
    public MatchProvisionDelegate getMatchProvision() throws ClientException {
        try {
            if ((this.matchProvisionDelegate == null)) {
                this.matchProvisionDelegate = new MatchProvisionDelegate(this.getComponent().getMatchProvision());
            }
            return this.matchProvisionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ProvisionComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MatchProvision", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the ProvisionComponentServiceDelegateFactory.
     */
    public static ProvisionComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
