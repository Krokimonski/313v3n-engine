package engine_313v3n.jugadores;

import java.util.ArrayList;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.juego.Partida;
import engine_313v3n.posiciones.Casilla;
import engine_313v3n.posiciones.Movimiento;
import engine_313v3n.reglas.Reglas;

public class HaceLoQuePuede implements Jugador {

  @Override
  public Movimiento decision(Partida partida, Reglas reglas) {

    AccesoTablero<? extends AccesoPieza> tablero = partida.tablero();

    Color turno = partida.turno();

    ArrayList<Movimiento> movs = new ArrayList<>();

    for (AccesoPieza pieza : tablero) {
      if (pieza != null && pieza.color().equals(turno)) {
        for (Casilla a : pieza.movimientosPosibles()) {
          Movimiento m = new Movimiento(pieza.posicion(), a);
          if (reglas.movimientoLegal(partida, m))
            movs.add(m);
        }
      }
    }

    return movs.get(0);
  }

  @Override
  public TipoPieza promocion(Partida partida, Casilla peon) {

    return TipoPieza.REINA;
  }

}
