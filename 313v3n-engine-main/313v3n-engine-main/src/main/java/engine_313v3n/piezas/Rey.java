package engine_313v3n.piezas;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.movimientos.AvanceRey;

public class Rey extends PiezaAbstracta {
  // TO-DO: Enroque
  public Rey(AccesoTablero<? extends AccesoPieza> origen, Color color) {

    super(origen, color, TipoPieza.REY, new AvanceRey());
  }
}
