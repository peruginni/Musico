package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Genre;
import java.util.Collection;
import javax.ejb.Local;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:17
 */
@Local
public interface GenreLocal
{

	/**
	 * Add new genre
	 * @param genre
	 */
	public void add(Genre genre);

	/**
	 * Edit existing genre
	 * @param genre
	 */
	public void edit(Genre genre);

	/**
	 * Delete existing genre
	 * @param genre
	 */
	public void delete(Genre genre);

	/**
	 * Get specific genre by information in object
	 * @param genre
	 */
	public Genre get(Genre genre);

        /**
	 * Get specific genre by genre id
	 * @param genre
	 */
	public Genre get(Integer GenreID);

        /**
         * Get all existing genres
         * @return existing genres
         */
	public Collection<Genre> getAll();

}