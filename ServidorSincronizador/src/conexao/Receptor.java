package conexao;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Classe Receptor que é responsável por receber um pacote de dados com as
 * requisições de clientes
 *
 * @author Bruno Vicelli
 * @author Mateus Henrique Dal Forno
 * @author Thiago Cassio Krug
 * @version 1.0
 */
public class Receptor {

    /**
     * Método resposável por receber os pacotes de dados dos clientes
     *
     * @param serverSocket
     * @return
     * @throws IOException
     */
    public DatagramPacket receber(DatagramSocket serverSocket) throws IOException {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        return receivePacket;
    }
}
