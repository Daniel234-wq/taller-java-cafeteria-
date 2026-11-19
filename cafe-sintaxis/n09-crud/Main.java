import java.util.ArrayList;
import java.util.List;

void main() {
    IO.println("=== Nivel 09: CRUD Paso a Paso con ArrayList ===");

    // Caso de estudio: Inventario CRUD en memoria
    IO.println("--- Inventario de la Barra ---");
    Inventario inv = new Inventario();
    inv.crear("Leche entera (L)", 12);
    inv.crear("Café en grano (kg)", 5);
    inv.crear("Avena (L)", 3);

    IO.println("1 Listado inicial: " + inv.listar());
    IO.println("2 Buscar #2: " + inv.buscar(2).orElseThrow());
    IO.println("3 ¿Existe #9? " + inv.buscar(9).isPresent());

    inv.actualizar(1, 20); // Recuento semanal
    inv.eliminar(3);       // Eliminación por ID

    var lista = inv.listar();
    IO.println("4 Tras actualizar y eliminar: " + lista);
    IO.println("5 Primero (Sequenced): " + lista.getFirst());
    IO.println("6 Último (Sequenced): " + lista.getLast());

    // Reto autocompletado: Lista de espera
    IO.println("\n--- Reto Autocompletado: Lista de Espera ---");
    List<String> espera = new ArrayList<>();
    espera.add("Rojas (4)");
    espera.add("Gómez (2)");
    espera.add("Pérez (3)");
    IO.println("En espera: " + espera.size());
    IO.println("Sigue: " + espera.getFirst());
    espera.set(1, "Gómez (5)"); // Modificar
    espera.removeIf(n -> n.startsWith("Rojas")); // Eliminar con predicado lambda
    IO.println("Lista restante: " + espera);
    IO.println("¿Está Pérez? " + espera.contains("Pérez (3)"));

    // Reto libre: Agenda de Reservas
    IO.println("\n--- Reto Libre: Agenda de Reservas ---");
    Agenda agenda = new Agenda();
    agenda.crear("Familia Martínez", 4, "19:00");
    agenda.crear("Carlos López", 2, "19:30");
    agenda.crear("Laura Gómez", 6, "19:00");

    IO.println("Reservas registradas: " + agenda.listar());
    IO.println("Reservas de las 19:00: " + agenda.deLaHora("19:00"));

    agenda.cambiarHora(2, "20:00");
    IO.println("Reserva #2 tras cambio de hora: " + agenda.buscar(2).orElseThrow());

    agenda.cancelar(1);
    IO.println("Reservas tras cancelar #1: " + agenda.listar());
}
