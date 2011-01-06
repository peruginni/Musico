package cz.cvut.x33eja.macosond.business.music;

import cz.cvut.x33eja.macosond.persistence.entity.Band;
import cz.cvut.x33eja.macosond.persistence.entity.Event;
import cz.cvut.x33eja.macosond.persistence.entity.Genre;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:17
 */
@Local
public interface EventLocal
{

	/**
	 * Add new event
	 * @param event
	 */
	public void add(Event event);

	/**
	 * Edit existing event
	 * @param event
	 */
	public void edit(Event event);

	/**
	 * Delete existing event
	 * @param event
	 */
	public void delete(Event event);

	/**
	 * Get specific event by given object
	 * @param event
	 */
	public Event get(Event event);

        /**
	 * Get specific event by given id
	 * @param event
	 */
	public Event get(Integer EventID);

        /**
         * Get all existing events
         * @return
         */
	public Collection<Event> getAll();

	/**
	 * Get events by given genre
	 * @param genre
	 */
	public Collection<Event> getByGenre(Genre genre);

	/**
	 * Get events within given date interval
	 * @param start
	 * @param end
	 */
	public Collection<Event> getByDateInterval(Date start, Date end);

	/**
	 * Get events that belong to given band
	 * @param band
	 */
	public Collection<Event> getByBand(Band band);

	/**
	 * Get events by place
	 * @param place
	 */
	public Collection<Event> getByPlace(String place);

}