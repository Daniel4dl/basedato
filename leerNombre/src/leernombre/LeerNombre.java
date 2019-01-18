/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leernombre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author dii
 */
public class LeerNombre {

    /**
     * @param args the command line arguments
     */
    static void leerArchivo(String archivo) throws FileNotFoundException, IOException {
        File arc = new File(archivo);
        String cadena;
        
        String cadenas[];
        String cadenas2[];
         String cadenas3[];
        int palabras = 0;
        int c = 0;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            c++;  
            cadenas = cadena.split(" ");
            for (String i:cadenas) {
                System.out.println(i);
                 cadenas2=i.split("./");
                 
                                  cadenas3=i.split("-");

                 
                palabras+=cadenas2.length+cadenas3.length;
            }
          
            
            
            if(cadenas.length>1){
            palabras += cadenas.length;
            }
        }

        System.out.println(arc.getName() + " " + palabras + " " + c);
        b.close();

    }

    public static void main(String[] args) throws IOException {

        leerArchivo(args[0]);
    }

}
