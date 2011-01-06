package cz.cvut.x33eja.macosond.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:16
 */
@Entity
@Table(name="UserRole")
@NamedQueries({
        @NamedQuery(name="UserRole.list", query="SELECT ur FROM UserRole ur")
})
public class UserRole implements Serializable
{
        private static final long serialVersionUID = 1L;
        public final static String GUEST = "guest";
        public final static String MEMBER = "member";
        public final static String ADMIN = "admin";

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="UserRoleID")
	private Integer UserRoleID;
        @Column(name="Username")
	private String Username;
        @Column(name="RoleName")
	private String RoleName;

        public UserRole()
        {
                super();
        }

        public UserRole(Integer UserRoleID)
        {
                super();
                this.UserRoleID = UserRoleID;
        }

        public Integer getUserRoleID()
        {
                return UserRoleID;
        }

        public void setUserRoleID(Integer UserRoleID)
        {
                this.UserRoleID = UserRoleID;
        }

        public String getUsername()
        {
                return Username;
        }

        public void setUsername(String Username)
        {
                this.Username = Username;
        }

        public String getRoleName()
        {
                return RoleName;
        }

        public void setRoleName(String RoleName)
        {
                this.RoleName = RoleName;
        }


        @Override
        public int hashCode()
        {
                int hash = 0;
                hash = (UserRoleID == null ? 0 : UserRoleID.hashCode());
                return hash;
        }

        @Override
        public boolean equals(Object o)
        {
                if( !(o instanceof UserRole) ) {
                        return false;
                }

                UserRole other = (UserRole) o;
                if( ( this.UserRoleID == null && other.UserRoleID != null )
                    || ( this.UserRoleID != null && other.UserRoleID == null )
                    || ( !this.UserRoleID.equals(other.UserRoleID) )
                  ) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString()
        {
                return "cz.cvut.x33eja.macosond.persistence.entity.UserRole[id=" + UserRoleID + "]";
        }

}