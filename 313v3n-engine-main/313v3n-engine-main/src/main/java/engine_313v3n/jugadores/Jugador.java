package engine_313v3n.jugadores;

import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.Partida;
import engine_313v3n.posiciones.Casilla;
import engine_313v3n.posiciones.Movimiento;
import engine_313v3n.reglas.Reglas;

public interface Jugador {
  public Movimiento decision(Partida partida, Reglas reglas);

  public TipoPieza promocion(Partida partida, Casilla peon);
}
