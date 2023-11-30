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


@WebServlet(name = "CiudadanoSV", urlPatterns = {"/CiudadanoSV"})
public class CiudadanoSV extends HttpServlet {
    
    // Lista para almacenar objetos de tipo Ciudadano.
    private List<Ciudadano> listaCiudadano = new ArrayList<>();
    
    private Controladora control = new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
    
     /**
     * Maneja la solicitud POST para agregar un nuevo ciudadano.
     * Este método recoge los datos de un formulario, validando que los campos no esten vacios y que el telefono tenga el formato correcto.
     * 
     * - Si los datos son validos:
     *   - Se crea un nuevo objeto 'Ciudadano' y se establecen sus atributos con los valores recogidos del formulario.
     *   - Luego, se llama al metodo 'crearCiudadano' de la clase 'Controladora' para guardar el nuevo ciudadano en la base de datos.
     *   - Finalmente, se redirige al usuario al 'index.jsp'.
     * 
     * - Si los datos no son validos o faltan los requeridos para la inserccion:
     *   - Se establece un atributo de error en la solicitud y se podría redirigir a una página de error o mostrar un mensaje en la misma página.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        
        // Hacer regex para el dni? 
        if(!nombre.isEmpty() && !apellidos.isEmpty() && !dni.isEmpty() && telefono.matches("^[0-9]{9}$")){
            
            Ciudadano ciudadano = new Ciudadano();
            
            ciudadano.setNombre(nombre);
            ciudadano.setApellidos(apellidos);
            ciudadano.setDni(dni);
            ciudadano.setTelefono(telefono);
            
            control.crearCiudadano(ciudadano);
            
            response.sendRedirect("index.jsp");

        }else {
        request.setAttribute("error", "Los datos son invalidos. Por favor, intentalo de nuevo.");
        
    }
}
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
