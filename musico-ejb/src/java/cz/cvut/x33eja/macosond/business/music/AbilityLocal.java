package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Ability;
import java.util.Collection;
import javax.ejb.Local;


/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Local
public interface AbilityLocal
{

	/**
	 * Add new ability
	 * @param ability
	 */
	public void add(Ability ability);

	/**
	 * Edit existing ability
	 * @param ability
	 */
	public void edit(Ability ability);

	/**
	 * Delete existing ability
	 * @param ability
	 */
	public void delete(Ability ability);

	/**
	 * Get specific ability by info in given object
	 * @param ability
	 */
	public Ability get(Ability ability);

	/**
	 * Get specific ability by given id
	 * @param ability
	 */
	public Ability get(Integer AbilityID);

        /**
         * Get all existing abilities
         * @return
         */
	public Collection<Ability> getAll();
}