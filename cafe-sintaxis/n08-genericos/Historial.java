import java.util.ArrayList;
import java.util.List;

public class Historial<T> {
    private final List<T> elementos = new ArrayList<>();
    private final int capacidad;

    public Historial(int capacidad) {
        this.capacidad = capacidad;
    }

    public void agregar(T item) {
        if (elementos.size() >= capacidad) {
            elementos.removeFirst();
        }
        elementos.add(item);
    }

    public T masReciente() {
        return elementos.getLast();
    }

    public List<T> todos() {
        return List.copyOf(elementos);
    }
}
