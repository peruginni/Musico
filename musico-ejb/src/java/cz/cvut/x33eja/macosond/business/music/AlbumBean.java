package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Album;
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
public class AlbumBean implements AlbumLocal
{
        @PersistenceContext(unitName="Musico-PU")
        private EntityManager em;

        @RolesAllowed({"member","admin"})
        public void add(Album album)
        {
                em.persist(album);
        }

        @RolesAllowed({"member","admin"})
        public void edit(Album album)
        {
                album = em.merge(album);
                em.persist(album);
        }

        @RolesAllowed({"member","admin"})
        public void delete(Album album)
        {
                album = em.merge(album);
                em.remove(album);
        }

        @PermitAll
        public Album get(Album album)
        {
                return em.find(Album.class, album.getAlbumID());
        }

        @PermitAll
        public Album get(Integer AlbumID)
        {
                return em.find(Album.class, AlbumID);
        }

        @PermitAll
        public Collection<Album> getAll()
        {
                return em.createNamedQuery("Album.list").getResultList();
        }
}
