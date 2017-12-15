package co.edu.sena.mavenproject2.view.managerbean;

import co.edu.sena.mavenproject2.model.entities.InstructorFicha;
import co.edu.sena.mavenproject2.view.managerbean.util.JsfUtil;
import co.edu.sena.mavenproject2.view.managerbean.util.JsfUtil.PersistAction;
import co.edu.sena.mavenproject2.controller.ejbs.InstructorFichaFacade;

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

@Named("instructorFichaController")
@SessionScoped
public class InstructorFichaController implements Serializable {

    @EJB
    private co.edu.sena.mavenproject2.controller.ejbs.InstructorFichaFacade ejbFacade;
    private List<InstructorFicha> items = null;
    private InstructorFicha selected;

    public InstructorFichaController() {
    }

    public InstructorFicha getSelected() {
        return selected;
    }

    public void setSelected(InstructorFicha selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getInstructorFichaPK().setTipoDocumento(selected.getCliente().getClientePK().getTipoDocumento());
        selected.getInstructorFichaPK().setFicha(selected.getFicha1().getNumeroFicha());
        selected.getInstructorFichaPK().setNumeroDocumento(selected.getCliente().getClientePK().getNumeroDocumento());
    }

    protected void initializeEmbeddableKey() {
        selected.setInstructorFichaPK(new co.edu.sena.mavenproject2.model.entities.InstructorFichaPK());
    }

    private InstructorFichaFacade getFacade() {
        return ejbFacade;
    }

    public InstructorFicha prepareCreate() {
        selected = new InstructorFicha();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InstructorFichaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InstructorFichaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InstructorFichaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<InstructorFicha> getItems() {
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

    public InstructorFicha getInstructorFicha(co.edu.sena.mavenproject2.model.entities.InstructorFichaPK id) {
        return getFacade().find(id);
    }

    public List<InstructorFicha> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<InstructorFicha> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = InstructorFicha.class)
    public static class InstructorFichaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InstructorFichaController controller = (InstructorFichaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "instructorFichaController");
            return controller.getInstructorFicha(getKey(value));
        }

        co.edu.sena.mavenproject2.model.entities.InstructorFichaPK getKey(String value) {
            co.edu.sena.mavenproject2.model.entities.InstructorFichaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.mavenproject2.model.entities.InstructorFichaPK();
            key.setTipoDocumento(values[0]);
            key.setNumeroDocumento(values[1]);
            key.setFicha(values[2]);
            return key;
        }

        String getStringKey(co.edu.sena.mavenproject2.model.entities.InstructorFichaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getNumeroDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getFicha());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof InstructorFicha) {
                InstructorFicha o = (InstructorFicha) object;
                return getStringKey(o.getInstructorFichaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InstructorFicha.class.getName()});
                return null;
            }
        }

    }

}
