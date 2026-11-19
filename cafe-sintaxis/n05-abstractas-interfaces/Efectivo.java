public class Efectivo implements MedioDePago {
    public String nombre() {
        return "Efectivo";
    }

    public boolean pagar(int valor) {
        return true; // Siempre se recibe
    }
}
