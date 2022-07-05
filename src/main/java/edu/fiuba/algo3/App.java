package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.JuegoView;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static final int MULTIPLICADOR = 50;
    public static final int SCREEN_WIDTH = 1620;
    public static final int SCREEN_HEIGHT = 720;

    Group layout = new Group();
    Juego juego = new Juego();
    Scene sceneInicio;
    Scene sceneJuego;
    Esquina limite;
    Esquina posicionMeta;
    Rectangle mapa;
    Text movimientos;
    VehiculoView vehiculoView;

    @Override
    public void start(Stage stage) {

        JuegoView juegoView = new JuegoView(stage);

        /*
        Group inicio = new Group();
        Button button = new Button("COMIENZA EL JUEGO");
        button.setLayoutX(320);
        button.setLayoutY(SCREEN_HEIGHT /4 - button.getHeight()/2);

        TextField textField = new TextField("Ingresa tu nickname");
        textField.setLayoutX(310);
        textField.setLayoutY(100);
        inicio.getChildren().add(textField);
        inicio.getChildren().add(button);



        sceneInicio = new Scene(inicio, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        stage.setScene(sceneInicio);
        stage.show();


        button.setOnAction(value ->{
            String nickname = textField.getText();
            nuevoJuego(stage, nickname);
        });


         */
    }

    public static void main(String[] args) {
        launch();
    }











    private void dibujarRanking(){
        int i = 20;
        Rectangle fondoRanking = new Rectangle(100,100,200,600);
        fondoRanking.setFill(Color.WHITE);
        fondoRanking.setStroke(Color.SALMON);
        fondoRanking.setStrokeWidth(5);
        layout.getChildren().add(fondoRanking);

        Text titulo = new Text(110,150,"Highscores: ");
        titulo.setFont(Font.font(30));
        layout.getChildren().add(titulo);
        for (Puntaje puntaje : juego.obtenerRanking().puntajes){
            Text nuevoPuntajeTexto = new Text(110,160 + i,puntaje.getNombre()+": " + puntaje.getMovimientos() + "\n");
            nuevoPuntajeTexto.setFont(Font.font(20));
            nuevoPuntajeTexto.setFill(Color.BLACK);
            layout.getChildren().add(nuevoPuntajeTexto);
            i+= 20;
        }
    }

    private void nuevoJuego(Stage stage, String nickname){

        juego.asignarNickname(nickname);



        vehiculoView = new VehiculoView(juego.obtenerVehiculo(), layout, mapa);


        dibujarRanking();

        sceneJuego = new Scene(layout, SCREEN_WIDTH, SCREEN_HEIGHT);


        stage.setScene(sceneJuego);
        stage.show();
    }

    private void hasGanado(Stage stage){

        Rectangle hasGanadoFondo = new Rectangle(350,100,200,200);
        hasGanadoFondo.setFill(Color.WHITE);
        hasGanadoFondo.setStroke(Color.GREEN);
        hasGanadoFondo.setStrokeWidth(5);
        layout.getChildren().add(hasGanadoFondo);

        Text text = new Text(370, 140, "Has ganado!");
        text.setFont(Font.font(30));
        text.setFill(Color.GREEN);

        Button button = new Button("JUGAR OTRA VEZ");
        button.setLayoutX(390);
        button.setLayoutY(200);

        layout.getChildren().add(text);
        layout.getChildren().add(button);

        dibujarRanking();

        button.setOnAction(value ->{
            layout = new Group();
            stage.setScene(sceneInicio);
        });



    }

}