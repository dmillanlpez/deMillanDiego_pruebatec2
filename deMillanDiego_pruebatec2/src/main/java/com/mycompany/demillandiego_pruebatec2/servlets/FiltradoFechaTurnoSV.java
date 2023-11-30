package com.mycompany.demillandiego_pruebatec2.servlets;

import com.mycompany.demillandiego_pruebatec2.logica.Controladora;
import com.mycompany.demillandiego_pruebatec2.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FiltradoFechaTurnoSV", urlPatterns = {"/FiltradoFechaTurnoSV"})
public class FiltradoFechaTurnoSV extends HttpServlet {
    
    private Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FiltradoFechaTurnoSV</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FiltradoFechaTurnoSV at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /*
    * Maneja la solicitud GET para filtrar los turnos por fecha y, opcionalmente, por estado.
    * Si se proporcionan ambos, fecha y estado, se devolverá una lista de turnos que coincidan con ambos criterios.
    * Si solo se proporciona la fecha, se devolverán todos los turnos para esa fecha. (da igual si esta en "En espera" o "Ya atendido"
    * Si no se proporciona fecha, se establece un mensaje de error y se reenvía la solicitud a 'filtradoFechaTurno.jsp' para informar al usuario.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String fechaParam = request.getParameter("fecha");
        String estadoParam = request.getParameter("estado");

        if (fechaParam != null && !fechaParam.isEmpty()) {
            LocalDate fecha = LocalDate.parse(fechaParam);
            List<Turno> turnosFiltrados;

            if (estadoParam != null && !estadoParam.isEmpty()) {
                // Filtra por fecha y estado
                turnosFiltrados = control.buscarTurnosPorFechaYEstado(fecha, estadoParam);
            } else {
                // Solo filtra por fecha
                turnosFiltrados = control.buscarTurnoPorFecha(fecha);
            }

            request.setAttribute("turnosFiltrados", turnosFiltrados);
            request.getRequestDispatcher("filtradoFechaTurno.jsp").forward(request, response);
        } else {
            // Manejar el caso de no proporcionar fecha
            request.setAttribute("error", "Debes proporcionar una fecha para poder filtrar los turnos.");
        }
            request.getRequestDispatcher("filtradoFechaTurno.jsp").forward(request, response);

    }
    
     /**
     * En este caso el doPost no hace nada, esta clase solo existe para el doGet
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

     /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
