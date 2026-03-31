package controller;

import dao.*;
import domain.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.IOException;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {

    private TeacherDAO teacherDAO = new TeacherDAO();
    private ChairDAO chairDAO = new ChairDAO();
    private PostDAO postDAO = new PostDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("teachers", teacherDAO.findAll());
            req.setAttribute("chairs", chairDAO.findAll());
            req.setAttribute("posts", postDAO.findAll());

            req.getRequestDispatcher("/views/teacher.jsp").forward(req, resp);
            return;
        }

        if (action.equals("delete")) {
            teacherDAO.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("teacher");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("update".equals(action)) {
            teacherDAO.update(new Teacher(
                    Integer.parseInt(req.getParameter("id")),
                    Integer.parseInt(req.getParameter("idChair")),
                    Integer.parseInt(req.getParameter("idPost")),
                    req.getParameter("firstName"),
                    req.getParameter("secondName"),
                    req.getParameter("lastName"),
                    req.getParameter("phone"),
                    req.getParameter("email")
            ));
        } else {
            teacherDAO.insert(new Teacher(
                    Integer.parseInt(req.getParameter("idChair")),
                    Integer.parseInt(req.getParameter("idPost")),
                    req.getParameter("firstName"),
                    req.getParameter("secondName"),
                    req.getParameter("lastName"),
                    req.getParameter("phone"),
                    req.getParameter("email")
            ));
        }

        resp.sendRedirect("teacher");
    }
}