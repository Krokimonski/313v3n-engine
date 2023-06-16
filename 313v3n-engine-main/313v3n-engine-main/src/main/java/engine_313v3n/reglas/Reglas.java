package engine_313v3n.reglas;

import engine_313v3n.juego.Partida;
import engine_313v3n.posiciones.Movimiento;

public interface Reglas {
  boolean movimientoLegal(Partida partida, Movimiento decision);

}
