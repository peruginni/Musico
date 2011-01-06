package cz.cvut.x33eja.macosond.persistence.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Entity
@Table(name="Ability")
@NamedQuery(name="Ability.list", query="SELECT a FROM Ability a")
public class Ability implements Serializable
{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="AbilityID")
        private Integer AbilityID;
        @Column(name="Name", unique = true)
        private String Name;

        @ManyToMany(mappedBy="Abilities")
        private Collection<Musician> Musicians;

        public Ability()
        {
                super();
        }

        public Ability(Integer AbilityID)
        {
                super();
                this.AbilityID = AbilityID;
        }

        public Integer getAbilityID()
        {
                return AbilityID;
        }

        public void setAbilityID(Integer AbilityID)
        {
                this.AbilityID = AbilityID;
        }

        public String getName()
        {
                return Name;
        }

        public void setName(String Name)
        {
                this.Name = Name;
        }

        public Collection<Musician> getMusicians()
        {
                return Musicians;
        }

        public void setMusicians(Collection<Musician> Musicians)
        {
                this.Musicians = Musicians;
        }

        @Override
        public int hashCode()
        {
                int hash = 0;
                hash = (AbilityID == null ? 0 : AbilityID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof Ability) ) {
                        return false;
                }

                Ability other = (Ability) o;
                if( ( this.AbilityID == null && other.AbilityID != null )
                    || ( this.AbilityID != null && other.AbilityID == null )
                    || ( !this.AbilityID.equals(other.AbilityID) )
                  ) {
                        return false;
                }
                return true;
        }
        
        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.Ability[id=" + AbilityID + "]";
        }

}