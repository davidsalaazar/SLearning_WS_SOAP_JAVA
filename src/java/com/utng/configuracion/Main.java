package com.utng.configuracion;

import com.utng.servidor.Servidor;
import static java.net.InetAddress.getLocalHost;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

/**
 * Fecha 06-nov-2018 Hora 2:12:45
 *
 * @author David Salazar Mejia Codificacion UTF-8 Version 1.0
 */
public class Main {

    private static Endpoint point;

    public static void main(String[] args) throws UnknownHostException {
        String direccionIP = getLocalHost().getHostAddress();

        String url = "http://" + direccionIP + ":8080/slearningWS";
        try {
            point = Endpoint.publish(url, new Servidor());
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(
                    Level.SEVERE, null, e);
        }
    }

}
