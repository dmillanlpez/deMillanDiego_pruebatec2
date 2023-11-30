package com.mycompany.demillandiego_pruebatec2.servlets;

import com.mycompany.demillandiego_pruebatec2.logica.Controladora;
import com.mycompany.demillandiego_pruebatec2.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarTurnosSV", urlPatterns = {"/ListarTurnosSV"})
public class ListarTurnosSV extends HttpServlet {
    
    private Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarTurnos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarTurnos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
  
     /**
     Este metodo gestiona las solicitudes GET enviadas al servlet. Su funcion es recuperar todos los turnos almacenados en la base de datos y 
     enviarlos al jsp correspondiente.
     * El metodo primero invoca a la f(x) listarTurnos() para obtener una lista de todos los turnos existentes. Luego, establece esta lista 
     * de turnos como un atributo en el objeto request bajo la clave "resultadoTurnos".
     *Por ultimo, redirige la solicitud y la respuesta al jsp llamado listarTurnos.jsp donde los datos estaran disponibles para que sean mostrados 
     * al usuar.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         List<Turno> todosLosTurnos = control.listarTurnos();

        request.setAttribute("resultadosTurnos", todosLosTurnos);
        request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
