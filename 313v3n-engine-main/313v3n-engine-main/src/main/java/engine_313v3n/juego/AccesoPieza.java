package engine_313v3n.juego;

import java.util.ArrayList;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.EstadoMovimiento;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.posiciones.Casilla;

public interface AccesoPieza {
  public Color color();

  public EstadoMovimiento movimiento();

  public TipoPieza figura();

  public ArrayList<Casilla> movimientosPosibles();

  public Casilla posicion();

  public AccesoTablero<? extends AccesoPieza> origen();

  public Pieza copia(AccesoTablero<? extends AccesoPieza> t);

}
