package com.utng.servicio;

import com.utng.dao.DAO;
import com.utng.modelo.AmbienteModelo;
import com.utng.modelo.SesionModelo;
import com.utng.modelo.UsuarioModelo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 9/10/2018
 * @hora 06:23:19 PM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
public class UsuarioServicio {

    private DAO dao = null;

    private UsuarioModelo usuario;

    public UsuarioServicio() {
        this.dao = new DAO();
        usuario = new UsuarioModelo();
    }

    public UsuarioModelo buscaUsuario(String nickCorreo, String contrasena, boolean nickname) {
        Object[] aColumna = new Object[1];
        aColumna[0] = (nickname) ? "nickname" : "correo";

        Object[] aValor = new Object[1];
        aValor[0] = nickCorreo;

        List<Object> lUsuario = dao.busca(UsuarioModelo.class, aColumna, aValor);

        if (lUsuario == null || lUsuario.isEmpty()) {
            return null;
        }

        usuario = (UsuarioModelo) lUsuario.get(0);

        if (usuario.getContrasena().equals(contrasena)) {
            return usuario;
        }

        return null;
    }

    public boolean agregaActualizaUsuario(UsuarioModelo usuario) {
        boolean estadoMetodo = false;
        if (usuario != null) {
            List<Object> lUsuario = new ArrayList();
            lUsuario.add(usuario);

            try {
                estadoMetodo = dao.insertUpdate(lUsuario);
            } catch (Exception e) {
                Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return estadoMetodo;
    }

    public boolean eliminaUsuario(UsuarioModelo usuario) {
        if (usuario != null) {
            List<Object> lObjeto = new ArrayList();
            lObjeto.add(usuario);
            return dao.delete(lObjeto);
        }
        return false;
    }

    public Object[] buscaNivelUsuario(int idUsuario) {
        String consulta = "select bt.fecha, bt.hora, n.nombre from bitacoranivel bt\n"
                + "		inner join nivel using(idnivel)		\n"
                + "		where idusuario = " + idUsuario + "\n"
                + "			order by idbitacora desc";

        List<Object> res = dao.busquedaEspecial(consulta);

        return res.toArray();
    }
}
