package com.utng.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author DAVID SALAZAR
 * @version 1.0
 * @created 09-oct.-2018 12:03:39 p. m.
 */
@Entity
@Table(name = "usuario")
@PrimaryKeyJoinColumn(name = "idPersona")
public class UsuarioModelo extends PersonaModelo implements Serializable {

    @Column(length = 30, unique = true)
    private String nickname;

    @Column(length = 150, unique = true)
    private String correo;

    @Column(length = 30)
    private String contrasena;

    private byte[] imagen;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idrol")
    private RolModelo rol;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CursoModelo> cursos;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public RolModelo getRol() {
        return rol;
    }

    public void setRol(RolModelo rol) {
        this.rol = rol;
    }

    public List<CursoModelo> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoModelo> cursos) {
        this.cursos = cursos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nickname);
        hash = 97 * hash + Objects.hashCode(this.correo);
        hash = 97 * hash + Objects.hashCode(this.contrasena);
        hash = 97 * hash + Arrays.hashCode(this.imagen);
        hash = 97 * hash + Objects.hashCode(this.rol);
        hash = 97 * hash + Objects.hashCode(this.cursos);
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
        final UsuarioModelo other = (UsuarioModelo) obj;
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        if (!Arrays.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (!Objects.equals(this.rol, other.rol)) {
            return false;
        }
        if (!Objects.equals(this.cursos, other.cursos)) {
            return false;
        }
        return true;
    }

}
