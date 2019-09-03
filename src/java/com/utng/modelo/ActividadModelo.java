package com.utng.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 15/10/2018
 * @hora 10:23:18 AM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
@Entity
@Table(name = "actividad")
public class ActividadModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividad;

    @Column(length = 10)
    private String fechaInicio;

    @Column(length = 10)
    private String fechaFin;

    @Column(length = 20)
    private String horaInicio;

    @Column(length = 20)
    private String horaFin;

    private String nombre;

    private String descripcion;

    private double valor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idtema")
    private TemaModelo tema;

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TemaModelo getTema() {
        return tema;
    }

    public void setTema(TemaModelo tema) {
        this.tema = tema;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idActividad;
        hash = 71 * hash + Objects.hashCode(this.fechaInicio);
        hash = 71 * hash + Objects.hashCode(this.fechaFin);
        hash = 71 * hash + Objects.hashCode(this.horaInicio);
        hash = 71 * hash + Objects.hashCode(this.horaFin);
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.descripcion);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.tema);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActividadModelo other = (ActividadModelo) obj;
        if (this.idActividad != other.idActividad) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.horaInicio, other.horaInicio)) {
            return false;
        }
        if (!Objects.equals(this.horaFin, other.horaFin)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        if (!Objects.equals(this.tema, other.tema)) {
            return false;
        }
        return true;
    }
}
