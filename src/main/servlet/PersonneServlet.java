package src.main.servlet;


import src.main.Model.Personne;
import src.main.Repository.PersonneRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/personne")
public class PersonneServlet extends HttpServlet {

    private PersonneRepository personneRepository;

    public PersonneServlet() {
        this.personneRepository = new PersonneRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = (req.getParameter("action") == null) ? "list" :req.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action){
            case "add":
                dispatcher = req.getRequestDispatcher("add.jsp");
                dispatcher.forward(req,resp);
                break;
            case "delete":
                try {
                    personneRepository.delete(Integer.parseInt(req.getParameter("id")));
                    resp.sendRedirect("?action=list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "list":
                try {
                    List<Personne> personnes = personneRepository.getAll();
                    req.setAttribute("personnes",personnes);
                    dispatcher = req.getRequestDispatcher("index.jsp");
                    dispatcher.forward(req,resp);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = (req.getParameter("action") == null) ? "list" :req.getParameter("action");
        RequestDispatcher dispatcher;
        switch (action) {
            case "save":
                try {
                    personneRepository.add(
                            Personne.builder()
                                    .nom(req.getParameter("nom"))
                                    .prenom(req.getParameter("prenom"))
                                    .age(Integer.parseInt(req.getParameter("age")))
                                    .build()
                    );
                   resp.sendRedirect("?action=list");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
