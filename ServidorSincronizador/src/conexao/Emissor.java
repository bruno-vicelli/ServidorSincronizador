package conexao;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Classe Emissor que responde um pacote de dados ao cliente
 *
 * @author Bruno Vicelli
 * @author Mateus Henrique Dal Forno
 * @author Thiago Cassio Krug
 * @version 1.0
 */
public class Emissor {

    /**
     * Método responsável por enviar um pacote de dados ao cliente que envio
     * alguma solictação
     *
     * @param serverSocket
     * @param msg
     * @param receivePacket
     * @throws IOException
     */
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
