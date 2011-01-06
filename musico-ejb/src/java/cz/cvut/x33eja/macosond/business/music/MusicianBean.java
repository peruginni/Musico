package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Band;
import cz.cvut.x33eja.macosond.persistence.entity.Musician;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
@Stateless
public class MusicianBean implements MusicianLocal
{
        @PersistenceContext(unitName="Musico-PU")
        private EntityManager em;

        @RolesAllowed({"member","admin"})
        public void add(Musician musician)
        {
                em.persist(musician);
        }

        @RolesAllowed({"member","admin"})
        public void edit(Musician musician)
        {
                musician = em.merge(musician);
                em.persist(musician);
        }

        @RolesAllowed({"member","admin"})
        public void delete(Musician musician)
        {
                musician = em.merge(musician);
                em.remove(musician);
        }

        public Musician get(Musician musician)
        {
                return em.find(Musician.class, musician.getMusicianID());
        }

        public Musician get(Integer MusicianID)
        {
                return em.find(Musician.class, MusicianID);
        }

        public Collection<Musician> getAll()
        {
                return em.createNamedQuery("Musician.list").getResultList();
        }

        public Collection<Musician> getByBand(Band band)
        {
                band = em.find(Band.class, band.getBandID());
                return band.getMusicians();
        }
}
