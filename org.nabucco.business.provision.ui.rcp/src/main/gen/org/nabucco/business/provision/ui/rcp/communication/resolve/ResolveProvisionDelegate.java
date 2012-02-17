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
package org.nabucco.business.provision.ui.rcp.communication.resolve;

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
import org.nabucco.business.provision.facade.service.resolve.ResolveProvision;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ResolveProvisionDelegate<p/>Resolve Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ResolveProvisionDelegate extends ServiceDelegateSupport {

    private ResolveProvision service;

    /**
     * Constructs a new ResolveProvisionDelegate instance.
     *
     * @param service the ResolveProvision.
     */
    public ResolveProvisionDelegate(ResolveProvision service) {
        super();
        this.service = service;
    }

    /**
     * ResolveSkill.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SkillMsg.
     * @return the SkillMsg.
     * @throws ClientException
     */
    public SkillMsg resolveSkill(SkillMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<SkillMsg> request = new ServiceRequest<SkillMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SkillMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveSkill(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveSkill", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveSkill");
    }

    /**
     * ResolveEquipment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EquipmentMsg.
     * @return the EquipmentMsg.
     * @throws ClientException
     */
    public EquipmentMsg resolveEquipment(EquipmentMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EquipmentMsg> request = new ServiceRequest<EquipmentMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EquipmentMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveEquipment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveEquipment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveEquipment");
    }

    /**
     * ResolveQualification.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the QualificationMsg.
     * @return the QualificationMsg.
     * @throws ClientException
     */
    public QualificationMsg resolveQualification(QualificationMsg message, ServiceSubContext... subContexts)
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
                response = service.resolveQualification(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveQualification", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveQualification");
    }

    /**
     * ResolveProvisionGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionGroupMsg.
     * @return the ProvisionGroupMsg.
     * @throws ClientException
     */
    public ProvisionGroupMsg resolveProvisionGroup(ProvisionGroupMsg message, ServiceSubContext... subContexts)
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
                response = service.resolveProvisionGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveProvisionGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveProvisionGroup");
    }

    /**
     * ResolveProvisionAssignment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionAssignmentMsg.
     * @return the ProvisionAssignmentMsg.
     * @throws ClientException
     */
    public ProvisionAssignmentMsg resolveProvisionAssignment(ProvisionAssignmentMsg message,
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
                response = service.resolveProvisionAssignment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveProvisionAssignment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveProvisionAssignment");
    }

    /**
     * ResolveSchoolEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SchoolEducationMsg.
     * @return the SchoolEducationMsg.
     * @throws ClientException
     */
    public SchoolEducationMsg resolveSchoolEducation(SchoolEducationMsg message, ServiceSubContext... subContexts)
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
                response = service.resolveSchoolEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveSchoolEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveSchoolEducation");
    }

    /**
     * ResolveJobEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the JobEducationMsg.
     * @return the JobEducationMsg.
     * @throws ClientException
     */
    public JobEducationMsg resolveJobEducation(JobEducationMsg message, ServiceSubContext... subContexts)
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
                response = service.resolveJobEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveJobEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveJobEducation");
    }

    /**
     * ResolveTertiaryEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the TertiaryEducationMsg.
     * @return the TertiaryEducationMsg.
     * @throws ClientException
     */
    public TertiaryEducationMsg resolveTertiaryEducation(TertiaryEducationMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<TertiaryEducationMsg> request = new ServiceRequest<TertiaryEducationMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<TertiaryEducationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveTertiaryEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveTertiaryEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveTertiaryEducation");
    }

    /**
     * ResolveFurtherEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the FurtherEducationMsg.
     * @return the FurtherEducationMsg.
     * @throws ClientException
     */
    public FurtherEducationMsg resolveFurtherEducation(FurtherEducationMsg message, ServiceSubContext... subContexts)
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
                response = service.resolveFurtherEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveFurtherEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveFurtherEducation");
    }

    /**
     * ResolveWorkExperience.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WorkExperienceMsg.
     * @return the WorkExperienceMsg.
     * @throws ClientException
     */
    public WorkExperienceMsg resolveWorkExperience(WorkExperienceMsg message, ServiceSubContext... subContexts)
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
                response = service.resolveWorkExperience(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveWorkExperience", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveWorkExperience");
    }

    /**
     * ResolveDatatypeList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ResolveDatatypeListRq.
     * @return the ResolveDatatypeListRs.
     * @throws ClientException
     */
    public ResolveDatatypeListRs resolveDatatypeList(ResolveDatatypeListRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ResolveDatatypeListRq> request = new ServiceRequest<ResolveDatatypeListRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ResolveDatatypeListRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveDatatypeList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProvision.class, "resolveDatatypeList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveProvision.resolveDatatypeList");
    }
}
