import java.util.List;

void main() {
    IO.println("=== Nivel 05: Clases Abstractas e Interfaces ===");

    // Caso de estudio: Producto abstracto y Personalizable
    List<Producto> menu = List.of(
        new Bebida("Capuchino", 9000),
        new Postre("Brownie", 7000)
    );

    IO.println("--- Pantalla de Barra ---");
    for (Producto p : menu) {
        IO.println(p.ficha());
        if (p instanceof Personalizable per) {
            IO.println("  Opciones: " + per.opciones());
            IO.println("  Avena: +$" + per.extra("avena"));
        }
    }

    // Práctica guiada: Medios de pago desacoplados
    IO.println("\n--- Práctica Guiada: Medios de Pago ---");
    List<MedioDePago> medios = List.of(
        new Efectivo(),
        new Billetera(12000),
        new Tarjeta(10000)
    );

    for (MedioDePago m : medios) {
        String r = m.pagar(9500) ? "aprobado" : "rechazado";
        IO.println(m.nombre() + " $9500: " + r);
        r = m.pagar(9500) ? "aprobado" : "rechazado";
        IO.println(m.nombre() + " $9500: " + r);
    }

    // Reto autocompletado: Descontable y Snacks
    IO.println("\n--- Reto Autocompletado: Snacks con Descuento ---");
    Snack s = new Galleta();
    IO.println(s.nombre() + ": $" + s.precioBase());
    Descontable d = s;
    IO.println("Con 20% descuento: $" + d.conDescuento(20));

    // Reto libre: Entregas polimórficas
    IO.println("\n--- Reto Libre: Formas de Entrega ---");
    Domicilio dom = new Domicilio(101, 3);
    List<Entrega> entregas = List.of(
        new EnMesa(100),
        new ParaLlevar(102),
        dom
    );

    for (Entrega ent : entregas) {
        IO.println(ent.resumen());
        if (ent instanceof Rastreable r) {
            IO.println("  Estado actual: " + r.estado() + " (¿Entregado? " + r.entregado() + ")");
        }
    }

    dom.avanzar();
    dom.avanzar();
    IO.println("Tras avanzar entrega domicilio:");
    IO.println("  Estado actual: " + dom.estado() + " (¿Entregado? " + dom.entregado() + ")");
}
