package engine_313v3n.movimientos;

import java.util.ArrayList;

import engine_313v3n.excepciones.FueraTableroException;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.juego.Tablero;
import engine_313v3n.posiciones.Casilla;

public class AvancePeon implements DecoradorMovimiento {

  @Override
  public ArrayList<Casilla> movimientosPosibles(AccesoTablero<? extends AccesoPieza> t, Casilla en) {

    int sentido = Tablero.delante[t.pieza(en).color().ordinal()];

    ArrayList<Casilla> out = new ArrayList<>();
    try {
      Casilla objetivo = en.mover(0, sentido * 1);
      if (t.pieza(objetivo) == null) {
        out.add(objetivo);
      }
    } catch (FueraTableroException e) {

    }
    return out;
  }

}
