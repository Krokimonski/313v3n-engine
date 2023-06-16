package engine_313v3n.juego;

import engine_313v3n.enums.Color;
import engine_313v3n.posiciones.Casilla;

public interface AccesoTablero<T extends AccesoPieza> extends Iterable<T> {
  public T pieza(Casilla c);

  public Tablero copia();

  public Casilla reyDe(Color c);
}
