/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leernombre;

import java.io.*;
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
            StringTokenizer st = new StringTokenizer(cadena);
           palabras+=st.countTokens();

        }

        System.out.println(arc.getName() + " " + palabras + " " + c);
        b.close();

    }

    static void leerDirectorio(String directorio) throws IOException {
        Queue<String> archivo = new LinkedList<>();
        boolean file = true;
        int a=0;

        Stack<String> path = new Stack<>();
        File f = new File(directorio);

        if (file = f.exists()) {
            File[] files = f.listFiles();
            for (File i : files) {
                if (i.isFile()) {

                    leerArchivo(i.getAbsolutePath());
                } else {
                    path.add(i.getAbsolutePath());
                    leerDirectorio(path.get(a));
                    a++;
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {

        leerArchivo(args[0]);
    }

}
