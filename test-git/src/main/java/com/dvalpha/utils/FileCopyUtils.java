/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvalpha.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class FileCopyUtils {
     
     public void copiarContenido(File origen,File destino){
    
        try {
            
            
            FileWriter fw = new FileWriter(destino);
            BufferedReader buff = new BufferedReader(new FileReader(origen));
            String linea = "";
            String total="";
            while((linea=buff.readLine())!=null){
            fw.append(linea+"\r\n");
            }
            fw.flush();
            fw.close();
          
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileCopyUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileCopyUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void copiarArchivosYCarpetas(File origen , File destino)
    throws IOException {

        if (origen.isDirectory()) {
            if (!destino.exists()) {
                 //Asignamos permisos de lectura sobre el directorio
                 destino.setReadable(true);
                
                 destino.mkdir();
               
               
            }

            String[] children = origen.list();
            for (int i=0; i<children.length; i++) {
                copiarArchivosYCarpetas(new File(origen, children[i]),
                        new File(destino, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }
}
