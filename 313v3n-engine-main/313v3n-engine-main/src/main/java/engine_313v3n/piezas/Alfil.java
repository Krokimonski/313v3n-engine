package engine_313v3n.piezas;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.movimientos.AvanceAlfil;

public class Alfil extends PiezaAbstracta {

  public Alfil(AccesoTablero<? extends AccesoPieza> origen, Color color) {

    super(origen, color, TipoPieza.ALFIL, new AvanceAlfil());
  }
}
