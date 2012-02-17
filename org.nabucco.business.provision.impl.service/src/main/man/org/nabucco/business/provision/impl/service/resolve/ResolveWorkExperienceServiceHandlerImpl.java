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

import org.nabucco.business.provision.facade.datatype.WorkExperience;
import org.nabucco.business.provision.facade.message.WorkExperienceMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * 
 * ResolveWorkExperienceServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ResolveWorkExperienceServiceHandlerImpl extends ResolveWorkExperienceServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected WorkExperienceMsg resolveWorkExperience(WorkExperienceMsg msg) throws ResolveException {

        WorkExperience workExperience = msg.getWorkExperience();

        try {
            workExperience = super.getPersistenceManager().find(workExperience);
            workExperience.getSectorList().size();
            workExperience.getActivityAreaList().size();
            workExperience.getRelationList().size();
        } catch (Exception e) {
            throw new ResolveException("Cannot resolve WorkExperience with id " + workExperience.getId(), e);
        }

        WorkExperienceMsg response = new WorkExperienceMsg();
        response.setWorkExperience(workExperience);
        return response;
    }

}
