package co.uid.utils.filter;

import co.uid.system.Log;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * User: maxim.levicky
 * Date: 6/25/13
 * Time: 12:39 PM
 */
public class ErrorFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            Log.getLogger(ErrorFilter.class).error("Not catcher error.", t);
            String xRequest = ((HttpServletRequest)request).getHeader("x-requested-with");
            if (xRequest != null && xRequest.equals("XMLHttpRequest")) {
                request.getRequestDispatcher("/WEB-INF/views/error/jsonErrorPage.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/error/generalError.jsp").forward(request, response);
            }
        }
    }

}
