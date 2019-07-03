package ru.inno.stc14.servlet;

import ru.inno.stc14.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;


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
            req.getRequestDispatcher("/signin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("login");
        String password = req.getParameter("password");

        Map<String, String> messages = new HashMap<>();
        resp.setContentType("text/html");

        if (username == null || username.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if(messages.isEmpty()){
            if(userService.checkUser(username,password)) {
                req.getSession().setAttribute("user",username);
                resp.sendRedirect(req.getContextPath() + "/");
            } else {
                messages.put("login","Unknown login, try again!");
                req.setAttribute("messages",messages);
                //req.getRequestDispatcher("/signin").forward(req,resp); //stack over flow
            }
        }
    }

}
