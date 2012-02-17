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
package org.nabucco.business.provision.facade.service.resolve;

import org.nabucco.business.provision.facade.message.EquipmentMsg;
import org.nabucco.business.provision.facade.message.FurtherEducationMsg;
import org.nabucco.business.provision.facade.message.JobEducationMsg;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentMsg;
import org.nabucco.business.provision.facade.message.ProvisionGroupMsg;
import org.nabucco.business.provision.facade.message.QualificationMsg;
import org.nabucco.business.provision.facade.message.SchoolEducationMsg;
import org.nabucco.business.provision.facade.message.SkillMsg;
import org.nabucco.business.provision.facade.message.TertiaryEducationMsg;
import org.nabucco.business.provision.facade.message.WorkExperienceMsg;
import org.nabucco.business.provision.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.provision.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ResolveProvision<p/>Resolve Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public interface ResolveProvision extends Service {

    /**
     * Missing description at method resolveSkill.
     *
     * @param rq the ServiceRequest<SkillMsg>.
     * @return the ServiceResponse<SkillMsg>.
     * @throws ResolveException
     */
    ServiceResponse<SkillMsg> resolveSkill(ServiceRequest<SkillMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveEquipment.
     *
     * @param rq the ServiceRequest<EquipmentMsg>.
     * @return the ServiceResponse<EquipmentMsg>.
     * @throws ResolveException
     */
    ServiceResponse<EquipmentMsg> resolveEquipment(ServiceRequest<EquipmentMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveQualification.
     *
     * @param rq the ServiceRequest<QualificationMsg>.
     * @return the ServiceResponse<QualificationMsg>.
     * @throws ResolveException
     */
    ServiceResponse<QualificationMsg> resolveQualification(ServiceRequest<QualificationMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveProvisionGroup.
     *
     * @param rq the ServiceRequest<ProvisionGroupMsg>.
     * @return the ServiceResponse<ProvisionGroupMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ProvisionGroupMsg> resolveProvisionGroup(ServiceRequest<ProvisionGroupMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveProvisionAssignment.
     *
     * @param rq the ServiceRequest<ProvisionAssignmentMsg>.
     * @return the ServiceResponse<ProvisionAssignmentMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ProvisionAssignmentMsg> resolveProvisionAssignment(ServiceRequest<ProvisionAssignmentMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveSchoolEducation.
     *
     * @param rq the ServiceRequest<SchoolEducationMsg>.
     * @return the ServiceResponse<SchoolEducationMsg>.
     * @throws ResolveException
     */
    ServiceResponse<SchoolEducationMsg> resolveSchoolEducation(ServiceRequest<SchoolEducationMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveJobEducation.
     *
     * @param rq the ServiceRequest<JobEducationMsg>.
     * @return the ServiceResponse<JobEducationMsg>.
     * @throws ResolveException
     */
    ServiceResponse<JobEducationMsg> resolveJobEducation(ServiceRequest<JobEducationMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveTertiaryEducation.
     *
     * @param rq the ServiceRequest<TertiaryEducationMsg>.
     * @return the ServiceResponse<TertiaryEducationMsg>.
     * @throws ResolveException
     */
    ServiceResponse<TertiaryEducationMsg> resolveTertiaryEducation(ServiceRequest<TertiaryEducationMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveFurtherEducation.
     *
     * @param rq the ServiceRequest<FurtherEducationMsg>.
     * @return the ServiceResponse<FurtherEducationMsg>.
     * @throws ResolveException
     */
    ServiceResponse<FurtherEducationMsg> resolveFurtherEducation(ServiceRequest<FurtherEducationMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveWorkExperience.
     *
     * @param rq the ServiceRequest<WorkExperienceMsg>.
     * @return the ServiceResponse<WorkExperienceMsg>.
     * @throws ResolveException
     */
    ServiceResponse<WorkExperienceMsg> resolveWorkExperience(ServiceRequest<WorkExperienceMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveDatatypeList.
     *
     * @param rq the ServiceRequest<ResolveDatatypeListRq>.
     * @return the ServiceResponse<ResolveDatatypeListRs>.
     * @throws ResolveException
     */
    ServiceResponse<ResolveDatatypeListRs> resolveDatatypeList(ServiceRequest<ResolveDatatypeListRq> rq)
            throws ResolveException;
}
