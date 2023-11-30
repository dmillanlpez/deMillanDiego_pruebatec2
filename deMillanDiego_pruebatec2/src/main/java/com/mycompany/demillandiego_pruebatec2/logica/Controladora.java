/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demillandiego_pruebatec2.logica;

import com.mycompany.demillandiego_pruebatec2.persistencia.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author diego
 */
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
    public Optional<Long> busquedaPorDni(String dni){
        
        return controlPersis.busquedaPorDni(dni);
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
         
         return controlPersis.buscarTurnoPorFecha(fecha);
     }
     
     // Busqueda de turno por fecha y estado
    public List<Turno> buscarTurnosPorFechaYEstado(LocalDate fecha, String estado) {
            List<Turno> todosLosTurnos = controlPersis.listarTurnos();
            return todosLosTurnos.stream()
                                 .filter(t -> t.getFechaTurno().isEqual(fecha) && t.getEstado().equalsIgnoreCase(estado))
                                 .collect(Collectors.toList());
    }  
}