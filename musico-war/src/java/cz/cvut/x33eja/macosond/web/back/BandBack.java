package cz.cvut.x33eja.macosond.web.back;

import cz.cvut.x33eja.macosond.business.music.BandLocal;
import cz.cvut.x33eja.macosond.persistence.entity.Band;
import cz.cvut.x33eja.macosond.persistence.entity.Musician;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class BandBack
{
        @EJB
        private BandLocal bandBean;
        private Band band;
        private DataModel bandListModel;

        public BandBack()
        {
                super();
                band = new Band();
                band.setDateCreated(new Date());
        }

        public BandLocal getBandBean()
        {
                return bandBean;
        }

        public void setBandBean(BandLocal bandBean)
        {
                this.bandBean = bandBean;
        }

        public Band getBand()
        {
                return band;
        }

        public void setBand(Band band)
        {
                this.band = band;
        }

        public List<Band> getBandList()
        {
                return new ArrayList<Band>(bandBean.getAll());
        }

        public DataModel getBandListModel()
        {
                bandListModel = new ListDataModel(getBandList());
                return bandListModel;
        }

        public void setBandListModel(DataModel bandListModel)
        {
                this.bandListModel = bandListModel;
        }

        public DataModel getBandListSelectItemModel()
        {
                List<Band> bands = getBandList();
                ArrayList<SelectItem> output = new ArrayList<SelectItem>();
                for (Band b : bands) {
                        output.add(new SelectItem(b, b.getName()));
                }
                return new ListDataModel(output);
        }
        
        /**
         * =================== Actions ===================
         */

        public String add()
        {
                bandBean.add(band);
                return "list";
        }

        public String edit()
        {
                band = (Band) bandListModel.getRowData();
                return "edit";
        }

        public String saveChanges()
        {
                bandBean.edit(band);
                return "list";
        }

        public String delete()
        {
                bandBean.delete((Band) bandListModel.getRowData());
                return "list";
        }

}
