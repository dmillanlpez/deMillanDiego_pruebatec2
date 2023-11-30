<%-- 
    Document   : filtradoFechaTurno
    Created on : Nov 30, 2023, 12:52:06 AM
    Author     : diego
--%>

<%@page import="com.mycompany.demillandiego_pruebatec2.logica.Turno"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
    <h1>Listado de Turnos</h1>
    <form action="FiltradoFechaTurno" method="get">
        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" required>
        <label for="estado">Estado:</label>
        <select id="estado" name="estado">
            <option value="">Todos</option>
            <option value="En espera">En espera</option>
            <option value="Ya atendido">Ya atendido</option>
        </select>
        <input type="submit" value="Filtrar">
    </form>

    <% String error = (String) request.getAttribute("error");
       if (error != null && !error.isEmpty()) {
    %>
        <p class="error"><%= error %></p>
    <% } else {
        List<Turno> turnosFiltrados = (List<Turno>) request.getAttribute("turnosFiltrados");
        if (turnosFiltrados != null && !turnosFiltrados.isEmpty()) {
    %>
        <table class="table">
            <thead>
                <tr>
                    <th>ID Turno</th>
                    <th>ID Ciudadano</th>
                    <th>Descripción</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <% for (Turno turno : turnosFiltrados) { %>
                    <tr>
                        <td><%= turno.getId() %></td>
                        <td><%= turno.getCiudadano().getId() %></td>
                        <td><%= turno.getDescripcionTram() %></td>
                        <td><%= turno.getFechaTurno() %></td>
                        <td><%= turno.getEstado() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p>No se encontraron turnos para mostrar.</p>
    <% }
       }
    %>
</body>
</html>
