package co.edu.sena.a;

import co.edu.sena.mavenproject3.Competencia;
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

@Named("competenciaController")
@SessionScoped
public class CompetenciaController implements Serializable {

    @EJB
    private co.edu.sena.a.CompetenciaFacade ejbFacade;
    private List<Competencia> items = null;
    private Competencia selected;

    public CompetenciaController() {
    }

    public Competencia getSelected() {
        return selected;
    }

    public void setSelected(Competencia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCompetenciaPK().setProgramaCodigoVersion(selected.getPrograma().getCodigoVersion());
    }

    protected void initializeEmbeddableKey() {
        selected.setCompetenciaPK(new co.edu.sena.mavenproject3.CompetenciaPK());
    }

    private CompetenciaFacade getFacade() {
        return ejbFacade;
    }

    public Competencia prepareCreate() {
        selected = new Competencia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CompetenciaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CompetenciaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CompetenciaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Competencia> getItems() {
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

    public Competencia getCompetencia(co.edu.sena.mavenproject3.CompetenciaPK id) {
        return getFacade().find(id);
    }

    public List<Competencia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Competencia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Competencia.class)
    public static class CompetenciaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CompetenciaController controller = (CompetenciaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "competenciaController");
            return controller.getCompetencia(getKey(value));
        }

        co.edu.sena.mavenproject3.CompetenciaPK getKey(String value) {
            co.edu.sena.mavenproject3.CompetenciaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.mavenproject3.CompetenciaPK();
            key.setCodigo(values[0]);
            key.setProgramaCodigoVersion(values[1]);
            return key;
        }

        String getStringKey(co.edu.sena.mavenproject3.CompetenciaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getProgramaCodigoVersion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Competencia) {
                Competencia o = (Competencia) object;
                return getStringKey(o.getCompetenciaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Competencia.class.getName()});
                return null;
            }
        }

    }

}
