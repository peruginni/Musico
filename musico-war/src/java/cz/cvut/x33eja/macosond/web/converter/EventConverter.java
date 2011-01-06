package cz.cvut.x33eja.macosond.web.converter;

import cz.cvut.x33eja.macosond.persistence.entity.Event;
import cz.cvut.x33eja.macosond.web.back.EventBack;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class EventConverter implements Converter
{

        public Object getAsObject(FacesContext context, UIComponent component, String value)
        {
                if (value == null || value.length() == 0) {
                    return null;
                }
                Integer id = new Integer(value);
                EventBack eventBack = (EventBack) context.getApplication().getELResolver().getValue(context.getELContext(), null, "eventBack");
                return eventBack.getEventBean().get(id);
        }

        public String getAsString(FacesContext context, UIComponent component, Object value)
        {
                return ((Event)value).getEventID().toString();
        }

}
