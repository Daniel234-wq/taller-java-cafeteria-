import java.util.List;

class PagosHelper {
    static String describir(Pago p, int total) {
        return switch (p) {
            case Efectivo(int recibido) ->
                "Efectivo · vuelto $" + (recibido - total);
            case Tarjeta(String f, int cuotas) when cuotas > 1 ->
                f + " a " + cuotas + " cuotas";
            case Tarjeta(String f, int cuotas) ->
                f + " de contado";
            case Billetera(String tel) ->
                "Billetera " + tel;
        };
    }
}

void main() {
    IO.println("=== Nivel 10: Records - Datos Inmutables ===");

    // Caso de estudio: LineaRecibo y Recibo
    IO.println("--- Recibos Inmutables ---");
    var l1 = new LineaRecibo("Latte", 9500, 2);
    var l2 = new LineaRecibo("Brownie", 7000, 1);

    IO.println(l1);
    IO.println(l1.producto() + " → $" + l1.subtotal());

    var otra = new LineaRecibo("Latte", 9500, 2);
    IO.println("¿Iguales por contenido (equals)? " + l1.equals(otra));

    var r = new Recibo(1001, List.of(l1, l2));
    IO.println("Recibo " + r.numero() + ": $" + r.total());

    // Record pattern con instanceof (deconstrucción)
    if (r.lineas().getFirst() instanceof LineaRecibo(var p, var precio, var c)) {
        IO.println("Primera línea deconstruida: " + c + " × " + p + " a $" + precio);
    }

    // Práctica guiada: Sealed Interface y Record Patterns con Guardas (when)
    IO.println("\n--- Práctica Guiada: Pagos con Record Patterns y 'when' ---");
    int totalCobro = 26000;
    List<Pago> listaPagos = List.of(
        new Efectivo(30000),
        new Tarjeta("Débito", 1),
        new Tarjeta("Crédito", 3),
        new Billetera("300 555 0110")
    );

    for (Pago pago : listaPagos) {
        IO.println(PagosHelper.describir(pago, totalCobro));
    }

    // Reto autocompletado: Calificación
    IO.println("\n--- Reto Autocompletado: Calificación ---");
    var cal1 = new Calificacion("Sofía", 5);
    var cal2 = new Calificacion("Sofía", 5);
    IO.println(cal1.cliente() + ": " + cal1.estrellas() + " estrellas");
    IO.println("¿Calificación buena? " + cal1.esBuena());
    IO.println("¿Iguales? " + cal1.equals(cal2));
    IO.println(cal1);

    // Reto libre: Menú del Día Inmutable
    IO.println("\n--- Reto Libre: Menú del Día con Inmutabilidad ---");
    ItemMenu itemOriginal = new ItemMenu("Capuchino", CategoriaMenu.BEBIDA, 9000);
    ItemMenu itemModificado = itemOriginal.conPrecio(9900); // Retorna copia con precio nuevo
    IO.println("Original: " + itemOriginal + " | Modificado: " + itemModificado);
    IO.println("¿El original se mantuvo inalterado? " + (itemOriginal.precio() == 9000));

    MenuDelDia menu = new MenuDelDia("2026-11-18", List.of(
        itemOriginal,
        new ItemMenu("Tarta de limón", CategoriaMenu.POSTRE, 8500),
        new ItemMenu("Croissant", CategoriaMenu.PANADERIA, 6000)
    ));
    IO.println("Promedio de precios en menú: $" + menu.promedioPrecio());

    IO.println("Filtrando solo bebidas mediante Pattern Matching:");
    for (ItemMenu it : menu.items()) {
        if (it instanceof ItemMenu(var nom, CategoriaMenu cat, var pr) && cat == CategoriaMenu.BEBIDA) {
            IO.println("  Bebida destacada: " + nom + " a $" + pr);
        }
    }
}
