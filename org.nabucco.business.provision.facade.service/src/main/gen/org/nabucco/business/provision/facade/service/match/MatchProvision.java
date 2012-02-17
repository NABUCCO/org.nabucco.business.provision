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
package org.nabucco.business.provision.facade.service.match;

import org.nabucco.business.provision.facade.exception.ProvisionMatchException;
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRq;
import org.nabucco.business.provision.facade.message.match.ProvisionMatchRs;
import org.nabucco.business.provision.facade.message.match.SkillMatchRq;
import org.nabucco.business.provision.facade.message.match.SkillMatchRs;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * MatchProvision<p/>Match Service for Provision<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2011-06-28
 */
public interface MatchProvision extends Service {

    /**
     * Missing description at method match.
     *
     * @param rq the ServiceRequest<ProvisionMatchRq>.
     * @return the ServiceResponse<ProvisionMatchRs>.
     * @throws ProvisionMatchException
     */
    ServiceResponse<ProvisionMatchRs> match(ServiceRequest<ProvisionMatchRq> rq) throws ProvisionMatchException;

    /**
     * Match skill lists to calculate average matching
     *
     * @param rq the ServiceRequest<SkillMatchRq>.
     * @return the ServiceResponse<SkillMatchRs>.
     * @throws ProvisionMatchException
     */
    ServiceResponse<SkillMatchRs> matchSkills(ServiceRequest<SkillMatchRq> rq) throws ProvisionMatchException;
}
