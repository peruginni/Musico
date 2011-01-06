package cz.cvut.x33eja.macosond.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="UserAccount")
@NamedQueries({
        @NamedQuery(name="UserAccount.list",
                query="SELECT u FROM UserAccount u"),
        @NamedQuery(name="UserAccount.byUsername",
                query="SELECT u FROM UserAccount u WHERE u.Username = :Username"),
        @NamedQuery(name="UserAccount.byEmail",
                query="SELECT u FROM UserAccount u WHERE u.Email = :Email")
})
public class UserAccount implements Serializable
{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="UserAccountID")
	private Integer UserAccountID;
        @Column(name="Email", unique = true)
	private String Email;
        @Column(name="Username", unique = true)
	private String Username;
        @Column(name="Password")
	private String Password;
        @Temporal(TemporalType.DATE)
        @Column(name="DateCreated")
	private Date DateCreated;
        @Column(name="DisplayName")
	private String DisplayName;

        public UserAccount()
        {
                super();
        }

        public UserAccount(Integer UserAccountID)
        {
                super();
                this.UserAccountID = UserAccountID;
        }

        public Integer getUserAccountID()
        {
                return UserAccountID;
        }

        public void setUserAccountID(Integer UserAccountID)
        {
                this.UserAccountID = UserAccountID;
        }

        public String getEmail()
        {
                return Email;
        }

        public void setEmail(String Email)
        {
                this.Email = Email;
        }

        public String getUsername()        
        {
                return Username;
        }

        public void setUsername(String Username)
        {
                this.Username = Username;
        }

        public String getPassword()
        {
                return Password;
        }

        public void setPassword(String Password)
        {
                this.Password = Password;
        }

        public Date getDateCreated()        
        {
                return DateCreated;
        }

        public void setDateCreated(Date DateCreated)
        {
                this.DateCreated = DateCreated;
        }

        public String getDisplayName()
        {
                return DisplayName;
        }

        public void setDisplayName(String DisplayName)
        {
                this.DisplayName = DisplayName;
        }

        @Override
        public int hashCode()
        {
                int hash = 0;
                hash = (UserAccountID == null ? 0 : UserAccountID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof UserAccount) ) {
                        return false;
                }

                UserAccount other = (UserAccount) o;
                if( ( this.UserAccountID == null && other.UserAccountID != null )
                    || ( this.UserAccountID != null && other.UserAccountID == null )
                    || ( !this.UserAccountID.equals(other.UserAccountID) )
                  ) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.UserAccount[id=" + UserAccountID + "]";
        }

}