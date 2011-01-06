package cz.cvut.x33eja.macosond.web.back;

import cz.cvut.x33eja.macosond.business.music.MusicianLocal;
import cz.cvut.x33eja.macosond.persistence.entity.Musician;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ondrej Macoszek <macosond@fel.cvut.cz>
 */
public class MusicianBack
{
        @EJB
        private MusicianLocal musicianBean;
        private Musician musician;
        private DataModel musicianListModel;

        public MusicianBack()
        {
                super();
                musician = new Musician();
        }

        public MusicianLocal getMusicianBean()
        {
                return musicianBean;
        }

        public void setMusicianBean(MusicianLocal musicianBean)
        {
                this.musicianBean = musicianBean;
        }

        public Musician getMusician()
        {
                return musician;
        }

        public void setMusician(Musician musician)
        {
                this.musician = musician;
        }

        public List<Musician> getMusicianList()
        {
                return new ArrayList<Musician>(musicianBean.getAll());
        }

        public DataModel getMusicianListModel()
        {
                musicianListModel = new ListDataModel(getMusicianList());
                return musicianListModel;
        }

        public void setMusicianListModel(DataModel musicianListModel)
        {
                this.musicianListModel = musicianListModel;
        }

        public DataModel getMusicianListSelectItemModel()
        {
                List<Musician> musicians = getMusicianList();
                ArrayList<SelectItem> output = new ArrayList<SelectItem>();
                for (Musician m : musicians) {
                        String name = m.getFirstName() + " " + m.getSecondName();
                        output.add(new SelectItem(m, name));
                }
                return new ListDataModel(output);
        }
        
        /**
         * =================== Actions ===================
         */

        public String add()
        {
                musicianBean.add(musician);
                return "list";
        }

        public String edit()
        {
                musician = (Musician) musicianListModel.getRowData();
                return "edit";
        }

        public String saveChanges()
        {
                musicianBean.edit(musician);
                return "list";
        }

        public String delete()
        {
                musicianBean.delete((Musician) musicianListModel.getRowData());
                return "list";
        }

}
