import java.util.List;

public class ReporteDiario {
    private final Formato formato;
    private final Destino destino;

    public ReporteDiario(Formato formato, Destino destino) {
        this.formato = formato;
        this.destino = destino;
    }

    public void emitir(List<Integer> montos) {
        Totales t = new Totales(montos);
        String salida = formato.dar(t.getTotal(), t.getVentas());
        destino.enviar(salida);
    }
}
