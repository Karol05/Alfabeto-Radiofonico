package Main.Modelo;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;



public class AnalizadorSintactico {

    Map diccionario = diccionario();
    private int iterador = 0;

    public Stack<Terminal> rellenar(Terminal terminal) {
        Terminal $ = new Terminal("$", true);
        Stack<Terminal> pila = new Stack<>();
        pila.push($);
        pila.push(terminal);
        return pila;
    }

    public Map diccionario() {
        int i = 0;
        Map<Key, Integer> map = new java.util.HashMap<>();
        String[] nombreComplemento = {"ALFA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT", "GOLF", "HOTEL", "INDIA", "JULIET", "KILO", "LIMA", "MIKE", "NOVEMBER", "ÑANDU", "OSCAR", "PAPA", "QUEBEQ", "ROMEO", "SIERRA", "TANGO", "UNIFORM", "VICTOR", "WHISKEY", "X-RAY", "YANKIE", "ZULU", "CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE"};
        for (String s : nombreComplemento) {
            map.put(new Key(s, "PALABRA"), i);
            i++;
        }
        map.put(new Key("$", "PUNTO"), null);
        for (String s : nombreComplemento) {
            map.put(new Key(s, "PUNTO"), null);
        }
        for (String s : nombreComplemento) {
            map.put(new Key(s, "CO"), i);
        }
        i++;
        map.put(new Key("$", "CO"), null);
        map.put(new Key(".", "PUNTO"), i);
        map.put(new Key(".", "CO"), null);
        return map;
    }

    public String[] separar(String cadena) {
        cadena = cadena + " $";
        return cadena.split(" ");
    }

    public Stack<Terminal> analizar(String cadena) {
        String[] palabras = separar(cadena);
        Stack<Terminal> pila = rellenar(getTerminal());
        Terminal terminal;

        do {
            terminal = pila.peek();
            if (terminal.isTerminal() || terminal.getNombre().equals("$")) {
                if (terminal.getNombre().equals(palabras[iterador])) {
                    pila.pop();
                    iterador++;
                } else {
                    System.out.println("Error en la cadena cerca de: " + palabras[iterador]);
                    return pila;
                }
            } else {
                if (existKeys(terminal.getNombre(), palabras)) {
                    pila.pop();
                    produccion(palabras[iterador],terminal, pila);
                } else {
                    System.out.println("Error en la cadena cerca de " + palabras[iterador]);
                    return pila;
                }
            }
        } while (!terminal.getNombre().equals("$"));
        System.out.println("Cadena correcta");
        return pila;
    }

    private boolean existKeys(String terminal, String[] cadena) {
        if (diccionario.containsKey(new Key(cadena[iterador], terminal))) {
            if(cadena[iterador].equals(".") && cadena[iterador-1].equals(".")){
                return false;
            }
            return true;
        }
        return false;
    }

    public void produccion(String cadena, Terminal terminal, Stack<Terminal> pila) {
        if (diccionario().get(new Key(cadena, terminal.getNombre())) != null) {
            int i = (int) diccionario().get(new Key(cadena, terminal.getNombre()));
            for (int j = terminal.getTerminales().get(i).size() - 1; j >= 0; j--) {
                pila.push(terminal.getTerminales().get(i).get(j));
            }
        }
    }

    public Terminal getTerminal() {
        ArrayList<Terminal> complementoCo = new ArrayList<>();
        ArrayList<Terminal> complementoPunto = new ArrayList<>();

        ArrayList<ArrayList<Terminal>> opciones = new ArrayList<>();
        ArrayList<Terminal> complemento = new ArrayList<>();
        String[] nombreComplemento = {"ALFA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT", "GOLF", "HOTEL", "INDIA", "JULIET", "KILO", "LIMA", "MIKE", "NOVEMBER", "ÑANDU", "OSCAR", "PAPA", "QUEBEQ", "ROMEO", "SIERRA", "TANGO", "UNIFORM", "VICTOR", "WHISKEY", "X-RAY", "YANKIE", "ZULU", "CERO", "UNO", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE"};


        Terminal co = new Terminal("CO", false, opciones);
        Terminal punto = new Terminal("PUNTO", false, opciones);
        Terminal puntoTerminal = new Terminal(".", true);


        for (String s : nombreComplemento) {
            Terminal t = new Terminal(s, true);
            complemento.add(t);
            complemento.add(co);
            complemento.add(punto);
            opciones.add(complemento);
            complemento = new ArrayList<>();
        }

        Terminal palabra = new Terminal("PALABRA", false, opciones);

        complementoCo.add(palabra);
        complementoCo.add(co);
        opciones.add(complementoCo);

        complementoPunto.add(puntoTerminal);
        complementoPunto.add(co);
        opciones.add(complementoPunto);

        return palabra;
    }

    public String getCadena(File textFile) throws FileNotFoundException {
        String cadena = "";
        Scanner scanner = new Scanner(textFile);
        while (scanner.hasNextLine()) {
            cadena += scanner.nextLine();
        }
        return cadena;
    }

}



