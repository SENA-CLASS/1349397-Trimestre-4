package co.edu.sena.mavenproject2.view.managerbean;

import co.edu.sena.mavenproject2.model.entities.FichaHasLista;
import co.edu.sena.mavenproject2.view.managerbean.util.JsfUtil;
import co.edu.sena.mavenproject2.view.managerbean.util.JsfUtil.PersistAction;
import co.edu.sena.mavenproject2.controller.ejbs.FichaHasListaFacade;

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

@Named("fichaHasListaController")
@SessionScoped
public class FichaHasListaController implements Serializable {

    @EJB
    private co.edu.sena.mavenproject2.controller.ejbs.FichaHasListaFacade ejbFacade;
    private List<FichaHasLista> items = null;
    private FichaHasLista selected;

    public FichaHasListaController() {
    }

    public FichaHasLista getSelected() {
        return selected;
    }

    public void setSelected(FichaHasLista selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FichaHasListaFacade getFacade() {
        return ejbFacade;
    }

    public FichaHasLista prepareCreate() {
        selected = new FichaHasLista();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FichaHasListaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FichaHasListaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FichaHasListaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FichaHasLista> getItems() {
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

    public FichaHasLista getFichaHasLista(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<FichaHasLista> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FichaHasLista> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = FichaHasLista.class)
    public static class FichaHasListaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FichaHasListaController controller = (FichaHasListaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fichaHasListaController");
            return controller.getFichaHasLista(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FichaHasLista) {
                FichaHasLista o = (FichaHasLista) object;
                return getStringKey(o.getFicha());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FichaHasLista.class.getName()});
                return null;
            }
        }

    }

}
