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

    Vehiculo vehiculo;
    Text movimientos;

    public MovimientosTextView(Vehiculo vehiculo, Group layout){
        Rectangle fondoMovimientos = new Rectangle(100,40,210,45);
        fondoMovimientos.setFill(Color.WHITE);
        fondoMovimientos.setStroke(Color.BLUE);
        fondoMovimientos.setStrokeWidth(5);

        movimientos = new Text(110,70,"Movimientos: " + vehiculo.obtenerMovimientosRealizados());
        movimientos.setFont(Font.font(20));
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
