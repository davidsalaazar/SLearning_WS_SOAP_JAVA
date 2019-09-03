package com.utng.servicio;

import com.utng.dao.DAO;
import com.utng.modelo.ActividadModelo;
import com.utng.modelo.ArchivoModelo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 15/11/2018
 * @hora 05:54:02 PM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
public class ArchivoServicio {

    private DAO dao = null;

    public ArchivoServicio() {
        this.dao = new DAO();
    }

    public List<ArchivoModelo> buscaArchivosDeActividad(int idActividad) {
        Object[] aColumna = new Object[1];
        aColumna[0] = "actividad.idActividad";

        Object[] aValor = new Object[1];
        aValor[0] = idActividad;

        List<Object> lObjeto = dao.busca(ArchivoModelo.class, aColumna, aValor);

        if (lObjeto == null || lObjeto.isEmpty()) {
            return null;
        }

        List<ArchivoModelo> lArchivo = new ArrayList();

        for (Object object : lObjeto) {
            lArchivo.add((ArchivoModelo) object);
        }
        return lArchivo;
    }

    public ArchivoModelo buscaArchivo(int idActividad, int idUsuario) {
        String query = "SELECT * FROM archivo\n"
                + "	where idactividad = " + idActividad + " \n"
                + "		and idusuario = " + idUsuario;

        List<Object> lObjeto = dao.busquedaEspecial(query);

        if (lObjeto == null || lObjeto.isEmpty()) {
            return null;
        }
        Object[] aRes = (Object[]) lObjeto.get(0);

        ArchivoModelo archivo = new ArchivoModelo();
        archivo.setArchivoId((int)aRes[0]);
        archivo.setBufferArchivo((byte[]) aRes[1]);
        archivo.setExtension(aRes[2].toString());

        return archivo;
    }

    public boolean agregaActualizaArchivo(ArchivoModelo archivo) {
        if (archivo != null) {
            List<Object> lObjeto = new ArrayList();
            lObjeto.add(archivo);
            return dao.insertUpdate(lObjeto);
        }
        return false;
    }
}
