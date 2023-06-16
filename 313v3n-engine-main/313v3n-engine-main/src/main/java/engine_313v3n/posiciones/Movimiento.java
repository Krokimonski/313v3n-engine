package engine_313v3n.posiciones;

import java.util.Objects;

public class Movimiento {
  private Casilla de;

  private Casilla a;

  public Movimiento(Casilla de, Casilla a) {

    this.de = de;
    this.a = a;
  }

  public Movimiento(String m) {

    de = new Casilla(m.substring(0, 2));
    a = new Casilla(m.substring(2, 4));
  }

  public Casilla de() {

    return de;
  }

  public Casilla a() {

    return a;
  }

  @Override
  public int hashCode() {

    return Objects.hash(a, de);
  }
}
