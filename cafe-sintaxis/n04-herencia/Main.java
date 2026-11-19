import java.util.List;

void main() {
    IO.println("=== Nivel 04: Herencia y Composición ===");

    // Caso de estudio: Vitrina polimórfica
    Bebida latte = new Bebida("Latte", 9500, 350);
    Postre torta = new Postre("Torta de zanahoria", 8000, true);
    Producto galleta = new Producto("Galleta", 3000);

    IO.println(latte.getNombre() + " cuesta " + latte.getPrecio());

    List<Producto> vitrina = List.of(latte, torta, galleta);
    IO.println("\n--- Vitrina (Polimorfismo) ---");
    for (Producto p : vitrina) {
        IO.println(p.descripcion());
    }

    // Composición: Pedido con LineaPedido
    IO.println("\n--- Composición: Pedido con Líneas ---");
    Pedido pedido = new Pedido(4);
    pedido.agregar(latte, 2);
    pedido.agregar(new Postre("Brownie", 7000, false), 1);
    pedido.imprimir();

    // Reto autocompletado: Temporada y Combo
    IO.println("\n--- Reto Autocompletado: Temporada y Combo ---");
    Producto ponque = new Temporada("Ponqué de calabaza", 8500, "octubre");
    Combo combo = new Combo(new Bebida("Latte", 9500, 350), ponque);
    IO.println(ponque.descripcion());
    IO.println("Combo: $" + combo.precio());

    // Reto libre: Nómina de Empleados
    IO.println("\n--- Reto Libre: Nómina de Turno ---");
    Barista martin = new Barista("Martín", 50000, 25);
    Mesero sofia = new Mesero("Sofía", 45000, 15000);
    IO.println(martin + " -> Pago: $" + martin.pago());
    IO.println(sofia + " -> Pago: $" + sofia.pago());

    Turno turno = new Turno();
    turno.agregar(martin);
    turno.agregar(sofia);
    IO.println("Nómina total del turno: $" + turno.totalNomina());
}
