package co.edu.sena.ejemplotemplates.view.frontcontroller;

import co.edu.sena.ejemplotemplates.model.entities.ObservacionGeneral;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil.PersistAction;
import co.edu.sena.ejemplotemplates.controller.ejbs.ObservacionGeneralFacade;

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

@Named("observacionGeneralController")
@SessionScoped
public class ObservacionGeneralController implements Serializable {

    @EJB
    private co.edu.sena.ejemplotemplates.controller.ejbs.ObservacionGeneralFacade ejbFacade;
    private List<ObservacionGeneral> items = null;
    private ObservacionGeneral selected;

    public ObservacionGeneralController() {
    }

    public ObservacionGeneral getSelected() {
        return selected;
    }

    public void setSelected(ObservacionGeneral selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getObservacionGeneralPK().setGrupoCodigo(selected.getGrupoProyecto().getGrupoProyectoPK().getCodigo());
        selected.getObservacionGeneralPK().setGrupoNumeroFicha(selected.getGrupoProyecto().getGrupoProyectoPK().getNumeroFicha());
    }

    protected void initializeEmbeddableKey() {
        selected.setObservacionGeneralPK(new co.edu.sena.ejemplotemplates.model.entities.ObservacionGeneralPK());
    }

    private ObservacionGeneralFacade getFacade() {
        return ejbFacade;
    }

    public ObservacionGeneral prepareCreate() {
        selected = new ObservacionGeneral();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ObservacionGeneralCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ObservacionGeneralUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ObservacionGeneralDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ObservacionGeneral> getItems() {
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

    public ObservacionGeneral getObservacionGeneral(co.edu.sena.ejemplotemplates.model.entities.ObservacionGeneralPK id) {
        return getFacade().find(id);
    }

    public List<ObservacionGeneral> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ObservacionGeneral> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ObservacionGeneral.class)
    public static class ObservacionGeneralControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ObservacionGeneralController controller = (ObservacionGeneralController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "observacionGeneralController");
            return controller.getObservacionGeneral(getKey(value));
        }

        co.edu.sena.ejemplotemplates.model.entities.ObservacionGeneralPK getKey(String value) {
            co.edu.sena.ejemplotemplates.model.entities.ObservacionGeneralPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.ejemplotemplates.model.entities.ObservacionGeneralPK();
            key.setGrupoNumeroFicha(values[0]);
            key.setGrupoCodigo(Integer.parseInt(values[1]));
            key.setIdObservacion(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(co.edu.sena.ejemplotemplates.model.entities.ObservacionGeneralPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getGrupoNumeroFicha());
            sb.append(SEPARATOR);
            sb.append(value.getGrupoCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getIdObservacion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ObservacionGeneral) {
                ObservacionGeneral o = (ObservacionGeneral) object;
                return getStringKey(o.getObservacionGeneralPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ObservacionGeneral.class.getName()});
                return null;
            }
        }

    }

}
