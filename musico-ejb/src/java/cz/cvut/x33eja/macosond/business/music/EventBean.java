package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Band;
import cz.cvut.x33eja.macosond.persistence.entity.Event;
import cz.cvut.x33eja.macosond.persistence.entity.Genre;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
@Stateless
public class EventBean implements EventLocal
{
        @PersistenceContext(unitName="Musico-PU")
        private EntityManager em;

        @RolesAllowed({"member","admin"})
        public void add(Event event)
        {
                em.persist(event);
        }

        @RolesAllowed({"member","admin"})
        public void edit(Event event)
        {
                event = em.merge(event);
                em.persist(event);
        }

        @RolesAllowed({"member","admin"})
        public void delete(Event event)
        {
                event = em.merge(event);
                em.remove(event);
        }

        @PermitAll
        public Event get(Event event)
        {
                return em.find(Event.class, event.getEventID());
        }

        @PermitAll
        public Event get(Integer EventID)
        {
                return em.find(Event.class, EventID);
        }

        @PermitAll
        public Collection<Event> getAll()
        {
                return em.createNamedQuery("Event.list").getResultList();
        }

        @PermitAll
        public Collection<Event> getByGenre(Genre genre)
        {
                genre = em.find(Genre.class, genre.getGenreID());
                return genre.getEvents();
        }

        @PermitAll
        public Collection<Event> getByDateInterval(Date start, Date end)
        {
                return em.createNamedQuery("Event.byDateInterval")
                        .setParameter("start", start, TemporalType.DATE)
                        .setParameter("end", end, TemporalType.DATE)
                        .getResultList();
        }

        @PermitAll
        public Collection<Event> getByBand(Band band)
        {
                band = em.find(Band.class, band.getBandID());
                return band.getEvents();
        }

        @PermitAll
        public Collection<Event> getByPlace(String place)
        {
                return em.createNamedQuery("Event.byPlace")
                        .setParameter("place", place)
                        .getResultList();
        }
}
