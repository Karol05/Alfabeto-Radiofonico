package Main.Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalizadorLexico {


    public String[] separarPalabras(String cadena){
        return cadena.split(" ");
    }

    public Map<String,String> definirGramatica(){
        Map<String,String> gramatica = new HashMap<>();
        String[] nombreComplemento = {"ALFA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT", "GOLF", "HOTEL", "INDIA", "JULIET", "KILO", "LIMA", "MIKE", "NOVEMBER", "ÑANDU", "OSCAR", "PAPA", "QUEBEQ", "ROMEO", "SIERRA", "TANGO", "UNIFORM", "VICTOR", "WHISKEY", "X-RAY", "YANKIE", "ZULU", "CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE"};
        for (String s : nombreComplemento) {
            gramatica.put(s, "PALABRA");
        }
        gramatica.put(".", "PUNTO");

        return gramatica;
    }

    public ArrayList<String> analizarTexto(String cadena){
        ArrayList<String> errores = new ArrayList<>();
        String[] gramaticaEntrante = separarPalabras(cadena);
        for (String s : gramaticaEntrante) {
            if (!definirGramatica().containsKey(s)) {

                errores.add(s);
            } else {
                System.out.println("Palabra: " + s + " - Regla: " + definirGramatica().get(s));
            }
        }

        return errores;
    }

    public ArrayList<String> analizarDocumento(String[] gramaticaEntrante){
        ArrayList<String> errores = new ArrayList<>();
        for (String s : gramaticaEntrante) {
            if (!definirGramatica().containsKey(s)) {
                errores.add(s);
            } else {
                System.out.println("Palabra: " + s + " - Regla: " + definirGramatica().get(s));
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


