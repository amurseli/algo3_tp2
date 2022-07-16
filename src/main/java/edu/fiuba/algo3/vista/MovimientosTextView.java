package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;

public class MovimientosTextView implements Observer {

    public static final int FONDO_MOVIMIENTOS_X = 100;
    public static final int FONDO_MOVIMIENTOS_Y = 40;
    public static final int FONDO_MOVIMIENTOS_ANCHO = 210;
    public static final int FONDO_MOVIENTOS_ALTO = 45;
    public static final int MOVIMIENTOS_X = 110;
    public static final int MOVIMIENTOS_Y = 70;
    public static final int SIZE_FONT_MOVIENTOS = 20;
    public static final int TAMANIO_STROKE = 5;
    Vehiculo vehiculo;
    Text movimientos;

    public MovimientosTextView(Vehiculo vehiculo, Group layout){
        Rectangle fondoMovimientos = new Rectangle(FONDO_MOVIMIENTOS_X, FONDO_MOVIMIENTOS_Y, FONDO_MOVIMIENTOS_ANCHO, FONDO_MOVIENTOS_ALTO);
        fondoMovimientos.setFill(Color.WHITE);
        fondoMovimientos.setStroke(Color.BLUE);
        fondoMovimientos.setStrokeWidth(TAMANIO_STROKE);

        movimientos = new Text(MOVIMIENTOS_X, MOVIMIENTOS_Y,"Movimientos: " + vehiculo.obtenerMovimientosRealizados());
        movimientos.setFont(Font.font(SIZE_FONT_MOVIENTOS));
        movimientos.setFill(Color.BLACK);

        this.vehiculo = vehiculo;
        this.vehiculo.addObserver(this);

        layout.getChildren().add(fondoMovimientos);
        layout.getChildren().add(movimientos);
    }
    @Override
    public void update(Observable o, Object arg) {
        actualizarMovimientos();
    }

    private void actualizarMovimientos(){
        movimientos.setText("Movimientos: " + vehiculo.obtenerMovimientosRealizados());
    }
}
