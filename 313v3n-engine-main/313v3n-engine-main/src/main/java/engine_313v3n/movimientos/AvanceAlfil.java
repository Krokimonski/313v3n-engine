package engine_313v3n.movimientos;

public class AvanceAlfil extends DecoradorCompuesto {
  public AvanceAlfil() {

    super(new AvanceEnLinea(1, 1), new AvanceEnLinea(-1, 1), new AvanceEnLinea(-1, -1), new AvanceEnLinea(1, -1));
  }
}
