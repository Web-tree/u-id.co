package co.uid.utils.filter;

import org.springframework.web.util.HtmlUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * User: maxim.levicky
 * Date: 4/15/13
 * Time: 5:39 PM
 */
public class CrossScriptingFilter implements Filter {
    private FilterConfig filterConfig;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
    }

    class RequestWrapper extends HttpServletRequestWrapper {
        public RequestWrapper(HttpServletRequest servletRequest) {
            super(servletRequest);
        }
        public String[] getParameterValues(String parameter) {
            String[] values = super.getParameterValues(parameter);
            if (values==null)  {
                return null;
            }
            int count = values.length;
            String[] encodedValues = new String[count];
            for (int i = 0; i < count; i++) {
                encodedValues[i] = cleanXSS(values[i]);
            }
            return encodedValues;
        }
        public String getParameter(String parameter) {
            String value = super.getParameter(parameter);
            if (value == null) {
                return null;
            }
            return cleanXSS(value);
        }
        public String getHeader(String name) {
            String value = super.getHeader(name);
            if (value == null)
                return null;
            return cleanXSS(value);
        }
        private String cleanXSS(String value) {
            return HtmlUtils.htmlEscape(value);
        }
    }
}
