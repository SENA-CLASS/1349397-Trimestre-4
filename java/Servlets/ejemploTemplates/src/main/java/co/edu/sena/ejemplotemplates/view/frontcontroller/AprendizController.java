package co.edu.sena.ejemplotemplates.view.frontcontroller;

import co.edu.sena.ejemplotemplates.model.entities.Aprendiz;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil;
import co.edu.sena.ejemplotemplates.view.frontcontroller.util.JsfUtil.PersistAction;
import co.edu.sena.ejemplotemplates.controller.ejbs.AprendizFacade;

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

@Named("aprendizController")
@SessionScoped
public class AprendizController implements Serializable {

    @EJB
    private co.edu.sena.ejemplotemplates.controller.ejbs.AprendizFacade ejbFacade;
    private List<Aprendiz> items = null;
    private Aprendiz selected;

    public AprendizController() {
    }

    public Aprendiz getSelected() {
        return selected;
    }

    public void setSelected(Aprendiz selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getAprendizPK().setTipoDocumento(selected.getCliente().getClientePK().getTipoDocumento());
        selected.getAprendizPK().setNumeroDocumento(selected.getCliente().getClientePK().getNumeroDocumento());
        selected.getAprendizPK().setFicha(selected.getGrupoProyecto().getGrupoProyectoPK().getNumeroFicha());
        selected.getAprendizPK().setGrupoCodigo(selected.getGrupoProyecto().getGrupoProyectoPK().getCodigo());
    }

    protected void initializeEmbeddableKey() {
        selected.setAprendizPK(new co.edu.sena.ejemplotemplates.model.entities.AprendizPK());
    }

    private AprendizFacade getFacade() {
        return ejbFacade;
    }

    public Aprendiz prepareCreate() {
        selected = new Aprendiz();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AprendizCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AprendizUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AprendizDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Aprendiz> getItems() {
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

    public Aprendiz getAprendiz(co.edu.sena.ejemplotemplates.model.entities.AprendizPK id) {
        return getFacade().find(id);
    }

    public List<Aprendiz> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Aprendiz> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Aprendiz.class)
    public static class AprendizControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AprendizController controller = (AprendizController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "aprendizController");
            return controller.getAprendiz(getKey(value));
        }

        co.edu.sena.ejemplotemplates.model.entities.AprendizPK getKey(String value) {
            co.edu.sena.ejemplotemplates.model.entities.AprendizPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.ejemplotemplates.model.entities.AprendizPK();
            key.setTipoDocumento(values[0]);
            key.setNumeroDocumento(values[1]);
            key.setFicha(values[2]);
            key.setGrupoCodigo(Integer.parseInt(values[3]));
            return key;
        }

        String getStringKey(co.edu.sena.ejemplotemplates.model.entities.AprendizPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getNumeroDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getFicha());
            sb.append(SEPARATOR);
            sb.append(value.getGrupoCodigo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Aprendiz) {
                Aprendiz o = (Aprendiz) object;
                return getStringKey(o.getAprendizPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Aprendiz.class.getName()});
                return null;
            }
        }

    }

}
