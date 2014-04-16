package co.uid.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Maxim Levicky
 *         created 16.04.2014
 */
public class FaceRequest {
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static String getParam(String paramName) {
        return getParam(paramName, null);
    }

    public static String getParam(String paramName, String defaultValue) {
        String paramValue = getRequest().getParameter(paramName);
        return paramValue == null ? defaultValue : paramName;
    }
}
