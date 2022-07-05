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

import java.util.Observable;
import java.util.Observer;

import static edu.fiuba.algo3.App.SCREEN_HEIGHT;
import static edu.fiuba.algo3.App.SCREEN_WIDTH;
import static edu.fiuba.algo3.vista.VehiculoView.MULTIPLICADOR;

public class JuegoView implements Observer {

    Stage stage;
    Juego juego;

    Esquina limite;
    String nickname;

    Rectangle mapa;

    VehiculoView vehiculoView;

    MovimientosTextView movimientosTextView;

    RankingView rankingView;

    Group layout;

    KeysController keysController;

    public JuegoView(Stage stage){

        this.stage = stage;
        juego = new Juego();
        pantallaInicio();

    }

    private void pantallaInicio(){

        Group inicio = new Group();
        Button button = new Button("COMIENZA EL JUEGO");
        button.setLayoutX(320);
        button.setLayoutY(280);

        TextField nickname = new TextField("Ingresa tu nickname");
        nickname.setLayoutX(310);
        nickname.setLayoutY(80);

        TextField fila = new TextField("Ingresa fila");
        fila.setLayoutX(200);
        fila.setLayoutY(180);

        TextField columna = new TextField("Ingresa columna");
        columna.setLayoutX(400);
        columna.setLayoutY(180);

        Text text = new Text("Bienvenido! Como te llamas?");
        text.setX(300);
        text.setY(60);

        Text text2 = new Text("Elije la dimenciones del mapa (Ojo! Solo numeros pares)");
        text2.setX(220);
        text2.setY(160);

        Text text3 = new Text("Llega a la meta en la menor cantidad de movimientos posibles!");
        text3.setX(220);
        text3.setY(250);

        inicio.getChildren().add(nickname);
        inicio.getChildren().add(fila);
        inicio.getChildren().add(columna);
        inicio.getChildren().add(button);
        inicio.getChildren().add(text);
        inicio.getChildren().add(text2);
        inicio.getChildren().add(text3);

        
        mostrarPantalla(inicio, false);

        button.setOnAction(value ->{

            if (comprobarEntrada(fila.getText(),columna.getText())) {
                System.out.println("GOLA");

                int filaInt = Integer.parseInt(fila.getText());
                int columnaInt = Integer.parseInt(columna.getText());


                limite = new Esquina(filaInt, columnaInt);
                this.nickname = nickname.getText();

                juego.addObserver(this);
                juego.asignarNickname(this.nickname);
                juego.nuevaPartida(limite);
                this.pantallaJuego();
            }
            else {
                Text advertencia = new Text("Dije numeros pares!");
                advertencia.setX(600);
                advertencia.setY(200);
                advertencia.setFill(Color.RED);
                inicio.getChildren().add(advertencia);
            }
            });

    }
    private boolean comprobarEntrada(String fila, String columna){
        if(esNumero(fila) && esNumero(columna)){
            int filaInt = Integer.parseInt(fila);
            int columnaInt = Integer.parseInt(columna);

            if (esPar(filaInt) && esPar(columnaInt)){
                return true;
            }
        }
        return false;
    }

    private Boolean esNumero(String entrada){
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    private Boolean esPar(Integer entrada){
        if (entrada % 2 == 0){
            return true;
        }
        return false;
    }

    private Scene mostrarPantalla(Group layout, Boolean pantallaCompleta){

        Scene scene = new Scene(layout, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        stage.setScene(scene);
        stage.setFullScreen(pantallaCompleta);
        stage.show();
        return scene;
    }

    private void pantallaJuego(){
        layout = new Group();
        crearMapa(layout);
        dibujarCaminosBlancos(layout);
 
        crearCaminosView(layout);

        vehiculoView = new VehiculoView(juego.obtenerVehiculo(), layout, mapa);
        dibujarMeta(layout);

        movimientosTextView = new MovimientosTextView(juego.obtenerVehiculo(),layout);

        rankingView = new RankingView(juego.obtenerRanking(),layout);

        Scene sceneActual = mostrarPantalla(layout, true);

        keysController = new KeysController();
        keysController.leerInputs(sceneActual,juego);
    }
    private void crearMapa(Group layout){
        mapa = new Rectangle(limite.columna * MULTIPLICADOR, limite.fila* MULTIPLICADOR);
        mapa.setX(SCREEN_WIDTH/2 - mapa.getWidth()/2); //los pongo en el centro
        mapa.setY(SCREEN_HEIGHT/2 - mapa.getHeight()/2);
        layout.getChildren().add(mapa);
    }

    private void dibujarCaminosBlancos(Group layout){
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



    private void dibujarHasGanado() {

        Rectangle hasGanadoFondo = new Rectangle(350, 100, 200, 200);
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

        button.setOnAction(value -> {
            pantallaInicio();
        });
    }
        @Override
    public void update(Observable o, Object arg) {
        dibujarHasGanado();
        keysController.bloquearControles();
    }
}
