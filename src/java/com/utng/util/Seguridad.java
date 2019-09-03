package com.utng.util;

import java.util.Base64;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 10/10/2018
 * @hora 06:34:45 PM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
public class Seguridad {

    String algoritmo = "AES-128";

    public static Object[] descifraContenido(String cadenaCifrada) {
        String json = Base64.getDecoder().decode(cadenaCifrada.getBytes()).toString();

        return json.split(",");
    }

    public static String cifraContenido(Object[] datos) {

        String cadena = "";

        for (Object dato : datos) {
            cadena += dato + ",";
        }
        cadena = cadena.substring(0, cadena.length() - 1);

        String cadenaCifrada = Base64.getEncoder().encodeToString(cadena.getBytes());

        return cadenaCifrada;
    }

}
