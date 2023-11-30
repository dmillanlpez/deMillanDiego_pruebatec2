<%-- 
    Document   : filtrarTurno
    Created on : Nov 30, 2023, 12:14:00 AM
    Author     : diego
--%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.demillandiego_pruebatec2.logica.Turno"%>
<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test</title>
        <link href="css/styles.css" rel="stylesheet" />

    </head>
  <body>
    <main class="main-container">
        <section class="form-section">
            <h2 class="form-title">Filtrar Turnos por Fecha</h2>
            <form action="TurnoSV" method="get" class="form">
                <div class="form-group">
                    <label for="filtro-fecha">Fecha:</label>
                    <input type="date" id="filtro-fecha" name="filtro-fecha" class="form-control" required>
                </div>
                <button type="submit" class="btn">Filtrar</button>
            </form>
        </section>

        <section class="table-section">
            <h2 class="form-title">Resultados de Turnos</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID Turno</th>
                        <th>ID Ciudadano</th>
                        <th>Descripción</th>
                        <th>Fecha</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Turno> resultadosTurnos = (List<Turno>) request.getAttribute("resultadosTurnos");
                        if (resultadosTurnos != null && !resultadosTurnos.isEmpty()) {
                            for (Turno turno : resultadosTurnos) {
                    %>
                        <tr>
                            <td><%= turno.getId() %></td>
                            <td><%= turno.getCiudadano().getId() %></td>
                            <td><%= turno.getDescripcionTram() %></td>
                            <td><%= turno.getFechaTurno() %></td>
                            <td><%= turno.getEstado() %></td>
                            <td>
                                <form action="TurnoSV" method="post">
                                    <input type="hidden" name="id-turno" value="<%= turno.getId() %>">
                                    <select name="cambio-estado" class="form-control">
                                        <option value="En espera">En espera</option>
                                        <option value="Ya atendido">Ya atendido</option>
                                    </select>
                                    <button type="submit" class="btn btn-small">Actualizar</button>
                                </form>
                            </td>
                        </tr>
                    <% 
                            }
                        } else {
                    %>
                        <tr>
                            <td colspan="6">No hay turnos para mostrar</td>
                        </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
        </section>
    </main>
</body>
</html>
