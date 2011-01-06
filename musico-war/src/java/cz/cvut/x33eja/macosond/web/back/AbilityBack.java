package cz.cvut.x33eja.macosond.web.back;

import cz.cvut.x33eja.macosond.business.music.AbilityLocal;
import cz.cvut.x33eja.macosond.persistence.entity.Ability;
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
public class AbilityBack
{
        @EJB
        private AbilityLocal abilityBean;
        private Ability ability;
        private DataModel abilityListModel;

        public AbilityBack()
        {
                super();
                ability = new Ability();
        }

        public AbilityLocal getAbilityBean()
        {
                return abilityBean;
        }

        public void setAbilityBean(AbilityLocal abilityBean)
        {
                this.abilityBean = abilityBean;
        }

        public Ability getAbility()
        {
                return ability;
        }

        public void setAbility(Ability ability)
        {
                this.ability = ability;
        }

        public List<Ability> getAbilityList()
        {
                return new ArrayList<Ability>(abilityBean.getAll());
        }

        public DataModel getAbilityListModel()
        {
                abilityListModel = new ListDataModel(getAbilityList());
                return abilityListModel;
        }

        public void setAbilityListModel(DataModel abilityListModel)
        {
                this.abilityListModel = abilityListModel;
        }

        public DataModel getAbilityListSelectItemModel()
        {
                List<Ability> abilities = getAbilityList();
                ArrayList<SelectItem> output = new ArrayList<SelectItem>();
                for (Ability a : abilities) {
                        output.add(new SelectItem(a, a.getName()));
                }
                return new ListDataModel(output);
        }
        
        /**
         * =================== Actions ===================
         */

        public String add()
        {
                abilityBean.add(ability);
                return "list";
        }

        public String edit()
        {
                ability = (Ability) abilityListModel.getRowData();
                return "edit";
        }

        public String saveChanges()
        {
                abilityBean.edit(ability);
                return "list";
        }

        public String delete()
        {
                abilityBean.delete((Ability) abilityListModel.getRowData());
                return "list";
        }

}
