package cz.cvut.x33eja.macosond.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Entity
@Table(name="Musician")
@NamedQuery(name="Musician.list", query="SELECT m FROM Musician m")
public class Musician implements Serializable
{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="MusicianID")
	private Integer MusicianID;
        @Column(name="FirstName")
	private String FirstName;
        @Column(name="SecondName")
	private String SecondName;
        @Column(name="ArtName")
	private String ArtName;
        @Column(name="Biography")
	private String Biography;

        @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "Musicians")
        private Collection<Band> Bands;

        @ManyToMany
        @JoinTable(
                name = "MusicianAbility",
                joinColumns = @JoinColumn(name="MusicianID", referencedColumnName="MusicianID"),
                inverseJoinColumns = @JoinColumn(name="AbilityID", referencedColumnName="AbilityID")
        )
        private Collection<Ability> Abilities;
        
        public Musician()
        {
                super();
        }

        public Musician(Integer MusicianID)
        {
                super();
                this.MusicianID = MusicianID;
        }

        public Integer getMusicianID()
        {
                return MusicianID;
        }

        public void setMusicianID(Integer MusicianID)
        {
                this.MusicianID = MusicianID;
        }

        public String getFirstName()
        {
                return FirstName;
        }

        public void setFirstName(String FirstName)
        {
                this.FirstName = FirstName;
        }

        public String getSecondName()
        {
                return SecondName;
        }

        public void setSecondName(String SecondName)
        {
                this.SecondName = SecondName;
        }

        public String getArtName()
        {
                return ArtName;
        }

        public void setArtName(String ArtName)
        {
                this.ArtName = ArtName;
        }

        public String getBiography()
        {
                return Biography;
        }

        public void setBiography(String Biography)
        {
                this.Biography = Biography;
        }

        public Collection<Band> getBands()
        {
                return Bands;
        }

        public void setBands(Collection<Band> Bands)
        {
                this.Bands = Bands;
        }

        public Collection<Ability> getAbilities()
        {
                return Abilities;
        }

        public void setAbilities(Collection<Ability> Abilities)
        {
                this.Abilities = Abilities;
        }
       
        @Override
        public int hashCode()
        {
                int hash = 0;
                hash = (MusicianID == null ? 0 : MusicianID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof Musician) ) {
                        return false;
                }

                Musician other = (Musician) o;
                if( ( this.MusicianID == null && other.MusicianID != null )
                    || ( this.MusicianID != null && other.MusicianID == null )
                    || ( !this.MusicianID.equals(other.MusicianID) )
                  ) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.Musician[id=" + MusicianID + "]";
        }


}