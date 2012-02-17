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
package org.nabucco.business.provision.ui.rcp.communication.search;

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
import org.nabucco.business.provision.facade.service.search.SearchProvision;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * SearchProvisionDelegate<p/>Search Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class SearchProvisionDelegate extends ServiceDelegateSupport {

    private SearchProvision service;

    /**
     * Constructs a new SearchProvisionDelegate instance.
     *
     * @param service the SearchProvision.
     */
    public SearchProvisionDelegate(SearchProvision service) {
        super();
        this.service = service;
    }

    /**
     * SearchSkill.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SkillSearchRq.
     * @return the SkillListMsg.
     * @throws ClientException
     */
    public SkillListMsg searchSkill(SkillSearchRq message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<SkillSearchRq> request = new ServiceRequest<SkillSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SkillListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchSkill(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchSkill", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchSkill");
    }

    /**
     * SearchEquipment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EquipmentSearchRq.
     * @return the EquipmentListMsg.
     * @throws ClientException
     */
    public EquipmentListMsg searchEquipment(EquipmentSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EquipmentSearchRq> request = new ServiceRequest<EquipmentSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EquipmentListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchEquipment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchEquipment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchEquipment");
    }

    /**
     * SearchProvisionGroup.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionGroupSearchRq.
     * @return the ProvisionGroupListMsg.
     * @throws ClientException
     */
    public ProvisionGroupListMsg searchProvisionGroup(ProvisionGroupSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ProvisionGroupSearchRq> request = new ServiceRequest<ProvisionGroupSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionGroupListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchProvisionGroup(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchProvisionGroup", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchProvisionGroup");
    }

    /**
     * SearchProvisionAssignment.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProvisionAssignmentSearchRq.
     * @return the ProvisionAssignmentListMsg.
     * @throws ClientException
     */
    public ProvisionAssignmentListMsg searchProvisionAssignment(ProvisionAssignmentSearchRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProvisionAssignmentSearchRq> request = new ServiceRequest<ProvisionAssignmentSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProvisionAssignmentListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchProvisionAssignment(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchProvisionAssignment", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchProvisionAssignment");
    }

    /**
     * SearchQualification.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the QualificationSearchRq.
     * @return the QualificationListMsg.
     * @throws ClientException
     */
    public QualificationListMsg searchQualification(QualificationSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<QualificationSearchRq> request = new ServiceRequest<QualificationSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<QualificationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchQualification(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchQualification", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchQualification");
    }

    /**
     * SearchSchoolEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SchoolEducationSearchRq.
     * @return the SchoolEducationListMsg.
     * @throws ClientException
     */
    public SchoolEducationListMsg searchSchoolEducation(SchoolEducationSearchRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<SchoolEducationSearchRq> request = new ServiceRequest<SchoolEducationSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SchoolEducationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchSchoolEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchSchoolEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchSchoolEducation");
    }

    /**
     * SearchJobEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the JobEducationSearchRq.
     * @return the JobEducationListMsg.
     * @throws ClientException
     */
    public JobEducationListMsg searchJobEducation(JobEducationSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<JobEducationSearchRq> request = new ServiceRequest<JobEducationSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<JobEducationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchJobEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchJobEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchJobEducation");
    }

    /**
     * SearchTertiaryEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the TertiaryEducationSearchRq.
     * @return the TertiaryEducationListMsg.
     * @throws ClientException
     */
    public TertiaryEducationListMsg searchTertiaryEducation(TertiaryEducationSearchRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<TertiaryEducationSearchRq> request = new ServiceRequest<TertiaryEducationSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<TertiaryEducationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchTertiaryEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchTertiaryEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchTertiaryEducation");
    }

    /**
     * SearchFurtherEducation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the FurtherEducationSearchRq.
     * @return the FurtherEducationListMsg.
     * @throws ClientException
     */
    public FurtherEducationListMsg searchFurtherEducation(FurtherEducationSearchRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<FurtherEducationSearchRq> request = new ServiceRequest<FurtherEducationSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<FurtherEducationListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchFurtherEducation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchFurtherEducation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchFurtherEducation");
    }

    /**
     * SearchWorkExperience.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WorkExperienceSearchRq.
     * @return the WorkExperienceListMsg.
     * @throws ClientException
     */
    public WorkExperienceListMsg searchWorkExperience(WorkExperienceSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<WorkExperienceSearchRq> request = new ServiceRequest<WorkExperienceSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WorkExperienceListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchWorkExperience(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProvision.class, "searchWorkExperience", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchProvision.searchWorkExperience");
    }
}
