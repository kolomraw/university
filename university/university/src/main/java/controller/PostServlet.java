package controller;

import dao.*;
import domain.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.IOException;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    private PostDAO dao = new PostDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            req.setAttribute("posts", dao.findAll());
            req.getRequestDispatcher("/views/post.jsp").forward(req, resp);
            return;
        }

        if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));

            req.setAttribute("post", dao.findById(id));
            req.getRequestDispatcher("/views/editpost.jsp").forward(req, resp);
        }

        if (action.equals("delete")) {
            dao.delete(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("post");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String action = req.getParameter("action");

        if ("update".equals(action)) {
            dao.update(new Post(
                    Integer.parseInt(req.getParameter("id")),
                    req.getParameter("namePost")
            ));
        } else {
            dao.insert(new Post(
                    req.getParameter("namePost")
            ));
        }

        resp.sendRedirect("post");
    }
}