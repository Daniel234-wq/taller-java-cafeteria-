import java.io.Serializable;

public record Turno(String barista, int bebidas) implements Serializable {
    public Turno {
        if (bebidas < 0) {
            throw new IllegalArgumentException("Bebidas no pueden ser negativas: " + bebidas);
        }
    }
}
