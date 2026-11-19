public interface Formato {
    String dar(int total, int ventas);
}

class FormatoTexto implements Formato {
    public String dar(int total, int ventas) {
        return "REPORTE DIARIO: " + ventas + " ventas por un total de $" + total;
    }
}

class FormatoCSV implements Formato {
    public String dar(int total, int ventas) {
        return "ventas,total\n" + ventas + "," + total;
    }
}
