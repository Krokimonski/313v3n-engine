package engine_313v3n.juego;

import engine_313v3n.enums.EstadoMovimiento;
import engine_313v3n.posiciones.Casilla;

public interface Pieza extends AccesoPieza {

  public void setMovimiento(EstadoMovimiento m);

  public void setPosicion(Casilla en);

}
