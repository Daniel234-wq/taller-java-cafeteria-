import java.util.EnumMap;
import java.util.Map;

void main() {
    IO.println("=== Nivel 06: Enum - Valores con Nombre ===");

    // Caso de estudio: Tamano y EstadoPedido
    IO.println("--- Tamaños de Vaso ---");
    for (Tamano t : Tamano.values()) {
        IO.println(t + ": " + t.ml() + " ml, +$" + t.recargo());
    }

    IO.println("\n--- Ciclo de Estado del Pedido ---");
    EstadoPedido e = EstadoPedido.RECIBIDO;
    while (e != EstadoPedido.ENTREGADO) {
        e = e.siguiente();
        String aviso = switch (e) {
            case EN_PREPARACION -> "En barra";
            case LISTO -> "¡Listo para recoger!";
            default -> "Entregado";
        };
        IO.println(e.ordinal() + " " + e + " → " + aviso);
    }

    var conteo = new EnumMap<EstadoPedido, Integer>(EstadoPedido.class);
    conteo.put(EstadoPedido.LISTO, 3);
    conteo.put(EstadoPedido.RECIBIDO, 5);
    IO.println("\nConteo por estado (EnumMap): " + conteo);
    IO.println("Mililitros de GRANDE: " + Tamano.valueOf("GRANDE").ml());

    // Práctica guiada: Ventas por Categoria
    IO.println("\n--- Práctica Guiada: Ventas por Categoría ---");
    Map<Categoria, Integer> ventas = new EnumMap<>(Categoria.class);
    ventas.put(Categoria.FRIA, 12000);
    ventas.put(Categoria.CALIENTE, 13000);
    ventas.put(Categoria.POSTRE, 7000);

    for (Categoria c : ventas.keySet()) {
        IO.println(c.etiqueta() + ": $" + ventas.get(c));
    }
    for (Categoria c : Categoria.values()) {
        if (!ventas.containsKey(c)) {
            IO.println("Sin ventas: " + c.etiqueta());
        }
    }

    // Reto autocompletado: Leches vegetales
    IO.println("\n--- Reto Autocompletado: Leches Vegetales ---");
    for (Leche l : Leche.values()) {
        if (l.vegetal()) {
            IO.println(l + " +$" + l.recargo());
        }
    }

    // Reto libre: Plano del Salón
    IO.println("\n--- Reto Libre: Plano de Mesas con EnumMap ---");
    EstadoMesa[] salon = {
        EstadoMesa.LIBRE, EstadoMesa.OCUPADA, EstadoMesa.LIBRE, EstadoMesa.RESERVADA,
        EstadoMesa.POR_LIMPIAR, EstadoMesa.OCUPADA, EstadoMesa.LIBRE, EstadoMesa.FUERA_DE_SERVICIO
    };

    var conteoMesas = new EnumMap<EstadoMesa, Integer>(EstadoMesa.class);
    for (EstadoMesa mesa : salon) {
        conteoMesas.put(mesa, conteoMesas.getOrDefault(mesa, 0) + 1);
    }
    IO.println("Conteo inicial de mesas: " + conteoMesas);

    // Avanzar cada mesa
    for (int i = 0; i < salon.length; i++) {
        salon[i] = salon[i].siguiente();
    }

    var conteoAvanzado = new EnumMap<EstadoMesa, Integer>(EstadoMesa.class);
    for (EstadoMesa mesa : salon) {
        conteoAvanzado.put(mesa, conteoAvanzado.getOrDefault(mesa, 0) + 1);
    }
    IO.println("Conteo tras transición: " + conteoAvanzado);
}
