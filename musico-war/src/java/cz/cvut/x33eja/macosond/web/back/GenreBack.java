package cz.cvut.x33eja.macosond.web.back;

import cz.cvut.x33eja.macosond.business.music.GenreLocal;
import cz.cvut.x33eja.macosond.persistence.entity.Genre;
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
public class GenreBack
{
        @EJB
        private GenreLocal genreBean;

        private Genre genre;
        private DataModel genreListModel;

        public GenreBack()
        {
                super();
                genre = new Genre();
        }

        public GenreLocal getGenreBean()
        {
                return genreBean;
        }

        public void setGenreBean(GenreLocal genreBean)
        {
                this.genreBean = genreBean;
        }

        public Genre getGenre()
        {
                return genre;
        }

        public void setGenre(Genre genre)
        {
                this.genre = genre;
        }

        public List<Genre> getGenreList()
        {
                return new ArrayList<Genre>(genreBean.getAll());
        }

        public DataModel getGenreListModel()
        {
                genreListModel = new ListDataModel(getGenreList());
                return genreListModel;
        }

        public void setGenreListModel(DataModel genreListModel)
        {
                this.genreListModel = genreListModel;
        }

        public DataModel getGenreListSelectItemModel()
        {
                List<Genre> genres = getGenreList();
                ArrayList<SelectItem> output = new ArrayList<SelectItem>();
                for (Genre g : genres) {
                        output.add(new SelectItem(g, g.getName()));
                }
                return new ListDataModel(output);
        }
        
        /**
         * =================== Actions ===================
         */

        public String add()
        {
                genreBean.add(genre);
                return "list";
        }

        public String edit()
        {
                genre = (Genre) genreListModel.getRowData();
                return "edit";
        }

        public String saveChanges()
        {
                genreBean.edit(genre);
                return "list";
        }

        public String delete()
        {
                genreBean.delete((Genre) genreListModel.getRowData());
                return "list";
        }

}
