package co.edu.sena.ejemplotemplates.view.frontcontroller;

import co.edu.sena.ejemplotemplates.model.entities.InstructorHasTrimestre;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil.PersistAction;
import co.edu.sena.ejemplotemplates.controller.ejbs.InstructorHasTrimestreFacade;

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

@Named("instructorHasTrimestreController")
@SessionScoped
public class InstructorHasTrimestreController implements Serializable {

    @EJB
    private co.edu.sena.ejemplotemplates.controller.ejbs.InstructorHasTrimestreFacade ejbFacade;
    private List<InstructorHasTrimestre> items = null;
    private InstructorHasTrimestre selected;

    public InstructorHasTrimestreController() {
    }

    public InstructorHasTrimestre getSelected() {
        return selected;
    }

    public void setSelected(InstructorHasTrimestre selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getInstructorHasTrimestrePK().setJornada(selected.getTrimestre().getTrimestrePK().getJornadaNombre());
        selected.getInstructorHasTrimestrePK().setNumeroDocumento(selected.getInstructorFicha().getInstructorFichaPK().getNumeroDocumento());
        selected.getInstructorHasTrimestrePK().setIdTrimestre(selected.getTrimestre().getTrimestrePK().getIdTrimestre());
        selected.getInstructorHasTrimestrePK().setTipoInstructor(selected.getTipoInstructor1().getModalidad());
        selected.getInstructorHasTrimestrePK().setFicha(selected.getInstructorFicha().getInstructorFichaPK().getFicha());
        selected.getInstructorHasTrimestrePK().setTipoDocumento(selected.getInstructorFicha().getInstructorFichaPK().getTipoDocumento());
    }

    protected void initializeEmbeddableKey() {
        selected.setInstructorHasTrimestrePK(new co.edu.sena.ejemplotemplates.model.entities.InstructorHasTrimestrePK());
    }

    private InstructorHasTrimestreFacade getFacade() {
        return ejbFacade;
    }

    public InstructorHasTrimestre prepareCreate() {
        selected = new InstructorHasTrimestre();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InstructorHasTrimestreCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InstructorHasTrimestreUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InstructorHasTrimestreDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<InstructorHasTrimestre> getItems() {
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

    public InstructorHasTrimestre getInstructorHasTrimestre(co.edu.sena.ejemplotemplates.model.entities.InstructorHasTrimestrePK id) {
        return getFacade().find(id);
    }

    public List<InstructorHasTrimestre> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<InstructorHasTrimestre> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = InstructorHasTrimestre.class)
    public static class InstructorHasTrimestreControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InstructorHasTrimestreController controller = (InstructorHasTrimestreController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "instructorHasTrimestreController");
            return controller.getInstructorHasTrimestre(getKey(value));
        }

        co.edu.sena.ejemplotemplates.model.entities.InstructorHasTrimestrePK getKey(String value) {
            co.edu.sena.ejemplotemplates.model.entities.InstructorHasTrimestrePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.ejemplotemplates.model.entities.InstructorHasTrimestrePK();
            key.setTipoDocumento(values[0]);
            key.setNumeroDocumento(values[1]);
            key.setFicha(values[2]);
            key.setIdTrimestre(values[3]);
            key.setJornada(values[4]);
            key.setTipoInstructor(values[5]);
            return key;
        }

        String getStringKey(co.edu.sena.ejemplotemplates.model.entities.InstructorHasTrimestrePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getNumeroDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getFicha());
            sb.append(SEPARATOR);
            sb.append(value.getIdTrimestre());
            sb.append(SEPARATOR);
            sb.append(value.getJornada());
            sb.append(SEPARATOR);
            sb.append(value.getTipoInstructor());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof InstructorHasTrimestre) {
                InstructorHasTrimestre o = (InstructorHasTrimestre) object;
                return getStringKey(o.getInstructorHasTrimestrePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InstructorHasTrimestre.class.getName()});
                return null;
            }
        }

    }

}
