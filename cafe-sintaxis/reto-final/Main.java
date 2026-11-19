import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

void main() throws Exception {
    IO.println("==========================================================");
    IO.println("    CAFÉ SINTAXIS 1.0 - SISTEMA INTEGRADO (N01 - N11)     ");
    IO.println("==========================================================");

    // 1. Catálogo de Productos con Repositorio Genérico (N01, N04, N05, N06, N08)
    IO.println("\n[1] CARGANDO CATÁLOGO EN REPOSITORIO GENÉRICO...");
    var catalogo = new Repositorio<Producto>();
    Bebida latte = new Bebida(1, "Latte Avellana", 8500, Categoria.CALIENTE, Tamano.GRANDE, true);
    Bebida americano = new Bebida(2, "Americano Clásico", 4500); // Constructor corto con prólogo Java 25
    Postre cheesecake = new Postre(3, "Cheesecake de Arándanos", 9000, false);
    Postre brownieVeg = new Postre(4, "Brownie Vegano", 7500, true);

    catalogo.guardar(latte);
    catalogo.guardar(americano);
    catalogo.guardar(cheesecake);
    catalogo.guardar(brownieVeg);

    for (Producto p : catalogo.listar()) {
        IO.println("  • " + p.ficha());
    }

    // 2. Composición de Pedidos (N04, N09)
    IO.println("\n[2] COMPONIENDO PEDIDO DE CLIENTE (MESA 7)...");
    Pedido pedidoMesa7 = new Pedido(7);
    pedidoMesa7.agregar(latte, 2);
    pedidoMesa7.agregar(brownieVeg, 1);
    pedidoMesa7.imprimir();

    // 3. Cobro en Caja con Arquitectura SOLID (N02, N07)
    IO.println("\n[3] COBRO EN CAJA REGISTRADORA SOLID...");
    Caja caja = new Caja(new NotificadorConsola());
    Descuento fidelidad = new Fidelidad();
    int cobroFinal = caja.cobrar(pedidoMesa7, fidelidad, "310-555-8989");
    IO.println("Saldo acumulado en caja: $" + caja.getSaldoEnCaja());

    // 4. Emisión de Recibo Inmutable con Records y Pattern Matching (N10)
    IO.println("\n[4] EMISIÓN DE AUDITORÍA (RECORDS & PATTERN MATCHING)...");
    List<LineaRecibo> lineasRecibo = new ArrayList<>();
    for (LineaPedido lp : pedidoMesa7.getLineas()) {
        lineasRecibo.add(new LineaRecibo(lp.getProducto().getNombre(), lp.getProducto().calcularPrecio(), lp.getCantidad()));
    }
    Recibo reciboFiscal = new Recibo(2026001, lineasRecibo);
    IO.println("Recibo Oficial #" + reciboFiscal.numero() + " emitido por $" + reciboFiscal.total());

    // Deconstrucción mediante Record Patterns
    for (LineaRecibo lr : reciboFiscal.lineas()) {
        if (lr instanceof LineaRecibo(var nombreProd, var precioUnit, var cant)) {
            IO.println("  Auditoría componente: " + cant + " unidad(es) de [" + nombreProd + "] valor unitario $" + precioUnit);
        }
    }

    // 5. Persistencia Segura de Bodega con Serialización y Filtro (N09, N11)
    IO.println("\n[5] PERSISTENCIA DE INVENTARIO (SERIALIZACIÓN FILTRADA Y CSV)...");
    Path archivoSer = Path.of("bodega_sintaxis.ser");
    Path archivoCsv = Path.of("bodega_sintaxis.csv");
    Almacen almacen = new Almacen(archivoSer);

    List<Insumo> existencias = List.of(
        new Insumo(1, "Café Especial Huila (kg)", 18),
        new Insumo(2, "Leche de Avena Barista (L)", 24),
        new Insumo(3, "Cacao Orgánico (kg)", 6)
    );

    almacen.guardar(existencias);
    IO.println("Inventario guardado en binario (" + Files.size(archivoSer) + " bytes).");

    List<Insumo> recuperados = almacen.cargar();
    IO.println("Inventario verificado con filtro de seguridad: " + recuperados);

    almacen.exportarCSV(archivoCsv, existencias);
    IO.println("Exportación a CSV generada exitosamente (" + Files.size(archivoCsv) + " bytes):");
    IO.println(Files.readString(archivoCsv).trim());

    IO.println("\n==========================================================");
    IO.println("    SISTEMA CAFÉ SINTAXIS 1.0 OPERANDO SATISFACTORIAMENTE  ");
    IO.println("==========================================================");
}
