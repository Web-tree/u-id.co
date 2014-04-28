package co.uid.system;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author Maxim Levicky
 *         created 19.04.2014
 */
public class FacesHelper {
    public static void addMessage(String message) {
        getCurrentContext().addMessage(null, new FacesMessage(message));
    }
    public static void addMessageWithRedirect(String message) {
        addMessage(message);
        getCurrentContext().getExternalContext().getFlash().setKeepMessages(true);
    }

    public static FacesContext getCurrentContext() {
        return FacesContext.getCurrentInstance();
    }

    public static void redirect(String url) {
        try {
            getCurrentContext().getExternalContext().redirect(url);
        } catch (IOException e) {
            Log.getLogger(FacesHelper.class).error("Redirect exception.", e);
            throw new Error(e);
        }
    }
}
