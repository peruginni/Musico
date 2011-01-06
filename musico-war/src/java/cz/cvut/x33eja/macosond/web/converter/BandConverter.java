package cz.cvut.x33eja.macosond.web.converter;

import cz.cvut.x33eja.macosond.persistence.entity.Band;
import cz.cvut.x33eja.macosond.web.back.BandBack;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class BandConverter implements Converter
{

        public Object getAsObject(FacesContext context, UIComponent component, String value)
        {
                if (value == null || value.length() == 0) {
                    return null;
                }
                Integer id = new Integer(value);
                BandBack bandBack = (BandBack) context.getApplication().getELResolver().getValue(context.getELContext(), null, "bandBack");
                return bandBack.getBandBean().get(id);
        }

        public String getAsString(FacesContext context, UIComponent component, Object value)
        {
                return ((Band)value).getBandID().toString();
        }

}
