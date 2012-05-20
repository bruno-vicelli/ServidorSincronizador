/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author thiago
 */
public class DateParser {
    
    public static String simpleDateFormat(String format, Date data) {
        SimpleDateFormat formatador = new SimpleDateFormat(format);
        return formatador.format(data);
    }
    
    public static String simpleDateFormat(String format, long data) {
        return DateParser.simpleDateFormat(format, new Date(data));
    }
    
}
