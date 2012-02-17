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

import org.nabucco.business.provision.facade.datatype.TertiaryEducation;
import org.nabucco.business.provision.facade.message.TertiaryEducationMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * 
 * ResolveTertiaryEducationServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ResolveTertiaryEducationServiceHandlerImpl extends ResolveTertiaryEducationServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected TertiaryEducationMsg resolveTertiaryEducation(TertiaryEducationMsg msg) throws ResolveException {

        TertiaryEducation tertiaryEducation = msg.getTertiaryEducation();

        try {
            tertiaryEducation = super.getPersistenceManager().find(tertiaryEducation);
            tertiaryEducation.getRelationList().size();
        } catch (Exception e) {
            throw new ResolveException("Cannot resolve TertiaryEducation with id " + tertiaryEducation.getId(), e);
        }

        TertiaryEducationMsg response = new TertiaryEducationMsg();
        response.setTertiaryEducation(tertiaryEducation);
        return response;
    }
}
