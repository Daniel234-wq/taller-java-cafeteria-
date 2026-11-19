public class Caja {
    private int saldo;
    private int ventas;

    public int getSaldo() {
        return saldo;
    }

    public void cobrar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Cobro inválido: " + valor);
        }
        saldo += valor;
        ventas++;
    }

    public void retirar(int valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("No hay $" + valor + " en caja");
        }
        saldo -= valor;
    }

    public String resumen() {
        return ventas + " ventas · saldo $" + saldo;
    }
}
