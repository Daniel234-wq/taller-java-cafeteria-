public class Fidelidad implements Descuento {
    public int aplicar(int total) {
        return Math.max(0, total - 2000); // Cumple el principio de sustitución de Liskov
    }
}
