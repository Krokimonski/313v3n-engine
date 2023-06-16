package engine_313v3n.movimientos;

public class AvanceTorre extends DecoradorCompuesto {

  public AvanceTorre() {

    super(new AvanceEnLinea(1, 0), new AvanceEnLinea(-1, 0), new AvanceEnLinea(0, 1), new AvanceEnLinea(0, -1));
  }
}
