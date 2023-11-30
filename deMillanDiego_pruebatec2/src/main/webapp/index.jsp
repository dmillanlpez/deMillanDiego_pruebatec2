
<%@ include file="header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.demillandiego_pruebatec2.logica.Turno"%>
<%@page import="com.mycompany.demillandiego_pruebatec2.logica.Controladora"%>
<%@page import="com.mycompany.demillandiego_pruebatec2.logica.Ciudadano"%>
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
         <!-- Agregar Ciudadano Form -->
         <section class="form-section">
            <h2 class="titulo">Agregar Ciudadano</h2>
            <form action="CiudadanoSV" method="post" class="form">
               <!-- Name Field -->
               <div class="form-group">
                  <label for="nombre">Nombre:</label>
                  <input type="text" id="nombre" name="nombre" class="form-control" required>
               </div>
               <!-- Surname Field -->
               <div class="form-group">
                  <label for="apellidos">Apellidos:</label>
                  <input type="text" id="apellidos" name="apellidos" class="form-control" required>
               </div>
               <!-- DNI Field -->
               <div class="form-group">
                  <label for="dni">DNI:</label>
                  <input type="text" id="dni" name="dni" class="form-control" required>
               </div>
               <!-- Phone Field -->
               <div class="form-group">
                  <label for="telefono">Teléfono:</label>
                  <input type="text" id="telefono" name="telefono" class="form-control" required pattern="^[0-9]{9}$">
               </div>
               <!-- Submit Button -->
               <button type="submit" class="btn">Agregar</button>
            </form>
         </section>
         <!-- Buscar Ciudadano Form -->
         <section class="form-section">
            <h2 class="titulo">Buscar Ciudadano por ID</h2>
            <form action="CiudadanoSV" method="get" class="form">
               <div class="form-group">
                  <label>ID del Ciudadano:</label>
                  <input type="text" name="id-ciudadano" class="form-control" required>
               </div>
               <button type="submit" class="btn">Buscar</button>
            </form>
         </section>
         <!-- Ciudadano Details Section -->
         <section class="details-section">
            <% 
               Ciudadano ciudadano = (Ciudadano) request.getAttribute("ciudadano");
               String error = (String) request.getAttribute("error");
               if (ciudadano != null) {
               %>
            <h2 class="form-title">Detalles del Ciudadano</h2>
            <table class="table">
               <thead>
                  <tr>
                     <th>ID</th>
                     <th>Nombre</th>
                     <th>Apellidos</th>
                     <th>DNI</th>
                     <th>Teléfono</th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td><%= ciudadano.getId() %></td>
                     <td><%= ciudadano.getNombre() %></td>
                     <td><%= ciudadano.getApellidos() %></td>
                     <td><%= ciudadano.getDni() %></td>
                     <td><%= ciudadano.getTelefono() %></td>
                  </tr>
               </tbody>
            </table>
            <% 
               } else {
                   if (error != null) {
               %>
            <div class="error-message">
               Error: <%= error %>
            </div>
            <% 
               } else {
               %>
            <div class="info-message">
               No se encontró el ciudadano. Por favor, intente con otro ID.
            </div>
            <% 
               }
               }
               %>
         </section>
      </main>
   </body>
</html>