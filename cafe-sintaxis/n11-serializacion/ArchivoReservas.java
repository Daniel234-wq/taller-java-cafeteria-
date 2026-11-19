import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoReservas {
    private final Path archivo;
    private static final String FILTRO = "Reserva;java.util.ArrayList;java.lang.Object;!*";

    public ArchivoReservas(Path archivo) {
        this.archivo = archivo;
    }

    public void guardar(List<Reserva> reservas) throws IOException {
        try (var out = new ObjectOutputStream(Files.newOutputStream(archivo))) {
            out.writeObject(new ArrayList<>(reservas));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Reserva> cargar() throws IOException, ClassNotFoundException {
        if (Files.notExists(archivo)) {
            return List.of();
        }
        try (var in = new ObjectInputStream(Files.newInputStream(archivo))) {
            in.setObjectInputFilter(ObjectInputFilter.Config.createFilter(FILTRO));
            return (List<Reserva>) in.readObject();
        }
    }

    public void exportarCSV(Path rutaCsv, List<Reserva> reservas) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("id;cliente;personas;hora");
        for (Reserva r : reservas) {
            lineas.add(r.id() + ";" + r.cliente() + ";" + r.personas() + ";" + r.hora());
        }
        Files.write(rutaCsv, lineas);
    }
}
