package engine_313v3n.posiciones;

import java.util.Objects;

import engine_313v3n.excepciones.FueraTableroException;
import engine_313v3n.juego.Tablero;

public class Casilla {
  private final int horizontal;

  private final int vertical;

  private Casilla(int h, int v) {

    if (h < 0 || Tablero.HORIZONTAL <= h) {
      throw new FueraTableroException("HORIZONTAL " + Integer.toString(h) + " INVALIDO");
    } else {
      horizontal = h;
    }

    if (v < 0 || Tablero.VERTICAL <= v) {
      throw new FueraTableroException("VERTICAL " + Integer.toString(v) + " INVALIDO");
    } else {
      vertical = v;
    }
  }

  public Casilla(Casilla c) {

    horizontal = c.horizontal;
    vertical = c.vertical;
  }

  public Casilla(char h, int v) {

    this(Character.toUpperCase(h) - 'A', v - 1);
  }

  public Casilla(String c) {

    this(c.charAt(0), Integer.parseInt(c.substring(1)));
  }

  public Casilla mover(int h, int v) {

    Casilla out = new Casilla(horizontal + h, vertical + v);
    return out;
  }

  public int horizontal() {

    return horizontal;
  }

  public int vertical() {

    return vertical;
  }

  @Override
  public int hashCode() {

    return Objects.hash(horizontal, vertical);
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Casilla other = (Casilla) obj;
    return horizontal == other.horizontal && vertical == other.vertical;
  }

  @Override
  public String toString() {

    return Character.toString('A' + horizontal) + Integer.toString(vertical + 1);
  }
}
