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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dii
 */
public class LeerNombre {
   static int palabras = 0;
    static void leerArchivo(String archivo) throws FileNotFoundException, IOException {
        File arc = new File(archivo);
        String cadena;
        ArrayList total;
        String cadenas[];


        int c = 0;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            c++;

            if (cadena.contains(" ")){

                cadenas=cadena.split(" ");
                total=new ArrayList();
                for (String i:cadenas
                     ) {
                    if (i.length()>0){
                        Pattern p = Pattern.compile("[a-zA-Z]*");
                        Matcher m = p.matcher(i);
                        Pattern l = Pattern.compile("[0-9.0-9]*");
                        Matcher v = l.matcher(i);
                        if (m.matches()|v.matches()){
                            total.add(i);
                        }else {
                            Palabras(i);
                        }
                    }

                }
                palabras+=total.size();
            }
            


        }

        System.out.println(arc.getName() + " " + palabras + " " + c);
        b.close();

    }
    static void Palabras(String i){
        if (i.contains("-")){
           String cadena;
           String cadenas[];
           ArrayList totol=new ArrayList();
           cadenas=i.split("-");
            for (String j:cadenas
                 ) {
                Pattern p = Pattern.compile("[^/]*");
                Matcher m = p.matcher(j);
                if (m.matches()){
            totol.add(j);
                }
                else{
                    System.out.println(j);
                }
            }
            palabras+=totol.size();
        }

    }

    public static void main(String[] args) throws IOException {

        leerArchivo(args[0]);
    }

}
