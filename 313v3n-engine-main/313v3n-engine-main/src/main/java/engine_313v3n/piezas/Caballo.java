package engine_313v3n.piezas;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.movimientos.AvanceCaballo;

public class Caballo extends PiezaAbstracta {

  public Caballo(AccesoTablero<? extends AccesoPieza> origen, Color color) {

    super(origen, color, TipoPieza.CABALLO, new AvanceCaballo());
  }
}
