package co.edu.sena.ejemplotemplates.view.frontcontroller;

import co.edu.sena.ejemplotemplates.model.entities.ItemChecker;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil.PersistAction;
import co.edu.sena.ejemplotemplates.controller.ejbs.ItemCheckerFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("itemCheckerController")
@SessionScoped
public class ItemCheckerController implements Serializable {

    @EJB
    private co.edu.sena.ejemplotemplates.controller.ejbs.ItemCheckerFacade ejbFacade;
    private List<ItemChecker> items = null;
    private ItemChecker selected;

    public ItemCheckerController() {
    }

    public ItemChecker getSelected() {
        return selected;
    }

    public void setSelected(ItemChecker selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getItemCheckerPK().setListaChequeo(selected.getListaChequeo1().getIdLista());
    }

    protected void initializeEmbeddableKey() {
        selected.setItemCheckerPK(new co.edu.sena.ejemplotemplates.model.entities.ItemCheckerPK());
    }

    private ItemCheckerFacade getFacade() {
        return ejbFacade;
    }

    public ItemChecker prepareCreate() {
        selected = new ItemChecker();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ItemCheckerCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ItemCheckerUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ItemCheckerDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ItemChecker> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ItemChecker getItemChecker(co.edu.sena.ejemplotemplates.model.entities.ItemCheckerPK id) {
        return getFacade().find(id);
    }

    public List<ItemChecker> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ItemChecker> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ItemChecker.class)
    public static class ItemCheckerControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ItemCheckerController controller = (ItemCheckerController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "itemCheckerController");
            return controller.getItemChecker(getKey(value));
        }

        co.edu.sena.ejemplotemplates.model.entities.ItemCheckerPK getKey(String value) {
            co.edu.sena.ejemplotemplates.model.entities.ItemCheckerPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.ejemplotemplates.model.entities.ItemCheckerPK();
            key.setListaChequeo(values[0]);
            key.setIdItem(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(co.edu.sena.ejemplotemplates.model.entities.ItemCheckerPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getListaChequeo());
            sb.append(SEPARATOR);
            sb.append(value.getIdItem());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ItemChecker) {
                ItemChecker o = (ItemChecker) object;
                return getStringKey(o.getItemCheckerPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ItemChecker.class.getName()});
                return null;
            }
        }

    }

}
