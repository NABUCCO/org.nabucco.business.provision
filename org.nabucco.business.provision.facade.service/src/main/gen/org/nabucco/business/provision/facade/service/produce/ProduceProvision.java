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
package org.nabucco.business.provision.facade.service.produce;

import org.nabucco.business.provision.facade.message.ActivityAreaListMsg;
import org.nabucco.business.provision.facade.message.EquipmentListMsg;
import org.nabucco.business.provision.facade.message.FurtherEducationListMsg;
import org.nabucco.business.provision.facade.message.JobEducationListMsg;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentHistoryListMsg;
import org.nabucco.business.provision.facade.message.ProvisionAssignmentListMsg;
import org.nabucco.business.provision.facade.message.ProvisionGroupListMsg;
import org.nabucco.business.provision.facade.message.ProvisionRelationListMsg;
import org.nabucco.business.provision.facade.message.QualificationListMsg;
import org.nabucco.business.provision.facade.message.SchoolEducationListMsg;
import org.nabucco.business.provision.facade.message.SectorListMsg;
import org.nabucco.business.provision.facade.message.SkillListMsg;
import org.nabucco.business.provision.facade.message.TertiaryEducationListMsg;
import org.nabucco.business.provision.facade.message.WorkExperienceListMsg;
import org.nabucco.business.provision.facade.message.produce.ActivityAreaProduceRq;
import org.nabucco.business.provision.facade.message.produce.EquipmentProduceRq;
import org.nabucco.business.provision.facade.message.produce.FurtherEducationProduceRq;
import org.nabucco.business.provision.facade.message.produce.JobEducationProduceRq;
import org.nabucco.business.provision.facade.message.produce.ProvisionAssignmentHistoryProduceRq;
import org.nabucco.business.provision.facade.message.produce.ProvisionAssignmentProduceRq;
import org.nabucco.business.provision.facade.message.produce.ProvisionGroupProduceRq;
import org.nabucco.business.provision.facade.message.produce.ProvisionRelationProduceRq;
import org.nabucco.business.provision.facade.message.produce.QualificationProduceRq;
import org.nabucco.business.provision.facade.message.produce.SchoolEducationProduceRq;
import org.nabucco.business.provision.facade.message.produce.SectorProduceRq;
import org.nabucco.business.provision.facade.message.produce.SkillProduceRq;
import org.nabucco.business.provision.facade.message.produce.TertiaryEducationProduceRq;
import org.nabucco.business.provision.facade.message.produce.WorkExperienceProduceRq;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ProduceProvision<p/>Produce Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public interface ProduceProvision extends Service {

    /**
     * Creates new Skill Instances.
     *
     * @param rq the ServiceRequest<SkillProduceRq>.
     * @return the ServiceResponse<SkillListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SkillListMsg> produceSkill(ServiceRequest<SkillProduceRq> rq) throws ProduceException;

    /**
     * Creates new Equipment Instances.
     *
     * @param rq the ServiceRequest<EquipmentProduceRq>.
     * @return the ServiceResponse<EquipmentListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<EquipmentListMsg> produceEquipment(ServiceRequest<EquipmentProduceRq> rq) throws ProduceException;

    /**
     * Creates new Qualification Instances.
     *
     * @param rq the ServiceRequest<QualificationProduceRq>.
     * @return the ServiceResponse<QualificationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<QualificationListMsg> produceQualification(ServiceRequest<QualificationProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new Provision Group Instances.
     *
     * @param rq the ServiceRequest<ProvisionGroupProduceRq>.
     * @return the ServiceResponse<ProvisionGroupListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProvisionGroupListMsg> produceProvisionGroup(ServiceRequest<ProvisionGroupProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new Provision Assignment Instances.
     *
     * @param rq the ServiceRequest<ProvisionAssignmentProduceRq>.
     * @return the ServiceResponse<ProvisionAssignmentListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProvisionAssignmentListMsg> produceProvisionAssignment(
            ServiceRequest<ProvisionAssignmentProduceRq> rq) throws ProduceException;

    /**
     * Creates new Provision Assignment History Instances.
     *
     * @param rq the ServiceRequest<ProvisionAssignmentHistoryProduceRq>.
     * @return the ServiceResponse<ProvisionAssignmentHistoryListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProvisionAssignmentHistoryListMsg> produceProvisionAssignmentHistory(
            ServiceRequest<ProvisionAssignmentHistoryProduceRq> rq) throws ProduceException;

    /**
     * Creates new Work Experience Instances.
     *
     * @param rq the ServiceRequest<WorkExperienceProduceRq>.
     * @return the ServiceResponse<WorkExperienceListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<WorkExperienceListMsg> produceWorkExperience(ServiceRequest<WorkExperienceProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new School Education Instances.
     *
     * @param rq the ServiceRequest<SchoolEducationProduceRq>.
     * @return the ServiceResponse<SchoolEducationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SchoolEducationListMsg> produceSchoolEducation(ServiceRequest<SchoolEducationProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new Job Education Instances.
     *
     * @param rq the ServiceRequest<JobEducationProduceRq>.
     * @return the ServiceResponse<JobEducationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<JobEducationListMsg> produceJobEducation(ServiceRequest<JobEducationProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new Tertiary Education Instances.
     *
     * @param rq the ServiceRequest<TertiaryEducationProduceRq>.
     * @return the ServiceResponse<TertiaryEducationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TertiaryEducationListMsg> produceTertiaryEducation(ServiceRequest<TertiaryEducationProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new Further Education Instances.
     *
     * @param rq the ServiceRequest<FurtherEducationProduceRq>.
     * @return the ServiceResponse<FurtherEducationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<FurtherEducationListMsg> produceFurtherEducation(ServiceRequest<FurtherEducationProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new Sector Instances.
     *
     * @param rq the ServiceRequest<SectorProduceRq>.
     * @return the ServiceResponse<SectorListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SectorListMsg> produceSector(ServiceRequest<SectorProduceRq> rq) throws ProduceException;

    /**
     * Creates new Activity Area Instances.
     *
     * @param rq the ServiceRequest<ActivityAreaProduceRq>.
     * @return the ServiceResponse<ActivityAreaListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ActivityAreaListMsg> produceActivityArea(ServiceRequest<ActivityAreaProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new Provision Relation Instances.
     *
     * @param rq the ServiceRequest<ProvisionRelationProduceRq>.
     * @return the ServiceResponse<ProvisionRelationListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProvisionRelationListMsg> produceProvisionRelation(ServiceRequest<ProvisionRelationProduceRq> rq)
            throws ProduceException;
}
