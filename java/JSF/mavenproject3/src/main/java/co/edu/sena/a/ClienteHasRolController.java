package co.edu.sena.a;

import co.edu.sena.mavenproject3.ClienteHasRol;
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

@Named("clienteHasRolController")
@SessionScoped
public class ClienteHasRolController implements Serializable {

    @EJB
    private co.edu.sena.a.ClienteHasRolFacade ejbFacade;
    private List<ClienteHasRol> items = null;
    private ClienteHasRol selected;

    public ClienteHasRolController() {
    }

    public ClienteHasRol getSelected() {
        return selected;
    }

    public void setSelected(ClienteHasRol selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getClienteHasRolPK().setNumeroDocumento(selected.getCliente().getClientePK().getNumeroDocumento());
        selected.getClienteHasRolPK().setTipoDocumento(selected.getCliente().getClientePK().getTipoDocumento());
        selected.getClienteHasRolPK().setRol(selected.getRol1().getIdRol());
    }

    protected void initializeEmbeddableKey() {
        selected.setClienteHasRolPK(new co.edu.sena.mavenproject3.ClienteHasRolPK());
    }

    private ClienteHasRolFacade getFacade() {
        return ejbFacade;
    }

    public ClienteHasRol prepareCreate() {
        selected = new ClienteHasRol();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ClienteHasRolCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ClienteHasRolUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ClienteHasRolDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ClienteHasRol> getItems() {
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

    public ClienteHasRol getClienteHasRol(co.edu.sena.mavenproject3.ClienteHasRolPK id) {
        return getFacade().find(id);
    }

    public List<ClienteHasRol> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ClienteHasRol> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ClienteHasRol.class)
    public static class ClienteHasRolControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClienteHasRolController controller = (ClienteHasRolController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clienteHasRolController");
            return controller.getClienteHasRol(getKey(value));
        }

        co.edu.sena.mavenproject3.ClienteHasRolPK getKey(String value) {
            co.edu.sena.mavenproject3.ClienteHasRolPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new co.edu.sena.mavenproject3.ClienteHasRolPK();
            key.setTipoDocumento(values[0]);
            key.setNumeroDocumento(values[1]);
            key.setRol(values[2]);
            return key;
        }

        String getStringKey(co.edu.sena.mavenproject3.ClienteHasRolPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getNumeroDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getRol());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ClienteHasRol) {
                ClienteHasRol o = (ClienteHasRol) object;
                return getStringKey(o.getClienteHasRolPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ClienteHasRol.class.getName()});
                return null;
            }
        }

    }

}
