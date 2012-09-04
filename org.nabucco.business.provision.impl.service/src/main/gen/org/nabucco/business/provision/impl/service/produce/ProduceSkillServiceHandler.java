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
package org.nabucco.business.provision.impl.service.produce;

import org.nabucco.business.provision.facade.message.SkillListMsg;
import org.nabucco.business.provision.facade.message.produce.SkillProduceRq;
import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;

/**
 * ProduceSkillServiceHandler<p/>Produce Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public abstract class ProduceSkillServiceHandler extends PersistenceServiceHandlerSupport implements ServiceHandler,
        PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.business.provision.impl.service.produce.ProduceSkillServiceHandler";

    /** Constructs a new ProduceSkillServiceHandler instance. */
    public ProduceSkillServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<SkillProduceRq>.
     * @return the ServiceResponse<SkillListMsg>.
     * @throws ProduceException
     */
    protected ServiceResponse<SkillListMsg> invoke(ServiceRequest<SkillProduceRq> rq) throws ProduceException {
        ServiceResponse<SkillListMsg> rs;
        SkillListMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.produceSkill(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<SkillListMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (ProduceException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ProduceException wrappedException = new ProduceException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ProduceException("Error during service invocation.", e);
        }
    }

    /**
     * Creates new Skill Instances.
     *
     * @param msg the SkillProduceRq.
     * @return the SkillListMsg.
     * @throws ProduceException
     */
    protected abstract SkillListMsg produceSkill(SkillProduceRq msg) throws ProduceException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
