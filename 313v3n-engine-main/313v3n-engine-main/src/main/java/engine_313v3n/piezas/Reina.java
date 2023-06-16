package engine_313v3n.piezas;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.movimientos.AvanceAlfil;
import engine_313v3n.movimientos.AvanceTorre;

public class Reina extends PiezaAbstracta {

  public Reina(AccesoTablero<? extends AccesoPieza> origen, Color color) {

    super(origen, color, TipoPieza.REINA, new AvanceTorre(), new AvanceAlfil());
  }

}
