public class Tarjeta implements MedioDePago {
    private int saldo;

    public Tarjeta(int saldo) {
        this.saldo = saldo;
    }

    public String nombre() {
        return "Tarjeta bancaria";
    }

    public boolean pagar(int valor) {
        int costoTotal = valor + (valor * 2 / 100); // 2% de comisión
        if (costoTotal > saldo) {
            return false;
        }
        saldo -= costoTotal;
        return true;
    }
}
