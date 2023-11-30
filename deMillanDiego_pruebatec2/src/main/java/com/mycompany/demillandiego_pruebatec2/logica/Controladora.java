
package com.mycompany.demillandiego_pruebatec2.logica;

import com.mycompany.demillandiego_pruebatec2.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    // Creacion de un ciudadano
    public void crearCiudadano(Ciudadano ciudadano){
        
        controlPersis.crearCiudadano(ciudadano);
    }
    
    // Listado de los ciudadanos
    public List<Ciudadano> listarCiudadano(){
        
        return controlPersis.listarCiudadanos();
    }
    
    // Busqueda de un ciudadano por ID
    public Ciudadano busquedaCiudadano(Long id){
        
        return controlPersis.busquedaCiudadano(id);
    }
    
    // Busqueda de un ciudadano por su DNI
    public Optional<Long> busquedaPorDni(String dni) {
        // Obtiene todos los ciudadanos
        List<Ciudadano> todosLosCiudadanos = controlPersis.listarCiudadanos();

        // Filtra los ciudadanos por el DNI especificado
        return todosLosCiudadanos.stream()
                                 .filter(c -> c.getDni().equalsIgnoreCase(dni))
                                 .findFirst()
                                 .map(Ciudadano::getId);
    }
    
    // Eliminar ciudadano
    public void eliminarCiudadano(Long id){
        
        controlPersis.eliminarCiudadano(id);
    }
    
    // Modificacion de un ciudadano
    public void modificarCiudadano(Ciudadano ciudadano){
        
        controlPersis.modificarCiudadano(ciudadano);
    }
    
    
    // ----- CONTROLADORA TURNOS -----
    
    // Creacion de un turno
     public void crearTurno(Turno turno){
       
         controlPersis.crearTurno(turno);
    }
     
     // Modificacion de un turno
     public void modificarTurno(Turno turno){
         
         controlPersis.modificarTurno(turno);
     }
     
     // Eliminacion de un turno
     public void eliminarTurno(Long id){
         
         controlPersis.eliminarTurno(id);
     }
     
    // Listado de los turnos
     public List<Turno> listarTurnos (){
        
         return controlPersis.listarTurnos();
    }
     
     // Busqueda turno 
     public Turno buscarTurno(Long id){
         
         return controlPersis.buscarTurno(id);
     }
     
     // Busqueda de turno por fecha
    public List<Turno> buscarTurnoPorFecha(LocalDate fecha){
        // Obtienes todos los turnos primero
        List<Turno> todosLosTurnos = controlPersis.listarTurnos();

        // Filtras los turnos por la fecha especificada
        return todosLosTurnos.stream()
                             .filter(t -> t.getFechaTurno().isEqual(fecha))
                             .collect(Collectors.toList());
    }
     
     // Busqueda de turno por fecha y estado
    public List<Turno> buscarTurnosPorFechaYEstado(LocalDate fecha, String estado) {
            List<Turno> todosLosTurnos = controlPersis.listarTurnos();
            return todosLosTurnos.stream()
                                 .filter(t -> t.getFechaTurno().isEqual(fecha) && t.getEstado().equalsIgnoreCase(estado))
                                 .collect(Collectors.toList());
    }  
}
