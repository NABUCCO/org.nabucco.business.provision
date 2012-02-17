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
package org.nabucco.business.provision.impl.service.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
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
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * SearchProvisionImpl<p/>Search Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class SearchProvisionImpl extends ServiceSupport implements SearchProvision {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchProvision";

    private static Map<String, String[]> ASPECTS;

    private SearchSkillServiceHandler searchSkillServiceHandler;

    private SearchEquipmentServiceHandler searchEquipmentServiceHandler;

    private SearchProvisionGroupServiceHandler searchProvisionGroupServiceHandler;

    private SearchProvisionAssignmentServiceHandler searchProvisionAssignmentServiceHandler;

    private SearchQualificationServiceHandler searchQualificationServiceHandler;

    private SearchSchoolEducationServiceHandler searchSchoolEducationServiceHandler;

    private SearchJobEducationServiceHandler searchJobEducationServiceHandler;

    private SearchTertiaryEducationServiceHandler searchTertiaryEducationServiceHandler;

    private SearchFurtherEducationServiceHandler searchFurtherEducationServiceHandler;

    private SearchWorkExperienceServiceHandler searchWorkExperienceServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new SearchProvisionImpl instance. */
    public SearchProvisionImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchSkillServiceHandler = injector.inject(SearchSkillServiceHandler.getId());
        if ((this.searchSkillServiceHandler != null)) {
            this.searchSkillServiceHandler.setPersistenceManager(persistenceManager);
            this.searchSkillServiceHandler.setLogger(super.getLogger());
        }
        this.searchEquipmentServiceHandler = injector.inject(SearchEquipmentServiceHandler.getId());
        if ((this.searchEquipmentServiceHandler != null)) {
            this.searchEquipmentServiceHandler.setPersistenceManager(persistenceManager);
            this.searchEquipmentServiceHandler.setLogger(super.getLogger());
        }
        this.searchProvisionGroupServiceHandler = injector.inject(SearchProvisionGroupServiceHandler.getId());
        if ((this.searchProvisionGroupServiceHandler != null)) {
            this.searchProvisionGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.searchProvisionGroupServiceHandler.setLogger(super.getLogger());
        }
        this.searchProvisionAssignmentServiceHandler = injector.inject(SearchProvisionAssignmentServiceHandler.getId());
        if ((this.searchProvisionAssignmentServiceHandler != null)) {
            this.searchProvisionAssignmentServiceHandler.setPersistenceManager(persistenceManager);
            this.searchProvisionAssignmentServiceHandler.setLogger(super.getLogger());
        }
        this.searchQualificationServiceHandler = injector.inject(SearchQualificationServiceHandler.getId());
        if ((this.searchQualificationServiceHandler != null)) {
            this.searchQualificationServiceHandler.setPersistenceManager(persistenceManager);
            this.searchQualificationServiceHandler.setLogger(super.getLogger());
        }
        this.searchSchoolEducationServiceHandler = injector.inject(SearchSchoolEducationServiceHandler.getId());
        if ((this.searchSchoolEducationServiceHandler != null)) {
            this.searchSchoolEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.searchSchoolEducationServiceHandler.setLogger(super.getLogger());
        }
        this.searchJobEducationServiceHandler = injector.inject(SearchJobEducationServiceHandler.getId());
        if ((this.searchJobEducationServiceHandler != null)) {
            this.searchJobEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.searchJobEducationServiceHandler.setLogger(super.getLogger());
        }
        this.searchTertiaryEducationServiceHandler = injector.inject(SearchTertiaryEducationServiceHandler.getId());
        if ((this.searchTertiaryEducationServiceHandler != null)) {
            this.searchTertiaryEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.searchTertiaryEducationServiceHandler.setLogger(super.getLogger());
        }
        this.searchFurtherEducationServiceHandler = injector.inject(SearchFurtherEducationServiceHandler.getId());
        if ((this.searchFurtherEducationServiceHandler != null)) {
            this.searchFurtherEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.searchFurtherEducationServiceHandler.setLogger(super.getLogger());
        }
        this.searchWorkExperienceServiceHandler = injector.inject(SearchWorkExperienceServiceHandler.getId());
        if ((this.searchWorkExperienceServiceHandler != null)) {
            this.searchWorkExperienceServiceHandler.setPersistenceManager(persistenceManager);
            this.searchWorkExperienceServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("searchSkill", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchEquipment", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchProvisionGroup", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchProvisionAssignment", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchQualification", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchSchoolEducation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchJobEducation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchTertiaryEducation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchFurtherEducation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchWorkExperience", new String[] { "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<SkillListMsg> searchSkill(ServiceRequest<SkillSearchRq> rq) throws SearchException {
        if ((this.searchSkillServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchSkill().");
            throw new InjectionException("No service implementation configured for searchSkill().");
        }
        ServiceResponse<SkillListMsg> rs;
        this.searchSkillServiceHandler.init();
        rs = this.searchSkillServiceHandler.invoke(rq);
        this.searchSkillServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EquipmentListMsg> searchEquipment(ServiceRequest<EquipmentSearchRq> rq)
            throws SearchException {
        if ((this.searchEquipmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchEquipment().");
            throw new InjectionException("No service implementation configured for searchEquipment().");
        }
        ServiceResponse<EquipmentListMsg> rs;
        this.searchEquipmentServiceHandler.init();
        rs = this.searchEquipmentServiceHandler.invoke(rq);
        this.searchEquipmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionGroupListMsg> searchProvisionGroup(ServiceRequest<ProvisionGroupSearchRq> rq)
            throws SearchException {
        if ((this.searchProvisionGroupServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchProvisionGroup().");
            throw new InjectionException("No service implementation configured for searchProvisionGroup().");
        }
        ServiceResponse<ProvisionGroupListMsg> rs;
        this.searchProvisionGroupServiceHandler.init();
        rs = this.searchProvisionGroupServiceHandler.invoke(rq);
        this.searchProvisionGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionAssignmentListMsg> searchProvisionAssignment(
            ServiceRequest<ProvisionAssignmentSearchRq> rq) throws SearchException {
        if ((this.searchProvisionAssignmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchProvisionAssignment().");
            throw new InjectionException("No service implementation configured for searchProvisionAssignment().");
        }
        ServiceResponse<ProvisionAssignmentListMsg> rs;
        this.searchProvisionAssignmentServiceHandler.init();
        rs = this.searchProvisionAssignmentServiceHandler.invoke(rq);
        this.searchProvisionAssignmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<QualificationListMsg> searchQualification(ServiceRequest<QualificationSearchRq> rq)
            throws SearchException {
        if ((this.searchQualificationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchQualification().");
            throw new InjectionException("No service implementation configured for searchQualification().");
        }
        ServiceResponse<QualificationListMsg> rs;
        this.searchQualificationServiceHandler.init();
        rs = this.searchQualificationServiceHandler.invoke(rq);
        this.searchQualificationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SchoolEducationListMsg> searchSchoolEducation(ServiceRequest<SchoolEducationSearchRq> rq)
            throws SearchException {
        if ((this.searchSchoolEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchSchoolEducation().");
            throw new InjectionException("No service implementation configured for searchSchoolEducation().");
        }
        ServiceResponse<SchoolEducationListMsg> rs;
        this.searchSchoolEducationServiceHandler.init();
        rs = this.searchSchoolEducationServiceHandler.invoke(rq);
        this.searchSchoolEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<JobEducationListMsg> searchJobEducation(ServiceRequest<JobEducationSearchRq> rq)
            throws SearchException {
        if ((this.searchJobEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchJobEducation().");
            throw new InjectionException("No service implementation configured for searchJobEducation().");
        }
        ServiceResponse<JobEducationListMsg> rs;
        this.searchJobEducationServiceHandler.init();
        rs = this.searchJobEducationServiceHandler.invoke(rq);
        this.searchJobEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TertiaryEducationListMsg> searchTertiaryEducation(
            ServiceRequest<TertiaryEducationSearchRq> rq) throws SearchException {
        if ((this.searchTertiaryEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchTertiaryEducation().");
            throw new InjectionException("No service implementation configured for searchTertiaryEducation().");
        }
        ServiceResponse<TertiaryEducationListMsg> rs;
        this.searchTertiaryEducationServiceHandler.init();
        rs = this.searchTertiaryEducationServiceHandler.invoke(rq);
        this.searchTertiaryEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<FurtherEducationListMsg> searchFurtherEducation(ServiceRequest<FurtherEducationSearchRq> rq)
            throws SearchException {
        if ((this.searchFurtherEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchFurtherEducation().");
            throw new InjectionException("No service implementation configured for searchFurtherEducation().");
        }
        ServiceResponse<FurtherEducationListMsg> rs;
        this.searchFurtherEducationServiceHandler.init();
        rs = this.searchFurtherEducationServiceHandler.invoke(rq);
        this.searchFurtherEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WorkExperienceListMsg> searchWorkExperience(ServiceRequest<WorkExperienceSearchRq> rq)
            throws SearchException {
        if ((this.searchWorkExperienceServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchWorkExperience().");
            throw new InjectionException("No service implementation configured for searchWorkExperience().");
        }
        ServiceResponse<WorkExperienceListMsg> rs;
        this.searchWorkExperienceServiceHandler.init();
        rs = this.searchWorkExperienceServiceHandler.invoke(rq);
        this.searchWorkExperienceServiceHandler.finish();
        return rs;
    }
}
