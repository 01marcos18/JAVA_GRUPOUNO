<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, pe.com.csubuaste.webapp.domain.data.entity.Estado" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/pages/Estado.css">

    <center><h2>Estados disponibles</h2> <a class="btn btn-primary" type="button" href="EstadoInsUpd?action=crear&id=0&desc=&estado=" >Crear</a></center>
    <div class="responsive-table mt-5">
        <table border="1" class="table table-hover table-secondary table-striped">
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Estado</th>
                <th>Fecha de creación</th>
                <th>Fecha de actualización</th>
                <th></th>
                <th></th>
            </tr>

        <%
            List<Estado> estados = (List<Estado>) request.getAttribute("estados");
            if (estados != null) {
                for (Estado estado : estados) {
        %>
            <tr>
                <td><%= estado.getIdEstado() %></td>
                <td><%= estado.getDescripcion() %></td>
                <td><%= estado.isEstado() %></td>
                <td><%= estado.getFechaCreacion() %></td>
                <td><%= estado.getFechaActualizacion() %></td>
                <td><a class="btn btn-success" type="button" href="EstadoInsUpd?action=editar&id=<%=estado.getIdEstado()%>&desc=<%=estado.getDescripcion()%>&estado=<%=estado.isEstado()%>">Editar</a></td>
                <td><a class="btn btn-danger" type="button" href="EstadoInsUpd?action=eliminar&id=<%=estado.getIdEstado()%>&estado=<%=estado.isEstado()%>">Eliminar</a></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr><td colspan="4">No hay datos disponibles.</td></tr>
        <%
            }
        %>
        </table>
    </div>
