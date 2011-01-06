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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Entity
@Table(name="Album")
@NamedQuery(name="Album.list", query="SELECT a FROM Album a")
public class Album implements Serializable
{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="AlbumID")
	private Integer AlbumID;
        @Column(name="Name")
	private String Name;
        @Temporal(TemporalType.DATE)
        @Column(name="DateReleased")
	private Date DateReleased;
        @Temporal(TemporalType.DATE)
        @Column(name="DateRecorded")
	private Date DateRecorded;
        @Column(name="AudioLength")
	private Integer AudioLength;
        @ManyToOne
        @JoinColumn(name="Genre")
	private Genre Genre;

        @ManyToMany
        @JoinTable(
                name = "AlbumSong",
                joinColumns = @JoinColumn(name="AlbumID", referencedColumnName="AlbumID"),
                inverseJoinColumns = @JoinColumn(name="SongID", referencedColumnName="SongID")
        )
        private Collection<Song> Songs;

        public Album()
        {
                super();
        }

        public Album(Integer AlbumID)
        {
                super();
                this.AlbumID = AlbumID;
        }

        public Integer getAlbumID()
        {
                return AlbumID;
        }

        public void setAlbumID(Integer AlbumID)
        {
                this.AlbumID = AlbumID;
        }

        public String getName()        
        {
                return Name;
        }

        public void setName(String Name)
        {
                this.Name = Name;
        }

        public Date getDateReleased()        
        {
                return DateReleased;
        }

        public void setDateReleased(Date DateReleased)
        {
                this.DateReleased = DateReleased;
        }

        public Date getDateRecorded()
        {
                return DateRecorded;
        }

        public void setDateRecorded(Date DateRecorded)
        {
                this.DateRecorded = DateRecorded;
        }

        public Integer getAudioLength()
        {
                return AudioLength;
        }

        public void setAudioLength(Integer AudioLength)
        {
                this.AudioLength = AudioLength;
        }

        public Genre getGenre()
        {
                return Genre;
        }

        public void setGenre(Genre Genre)
        {
                this.Genre = Genre;
        }

        public Collection<Song> getSongs()
        {
                return Songs;
        }

        public void setSongs(Collection<Song> Songs)
        {
                this.Songs = Songs;
        }

        @Override
        public int hashCode()
        {
                int hash = 0;
                hash = (AlbumID == null ? 0 : AlbumID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof Album) ) {
                        return false;
                }

                Album other = (Album) o;
                if( ( this.AlbumID == null && other.AlbumID != null )
                    || ( this.AlbumID != null && other.AlbumID == null )
                    || ( !this.AlbumID.equals(other.AlbumID) )
                  ) {
                        return false;
                }
                return true;
        }
        
        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.Album[id=" + AlbumID + "]";
        }

}