package com.utng.servicio;

import com.utng.dao.DAO;
import com.utng.modelo.ActividadModelo;
import com.utng.modelo.SesionModelo;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha 14-nov-2018 Hora 0:17:06
 *
 * @author David Salazar Mejia Codificacion UTF-8 Version 1.0
 */
public class ActividadServicio {

    private DAO dao = null;

    public ActividadServicio() {
        this.dao = new DAO();
    }

    public List<ActividadModelo> buscaActividad(int idTema) {
        Object[] aColumna = new Object[1];
        aColumna[0] = "tema.idTema";

        Object[] aValor = new Object[1];
        aValor[0] = idTema;

        List<Object> lObjeto = dao.busca(ActividadModelo.class, aColumna, aValor);

        if (lObjeto == null || lObjeto.isEmpty()) {
            return null;
        }

        List<ActividadModelo> lActividad = new ArrayList();

        for (Object object : lObjeto) {
            lActividad.add((ActividadModelo) object);
        }

        return lActividad;
    }

    public boolean agregaActualizaActividad(ActividadModelo actividad) {
        if (actividad != null) {
            List<Object> lObjecto = new ArrayList();
            lObjecto.add(actividad);
            return dao.insertUpdate(lObjecto);
        }
        return false;
    }

}
