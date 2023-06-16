package engine_313v3n;

import java.io.IOException;

import engine_313v3n.enums.EstadoPartida;
import engine_313v3n.inicializadores.InicializadorStd;
import engine_313v3n.juego.Manejador;
import engine_313v3n.juego.Tablero;
import engine_313v3n.jugadores.EntradaTexto;
import engine_313v3n.jugadores.HaceLoQuePuede;
import engine_313v3n.jugadores.Jugador;
import engine_313v3n.reglas.Reglas;
import engine_313v3n.reglas.ReglasStd;

public class Main {

  /* TO-DOs: En Peon, Manejador, EntradaTexto */

  public static void main(String[] args) throws IOException {

    Tablero t = new Tablero();

    new InicializadorStd().iniciar(t);

    System.out.println(t);

    Jugador j1 = new HaceLoQuePuede();
    Jugador j2 = new EntradaTexto();

    Reglas r = new ReglasStd();

    Manejador juego = new Manejador(t, j1, j2, r);
    EstadoPartida partida = EstadoPartida.CONTINUA;

    while (partida.equals(EstadoPartida.CONTINUA)) {
      partida = juego.Turno();
      System.out.println(t);
    }

    switch (partida) {
      case EMPATE:
        System.out.println("EMPATE");
        break;
      case VICTORIA_BLANCA:
        System.out.println("GANAN LAS BLANCAS");
        break;
      case VICTORIA_NEGRA:
        System.out.println("GANAN LAS NEGRAS");
        break;
      default:
        System.out.println("ERROR: FINAL INESPERADO");
    }
  }

}
