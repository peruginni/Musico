package cz.cvut.x33eja.macosond.web.back;

import cz.cvut.x33eja.macosond.business.util.LocaleChoiceLocal;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class LocaleBack
{
        @EJB
        private LocaleChoiceLocal localeChoiceBean;
        
        public LocaleBack()
        {
                super();
        }

        public Locale getCurrentLocale()
        {
                Locale current = localeChoiceBean.getCurrentLocale();
                if(current == null) {
                        Locale preferred = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
                        if(!preferred.equals(LocaleChoiceLocal.CZECH) && !preferred.equals(LocaleChoiceLocal.ENGLISH)) {
                                current = LocaleChoiceLocal.CZECH;
                        }
                        setCurrentLocale(current);
                }
                return current;
        }

        public void setCurrentLocale(Locale currentLocale)
        {
                FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
                localeChoiceBean.setCurrentLocale(currentLocale);
        }

        public boolean isCzech()
        {
                if(getCurrentLocale() == null) {
                        return false;
                }
                return getCurrentLocale().equals(LocaleChoiceLocal.CZECH);
        }

        public boolean isEnglish()
        {
                return !isCzech();
        }


        /**
         * =================== Actions ===================
         */

        public void switchToEnglish()
        {
                setCurrentLocale(LocaleChoiceLocal.ENGLISH);
        }

        public void switchToCzech()
        {
                setCurrentLocale(LocaleChoiceLocal.CZECH);
        }

        
}
