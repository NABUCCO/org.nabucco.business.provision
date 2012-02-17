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

import org.nabucco.business.provision.facade.datatype.ProvisionAssignment;
import org.nabucco.business.provision.facade.datatype.ProvisionUsageType;
import org.nabucco.business.provision.facade.datatype.RequirementType;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentListMsg;
import org.nabucco.business.provision.facade.message.produce.ProvisionAssignmentProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceProvisionAssignmentServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceProvisionAssignmentServiceHandlerImpl extends ProduceProvisionAssignmentServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProvisionAssignmentListMsg produceProvisionAssignment(ProvisionAssignmentProduceRq rq)
            throws ProduceException {

        ProvisionAssignmentListMsg response = new ProvisionAssignmentListMsg();
        RequirementType requirementType = rq.getRequirementType();
        ProvisionUsageType usageType = rq.getUsageType();

        for (int i = 0; i < rq.getAmount().getValue(); i++) {
            ProvisionAssignment datatype = new ProvisionAssignment();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            if (usageType != null) {
                datatype.setProvisionUsageType(usageType);
            }
            if (requirementType != null) {
                datatype.setRequirementType(requirementType);
            }

            response.getProvisionAssignmentList().add(datatype);
        }

        return response;
    }
}
