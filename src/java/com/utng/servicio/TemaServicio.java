package com.utng.servicio;

import com.utng.dao.DAO;
import com.utng.modelo.CursoModelo;
import com.utng.modelo.TemaModelo;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha 14-nov-2018 Hora 0:20:51
 *
 * @author David Salazar Mejia Codificacion UTF-8 Version 1.0
 */
public class TemaServicio {

    private DAO dao = null;

    public TemaServicio() {
        this.dao = new DAO();
    }

    public List<TemaModelo> buscaTema(int idCurso) {
        Object[] aColumna = new Object[1];
        aColumna[0] = "curso.idCurso";

        Object[] aValor = new Object[1];
        aValor[0] = idCurso;

        List<Object> lObjeto = dao.busca(TemaModelo.class, aColumna, aValor);

        if (lObjeto == null || lObjeto.isEmpty()) {
            return null;
        }

        List<TemaModelo> lTema = new ArrayList();

        for (Object object : lObjeto) {
            lTema.add((TemaModelo) object);
        }

        return lTema;
    }

    public boolean agregaActualizaTema(TemaModelo tema) {
        if (tema != null) {
            List<Object> lObjecto = new ArrayList();
            lObjecto.add(tema);
            return dao.insertUpdate(lObjecto);
        }
        return false;
    }

    public boolean eliminarTema(TemaModelo tema) {
        if (tema != null) {
            String query = "delete from archivo\n"
                    + "	where idactividad =  any (array(select idactividad from actividad where idtema = " + tema.getIdTema() + "))";

            if (dao.executeSQL(query)) {

                query = "delete from pregunta \n"
                        + "	where idactividad =  any (array(select idactividad from actividad where idtema = " + tema.getIdTema() + "))";

                if (dao.executeSQL(query)) {

                    query = "delete from actividad \n"
                            + "	where idtema = " + tema.getIdTema();

                    if (dao.executeSQL(query)) {
                        List<Object> lObjeto = new ArrayList();
                        lObjeto.add(tema);
                        return dao.delete(lObjeto);
                    }
                }
            }
        }
        return false;
    }
}
