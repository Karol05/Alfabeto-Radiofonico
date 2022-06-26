package Main;

import Main.Modelo.AnalizadorSintactico;
import Main.Modelo.Terminal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Vista/VistaAnalizador.fxml"));
        primaryStage.setTitle("Alfabeto");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);
        AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico();
        Stack<Terminal>pila = analizadorSintactico.analizar("ALFA BRAVO");
        for (int i =0; i<pila.size(); i++) {
            System.out.println(pila.get(i).getNombre());
        }
    }
}