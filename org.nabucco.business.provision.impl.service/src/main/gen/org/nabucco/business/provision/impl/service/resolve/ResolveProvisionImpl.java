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
package org.nabucco.business.provision.impl.service.resolve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
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
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ResolveProvisionImpl<p/>Resolve Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ResolveProvisionImpl extends ServiceSupport implements ResolveProvision {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResolveProvision";

    private static Map<String, String[]> ASPECTS;

    private ResolveSkillServiceHandler resolveSkillServiceHandler;

    private ResolveEquipmentServiceHandler resolveEquipmentServiceHandler;

    private ResolveQualificationServiceHandler resolveQualificationServiceHandler;

    private ResolveProvisionGroupServiceHandler resolveProvisionGroupServiceHandler;

    private ResolveProvisionAssignmentServiceHandler resolveProvisionAssignmentServiceHandler;

    private ResolveSchoolEducationServiceHandler resolveSchoolEducationServiceHandler;

    private ResolveJobEducationServiceHandler resolveJobEducationServiceHandler;

    private ResolveTertiaryEducationServiceHandler resolveTertiaryEducationServiceHandler;

    private ResolveFurtherEducationServiceHandler resolveFurtherEducationServiceHandler;

    private ResolveWorkExperienceServiceHandler resolveWorkExperienceServiceHandler;

    private ResolveDatatypeListServiceHandler resolveDatatypeListServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ResolveProvisionImpl instance. */
    public ResolveProvisionImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.resolveSkillServiceHandler = injector.inject(ResolveSkillServiceHandler.getId());
        if ((this.resolveSkillServiceHandler != null)) {
            this.resolveSkillServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveSkillServiceHandler.setLogger(super.getLogger());
        }
        this.resolveEquipmentServiceHandler = injector.inject(ResolveEquipmentServiceHandler.getId());
        if ((this.resolveEquipmentServiceHandler != null)) {
            this.resolveEquipmentServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveEquipmentServiceHandler.setLogger(super.getLogger());
        }
        this.resolveQualificationServiceHandler = injector.inject(ResolveQualificationServiceHandler.getId());
        if ((this.resolveQualificationServiceHandler != null)) {
            this.resolveQualificationServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveQualificationServiceHandler.setLogger(super.getLogger());
        }
        this.resolveProvisionGroupServiceHandler = injector.inject(ResolveProvisionGroupServiceHandler.getId());
        if ((this.resolveProvisionGroupServiceHandler != null)) {
            this.resolveProvisionGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveProvisionGroupServiceHandler.setLogger(super.getLogger());
        }
        this.resolveProvisionAssignmentServiceHandler = injector.inject(ResolveProvisionAssignmentServiceHandler
                .getId());
        if ((this.resolveProvisionAssignmentServiceHandler != null)) {
            this.resolveProvisionAssignmentServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveProvisionAssignmentServiceHandler.setLogger(super.getLogger());
        }
        this.resolveSchoolEducationServiceHandler = injector.inject(ResolveSchoolEducationServiceHandler.getId());
        if ((this.resolveSchoolEducationServiceHandler != null)) {
            this.resolveSchoolEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveSchoolEducationServiceHandler.setLogger(super.getLogger());
        }
        this.resolveJobEducationServiceHandler = injector.inject(ResolveJobEducationServiceHandler.getId());
        if ((this.resolveJobEducationServiceHandler != null)) {
            this.resolveJobEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveJobEducationServiceHandler.setLogger(super.getLogger());
        }
        this.resolveTertiaryEducationServiceHandler = injector.inject(ResolveTertiaryEducationServiceHandler.getId());
        if ((this.resolveTertiaryEducationServiceHandler != null)) {
            this.resolveTertiaryEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveTertiaryEducationServiceHandler.setLogger(super.getLogger());
        }
        this.resolveFurtherEducationServiceHandler = injector.inject(ResolveFurtherEducationServiceHandler.getId());
        if ((this.resolveFurtherEducationServiceHandler != null)) {
            this.resolveFurtherEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveFurtherEducationServiceHandler.setLogger(super.getLogger());
        }
        this.resolveWorkExperienceServiceHandler = injector.inject(ResolveWorkExperienceServiceHandler.getId());
        if ((this.resolveWorkExperienceServiceHandler != null)) {
            this.resolveWorkExperienceServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveWorkExperienceServiceHandler.setLogger(super.getLogger());
        }
        this.resolveDatatypeListServiceHandler = injector.inject(ResolveDatatypeListServiceHandler.getId());
        if ((this.resolveDatatypeListServiceHandler != null)) {
            this.resolveDatatypeListServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveDatatypeListServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("resolveSkill", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveEquipment", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveQualification", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveProvisionGroup", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveProvisionAssignment", new String[] { "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.constraining" });
            ASPECTS.put("resolveSchoolEducation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveJobEducation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveTertiaryEducation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveFurtherEducation", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveWorkExperience", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveDatatypeList", new String[] { "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<SkillMsg> resolveSkill(ServiceRequest<SkillMsg> rq) throws ResolveException {
        if ((this.resolveSkillServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveSkill().");
            throw new InjectionException("No service implementation configured for resolveSkill().");
        }
        ServiceResponse<SkillMsg> rs;
        this.resolveSkillServiceHandler.init();
        rs = this.resolveSkillServiceHandler.invoke(rq);
        this.resolveSkillServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EquipmentMsg> resolveEquipment(ServiceRequest<EquipmentMsg> rq) throws ResolveException {
        if ((this.resolveEquipmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveEquipment().");
            throw new InjectionException("No service implementation configured for resolveEquipment().");
        }
        ServiceResponse<EquipmentMsg> rs;
        this.resolveEquipmentServiceHandler.init();
        rs = this.resolveEquipmentServiceHandler.invoke(rq);
        this.resolveEquipmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<QualificationMsg> resolveQualification(ServiceRequest<QualificationMsg> rq)
            throws ResolveException {
        if ((this.resolveQualificationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveQualification().");
            throw new InjectionException("No service implementation configured for resolveQualification().");
        }
        ServiceResponse<QualificationMsg> rs;
        this.resolveQualificationServiceHandler.init();
        rs = this.resolveQualificationServiceHandler.invoke(rq);
        this.resolveQualificationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionGroupMsg> resolveProvisionGroup(ServiceRequest<ProvisionGroupMsg> rq)
            throws ResolveException {
        if ((this.resolveProvisionGroupServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveProvisionGroup().");
            throw new InjectionException("No service implementation configured for resolveProvisionGroup().");
        }
        ServiceResponse<ProvisionGroupMsg> rs;
        this.resolveProvisionGroupServiceHandler.init();
        rs = this.resolveProvisionGroupServiceHandler.invoke(rq);
        this.resolveProvisionGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionAssignmentMsg> resolveProvisionAssignment(ServiceRequest<ProvisionAssignmentMsg> rq)
            throws ResolveException {
        if ((this.resolveProvisionAssignmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveProvisionAssignment().");
            throw new InjectionException("No service implementation configured for resolveProvisionAssignment().");
        }
        ServiceResponse<ProvisionAssignmentMsg> rs;
        this.resolveProvisionAssignmentServiceHandler.init();
        rs = this.resolveProvisionAssignmentServiceHandler.invoke(rq);
        this.resolveProvisionAssignmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SchoolEducationMsg> resolveSchoolEducation(ServiceRequest<SchoolEducationMsg> rq)
            throws ResolveException {
        if ((this.resolveSchoolEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveSchoolEducation().");
            throw new InjectionException("No service implementation configured for resolveSchoolEducation().");
        }
        ServiceResponse<SchoolEducationMsg> rs;
        this.resolveSchoolEducationServiceHandler.init();
        rs = this.resolveSchoolEducationServiceHandler.invoke(rq);
        this.resolveSchoolEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<JobEducationMsg> resolveJobEducation(ServiceRequest<JobEducationMsg> rq)
            throws ResolveException {
        if ((this.resolveJobEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveJobEducation().");
            throw new InjectionException("No service implementation configured for resolveJobEducation().");
        }
        ServiceResponse<JobEducationMsg> rs;
        this.resolveJobEducationServiceHandler.init();
        rs = this.resolveJobEducationServiceHandler.invoke(rq);
        this.resolveJobEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TertiaryEducationMsg> resolveTertiaryEducation(ServiceRequest<TertiaryEducationMsg> rq)
            throws ResolveException {
        if ((this.resolveTertiaryEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveTertiaryEducation().");
            throw new InjectionException("No service implementation configured for resolveTertiaryEducation().");
        }
        ServiceResponse<TertiaryEducationMsg> rs;
        this.resolveTertiaryEducationServiceHandler.init();
        rs = this.resolveTertiaryEducationServiceHandler.invoke(rq);
        this.resolveTertiaryEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<FurtherEducationMsg> resolveFurtherEducation(ServiceRequest<FurtherEducationMsg> rq)
            throws ResolveException {
        if ((this.resolveFurtherEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveFurtherEducation().");
            throw new InjectionException("No service implementation configured for resolveFurtherEducation().");
        }
        ServiceResponse<FurtherEducationMsg> rs;
        this.resolveFurtherEducationServiceHandler.init();
        rs = this.resolveFurtherEducationServiceHandler.invoke(rq);
        this.resolveFurtherEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WorkExperienceMsg> resolveWorkExperience(ServiceRequest<WorkExperienceMsg> rq)
            throws ResolveException {
        if ((this.resolveWorkExperienceServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveWorkExperience().");
            throw new InjectionException("No service implementation configured for resolveWorkExperience().");
        }
        ServiceResponse<WorkExperienceMsg> rs;
        this.resolveWorkExperienceServiceHandler.init();
        rs = this.resolveWorkExperienceServiceHandler.invoke(rq);
        this.resolveWorkExperienceServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ResolveDatatypeListRs> resolveDatatypeList(ServiceRequest<ResolveDatatypeListRq> rq)
            throws ResolveException {
        if ((this.resolveDatatypeListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveDatatypeList().");
            throw new InjectionException("No service implementation configured for resolveDatatypeList().");
        }
        ServiceResponse<ResolveDatatypeListRs> rs;
        this.resolveDatatypeListServiceHandler.init();
        rs = this.resolveDatatypeListServiceHandler.invoke(rq);
        this.resolveDatatypeListServiceHandler.finish();
        return rs;
    }
}
