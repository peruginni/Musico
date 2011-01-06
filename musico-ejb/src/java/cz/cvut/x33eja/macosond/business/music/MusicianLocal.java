package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Band;
import cz.cvut.x33eja.macosond.persistence.entity.Musician;
import java.util.Collection;
import javax.ejb.Local;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:17
 */
@Local
public interface MusicianLocal
{

	/**
	 * Add new musician
	 * @param musician entity filled with data
	 */
	public void add(Musician musician);

	/**
	 * Save changed properties of existing musician
	 * @param musician
	 */
	public void edit(Musician musician);

	/**
	 * Remove existing musician
	 * @param musician
	 */
	public void delete(Musician musician);

	/**
	 * Get specific song by informations in entity
	 * @param musician
	 */
	public Musician get(Musician musician);

        /**
	 * Get specific song by informations in entity
	 * @param musician
	 */
	public Musician get(Integer MusicianID);

	public Collection<Musician> getAll();

	/**
	 * Get musicians which belong to given band
	 * @param band musician will be search within this band
	 */
	public Collection<Musician> getByBand(Band band);

}