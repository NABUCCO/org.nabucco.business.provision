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

import org.nabucco.business.provision.facade.exception.ProvisionMatchException;
import org.nabucco.business.provision.facade.message.match.SkillMatchRq;
import org.nabucco.business.provision.facade.message.match.SkillMatchRs;
import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;

/**
 * MatchSkillsServiceHandler<p/>Match Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-06-28
 */
public abstract class MatchSkillsServiceHandler extends PersistenceServiceHandlerSupport implements ServiceHandler,
        PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.business.provision.impl.service.match.MatchSkillsServiceHandler";

    /** Constructs a new MatchSkillsServiceHandler instance. */
    public MatchSkillsServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<SkillMatchRq>.
     * @return the ServiceResponse<SkillMatchRs>.
     * @throws ProvisionMatchException
     */
    protected ServiceResponse<SkillMatchRs> invoke(ServiceRequest<SkillMatchRq> rq) throws ProvisionMatchException {
        ServiceResponse<SkillMatchRs> rs;
        SkillMatchRs msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.matchSkills(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<SkillMatchRs>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (ProvisionMatchException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ProvisionMatchException wrappedException = new ProvisionMatchException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ProvisionMatchException("Error during service invocation.", e);
        }
    }

    /**
     * Match skill lists to calculate average matching
     *
     * @param msg the SkillMatchRq.
     * @return the SkillMatchRs.
     * @throws ProvisionMatchException
     */
    protected abstract SkillMatchRs matchSkills(SkillMatchRq msg) throws ProvisionMatchException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
