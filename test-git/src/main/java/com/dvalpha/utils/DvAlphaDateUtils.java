/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvalpha.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class DvAlphaDateUtils {
 
    
    public Date sumarRestarDiasFecha(Date fecha, int dias){

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0

      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

 }
 
 // Suma o resta las horas recibidos a la fecha  

 public Date sumarRestarHorasFecha(Date fecha, int horas){

      Calendar calendar = Calendar.getInstance();	
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
	
 }
 
 public String obtenerHorasApartirDeUtilDate(Date fecha){
 DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
 return formatoHora.format(fecha);
 }
 public String obtenerFechaApartirDeUtilDate(Date fecha){
 DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
 return formatoFecha.format(fecha);
 }
 
 
 public String obtenerDiasEntreFechas(Date entrada,Date salida){
  // Crear 2 instancias de Calendar
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        // Establecer las fechas
        cal1.setTimeInMillis(entrada.getTime());
        cal2.setTimeInMillis(salida.getTime());

        // conseguir la representacion de la fecha en milisegundos
        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();

        // calcular la diferencia en milisengundos
        long diff = milis2 - milis1;

  
        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);
        
        return String.valueOf(diffDays);
        
 
 }
 

 
 
 
 public static void main (String []a ){
 
      DvAlphaDateUtils util = new DvAlphaDateUtils();
      Date salida = new Date();
      util.fechahoyCompareFechaSalida(salida);
       
      //Test
      int res= util.fechahoyCompareFechaSalida(salida);
      Date semanaMenos=util.sumarRestarDiasFecha(salida, -10);
        
      System.out.println("compara :"+res);
      System.out.println("Resta :"+semanaMenos);    
 
 
 
 }
     public int fechahoyCompareFechaSalida(Date salida){
         
        Calendar sal = new GregorianCalendar();
        sal.setTime(salida);
         
        Calendar hoy = new GregorianCalendar();
        int año = hoy.get(Calendar.YEAR);
        int mes = hoy.get(Calendar.MONTH);
        int dia = hoy.get(Calendar.DAY_OF_MONTH);
        
       // Si la fecha de salida es mayor a la actual devuelve -1 (aun esta el cliente)
       // Si la fecha de salida es menor  a la actual devuelve 1 (el cliente se ha ido)
       // Si la fecha de salida es igual  a la actual devuelve 0 (el cliente se ha ido)
          
          hoy.set(año, mes, dia,0,0,0);
          int resultado;
          if(hoy.getTime().toString().equals(sal.getTime().toString())){
           resultado=0;
           }else{
            resultado=hoy.compareTo(sal);
           }
          
          return resultado;
 }
}
