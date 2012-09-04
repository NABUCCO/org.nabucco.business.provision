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
package org.nabucco.business.provision.ui.rcp.communication.match;

import org.nabucco.business.provision.facade.message.match.ProvisionMatchRq;
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRs;
import org.nabucco.business.provision.facade.message.match.SkillMatchRq;
import org.nabucco.business.provision.facade.message.match.SkillMatchRs;
import org.nabucco.business.provision.facade.service.match.MatchProvision;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * MatchProvisionDelegate<p/>Match Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-06-28
 */
public class MatchProvisionDelegate extends ServiceDelegateSupport {

    private MatchProvision service;

    /**
     * Constructs a new MatchProvisionDelegate instance.
     *
     * @param service the MatchProvision.
     */
    public MatchProvisionDelegate(MatchProvision service) {
        super();
        this.service = service;
    }

    /**
     * Match.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionMatchRq.
     * @return the ProvisionMatchRs.
     * @throws ClientException
     */
    public ProvisionMatchRs match(ProvisionMatchRq message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProvisionMatchRq> request = new ServiceRequest<ProvisionMatchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionMatchRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.match(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MatchProvision.class, "match", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MatchProvision.match");
    }

    /**
     * MatchSkills.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SkillMatchRq.
     * @return the SkillMatchRs.
     * @throws ClientException
     */
    public SkillMatchRs matchSkills(SkillMatchRq message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<SkillMatchRq> request = new ServiceRequest<SkillMatchRq>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SkillMatchRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.matchSkills(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MatchProvision.class, "matchSkills", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MatchProvision.matchSkills");
    }
}
