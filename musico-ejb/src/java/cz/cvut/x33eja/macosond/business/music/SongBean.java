package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Album;
import cz.cvut.x33eja.macosond.persistence.entity.Song;
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
public class SongBean implements SongLocal
{
        @PersistenceContext(unitName="Musico-PU")
        private EntityManager em;

        @RolesAllowed({"member","admin"})
        public void add(Song song)
        {
                em.persist(song);
        }

        @RolesAllowed({"member","admin"})
        public void edit(Song song)
        {
                song = em.merge(song);
                em.persist(song);
        }

        @RolesAllowed({"member","admin"})
        public void delete(Song song)
        {
                song = em.merge(song);
                em.remove(song);
        }

        @PermitAll
        public Song get(Song song)
        {
                return em.find(Song.class, song.getSongID());
        }

        @PermitAll
        public Song get(Integer SongID)
        {
                return em.find(Song.class, SongID);
        }

        @PermitAll
        public Collection<Song> getAll()
        {
                return em.createNamedQuery("Song.list").getResultList();
        }

        @PermitAll
        public Collection<Song> getByAlbum(Album album)
        {
                album = em.find(Album.class, album.getAlbumID());
                return album.getSongs();
        }
}
