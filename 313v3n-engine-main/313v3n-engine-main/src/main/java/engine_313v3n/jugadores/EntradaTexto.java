package engine_313v3n.jugadores;

import java.util.Scanner;

import engine_313v3n.enums.TipoPieza;
import engine_313v3n.juego.Partida;
import engine_313v3n.posiciones.Casilla;
import engine_313v3n.posiciones.Movimiento;
import engine_313v3n.reglas.Reglas;

public class EntradaTexto implements Jugador {
  // TO-DO Comprobar legalidad movimiento (reutilizar codigo manejador?)

  Scanner sc;

  public EntradaTexto() {

    sc = new Scanner(System.in);
  }

  @Override
  public Movimiento decision(Partida partida, Reglas reglas) {

    Movimiento m = null;
    while (m == null)
      try {
        String choice = sc.nextLine();
        m = new Movimiento(choice);
        if (!reglas.movimientoLegal(partida, m)) {
          System.out.println("Introduzca un movimiento legal");
          m = null;
        }
      } catch (Exception e) {
        System.out.println("Introduzca un movimiento valido");
        m = null;
      }
    return m;
  }

  @Override
  public TipoPieza promocion(Partida partida, Casilla peon) {

    System.out.println("El peon en " + peon.toString() + " ha promocionado.");
    TipoPieza out = null;
    while (out == null) {
      System.out
          .println("Elija la figura en la que se convertira ([T]orre [A]lfil [C]aballo [R]eina):");
      switch (sc.nextLine().toUpperCase().charAt(0)) {
        case 'T':
          out = TipoPieza.TORRE;
          break;
        case 'A':
          out = TipoPieza.ALFIL;
          break;
        case 'C':
          out = TipoPieza.CABALLO;
          break;
        case 'R':
          out = TipoPieza.REINA;
          break;
        default:
          System.out.println("Seleccion invalida.");
      }
    }
    return out;
  }
}
