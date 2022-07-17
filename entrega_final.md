# Entrega Final

Nota final: 8
Aprobada: :heavy_check_mark:

# Asistencia

| Alumnes                                                               | Presente           |
|-----------------------------------------------------------------------|:------------------:|
| Agustín Murseli - [amurseli](https://github.com/amurseli)             | :x: |
| Julio Mateo Fernandéz - [MateoF01](https://github.com/MateoF01)       | :heavy_check_mark: |
| Santiago Nicolás Penalva - [spenalva1](https://github.com/Spenalva1)  | :heavy_check_mark: |
| Jackson Puentes - [JacksonPuentes](https://github.com/JacksonPuentes) | :heavy_check_mark: |


## Modelo y paradigma

### Herencia

:heavy_check_mark:

### Delegación

:heavy_check_mark:

### Encapsulamiento

:heavy_check_mark:

### Ocultamiento de la información

:heavy_check_mark:

### Principios de diseño

:heavy_check_mark:

### S.O.L.I.D

:heavy_check_mark:

1. Violan *Dependency inversion principle (DIP)* . Dificulta la escritura de tests:

```java
public class Camino extends Observable {
    // ...
    public Camino(Esquina esquinaInicial, Direccion unaDireccion) {
        this.esquinaInicial = esquinaInicial;
        esquinaFinal = unaDireccion.siguiente(esquinaInicial);

        // DIP
        generadorRandomSorpresas = new GeneradorRandomSorpresas();

        // DIP
        generadorRandomObstaculos = new GeneradorRandomObstaculos();
        sorpresa = new SorpresaNull();
        obstaculo = new ObstaculoNull();
    }
    // ...
}
```

### Tell don’t ask

:heavy_check_mark:

Lo comprometen aquí:

```java
public class Pozo extends ManejadorDeObservablesObstaculos implements Obstaculo {

    // ...

    public void aplicarEfecto(Vehiculo vehiculo, CuatroPorCuatro cuatroPorCuatro) {
        cuatroPorCuatro.sumarPozoPisado();
        if(cuatroPorCuatro.elProximoPozoEsPenalizable()){
            vehiculo.sumarMovimientos(PENALIZACION_CUATRO_POR_CUATRO);
            cuatroPorCuatro.reinciarPozosPizados();
        }
    }

    // ...

}
```
### Patrones de diseño

:heavy_check_mark:

### Adaptabilidad:

:heavy_check_mark: 

#### Extensión del modelo

- :heavy_check_mark: Bien haber escrito la prueba, por más que no hayan hecho TDD.
- :x: Violan OCP. Tienen que cambiar el generador random.
- :x: No aplicaron composite.


## Diagramas UML

### Notación

1. Están invertidas las relaciones `GeneradorRandomObstaculos` y `ManejadorDeObservablesObstaculos`.
2. Están invertidas las relaciones `GeneradorRandomSorpresas` y `ManejadorDeObservablesSorpresa`.
3. Están invertidas las relaciones `Camino` y `Observable`
4. Revisar **todas** las relaciones de herencia.

### Consistencia

1. Hay una inconsistencia en el diagrama *Jugador se mueve a la derecha*. 

    a. No se muestran los condicionales. Tenien dos posibilidades, especificar mejor el caso de uso para que no sea necesario mostrar los condicionales o motrarlos en en el diagrama.
    
    b. La secuencia está incompleta. Falta: 
    
```java
public class Vehiculo extends Observable{
    public Esquina mover(Direccion unaDireccion, ListadoCaminos caminos, Esquina limite) {
        Esquina nuevaEsquina = unaDireccion.siguiente(posicion);

        if(!validarPosicion(limite,nuevaEsquina)){

            sumarMovimientos(1);
            asignarPosicion(nuevaEsquina);

            // Falta
            Camino caminoRecorrido = caminos.obtenerCaminoRecorrido(new Camino(posicionAnterior, unaDireccion));
            // Falta
            caminoRecorrido.aplicarEfecto(this,estado);
        }

        // Falta
        setChanged();
        this.notifyObservers();

        return posicion;
    }

}
```

### Complejidad

## Informe 

### Herencia vs. Delegación:

:x:

No lo explicacn.

### Principios de diseño

:heavy_check_mark:

### Patrones de diseño

:heavy_check_mark:
