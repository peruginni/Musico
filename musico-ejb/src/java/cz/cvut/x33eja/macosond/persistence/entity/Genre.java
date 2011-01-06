package cz.cvut.x33eja.macosond.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Entity
@Table(name="Genre")
@NamedQueries({
        @NamedQuery(name="Genre.list", query="SELECT g FROM Genre g")
})
public class Genre implements Serializable
{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="GenreID")
	private Integer GenreID;
        @Column(name="Name", unique = true)
	private String Name;

        @ManyToMany(mappedBy="Genres")
        private Collection<Event> Events;

        public Genre()
        {
                super();
        }

        public Genre(Integer GenreID)
        {
                super();
                this.GenreID = GenreID;
        }

        public Genre(String Name)
        {
                super();
                this.Name = Name;
        }

        public Integer getGenreID()
        {
                return GenreID;
        }

        public void setGenreID(Integer GenreID)
        {
                this.GenreID = GenreID;
        }

        public String getName()
        {
                return Name;
        }

        public void setName(String Name)
        {
                this.Name = Name;
        }

        public Collection<Event> getEvents()
        {
                return Events;
        }

        public void setEvents(Collection<Event> Events)
        {
                this.Events = Events;
        }

        @Override
        public int hashCode()
        {
                int hash = 0;
                hash = (GenreID == null ? 0 : GenreID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof Genre) ) {
                        return false;
                }

                Genre other = (Genre) o;
                if( ( this.GenreID == null && other.GenreID != null )
                    || ( this.GenreID != null && other.GenreID == null )
                    || ( !this.GenreID.equals(other.GenreID) )
                  ) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.Genre[id=" + GenreID+ "]";
        }
}