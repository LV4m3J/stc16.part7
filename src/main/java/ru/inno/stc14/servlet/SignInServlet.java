package ru.inno.stc14.servlet;

import ru.inno.stc14.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "signin",urlPatterns = "/signin", loadOnStartup = 1)
public class SignInServlet extends HttpServlet {
    private UserServiceImpl userService;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        userService = new UserServiceImpl(connection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.getServletContext().getRequestDispatcher("/signin.jsp").forward(req,resp);
        return; // если убираю бывает переполнение стека
    }

    /**
     * Резульат проверки формы, перенаправляет на форму логина
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("login");
        Integer password = req.getParameter("password").hashCode();

        if(userService.checkUser(username,password)){
            req.getSession().setAttribute("user", username);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            this.getServletContext().getRequestDispatcher("/signin.jsp").forward(req,resp);
        }

    }
}
