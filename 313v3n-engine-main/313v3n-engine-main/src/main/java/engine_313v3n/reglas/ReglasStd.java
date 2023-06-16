package engine_313v3n.reglas;

import java.util.ArrayList;

import engine_313v3n.enums.Color;
import engine_313v3n.juego.AccesoPieza;
import engine_313v3n.juego.AccesoTablero;
import engine_313v3n.juego.Partida;
import engine_313v3n.posiciones.Casilla;
import engine_313v3n.posiciones.Movimiento;

public class ReglasStd implements Reglas {

  @Override
  public boolean movimientoLegal(Partida partida, Movimiento decision) {

    AccesoTablero<? extends AccesoPieza> tablero = partida.tablero();

    Color turno = partida.turno();

    AccesoPieza pDe = tablero.pieza(decision.de());

    if (pDe == null || !pDe.color().equals(turno)) {
      return false;
    }

    ArrayList<Casilla> posibilidades = tablero.pieza(decision.de()).movimientosPosibles();
    if (!posibilidades.contains(decision.a())) {
      return false;
    }

    Partida futura = partida.ramificar(decision);
    if (futura.enJaque(turno, futura.tablero().reyDe(turno))) {
      return false;
    }

    return true;
  }

}
