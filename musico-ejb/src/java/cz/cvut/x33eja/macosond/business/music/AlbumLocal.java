package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Album;
import java.util.Collection;
import javax.ejb.Local;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Local
public interface AlbumLocal
{

	/**
	 * Add new album
	 * @param album
	 */
	public void add(Album album);

	/**
	 * Edit existing album
	 * @param album
	 */
	public void edit(Album album);

	/**
	 * Delete existing album
	 * @param album
	 */
	public void delete(Album album);

	/**
	 * Get specific album by informations in given object
	 * @param album
	 */
	public Album get(Album album);

	/**
	 * Get specific album by given id
	 * @param album
	 */
	public Album get(Integer AlbumID);

        /**
         * Get all existing albums
         * @return
         */
	public Collection<Album> getAll();

}