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
package org.nabucco.business.provision.facade.service.search;

import org.nabucco.business.provision.facade.message.EquipmentListMsg;
import org.nabucco.business.provision.facade.message.FurtherEducationListMsg;
import org.nabucco.business.provision.facade.message.JobEducationListMsg;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentListMsg;
import org.nabucco.business.provision.facade.message.ProvisionGroupListMsg;
import org.nabucco.business.provision.facade.message.QualificationListMsg;
import org.nabucco.business.provision.facade.message.SchoolEducationListMsg;
import org.nabucco.business.provision.facade.message.SkillListMsg;
import org.nabucco.business.provision.facade.message.TertiaryEducationListMsg;
import org.nabucco.business.provision.facade.message.WorkExperienceListMsg;
import org.nabucco.business.provision.facade.message.search.EquipmentSearchRq;
import org.nabucco.business.provision.facade.message.search.FurtherEducationSearchRq;
import org.nabucco.business.provision.facade.message.search.JobEducationSearchRq;
import org.nabucco.business.provision.facade.message.search.ProvisionAssignmentSearchRq;
import org.nabucco.business.provision.facade.message.search.ProvisionGroupSearchRq;
import org.nabucco.business.provision.facade.message.search.QualificationSearchRq;
import org.nabucco.business.provision.facade.message.search.SchoolEducationSearchRq;
import org.nabucco.business.provision.facade.message.search.SkillSearchRq;
import org.nabucco.business.provision.facade.message.search.TertiaryEducationSearchRq;
import org.nabucco.business.provision.facade.message.search.WorkExperienceSearchRq;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * SearchProvision<p/>Search Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public interface SearchProvision extends Service {

    /**
     * Missing description at method searchSkill.
     *
     * @param rq the ServiceRequest<SkillSearchRq>.
     * @return the ServiceResponse<SkillListMsg>.
     * @throws SearchException
     */
    ServiceResponse<SkillListMsg> searchSkill(ServiceRequest<SkillSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchEquipment.
     *
     * @param rq the ServiceRequest<EquipmentSearchRq>.
     * @return the ServiceResponse<EquipmentListMsg>.
     * @throws SearchException
     */
    ServiceResponse<EquipmentListMsg> searchEquipment(ServiceRequest<EquipmentSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchProvisionGroup.
     *
     * @param rq the ServiceRequest<ProvisionGroupSearchRq>.
     * @return the ServiceResponse<ProvisionGroupListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ProvisionGroupListMsg> searchProvisionGroup(ServiceRequest<ProvisionGroupSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchProvisionAssignment.
     *
     * @param rq the ServiceRequest<ProvisionAssignmentSearchRq>.
     * @return the ServiceResponse<ProvisionAssignmentListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ProvisionAssignmentListMsg> searchProvisionAssignment(ServiceRequest<ProvisionAssignmentSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchQualification.
     *
     * @param rq the ServiceRequest<QualificationSearchRq>.
     * @return the ServiceResponse<QualificationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<QualificationListMsg> searchQualification(ServiceRequest<QualificationSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchSchoolEducation.
     *
     * @param rq the ServiceRequest<SchoolEducationSearchRq>.
     * @return the ServiceResponse<SchoolEducationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<SchoolEducationListMsg> searchSchoolEducation(ServiceRequest<SchoolEducationSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchJobEducation.
     *
     * @param rq the ServiceRequest<JobEducationSearchRq>.
     * @return the ServiceResponse<JobEducationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<JobEducationListMsg> searchJobEducation(ServiceRequest<JobEducationSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchTertiaryEducation.
     *
     * @param rq the ServiceRequest<TertiaryEducationSearchRq>.
     * @return the ServiceResponse<TertiaryEducationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<TertiaryEducationListMsg> searchTertiaryEducation(ServiceRequest<TertiaryEducationSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchFurtherEducation.
     *
     * @param rq the ServiceRequest<FurtherEducationSearchRq>.
     * @return the ServiceResponse<FurtherEducationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<FurtherEducationListMsg> searchFurtherEducation(ServiceRequest<FurtherEducationSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchWorkExperience.
     *
     * @param rq the ServiceRequest<WorkExperienceSearchRq>.
     * @return the ServiceResponse<WorkExperienceListMsg>.
     * @throws SearchException
     */
    ServiceResponse<WorkExperienceListMsg> searchWorkExperience(ServiceRequest<WorkExperienceSearchRq> rq)
            throws SearchException;
}
