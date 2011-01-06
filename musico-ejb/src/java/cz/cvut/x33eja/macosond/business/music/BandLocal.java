package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Band;
import java.util.Collection;
import javax.ejb.Local;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:17
 */
@Local
public interface BandLocal
{

	/**
	 * Add new band
	 * @param band
	 */
	public void add(Band band);

	/**
	 * Edit existing band
	 * @param band
	 */
	public void edit(Band band);

	/**
	 * Delete existing band
	 * @param band
	 */
	public void delete(Band band);

	/**
	 * Get specific band by informations in given object
	 * @param band
	 */
	public Band get(Band band);
        
        /**
	 * Get specific band by given id
	 * @param band
	 */
	public Band get(Integer BandID);

        /**
         * Get all existing bands
         * @return
         */
	public Collection<Band> getAll();

}