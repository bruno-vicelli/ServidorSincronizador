package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe DateParser que faz o tratamento das horas e converte o tipo de acordo
 * com o necessário
 *
 * @author Bruno Vicelli
 * @author Mateus Henrique Dal Forno
 * @author Thiago Cassio Krug
 * @version 1.0
 */
public class DateParser {

    /**
     * Método que pega a data e converte para o formato Date
     *
     * @param format
     * @param data
     * @return a data no formato Date
     */
    public static String simpleDateFormat(String format, Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat(format);
        return formatador.format(data);
    }

    /**
     * Método que converte a data para o formato long
     *
     * @param format
     * @param data
     * @return a data no formato long
     */
    public static String simpleDateFormat(String format, long data) {
        return DateParser.simpleDateFormat(format, new Date(data));
    }
}
