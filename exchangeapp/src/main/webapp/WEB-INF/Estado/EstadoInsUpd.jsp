<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pe.com.csubuaste.webapp.domain.data.entity.Estado" %>

<%
    Estado estado = (Estado) request.getAttribute("estado");
%>

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <div class="card shadow rounded">
                <div class="card-header bg-primary text-white text-center">
                    <h5 class="mb-0">
                        <%= estado != null && estado.getIdEstado() > 0 ? "Editar Estado" : "Registrar Estado" %>
                    </h5>
                </div>
                <div class="card-body">
                    <form action="EstadoInsUpd?action=guardar" method="post">

                        <!-- ID oculto -->
                        <input type="hidden" name="idEstado" value="<%= estado != null ? estado.getIdEstado() : "" %>">

                        <!-- Descripción -->
                        <div class="mb-3">
                            <label for="descripcion" class="form-label">Descripción</label>
                            <input type="text" class="form-control" id="descripcion" name="desc"
                                   value="<%= estado != null ? estado.getDescripcion() : "" %>" required>
                            <% String error = (String) request.getAttribute("error"); %>
                            <% if (error != null) { %>
                                <div class="alert alert-danger mt-3 text-center" role="alert">
                                    <%= error %>
                                </div>
                            <% } %>
                        </div>

                        <!-- Estado (activo/inactivo) -->
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" id="estado" name="estado"
                                   <%= estado != null && estado.isEstado() ? "checked" : "" %>>
                            <label class="form-check-label" for="estado">Activo</label>
                        </div>

                        <!-- Botones -->
                        <div class="d-flex justify-content-end gap-2">
                            <a href="EstadoServlet" class="btn btn-secondary">Cancelar</a>
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>