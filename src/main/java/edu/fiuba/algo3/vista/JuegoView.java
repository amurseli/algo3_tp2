package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controller.KeysController;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static edu.fiuba.algo3.App.SCREEN_HEIGHT;
import static edu.fiuba.algo3.App.SCREEN_WIDTH;
import static edu.fiuba.algo3.vista.VehiculoView.MULTIPLICADOR;

public class JuegoView {

    Stage stage;
    Juego juego;

    Esquina limite;
    String nickname;

    Rectangle mapa;

    VehiculoView vehiculoView;

    MovimientosTextView movimientosTextView;


    public JuegoView(Stage stage){

        this.stage = stage;
        pantallaInicio();

    }

    private void pantallaInicio(){

        Group inicio = new Group();
        Button button = new Button("COMIENZA EL JUEGO");
        button.setLayoutX(320);
        button.setLayoutY(SCREEN_HEIGHT /4 - button.getHeight()/2);

        TextField nickname = new TextField("Ingresa tu nickname");
        nickname.setLayoutX(310);
        nickname.setLayoutY(100);

        TextField fila = new TextField("Ingresa fila");
        fila.setLayoutX(110);
        fila.setLayoutY(100);

        TextField columna = new TextField("Ingresa columna");
        columna.setLayoutX(410);
        columna.setLayoutY(100);

        inicio.getChildren().add(nickname);
        inicio.getChildren().add(fila);
        inicio.getChildren().add(columna);
        inicio.getChildren().add(button);

        //TODO: COMPROBAR ENTRADA DE INT


        mostrarPantalla(inicio);

        button.setOnAction(value ->{
            int filaInt = Integer.parseInt(fila.getText());
            int columnaInt = Integer.parseInt(columna.getText());

            limite = new Esquina(filaInt,columnaInt);
            this.nickname = nickname.getText();

            juego = new Juego();
            juego.asignarNickname(this.nickname);
            juego.nuevaPartida(limite);
            this.pantallaJuego();
        });
    }

    private Scene mostrarPantalla(Group layout){

        Scene scene = new Scene(layout, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        return scene;
    }

    private void pantallaJuego(){
        Group layout = new Group();
        crearMapa(layout);
        crearCaminos(layout);
 
        crearCaminosView(layout);

        vehiculoView = new VehiculoView(juego.obtenerVehiculo(), layout, mapa);
        dibujarMeta(layout);

        movimientosTextView = new MovimientosTextView(juego.obtenerVehiculo(),layout);

        dibujarRanking(layout);

        Scene sceneActual = mostrarPantalla(layout);

        KeysController keysController = new KeysController();
        keysController.leerInputs(sceneActual,juego);
    }
    private void crearMapa(Group layout){
        mapa = new Rectangle(limite.columna * MULTIPLICADOR, limite.fila* MULTIPLICADOR);
        mapa.setX(SCREEN_WIDTH/2 - mapa.getWidth()/2); //los pongo en el centro
        mapa.setY(SCREEN_HEIGHT/2 - mapa.getHeight()/2);
        layout.getChildren().add(mapa);
    }

    private void crearCaminos(Group layout){
        for (int i = 0; i < 30 ; i++){
            Rectangle caminitoHorizontal = new Rectangle(SCREEN_WIDTH, 20);
            Rectangle caminitoVertical = new Rectangle(20, SCREEN_HEIGHT);
            caminitoHorizontal.setFill(Paint.valueOf("white"));
            caminitoVertical.setFill(Paint.valueOf("white"));
            caminitoHorizontal.setY(i * MULTIPLICADOR + 10);
            caminitoVertical.setX(i* MULTIPLICADOR + 10);
            layout.getChildren().add(caminitoHorizontal);
            layout.getChildren().add(caminitoVertical);
        }
    }

    private void dibujarMeta(Group layout){
        Image meta = new Image("/meta.png",30,30,true,true);
        ImageView metaView = new ImageView(meta);
        Rectangle rectangle = new Rectangle(25,25);
        rectangle.setFill(Color.WHITE);
        rectangle.setX(SCREEN_WIDTH / 2 - mapa.getWidth()/2 +  (juego.obtenerMeta().columna)* MULTIPLICADOR);
        rectangle.setY(SCREEN_HEIGHT / 2 - mapa.getHeight()/2 + (juego.obtenerMeta().fila)* MULTIPLICADOR);

        metaView.setX(SCREEN_WIDTH / 2 - mapa.getWidth()/2 +  (juego.obtenerMeta().columna)* MULTIPLICADOR);
        metaView.setY(SCREEN_HEIGHT / 2 - mapa.getHeight()/2 + (juego.obtenerMeta().fila)* MULTIPLICADOR);

        layout.getChildren().add(rectangle);
        layout.getChildren().add(metaView);

    }

    private void crearCaminosView(Group layout){

        ListadoCaminos listadoCaminos = juego.obtenerCaminos();

        for (Camino camino : listadoCaminos.caminosConEfectos) {
            CaminoView caminoView = new CaminoView(camino,layout,mapa);
        }
    }



    private void dibujarRanking(Group layout){
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

}