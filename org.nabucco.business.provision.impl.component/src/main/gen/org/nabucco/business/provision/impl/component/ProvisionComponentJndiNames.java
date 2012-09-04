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

/**
 * ProvisionComponentJndiNames<p/>Provision component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public interface ProvisionComponentJndiNames {

    final String COMPONENT_RELATION_SERVICE_LOCAL = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.component.ComponentRelationService/local";

    final String COMPONENT_RELATION_SERVICE_REMOTE = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.component.ComponentRelationService/remote";

    final String QUERY_FILTER_SERVICE_LOCAL = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.component.QueryFilterService/local";

    final String QUERY_FILTER_SERVICE_REMOTE = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.component.QueryFilterService/remote";

    final String MAINTAIN_PROVISION_LOCAL = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.maintain.MaintainProvision/local";

    final String MAINTAIN_PROVISION_REMOTE = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.maintain.MaintainProvision/remote";

    final String PRODUCE_PROVISION_LOCAL = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.produce.ProduceProvision/local";

    final String PRODUCE_PROVISION_REMOTE = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.produce.ProduceProvision/remote";

    final String RESOLVE_PROVISION_LOCAL = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.resolve.ResolveProvision/local";

    final String RESOLVE_PROVISION_REMOTE = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.resolve.ResolveProvision/remote";

    final String SEARCH_PROVISION_LOCAL = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.search.SearchProvision/local";

    final String SEARCH_PROVISION_REMOTE = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.search.SearchProvision/remote";

    final String MATCH_PROVISION_LOCAL = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.match.MatchProvision/local";

    final String MATCH_PROVISION_REMOTE = "nabucco/org.nabucco.business.provision/org.nabucco.business.provision.facade.service.match.MatchProvision/remote";
}
