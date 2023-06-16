package engine_313v3n.movimientos;

import java.util.ArrayList;

import engine_313v3n.enums.EstadoMovimiento;
import engine_313v3n.excepciones.FueraTableroException;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.juego.Tablero;
import engine_313v3n.posiciones.Casilla;

public class PrimerAvancePeon implements DecoradorMovimiento {

  @Override
  public ArrayList<Casilla> movimientosPosibles(AccesoTablero<? extends AccesoPieza> t, Casilla en) {

    int sentido = Tablero.delante[t.pieza(en).color().ordinal()];

    ArrayList<Casilla> out = new ArrayList<>();

    try {
      if (t.pieza(en).movimiento().equals(EstadoMovimiento.QUIETA)) {
        Casilla intermedia = en.mover(0, sentido * 1);
        Casilla objetivo = en.mover(0, sentido * 2);
        if (t.pieza(intermedia) == null && t.pieza(objetivo) == null) {
          out.add(objetivo);
        }
      }
    } catch (FueraTableroException e) {
    }
    return out;
  }

}
