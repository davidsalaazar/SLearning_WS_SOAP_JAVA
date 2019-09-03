package com.utng.servicio;

import com.utng.dao.DAO;
import com.utng.modelo.BitacoraNivelModelo;
import com.utng.modelo.NivelModelo;
import com.utng.modelo.UsuarioModelo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 9/10/2018
 * @hora 06:23:43 PM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
public class BitacoraNivelServicio {

    private DAO dao = null;

    public BitacoraNivelServicio() {
        this.dao = new DAO();
    }

    public boolean agregaBitacoraNivelUsuario(int idUsuario, int idNivel) {
        if (idUsuario > 0 && idNivel > 0) {
            BitacoraNivelModelo bitacora = new BitacoraNivelModelo();
            UsuarioModelo usuario = new UsuarioModelo();
            NivelModelo nivel = new NivelModelo();

            usuario.setIdPersona(idUsuario);
            nivel.setIdNivel(idNivel);

            bitacora.setUsuario(usuario);
            bitacora.setNivel(nivel);

            List<Object> lBitacora = new ArrayList();

            lBitacora.add(bitacora);
            return dao.insertUpdate(lBitacora);
        }
        return false;
    }
}
