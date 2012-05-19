/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiago
 */
public class Emissor {

    private DatagramSocket socket = null;
    private byte[] buffer;

    public void enviar() {
        try {
            socket = null;
            buffer = new byte[10];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
            }
        } catch (IOException ex) {
            Logger.getLogger(Emissor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
