/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.ExampleJDBC.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alejo
 * Objetive: clase para utileria de conversiones de datos
 */
public class ConvertUtils {
    public static String dateToString (Date date)
    {
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String result = dateFormat.format(date);
         return result;
    }
    
    public static Date StringToDate(String text) throws ParseException
    {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
        return date;
    }
}
