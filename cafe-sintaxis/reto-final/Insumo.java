import java.io.Serializable;

public record Insumo(int id, String nombre, int cantidad) implements Serializable {
    public Insumo {
        if (id < 1) {
            throw new IllegalArgumentException("Id de insumo inválido");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre de insumo inválido");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad negativa rechazada");
        }
    }
}
