/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demillandiego_pruebatec2.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author diego
 */
@Entity
public class Ciudadano implements Serializable{
    
    // Creacion del constructor tanto vacio como completo
    public Ciudadano() {
    }

    public Ciudadano(Long id,List<Turno> turnos, String dni, String nombre, String apellidos, String telefono) {
        this.id = id;
        this.turnos = turnos;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    @OneToMany(mappedBy = "ciudadano")
    private List<Turno> turnos = new ArrayList<>();
    
    // Creacion de los getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Creacion a mayores del metodo toString()

    @Override
    public String toString() {
        return "Ciudadano{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + '}';
    }
    
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    
}
