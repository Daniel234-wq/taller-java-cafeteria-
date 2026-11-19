import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

class CsvHelper {
    static String aLinea(Insumo i) {
        return i.id() + ";" + i.nombre() + ";" + i.cantidad();
    }

    static Insumo deLinea(String linea) {
        String[] p = linea.split(";");
        return new Insumo(Integer.parseInt(p[0]), p[1], Integer.parseInt(p[2]));
    }
}

void main() throws Exception {
    IO.println("=== Nivel 11: Serialización Moderna con Archivos ===");

    // Caso de estudio: Almacén binario protegido con ObjectInputFilter
    IO.println("--- Almacén de Bodega (.ser con Filtro) ---");
    Path serPath = Path.of("bodega.ser");
    Almacen almacen = new Almacen(serPath);

    IO.println("Al abrir (estado inicial): " + almacen.cargar());

    List<Insumo> hoy = List.of(
        new Insumo(1, "Leche entera (L)", 20),
        new Insumo(2, "Café en grano (kg)", 5)
    );
    almacen.guardar(hoy);
    long bytes = Files.size(serPath);
    IO.println("Guardado en disco: " + bytes + " bytes");

    List<Insumo> leidos = almacen.cargar();
    IO.println("Leído de archivo: " + leidos);
    IO.println("¿Objetos reconstruidos iguales a memoria? " + hoy.equals(leidos));

    // Práctica guiada: Persistencia en Texto Plano CSV
    IO.println("\n--- Práctica Guiada: Copia CSV para Contabilidad ---");
    Path csvPath = Path.of("bodega.csv");
    List<String> lineasCsv = new ArrayList<>();
    for (Insumo i : hoy) {
        lineasCsv.add(CsvHelper.aLinea(i));
    }
    Files.write(csvPath, lineasCsv);
    IO.println("Contenido de bodega.csv:\n" + Files.readString(csvPath).trim());

    List<Insumo> leidosCsv = new ArrayList<>();
    for (String l : Files.readAllLines(csvPath)) {
        leidosCsv.add(CsvHelper.deLinea(l));
    }
    IO.println("Insumos recuperados de CSV: " + leidosCsv);
    IO.println(Files.size(csvPath) + " bytes CSV · ¿Iguales? " + hoy.equals(leidosCsv));

    // Reto autocompletado: Turno serializable
    IO.println("\n--- Reto Autocompletado: Turno con Filtro ---");
    Path turnoPath = Path.of("turno.ser");
    try (var out = new ObjectOutputStream(Files.newOutputStream(turnoPath))) {
        out.writeObject(new Turno("Martín", 42));
    }
    try (var in = new ObjectInputStream(Files.newInputStream(turnoPath))) {
        in.setObjectInputFilter(ObjectInputFilter.Config.createFilter("Turno;!*"));
        Turno t = (Turno) in.readObject();
        IO.println(t + " · " + Files.size(turnoPath) + " bytes");
    }

    // Reto libre: Agenda que no olvida
    IO.println("\n--- Reto Libre: Archivo de Reservas con Exportación CSV ---");
    Path reservasPath = Path.of("reservas.ser");
    Path reservasCsv = Path.of("reservas.csv");
    ArchivoReservas archReservas = new ArchivoReservas(reservasPath);

    List<Reserva> listaReservas = List.of(
        new Reserva(1, "Valeria Restrepo", 4, "18:00"),
        new Reserva(2, "Martín Cajero", 2, "19:30")
    );
    archReservas.guardar(listaReservas);
    List<Reserva> recuperadas = archReservas.cargar();
    IO.println("Reservas cargadas desde disco: " + recuperadas);

    archReservas.exportarCSV(reservasCsv, recuperadas);
    IO.println("Archivo reservas.csv exportado:\n" + Files.readString(reservasCsv).trim());
}
