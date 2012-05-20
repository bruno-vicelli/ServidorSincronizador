package core;

/**
 * Classe Main que iniciliza o programa servidor
 *
 * @author Bruno Vicelli
 * @author Mateus Henrique Dal Forno
 * @author Thiago Cassio Krug
 * @version 1.0
 */
public class Main {

    /**
     * Método responsável por invocar os métodos dos objetos para inicializar o
     * programa
     *
     * @param args
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.inicialzarServidor();
    }
}
