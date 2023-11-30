/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demillandiego_pruebatec2.persistencia;

import com.mycompany.demillandiego_pruebatec2.logica.Ciudadano;
import com.mycompany.demillandiego_pruebatec2.logica.Turno;
import com.mycompany.demillandiego_pruebatec2.persistencia.exceptions.NonexistentEntityException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;

/**
 *
 * @author diego
 */
public class ControladoraPersistencia {
    
    // Creacion de instancias para ciudadano y turno
    CiudadanoJpaController ciudadanoJpa = new CiudadanoJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    
    
    // Crear un ciudadano 
    public void crearCiudadano(Ciudadano ciudadano){ 
        ciudadanoJpa.create(ciudadano);
    }
    
    // Buscar a un ciudadano por su ID
    public Ciudadano busquedaCiudadano(Long id){
        return ciudadanoJpa.findCiudadano(id);
    }   
    
    // Lista a los ciudadanos
    public List<Ciudadano> listarCiudadanos(){ 
       return ciudadanoJpa.findCiudadanoEntities();
    }
    
    // Filtrado por DNI utilizando streams
    public Optional<Long> busquedaPorDni(String dni) {
    return ciudadanoJpa.findCiudadanoEntities().stream()
                .filter(n -> n.getDni().equalsIgnoreCase(dni))
                .findFirst()
                .map(Ciudadano::getId);
    }
    
    // Eliminacion de un Ciudadano
    public void eliminarCiudadano(Long id) {
    try {
        ciudadanoJpa.destroy(id);
    } catch (NonexistentEntityException e) {
        Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Estas intentando eliminar una entidad que no existe: " + id, e);
        
    }
    
    }
    
    // Modificacion de un ciudadano
    public void modificarCiudadano(Ciudadano ciudadano) {
        try {
            ciudadanoJpa.edit(ciudadano);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Intento de modificar un ciudadano que no existe: " + ciudadano.getId(), e);
            // Aquí podrías agregar más lógica para manejar esta situación específica
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al modificar el ciudadano: " + ciudadano.getId(), e);
            // Manejar otras excepciones generales
        }
    }    
    
    // ----- CONTROLADORA TURNO -----
    
    // Creacion de un turno
    public void crearTurno(Turno turno){
        turnoJpa.create(turno);
    }
    
    // Eliminacion de un turno
    public void eliminarTurno(Long id) {
        try {
            turnoJpa.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Estas intentando eliminar un turno que no existe: " + id, e);
        
        }
    }
    
    // Buscar un turno
    public Turno buscarTurno(Long id){
        return turnoJpa.findTurno(id);
    }
    
    // Listado de los turnos
    public List<Turno> listarTurnos(){
        return turnoJpa.findTurnoEntities();
    }
    
    // Modificacion de un turno
     public void modificarTurno(Turno turno) {
        try {
            turnoJpa.edit(turno);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Intento de modificar un turno que no existe: " + turno.getId(), e);
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al modificar el turno: " + turno.getId(), e);
        }
    }
     
     // Buscar turno por fecha
     public List<Turno> buscarTurnoPorFecha(LocalDate fecha){
         return turnoJpa.findTurnoEntities().stream()
                 .filter(n -> n.getFechaTurno().isEqual(fecha)).toList();
                   
     }
       
}