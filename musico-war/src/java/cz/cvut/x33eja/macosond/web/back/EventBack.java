package cz.cvut.x33eja.macosond.web.back;

import cz.cvut.x33eja.macosond.business.music.EventLocal;
import cz.cvut.x33eja.macosond.persistence.entity.Event;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class EventBack
{
        @EJB
        private EventLocal eventBean;
        private Event event;
        private DataModel eventListModel;

        public EventBack()
        {
                super();
                event = new Event();

                // set current date and evening time
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(new Date());
                gc.set(Calendar.HOUR_OF_DAY, 19);
                gc.set(Calendar.MINUTE, 0);
                event.setDateStart(gc.getTime()); // set current date and time
                gc.set(Calendar.HOUR_OF_DAY, 23);
                gc.set(Calendar.MINUTE, 0);
                event.setDateEnd(gc.getTime()); // set current date and time
        }

        public EventLocal getEventBean()
        {
                return eventBean;
        }

        public void setEventBean(EventLocal eventBean)
        {
                this.eventBean = eventBean;
        }

        public Event getEvent()
        {
                return event;
        }

        public void setEvent(Event event)
        {
                this.event = event;
        }
        
        public List<Event> getEventList()
        {
                return new ArrayList<Event>(eventBean.getAll());
        }

        public DataModel getEventListModel()
        {       
                eventListModel = new ListDataModel(getEventList());
                return eventListModel;
        }

        public void setEventListModel(DataModel eventListModel)
        {
                this.eventListModel = eventListModel;
        }

        public DataModel getEventListSelectItemModel()
        {
                List<Event> events = getEventList();
                ArrayList<SelectItem> output = new ArrayList<SelectItem>();
                for (Event e : events) {
                        output.add(new SelectItem(e, e.getName()));
                }
                return new ListDataModel(output);
        }

        /**
         * =================== Actions ===================
         */

        public String add()
        {
                eventBean.add(event);
                return "list";
        }

        public String edit()
        {
                event = (Event) eventListModel.getRowData();
                return "edit";
        }

        public String saveChanges()
        {
                eventBean.edit(event);
                return "list";
        }

        public String delete()
        {
                Integer id = ((Event) eventListModel.getRowData()).getEventID();
                event = eventBean.get(id);
                eventBean.delete(event);
                return "list";
        }
}
