/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvalpha.utils;

/**
 *
 * @author Alex
 */
public class FileTransformBytes {
double KB,MB,GB,TB;

    public FileTransformBytes(long bytes){
    //Se inicializa todo el objeto.    
    obtenerTB(bytes);
    }
    public double obtenerKb(long bytes){
    setKB(bytes/1024);
    return getKB();
    
    }
    
    public double obtenerMB(long bytes){
    setMB(obtenerKb(bytes)/1024);
    return getMB();
    
    }
    
    public double obtenerGB(long bytes){
    setGB(obtenerMB(bytes)/1024);
    return getGB();
    }
    public double obtenerTB(long bytes){
    setTB(obtenerGB(bytes)/1024);
    return getTB();
    }

    @Override
    public String toString() {
        return "FileTransformBytes{" + "KB=" + KB + ", MB=" + MB + ", GB=" + GB + ", TB=" + TB + '}';
    }
    
    public static void main(String a[]){
    long m=1000000L;
    FileTransformBytes test = new FileTransformBytes(m);
    System.out.println("El numeraco es "+m);
    System.out.println(test);
    
    
    }
    
    
    public double getKB() {
        return KB;
    }

    public void setKB(double KB) {
        this.KB = KB;
    }

    public double getMB() {
        return MB;
    }

    public void setMB(double MB) {
        this.MB = MB;
    }

    public double getGB() {
        return GB;
    }

    public void setGB(double GB) {
        this.GB = GB;
    }

    public double getTB() {
        return TB;
    }

    public void setTB(double TB) {
        this.TB = TB;
    }

}
