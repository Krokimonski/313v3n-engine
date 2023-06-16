package engine_313v3n.movimientos;

import java.util.ArrayList;

import engine_313v3n.excepciones.FueraTableroException;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.posiciones.Casilla;

public class Salto implements DecoradorMovimiento {
  private int dirH;

  private int dirV;

  public Salto(int dirHorizontal, int dirVertical) {

    dirH = dirHorizontal;
    dirV = dirVertical;
  }

  @Override
  public ArrayList<Casilla> movimientosPosibles(AccesoTablero<? extends AccesoPieza> t,
      Casilla en) {

    ArrayList<Casilla> out = new ArrayList<>();
    try {
      Casilla a = en.mover(dirH, dirV);
      if (t.pieza(a) == null) {
        out.add(a);
      } else if (t.pieza(en).color() != t.pieza(a).color()) {
        out.add(a);
      }
    } catch (FueraTableroException e) {
    }

    return out;
  }

}
