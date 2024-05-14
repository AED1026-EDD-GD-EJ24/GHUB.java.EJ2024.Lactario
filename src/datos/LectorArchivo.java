package datos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import listaDoble.ListaDoblementeEnlazada;
import arbolAVL.ArbolAVL;
import java.util.Hashtable;


public class LectorArchivo {

    public void leerArchivo( ArbolAVL abo, ListaDoblementeEnlazada<Hijo> hijos, Hashtable<String,Mama> ht) 
                             {
        
        
        String rutaArchivoMamas = "mamas.txt";
        String rutaArchivoHijos = "hijos.txt";
        ListaDoblementeEnlazada<Hijo> hijosMama = new ListaDoblementeEnlazada<Hijo>();

        try (Scanner scanner = new Scanner(new File(rutaArchivoMamas))) {
            scanner.useDelimiter(",\\s*");

            while (scanner.hasNext()) {
                try {
                    String linea = scanner.nextLine();
                    String[] campos = linea.split(",");

                    String id = campos[0].replaceAll("\"", "");
                    String nombre = campos[1].replaceAll("\"", "");
                    int edad = Integer.parseInt(campos[2].replaceAll("\"", ""));
                    String fechaNac = campos[3].replaceAll("\"", "");
                   

                    Mama objMama = new Mama(id, nombre, edad, new Fecha(fechaNac),hijosMama);
                    abo.insertar(objMama);
                    ht.put(id, new Mama(id, nombre, edad, new Fecha(fechaNac),hijosMama));
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       
        try (Scanner scannerHijos = new Scanner(new File(rutaArchivoHijos))) {
            scannerHijos.useDelimiter(",\\s*");

            while (scannerHijos.hasNext()) {
                String linea = scannerHijos.nextLine();
                String[] campos = linea.split(",");

                String codigo = campos[0].replaceAll("\"", "");
                String nombre = campos[1].replaceAll("\"", "");
                int meses  =Integer.parseInt(campos[2].replaceAll("\"", ""));
                String tipoMes =campos[3].replaceAll("\"", "");
                int dias =Integer.parseInt(campos[4].replaceAll("\"", ""));
                String tipoDias =campos[5].replaceAll("\"", "");
          
                
                String fechaNac = campos[6].replaceAll("\"", "");
                String idMama = campos[7].replaceAll("\"", "");
               
               
                Hijo objHijo = new Hijo(codigo, nombre, meses,dias, new Fecha(fechaNac), idMama);
            
                hijos.agregar(objHijo);
               
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            

    }
}