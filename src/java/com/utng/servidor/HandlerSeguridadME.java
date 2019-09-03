package com.utng.servidor;

import com.utng.servicio.UsuarioServicio;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

/**
 * @author David Salazar Mejia
 * @correo davidsm54@gmail.com
 * @fecha 24-may-2018
 * @hora 13:55:03
 * @encoding ISO-8859-1
 * @empresa SOMA
 * @version 1.0
 */
public class HandlerSeguridadME implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    /**
     * Manipula las peticiones de entrada en el WEB SERVICE del Modulo Entidad
     *
     * @param context Indica el contexto de la peticion XML del WS
     * @return boolean
     */
    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        //Indica el estado del 
        boolean estadoActual = true;

        try {
            //Indica si es una peticion de entrada
            boolean esSolicitud = (boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            Object formaEnvio = context.get(MessageContext.HTTP_REQUEST_METHOD);

            String mensajeError = "Usuario o Contraseña no han sido especificados en el HEADER";

            if (formaEnvio.equals("POST") && !esSolicitud) {

                /*Extrae los datos del mensaje SOAP*/
                SOAPMessage mensajeSOAP = context.getMessage();
                SOAPEnvelope ambiente = mensajeSOAP.getSOAPPart().getEnvelope();
                SOAPHeader encabezadoSOAP = ambiente.getHeader();

                logMessage(mensajeSOAP);
                mensajeSOAP.saveChanges();

                //Valida que haya un usuario y contraseña en el HEADER
                if (encabezadoSOAP == null) {
                    generaErrorSOAP(mensajeSOAP, 1, mensajeError);
                }

                //Datos del encabezado
                Iterator iterador = encabezadoSOAP.getChildElements();

                //if no header block for next actor found? throw exception
                if (iterador == null || !iterador.hasNext()) {
                    generaErrorSOAP(mensajeSOAP, 1, mensajeError);
                }

                List<Object[]> lDato = new ArrayList();

                while (iterador.hasNext()) {
                    Node nodo = (Node) iterador.next();

                    Object[] aDato = new Object[2];

                    aDato[0] = nodo.getNodeName();
                    //Verifica si es null el valor, si lo es, asigna comillas doble
                    aDato[1] = (nodo.getValue() == null) ? "" : nodo.getValue();

                    lDato.add(aDato);
                }

                if (lDato.size() < 2) {
                    generaErrorSOAP(mensajeSOAP, 1, mensajeError);
                } else {
                    Object[] aUsuario = lDato.get(0);
                    Object[] aContrasena = lDato.get(1);

                    if (aUsuario == null) {
                        generaErrorSOAP(mensajeSOAP, 1, mensajeError);
                    } else if (!aUsuario[0].toString().contains("usuario")) {
                        generaErrorSOAP(mensajeSOAP, 1, mensajeError);
                    }

                    if (aContrasena == null) {
                        generaErrorSOAP(mensajeSOAP, 1, mensajeError);
                    } else if (!aContrasena[0].toString().contains("contrasena")) {
                        generaErrorSOAP(mensajeSOAP, 1, mensajeError);
                    }

                    String nickname = aUsuario[1].toString();
                    String contrasenaWS = aContrasena[1].toString();

                    if (new UsuarioServicio().buscaUsuario(nickname, contrasenaWS, true) == null) {
                        generaErrorSOAP(mensajeSOAP, 1, mensajeError);
                    }
                }
            }
        } catch (SOAPException e) {
            try {
                generaErrorSOAP(null, 1, e.getMessage());
            } catch (SOAPException ex) {
            }
            estadoActual = false;
        }
        return estadoActual;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }

    /**
     * Genera un mensaje de retorno, lanzando una excepcion
     *
     * @param mensajeXML
     * @param estadoPeticion Integer.- Indica el numero de peticion
     * @param error Mensaje a mostrar
     * @throws SOAPException
     */
    private void generaErrorSOAP(SOAPMessage mensajeXML, int estadoPeticion,
            String error) throws SOAPException {
        SOAPBody soapBody = mensajeXML.getSOAPPart().getEnvelope().getBody();
        SOAPFault mensajeError = soapBody.addFault();

        mensajeError.setFaultCode(String.valueOf(estadoPeticion));
        mensajeError.setFaultString(error);
        throw new SOAPFaultException(mensajeError);
    }

//    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private void logMessage(final SOAPMessage msg) {
        try {
            // Write the message to the output stream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            msg.writeTo(baos);
//            LOGGER.info(baos.toString());
            baos.close();
        } catch (final IOException | SOAPException e) {
//            LOGGER.error("Caught exception: " + e.getMessage(), e);
        }
    }
}
