package com.utng.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 15/10/2018
 * @hora 10:23:09 AM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
@Entity
@Table(name = "pregunta")
public class PreguntaModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    private String descripcion;

    private double valor;

    private String respuesta;

    private String[] respuestas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idactividad")
    private ActividadModelo actividad;

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public ActividadModelo getActividad() {
        return actividad;
    }

    public void setActividad(ActividadModelo actividad) {
        this.actividad = actividad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idPregunta;
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.respuesta);
        hash = 97 * hash + Arrays.deepHashCode(this.respuestas);
        hash = 97 * hash + Objects.hashCode(this.actividad);
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
        final PreguntaModelo other = (PreguntaModelo) obj;
        if (this.idPregunta != other.idPregunta) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.respuesta, other.respuesta)) {
            return false;
        }
        if (!Arrays.deepEquals(this.respuestas, other.respuestas)) {
            return false;
        }
        if (!Objects.equals(this.actividad, other.actividad)) {
            return false;
        }
        return true;
    }
}
