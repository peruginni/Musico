package cz.cvut.x33eja.macosond.web.back;

import cz.cvut.x33eja.macosond.business.user.UserAccountLocal;
import cz.cvut.x33eja.macosond.persistence.entity.UserAccount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class UserAccountBack
{
        @EJB
        private UserAccountLocal userAccountBean;
        private UserAccount userAccount = new UserAccount();
        private DataModel userAccountListModel;

        public UserAccountLocal getUserAccountBean()
        {
                return userAccountBean;
        }

        public void setUserAccountBean(UserAccountLocal userAccountBean)
        {
                this.userAccountBean = userAccountBean;
        }

        public UserAccount getUserAccount()
        {
                return userAccount;
        }

        public void setUserAccount(UserAccount userAccount)
        {
                this.userAccount = userAccount;
        }

        public List<UserAccount> getUserAccountList() 
        {
                return new ArrayList<UserAccount>(userAccountBean.getAll());
        }

        public DataModel getUserAccountListModel()
        {
                userAccountListModel = new ListDataModel(getUserAccountList());
                return userAccountListModel;
        }

        public void setUserAccountListModel(DataModel userAccountListModel)
        {
                this.userAccountListModel = userAccountListModel;
        }

        public UserAccountBack()
        {
                super();
        }

        /**
         * =================== Actions ===================
         */

        public String register()
        {
                userAccountBean.add(userAccount);
                return "login";
        }

        public void logout() throws IOException
        {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                HttpSession httpSession = (HttpSession) ec.getSession(true);
                httpSession.invalidate();
                ec.redirect("index.jsf");
        }

}
