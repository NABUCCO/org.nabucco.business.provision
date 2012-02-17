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
package org.nabucco.business.provision.ui.rcp.communication.maintain;

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
import org.nabucco.business.provision.facade.service.maintain.MaintainProvision;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * MaintainProvisionDelegate<p/>Maintain Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class MaintainProvisionDelegate extends ServiceDelegateSupport {

    private MaintainProvision service;

    /**
     * Constructs a new MaintainProvisionDelegate instance.
     *
     * @param service the MaintainProvision.
     */
    public MaintainProvisionDelegate(MaintainProvision service) {
        super();
        this.service = service;
    }

    /**
     * MaintainSkill.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SkillMsg.
     * @return the SkillMsg.
     * @throws ClientException
     */
    public SkillMsg maintainSkill(SkillMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<SkillMsg> request = new ServiceRequest<SkillMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SkillMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainSkill(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainSkill", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainSkill");
    }

    /**
     * MaintainEquipment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EquipmentMsg.
     * @return the EquipmentMsg.
     * @throws ClientException
     */
    public EquipmentMsg maintainEquipment(EquipmentMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EquipmentMsg> request = new ServiceRequest<EquipmentMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EquipmentMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainEquipment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainEquipment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainEquipment");
    }

    /**
     * MaintainQualification.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the QualificationMsg.
     * @return the QualificationMsg.
     * @throws ClientException
     */
    public QualificationMsg maintainQualification(QualificationMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<QualificationMsg> request = new ServiceRequest<QualificationMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<QualificationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainQualification(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainQualification", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainQualification");
    }

    /**
     * MaintainProvisionGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionGroupMsg.
     * @return the ProvisionGroupMsg.
     * @throws ClientException
     */
    public ProvisionGroupMsg maintainProvisionGroup(ProvisionGroupMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ProvisionGroupMsg> request = new ServiceRequest<ProvisionGroupMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionGroupMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainProvisionGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainProvisionGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainProvisionGroup");
    }

    /**
     * MaintainProvisionAssignment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionAssignmentMsg.
     * @return the ProvisionAssignmentMsg.
     * @throws ClientException
     */
    public ProvisionAssignmentMsg maintainProvisionAssignment(ProvisionAssignmentMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProvisionAssignmentMsg> request = new ServiceRequest<ProvisionAssignmentMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionAssignmentMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainProvisionAssignment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainProvisionAssignment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainProvisionAssignment");
    }

    /**
     * MaintainSchoolEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SchoolEducationMsg.
     * @return the SchoolEducationMsg.
     * @throws ClientException
     */
    public SchoolEducationMsg maintainSchoolEducation(SchoolEducationMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<SchoolEducationMsg> request = new ServiceRequest<SchoolEducationMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SchoolEducationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainSchoolEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainSchoolEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainSchoolEducation");
    }

    /**
     * MaintainJobEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the JobEducationMsg.
     * @return the JobEducationMsg.
     * @throws ClientException
     */
    public JobEducationMsg maintainJobEducation(JobEducationMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<JobEducationMsg> request = new ServiceRequest<JobEducationMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<JobEducationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainJobEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainJobEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainJobEducation");
    }

    /**
     * MaintainTertiaryEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the TertiaryEducationMsg.
     * @return the TertiaryEducationMsg.
     * @throws ClientException
     */
    public TertiaryEducationMsg maintainTertiaryEducation(TertiaryEducationMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<TertiaryEducationMsg> request = new ServiceRequest<TertiaryEducationMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<TertiaryEducationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainTertiaryEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainTertiaryEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainTertiaryEducation");
    }

    /**
     * MaintainFurtherEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the FurtherEducationMsg.
     * @return the FurtherEducationMsg.
     * @throws ClientException
     */
    public FurtherEducationMsg maintainFurtherEducation(FurtherEducationMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<FurtherEducationMsg> request = new ServiceRequest<FurtherEducationMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<FurtherEducationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainFurtherEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainFurtherEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainFurtherEducation");
    }

    /**
     * MaintainWorkExperience.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WorkExperienceMsg.
     * @return the WorkExperienceMsg.
     * @throws ClientException
     */
    public WorkExperienceMsg maintainWorkExperience(WorkExperienceMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<WorkExperienceMsg> request = new ServiceRequest<WorkExperienceMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WorkExperienceMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainWorkExperience(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "maintainWorkExperience", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.maintainWorkExperience");
    }

    /**
     * UnassignChild.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the UnassignChildMsg.
     * @return the ProvisionGroupMsg.
     * @throws ClientException
     */
    public ProvisionGroupMsg unassignChild(UnassignChildMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<UnassignChildMsg> request = new ServiceRequest<UnassignChildMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionGroupMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.unassignChild(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "unassignChild", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.unassignChild");
    }

    /**
     * MoveProvisionCharacteristic.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the MoveProvisionCharacteristicMsg.
     * @return the ProvisionGroupMsg.
     * @throws ClientException
     */
    public ProvisionGroupMsg moveProvisionCharacteristic(MoveProvisionCharacteristicMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<MoveProvisionCharacteristicMsg> request = new ServiceRequest<MoveProvisionCharacteristicMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionGroupMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.moveProvisionCharacteristic(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProvision.class, "moveProvisionCharacteristic", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProvision.moveProvisionCharacteristic");
    }
}
