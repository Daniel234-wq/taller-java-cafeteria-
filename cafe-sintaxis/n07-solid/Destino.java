import java.util.ArrayList;
import java.util.List;

public interface Destino {
    void enviar(String texto);
}

class DestinoConsola implements Destino {
    public void enviar(String texto) {
        IO.println(texto);
    }
}

class DestinoMemoria implements Destino {
    private final List<String> registros = new ArrayList<>();

    public void enviar(String texto) {
        registros.add(texto);
    }

    public List<String> getRegistros() {
        return List.copyOf(registros);
    }
}
