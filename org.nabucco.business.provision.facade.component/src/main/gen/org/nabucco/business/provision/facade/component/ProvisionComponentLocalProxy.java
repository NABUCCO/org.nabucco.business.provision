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

import org.nabucco.business.provision.facade.component.ProvisionComponent;
import org.nabucco.business.provision.facade.service.maintain.MaintainProvision;
import org.nabucco.business.provision.facade.service.match.MatchProvision;
import org.nabucco.business.provision.facade.service.produce.ProduceProvision;
import org.nabucco.business.provision.facade.service.resolve.ResolveProvision;
import org.nabucco.business.provision.facade.service.search.SearchProvision;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;

/**
 * ProvisionComponentLocalProxy<p/>Provision component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProvisionComponentLocalProxy implements ProvisionComponent {

    private static final long serialVersionUID = 1L;

    private final ProvisionComponentLocal delegate;

    /**
     * Constructs a new ProvisionComponentLocalProxy instance.
     *
     * @param delegate the ProvisionComponentLocal.
     */
    public ProvisionComponentLocalProxy(ProvisionComponentLocal delegate) {
        super();
        if ((delegate == null)) {
            throw new IllegalArgumentException("Cannot create local proxy for component [null].");
        }
        this.delegate = delegate;
    }

    @Override
    public String getId() {
        return this.delegate.getId();
    }

    @Override
    public String getName() {
        return this.delegate.getName();
    }

    @Override
    public String getJndiName() {
        return this.delegate.getJndiName();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.delegate.getComponentRelationServiceLocal();
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return this.delegate.getQueryFilterServiceLocal();
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    @Override
    public MaintainProvision getMaintainProvision() throws ServiceException {
        return this.delegate.getMaintainProvisionLocal();
    }

    @Override
    public ProduceProvision getProduceProvision() throws ServiceException {
        return this.delegate.getProduceProvisionLocal();
    }

    @Override
    public ResolveProvision getResolveProvision() throws ServiceException {
        return this.delegate.getResolveProvisionLocal();
    }

    @Override
    public SearchProvision getSearchProvision() throws ServiceException {
        return this.delegate.getSearchProvisionLocal();
    }

    @Override
    public MatchProvision getMatchProvision() throws ServiceException {
        return this.delegate.getMatchProvisionLocal();
    }
}
