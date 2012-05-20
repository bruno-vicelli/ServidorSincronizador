/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author thiago
 */
public class Emissor {

    public void enviar(DatagramSocket serverSocket, String msg, DatagramPacket receivePacket) throws IOException {
        byte[] sendData = new byte[1024];
        InetAddress ipAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        sendData = msg.getBytes();
        DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, ipAddress, port);
        serverSocket.send(sendPacket);
    }
}
