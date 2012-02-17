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
package org.nabucco.business.provision.impl.service.resolve;

import org.nabucco.business.provision.facade.datatype.ProvisionAssignment;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * 
 * ResolveProvisionAssignmentServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ResolveProvisionAssignmentServiceHandlerImpl extends ResolveProvisionAssignmentServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProvisionAssignmentMsg resolveProvisionAssignment(ProvisionAssignmentMsg msg) throws ResolveException {

        ProvisionAssignment provisionRating = msg.getProvisionAssignment();

        try {
            provisionRating = super.getPersistenceManager().find(provisionRating);
        } catch (Exception e) {
            throw new ResolveException("Cannot resolve ProvisionAssignment with id " + provisionRating.getId(), e);
        }

        ProvisionAssignmentMsg response = new ProvisionAssignmentMsg();
        response.setProvisionAssignment(provisionRating);
        return response;
    }

}
