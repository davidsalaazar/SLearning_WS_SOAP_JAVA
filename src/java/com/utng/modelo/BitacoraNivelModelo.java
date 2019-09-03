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
 * @author SOMA-DAVID
 * @version 1.0
 * @created 09-oct.-2018 12:03:53 p. m.
 */
@Entity
@Table(name = "bitacoranivel")
public class BitacoraNivelModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBitacora;

    @Temporal(TemporalType.DATE)
    @Column(insertable = false, updatable = false, columnDefinition = "date default current_date")
    private Date fecha;

    @Temporal(TemporalType.TIME)
    @Column(insertable = false, updatable = false, columnDefinition = "time default current_time")
    private Date hora;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idusuario")
    private UsuarioModelo usuario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idnivel")
    private NivelModelo nivel;

    public int getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(int idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public UsuarioModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModelo usuario) {
        this.usuario = usuario;
    }

    public NivelModelo getNivel() {
        return nivel;
    }

    public void setNivel(NivelModelo nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idBitacora;
        hash = 17 * hash + Objects.hashCode(this.fecha);
        hash = 17 * hash + Objects.hashCode(this.hora);
        hash = 17 * hash + Objects.hashCode(this.usuario);
        hash = 17 * hash + Objects.hashCode(this.nivel);
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
        final BitacoraNivelModelo other = (BitacoraNivelModelo) obj;
        if (this.idBitacora != other.idBitacora) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        return true;
    }
}//end BitacoraNivel
