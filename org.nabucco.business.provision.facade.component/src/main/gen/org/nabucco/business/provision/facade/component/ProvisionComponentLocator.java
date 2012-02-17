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
package org.nabucco.business.provision.facade.component;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for ProvisionComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class ProvisionComponentLocator extends ComponentLocatorSupport<ProvisionComponent> implements
        ComponentLocator<ProvisionComponent> {

    private static ProvisionComponentLocator instance;

    /**
     * Constructs a new ProvisionComponentLocator instance.
     *
     * @param component the Class<ProvisionComponent>.
     * @param jndiName the String.
     */
    private ProvisionComponentLocator(String jndiName, Class<ProvisionComponent> component) {
        super(jndiName, component);
    }

    @Override
    public ProvisionComponent getComponent() throws ConnectionException {
        ProvisionComponent component = super.getComponent();
        if ((component instanceof ProvisionComponentLocal)) {
            return new ProvisionComponentLocalProxy(((ProvisionComponentLocal) component));
        }
        return component;
    }

    /**
     * Getter for the Instance.
     *
     * @return the ProvisionComponentLocator.
     */
    public static ProvisionComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new ProvisionComponentLocator(ProvisionComponent.JNDI_NAME, ProvisionComponent.class);
        }
        return instance;
    }
}
