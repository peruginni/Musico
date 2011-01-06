package cz.cvut.x33eja.macosond.business.user;

import cz.cvut.x33eja.macosond.business.util.Password;
import cz.cvut.x33eja.macosond.persistence.entity.UserAccount;
import cz.cvut.x33eja.macosond.persistence.entity.UserRole;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
@Stateless
public class UserAccountBean implements UserAccountLocal
{
        @PersistenceContext(unitName="Musico-PU")
        private EntityManager em;

        @Resource
        private SessionContext sc;

        @PermitAll
        public void add(UserAccount user)
        {
                em.persist(user);
        }

        @RolesAllowed({"member","admin"})
        public void edit(UserAccount user)
        {
                if(sc.isCallerInRole(UserRole.ADMIN)) {
                        user = em.merge(user);
                        em.persist(user);
                } else {
                        UserAccount current = getCurrentUser();
                        if(current.getUserAccountID().equals(user.getUserAccountID())) {
                                user = em.merge(user);
                                em.persist(user);
                        }
                }
        }

        @RolesAllowed({"admin"})
        public void delete(UserAccount user)
        {
                user = em.merge(user);
                em.remove(user);
        }

        @PermitAll
        public UserAccount get(UserAccount user)
        {
                return em.find(UserAccount.class, user.getUserAccountID());
        }

        @PermitAll
        public UserAccount get(Integer UserAccountID)
        {
                return em.find(UserAccount.class, UserAccountID);
        }

        @PermitAll
        public boolean usernameExists(String Username)
        {
                Query query = em.createNamedQuery("UserAccount.byUsername");
                query.setParameter("Username", Username);
                if(query.getSingleResult() == null) {
                        return false;
                } else {
                        return true;
                }
        }

        @PermitAll
        public boolean emailExists(String Email)
        {
                Query query = em.createNamedQuery("UserAccount.byEmail");
                query.setParameter("Email", Email);
                if(query.getSingleResult() == null) {
                        return false;
                } else {
                        return true;
                }
        }

        @RolesAllowed({"member","admin"})
        public boolean changePassword(String oldPassword, String newPassword)
        {
                try {
                        UserAccount userAccount = getCurrentUser();
                        if (userAccount.getPassword().equals(Password.encode(oldPassword))) {
                                userAccount.setPassword(Password.encode(newPassword));
                                em.persist(userAccount);
                                return true;
                        }
                        return false;
                } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(UserAccountBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                return false;
        }

        @PermitAll
        public UserAccount getCurrentUser()
        {
                String username = sc.getCallerPrincipal().getName();
                if(username == null) {
                        return null;
                }
                Query query = em.createNamedQuery("UserAccount.byUsername");
                query.setParameter("Username", username);
                try {
                        return (UserAccount) query.getSingleResult();
                } catch(javax.persistence.NoResultException ex) {
                        return null;
                }
        }

        @RolesAllowed({"admin"})
        public Collection<UserAccount> getAll()
        {
                return em.createNamedQuery("UserAccount.list").getResultList();
        }
}
