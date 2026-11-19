import java.util.List;

public class Totales {
    private final int total;
    private final int ventas;

    public Totales(List<Integer> montos) {
        int sum = 0;
        for (int m : montos) {
            sum += m;
        }
        this.total = sum;
        this.ventas = montos.size();
    }

    public int getTotal() { return total; }
    public int getVentas() { return ventas; }
}
