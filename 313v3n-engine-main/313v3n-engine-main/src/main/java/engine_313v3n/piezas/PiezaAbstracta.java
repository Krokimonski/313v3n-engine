package engine_313v3n.piezas;

import java.util.ArrayList;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.EstadoMovimiento;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.juego.Pieza;
import engine_313v3n.movimientos.DecoradorMovimiento;
import engine_313v3n.posiciones.Casilla;

public class PiezaAbstracta implements Pieza {
  private final Color color;

  private final AccesoTablero<? extends AccesoPieza> origen;

  private EstadoMovimiento estadoMovimiento;

  private DecoradorMovimiento movimientos[];

  private Casilla posicion;

  private TipoPieza tipoPieza;

  public PiezaAbstracta(AccesoTablero<? extends AccesoPieza> t, Color c, TipoPieza tp,
      DecoradorMovimiento... movimientos) {

    color = c;
    origen = t;
    tipoPieza = tp;
    estadoMovimiento = EstadoMovimiento.QUIETA;
    this.movimientos = movimientos;
  }

  @Override
  public Color color() {

    return color;
  }

  @Override
  public void setPosicion(Casilla en) {

    posicion = en;
  }

  @Override
  public Casilla posicion() {

    return posicion;
  }

  @Override
  public void setMovimiento(EstadoMovimiento m) {

    estadoMovimiento = m;
  }

  @Override
  public EstadoMovimiento movimiento() {

    return estadoMovimiento;
  }

  @Override
  public ArrayList<Casilla> movimientosPosibles() {

    ArrayList<Casilla> out = new ArrayList<>();

    for (DecoradorMovimiento m : movimientos) {
      out.addAll(m.movimientosPosibles(origen, posicion));
    }

    return out;
  }

  @Override
  public AccesoTablero<? extends AccesoPieza> origen() {

    return origen;
  }

  @Override
  public TipoPieza figura() {

    return tipoPieza;
  }

  @Override
  public Pieza copia(AccesoTablero<? extends AccesoPieza> t) {

    PiezaAbstracta copia = new PiezaAbstracta(t, color, tipoPieza, movimientos);
    copia.posicion = posicion;
    return copia;
  }

}
