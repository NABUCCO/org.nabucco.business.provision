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
package org.nabucco.business.provision.impl.service.produce;

import org.nabucco.business.provision.facade.datatype.ProvisionAssignmentHistory;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentHistoryListMsg;
import org.nabucco.business.provision.facade.message.produce.ProvisionAssignmentHistoryProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceProvisionAssignmentHistoryServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceProvisionAssignmentHistoryServiceHandlerImpl extends
        ProduceProvisionAssignmentHistoryServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProvisionAssignmentHistoryListMsg produceProvisionAssignmentHistory(ProvisionAssignmentHistoryProduceRq rq)
            throws ProduceException {

        ProvisionAssignmentHistoryListMsg response = new ProvisionAssignmentHistoryListMsg();

        for (int i = 0; i < rq.getAmount().getValue(); i++) {
            ProvisionAssignmentHistory datatype = new ProvisionAssignmentHistory();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            response.getProvisionAssignmentHistoryList().add(datatype);
        }

        return response;
    }

}
