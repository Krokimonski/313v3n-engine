package engine_313v3n.movimientos;

import java.util.ArrayList;

import engine_313v3n.excepciones.FueraTableroException;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.posiciones.Casilla;

public class AvanceEnLinea implements DecoradorMovimiento {
  private int dirH;

  private int dirV;

  public AvanceEnLinea(int dirHorizontal, int dirVertical) {

    this.dirH = dirHorizontal;
    this.dirV = dirVertical;
  }

  @Override
  public ArrayList<Casilla> movimientosPosibles(AccesoTablero<? extends AccesoPieza> t, Casilla en) {

    ArrayList<Casilla> out = new ArrayList<>();
    Casilla i = en;
    try {
      while (true) {
        i = i.mover(this.dirH, this.dirV);
        if (t.pieza(i) == null) {
          out.add(i);
        } else {
          if (!t.pieza(en).color().equals(t.pieza(i).color())) {
            out.add(i);
          }
          break;
        }
      }
    } catch (FueraTableroException e) {
    }
    return out;
  }

}
