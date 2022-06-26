package Main.Modelo;

import java.util.ArrayList;

public class Terminal {

    private String nombre;
    private Boolean terminal;
    private ArrayList<ArrayList<Terminal>> terminales;

    public Terminal() {
    }

    public Terminal(String nombre, Boolean terminal) {
        this.nombre = nombre;
        this.terminal = terminal;
        this.terminales = new ArrayList<>();
    }

    public Terminal(String nombre, Boolean terminal, ArrayList<ArrayList<Terminal>> terminales) {
        this.nombre = nombre;
        this.terminal = terminal;
        this.terminales = terminales;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getTerminal() {
        return terminal;
    }

    public ArrayList<ArrayList<Terminal>> getTerminales() {
        return terminales;
    }

    public void setTerminales(ArrayList<ArrayList<Terminal>> terminales) {
        this.terminales = terminales;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTerminal(Boolean terminal) {
        this.terminal = terminal;
    }

    public boolean isTerminal() {
        return this.terminal;
    }

}