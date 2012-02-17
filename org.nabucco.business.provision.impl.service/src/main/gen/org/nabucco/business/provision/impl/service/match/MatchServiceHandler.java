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
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRq;
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRs;
import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;

/**
 * MatchServiceHandler<p/>Match Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-06-28
 */
public abstract class MatchServiceHandler extends PersistenceServiceHandlerSupport implements ServiceHandler,
        PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.business.provision.impl.service.match.MatchServiceHandler";

    /** Constructs a new MatchServiceHandler instance. */
    public MatchServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<ProvisionMatchRq>.
     * @return the ServiceResponse<ProvisionMatchRs>.
     * @throws ProvisionMatchException
     */
    protected ServiceResponse<ProvisionMatchRs> invoke(ServiceRequest<ProvisionMatchRq> rq)
            throws ProvisionMatchException {
        ServiceResponse<ProvisionMatchRs> rs;
        ProvisionMatchRs msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.match(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<ProvisionMatchRs>(rq.getContext());
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
     * Missing description at method match.
     *
     * @param msg the ProvisionMatchRq.
     * @return the ProvisionMatchRs.
     * @throws ProvisionMatchException
     */
    protected abstract ProvisionMatchRs match(ProvisionMatchRq msg) throws ProvisionMatchException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
