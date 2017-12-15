package co.edu.sena.a;

import co.edu.sena.mavenproject3.ObservacionItem;
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

@Named("observacionItemController")
@SessionScoped
public class ObservacionItemController implements Serializable {

    @EJB
    private co.edu.sena.a.ObservacionItemFacade ejbFacade;
    private List<ObservacionItem> items = null;
    private ObservacionItem selected;

    public ObservacionItemController() {
    }

    public ObservacionItem getSelected() {
        return selected;
    }

    public void setSelected(ObservacionItem selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getObservacionItemPK().setGrupoCodigo(selected.getRespuestaGrupo().getRespuestaGrupoPK().getGrupoCodigo());
        selected.getObservacionItemPK().setNumeroFicha(selected.getRespuestaGrupo().getRespuestaGrupoPK().getFicha());
        selected.getObservacionItemPK().setIdItem(selected.getRespuestaGrupo().getRespuestaGrupoPK().getIdItem());
        selected.getObservacionItemPK().setListaChequeo(selected.getRespuestaGrupo().getRespuestaGrupoPK().getListaChequeo());
    }

    protected void initializeEmbeddableKey() {
        selected.setObservacionItemPK(new co.edu.sena.mavenproject3.ObservacionItemPK());
    }

    private ObservacionItemFacade getFacade() {
        return ejbFacade;
    }

    public ObservacionItem prepareCreate() {
        selected = new ObservacionItem();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ObservacionItemCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ObservacionItemUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ObservacionItemDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ObservacionItem> getItems() {
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

    public ObservacionItem getObservacionItem(co.edu.sena.mavenproject3.ObservacionItemPK id) {
        return getFacade().find(id);
    }

    public List<ObservacionItem> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ObservacionItem> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ObservacionItem.class)
    public static class ObservacionItemControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ObservacionItemController controller = (ObservacionItemController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "observacionItemController");
            return controller.getObservacionItem(getKey(value));
        }

        co.edu.sena.mavenproject3.ObservacionItemPK getKey(String value) {
            co.edu.sena.mavenproject3.ObservacionItemPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.mavenproject3.ObservacionItemPK();
            key.setIdObservacion(Integer.parseInt(values[0]));
            key.setNumeroFicha(values[1]);
            key.setGrupoCodigo(Integer.parseInt(values[2]));
            key.setListaChequeo(values[3]);
            key.setIdItem(Integer.parseInt(values[4]));
            return key;
        }

        String getStringKey(co.edu.sena.mavenproject3.ObservacionItemPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdObservacion());
            sb.append(SEPARATOR);
            sb.append(value.getNumeroFicha());
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
            if (object instanceof ObservacionItem) {
                ObservacionItem o = (ObservacionItem) object;
                return getStringKey(o.getObservacionItemPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ObservacionItem.class.getName()});
                return null;
            }
        }

    }

}
