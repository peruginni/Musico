package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Album;
import cz.cvut.x33eja.macosond.persistence.entity.Song;
import java.util.Collection;
import javax.ejb.Local;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:17
 */
@Local
public interface SongLocal
{

	/**
	 * Add new song
	 * @param song
	 */
	public void add(Song song);

	/**
	 * Save changed properties of existing song
	 * @param song
	 */
	public void edit(Song song);

	/**
	 * Remove existing song
	 * @param song
	 */
	public void delete(Song song);

	/**
	 * Get specific song by informations in entity
	 * @param song
	 */
	public Song get(Song song);

        /**
	 * Get specific song by id
	 * @param song
	 */
	public Song get(Integer SongID);

	public Collection<Song> getAll();

	/**
	 * Find all songs contained in certain album
	 * @param album album which songs will be returned
	 */
	public Collection<Song> getByAlbum(Album album);

}