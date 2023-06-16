package engine_313v3n.movimientos;

import java.util.ArrayList;

import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.posiciones.Casilla;

public abstract class DecoradorCompuesto implements DecoradorMovimiento {

  private DecoradorMovimiento decoradores[];

  public DecoradorCompuesto(DecoradorMovimiento... movs) {

    this.decoradores = movs;
  }

  @Override
  public ArrayList<Casilla> movimientosPosibles(AccesoTablero<? extends AccesoPieza> t, Casilla en) {

    ArrayList<Casilla> out = new ArrayList<>();

    for (DecoradorMovimiento dm : this.decoradores) {
      out.addAll(dm.movimientosPosibles(t, en));
    }
    return out;
  }

}
