package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Direcciones.*;
import edu.fiuba.algo3.modelo.efectos.obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.efectos.sorpresas.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import edu.fiuba.algo3.vista.ObtaculoView;
import edu.fiuba.algo3.vista.SorpresaView;
import edu.fiuba.algo3.vista.VehiculoView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
public class App extends Application implements EventHandler<KeyEvent> {
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

    }

    @Override
    public void handle(KeyEvent event){
        System.out.println(event.getCode().isArrowKey());
    }

    public static void main(String[] args) {
        launch();
    }

    private void leerInputs(Scene scene, Juego juego, VehiculoView vehiculoView, Stage stage, Text movimientos){
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.W){

                juego.mover(new Arriba());
                vehiculoView.actualizarPosicion(juego.obtenerVehiculo(),180);

            }
            if(event.getCode() == KeyCode.S){
                juego.mover(new Abajo());
                vehiculoView.actualizarPosicion(juego.obtenerVehiculo(),0);

            }
            if(event.getCode() == KeyCode.A){
                juego.mover(new Izquierda());
                vehiculoView.actualizarPosicion(juego.obtenerVehiculo(),90);

            }
            if(event.getCode() == KeyCode.D){
                juego.mover(new Derecha());
                vehiculoView.actualizarPosicion(juego.obtenerVehiculo(),270);

            }

            movimientos.setText("Movimientos: " + juego.obtenerMovimientosRealizados());

            if (juego.finDeJuego){
                hasGanado(stage);
            }
        });

    }



    private void crearCiudadNueva(){
        //JUEGO
        juego.finDeJuego = false;
        juego.crearCiudad(new Esquina(10,10),new Esquina(1,9),new Vehiculo(new Auto(), new Esquina(5,1)));
        limite = juego.obtenerLimite();
        posicionMeta = juego.obtenerMeta();
    }

    private void crearMapa(){
        mapa = new Rectangle(limite.columna * MULTIPLICADOR, limite.fila* MULTIPLICADOR);
        mapa.setX(SCREEN_WIDTH/2 - mapa.getWidth()/2); //los pongo en el centro
        mapa.setY(SCREEN_HEIGHT/2 - mapa.getHeight()/2);
        layout.getChildren().add(mapa);
    }

    private void crearCaminos(){
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

    private void dibujarMeta(){
        Image meta = new Image("/meta.png",30,30,true,true);
        ImageView metaView = new ImageView(meta);
        Rectangle rectangle = new Rectangle(25,25);
        rectangle.setFill(Color.WHITE);
        rectangle.setX(SCREEN_WIDTH / 2 - mapa.getWidth()/2 +  (posicionMeta.columna)* MULTIPLICADOR);
        rectangle.setY(SCREEN_HEIGHT / 2 - mapa.getHeight()/2 + (posicionMeta.fila)* MULTIPLICADOR);

        metaView.setX(SCREEN_WIDTH / 2 - mapa.getWidth()/2 +  (posicionMeta.columna)* MULTIPLICADOR);
        metaView.setY(SCREEN_HEIGHT / 2 - mapa.getHeight()/2 + (posicionMeta.fila)* MULTIPLICADOR);

        layout.getChildren().add(rectangle);
        layout.getChildren().add(metaView);

    }

    private void crearObstaculos(){
        for (int i = 0; i < 20; i++){

            GeneradorRandom generadorRandom = new GeneradorRandom();
            Camino camino = new Camino(generadorRandom.generarEsquina(limite), generadorRandom.generarDireccion());
            Obstaculo obtaculo = generadorRandom.generarObstaculo();
            camino.agregrarEfecto(obtaculo);
            juego.agregarCamino(camino);
        }
    }

    private void dibujarObstaculos(Juego juego, Group layout, Rectangle mapa){

        ListadoCaminos caminosConEfectos = juego.obtenerCaminos();

        for (Camino camino : caminosConEfectos.caminosConEfectos) {

            for(Obstaculo obstaculo : camino.obstaculos) {
                ObtaculoView obtaculoView = new ObtaculoView(layout,mapa,camino);
                obstaculo.mostrarImagen(obtaculoView);
            }
        }
    }

    private void crearSorpresas(){
        for (int i = 0; i < 20 ; i++){
            GeneradorRandom generadorRandom = new GeneradorRandom();
            Camino camino = new Camino(generadorRandom.generarEsquina(limite), generadorRandom.generarDireccion());
            Sorpresa sorpresa = generadorRandom.generarSorpresa();
            camino.agregrarEfecto(sorpresa);
            juego.agregarCamino(camino);
        }
    }

    private void dibujarSorpresas(Juego juego, Group layout, Rectangle mapa){

        ListadoCaminos caminosConEfectos = juego.obtenerCaminos();

        for (Camino camino : caminosConEfectos.caminosConEfectos) {

            for(Sorpresa sorpresa : camino.sospresas) {
                SorpresaView sorpresaView = new SorpresaView(layout,mapa,camino);
                sorpresaView.mostrarImagen();
            }
        }
    }

    private void dibujarMovimientos(){
        Rectangle fondoMovimientos = new Rectangle(100,40,200,45);
        fondoMovimientos.setFill(Color.WHITE);
        fondoMovimientos.setStroke(Color.BLUE);
        fondoMovimientos.setStrokeWidth(5);

        movimientos = new Text(110,70,"Movimientos: " + juego.obtenerMovimientosRealizados());
        movimientos.setFont(Font.font(20));
        movimientos.setFill(Color.BLACK);

        layout.getChildren().add(fondoMovimientos);
        layout.getChildren().add(movimientos);
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

        crearCiudadNueva();

        crearMapa();

        crearCaminos();

        crearObstaculos();
        dibujarObstaculos(juego,layout,mapa);

        crearSorpresas();
        dibujarSorpresas(juego,layout,mapa);

        vehiculoView = new VehiculoView(juego.obtenerVehiculo(), layout, mapa);

        dibujarMeta();

        dibujarMovimientos();
        dibujarRanking();

        sceneJuego = new Scene(layout, SCREEN_WIDTH, SCREEN_HEIGHT);

        leerInputs(sceneJuego,juego,vehiculoView,stage,movimientos);

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