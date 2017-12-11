package co.edu.sena.ejemplotemplates.view.frontcontroller;

import co.edu.sena.ejemplotemplates.model.entities.Trimestre;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil.PersistAction;
import co.edu.sena.ejemplotemplates.controller.ejbs.TrimestreFacade;

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

@Named("trimestreController")
@SessionScoped
public class TrimestreController implements Serializable {

    @EJB
    private co.edu.sena.ejemplotemplates.controller.ejbs.TrimestreFacade ejbFacade;
    private List<Trimestre> items = null;
    private Trimestre selected;

    public TrimestreController() {
    }

    public Trimestre getSelected() {
        return selected;
    }

    public void setSelected(Trimestre selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTrimestrePK().setJornadaNombre(selected.getJornada().getNombre());
    }

    protected void initializeEmbeddableKey() {
        selected.setTrimestrePK(new co.edu.sena.ejemplotemplates.model.entities.TrimestrePK());
    }

    private TrimestreFacade getFacade() {
        return ejbFacade;
    }

    public Trimestre prepareCreate() {
        selected = new Trimestre();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TrimestreCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TrimestreUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TrimestreDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Trimestre> getItems() {
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

    public Trimestre getTrimestre(co.edu.sena.ejemplotemplates.model.entities.TrimestrePK id) {
        return getFacade().find(id);
    }

    public List<Trimestre> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Trimestre> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Trimestre.class)
    public static class TrimestreControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TrimestreController controller = (TrimestreController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "trimestreController");
            return controller.getTrimestre(getKey(value));
        }

        co.edu.sena.ejemplotemplates.model.entities.TrimestrePK getKey(String value) {
            co.edu.sena.ejemplotemplates.model.entities.TrimestrePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.ejemplotemplates.model.entities.TrimestrePK();
            key.setIdTrimestre(values[0]);
            key.setJornadaNombre(values[1]);
            return key;
        }

        String getStringKey(co.edu.sena.ejemplotemplates.model.entities.TrimestrePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdTrimestre());
            sb.append(SEPARATOR);
            sb.append(value.getJornadaNombre());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Trimestre) {
                Trimestre o = (Trimestre) object;
                return getStringKey(o.getTrimestrePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Trimestre.class.getName()});
                return null;
            }
        }

    }

}
