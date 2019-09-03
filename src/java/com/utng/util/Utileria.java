package com.utng.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 10/10/2018
 * @hora 06:31:12 PM
 * @encoding UTF-8
 * @empresa SOMA
 * @version 1.0
 */
public class Utileria {

    public static String getFechaActual() {
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    
    public static String getHoraActual() {
        Date date = new Date();
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }

}
