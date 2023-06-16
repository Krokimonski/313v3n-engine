package engine_313v3n.juego;

import engine_313v3n.enums.Color;
import engine_313v3n.enums.TipoPieza;
import engine_313v3n.excepciones.PromocionIlegalException;
import engine_313v3n.piezas.Alfil;
import engine_313v3n.piezas.Caballo;
import engine_313v3n.piezas.Reina;
import engine_313v3n.piezas.Torre;
import engine_313v3n.posiciones.Casilla;
import engine_313v3n.posiciones.Movimiento;

public class Partida {
  private Tablero tablero;

  private Color turno;

  private Partida padre;

  private Movimiento ultimoMovimiento;

  public Partida(Tablero tablero) {

    this.tablero = tablero;
    turno = Color.BLANCO;

    padre = null;
    ultimoMovimiento = null;
  }

  private Partida(Partida padre, Movimiento ultimoMovimiento) {

    this.padre = padre;
    this.ultimoMovimiento = ultimoMovimiento;

    tablero = padre.tablero.copia();
    turno = padre.turno;

    mover(ultimoMovimiento);
  }

  public Color turno() {

    return turno;
  }

  public AccesoTablero<? extends AccesoPieza> tablero() {

    return tablero;
  }

  public boolean enJaque(Color color, Casilla posicion) {

    for (AccesoPieza p : tablero) {
      if (p != null && color != p.color()) {
        if (p.movimientosPosibles().contains(posicion)) {
          return true;
        }
      }
    }
    return false;
  }

  public void promocion(TipoPieza promocion, Casilla peon) {

    Pieza original = tablero.pieza(peon);
    Pieza nueva;
    switch (promocion) {
      case TORRE:
        nueva = new Torre(original.origen(), original.color());
        break;
      case ALFIL:
        nueva = new Alfil(original.origen(), original.color());
        break;
      case CABALLO:
        nueva = new Caballo(original.origen(), original.color());
        break;
      case REINA:
        nueva = new Reina(original.origen(), original.color());
        break;
      default:
        throw new PromocionIlegalException(promocion.name());
    }

    Pieza out = tablero.poner(nueva, peon);
    borradoFicha(out);
  }

  public Partida ramificar(Movimiento decision) {

    return new Partida(this, decision);
  }

  private void borradoFicha(Pieza out) {

    if (out != null) {
      // TO-DO: se destruye ficha, ¿necesario algo?
    }
  }

  public void mover(Movimiento decision) {

    Pieza out = tablero.mover(decision.de(), decision.a());
    borradoFicha(out);

    if (turno.equals(Color.BLANCO)) {
      turno = Color.NEGRO;
    } else {
      turno = Color.BLANCO;
    }
  }
}
