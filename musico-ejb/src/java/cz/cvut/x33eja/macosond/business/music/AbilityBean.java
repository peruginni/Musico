/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Ability;
import java.util.Collection;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
@Stateless
public class AbilityBean implements AbilityLocal
{
        @PersistenceContext(unitName="Musico-PU")
        private EntityManager em;

        @RolesAllowed({"member","admin"})
        public void add(Ability ability)
        {
                em.persist(ability);
        }

        @RolesAllowed({"member","admin"})
        public void edit(Ability ability)
        {
                ability = em.merge(ability);
                em.persist(ability);
        }

        @RolesAllowed({"member","admin"})
        public void delete(Ability ability)
        {
                ability = em.merge(ability);
                em.remove(ability);
        }

        @PermitAll
        public Ability get(Ability ability)
        {
                return em.find(Ability.class, ability.getAbilityID());
        }

        @PermitAll
        public Ability get(Integer AbilityID)
        {
                return em.find(Ability.class, AbilityID);
        }

        @PermitAll
        public Collection<Ability> getAll()
        {
                return em.createNamedQuery("Ability.list").getResultList();
        }
}
