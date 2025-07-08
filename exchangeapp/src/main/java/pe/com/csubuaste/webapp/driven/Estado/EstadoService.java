package pe.com.csubuaste.webapp.driven.Estado;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.com.csubuaste.webapp.domain.data.entity.Estado;
import pe.com.csubuaste.webapp.domain.useCase.parser.Estado.EstadoCRUD;

import java.io.IOException;
import java.util.List;

@WebServlet({"/Estado"})
public class EstadoService extends HttpServlet {
    private EstadoCRUD srv = new EstadoCRUD();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Estado> estados = srv.listar();
        req.setAttribute("estados",estados);
        req.setAttribute("contenido", "/WEB-INF/Estado/Estado.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/layout/base.jsp");
        dispatcher.forward(req, resp);
    }
}
