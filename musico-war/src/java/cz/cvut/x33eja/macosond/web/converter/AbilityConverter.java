package cz.cvut.x33eja.macosond.web.converter;

import cz.cvut.x33eja.macosond.persistence.entity.Ability;
import cz.cvut.x33eja.macosond.web.back.AbilityBack;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class AbilityConverter implements Converter
{

        public Object getAsObject(FacesContext context, UIComponent component, String value)
        {
                if (value == null || value.length() == 0) {
                    return null;
                }
                Integer id = new Integer(value);
                AbilityBack abilityBack = (AbilityBack) context.getApplication().getELResolver().getValue(context.getELContext(), null, "abilityBack");
                return abilityBack.getAbilityBean().get(id);
        }

        public String getAsString(FacesContext context, UIComponent component, Object value)
        {
                return ((Ability)value).getAbilityID().toString();
        }

}
