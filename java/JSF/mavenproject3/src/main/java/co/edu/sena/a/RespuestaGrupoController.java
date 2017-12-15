package co.edu.sena.a;

import co.edu.sena.mavenproject3.RespuestaGrupo;
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

@Named("respuestaGrupoController")
@SessionScoped
public class RespuestaGrupoController implements Serializable {

    @EJB
    private co.edu.sena.a.RespuestaGrupoFacade ejbFacade;
    private List<RespuestaGrupo> items = null;
    private RespuestaGrupo selected;

    public RespuestaGrupoController() {
    }

    public RespuestaGrupo getSelected() {
        return selected;
    }

    public void setSelected(RespuestaGrupo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getRespuestaGrupoPK().setFicha(selected.getGrupoProyecto().getGrupoProyectoPK().getNumeroFicha());
        selected.getRespuestaGrupoPK().setIdItem(selected.getItemChecker().getItemCheckerPK().getIdItem());
        selected.getRespuestaGrupoPK().setListaChequeo(selected.getItemChecker().getItemCheckerPK().getListaChequeo());
        selected.getRespuestaGrupoPK().setGrupoCodigo(selected.getGrupoProyecto().getGrupoProyectoPK().getCodigo());
    }

    protected void initializeEmbeddableKey() {
        selected.setRespuestaGrupoPK(new co.edu.sena.mavenproject3.RespuestaGrupoPK());
    }

    private RespuestaGrupoFacade getFacade() {
        return ejbFacade;
    }

    public RespuestaGrupo prepareCreate() {
        selected = new RespuestaGrupo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RespuestaGrupoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RespuestaGrupoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RespuestaGrupoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<RespuestaGrupo> getItems() {
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

    public RespuestaGrupo getRespuestaGrupo(co.edu.sena.mavenproject3.RespuestaGrupoPK id) {
        return getFacade().find(id);
    }

    public List<RespuestaGrupo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<RespuestaGrupo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = RespuestaGrupo.class)
    public static class RespuestaGrupoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RespuestaGrupoController controller = (RespuestaGrupoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "respuestaGrupoController");
            return controller.getRespuestaGrupo(getKey(value));
        }

        co.edu.sena.mavenproject3.RespuestaGrupoPK getKey(String value) {
            co.edu.sena.mavenproject3.RespuestaGrupoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.mavenproject3.RespuestaGrupoPK();
            key.setFicha(values[0]);
            key.setGrupoCodigo(Integer.parseInt(values[1]));
            key.setListaChequeo(values[2]);
            key.setIdItem(Integer.parseInt(values[3]));
            return key;
        }

        String getStringKey(co.edu.sena.mavenproject3.RespuestaGrupoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getFicha());
            sb.append(SEPARATOR);
            sb.append(value.getGrupoCodigo());
            sb.append(SEPARATOR);
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
            if (object instanceof RespuestaGrupo) {
                RespuestaGrupo o = (RespuestaGrupo) object;
                return getStringKey(o.getRespuestaGrupoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), RespuestaGrupo.class.getName()});
                return null;
            }
        }

    }

}
