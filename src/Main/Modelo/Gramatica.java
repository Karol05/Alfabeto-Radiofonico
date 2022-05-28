package Main.Modelo;

import java.util.ArrayList;
import java.util.Map;

public class Gramatica {

    private ArrayList<String> nombreRegla;
    private ArrayList<String> valorRegla;

    public Gramatica(){
        nombreRegla = new ArrayList<>();
        valorRegla = new ArrayList<>();
    }

    public void agregarRegla(String nombre, String valor){
        nombreRegla.add(nombre);
        valorRegla.add(valor);
    }

    public ArrayList<String> getNombreRegla() {
        return nombreRegla;
    }

    public void setNombreRegla(ArrayList<String> nombreRegla) {
        this.nombreRegla = nombreRegla;
    }

    public ArrayList<String> getValorRegla() {
        return valorRegla;
    }

    public void setValorRegla(ArrayList<String> valorRegla) {
        this.valorRegla = valorRegla;
    }

    public String getNombreRegla(int i){
        return nombreRegla.get(i);
    }

    public String getValorRegla(int i){
        return valorRegla.get(i);
    }

    public int getCantidadReglas(){
        return nombreRegla.size();
    }


    public boolean buscaRegla(String nombre, ArrayList<String> valores){
        Map<String, String> map = new java.util.HashMap<>();
        for (String s : valores) {
            if (s.equals(nombre)) {
                return true;
            }
        }
        return false;
    }
}

