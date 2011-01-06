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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Entity
@Table(name="Band")
@NamedQuery(name="Band.list", query="SELECT b FROM Band b")
public class Band implements Serializable
{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="BandID")
	private Integer BandID;
        @Column(name="Name", unique = true)
	private String Name;
        @Column(name="Website")
	private String Website;
        @Column(name="Country")
	private String Country;
        @Temporal(TemporalType.DATE)
        @Column(name="DateFoundation")
	private Date DateFoundation;
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name="DateCreated")
	private Date DateCreated;
        @ManyToOne
        @JoinColumn(name="PreferredGenre")
	private Genre PreferredGenre;

        @ManyToMany
        @JoinTable(
                name = "BandMusician",
                joinColumns = @JoinColumn(name="BandID", referencedColumnName="BandID"),
                inverseJoinColumns = @JoinColumn(name="MusicianID", referencedColumnName="MusicianID")
        )
        private Collection<Musician> Musicians;

        @OneToMany
	private Collection<Event> Events;
        
        public Band()
        {
                super();
        }

        public Band(Integer BandID)
        {
                super();
                this.BandID = BandID;
        }

        public Integer getBandID()
        {
                return BandID;
        }

        public void setBandID(Integer BandID)
        {
                this.BandID = BandID;
        }

        public String getName()
        {
                return Name;
        }

        public void setName(String Name)
        {
                this.Name = Name;
        }

        public String getWebsite()        
        {
                return Website;
        }

        public void setWebsite(String Website)
        {
                this.Website = Website;
        }

        public String getCountry()        
        {
                return Country;
        }

        public void setCountry(String Country)
        {
                this.Country = Country;
        }

        public Date getDateFoundation()        
        {
                return DateFoundation;
        }

        public void setDateFoundation(Date DateFoundation)
        {
                this.DateFoundation = DateFoundation;
        }

        public Date getDateCreated()        
        {
                return DateCreated;
        }

        public void setDateCreated(Date DateCreated)
        {
                this.DateCreated = DateCreated;
        }

        public Genre getPreferredGenre()
        {
                return PreferredGenre;
        }

        public void setPreferredGenre(Genre PreferredGenre)
        {
                this.PreferredGenre = PreferredGenre;
        }

        public Collection<Musician>  getMusicians()
        {
                return Musicians;
        }

        public void setMusicians(Collection<Musician>  Musicians)
        {
                this.Musicians = Musicians;
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
                hash = (BandID == null ? 0 : BandID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof Band) ) {
                        return false;
                }

                Band other = (Band) o;
                if( ( this.BandID == null && other.BandID != null )
                    || ( this.BandID != null && other.BandID == null )
                    || ( !this.BandID.equals(other.BandID) )
                  ) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.Band[id=" + BandID + "]";
        }

}