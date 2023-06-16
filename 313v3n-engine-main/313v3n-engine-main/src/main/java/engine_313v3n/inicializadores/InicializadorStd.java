package engine_313v3n.inicializadores;

import engine_313v3n.enums.Color;
import engine_313v3n.juego.Pieza;
import engine_313v3n.juego.Tablero;
import engine_313v3n.piezas.Alfil;
import engine_313v3n.piezas.Caballo;
import engine_313v3n.piezas.Peon;
import engine_313v3n.piezas.Reina;
import engine_313v3n.piezas.Rey;
import engine_313v3n.piezas.Torre;
import engine_313v3n.posiciones.Casilla;

public class InicializadorStd implements Inicializador {

  private void iniciar(Tablero t, Color c) {

    Casilla esquina = new Casilla('A', 1);
    if (c.equals(Color.NEGRO)) {
      esquina = new Casilla('A', 8);
    }

    for (int v = 0; v < 2; v++) {
      for (int h = 0; h < Tablero.HORIZONTAL; h++) {
        Casilla i = esquina.mover(h, v * Tablero.delante[c.ordinal()]);
        if (v != 0) {
          t.poner(new Peon(t, c), i);
        } else if (h == 0 || h == 7) {
          t.poner(new Torre(t, c), i);
        } else if (h == 1 || h == 6) {
          t.poner(new Alfil(t, c), i);
        } else if (h == 2 || h == 5) {
          t.poner(new Caballo(t, c), i);
        } else if (h == 3) {
          t.poner(new Reina(t, c), i);
        } else if (h == 4) {
          Pieza rey = new Rey(t, c);
          t.poner(rey, i);
          t.setRey(c, rey);
        }
      }
    }

  }

  @Override
  public void iniciar(Tablero t) {

    this.iniciar(t, Color.BLANCO);
    this.iniciar(t, Color.NEGRO);
  }

}
