void main() {
    IO.println("=== Nivel 02: Encapsulamiento ===");

    // Caso de estudio: Caja
    Caja caja = new Caja();
    caja.cobrar(19000);
    caja.cobrar(7000);
    IO.println(caja.resumen());

    try {
        caja.cobrar(-500);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }

    IO.println("Saldo: $" + caja.getSaldo());

    // Práctica guiada: Producto encapsulado
    IO.println("\n--- Práctica Guiada: Producto Encapsulado ---");
    Producto latte = new Producto();
    latte.setNombre("Latte");
    latte.setPrecio(9500);
    latte.reponer(5);
    IO.println(latte.getNombre() + " $" + latte.getPrecio() + " - stock: " + latte.getStock());
    try {
        latte.setPrecio(-9500);
    } catch (IllegalArgumentException e) {
        IO.println("Error capturado: " + e.getMessage());
    }
    IO.println("Sigue en $" + latte.getPrecio());

    // Reto autocompletado: TarjetaRegalo
    IO.println("\n--- Reto Autocompletado: TarjetaRegalo ---");
    TarjetaRegalo t = new TarjetaRegalo();
    t.recargar(30000);
    IO.println("¿Pagó latte? " + t.pagar(9500));
    IO.println("¿Pagó torta? " + t.pagar(25000));
    IO.println("Saldo: $" + t.getSaldo());

    // Reto libre: BotePropinas
    IO.println("\n--- Reto Libre: BotePropinas ---");
    BotePropinas bote = new BotePropinas();
    bote.aportar(2000);
    bote.aportar(5000);
    bote.aportar(3500);
    try {
        bote.aportar(-100);
    } catch (IllegalArgumentException e) {
        IO.println("Error al aportar: " + e.getMessage());
    }
    int cuota = bote.repartir(3);
    int residuo = bote.sobrante(3);
    IO.println("Total propinas: $" + bote.getTotal() + " (" + bote.getAportes() + " aportes)");
    IO.println("Cuota por persona (3 personas): $" + cuota + " | Sobrante en bote: $" + residuo);
}
