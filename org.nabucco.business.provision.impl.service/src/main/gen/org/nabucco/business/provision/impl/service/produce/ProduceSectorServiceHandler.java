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

import org.nabucco.business.provision.facade.message.SectorListMsg;
import org.nabucco.business.provision.facade.message.produce.SectorProduceRq;
import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;

/**
 * ProduceSectorServiceHandler<p/>Produce Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public abstract class ProduceSectorServiceHandler extends PersistenceServiceHandlerSupport implements ServiceHandler,
        PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.business.provision.impl.service.produce.ProduceSectorServiceHandler";

    /** Constructs a new ProduceSectorServiceHandler instance. */
    public ProduceSectorServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<SectorProduceRq>.
     * @return the ServiceResponse<SectorListMsg>.
     * @throws ProduceException
     */
    protected ServiceResponse<SectorListMsg> invoke(ServiceRequest<SectorProduceRq> rq) throws ProduceException {
        ServiceResponse<SectorListMsg> rs;
        SectorListMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.produceSector(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<SectorListMsg>(rq.getContext());
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
     * Creates new Sector Instances.
     *
     * @param msg the SectorProduceRq.
     * @return the SectorListMsg.
     * @throws ProduceException
     */
    protected abstract SectorListMsg produceSector(SectorProduceRq msg) throws ProduceException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
