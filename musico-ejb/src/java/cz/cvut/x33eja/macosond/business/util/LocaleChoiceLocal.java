package cz.cvut.x33eja.macosond.business.util;

import java.util.Locale;
import javax.ejb.Local;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
@Local
public interface LocaleChoiceLocal
{
        public final static Locale CZECH = new Locale("cs", "CZ");
        public final static Locale ENGLISH = Locale.ENGLISH;

        public Locale getCurrentLocale();
        public void setCurrentLocale(Locale currentLocale);
}
