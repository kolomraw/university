package controller;

import dao.*;
import domain.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.IOException;

@WebServlet("/chair")
public class ChairServlet extends HttpServlet {

    private ChairDAO chairDAO = new ChairDAO();
    private FacultyDAO facultyDAO = new FacultyDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("chairs", chairDAO.findAll());
            req.setAttribute("faculties", facultyDAO.findAll());
            req.getRequestDispatcher("/views/chair.jsp").forward(req, resp);
            return;
        }

        if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));

            req.setAttribute("chair", chairDAO.findById(id));
            req.setAttribute("faculties", facultyDAO.findAll());

            req.getRequestDispatcher("/views/editchair.jsp").forward(req, resp);
            return;
        }

        if ("delete".equals(action)) {
            chairDAO.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("chair");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("update".equals(action)) {
            chairDAO.update(new Chair(
                    Integer.parseInt(req.getParameter("id")),
                    Integer.parseInt(req.getParameter("idFaculty")),
                    req.getParameter("nameChair"),
                    req.getParameter("shortNameChair")
            ));
        } else {
            chairDAO.insert(new Chair(
                    Integer.parseInt(req.getParameter("idFaculty")),
                    req.getParameter("nameChair"),
                    req.getParameter("shortNameChair")
            ));
        }

        resp.sendRedirect("chair");
    }
}