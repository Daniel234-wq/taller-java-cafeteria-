public class BotePropinas {
    private int total;
    private int aportes;

    public void aportar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El aporte debe ser mayor a 0: " + valor);
        }
        total += valor;
        aportes++;
    }

    public int repartir(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 persona para repartir");
        }
        return total / personas;
    }

    public int sobrante(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 persona para calcular sobrante");
        }
        return total % personas;
    }

    public int getTotal() {
        return total;
    }

    public int getAportes() {
        return aportes;
    }
}
