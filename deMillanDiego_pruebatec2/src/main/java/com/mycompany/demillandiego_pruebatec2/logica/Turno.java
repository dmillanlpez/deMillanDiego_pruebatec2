
package com.mycompany.demillandiego_pruebatec2.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turno implements Serializable {
    
    // Creacion del constructor tanto vacio como completo
    public Turno() {
    }

    public Turno(Ciudadano ciudadano, Long id, LocalDate fechaTurno, String descripcionTram, String estado) {
        this.ciudadano = ciudadano;
        this.id = id;
        this.fechaTurno = fechaTurno;
        this.descripcionTram = descripcionTram;
        this.estado = estado;
    }

    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano ciudadano;
    
    // Creacion getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getDescripcionTram() {
        return descripcionTram;
    }

    public void setDescripcionTram(String descripcionTram) {
        this.descripcionTram = descripcionTram;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    // Creacion a mayores del metodo toString()

    @Override
    public String toString() {
        return "Turno{" + "ciudadano=" + ciudadano + ", id=" + id + ", fechaTurno=" + fechaTurno + ", descripcionTram=" + descripcionTram + ", estado=" + estado + '}';
    }

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaTurno;
    private String descripcionTram;
    private String estado;
     
}
