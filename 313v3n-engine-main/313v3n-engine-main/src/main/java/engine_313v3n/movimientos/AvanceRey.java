package engine_313v3n.movimientos;

public class AvanceRey extends DecoradorCompuesto {
  public AvanceRey() {

    super(new Salto(1, 1), new Salto(1, 0), new Salto(1, -1), new Salto(0, -1), new Salto(-1, -1),
        new Salto(-1, 0), new Salto(-1, 1), new Salto(0, 1));
  }
}
