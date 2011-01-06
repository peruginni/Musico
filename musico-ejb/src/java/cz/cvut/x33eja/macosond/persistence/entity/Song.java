package cz.cvut.x33eja.macosond.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name="Song")
@NamedQuery(name="Song.list", query="SELECT s FROM Song s")
public class Song implements Serializable
{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="SongID")
	private Integer SongID;
        @Column(name="Name")
	private String Name;
        @Temporal(TemporalType.DATE)
        @Column(name="DateCreated")
	private Date DateCreated;

        @ManyToMany(mappedBy="Songs")
        private Collection<Album> Albums;

        public Song()
        {
                super();
        }

        public Song(Integer SongID)
        {
                super();
                this.SongID = SongID;
        }

        public Integer getSongID()
        {
                return SongID;
        }

        public void setSongID(Integer SongID)
        {
                this.SongID = SongID;
        }

        public String getName()
        {
                return Name;
        }

        public void setName(String Name)
        {
                this.Name = Name;
        }

        public Date getDateCreated()
        {
                return DateCreated;
        }

        public void setDateCreated(Date DateCreated)
        {
                this.DateCreated = DateCreated;
        }
        
        public Collection<Album> getAlbums()
        {
                return Albums;
        }

        public void setAlbums(Collection<Album> Albums)
        {
                this.Albums = Albums;
        }


        @Override
        public int hashCode()
        {
                int hash = 0;
                hash = (SongID == null ? 0 : SongID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof Song) ) {
                        return false;
                }

                Song other = (Song) o;
                if( ( this.SongID == null && other.SongID != null )
                    || ( this.SongID != null && other.SongID == null )
                    || ( !this.SongID.equals(other.SongID) )
                  ) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.Song[id=" + SongID + "]";
        }

}