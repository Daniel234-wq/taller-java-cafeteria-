import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private final Path archivo;
    private static final String PERMITIDOS =
            "Insumo;java.lang.String;java.lang.Integer;java.util.ArrayList;java.lang.Object;!*";

    public Almacen(Path archivo) {
        this.archivo = archivo;
    }

    public void guardar(List<Insumo> insumos) throws IOException {
        if (insumos == null) {
            throw new IllegalArgumentException("La lista de insumos no puede ser nula");
        }
        Path parent = archivo.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        try (var out = new ObjectOutputStream(Files.newOutputStream(archivo))) {
            out.writeObject(new ArrayList<>(insumos));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Insumo> cargar() throws IOException, ClassNotFoundException {
        if (Files.notExists(archivo)) {
            return List.of();
        }
        try (var in = new ObjectInputStream(Files.newInputStream(archivo))) {
            in.setObjectInputFilter(ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Insumo>) in.readObject();
        }
    }

    public void exportarCSV(Path rutaCsv, List<Insumo> insumos) throws IOException {
        if (rutaCsv == null) {
            throw new IllegalArgumentException("La ruta CSV no puede ser nula");
        }
        if (insumos == null) {
            throw new IllegalArgumentException("La lista de insumos no puede ser nula");
        }

        Path parent = rutaCsv.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        List<String> lineas = new ArrayList<>();
        lineas.add("id;nombre;cantidad");
        for (Insumo i : insumos) {
            lineas.add(i.id() + ";" + i.nombre() + ";" + i.cantidad());
        }
        Files.write(rutaCsv, lineas);
    }
}
