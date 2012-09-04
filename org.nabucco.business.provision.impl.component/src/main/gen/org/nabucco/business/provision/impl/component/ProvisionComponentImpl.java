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
package org.nabucco.business.provision.impl.component;

import org.nabucco.business.provision.facade.component.ProvisionComponentLocal;
import org.nabucco.business.provision.facade.component.ProvisionComponentRemote;
import org.nabucco.business.provision.facade.service.maintain.MaintainProvision;
import org.nabucco.business.provision.facade.service.match.MatchProvision;
import org.nabucco.business.provision.facade.service.produce.ProduceProvision;
import org.nabucco.business.provision.facade.service.resolve.ResolveProvision;
import org.nabucco.business.provision.facade.service.search.SearchProvision;
import org.nabucco.framework.base.facade.component.handler.PostConstructHandler;
import org.nabucco.framework.base.facade.component.handler.PreDestroyHandler;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.base.impl.component.ComponentSupport;

/**
 * ProvisionComponentImpl<p/>Provision component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProvisionComponentImpl extends ComponentSupport implements ProvisionComponentLocal,
        ProvisionComponentRemote {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProvisionComponent";

    /** Constructs a new ProvisionComponentImpl instance. */
    public ProvisionComponentImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PostConstructHandler handler = injector.inject(PostConstructHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No post construct handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PreDestroyHandler handler = injector.inject(PreDestroyHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No pre destroy handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @Override
    public String getJndiName() {
        return JNDI_NAME;
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.COMPONENT_RELATION_SERVICE_REMOTE,
                ComponentRelationService.class);
    }

    @Override
    public ComponentRelationService getComponentRelationServiceLocal() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.COMPONENT_RELATION_SERVICE_LOCAL,
                ComponentRelationService.class);
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.QUERY_FILTER_SERVICE_REMOTE, QueryFilterService.class);
    }

    @Override
    public QueryFilterService getQueryFilterServiceLocal() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.QUERY_FILTER_SERVICE_LOCAL, QueryFilterService.class);
    }

    @Override
    public MaintainProvision getMaintainProvisionLocal() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.MAINTAIN_PROVISION_LOCAL, MaintainProvision.class);
    }

    @Override
    public MaintainProvision getMaintainProvision() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.MAINTAIN_PROVISION_REMOTE, MaintainProvision.class);
    }

    @Override
    public ProduceProvision getProduceProvisionLocal() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.PRODUCE_PROVISION_LOCAL, ProduceProvision.class);
    }

    @Override
    public ProduceProvision getProduceProvision() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.PRODUCE_PROVISION_REMOTE, ProduceProvision.class);
    }

    @Override
    public ResolveProvision getResolveProvisionLocal() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.RESOLVE_PROVISION_LOCAL, ResolveProvision.class);
    }

    @Override
    public ResolveProvision getResolveProvision() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.RESOLVE_PROVISION_REMOTE, ResolveProvision.class);
    }

    @Override
    public SearchProvision getSearchProvisionLocal() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.SEARCH_PROVISION_LOCAL, SearchProvision.class);
    }

    @Override
    public SearchProvision getSearchProvision() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.SEARCH_PROVISION_REMOTE, SearchProvision.class);
    }

    @Override
    public MatchProvision getMatchProvisionLocal() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.MATCH_PROVISION_LOCAL, MatchProvision.class);
    }

    @Override
    public MatchProvision getMatchProvision() throws ServiceException {
        return super.lookup(ProvisionComponentJndiNames.MATCH_PROVISION_REMOTE, MatchProvision.class);
    }
}
