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
package org.nabucco.business.provision.impl.service.maintain;

import org.nabucco.business.provision.facade.datatype.SchoolEducation;
import org.nabucco.business.provision.facade.message.SchoolEducationMsg;
import org.nabucco.business.provision.impl.service.maintain.support.ProvisionCharacteristicMaintainServiceSupport;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * 
 * MaintainSchoolEducationServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class MaintainSchoolEducationServiceHandlerImpl extends MaintainSchoolEducationServiceHandler {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected SchoolEducationMsg maintainSchoolEducation(SchoolEducationMsg msg) throws MaintainException {

        ProvisionCharacteristicMaintainServiceSupport support = new ProvisionCharacteristicMaintainServiceSupport(
                getPersistenceManager());
        SchoolEducation schoolEducation = (SchoolEducation) support.maintain(msg.getSchoolEducation());

        SchoolEducationMsg response = new SchoolEducationMsg();
        response.setSchoolEducation(schoolEducation);
        return response;
    }

}
