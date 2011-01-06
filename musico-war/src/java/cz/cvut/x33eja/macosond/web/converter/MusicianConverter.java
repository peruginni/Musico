package cz.cvut.x33eja.macosond.web.converter;

import cz.cvut.x33eja.macosond.persistence.entity.Musician;
import cz.cvut.x33eja.macosond.web.back.MusicianBack;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class MusicianConverter implements Converter
{

        public Object getAsObject(FacesContext context, UIComponent component, String value)
        {
                if (value == null || value.length() == 0) {
                    return null;
                }
                Integer id = new Integer(value);
                MusicianBack musicianBack = (MusicianBack) context.getApplication().getELResolver().getValue(context.getELContext(), null, "musicianBack");
                return musicianBack.getMusicianBean().get(id);
        }

        public String getAsString(FacesContext context, UIComponent component, Object value)
        {
                return ((Musician)value).getMusicianID().toString();
        }

}
