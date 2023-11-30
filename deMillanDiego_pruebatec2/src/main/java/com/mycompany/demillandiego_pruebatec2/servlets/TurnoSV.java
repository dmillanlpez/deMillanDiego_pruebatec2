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

@WebServlet(name = "TurnoSV", urlPatterns = {"/TurnoSV"}) // Define la ruta
public class TurnoSV extends HttpServlet {
    
    private List<Turno> listadoTurno = new ArrayList<>();
    
    private Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
     * Maneja la solicitud GET para filtrar turnos por fecha. 
     * Este metodo recupera el parametro 'filtro-fecha' de la solicitud y, si esta presente y no esta vacio, 
     * parsea la fecha y busca los turnos correspondientes a esa fecha en la base de datos mediante la funcion 'buscarTurnoPorFecha' de la 
     * clase Controladora.
     * Si se encuentra una fecha valida, el metodo recoge los turnos filtrados y los establece como un atributo de la solicitud para ser 
     * utilizados en 'filtrarTurno.jsp'.
     * En caso de que no se proporcione una fecha, se establece un mensaje de error y se redirige al usuario al filtrarTurnos.jsp
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
        request.setAttribute("error", "Debe proporcionar una fecha para filtrar los turnos.");
        request.getRequestDispatcher("listarTurnos.jsp").forward(request, response);
        return;
    }

    request.setAttribute("resultadosTurnos", resultado);
    request.getRequestDispatcher("filtrarTurno.jsp").forward(request, response);
}

       /**
       * Maneja la solicitud POST para crear o actualizar turnos.
       * Este metodo distingue entre dos escenarios principales basados en la presencia del parametro 'id-turno':
       * 
       * 1. Creación de un nuevo turno:
       *    Si 'id-turno' no se proporciona (es null), esto indica la creacion de un nuevo turno.
       *    Se recogen todos los datos necesarios del formulario (id-ciudadano, descripcionTram, estado, fechaTurno),
       *    se crea un nuevo objeto Turno y se rellena con estos datos. Luego, se invoca el metodo 'crearTurno' 
       *    de la clase Controladora para guardar el nuevo turno en la base de datos.
       *    Finalmente, se redirige al usuario a 'agregarTurno.jsp'.
       * 
       * 2. Update de un turno existente:
       *    Si 'id-turno' se proporciona, se busca el turno correspondiente en la base de datos.
       *    Se verifica si se desea actualizar el estado del turno ('cambio-estado'). Si es asi, se actualiza
       *    el estado del turno y luego se invoca el metodo 'modificarTurno' de la clase Controladora para 
       *    actualizar el turno en la base de datos.
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
        response.sendRedirect("agregarTurno.jsp");

    }else{
        turno = control.buscarTurno(Long.valueOf(stringId));
        String actualizarEstado = request.getParameter("cambio-estado");
        
        if(actualizarEstado != null){
            turno.setEstado(request.getParameter("cambio-estado"));
            control.modificarTurno(turno);
            response.sendRedirect("filtrarTurno.jsp");
        }else{
            System.out.println("No se ha modificado");
        }      
    }
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
