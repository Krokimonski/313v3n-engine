package engine_313v3n.juego;

import java.util.Iterator;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.EstadoMovimiento;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.posiciones.Casilla;

public class Tablero implements AccesoTablero<Pieza> {
  @Override
  public Iterator<Pieza> iterator() {

    return new IteradorTablero(this);
  }

  class IteradorTablero implements Iterator<Pieza> {
    Casilla i;

    Tablero t;

    IteradorTablero(Tablero t) {

      i = new Casilla('A', 1);
      this.t = t;
    }

    @Override
    public boolean hasNext() {

      return i.vertical() < Tablero.VERTICAL - 1 || i.horizontal() < Tablero.HORIZONTAL - 1;
    }

    @Override
    public Pieza next() {

      Pieza out = t.pieza(i);
      if (i.horizontal() == Tablero.HORIZONTAL - 1) {
        i = i.mover(-7, 1); // nueva fila
      } else {
        i = i.mover(1, 0); // mueve columna
      }

      return out;
    }
  }

  public static int HORIZONTAL = 8;

  public static int VERTICAL = 8;

  public static int delante[] = new int[2];

  static {
    delante[Color.BLANCO.ordinal()] = 1;
    delante[Color.NEGRO.ordinal()] = -1;
  }

  private Pieza casillas[][];

  private Pieza reyes[] = new Pieza[2];

  public void setRey(Color color, Pieza rey) {

    reyes[color.ordinal()] = rey;
  }

  @Override
  public Tablero copia() {

    Tablero copia = new Tablero();
    for (int i = 0; i < VERTICAL; i++) {
      for (int j = 0; j < HORIZONTAL; j++) {
        if (casillas[i][j] != null) {
          copia.casillas[i][j] = casillas[i][j].copia(copia);
          if (copia.casillas[i][j].figura() == TipoPieza.REY) {
            copia.setRey(casillas[i][j].color(), copia.casillas[i][j]);
          }
        }
      }
    }
    return copia;
  }

  public Tablero() {

    casillas = new Pieza[VERTICAL][HORIZONTAL];
    for (int i = 0; i < VERTICAL; i++) {
      for (int j = 0; j < HORIZONTAL; j++) {
        casillas[i][j] = null;
      }
    }
  }

  @Override
  public Pieza pieza(Casilla c) {

    return casillas[c.vertical()][c.horizontal()];
  }

  public Pieza poner(Pieza p, Casilla en) {

    Pieza out = casillas[en.vertical()][en.horizontal()];
    casillas[en.vertical()][en.horizontal()] = p;
    p.setPosicion(en);

    return out;
  }

  public void eliminar(Casilla de) {

    casillas[de.vertical()][de.horizontal()] = null;
  }

  public Pieza mover(Casilla de, Casilla a) {

    Pieza p = casillas[de.vertical()][de.horizontal()];
    casillas[de.vertical()][de.horizontal()] = null;
    Pieza out = casillas[a.vertical()][a.horizontal()];
    casillas[a.vertical()][a.horizontal()] = p;

    p.setPosicion(a);

    if (p.movimiento().equals(EstadoMovimiento.QUIETA)) {
      p.setMovimiento(EstadoMovimiento.PRIMERO);
    } else {
      p.setMovimiento(EstadoMovimiento.RECIEN_MOVIDA);
    }

    for (Pieza pieza : this) {
      if (pieza != null && pieza != p) {
        if (pieza.movimiento().equals(EstadoMovimiento.PRIMERO)
            || pieza.movimiento().equals(EstadoMovimiento.RECIEN_MOVIDA)) {
          pieza.setMovimiento(EstadoMovimiento.MOVIDA);
        }
      }
    }
    return out;
  }

  @Override
  public String toString() {

    String out = "";
    String bottom = "  ";
    for (int linea = casillas.length - 1; 0 <= linea; linea--) {
      out += Integer.toString(linea + 1) + " ";
      for (int columna = 0; columna < casillas[linea].length; columna++) {
        bottom += Character.toString('A' + columna);
        Pieza actual = casillas[linea][columna];
        if (actual == null) {
          if ((linea + columna) % 2 == 1) {
            out += " ";
          } else {
            out += "X";
          }
        } else {
          String p;
          switch (actual.figura()) {
            case PEON:
              p = "P";
              break;
            case TORRE:
              p = "T";
              break;
            case ALFIL:
              p = "A";
              break;
            case CABALLO:
              p = "C";
              break;
            case REY:
              p = "R";
              break;
            case REINA:
              p = "r";
              break;
            default:
              p = "?";
          }
          out += p;
        }
      }
      out += "\n";
    }
    out += "  ABCDEFGH\n";
    return out;
  }

  @Override
  public Casilla reyDe(Color c) {

    return reyes[c.ordinal()].posicion();
  }
}
