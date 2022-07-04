package Main.Modelo;

import java.util.Map;

public class AnalizadorSemantico {

    private Map<String, String> tablaSimbolos() {
        Map<String, String> tablaSimbolos = new java.util.HashMap<>();
        String[] palabra = {"ALFA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT", "GOLF", "HOTEL", "INDIA", "JULIET", "KILO", "LIMA", "MIKE", "NOVEMBER", "ÑANDU", "OSCAR", "PAPA", "QUEBEQ", "ROMEO", "SIERRA", "TANGO", "UNIFORM", "VICTOR", "WHISKEY", "X-RAY", "YANKIE", "ZULU", "CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE"};
        String[] letra = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < palabra.length; i++) {
            tablaSimbolos.put(palabra[i], letra[i]);
        }
        tablaSimbolos.put(".", " ");

        return tablaSimbolos;
    }

    public String[] separar(String cadena) {
        return cadena.split(" ");
    }

    public String traducir(String cadena) {
        String[] palabras = separar(cadena);
        StringBuilder traduccion = new StringBuilder();
        Map<String, String> tablaSimbolos = tablaSimbolos();
        for (String s : palabras) {
            traduccion.append(tablaSimbolos.get(s));
        }
        return traduccion.toString();
    }

}
