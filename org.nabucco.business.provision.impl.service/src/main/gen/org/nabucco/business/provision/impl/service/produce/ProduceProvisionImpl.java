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
package org.nabucco.business.provision.impl.service.produce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
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
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ProduceProvisionImpl<p/>Produce Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProduceProvisionImpl extends ServiceSupport implements ProduceProvision {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceProvision";

    private static Map<String, String[]> ASPECTS;

    private ProduceSkillServiceHandler produceSkillServiceHandler;

    private ProduceEquipmentServiceHandler produceEquipmentServiceHandler;

    private ProduceQualificationServiceHandler produceQualificationServiceHandler;

    private ProduceProvisionGroupServiceHandler produceProvisionGroupServiceHandler;

    private ProduceProvisionAssignmentServiceHandler produceProvisionAssignmentServiceHandler;

    private ProduceProvisionAssignmentHistoryServiceHandler produceProvisionAssignmentHistoryServiceHandler;

    private ProduceWorkExperienceServiceHandler produceWorkExperienceServiceHandler;

    private ProduceSchoolEducationServiceHandler produceSchoolEducationServiceHandler;

    private ProduceJobEducationServiceHandler produceJobEducationServiceHandler;

    private ProduceTertiaryEducationServiceHandler produceTertiaryEducationServiceHandler;

    private ProduceFurtherEducationServiceHandler produceFurtherEducationServiceHandler;

    private ProduceSectorServiceHandler produceSectorServiceHandler;

    private ProduceActivityAreaServiceHandler produceActivityAreaServiceHandler;

    private ProduceProvisionRelationServiceHandler produceProvisionRelationServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ProduceProvisionImpl instance. */
    public ProduceProvisionImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.produceSkillServiceHandler = injector.inject(ProduceSkillServiceHandler.getId());
        if ((this.produceSkillServiceHandler != null)) {
            this.produceSkillServiceHandler.setPersistenceManager(persistenceManager);
            this.produceSkillServiceHandler.setLogger(super.getLogger());
        }
        this.produceEquipmentServiceHandler = injector.inject(ProduceEquipmentServiceHandler.getId());
        if ((this.produceEquipmentServiceHandler != null)) {
            this.produceEquipmentServiceHandler.setPersistenceManager(persistenceManager);
            this.produceEquipmentServiceHandler.setLogger(super.getLogger());
        }
        this.produceQualificationServiceHandler = injector.inject(ProduceQualificationServiceHandler.getId());
        if ((this.produceQualificationServiceHandler != null)) {
            this.produceQualificationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceQualificationServiceHandler.setLogger(super.getLogger());
        }
        this.produceProvisionGroupServiceHandler = injector.inject(ProduceProvisionGroupServiceHandler.getId());
        if ((this.produceProvisionGroupServiceHandler != null)) {
            this.produceProvisionGroupServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProvisionGroupServiceHandler.setLogger(super.getLogger());
        }
        this.produceProvisionAssignmentServiceHandler = injector.inject(ProduceProvisionAssignmentServiceHandler
                .getId());
        if ((this.produceProvisionAssignmentServiceHandler != null)) {
            this.produceProvisionAssignmentServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProvisionAssignmentServiceHandler.setLogger(super.getLogger());
        }
        this.produceProvisionAssignmentHistoryServiceHandler = injector
                .inject(ProduceProvisionAssignmentHistoryServiceHandler.getId());
        if ((this.produceProvisionAssignmentHistoryServiceHandler != null)) {
            this.produceProvisionAssignmentHistoryServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProvisionAssignmentHistoryServiceHandler.setLogger(super.getLogger());
        }
        this.produceWorkExperienceServiceHandler = injector.inject(ProduceWorkExperienceServiceHandler.getId());
        if ((this.produceWorkExperienceServiceHandler != null)) {
            this.produceWorkExperienceServiceHandler.setPersistenceManager(persistenceManager);
            this.produceWorkExperienceServiceHandler.setLogger(super.getLogger());
        }
        this.produceSchoolEducationServiceHandler = injector.inject(ProduceSchoolEducationServiceHandler.getId());
        if ((this.produceSchoolEducationServiceHandler != null)) {
            this.produceSchoolEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceSchoolEducationServiceHandler.setLogger(super.getLogger());
        }
        this.produceJobEducationServiceHandler = injector.inject(ProduceJobEducationServiceHandler.getId());
        if ((this.produceJobEducationServiceHandler != null)) {
            this.produceJobEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceJobEducationServiceHandler.setLogger(super.getLogger());
        }
        this.produceTertiaryEducationServiceHandler = injector.inject(ProduceTertiaryEducationServiceHandler.getId());
        if ((this.produceTertiaryEducationServiceHandler != null)) {
            this.produceTertiaryEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceTertiaryEducationServiceHandler.setLogger(super.getLogger());
        }
        this.produceFurtherEducationServiceHandler = injector.inject(ProduceFurtherEducationServiceHandler.getId());
        if ((this.produceFurtherEducationServiceHandler != null)) {
            this.produceFurtherEducationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceFurtherEducationServiceHandler.setLogger(super.getLogger());
        }
        this.produceSectorServiceHandler = injector.inject(ProduceSectorServiceHandler.getId());
        if ((this.produceSectorServiceHandler != null)) {
            this.produceSectorServiceHandler.setPersistenceManager(persistenceManager);
            this.produceSectorServiceHandler.setLogger(super.getLogger());
        }
        this.produceActivityAreaServiceHandler = injector.inject(ProduceActivityAreaServiceHandler.getId());
        if ((this.produceActivityAreaServiceHandler != null)) {
            this.produceActivityAreaServiceHandler.setPersistenceManager(persistenceManager);
            this.produceActivityAreaServiceHandler.setLogger(super.getLogger());
        }
        this.produceProvisionRelationServiceHandler = injector.inject(ProduceProvisionRelationServiceHandler.getId());
        if ((this.produceProvisionRelationServiceHandler != null)) {
            this.produceProvisionRelationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProvisionRelationServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("produceSkill", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceEquipment", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceQualification", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProvisionGroup", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProvisionAssignment", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProvisionAssignmentHistory", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceWorkExperience", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceSchoolEducation", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceJobEducation", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceTertiaryEducation", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceFurtherEducation", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceSector", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceActivityArea", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProvisionRelation", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.initializing" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<SkillListMsg> produceSkill(ServiceRequest<SkillProduceRq> rq) throws ProduceException {
        if ((this.produceSkillServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceSkill().");
            throw new InjectionException("No service implementation configured for produceSkill().");
        }
        ServiceResponse<SkillListMsg> rs;
        this.produceSkillServiceHandler.init();
        rs = this.produceSkillServiceHandler.invoke(rq);
        this.produceSkillServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EquipmentListMsg> produceEquipment(ServiceRequest<EquipmentProduceRq> rq)
            throws ProduceException {
        if ((this.produceEquipmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceEquipment().");
            throw new InjectionException("No service implementation configured for produceEquipment().");
        }
        ServiceResponse<EquipmentListMsg> rs;
        this.produceEquipmentServiceHandler.init();
        rs = this.produceEquipmentServiceHandler.invoke(rq);
        this.produceEquipmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<QualificationListMsg> produceQualification(ServiceRequest<QualificationProduceRq> rq)
            throws ProduceException {
        if ((this.produceQualificationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceQualification().");
            throw new InjectionException("No service implementation configured for produceQualification().");
        }
        ServiceResponse<QualificationListMsg> rs;
        this.produceQualificationServiceHandler.init();
        rs = this.produceQualificationServiceHandler.invoke(rq);
        this.produceQualificationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionGroupListMsg> produceProvisionGroup(ServiceRequest<ProvisionGroupProduceRq> rq)
            throws ProduceException {
        if ((this.produceProvisionGroupServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProvisionGroup().");
            throw new InjectionException("No service implementation configured for produceProvisionGroup().");
        }
        ServiceResponse<ProvisionGroupListMsg> rs;
        this.produceProvisionGroupServiceHandler.init();
        rs = this.produceProvisionGroupServiceHandler.invoke(rq);
        this.produceProvisionGroupServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionAssignmentListMsg> produceProvisionAssignment(
            ServiceRequest<ProvisionAssignmentProduceRq> rq) throws ProduceException {
        if ((this.produceProvisionAssignmentServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProvisionAssignment().");
            throw new InjectionException("No service implementation configured for produceProvisionAssignment().");
        }
        ServiceResponse<ProvisionAssignmentListMsg> rs;
        this.produceProvisionAssignmentServiceHandler.init();
        rs = this.produceProvisionAssignmentServiceHandler.invoke(rq);
        this.produceProvisionAssignmentServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionAssignmentHistoryListMsg> produceProvisionAssignmentHistory(
            ServiceRequest<ProvisionAssignmentHistoryProduceRq> rq) throws ProduceException {
        if ((this.produceProvisionAssignmentHistoryServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProvisionAssignmentHistory().");
            throw new InjectionException(
                    "No service implementation configured for produceProvisionAssignmentHistory().");
        }
        ServiceResponse<ProvisionAssignmentHistoryListMsg> rs;
        this.produceProvisionAssignmentHistoryServiceHandler.init();
        rs = this.produceProvisionAssignmentHistoryServiceHandler.invoke(rq);
        this.produceProvisionAssignmentHistoryServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WorkExperienceListMsg> produceWorkExperience(ServiceRequest<WorkExperienceProduceRq> rq)
            throws ProduceException {
        if ((this.produceWorkExperienceServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceWorkExperience().");
            throw new InjectionException("No service implementation configured for produceWorkExperience().");
        }
        ServiceResponse<WorkExperienceListMsg> rs;
        this.produceWorkExperienceServiceHandler.init();
        rs = this.produceWorkExperienceServiceHandler.invoke(rq);
        this.produceWorkExperienceServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SchoolEducationListMsg> produceSchoolEducation(ServiceRequest<SchoolEducationProduceRq> rq)
            throws ProduceException {
        if ((this.produceSchoolEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceSchoolEducation().");
            throw new InjectionException("No service implementation configured for produceSchoolEducation().");
        }
        ServiceResponse<SchoolEducationListMsg> rs;
        this.produceSchoolEducationServiceHandler.init();
        rs = this.produceSchoolEducationServiceHandler.invoke(rq);
        this.produceSchoolEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<JobEducationListMsg> produceJobEducation(ServiceRequest<JobEducationProduceRq> rq)
            throws ProduceException {
        if ((this.produceJobEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceJobEducation().");
            throw new InjectionException("No service implementation configured for produceJobEducation().");
        }
        ServiceResponse<JobEducationListMsg> rs;
        this.produceJobEducationServiceHandler.init();
        rs = this.produceJobEducationServiceHandler.invoke(rq);
        this.produceJobEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TertiaryEducationListMsg> produceTertiaryEducation(
            ServiceRequest<TertiaryEducationProduceRq> rq) throws ProduceException {
        if ((this.produceTertiaryEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceTertiaryEducation().");
            throw new InjectionException("No service implementation configured for produceTertiaryEducation().");
        }
        ServiceResponse<TertiaryEducationListMsg> rs;
        this.produceTertiaryEducationServiceHandler.init();
        rs = this.produceTertiaryEducationServiceHandler.invoke(rq);
        this.produceTertiaryEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<FurtherEducationListMsg> produceFurtherEducation(ServiceRequest<FurtherEducationProduceRq> rq)
            throws ProduceException {
        if ((this.produceFurtherEducationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceFurtherEducation().");
            throw new InjectionException("No service implementation configured for produceFurtherEducation().");
        }
        ServiceResponse<FurtherEducationListMsg> rs;
        this.produceFurtherEducationServiceHandler.init();
        rs = this.produceFurtherEducationServiceHandler.invoke(rq);
        this.produceFurtherEducationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SectorListMsg> produceSector(ServiceRequest<SectorProduceRq> rq) throws ProduceException {
        if ((this.produceSectorServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceSector().");
            throw new InjectionException("No service implementation configured for produceSector().");
        }
        ServiceResponse<SectorListMsg> rs;
        this.produceSectorServiceHandler.init();
        rs = this.produceSectorServiceHandler.invoke(rq);
        this.produceSectorServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ActivityAreaListMsg> produceActivityArea(ServiceRequest<ActivityAreaProduceRq> rq)
            throws ProduceException {
        if ((this.produceActivityAreaServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceActivityArea().");
            throw new InjectionException("No service implementation configured for produceActivityArea().");
        }
        ServiceResponse<ActivityAreaListMsg> rs;
        this.produceActivityAreaServiceHandler.init();
        rs = this.produceActivityAreaServiceHandler.invoke(rq);
        this.produceActivityAreaServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProvisionRelationListMsg> produceProvisionRelation(
            ServiceRequest<ProvisionRelationProduceRq> rq) throws ProduceException {
        if ((this.produceProvisionRelationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProvisionRelation().");
            throw new InjectionException("No service implementation configured for produceProvisionRelation().");
        }
        ServiceResponse<ProvisionRelationListMsg> rs;
        this.produceProvisionRelationServiceHandler.init();
        rs = this.produceProvisionRelationServiceHandler.invoke(rq);
        this.produceProvisionRelationServiceHandler.finish();
        return rs;
    }
}
