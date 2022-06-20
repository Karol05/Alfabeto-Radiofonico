package Main.Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnalizadorLexico {


    public String[] separarPalabras(String cadena){
        return cadena.split(" ");
    }

    public Gramatica definirGramatica(){
        Gramatica gramatica = new Gramatica();
        gramatica.agregarRegla("Palabra", "ALFA");
        gramatica.agregarRegla("Palabra", "BRAVO");
        gramatica.agregarRegla("Palabra", "CHARLIE");
        gramatica.agregarRegla("Palabra", "DELTA");
        gramatica.agregarRegla("Palabra", "ECHO");
        gramatica.agregarRegla("Palabra", "FOXTROT");
        gramatica.agregarRegla("Palabra", "GOLF");
        gramatica.agregarRegla("Palabra", "HOTEL");
        gramatica.agregarRegla("Palabra", "INDIA");
        gramatica.agregarRegla("Palabra", "JULIET");
        gramatica.agregarRegla("Palabra", "KILO");
        gramatica.agregarRegla("Palabra", "LIMA");
        gramatica.agregarRegla("Palabra", "MIKE");
        gramatica.agregarRegla("Palabra", "NOVEMBER");
        gramatica.agregarRegla("Palabra", "ÑANDU");
        gramatica.agregarRegla("Palabra", "OSCAR");
        gramatica.agregarRegla("Palabra", "PAPA");
        gramatica.agregarRegla("Palabra", "QUEBEQ");
        gramatica.agregarRegla("Palabra", "ROMEO");
        gramatica.agregarRegla("Palabra", "SIERRA");
        gramatica.agregarRegla("Palabra", "TANGO");
        gramatica.agregarRegla("Palabra", "UNIFORM");
        gramatica.agregarRegla("Palabra", "VICTOR");
        gramatica.agregarRegla("Palabra", "WHISKEY");
        gramatica.agregarRegla("Palabra", "X-RAY");
        gramatica.agregarRegla("Palabra", "YANKIE");
        gramatica.agregarRegla("Palabra", "ZULU");
        gramatica.agregarRegla("Palabra", "UNO");
        gramatica.agregarRegla("Palabra", "DOS");
        gramatica.agregarRegla("Palabra", "TRES");
        gramatica.agregarRegla("Palabra", "CUATRO");
        gramatica.agregarRegla("Palabra", "CINCO");
        gramatica.agregarRegla("Palabra", "SEIS");
        gramatica.agregarRegla("Palabra", "SIETE");
        gramatica.agregarRegla("Palabra", "OCHO");
        gramatica.agregarRegla("Palabra", "NUEVE");
        gramatica.agregarRegla("Palabra", "CERO");
        gramatica.agregarRegla("Punto", ".");

        return gramatica;
    }

    public ArrayList<String> analizarTexto(String cadena){
        ArrayList<String> errores = new ArrayList<>();
        Gramatica gramatica = definirGramatica();
        String[] gramaticaEntrante = separarPalabras(cadena);
        for(int i = 0; i < gramaticaEntrante.length; i++){
            if (!gramatica.buscaRegla(gramaticaEntrante[i], gramatica.getValorRegla())) {

                errores.add(gramaticaEntrante[i]);
            }
            else{
                System.out.println("Palabra: " + gramaticaEntrante[i] + " - Regla: " + gramatica.getNombreRegla().get(i));
            }
        }

        return errores;
    }

    public ArrayList<String> analizarDocumento(String[] gramaticaEntrante){
        ArrayList<String> errores = new ArrayList<>();
        Gramatica gramatica = definirGramatica();
        for(int i = 0; i < gramaticaEntrante.length; i++){
            if (!gramatica.buscaRegla(gramaticaEntrante[i], gramatica.getValorRegla())) {

                errores.add(gramaticaEntrante[i]);
            }
            else{
                System.out.println("Palabra: " + gramaticaEntrante[i] + " - Regla: " + gramatica.getNombreRegla().get(i));
            }
        }

        return errores;
    }


    public String[] separarDocumento(File textFile) throws IOException {
        String[] texto = null;
        String linea;
        BufferedReader contenedor = new BufferedReader(new FileReader(textFile));
        while ((linea=contenedor.readLine()) != null) {
            texto = linea.split(" ");
        }
        
        return texto;
    }

}


