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

import org.nabucco.business.provision.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.provision.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.framework.base.facade.datatype.DatatypeIdentifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * ResolveDatatypeListServiceHandlerImpl.
 * 
 * @author Juergen Weismueller, PRODYNA AG
 * @author Markus Jorroch, PRODYNA AG
 */
public class ResolveDatatypeListServiceHandlerImpl extends ResolveDatatypeListServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ResolveDatatypeListRs resolveDatatypeList(ResolveDatatypeListRq msg) throws ResolveException {
        ResolveDatatypeListRs rs = new ResolveDatatypeListRs();
        NabuccoList<NabuccoDatatype> datatypeList = rs.getDatatypeList();
        try {

            NabuccoList<DatatypeIdentifier> datatypeIdentifiers = msg.getDatatypeIdentifiers();
            for (DatatypeIdentifier datatypeIdentifier : datatypeIdentifiers) {
                @SuppressWarnings("unchecked")
                Class<NabuccoDatatype> type = (Class<NabuccoDatatype>) Class.forName(datatypeIdentifier
                        .getFullQualifiedClassName().getValue());
                Long id = datatypeIdentifier.getIdentifier().getValue();
                NabuccoDatatype datatype = getPersistenceManager().find(type, id);
                if (datatype != null) {
                    datatypeList.add(datatype);
                } else {
                    throw new ResolveException("Unble to find datatype of class '"
                            + datatypeIdentifier.getFullQualifiedClassName().getValue() + "' and id '"
                            + datatypeIdentifier.getIdentifier().getValue() + "'.");
                }
            }
        } catch (PersistenceException e) {
            throw new ResolveException(e);
        } catch (ClassNotFoundException e) {
            throw new ResolveException(e);
        }
        return rs;
    }

}
