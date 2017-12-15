package co.edu.sena.mavenproject2.view.managerbean;

import co.edu.sena.mavenproject2.model.entities.GrupoProyecto;
import co.edu.sena.mavenproject2.view.managerbean.util.JsfUtil;
import co.edu.sena.mavenproject2.view.managerbean.util.JsfUtil.PersistAction;
import co.edu.sena.mavenproject2.controller.ejbs.GrupoProyectoFacade;

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

@Named("grupoProyectoController")
@SessionScoped
public class GrupoProyectoController implements Serializable {

    @EJB
    private co.edu.sena.mavenproject2.controller.ejbs.GrupoProyectoFacade ejbFacade;
    private List<GrupoProyecto> items = null;
    private GrupoProyecto selected;

    public GrupoProyectoController() {
    }

    public GrupoProyecto getSelected() {
        return selected;
    }

    public void setSelected(GrupoProyecto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getGrupoProyectoPK().setNumeroFicha(selected.getFicha().getNumeroFicha());
    }

    protected void initializeEmbeddableKey() {
        selected.setGrupoProyectoPK(new co.edu.sena.mavenproject2.model.entities.GrupoProyectoPK());
    }

    private GrupoProyectoFacade getFacade() {
        return ejbFacade;
    }

    public GrupoProyecto prepareCreate() {
        selected = new GrupoProyecto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("GrupoProyectoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("GrupoProyectoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("GrupoProyectoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<GrupoProyecto> getItems() {
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

    public GrupoProyecto getGrupoProyecto(co.edu.sena.mavenproject2.model.entities.GrupoProyectoPK id) {
        return getFacade().find(id);
    }

    public List<GrupoProyecto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<GrupoProyecto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = GrupoProyecto.class)
    public static class GrupoProyectoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GrupoProyectoController controller = (GrupoProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "grupoProyectoController");
            return controller.getGrupoProyecto(getKey(value));
        }

        co.edu.sena.mavenproject2.model.entities.GrupoProyectoPK getKey(String value) {
            co.edu.sena.mavenproject2.model.entities.GrupoProyectoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.mavenproject2.model.entities.GrupoProyectoPK();
            key.setNumeroFicha(values[0]);
            key.setCodigo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(co.edu.sena.mavenproject2.model.entities.GrupoProyectoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNumeroFicha());
            sb.append(SEPARATOR);
            sb.append(value.getCodigo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof GrupoProyecto) {
                GrupoProyecto o = (GrupoProyecto) object;
                return getStringKey(o.getGrupoProyectoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), GrupoProyecto.class.getName()});
                return null;
            }
        }

    }

}
