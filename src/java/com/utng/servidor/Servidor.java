package com.utng.servidor;

import com.utng.modelo.ActividadModelo;
import com.utng.modelo.ArchivoModelo;
import com.utng.modelo.CursoModelo;
import com.utng.modelo.RolModelo;
import com.utng.modelo.TemaModelo;
import com.utng.modelo.UsuarioModelo;
import com.utng.servicio.ActividadServicio;
import com.utng.servicio.ArchivoServicio;
import com.utng.servicio.CursoServicio;
import com.utng.servicio.TemaServicio;
import com.utng.servicio.UsuarioServicio;
import com.utng.util.Seguridad;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 9/10/2018
 * @hora 06:15:55 PM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
@WebService
//@HandlerChain(file = "CanalSeguro.xml")
public class Servidor {

    /**
     * Metodo que verifica la existencia de un usuario
     *
     * @param nombreUsuario
     * @param contrasena
     * @param nickCorreo indica como se buscara el usuario si por el correo o
     * por el Nickname
     * @return UsuarioModelo
     */
    @WebMethod
    public UsuarioModelo login(String nombreUsuario, String contrasena, boolean nickCorreo) {
        System.out.println("Usuario buscado: " + nombreUsuario + "Contrasena: " + contrasena);
        return new UsuarioServicio().buscaUsuario(nombreUsuario, contrasena, true);
    }

    /**
     * Registra y actualiza la informacion de un usuario
     *
     * @param usuario
     * @return
     */
    @WebMethod
    public boolean registro(UsuarioModelo usuario) {
        return new UsuarioServicio().agregaActualizaUsuario(usuario);
    }

    @WebMethod
    public List<TemaModelo> getTema(int idCurso) {
        return new TemaServicio().buscaTema(idCurso);
    }

    @WebMethod
    public List<ActividadModelo> getActividad(int idTema) {
        return new ActividadServicio().buscaActividad(idTema);
    }

    @WebMethod
    public double getPorcentaje(int idUsuario) {
        return 0.0;
    }

    @WebMethod
    public boolean agregaCurso(CursoModelo curso) {
        return new CursoServicio().agregaActualizaCurso(curso);
    }

    @WebMethod
    public boolean eliminaCurso(CursoModelo curso) {
        return new CursoServicio().eliminaCurso(curso);
    }

    @WebMethod
    public boolean agregaTema(TemaModelo tema) {
        return new TemaServicio().agregaActualizaTema(tema);
    }

    @WebMethod
    public boolean eliminaTema(TemaModelo tema) {
        return new TemaServicio().eliminarTema(tema);
    }

    @WebMethod
    public boolean agregaActividad(ActividadModelo actividad) {
        return new ActividadServicio().agregaActualizaActividad(actividad);
    }

    @WebMethod
    public List<ArchivoModelo> getArchivosAlumnos(int idActividad) {
        return new ArchivoServicio().buscaArchivosDeActividad(idActividad);
    }

    @WebMethod
    public boolean agregaActualizaArchivo(ArchivoModelo archivo) {
        return new ArchivoServicio().agregaActualizaArchivo(archivo);
    }

    @WebMethod
    public ArchivoModelo getArchivo(int idActividad, int idUsuario) {
        return new ArchivoServicio().buscaArchivo(idActividad, idUsuario);
    }
}
