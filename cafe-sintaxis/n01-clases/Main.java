void main() {
    IO.println("=== Nivel 01: Clases, Métodos y Atributos ===");

    // Caso de estudio: Producto
    Producto latte = new Producto();
    latte.nombre = "Latte";
    latte.precio = 9500;
    latte.stock = 3;

    Producto brownie = new Producto();
    brownie.nombre = "Brownie";
    brownie.precio = 7000;

    IO.println(latte.descripcion());
    IO.println("¿Hay brownie? " + brownie.hayStock());

    int cobro = latte.vender(2);
    IO.println("Cobrar: $" + cobro);
    IO.println(latte.descripcion());
    latte.vender(5);

    // Práctica guiada: Cliente
    IO.println("\n--- Práctica Guiada: Cliente ---");
    Cliente sofia = new Cliente();
    sofia.nombre = "Sofía";
    sofia.puntos = 41;
    sofia.sumarPuntos(12500);
    IO.println(sofia.tarjeta());
    IO.println("¿Café gratis? " + sofia.puedeCanjear());
    sofia.canjear();
    IO.println("Tras canje: " + sofia.tarjeta());

    // Reto autocompletado: Mesa
    IO.println("\n--- Reto Autocompletado: Mesa ---");
    Mesa m4 = new Mesa();
    m4.numero = 4;
    m4.ocupar(3);
    IO.println(m4.estado());
    m4.liberar();
    IO.println(m4.estado());

    // Reto libre: Barista
    IO.println("\n--- Reto Libre: Barista ---");
    Barista martin = new Barista();
    martin.nombre = "Martín";
    martin.turno = "mañana";
    for (int i = 0; i < 3; i++) {
        martin.preparar("Latte");
    }
    IO.println(martin.resumen() + " | Merece pausa: " + martin.merecePausa());

    Barista lucia = new Barista();
    lucia.nombre = "Lucía";
    lucia.turno = "tarde";
    for (int i = 0; i < 21; i++) {
        lucia.preparar("Espresso");
    }
    IO.println(lucia.resumen() + " | Merece pausa: " + lucia.merecePausa());
    lucia.recibirPropina(5000);
    lucia.recibirPropina(-1000);
    IO.println("Propinas acumuladas Lucía: $" + lucia.propinas);
}
