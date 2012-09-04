/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.provision.ui.web.communication.resolve;

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
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

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
     * @param session the NabuccoSession.
     * @param message the SkillMsg.
     * @return the SkillMsg.
     * @throws ResolveException
     */
    public SkillMsg resolveSkill(SkillMsg message, NabuccoSession session, ServiceSubContext... subContexts)
            throws ResolveException {
        ServiceRequest<SkillMsg> request = new ServiceRequest<SkillMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SkillMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveSkill");
    }

    /**
     * ResolveEquipment.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EquipmentMsg.
     * @return the EquipmentMsg.
     * @throws ResolveException
     */
    public EquipmentMsg resolveEquipment(EquipmentMsg message, NabuccoSession session, ServiceSubContext... subContexts)
            throws ResolveException {
        ServiceRequest<EquipmentMsg> request = new ServiceRequest<EquipmentMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EquipmentMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveEquipment");
    }

    /**
     * ResolveQualification.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the QualificationMsg.
     * @return the QualificationMsg.
     * @throws ResolveException
     */
    public QualificationMsg resolveQualification(QualificationMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<QualificationMsg> request = new ServiceRequest<QualificationMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<QualificationMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveQualification");
    }

    /**
     * ResolveProvisionGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProvisionGroupMsg.
     * @return the ProvisionGroupMsg.
     * @throws ResolveException
     */
    public ProvisionGroupMsg resolveProvisionGroup(ProvisionGroupMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<ProvisionGroupMsg> request = new ServiceRequest<ProvisionGroupMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionGroupMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveProvisionGroup");
    }

    /**
     * ResolveProvisionAssignment.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProvisionAssignmentMsg.
     * @return the ProvisionAssignmentMsg.
     * @throws ResolveException
     */
    public ProvisionAssignmentMsg resolveProvisionAssignment(ProvisionAssignmentMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<ProvisionAssignmentMsg> request = new ServiceRequest<ProvisionAssignmentMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionAssignmentMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveProvisionAssignment");
    }

    /**
     * ResolveSchoolEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the SchoolEducationMsg.
     * @return the SchoolEducationMsg.
     * @throws ResolveException
     */
    public SchoolEducationMsg resolveSchoolEducation(SchoolEducationMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<SchoolEducationMsg> request = new ServiceRequest<SchoolEducationMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SchoolEducationMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveSchoolEducation");
    }

    /**
     * ResolveJobEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the JobEducationMsg.
     * @return the JobEducationMsg.
     * @throws ResolveException
     */
    public JobEducationMsg resolveJobEducation(JobEducationMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<JobEducationMsg> request = new ServiceRequest<JobEducationMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<JobEducationMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveJobEducation");
    }

    /**
     * ResolveTertiaryEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the TertiaryEducationMsg.
     * @return the TertiaryEducationMsg.
     * @throws ResolveException
     */
    public TertiaryEducationMsg resolveTertiaryEducation(TertiaryEducationMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<TertiaryEducationMsg> request = new ServiceRequest<TertiaryEducationMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<TertiaryEducationMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveTertiaryEducation");
    }

    /**
     * ResolveFurtherEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the FurtherEducationMsg.
     * @return the FurtherEducationMsg.
     * @throws ResolveException
     */
    public FurtherEducationMsg resolveFurtherEducation(FurtherEducationMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<FurtherEducationMsg> request = new ServiceRequest<FurtherEducationMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<FurtherEducationMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveFurtherEducation");
    }

    /**
     * ResolveWorkExperience.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the WorkExperienceMsg.
     * @return the WorkExperienceMsg.
     * @throws ResolveException
     */
    public WorkExperienceMsg resolveWorkExperience(WorkExperienceMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<WorkExperienceMsg> request = new ServiceRequest<WorkExperienceMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WorkExperienceMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveWorkExperience");
    }

    /**
     * ResolveDatatypeList.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ResolveDatatypeListRq.
     * @return the ResolveDatatypeListRs.
     * @throws ResolveException
     */
    public ResolveDatatypeListRs resolveDatatypeList(ResolveDatatypeListRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<ResolveDatatypeListRq> request = new ServiceRequest<ResolveDatatypeListRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ResolveDatatypeListRs> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProvision.resolveDatatypeList");
    }
}
