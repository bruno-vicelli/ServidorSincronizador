/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DateParser;

/**
 *
 * @author thiago
 */
public class Principal {
    
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
