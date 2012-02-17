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
package org.nabucco.business.provision.facade.service.maintain;

import org.nabucco.business.provision.facade.message.EquipmentMsg;
import org.nabucco.business.provision.facade.message.FurtherEducationMsg;
import org.nabucco.business.provision.facade.message.JobEducationMsg;
import org.nabucco.business.provision.facade.message.MoveProvisionCharacteristicMsg;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentMsg;
import org.nabucco.business.provision.facade.message.ProvisionGroupMsg;
import org.nabucco.business.provision.facade.message.QualificationMsg;
import org.nabucco.business.provision.facade.message.SchoolEducationMsg;
import org.nabucco.business.provision.facade.message.SkillMsg;
import org.nabucco.business.provision.facade.message.TertiaryEducationMsg;
import org.nabucco.business.provision.facade.message.UnassignChildMsg;
import org.nabucco.business.provision.facade.message.WorkExperienceMsg;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * MaintainProvision<p/>Maintain Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public interface MaintainProvision extends Service {

    /**
     * Missing description at method maintainSkill.
     *
     * @param rq the ServiceRequest<SkillMsg>.
     * @return the ServiceResponse<SkillMsg>.
     * @throws MaintainException
     */
    ServiceResponse<SkillMsg> maintainSkill(ServiceRequest<SkillMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainEquipment.
     *
     * @param rq the ServiceRequest<EquipmentMsg>.
     * @return the ServiceResponse<EquipmentMsg>.
     * @throws MaintainException
     */
    ServiceResponse<EquipmentMsg> maintainEquipment(ServiceRequest<EquipmentMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainQualification.
     *
     * @param rq the ServiceRequest<QualificationMsg>.
     * @return the ServiceResponse<QualificationMsg>.
     * @throws MaintainException
     */
    ServiceResponse<QualificationMsg> maintainQualification(ServiceRequest<QualificationMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method maintainProvisionGroup.
     *
     * @param rq the ServiceRequest<ProvisionGroupMsg>.
     * @return the ServiceResponse<ProvisionGroupMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProvisionGroupMsg> maintainProvisionGroup(ServiceRequest<ProvisionGroupMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method maintainProvisionAssignment.
     *
     * @param rq the ServiceRequest<ProvisionAssignmentMsg>.
     * @return the ServiceResponse<ProvisionAssignmentMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProvisionAssignmentMsg> maintainProvisionAssignment(ServiceRequest<ProvisionAssignmentMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method maintainSchoolEducation.
     *
     * @param rq the ServiceRequest<SchoolEducationMsg>.
     * @return the ServiceResponse<SchoolEducationMsg>.
     * @throws MaintainException
     */
    ServiceResponse<SchoolEducationMsg> maintainSchoolEducation(ServiceRequest<SchoolEducationMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method maintainJobEducation.
     *
     * @param rq the ServiceRequest<JobEducationMsg>.
     * @return the ServiceResponse<JobEducationMsg>.
     * @throws MaintainException
     */
    ServiceResponse<JobEducationMsg> maintainJobEducation(ServiceRequest<JobEducationMsg> rq) throws MaintainException;

    /**
     * Missing description at method maintainTertiaryEducation.
     *
     * @param rq the ServiceRequest<TertiaryEducationMsg>.
     * @return the ServiceResponse<TertiaryEducationMsg>.
     * @throws MaintainException
     */
    ServiceResponse<TertiaryEducationMsg> maintainTertiaryEducation(ServiceRequest<TertiaryEducationMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method maintainFurtherEducation.
     *
     * @param rq the ServiceRequest<FurtherEducationMsg>.
     * @return the ServiceResponse<FurtherEducationMsg>.
     * @throws MaintainException
     */
    ServiceResponse<FurtherEducationMsg> maintainFurtherEducation(ServiceRequest<FurtherEducationMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method maintainWorkExperience.
     *
     * @param rq the ServiceRequest<WorkExperienceMsg>.
     * @return the ServiceResponse<WorkExperienceMsg>.
     * @throws MaintainException
     */
    ServiceResponse<WorkExperienceMsg> maintainWorkExperience(ServiceRequest<WorkExperienceMsg> rq)
            throws MaintainException;

    /**
     * Missing description at method unassignChild.
     *
     * @param rq the ServiceRequest<UnassignChildMsg>.
     * @return the ServiceResponse<ProvisionGroupMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProvisionGroupMsg> unassignChild(ServiceRequest<UnassignChildMsg> rq) throws MaintainException;

    /**
     * Missing description at method moveProvisionCharacteristic.
     *
     * @param rq the ServiceRequest<MoveProvisionCharacteristicMsg>.
     * @return the ServiceResponse<ProvisionGroupMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProvisionGroupMsg> moveProvisionCharacteristic(ServiceRequest<MoveProvisionCharacteristicMsg> rq)
            throws MaintainException;
}
