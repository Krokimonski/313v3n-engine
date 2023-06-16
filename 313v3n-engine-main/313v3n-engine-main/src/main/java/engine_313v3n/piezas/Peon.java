package engine_313v3n.piezas;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.juego.Pieza;
import engine_313v3n.movimientos.AvancePeon;
import engine_313v3n.movimientos.CapturaPeon;
import engine_313v3n.movimientos.PrimerAvancePeon;

public class Peon extends PiezaAbstracta implements Pieza {
  // TO-DO: PROMOCION DE PEON, CAPTURA AL PASO
  public Peon(AccesoTablero<? extends AccesoPieza> origen, Color color) {

    super(origen, color, TipoPieza.PEON, new CapturaPeon(), new PrimerAvancePeon(), new AvancePeon());
  }
}
