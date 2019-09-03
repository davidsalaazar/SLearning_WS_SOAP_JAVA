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
 * @hora 10:23:18 AM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
@Entity
@Table(name = "archivo")
public class ArchivoModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int archivoId;

    private byte[] bufferArchivo;

    private String extension;
    
    private String nombre;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idactividad")
    private ActividadModelo actividad;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idusuario")
    private UsuarioModelo usuario;

    public int getArchivoId() {
        return archivoId;
    }

    public void setArchivoId(int archivoId) {
        this.archivoId = archivoId;
    }

    public byte[] getBufferArchivo() {
        return bufferArchivo;
    }

    public void setBufferArchivo(byte[] bufferArchivo) {
        this.bufferArchivo = bufferArchivo;
    }

    public ActividadModelo getActividad() {
        return actividad;
    }

    public void setActividad(ActividadModelo actividad) {
        this.actividad = actividad;
    }

    public UsuarioModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModelo usuario) {
        this.usuario = usuario;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.archivoId;
        hash = 53 * hash + Arrays.hashCode(this.bufferArchivo);
        hash = 53 * hash + Objects.hashCode(this.extension);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.actividad);
        hash = 53 * hash + Objects.hashCode(this.usuario);
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
        final ArchivoModelo other = (ArchivoModelo) obj;
        if (this.archivoId != other.archivoId) {
            return false;
        }
        if (!Objects.equals(this.extension, other.extension)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Arrays.equals(this.bufferArchivo, other.bufferArchivo)) {
            return false;
        }
        if (!Objects.equals(this.actividad, other.actividad)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
}
