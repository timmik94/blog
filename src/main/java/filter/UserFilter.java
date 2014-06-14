package filter;

import Hibernateclasses.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by timur on 14.06.2014.
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest &&
                servletResponse instanceof HttpServletResponse) {
            HttpSession session=((HttpServletRequest) servletRequest).getSession();
            User user = (User) session.getAttribute("user");
            if(user==null){((HttpServletResponse) servletResponse).sendRedirect("../login.jsp");}

        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
