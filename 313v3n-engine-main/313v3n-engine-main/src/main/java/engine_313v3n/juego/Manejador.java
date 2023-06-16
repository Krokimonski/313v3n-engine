package engine_313v3n.juego;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.EstadoPartida;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.excepciones.MovimientoIlegalException;
import engine_313v3n.jugadores.Jugador;
import engine_313v3n.posiciones.Casilla;
import engine_313v3n.posiciones.Movimiento;
import engine_313v3n.reglas.Reglas;

public class Manejador {
  // TO-DO: Empate
  /*
   * EMPATES:
   *
   * - Jugador no tiene movimiento legal y no está en jaque
   *
   * - 3 veces misma posicion (mismos movimientos posibles tb)
   *
   * - 50 movimientos sin avance de peon ni capturas
   *
   */
  private Jugador jugadores[];

  private Partida partida;

  private Reglas reglas;

  public Manejador(Tablero tablero, Jugador blanco, Jugador negro, Reglas reglas) {

    partida = new Partida(tablero);

    jugadores = new Jugador[2];
    jugadores[Color.BLANCO.ordinal()] = blanco;
    jugadores[Color.NEGRO.ordinal()] = negro;

    this.reglas = reglas;
  }

  private boolean noMovimiento() {

    for (AccesoPieza p : partida.tablero()) {
      if (p != null && p.color().equals(partida.turno())) {
        for (Casilla c : p.movimientosPosibles()) {
          if (reglas.movimientoLegal(partida, new Movimiento(p.posicion(), c)))
            return false;
        }
      }
    }

    return true;
  }

  public EstadoPartida Turno() {

    Color turno = partida.turno();

    if (noMovimiento()) {
      if (partida.enJaque(turno, partida.tablero().reyDe(turno)))
        switch (turno) {
          case BLANCO:
            return EstadoPartida.VICTORIA_NEGRA;
          case NEGRO:
            return EstadoPartida.VICTORIA_BLANCA;
        }
      else
        return EstadoPartida.EMPATE;
    }

    Movimiento decision = jugadores[turno.ordinal()].decision(partida, reglas);

    if (!reglas.movimientoLegal(partida, decision)) {
      throw new MovimientoIlegalException(decision.toString());
    }

    if (partida.tablero().pieza(decision.de()).figura() == TipoPieza.PEON
        && (decision.a().vertical() == 0 || decision.a().vertical() == 7)) {
      partida.promocion(jugadores[turno.ordinal()].promocion(partida, decision.a()), decision.de());
    }

    partida.mover(decision);
    return EstadoPartida.CONTINUA;
  }
}
