/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.demillandiego_pruebatec2.servlets;

import com.mycompany.demillandiego_pruebatec2.logica.Ciudadano;
import com.mycompany.demillandiego_pruebatec2.logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "CiudadanoSV", urlPatterns = {"/CiudadanoSV"})
public class CiudadanoSV extends HttpServlet {
    
    // Lista para almacenar objetos de tipo Ciudadano.
    private List<Ciudadano> listaCiudadano = new ArrayList<>();
    private Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CiudadanoSV</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CiudadanoSV at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /*
     * Maneja la solicitud GET para buscar un ciudadano por ID.
     * Si se encuentra el ID, se establece el ciudadano correspondiente como atributo del request.
     * En caso de error en el formato del ID, se establece un mensaje de error.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id-ciudadano");
        if (idStr != null && !idStr.isEmpty()) {
            try {
                Long id = Long.parseLong(idStr);
                Ciudadano ciudadano = control.busquedaCiudadano(id);
                request.setAttribute("ciudadano", ciudadano);
            } catch (NumberFormatException e) {
                // Manejar el error si el ID no es un número válido
                request.setAttribute("error", "El formato del ID no valido.");
            }
        }

        // Reenviar a la página JSP para mostrar la información
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
      
 }
    
    /*
     * Maneja la solicitud POST para agregar un nuevo ciudadano.
     * Valida los campos del formulario y, si son correctos, crea y almacena un nuevo objeto Ciudadano.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        
        // Valido los datos en caso de que esten vacios y si todo es correcto se crea un objeto (explicacion linea 78)
        if(!nombre.isEmpty() && !apellidos.isEmpty() && !dni.isEmpty() && telefono.matches("^[0-9]{9}$")){
            
            Ciudadano ciudadano = new Ciudadano();
            
            ciudadano.setNombre(nombre);
            ciudadano.setApellidos(apellidos);
            ciudadano.setDni(dni);
            ciudadano.setTelefono(telefono);
            
            control.crearCiudadano(ciudadano);
        }
        
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
