package com.utng.servicio;

import com.utng.dao.DAO;
import com.utng.modelo.SesionModelo;
import com.utng.modelo.UsuarioModelo;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha 10-oct-2018 Hora 1:24:51
 *
 * @author David Salazar Mejia Codificacion UTF-8 Version 1.0
 */
public class SesionServicio {

    private DAO dao = null;

    public SesionServicio() {
        this.dao = new DAO();
    }

    public UsuarioModelo buscaSesiones(String fecha) {
        Object[] aColumna = new Object[1];
        aColumna[0] = "fechaInicio";

        Object[] aValor = new Object[1];
        aValor[0] = fecha;

        List<Object> lUsuario = dao.busca(UsuarioModelo.class, aColumna, aValor);

        if (lUsuario == null || lUsuario.isEmpty()) {
            return null;
        }

        return (UsuarioModelo) lUsuario.get(0);
    }

    public boolean agregaActualizaSesion(SesionModelo sesion) {
        if (sesion != null) {
            List<Object> lObjecto = new ArrayList();
            lObjecto.add(sesion);
            return dao.insertUpdate(lObjecto);
        }
        return false;
    }
}
