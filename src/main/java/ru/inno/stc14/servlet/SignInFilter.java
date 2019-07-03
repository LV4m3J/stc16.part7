package ru.inno.stc14.servlet;


import ru.inno.stc14.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class SignInFilter implements Filter {
    private Logger logger = Logger.getLogger(LogFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.warning("initialize loginFilter");
    }

    /**
     * фильтр не мой честно скажу, нашел где то в интернете не помню где уже
     * пробовал сой сделать что то как то не получилось.
     * Проверка логина пользователя
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        final HttpSession session = request.getSession();//false
        String loginURI = request.getContextPath() + "/signin";

        boolean loggedIn;
        if(session!=null && session.getAttribute("user")!=null){
            loggedIn = true;
        } else {
            loggedIn = false;
        }

        boolean loginRequest = request.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        logger.warning("destroy loginFilter");
    }
}
