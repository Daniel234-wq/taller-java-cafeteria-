public class Porcentaje implements Descuento {
    private final int porcentaje;

    public Porcentaje(int porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("Porcentaje debe estar entre 0 y 100");
        }
        this.porcentaje = porcentaje;
    }

    public int aplicar(int total) {
        return total * (100 - porcentaje) / 100;
    }
}
