package Control;

import Entity.Horarioxgrupoteorico;
import Control.util.JsfUtil;
import Control.util.JsfUtil.PersistAction;
import Model.HorarioxgrupoteoricoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "horarioxgrupoteoricoController")
@SessionScoped
public class HorarioxgrupoteoricoController implements Serializable {

    @EJB
    private Model.HorarioxgrupoteoricoFacade ejbFacade;
    private List<Horarioxgrupoteorico> items = null;
    private Horarioxgrupoteorico selected;

    public HorarioxgrupoteoricoController() {
    }

    public Horarioxgrupoteorico getSelected() {
        return selected;
    }

    public void setSelected(Horarioxgrupoteorico selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private HorarioxgrupoteoricoFacade getFacade() {
        return ejbFacade;
    }

    public Horarioxgrupoteorico prepareCreate() {
        selected = new Horarioxgrupoteorico();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("HorarioxgrupoteoricoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("HorarioxgrupoteoricoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("HorarioxgrupoteoricoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Horarioxgrupoteorico> getItems() {
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

    public List<Horarioxgrupoteorico> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Horarioxgrupoteorico> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Horarioxgrupoteorico.class)
    public static class HorarioxgrupoteoricoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HorarioxgrupoteoricoController controller = (HorarioxgrupoteoricoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "horarioxgrupoteoricoController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Horarioxgrupoteorico) {
                Horarioxgrupoteorico o = (Horarioxgrupoteorico) object;
                return getStringKey(o.getIdHorarioXhorario());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Horarioxgrupoteorico.class.getName()});
                return null;
            }
        }

    }

}
