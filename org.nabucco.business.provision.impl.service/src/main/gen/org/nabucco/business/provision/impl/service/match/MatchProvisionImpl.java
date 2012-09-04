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
package org.nabucco.business.provision.impl.service.match;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.provision.facade.exception.ProvisionMatchException;
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRq;
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRs;
import org.nabucco.business.provision.facade.message.match.SkillMatchRq;
import org.nabucco.business.provision.facade.message.match.SkillMatchRs;
import org.nabucco.business.provision.facade.service.match.MatchProvision;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * MatchProvisionImpl<p/>Match Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-06-28
 */
public class MatchProvisionImpl extends ServiceSupport implements MatchProvision {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MatchProvision";

    private static Map<String, String[]> ASPECTS;

    private MatchServiceHandler matchServiceHandler;

    private MatchSkillsServiceHandler matchSkillsServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new MatchProvisionImpl instance. */
    public MatchProvisionImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.matchServiceHandler = injector.inject(MatchServiceHandler.getId());
        if ((this.matchServiceHandler != null)) {
            this.matchServiceHandler.setPersistenceManager(persistenceManager);
            this.matchServiceHandler.setLogger(super.getLogger());
        }
        this.matchSkillsServiceHandler = injector.inject(MatchSkillsServiceHandler.getId());
        if ((this.matchSkillsServiceHandler != null)) {
            this.matchSkillsServiceHandler.setPersistenceManager(persistenceManager);
            this.matchSkillsServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("match", NO_ASPECTS);
            ASPECTS.put("matchSkills", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<ProvisionMatchRs> match(ServiceRequest<ProvisionMatchRq> rq) throws ProvisionMatchException {
        if ((this.matchServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for match().");
            throw new InjectionException("No service implementation configured for match().");
        }
        ServiceResponse<ProvisionMatchRs> rs;
        this.matchServiceHandler.init();
        rs = this.matchServiceHandler.invoke(rq);
        this.matchServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SkillMatchRs> matchSkills(ServiceRequest<SkillMatchRq> rq) throws ProvisionMatchException {
        if ((this.matchSkillsServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for matchSkills().");
            throw new InjectionException("No service implementation configured for matchSkills().");
        }
        ServiceResponse<SkillMatchRs> rs;
        this.matchSkillsServiceHandler.init();
        rs = this.matchSkillsServiceHandler.invoke(rq);
        this.matchSkillsServiceHandler.finish();
        return rs;
    }
}
