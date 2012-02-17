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

import org.nabucco.business.provision.facade.datatype.FurtherEducation;
import org.nabucco.business.provision.facade.message.FurtherEducationListMsg;
import org.nabucco.business.provision.facade.message.produce.FurtherEducationProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * 
 * ProduceFurtherEducationServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceFurtherEducationServiceHandlerImpl extends ProduceFurtherEducationServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected FurtherEducationListMsg produceFurtherEducation(FurtherEducationProduceRq rq) throws ProduceException {

        FurtherEducationListMsg response = new FurtherEducationListMsg();

        for (int i = 0; i < rq.getAmount().getValue(); i++) {
            FurtherEducation datatype = new FurtherEducation();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);
            datatype.setOwner(getContext().getSubject().getOwner());

            response.getFurtherEducationList().add(datatype);
        }

        return response;
    }

}
