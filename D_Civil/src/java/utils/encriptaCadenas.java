/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Administrador
 */
public class encriptaCadenas {

  public static String MD5 = "MD5";
    
    private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(int i=0; i<digest.length; i++) {
            byte aux = digest[i];
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }
    public static String getStringMessageDigest(String message, String algorithm){
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return toHexadecimal(digest);
    } 
    
    public static void main(String[] args) {
        
        encriptaCadenas StringMD=new encriptaCadenas();
        String mensaje = "mdsmp*2017";
        System.out.println("Mensaje = " + mensaje);    
        System.out.println("MD5 = " + StringMD.getStringMessageDigest(mensaje, StringMD.MD5));
    
        
    }
    
}
