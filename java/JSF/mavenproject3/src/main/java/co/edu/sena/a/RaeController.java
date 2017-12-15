package co.edu.sena.a;

import co.edu.sena.mavenproject3.Rae;
import co.edu.sena.a.util.JsfUtil;
import co.edu.sena.a.util.JsfUtil.PersistAction;

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

@Named("raeController")
@SessionScoped
public class RaeController implements Serializable {

    @EJB
    private co.edu.sena.a.RaeFacade ejbFacade;
    private List<Rae> items = null;
    private Rae selected;

    public RaeController() {
    }

    public Rae getSelected() {
        return selected;
    }

    public void setSelected(Rae selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getRaePK().setProgramaCodigoVersion(selected.getCompetencia().getCompetenciaPK().getProgramaCodigoVersion());
        selected.getRaePK().setCompetenciaCodigo(selected.getCompetencia().getCompetenciaPK().getCodigo());
    }

    protected void initializeEmbeddableKey() {
        selected.setRaePK(new co.edu.sena.mavenproject3.RaePK());
    }

    private RaeFacade getFacade() {
        return ejbFacade;
    }

    public Rae prepareCreate() {
        selected = new Rae();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RaeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RaeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RaeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Rae> getItems() {
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

    public Rae getRae(co.edu.sena.mavenproject3.RaePK id) {
        return getFacade().find(id);
    }

    public List<Rae> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Rae> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Rae.class)
    public static class RaeControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RaeController controller = (RaeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "raeController");
            return controller.getRae(getKey(value));
        }

        co.edu.sena.mavenproject3.RaePK getKey(String value) {
            co.edu.sena.mavenproject3.RaePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.mavenproject3.RaePK();
            key.setCodigo(values[0]);
            key.setCompetenciaCodigo(values[1]);
            key.setProgramaCodigoVersion(values[2]);
            return key;
        }

        String getStringKey(co.edu.sena.mavenproject3.RaePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getCompetenciaCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getProgramaCodigoVersion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Rae) {
                Rae o = (Rae) object;
                return getStringKey(o.getRaePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Rae.class.getName()});
                return null;
            }
        }

    }

}
