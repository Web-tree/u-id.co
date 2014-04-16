package co.uid.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Maxim Levicky
 *         created 16.04.2014
 */
public class FaceContext {
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static String getRequestParam(String paramName) {
        return getRequestParam(paramName, null);
    }

    public static String getRequestParam(String paramName, String defaultValue) {
        String paramValue = getRequest().getParameter(paramName);
        return paramValue == null ? defaultValue : paramName;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getSessionObject(Class<T> tClass, String name) {
        return (T) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get(name);
    }
}
