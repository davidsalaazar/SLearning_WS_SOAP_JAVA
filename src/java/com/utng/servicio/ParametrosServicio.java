package com.utng.servicio;

import com.utng.dao.DAO;
import com.utng.modelo.ParametroModelo;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha 10-oct-2018 Hora 2:03:41
 *
 * @author David Salazar Mejia Codificacion UTF-8 Version 1.0
 */
public class ParametrosServicio {

    private DAO dao;

    public ParametrosServicio() {
        this.dao = new DAO();
    }

    public ParametroModelo buscaParametro(String nombre) {
        Object[] aColumna = new Object[1];
        aColumna[0] = "nombre";

        Object[] aValor = new Object[1];
        aValor[0] = nombre;

        List<Object> lObjeto = dao.busca(ParametroModelo.class, aColumna, aValor);

        if (lObjeto == null || lObjeto.isEmpty()) {
            return null;
        }

        return (ParametroModelo) lObjeto.get(0);
    }

    public boolean agregaActualizaParametro(ParametroModelo parametro) {
        if (parametro != null) {
            List<Object> lObjeto = new ArrayList();
            lObjeto.add(parametro);
            return dao.insertUpdate(lObjeto);
        }
        return false;
    }
}
