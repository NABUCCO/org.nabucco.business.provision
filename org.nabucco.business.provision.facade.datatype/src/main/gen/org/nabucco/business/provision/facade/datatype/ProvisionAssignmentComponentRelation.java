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
package org.nabucco.business.provision.facade.datatype;

import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;

/**
 * ProvisionAssignmentComponentRelation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-12-01
 */
public class ProvisionAssignmentComponentRelation extends ComponentRelation<ProvisionAssignment> {

    private static final long serialVersionUID = 1L;

    /** Constructs a new ProvisionAssignmentComponentRelation instance. */
    protected ProvisionAssignmentComponentRelation() {
        super();
    }

    /**
     * Constructs a new ProvisionAssignmentComponentRelation instance.
     *
     * @param relationType the ComponentRelationType.
     */
    public ProvisionAssignmentComponentRelation(ComponentRelationType relationType) {
        super(relationType);
    }

    /**
     * Getter for the Tarthe .
     *
     * @return the ProvisionAssignment.
     */
    public ProvisionAssignment getTarget() {
        return super.getTarget();
    }

    /**
     * Setter for the Target.
     *
     * @param target the ProvisionAssignment.
     */
    public void setTarget(ProvisionAssignment target) {
        super.setTarget(target);
    }

    @Override
    public ProvisionAssignmentComponentRelation cloneObject() {
        ProvisionAssignmentComponentRelation clone = new ProvisionAssignmentComponentRelation();
        super.cloneObject(clone);
        return clone;
    }
}
