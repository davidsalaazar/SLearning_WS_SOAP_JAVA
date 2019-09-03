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
 * @author DAVID SALAZAR
 * @version 1.0
 * @created 09-oct.-2018 12:03:22 p. m.
 */
@Entity
@Table(name = "sesion")
public class SesionModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSesion;

    @Temporal(TemporalType.DATE)
    @Column(insertable = false, updatable = false, columnDefinition = "date default current_date")
    private Date fecha;

    @Temporal(TemporalType.TIME)
    @Column(insertable = false, updatable = false, columnDefinition = "time default current_time")
    private Date horaInicio;

    @Temporal(TemporalType.TIME)
    private Date fechaFin;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idusuario")
    private UsuarioModelo usuario;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idambiente")
    private AmbienteModelo ambiente;

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public UsuarioModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModelo usuario) {
        this.usuario = usuario;
    }

    public AmbienteModelo getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(AmbienteModelo ambiente) {
        this.ambiente = ambiente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.idSesion;
        hash = 31 * hash + Objects.hashCode(this.fecha);
        hash = 31 * hash + Objects.hashCode(this.horaInicio);
        hash = 31 * hash + Objects.hashCode(this.fechaFin);
        hash = 31 * hash + Objects.hashCode(this.usuario);
        hash = 31 * hash + Objects.hashCode(this.ambiente);
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
        final SesionModelo other = (SesionModelo) obj;
        if (this.idSesion != other.idSesion) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.horaInicio, other.horaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.ambiente, other.ambiente)) {
            return false;
        }
        return true;
    }
}//end Sesion
