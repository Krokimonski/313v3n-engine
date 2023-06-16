package engine_313v3n.movimientos;

import java.util.ArrayList;

import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.posiciones.Casilla;

public interface DecoradorMovimiento {
  public ArrayList<Casilla> movimientosPosibles(AccesoTablero<? extends AccesoPieza> t, Casilla en);
}
