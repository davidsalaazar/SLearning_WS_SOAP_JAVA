package com.utng.servicio;

import com.utng.dao.DAO;
import com.utng.modelo.CursoModelo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 9/10/2018
 * @hora 06:24:02 PM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
public class CursoServicio {

    private DAO dao = null;

    public CursoServicio() {
        this.dao = new DAO();
    }

    public CursoModelo buscaCurso(String nombre) {
        Object[] aColumna = new Object[1];
        aColumna[0] = "nombre";

        Object[] aValor = new Object[1];
        aValor[0] = nombre;

        List<Object> lObjeto = dao.busca(CursoModelo.class, aColumna, aValor);

        if (lObjeto == null || lObjeto.isEmpty()) {
            return null;
        }

        return (CursoModelo) lObjeto.get(0);
    }

    public boolean agregaActualizaCurso(CursoModelo curso) {
        if (curso != null) {
            List<Object> lObjeto = new ArrayList();
            lObjeto.add(curso);
            return dao.insertUpdate(lObjeto);
        }
        return false;
    }

    public boolean eliminaCurso(CursoModelo curso) {
        if (curso != null) {
            String query = "delete from usuario_curso\n"
                    + "	where cursos_idcurso = " + curso.getIdCurso();

            if (dao.executeSQL(query)) {

                query = "delete from tema\n"
                        + "	where idcurso = " + curso.getIdCurso();

                if (dao.executeSQL(query)) {
                    List<Object> lObjeto = new ArrayList();
                    lObjeto.add(curso);
                    return dao.delete(lObjeto);
                }
            }
        }
        return false;
    }
}
