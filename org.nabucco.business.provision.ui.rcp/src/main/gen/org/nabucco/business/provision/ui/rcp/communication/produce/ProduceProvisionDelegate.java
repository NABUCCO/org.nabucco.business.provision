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
package org.nabucco.business.provision.ui.rcp.communication.produce;

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
import org.nabucco.business.provision.facade.service.produce.ProduceProvision;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ProduceProvisionDelegate<p/>Produce Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProduceProvisionDelegate extends ServiceDelegateSupport {

    private ProduceProvision service;

    /**
     * Constructs a new ProduceProvisionDelegate instance.
     *
     * @param service the ProduceProvision.
     */
    public ProduceProvisionDelegate(ProduceProvision service) {
        super();
        this.service = service;
    }

    /**
     * ProduceSkill.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SkillProduceRq.
     * @return the SkillListMsg.
     * @throws ClientException
     */
    public SkillListMsg produceSkill(SkillProduceRq message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<SkillProduceRq> request = new ServiceRequest<SkillProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SkillListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceSkill(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceSkill", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceSkill");
    }

    /**
     * ProduceEquipment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EquipmentProduceRq.
     * @return the EquipmentListMsg.
     * @throws ClientException
     */
    public EquipmentListMsg produceEquipment(EquipmentProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EquipmentProduceRq> request = new ServiceRequest<EquipmentProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EquipmentListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEquipment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceEquipment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceEquipment");
    }

    /**
     * ProduceQualification.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the QualificationProduceRq.
     * @return the QualificationListMsg.
     * @throws ClientException
     */
    public QualificationListMsg produceQualification(QualificationProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<QualificationProduceRq> request = new ServiceRequest<QualificationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<QualificationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceQualification(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceQualification", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceQualification");
    }

    /**
     * ProduceProvisionGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionGroupProduceRq.
     * @return the ProvisionGroupListMsg.
     * @throws ClientException
     */
    public ProvisionGroupListMsg produceProvisionGroup(ProvisionGroupProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProvisionGroupProduceRq> request = new ServiceRequest<ProvisionGroupProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionGroupListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProvisionGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceProvisionGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceProvisionGroup");
    }

    /**
     * ProduceProvisionAssignment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionAssignmentProduceRq.
     * @return the ProvisionAssignmentListMsg.
     * @throws ClientException
     */
    public ProvisionAssignmentListMsg produceProvisionAssignment(ProvisionAssignmentProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProvisionAssignmentProduceRq> request = new ServiceRequest<ProvisionAssignmentProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionAssignmentListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProvisionAssignment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceProvisionAssignment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceProvisionAssignment");
    }

    /**
     * ProduceProvisionAssignmentHistory.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionAssignmentHistoryProduceRq.
     * @return the ProvisionAssignmentHistoryListMsg.
     * @throws ClientException
     */
    public ProvisionAssignmentHistoryListMsg produceProvisionAssignmentHistory(
            ProvisionAssignmentHistoryProduceRq message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProvisionAssignmentHistoryProduceRq> request = new ServiceRequest<ProvisionAssignmentHistoryProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionAssignmentHistoryListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProvisionAssignmentHistory(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceProvisionAssignmentHistory", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceProvision.produceProvisionAssignmentHistory");
    }

    /**
     * ProduceWorkExperience.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WorkExperienceProduceRq.
     * @return the WorkExperienceListMsg.
     * @throws ClientException
     */
    public WorkExperienceListMsg produceWorkExperience(WorkExperienceProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<WorkExperienceProduceRq> request = new ServiceRequest<WorkExperienceProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WorkExperienceListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceWorkExperience(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceWorkExperience", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceWorkExperience");
    }

    /**
     * ProduceSchoolEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SchoolEducationProduceRq.
     * @return the SchoolEducationListMsg.
     * @throws ClientException
     */
    public SchoolEducationListMsg produceSchoolEducation(SchoolEducationProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<SchoolEducationProduceRq> request = new ServiceRequest<SchoolEducationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SchoolEducationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceSchoolEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceSchoolEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceSchoolEducation");
    }

    /**
     * ProduceJobEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the JobEducationProduceRq.
     * @return the JobEducationListMsg.
     * @throws ClientException
     */
    public JobEducationListMsg produceJobEducation(JobEducationProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<JobEducationProduceRq> request = new ServiceRequest<JobEducationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<JobEducationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceJobEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceJobEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceJobEducation");
    }

    /**
     * ProduceTertiaryEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the TertiaryEducationProduceRq.
     * @return the TertiaryEducationListMsg.
     * @throws ClientException
     */
    public TertiaryEducationListMsg produceTertiaryEducation(TertiaryEducationProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<TertiaryEducationProduceRq> request = new ServiceRequest<TertiaryEducationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<TertiaryEducationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceTertiaryEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceTertiaryEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceTertiaryEducation");
    }

    /**
     * ProduceFurtherEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the FurtherEducationProduceRq.
     * @return the FurtherEducationListMsg.
     * @throws ClientException
     */
    public FurtherEducationListMsg produceFurtherEducation(FurtherEducationProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<FurtherEducationProduceRq> request = new ServiceRequest<FurtherEducationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<FurtherEducationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceFurtherEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceFurtherEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceFurtherEducation");
    }

    /**
     * ProduceSector.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SectorProduceRq.
     * @return the SectorListMsg.
     * @throws ClientException
     */
    public SectorListMsg produceSector(SectorProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<SectorProduceRq> request = new ServiceRequest<SectorProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SectorListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceSector(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceSector", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceSector");
    }

    /**
     * ProduceActivityArea.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ActivityAreaProduceRq.
     * @return the ActivityAreaListMsg.
     * @throws ClientException
     */
    public ActivityAreaListMsg produceActivityArea(ActivityAreaProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ActivityAreaProduceRq> request = new ServiceRequest<ActivityAreaProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ActivityAreaListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceActivityArea(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceActivityArea", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceActivityArea");
    }

    /**
     * ProduceProvisionRelation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionRelationProduceRq.
     * @return the ProvisionRelationListMsg.
     * @throws ClientException
     */
    public ProvisionRelationListMsg produceProvisionRelation(ProvisionRelationProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProvisionRelationProduceRq> request = new ServiceRequest<ProvisionRelationProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionRelationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProvisionRelation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProvision.class, "produceProvisionRelation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProvision.produceProvisionRelation");
    }
}
