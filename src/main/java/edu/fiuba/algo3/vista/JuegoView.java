package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controller.KeysController;
import edu.fiuba.algo3.excepciones.EntradaInvalidaMapa;
import edu.fiuba.algo3.excepciones.EntradaInvalidaNickname;
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

    public static final int RANGO_MINIMO_MAPA = 2;
    public static final int RANGO_MAXIMO_MAPA = 14;
    public static final int BOTTON_INICIO_X = 320;
    public static final int BOTTON_INICIO_Y = 280;
    public static final int TEXT_FIELD_NICKNAME_X = 310;
    public static final int TEXT_FIELD_NICKNAME_Y = 80;
    public static final int TEXT_FIELD_FILA_X = 200;
    public static final int TEXT_FIELD_FILA_Y = 180;
    public static final int TEXT_FIELD_COLUMNA_X = 400;
    public static final int TEXT_FIELD_COLUMNA_Y = 180;
    public static final int BIENVENIDO_X = 300;
    public static final int BIENVENIDO_Y = 60;
    public static final int MENSAJE_DIMENSION_X = 220;
    public static final int MENSAJE_DIMENSION_Y = 140;
    public static final int ACLARACION_DIMENSION_X = 300;
    public static final int ACLARACION_DIMENSION_Y = 160;
    public static final int MENSAJE_FINAL_X = 220;
    public static final int MENSAJE_FINAL_Y = 250;
    public static final int ADVERTENCIA_1_X = 500;
    public static final int ADVERTENCIA_1_Y = 95;
    public static final int ADVERTENCIA_2_X = 600;
    public static final int ADVERTENCIA_2_Y = 200;
    public static final int MAXIMA_CANTIDAD_DE_CARACTERES = 12;
    public static final int MINIMA_CANTIDAD_DE_CARACTERES = 0;
    public static final int DESFASE = 10;
    public static final int ANCHO_CAMINO = 20;
    public static final int TAMANIO_IMAGEN_META = 30;
    public static final int TAMANIO_FONDO_META = 25;
    public static final int COMO_DIBUJAR_X = 100;
    public static final int COMO_DIBUJAR_Y = 450;
    public static final int COMO_DIBUJAR_ANCHO = 210;
    public static final int COMO_DIBUJAR_ALTO = 270;
    public static final int ANCHO_STROKE = 5;
    public static final int TITULO_COMO_JUGAR_X = 110;
    public static final int TITULO_COMO_JUGAR_Y = 490;
    public static final int TAMANIO_FUENTE_TITULO = 30;
    public static final int POZOS_X = 105;
    public static final int FLECHITAS_TEXT_X = 105;
    public static final int FLECHITAS_TEXT_Y = 520;
    public static final int POLICIAS_X = 105;
    public static final int POLICIAS_Y = 540;
    public static final int PIQUETES_X = 105;
    public static final int PIQUETES_Y = 575;
    public static final int POZOS_Y = 595;
    public static final int SORPRESAS_X = 105;
    public static final int SORPRESAS_Y = 615;
    public static final int VEHICULOS_X = 105;
    public static final int VEHICULOS_Y = 650;
    public static final int HAS_GANADO_X = 350;
    public static final int HAS_GANADO_Y = 100;
    public static final int HAS_GANADO_ANCHO = 200;
    public static final int HAS_GANADO_ALTO = 200;
    public static final int HAS_GANADO_TEXT_X = 370;
    public static final int HAS_GANADO_TEXT_Y = 140;
    public static final int HAS_GANADO_BUTTON_X = 390;
    public static final int HAS_GANADO_BUTTON_Y = 200;
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
        button.setLayoutX(BOTTON_INICIO_X);
        button.setLayoutY(BOTTON_INICIO_Y);

        TextField nickname = new TextField("Ingresa tu nickname");
        nickname.setLayoutX(TEXT_FIELD_NICKNAME_X);
        nickname.setLayoutY(TEXT_FIELD_NICKNAME_Y);

        TextField fila = new TextField("Ingresa fila");
        fila.setLayoutX(TEXT_FIELD_FILA_X);
        fila.setLayoutY(TEXT_FIELD_FILA_Y);

        TextField columna = new TextField("Ingresa columna");
        columna.setLayoutX(TEXT_FIELD_COLUMNA_X);
        columna.setLayoutY(TEXT_FIELD_COLUMNA_Y);

        Text text = new Text("Bienvenido! Como te llamas?");
        text.setX(BIENVENIDO_X);
        text.setY(BIENVENIDO_Y);

        Text text2 = new Text("Elije la dimenciones del mapa (Ojo! Solo numeros pares)");
        text2.setX(MENSAJE_DIMENSION_X);
        text2.setY(MENSAJE_DIMENSION_Y);

        Text text4 = new Text("Minimo 2x2 y Maximo 14x14");
        text4.setX(ACLARACION_DIMENSION_X);
        text4.setY(ACLARACION_DIMENSION_Y);

        Text text3 = new Text("Llega a la meta en la menor cantidad de movimientos posibles!");
        text3.setX(MENSAJE_FINAL_X);
        text3.setY(MENSAJE_FINAL_Y);

        inicio.getChildren().add(nickname);
        inicio.getChildren().add(fila);
        inicio.getChildren().add(columna);
        inicio.getChildren().add(button);
        inicio.getChildren().add(text);
        inicio.getChildren().add(text2);
        inicio.getChildren().add(text3);
        inicio.getChildren().add(text4);


        mostrarPantalla(inicio, false);

        button.setOnAction(value ->{

            if (comprobarEntradaTamanioMapa(fila.getText(),columna.getText())) {

                int filaInt = Integer.parseInt(fila.getText());
                int columnaInt = Integer.parseInt(columna.getText());

                limite = new Esquina(filaInt, columnaInt);
                this.nickname = nickname.getText();

                if(comprobarEntradaNickname(this.nickname)){
                    juego.addObserver(this);
                    juego.asignarNickname(this.nickname);
                    juego.nuevaPartida(limite);
                    this.pantallaJuego();
                }
                else {
                    try {
                        throw new EntradaInvalidaNickname("Entrada invalida nickname");
                    } catch (EntradaInvalidaNickname e) {
                        Text advertencia = new Text("Minimo 1 caracter. Maximo 12");
                        advertencia.setX(ADVERTENCIA_1_X);
                        advertencia.setY(ADVERTENCIA_1_Y);
                        advertencia.setFill(Color.RED);
                        inicio.getChildren().add(advertencia);
                    }
                }

            }
            else {
                try {
                    throw new EntradaInvalidaMapa("Entrada invalida mapa");
                } catch (EntradaInvalidaMapa e) {
                    Text advertencia = new Text("Entrada incorrecta!");
                    advertencia.setX(ADVERTENCIA_2_X);
                    advertencia.setY(ADVERTENCIA_2_Y);
                    advertencia.setFill(Color.RED);
                    inicio.getChildren().add(advertencia);
                }
            }
            });

    }
    private boolean comprobarEntradaNickname(String nickname){
        return (nickname.length() <= MAXIMA_CANTIDAD_DE_CARACTERES && nickname.length() > MINIMA_CANTIDAD_DE_CARACTERES);
    }

    private boolean comprobarEntradaTamanioMapa(String fila, String columna){
        if(esNumero(fila) && esNumero(columna)){
            int filaInt = Integer.parseInt(fila);
            int columnaInt = Integer.parseInt(columna);

            if (esPar(filaInt) && esPar(columnaInt)){
                if(rangoCorrecto(filaInt,columnaInt)){
                    return true;
                }
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
        if(entrada % 2 == 0){
            return true;
        }
        return false;
    }

    private Boolean rangoCorrecto(Integer fila, Integer columna){
        if(fila < RANGO_MINIMO_MAPA || columna < RANGO_MINIMO_MAPA || fila > RANGO_MAXIMO_MAPA || columna > RANGO_MAXIMO_MAPA){
            return false;
        }
        return true;
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

        dibujarComoJugar();

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
            Rectangle caminitoHorizontal = new Rectangle(SCREEN_WIDTH, ANCHO_CAMINO);
            Rectangle caminitoVertical = new Rectangle(ANCHO_CAMINO, SCREEN_HEIGHT);
            caminitoHorizontal.setFill(Paint.valueOf("white"));
            caminitoVertical.setFill(Paint.valueOf("white"));
            caminitoHorizontal.setY(i * MULTIPLICADOR + DESFASE);
            caminitoVertical.setX(i* MULTIPLICADOR + DESFASE);
            layout.getChildren().add(caminitoHorizontal);
            layout.getChildren().add(caminitoVertical);
        }
    }

    private void dibujarMeta(Group layout){
        Image meta = new Image("/meta.png", TAMANIO_IMAGEN_META,TAMANIO_IMAGEN_META,true,true);
        ImageView metaView = new ImageView(meta);
        Rectangle rectangle = new Rectangle(TAMANIO_FONDO_META,TAMANIO_FONDO_META);
        rectangle.setFill(Color.WHITE);
        rectangle.setX(SCREEN_WIDTH / 2 - mapa.getWidth()/2 +  (juego.obtenerMeta().columna)* MULTIPLICADOR);
        rectangle.setY(SCREEN_HEIGHT / 2 - mapa.getHeight()/2 + (juego.obtenerMeta().fila)* MULTIPLICADOR);

        metaView.setX(SCREEN_WIDTH / 2 - mapa.getWidth()/2 +  (juego.obtenerMeta().columna)* MULTIPLICADOR);
        metaView.setY(SCREEN_HEIGHT / 2 - mapa.getHeight()/2 + (juego.obtenerMeta().fila)* MULTIPLICADOR);

        layout.getChildren().add(rectangle);
        layout.getChildren().add(metaView);

    }

    private void dibujarComoJugar() {
        Rectangle fondoComoJugar = new Rectangle(COMO_DIBUJAR_X, COMO_DIBUJAR_Y, COMO_DIBUJAR_ANCHO, COMO_DIBUJAR_ALTO);
        fondoComoJugar.setFill(Color.WHITE);
        fondoComoJugar.setStroke(Color.AQUAMARINE);
        fondoComoJugar.setStrokeWidth(ANCHO_STROKE);
        layout.getChildren().add(fondoComoJugar);

        Text titulo = new Text(TITULO_COMO_JUGAR_X, TITULO_COMO_JUGAR_Y, "Como jugar: ")
                ;
        titulo.setFont(Font.font(TAMANIO_FUENTE_TITULO));
        layout.getChildren().add(titulo);

        Text flechitasText = new Text(FLECHITAS_TEXT_X, FLECHITAS_TEXT_Y, "* Muevete utilizando las flechitas");
        layout.getChildren().add(flechitasText);

        Text policias = new Text(POLICIAS_X, POLICIAS_Y, "* Los policias te penalizarán \n de forma aleatoria si los atraviesas");
        layout.getChildren().add(policias);

        Text piquetes = new Text(PIQUETES_X, PIQUETES_Y, "* Los piquetes te bloquean el paso");
        layout.getChildren().add(piquetes);

        Text pozos = new Text(POZOS_X, POZOS_Y, "* Los pozos te penalizan si los pisas");
        layout.getChildren().add(pozos);

        Text sorpresas = new Text(SORPRESAS_X, SORPRESAS_Y, "* Las sorpresas le aplican \n un efecto misterioso a tu vehiculo");
        layout.getChildren().add(sorpresas);

        Text vehiculos = new Text(VEHICULOS_X, VEHICULOS_Y, "* Cada vehiculo interactua \n de forma distinta con los objetos \n " +
                "Descubre las diferencias! ");
        layout.getChildren().add(vehiculos);


    }


    private void crearCaminosView(Group layout){

        ListadoCaminos listadoCaminos = juego.obtenerCaminosConEfectos();

        for (Camino camino : listadoCaminos.caminosConEfectos) {
            new CaminoView(camino,layout,mapa);
        }
    }



    private void dibujarHasGanado() {

        Rectangle hasGanadoFondo = new Rectangle(HAS_GANADO_X, HAS_GANADO_Y, HAS_GANADO_ANCHO, HAS_GANADO_ALTO);
        hasGanadoFondo.setFill(Color.WHITE);
        hasGanadoFondo.setStroke(Color.GREEN);
        hasGanadoFondo.setStrokeWidth(ANCHO_STROKE);
        layout.getChildren().add(hasGanadoFondo);

        Text text = new Text(HAS_GANADO_TEXT_X, HAS_GANADO_TEXT_Y, "Has ganado!");
        text.setFont(Font.font(TAMANIO_FUENTE_TITULO));
        text.setFill(Color.GREEN);

        Button button = new Button("JUGAR OTRA VEZ");
        button.setLayoutX(HAS_GANADO_BUTTON_X);
        button.setLayoutY(HAS_GANADO_BUTTON_Y);

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
