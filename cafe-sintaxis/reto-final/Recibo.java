import java.util.List;

public record Recibo(int numero, List<LineaRecibo> lineas) {
    public Recibo {
        if (numero < 1) {
            throw new IllegalArgumentException("Número de recibo inválido");
        }
        if (lineas == null) {
            throw new IllegalArgumentException("Las líneas del recibo son requeridas");
        }
        lineas = List.copyOf(lineas);
    }

    public int total() {
        int t = 0;
        for (LineaRecibo l : lineas) {
            t += l.subtotal();
        }
        return t;
    }
}
