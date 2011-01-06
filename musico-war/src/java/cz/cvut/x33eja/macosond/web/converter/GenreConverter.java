package cz.cvut.x33eja.macosond.web.converter;

import cz.cvut.x33eja.macosond.persistence.entity.Genre;
import cz.cvut.x33eja.macosond.web.back.GenreBack;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class GenreConverter implements Converter
{

        public Object getAsObject(FacesContext context, UIComponent component, String value)
        {
                if (value == null || value.length() == 0) {
                    return null;
                }
                Integer id = new Integer(value);
                GenreBack genreBack = (GenreBack) context.getApplication().getELResolver().getValue(context.getELContext(), null, "genreBack");
                return genreBack.getGenreBean().get(id);
        }

        public String getAsString(FacesContext context, UIComponent component, Object value)
        {
                return ((Genre)value).getGenreID().toString();
        }

}
