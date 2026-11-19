void main() {
    IO.println("=== Nivel 03: Constructores y Sobrecarga ===");

    // Caso de estudio: Bebida con prólogo Java 25
    Bebida a = new Bebida("Latte", "grande", 11000, true);
    Bebida b = new Bebida("Tinto", 3500);

    IO.println(a.descripcion());
    IO.println(b.descripcion());
    IO.println("Latte + 2 extras: $" + a.precioCon(2));
    IO.println("Con cupón CAFE10: $" + a.precioCon("CAFE10"));

    try {
        new Bebida(" ", 3000); // Falla en prólogo Java 25
    } catch (IllegalArgumentException e) {
        IO.println("Rechazada: " + e.getMessage());
    }

    // Práctica guiada: Reserva
    IO.println("\n--- Práctica Guiada: Reserva ---");
    Reserva r1 = new Reserva("Familia Rojas", 6, "18:30");
    Reserva r2 = new Reserva("Andrés", 2);
    IO.println(r1.aviso());
    IO.println(r2.aviso(15));
    try {
        new Reserva("Fiesta", 12);
    } catch (IllegalArgumentException e) {
        IO.println("No se pudo: " + e.getMessage());
    }

    // Reto autocompletado: Postre
    IO.println("\n--- Reto Autocompletado: Postre ---");
    Postre p1 = new Postre("Brownie", 7000);
    Postre p2 = new Postre("Cheesecake", 9000, true);
    IO.println(p1.etiqueta(true));
    IO.println(p2.etiqueta(true));

    // Reto libre: Combo
    IO.println("\n--- Reto Libre: Combo ---");
    Combo c1 = new Combo("Capuchino", "Muffin", 14000);
    Combo c2 = new Combo("Americano", 5000);
    IO.println(c1.descripcion() + " | Con 10% propina: $" + c1.precioFinal(10));
    IO.println(c2.descripcion());
    try {
        new Combo("   ", 4000); // Falla en prólogo Java 25
    } catch (IllegalArgumentException e) {
        IO.println("Error combo prólogo: " + e.getMessage());
    }
}
