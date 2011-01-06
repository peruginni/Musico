package cz.cvut.x33eja.macosond.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Entity
@Table(name="Event")
@NamedQueries({
        @NamedQuery(name="Event.list", 
                query="SELECT e FROM Event e ORDER BY e.DateStart ASC"),
        @NamedQuery(name="Event.byDateInterval", 
                query="SELECT e FROM Event e WHERE e.DateStart > :start AND e.DateStart < :end ORDER BY e.DateStart ASC"),
        @NamedQuery(name="Event.byPlace",
                query="SELECT e FROM Event e WHERE e.Place = :place ORDER BY e.DateStart ASC")
})
public class Event implements Serializable
{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="EventID")
	private Integer EventID;
        @Column(name="Name")
        private String Name;
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name="DateStart")
	private Date DateStart;
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name="DateEnd")
	private Date DateEnd;
        @Column(name="Place")
	private String Place;
        @ManyToOne
        @JoinColumn(name="Band")
        private Band Band;

        @ManyToMany
        @JoinTable(
                name = "EventGenre",
                joinColumns = @JoinColumn(name="EventID", referencedColumnName="EventID"),
                inverseJoinColumns = @JoinColumn(name="GenreID", referencedColumnName="GenreID")
        )
        private Collection<Genre> Genres;

        public Event()
        {
                super();
        }

        public Event(Integer EventID)
        {
                super();
                this.EventID = EventID;
        }

        public Integer getEventID()
        {
                return EventID;
        }

        public void setEventID(Integer EventID)
        {
                this.EventID = EventID;
        }

        public String getName()
        {
                return Name;
        }

        public void setName(String Name)
        {
                this.Name = Name;
        }
        
        public Date getDateStart()        
        {
                return DateStart;
        }

        public void setDateStart(Date DateStart)
        {
                this.DateStart = DateStart;
        }
        
        public Date getDateEnd()
        {
                return DateEnd;
        }

        public void setDateEnd(Date DateEnd)
        {
                this.DateEnd = DateEnd;
        }

        public String getPlace()
        {
                return Place;
        }

        public void setPlace(String Place)
        {
                this.Place = Place;
        }
        
        public Band getBand()        
        {
                return Band;
        }

        public void setBand(Band Band)
        {
                this.Band = Band;
        }

        public Collection<Genre> getGenres()
        {
                return Genres;
        }

        public void setGenres(Collection<Genre> Genres)
        {
                this.Genres = Genres;
        }

        @Override
        public int hashCode()
        {
                int hash = 0;
                hash = (EventID == null ? 0 : EventID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof Event) ) {
                        return false;
                }

                Event other = (Event) o;
                if( ( this.EventID == null && other.EventID != null )
                    || ( this.EventID != null && other.EventID == null )
                    || ( !this.EventID.equals(other.EventID) )
                  ) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.Event[id=" + EventID + "]";
        }

}