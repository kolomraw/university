package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            request.getRequestDispatcher("/views/login.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if ("admin".equals(login) && "123".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", login);

            response.sendRedirect(request.getContextPath() + "/");
        } else {
            response.sendRedirect("login?error=1");
        }
    }
}