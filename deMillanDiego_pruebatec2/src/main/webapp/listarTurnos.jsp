<%-- 
   Document   : listarTurnos
   Created on : Nov 30, 2023, 1:08:58 AM
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
      <title>Gestion de turnos</title>
      <link href="css/styles.css" rel="stylesheet" />
   </head>
   <body>
      <main class="main-container">
         <section class="form-section">
            <h1 class="titulo">Listado de todos los Turnos</h1>
            <div class="btn-container">
               <a href="ListarTurnos" class="btnList">Cargar Todos los Turnos</a>
            </div>
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
                  </tr>
                  <% 
                     }
                     } else {
                     %>
                  <tr>
                     <td colspan="5">No hay turnos para mostrar</td>
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