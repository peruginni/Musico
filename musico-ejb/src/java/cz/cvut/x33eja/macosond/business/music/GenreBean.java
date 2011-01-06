package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Genre;
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
public class GenreBean implements GenreLocal
{
        @PersistenceContext(unitName="Musico-PU")
        private EntityManager em;

        @RolesAllowed({"member","admin"})
        public void add(Genre genre)
        {
                em.persist(genre);
        }

        @RolesAllowed({"member","admin"})
        public void edit(Genre genre)
        {
                genre = em.merge(genre);
                em.persist(genre);
        }

        @RolesAllowed({"member","admin"})
        public void delete(Genre genre)
        {
                genre = em.merge(genre);
                em.remove(genre);
        }

        @PermitAll
        public Genre get(Genre genre)
        {
                return em.find(Genre.class, genre.getGenreID());
        }

        @PermitAll
        public Genre get(Integer GenreID)
        {
                return em.find(Genre.class, GenreID);
        }

        @PermitAll
        public Collection<Genre> getAll()
        {
                return em.createNamedQuery("Genre.list").getResultList();
        }
       
}
