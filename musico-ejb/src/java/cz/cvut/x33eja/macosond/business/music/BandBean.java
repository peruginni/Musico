package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Band;
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
public class BandBean implements BandLocal
{
        @PersistenceContext(unitName="Musico-PU")
        private EntityManager em;

        @RolesAllowed({"member","admin"})
        public void add(Band band)
        {
                em.persist(band);
        }

        @RolesAllowed({"member","admin"})
        public void edit(Band band)
        {
                band = em.merge(band);
                em.persist(band);
        }

        @RolesAllowed({"member","admin"})
        public void delete(Band band)
        {
                band = em.merge(band);
                em.remove(band);
        }

        @PermitAll
        public Band get(Band band)
        {
                return em.find(Band.class, band.getBandID());
        }

        @PermitAll
        public Band get(Integer BandID)
        {
                return em.find(Band.class, BandID);
        }

        @PermitAll
        public Collection<Band> getAll()
        {
                return em.createNamedQuery("Band.list").getResultList();
        }
}
