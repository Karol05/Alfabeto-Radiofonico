package Main.Controlador;

import Main.Modelo.AnalizadorLexico;
import Main.Modelo.AnalizadorSintactico;
import Main.Modelo.Terminal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class AnalizadorControlador {

    @FXML
    private TextField cadenaIngresada;

    @FXML
    private Label resultado;




    public void initialize() {

    }


    @FXML
    File abrirDocumento() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Archivo");
        File textFile;
        try
        {

            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("TXT", "*.txt")
            );


            textFile = fileChooser.showOpenDialog(null);
            return textFile;
        }catch (Exception e)
        {
            System.out.println("Error al abrir el archivo");
        }


        return null;
    }


    @FXML
    void AnalizarArchivo(ActionEvent event) throws IOException {
        AnalizadorLexico analizadorLexico = new AnalizadorLexico();
        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico();
        File documento = abrirDocumento();
        Stack<Terminal> pila = new Stack<>();
        try {
            String[] textoSeparado = analizadorLexico.separarDocumento(documento);
            ArrayList<String> resultadoAnalisis = analizadorLexico.analizarDocumento(textoSeparado);
            if(resultadoAnalisis.isEmpty())
            {
                resultado.setText("No se encontraron errores");
            }
            else
            {
                if(resultadoAnalisis.size() == 1)
                {
                    resultado.setText("Se encontro un error: " + resultadoAnalisis.get(0) + " \nNo se reconoce");
                }else
                {
                    resultado.setText("Se encontraron " + resultadoAnalisis.size() + " errores: " + resultadoAnalisis + " \nNo se reconocen");
                }

            }
        }catch (Exception e)
        {
            System.out.println("Error al abrir el archivo");
        }
        pila = analizadorSintactico.analizar(analizadorSintactico.getCadena(documento));
        for (int i =0; i<pila.size(); i++) {
            System.out.println(pila.get(i).getNombre());
        }
    }



    @FXML
    void analizarTexto(ActionEvent event) {
        String textoIngresado = cadenaIngresada.getText();
        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico();
        AnalizadorLexico analizadorLexico = new AnalizadorLexico();
        Stack<Terminal> pila = new Stack<>();
        if(textoIngresado.isEmpty())
        {
            resultado.setText("No se ingreso ningun texto");
        }
        else
        {
            ArrayList<String> resultadoAnalisis = analizadorLexico.analizarTexto(textoIngresado);
            if(resultadoAnalisis.isEmpty())
            {
                resultado.setText("No se encontraron errores");
            }
            else
            {
                if(resultadoAnalisis.size() == 1)
                {
                    resultado.setText("Se encontro un error: " + resultadoAnalisis.get(0) + " \nNo se reconoce");
                }else
                {
                    resultado.setText("Se encontraron " + resultadoAnalisis.size() + " errores: " + resultadoAnalisis + " \nNo se reconocen");
                }
            }
        }
        pila = analizadorSintactico.analizar(textoIngresado);

        for (int i =0; i<pila.size(); i++) {
            System.out.println(pila.get(i).getNombre());
        }

    }

}
