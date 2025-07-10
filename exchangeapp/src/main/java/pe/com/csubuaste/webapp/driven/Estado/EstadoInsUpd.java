package pe.com.csubuaste.webapp.driven.Estado;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.com.csubuaste.webapp.domain.data.entity.Estado;
import pe.com.csubuaste.webapp.domain.useCase.parser.Estado.EstadoCRUD;

import java.io.IOException;
import java.util.Date;

@WebServlet("/EstadoInsUpd")
public class EstadoInsUpd extends HttpServlet {
    private EstadoCRUD srv = new EstadoCRUD();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("action");
        if (accion.trim().toLowerCase().equals("eliminar")) {
            srv.eliminar(Long.parseLong(req.getParameter("id")), false);
            resp.sendRedirect("index.jsp");
            return;
        }
        Estado est = new Estado();
        est.setIdEstado(Integer.parseInt(req.getParameter("id")));
        est.setDescripcion(req.getParameter("desc"));
        est.setEstado(Boolean.parseBoolean(req.getParameter("estado")));

        req.setAttribute("estado", est);
        req.setAttribute("contenido", "/WEB-INF/Estado/EstadoInsUpd.jsp");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/layout/base.jsp");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("idEstado");
        String descripcion = req.getParameter("desc");
        boolean activo = req.getParameter("estado") != null;

        if (descripcion == null || descripcion.trim().isEmpty()) {
            Estado estado = new Estado();
            estado.setIdEstado(idParam != null && !idParam.isEmpty() ? Integer.parseInt(idParam) : 0);
            estado.setDescripcion(descripcion);
            estado.setEstado(activo);

            req.setAttribute("estado", estado);
            req.setAttribute("error", "La descripción es obligatoria.");

            req.setAttribute("contenido", "/WEB-INF/Estado/EstadoInsUpd.jsp");
            req.getRequestDispatcher("/WEB-INF/jsp/layout/base.jsp").forward(req, resp);
            return;
        }

        Estado estado = new Estado();
        estado.setDescripcion(descripcion);
        estado.setEstado(activo);

        Date ahora = new Date();
        estado.setFechaCreacion(ahora);
        estado.setFechaActualizacion(ahora);

        // Insertar o actualizar según venga ID
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            estado.setIdEstado(id);
        } else {
            estado.setIdEstado(0);
        }

        srv.guardar(estado);

        //req.setAttribute("contenido", "/WEB-INF/Estado/Estado.jsp");

        resp.sendRedirect("index.jsp");
    }
}
