package cz.cvut.x33eja.macosond.business.user;

import cz.cvut.x33eja.macosond.persistence.entity.UserAccount;
import java.util.Collection;
import javax.ejb.Local;

/**
 * @author Ondra
 * @version 1.0
 * @created 23-XII-2009 19:34:17
 */
@Local
public interface UserAccountLocal
{

	/**
	 * Add new useraccount
	 * @param user
	 */
	public void add(UserAccount user);

	/**
	 * Edit existing useraccount
	 * @param user
	 */
	public void edit(UserAccount user);

	/**
	 * Delete existing useraccount
	 * @param user
	 */
	public void delete(UserAccount user);

	/**
	 * Get specific useraccount by info in given object
	 * @param user
	 */
	public UserAccount get(UserAccount user);

        /**
	 * Get specific useraccount by given id
	 * @param user
	 */
	public UserAccount get(Integer UserAccountID);

        /**
         * Check if username exists in database
         * @param Username
         * @return true if username exists
         * @return fals if username not exists
         */
        public boolean usernameExists(String Username);

        /**
         * Check if email exists in database
         * @param Email
         * @return true if email exists
         * @return false if email not exists
         */
        public boolean emailExists(String Email);

        /**
         * For current user change old password to new one
         * @param oldPassword
         * @param newPassword
         * @return true if password changed
         * @return false if password not changed
         */
        public boolean changePassword(String oldPassword, String newPassword);

        /**
         * Return current logged user (in current session)
         * @return User user entity if logged 
         */
        public UserAccount getCurrentUser();

        /**
         * Get all existing user accounts
         * @return
         */
	public Collection<UserAccount> getAll();

}