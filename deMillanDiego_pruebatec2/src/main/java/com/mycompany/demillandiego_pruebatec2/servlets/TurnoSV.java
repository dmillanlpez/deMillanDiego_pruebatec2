/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.demillandiego_pruebatec2.servlets;

import com.mycompany.demillandiego_pruebatec2.logica.Ciudadano;
import com.mycompany.demillandiego_pruebatec2.logica.Controladora;
import com.mycompany.demillandiego_pruebatec2.logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "TurnoSV", urlPatterns = {"/TurnoSV"}) // Define la ruta
public class TurnoSV extends HttpServlet {
    
    private List<Turno> listadoTurno = new ArrayList<>();
    
    private Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TurnoSV</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TurnoSV at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   /**
     * Maneja la solicitud GET para filtrar los turnos por fecha.
     * Si se proporciona una fecha valida, se van recuperan los turnos correspondientes a esa fecha.
     * En caso de no recibir una fecha válida, se redirige a una pagina de error o inicio.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    List<Turno> resultado = new ArrayList<>();

    String fechaParam = request.getParameter("filtro-fecha");

    if (fechaParam != null && !fechaParam.isEmpty()) {
        LocalDate fecha = LocalDate.parse(fechaParam);
        resultado = control.buscarTurnoPorFecha(fecha);
    } else {
        // Si no se proporciona una fecha, redirige a una página o muestra un mensaje de error
        request.setAttribute("error", "Debe proporcionar una fecha para filtrar los turnos.");
        request.getRequestDispatcher("rutaAlJSPErrorOInicio.jsp").forward(request, response);
        return;
    }

    request.setAttribute("resultadosTurnos", resultado);
    request.getRequestDispatcher("filtrarTurno.jsp").forward(request, response);
}

   /**
     * Maneja la solicitud POST para crear o modificar turnos.
     * Si no se proporciona un ID de turno, se crea un nuevo turno con todos los datos proporcionados.
     * Si se proporciona un ID de turno, se busca y se va a actualizar el turno correspondiente.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    String stringId = request.getParameter("id-turno");

    Turno turno = new Turno();

    if (stringId == null) {
        Long idCiudadano = Long.valueOf(request.getParameter("id-ciudadano"));
        turno.setDescripcionTram(request.getParameter("descripcionTram"));
        turno.setEstado(request.getParameter("estado"));
        turno.setFechaTurno(LocalDate.parse(request.getParameter("fechaTurno")));
        turno.setCiudadano(control.busquedaCiudadano(idCiudadano));

        control.crearTurno(turno);

    }else{
        turno = control.buscarTurno(Long.valueOf(stringId));
        String actualizarEstado = request.getParameter("cambio-estado");
        
        if(actualizarEstado != null){
            turno.setEstado(request.getParameter("cambio-estado"));
            control.modificarTurno(turno);
        }else{
            System.out.println("No se ha modificado");
        }
        
        response.sendRedirect("filtrarTurno.jsp");
    }
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
