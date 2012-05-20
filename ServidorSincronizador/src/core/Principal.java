package core;

import conexao.Emissor;
import conexao.Receptor;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DateParser;

/**
 * Classe Principal que inicializa o socket para o funcionamneto do servidor
 *
 *
 * @author Bruno Vicelli
 * @author Mateus Henrique Dal Forno
 * @author Thiago Cassio Krug
 * @version 1.0
 */
public class Principal {

    /**
     * Metodo que inicia o servidor e cria um socket que fica aguardando
     * conexões e recebimento de pedidos e responde com a sua hora certa
     *
     */
    public void inicialzarServidor() {
        DatagramSocket serverSocket;
        DatagramPacket mensagem;
        try {
            serverSocket = new DatagramSocket(9876);
            System.out.println("Servidor iniciado na porta 9876. Aguardando solicitações...\n");
            while (true) {
                Receptor receptor = new Receptor();
                Emissor emissor = new Emissor();
                mensagem = receptor.receber(serverSocket);
                System.out.println("Mensagem recebida do IP: " + mensagem.getAddress());
                long horaEnvio = System.currentTimeMillis();
                String msg = String.valueOf(horaEnvio);
                emissor.enviar(serverSocket, msg, mensagem);
                System.out.println("Mensagem enviada às " + DateParser.simpleDateFormat("dd/MM/yyyy HH:mm:ss:SSSS", horaEnvio) + "\n");
            }
        } catch (SocketException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
