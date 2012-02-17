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
package org.nabucco.business.provision.impl.service.maintain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
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
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * MaintainProvisionImpl<p/>Maintain Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class MaintainProvisionImpl extends ServiceSupport implements MaintainProvision {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainProvision";

    private static Map<String, String[]> ASPECTS;

    private MaintainSkillServiceHandler maintainSkillServiceHandler;

    private MaintainEquipmentServiceHandler maintainEquipmentServiceHandler;

    private MaintainQualificationServiceHandler maintainQualificationServiceHandler;

    private MaintainProvisionGroupServiceHandler maintainProvisionGroupServiceHandler;

    private MaintainProvisionAssignmentServiceHandler maintainProvisionAssignmentServiceHandler;

    private MaintainSchoolEducationServiceHandler maintainSchoolEducationServiceHandler;

    private MaintainJobEducationServiceHandler maintainJobEducationServiceHandler;

    private MaintainTertiaryEducationServiceHandler maintainTertiaryEducationServiceHandler;

    private MaintainFurtherEducationServiceHandler maintainFurtherEducationServiceHandler;

    private MaintainWorkExperienceServiceHandler maintainWorkExperienceServiceHandler;

    private UnassignChildServiceHandler unassignChildServiceHandler;

    private MoveProvisionCharacteristicServiceHandler moveProvisionCharacteristicServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new MaintainProvisionImpl instance. */
    public MaintainProvisionImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.maintainSkillServiceHandler = injector.inject(MaintainSkillServiceHandler.getId());
        if ((this.maintainSkillServiceHandler != null)) {
            this.maintainSkillServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainSkillServiceHandler.setLogger(super.getLogger());
        }
        this.maintainEquipmentServiceHandler = injector.inject(MaintainEquipmentServiceHandler.getId());
        if ((this.maintainEquipmentServiceHandler != null)) {
            this.maintainEquipmentServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainEquipmentServiceHandler.setLogger(super.getLogger());
        }
        this.maintainQualificationServiceHandler = injector.inject(MaintainQualificationServiceHandler.getId());
        if ((this.maintainQualificationServiceHandler != null)) {
            this.maintainQualificationServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainQualificationServiceHandler.setLogger(super.getLogger());
        }
        this.maintainProvisionGroupServiceHandler = injector.inject(MaintainProvisionGroupServiceHandler.getId());
        if ((this.maintainProvisionGroupServiceHandler != null)) {
            this.maintainProvisionGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainProvisionGroupServiceHandler.setLogger(super.getLogger());
        }
        this.maintainProvisionAssignmentServiceHandler = injector.inject(MaintainProvisionAssignmentServiceHandler
                .getId());
        if ((this.maintainProvisionAssignmentServiceHandler != null)) {
            this.maintainProvisionAssignmentServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainProvisionAssignmentServiceHandler.setLogger(super.getLogger());
        }
        this.maintainSchoolEducationServiceHandler = injector.inject(MaintainSchoolEducationServiceHandler.getId());
        if ((this.maintainSchoolEducationServiceHandler != null)) {
            this.maintainSchoolEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainSchoolEducationServiceHandler.setLogger(super.getLogger());
        }
        this.maintainJobEducationServiceHandler = injector.inject(MaintainJobEducationServiceHandler.getId());
        if ((this.maintainJobEducationServiceHandler != null)) {
            this.maintainJobEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainJobEducationServiceHandler.setLogger(super.getLogger());
        }
        this.maintainTertiaryEducationServiceHandler = injector.inject(MaintainTertiaryEducationServiceHandler.getId());
        if ((this.maintainTertiaryEducationServiceHandler != null)) {
            this.maintainTertiaryEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainTertiaryEducationServiceHandler.setLogger(super.getLogger());
        }
        this.maintainFurtherEducationServiceHandler = injector.inject(MaintainFurtherEducationServiceHandler.getId());
        if ((this.maintainFurtherEducationServiceHandler != null)) {
            this.maintainFurtherEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainFurtherEducationServiceHandler.setLogger(super.getLogger());
        }
        this.maintainWorkExperienceServiceHandler = injector.inject(MaintainWorkExperienceServiceHandler.getId());
        if ((this.maintainWorkExperienceServiceHandler != null)) {
            this.maintainWorkExperienceServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainWorkExperienceServiceHandler.setLogger(super.getLogger());
        }
        this.unassignChildServiceHandler = injector.inject(UnassignChildServiceHandler.getId());
        if ((this.unassignChildServiceHandler != null)) {
            this.unassignChildServiceHandler.setPersistenceManager(persistenceManager);
            this.unassignChildServiceHandler.setLogger(super.getLogger());
        }
        this.moveProvisionCharacteristicServiceHandler = injector.inject(MoveProvisionCharacteristicServiceHandler
                .getId());
        if ((this.moveProvisionCharacteristicServiceHandler != null)) {
            this.moveProvisionCharacteristicServiceHandler.setPersistenceManager(persistenceManager);
            this.moveProvisionCharacteristicServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("maintainSkill", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainEquipment", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainQualification", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainProvisionGroup", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainProvisionAssignment", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.constraining", "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainSchoolEducation", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainJobEducation", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainTertiaryEducation", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainFurtherEducation", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainWorkExperience", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("unassignChild", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
            ASPECTS.put("moveProvisionCharacteristic", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<SkillMsg> maintainSkill(ServiceRequest<SkillMsg> rq) throws MaintainException {
        if ((this.maintainSkillServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainSkill().");
            throw new InjectionException("No service implementation configured for maintainSkill().");
        }
        ServiceResponse<SkillMsg> rs;
        this.maintainSkillServiceHandler.init();
        rs = this.maintainSkillServiceHandler.invoke(rq);
        this.maintainSkillServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EquipmentMsg> maintainEquipment(ServiceRequest<EquipmentMsg> rq) throws MaintainException {
        if ((this.maintainEquipmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainEquipment().");
            throw new InjectionException("No service implementation configured for maintainEquipment().");
        }
        ServiceResponse<EquipmentMsg> rs;
        this.maintainEquipmentServiceHandler.init();
        rs = this.maintainEquipmentServiceHandler.invoke(rq);
        this.maintainEquipmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<QualificationMsg> maintainQualification(ServiceRequest<QualificationMsg> rq)
            throws MaintainException {
        if ((this.maintainQualificationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainQualification().");
            throw new InjectionException("No service implementation configured for maintainQualification().");
        }
        ServiceResponse<QualificationMsg> rs;
        this.maintainQualificationServiceHandler.init();
        rs = this.maintainQualificationServiceHandler.invoke(rq);
        this.maintainQualificationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionGroupMsg> maintainProvisionGroup(ServiceRequest<ProvisionGroupMsg> rq)
            throws MaintainException {
        if ((this.maintainProvisionGroupServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainProvisionGroup().");
            throw new InjectionException("No service implementation configured for maintainProvisionGroup().");
        }
        ServiceResponse<ProvisionGroupMsg> rs;
        this.maintainProvisionGroupServiceHandler.init();
        rs = this.maintainProvisionGroupServiceHandler.invoke(rq);
        this.maintainProvisionGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionAssignmentMsg> maintainProvisionAssignment(ServiceRequest<ProvisionAssignmentMsg> rq)
            throws MaintainException {
        if ((this.maintainProvisionAssignmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainProvisionAssignment().");
            throw new InjectionException("No service implementation configured for maintainProvisionAssignment().");
        }
        ServiceResponse<ProvisionAssignmentMsg> rs;
        this.maintainProvisionAssignmentServiceHandler.init();
        rs = this.maintainProvisionAssignmentServiceHandler.invoke(rq);
        this.maintainProvisionAssignmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SchoolEducationMsg> maintainSchoolEducation(ServiceRequest<SchoolEducationMsg> rq)
            throws MaintainException {
        if ((this.maintainSchoolEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainSchoolEducation().");
            throw new InjectionException("No service implementation configured for maintainSchoolEducation().");
        }
        ServiceResponse<SchoolEducationMsg> rs;
        this.maintainSchoolEducationServiceHandler.init();
        rs = this.maintainSchoolEducationServiceHandler.invoke(rq);
        this.maintainSchoolEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<JobEducationMsg> maintainJobEducation(ServiceRequest<JobEducationMsg> rq)
            throws MaintainException {
        if ((this.maintainJobEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainJobEducation().");
            throw new InjectionException("No service implementation configured for maintainJobEducation().");
        }
        ServiceResponse<JobEducationMsg> rs;
        this.maintainJobEducationServiceHandler.init();
        rs = this.maintainJobEducationServiceHandler.invoke(rq);
        this.maintainJobEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TertiaryEducationMsg> maintainTertiaryEducation(ServiceRequest<TertiaryEducationMsg> rq)
            throws MaintainException {
        if ((this.maintainTertiaryEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainTertiaryEducation().");
            throw new InjectionException("No service implementation configured for maintainTertiaryEducation().");
        }
        ServiceResponse<TertiaryEducationMsg> rs;
        this.maintainTertiaryEducationServiceHandler.init();
        rs = this.maintainTertiaryEducationServiceHandler.invoke(rq);
        this.maintainTertiaryEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<FurtherEducationMsg> maintainFurtherEducation(ServiceRequest<FurtherEducationMsg> rq)
            throws MaintainException {
        if ((this.maintainFurtherEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainFurtherEducation().");
            throw new InjectionException("No service implementation configured for maintainFurtherEducation().");
        }
        ServiceResponse<FurtherEducationMsg> rs;
        this.maintainFurtherEducationServiceHandler.init();
        rs = this.maintainFurtherEducationServiceHandler.invoke(rq);
        this.maintainFurtherEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WorkExperienceMsg> maintainWorkExperience(ServiceRequest<WorkExperienceMsg> rq)
            throws MaintainException {
        if ((this.maintainWorkExperienceServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainWorkExperience().");
            throw new InjectionException("No service implementation configured for maintainWorkExperience().");
        }
        ServiceResponse<WorkExperienceMsg> rs;
        this.maintainWorkExperienceServiceHandler.init();
        rs = this.maintainWorkExperienceServiceHandler.invoke(rq);
        this.maintainWorkExperienceServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionGroupMsg> unassignChild(ServiceRequest<UnassignChildMsg> rq)
            throws MaintainException {
        if ((this.unassignChildServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for unassignChild().");
            throw new InjectionException("No service implementation configured for unassignChild().");
        }
        ServiceResponse<ProvisionGroupMsg> rs;
        this.unassignChildServiceHandler.init();
        rs = this.unassignChildServiceHandler.invoke(rq);
        this.unassignChildServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionGroupMsg> moveProvisionCharacteristic(
            ServiceRequest<MoveProvisionCharacteristicMsg> rq) throws MaintainException {
        if ((this.moveProvisionCharacteristicServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for moveProvisionCharacteristic().");
            throw new InjectionException("No service implementation configured for moveProvisionCharacteristic().");
        }
        ServiceResponse<ProvisionGroupMsg> rs;
        this.moveProvisionCharacteristicServiceHandler.init();
        rs = this.moveProvisionCharacteristicServiceHandler.invoke(rq);
        this.moveProvisionCharacteristicServiceHandler.finish();
        return rs;
    }
}
