package engine_313v3n.movimientos;

public class AvanceCaballo extends DecoradorCompuesto {
  public AvanceCaballo() {

    super(new Salto(2, 1), new Salto(2, -1), new Salto(-2, 1), new Salto(-2, -1), new Salto(1, 2),
        new Salto(-1, 2), new Salto(1, -2), new Salto(-1, -2));
  }
}
