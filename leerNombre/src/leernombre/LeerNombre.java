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

static ArrayList diccionario=new ArrayList();

static void busquedad(ArrayList cadenas,String palabra) throws IOException {
  int c=0;
    if(!diccionario.contains(palabra)){

        for (Object i:cadenas) {
          if (i.toString().equals(palabra)){
            c++;
          }

      }
        System.out.println(palabra+" | "+c);

  }
}

static  void diccionario() throws IOException {

    File file=new File("/home/csipro/Descargas/en-stopwords.txt");
    String palabra;
    FileReader f =new FileReader(file);
    BufferedReader b=new BufferedReader(f);
    while ((palabra=b.readLine())!=null){
         diccionario.add(palabra);
    }
}

    static void leerDirectorio(String directorio) throws IOException {
        Queue<String> archivo = new LinkedList<>();
        boolean file = true;
        int a = 0;

        Stack<String> path = new Stack<>();
        File f = new File(directorio);

        if (file = f.exists()) {
            File[] files = f.listFiles();
            for (File i : files) {
                if (i.isFile()) {

                    leerArchivo(i.getAbsolutePath());
                    break;
                } else {
                    path.add(i.getAbsolutePath());
                    leerDirectorio(path.get(a));
                    a++;
                }

            }
        }

    }

    static void leerArchivo(String archivo) throws FileNotFoundException, IOException {
        File arc = new File(archivo);
        String cadena;
        int palabras = 0;
        ArrayList Palabras=new ArrayList();
        int c = 0;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            c++;
            StringTokenizer st = new StringTokenizer(cadena);
            palabras += st.countTokens();
            while (st.hasMoreTokens()){
                Palabras.add(st.nextToken());
            }

        }
        for (Object i :Palabras
             ) {
busquedad(Palabras,i.toString());
        }


        System.out.println(c + " " + palabras + " " + arc.getName());
        b.close();
    }

    public static void main(String[] args) throws IOException {
       //leerDirectorio(args[0]);
        diccionario();
        leerArchivo(args[0]);



    }

}