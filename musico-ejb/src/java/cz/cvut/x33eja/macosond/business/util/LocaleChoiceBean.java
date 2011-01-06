package cz.cvut.x33eja.macosond.business.util;

import java.util.Locale;
import javax.ejb.Stateful;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
@Stateful
public class LocaleChoiceBean implements LocaleChoiceLocal
{
        private Locale currentLocale;

        public Locale getCurrentLocale()
        {
                return currentLocale;
        }

        public void setCurrentLocale(Locale currentLocale)
        {
                this.currentLocale = currentLocale;
        }
}
