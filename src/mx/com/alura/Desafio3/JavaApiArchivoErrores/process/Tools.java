package mx.com.alura.Desafio3.JavaApiArchivoErrores.process;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

    public static int stringToInt(String intStr){
        try{
            return Integer.parseInt(intStr.trim());
        }catch(NumberFormatException e){
            System.out.println("No fue posible convertir el valor " + intStr + " a número");
        }catch(NullPointerException e){
            System.out.println("Valor nulo: " + intStr);
        }
        return 0;
    }

    public static double stringToDouble(String doubleStr){
        try{
            return Double.parseDouble(doubleStr.trim());
        }catch(NumberFormatException e){
            System.out.println("No fue posible convertir el valor " + doubleStr + " a número decimal");
        }catch(NullPointerException e){
            System.out.println("Valor nulo: " + doubleStr);
        }
        return 0;
    }

    public static Date stringToDate(String dateStr, String formatter) {
        try{
            DateFormat df = new SimpleDateFormat(formatter);
            return df.parse(dateStr);
        }catch (ParseException e) {
            System.out.println("No fue posible convertir el valor " + dateStr + " a fecha con el formato " + formatter);
        }catch(NullPointerException e){
            System.out.println("Valor nulo: " + formatter);
        }
        return null;
    }
}
