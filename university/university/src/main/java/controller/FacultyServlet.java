package controller;

import dao.*;
import domain.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.IOException;

@WebServlet("/faculty")
public class FacultyServlet extends HttpServlet {

    private FacultyDAO dao = new FacultyDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("faculties", dao.findAll());
            req.getRequestDispatcher("/views/faculty.jsp").forward(req, resp);
            return;
        }

        if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));

            req.setAttribute("faculty", dao.findById(id));
            req.getRequestDispatcher("/views/editfaculty.jsp").forward(req, resp);
        }

        if (action.equals("delete")) {
            dao.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("faculty");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("update".equals(action)) {
            dao.update(new Faculty(
                    Integer.parseInt(req.getParameter("id")),
                    req.getParameter("nameFaculty"),
                    req.getParameter("shortNameFaculty")
            ));
        } else {
            dao.insert(new Faculty(
                    req.getParameter("nameFaculty"),
                    req.getParameter("shortNameFaculty")
            ));
        }

        resp.sendRedirect("faculty");
    }
}