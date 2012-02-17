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
package org.nabucco.business.provision.facade.datatype.match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.provision.facade.datatype.match.SkillMatch;
import org.nabucco.business.provision.facade.datatype.match.SkillMatchItem;
import org.nabucco.business.provision.facade.datatype.match.SkillRefKey;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * SkillMatchGroup<p/>The group of the matched skills<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2011-11-23
 */
public class SkillMatchGroup extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l5,n;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "m0,n;" };

    public static final String SKILLREFKEY = "skillRefKey";

    public static final String SKILLMATCH = "skillMatch";

    public static final String MATCHEDSKILLLIST = "matchedSkillList";

    /** Skillgroup reference key */
    public SkillRefKey skillRefKey;

    /** The match of the skillgpoup relative to the given skill reference */
    public SkillMatch skillMatch;

    /** The list of the skills with their match quote */
    public NabuccoList<SkillMatchItem> matchedSkillList;

    /** Constructs a new SkillMatchGroup instance. */
    public SkillMatchGroup() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the SkillMatchGroup.
     */
    protected void cloneObject(SkillMatchGroup clone) {
        super.cloneObject(clone);
        if ((this.getSkillRefKey() != null)) {
            clone.setSkillRefKey(this.getSkillRefKey().cloneObject());
        }
        if ((this.getSkillMatch() != null)) {
            clone.setSkillMatch(this.getSkillMatch().cloneObject());
        }
        if ((this.matchedSkillList != null)) {
            clone.matchedSkillList = this.matchedSkillList.cloneCollection();
        }
    }

    /**
     * Getter for the MatchedSkillListJPA.
     *
     * @return the List<SkillMatchItem>.
     */
    List<SkillMatchItem> getMatchedSkillListJPA() {
        if ((this.matchedSkillList == null)) {
            this.matchedSkillList = new NabuccoListImpl<SkillMatchItem>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<SkillMatchItem>) this.matchedSkillList).getDelegate();
    }

    /**
     * Setter for the MatchedSkillListJPA.
     *
     * @param matchedSkillList the List<SkillMatchItem>.
     */
    void setMatchedSkillListJPA(List<SkillMatchItem> matchedSkillList) {
        if ((this.matchedSkillList == null)) {
            this.matchedSkillList = new NabuccoListImpl<SkillMatchItem>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<SkillMatchItem>) this.matchedSkillList).setDelegate(matchedSkillList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(SKILLREFKEY, PropertyDescriptorSupport.createBasetype(SKILLREFKEY, SkillRefKey.class, 3,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(SKILLMATCH, PropertyDescriptorSupport.createBasetype(SKILLMATCH, SkillMatch.class, 4,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(MATCHEDSKILLLIST, PropertyDescriptorSupport.createCollection(MATCHEDSKILLLIST,
                SkillMatchItem.class, 5, PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties
                .add(super.createProperty(SkillMatchGroup.getPropertyDescriptor(SKILLREFKEY), this.skillRefKey, null));
        properties.add(super.createProperty(SkillMatchGroup.getPropertyDescriptor(SKILLMATCH), this.skillMatch, null));
        properties.add(super.createProperty(SkillMatchGroup.getPropertyDescriptor(MATCHEDSKILLLIST),
                this.matchedSkillList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SKILLREFKEY) && (property.getType() == SkillRefKey.class))) {
            this.setSkillRefKey(((SkillRefKey) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SKILLMATCH) && (property.getType() == SkillMatch.class))) {
            this.setSkillMatch(((SkillMatch) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MATCHEDSKILLLIST) && (property.getType() == SkillMatchItem.class))) {
            this.matchedSkillList = ((NabuccoList<SkillMatchItem>) property.getInstance());
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final SkillMatchGroup other = ((SkillMatchGroup) obj);
        if ((this.skillRefKey == null)) {
            if ((other.skillRefKey != null))
                return false;
        } else if ((!this.skillRefKey.equals(other.skillRefKey)))
            return false;
        if ((this.skillMatch == null)) {
            if ((other.skillMatch != null))
                return false;
        } else if ((!this.skillMatch.equals(other.skillMatch)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.skillRefKey == null) ? 0 : this.skillRefKey.hashCode()));
        result = ((PRIME * result) + ((this.skillMatch == null) ? 0 : this.skillMatch.hashCode()));
        return result;
    }

    @Override
    public SkillMatchGroup cloneObject() {
        SkillMatchGroup clone = new SkillMatchGroup();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Skillgroup reference key
     *
     * @return the SkillRefKey.
     */
    public SkillRefKey getSkillRefKey() {
        return this.skillRefKey;
    }

    /**
     * Skillgroup reference key
     *
     * @param skillRefKey the SkillRefKey.
     */
    public void setSkillRefKey(SkillRefKey skillRefKey) {
        this.skillRefKey = skillRefKey;
    }

    /**
     * Skillgroup reference key
     *
     * @param skillRefKey the String.
     */
    public void setSkillRefKey(String skillRefKey) {
        if ((this.skillRefKey == null)) {
            if ((skillRefKey == null)) {
                return;
            }
            this.skillRefKey = new SkillRefKey();
        }
        this.skillRefKey.setValue(skillRefKey);
    }

    /**
     * The match of the skillgpoup relative to the given skill reference
     *
     * @return the SkillMatch.
     */
    public SkillMatch getSkillMatch() {
        return this.skillMatch;
    }

    /**
     * The match of the skillgpoup relative to the given skill reference
     *
     * @param skillMatch the SkillMatch.
     */
    public void setSkillMatch(SkillMatch skillMatch) {
        this.skillMatch = skillMatch;
    }

    /**
     * The match of the skillgpoup relative to the given skill reference
     *
     * @param skillMatch the java.math.BigDecimal.
     */
    public void setSkillMatch(java.math.BigDecimal skillMatch) {
        if ((this.skillMatch == null)) {
            if ((skillMatch == null)) {
                return;
            }
            this.skillMatch = new SkillMatch();
        }
        this.skillMatch.setValue(skillMatch);
    }

    /**
     * The list of the skills with their match quote
     *
     * @return the NabuccoList<SkillMatchItem>.
     */
    public NabuccoList<SkillMatchItem> getMatchedSkillList() {
        if ((this.matchedSkillList == null)) {
            this.matchedSkillList = new NabuccoListImpl<SkillMatchItem>(NabuccoCollectionState.INITIALIZED);
        }
        return this.matchedSkillList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(SkillMatchGroup.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(SkillMatchGroup.class).getAllProperties();
    }
}
