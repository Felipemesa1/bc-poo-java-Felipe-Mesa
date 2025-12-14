package co.edu.sena.felipe.sem2;
import java.util.ArrayList;

public class GestoraEventos {
// atributos
    private String nombreEmpresa;
    private ArrayList<PaqueteEvento> paquetes;
    private ArrayList<Cliente> clientes;
    private ArrayList<Servicio> catalogoServicios;

    public GestoraEventos(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.paquetes = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.catalogoServicios = new ArrayList<>();
    }

    public void agregarPaquete(PaqueteEvento paquete) {
        paquetes.add(paquete);
        System.out.println("✓ Paquete " + paquete.getIdPaquete() + " agregado exitosamente");
    }

    public PaqueteEvento buscarPaquete(String idPaquete) {
        for (PaqueteEvento paquete : paquetes) {
            if (paquete.getIdPaquete().equals(idPaquete)) {
                return paquete;
            }
        }
        return null;
    }

    public boolean eliminarPaquete(String idPaquete) {
        for (int i = 0; i < paquetes.size(); i++) {
            if (paquetes.get(i).getIdPaquete().equals(idPaquete)) {
                paquetes.remove(i);
                System.out.println("✓ Paquete " + idPaquete + " eliminado");
                return true;
            }
        }
        System.out.println("✗ Paquete no encontrado");
        return false;
    }

    public void mostrarTodosPaquetes() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           LISTA DE TODOS LOS PAQUETES          ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        if (paquetes.isEmpty()) {
            System.out.println("No hay paquetes registrados");
        } else {
            for (int i = 0; i < paquetes.size(); i++) {
                PaqueteEvento p = paquetes.get(i);
                System.out.println("\n" + (i + 1) + ". Paquete: " + p.getIdPaquete());
                System.out.println("   Evento: " + p.getEvento().getEventType());
                System.out.println("   Estado: " + p.getEstadoPaquete());
                System.out.println("   Servicios: " + p.getCantidadServicios());
                System.out.println("   Costo Total: $" + String.format("%,.0f", p.calcularCostoTotal()));
            }
        }
        System.out.println("════════════════════════════════════════════════\n");
    }

    public void mostrarEstadisticasPorEstado() {
        int cotizados = 0, confirmados = 0, enProceso = 0, finalizados = 0;

        for (PaqueteEvento paquete : paquetes) {
            switch (paquete.getEstadoPaquete()) {
                case "Cotizado":
                    cotizados++;
                    break;
                case "Confirmado":
                    confirmados++;
                    break;
                case "En Proceso":
                    enProceso++;
                    break;
                case "Finalizado":
                    finalizados++;
                    break;
            }
        }

        System.out.println("\n--- ESTADÍSTICAS POR ESTADO ---");
        System.out.println("Cotizados: " + cotizados);
        System.out.println("Confirmados: " + confirmados);
        System.out.println("En Proceso: " + enProceso);
        System.out.println("Finalizados: " + finalizados);
        System.out.println("TOTAL: " + paquetes.size());
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("✓ Cliente " + cliente.getNombreCompleto() + " registrado");
    }

    public Cliente buscarCliente(String idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente().equals(idCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public void mostrarTodosClientes() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║              LISTA DE CLIENTES                 ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);
                System.out.println((i + 1) + ". " + c.getNombreCompleto() + " (" + c.getTipoCliente() + ")");
            }
        }
        System.out.println();
    }

    public void agregarServicioACatalogo(Servicio servicio) {
        catalogoServicios.add(servicio);
        System.out.println("✓ Servicio '" + servicio.getNombreServicio() + "' agregado al catálogo");
    }

    public void mostrarCatalogoServicios() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           CATÁLOGO DE SERVICIOS                ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        if (catalogoServicios.isEmpty()) {
            System.out.println("No hay servicios en el catálogo");
        } else {
            for (int i = 0; i < catalogoServicios.size(); i++) {
                Servicio s = catalogoServicios.get(i);
                System.out.println((i + 1) + ". " + s.obtenerResumen() + " - " + (s.isDisponible() ? "✓" : "✗"));
            }
        }
        System.out.println();
    }

    public ArrayList<Servicio> buscarServiciosPorCategoria(String categoria) {
        ArrayList<Servicio> encontrados = new ArrayList<>();
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getCategoria().equalsIgnoreCase(categoria)) {
                encontrados.add(servicio);
            }
        }
        return encontrados;
    }

    public double calcularIngresoTotal() {
        double total = 0;
        for (PaqueteEvento paquete : paquetes) {
            if (!paquete.getEstadoPaquete().equals("Cancelado")) {
                total += paquete.calcularCostoTotal();
            }
        }
        return total;
    }

    public void generarReporteEjecutivo() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           REPORTE EJECUTIVO                    ║");
        System.out.println("║           " + nombreEmpresa + "                    ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("\n📊 RESUMEN GENERAL:");
        System.out.println(" • Total de Paquetes: " + paquetes.size());
        System.out.println(" • Total de Clientes: " + clientes.size());
        System.out.println(" • Servicios en Catálogo: " + catalogoServicios.size());
        System.out.println(" • Ingreso Total: $" + String.format("%,.0f", calcularIngresoTotal()));

        mostrarEstadisticasPorEstado();
        System.out.println("\n════════════════════════════════════════════════\n");
    }

    public PaqueteEvento obtenerPaqueteMasCostoso() {
        if (paquetes.isEmpty()) {
            return null;
        }

        PaqueteEvento masCostoso = paquetes.get(0);
        for (PaqueteEvento paquete : paquetes) {
            if (paquete.calcularCostoTotal() > masCostoso.calcularCostoTotal()) {
                masCostoso = paquete;
            }
        }
        return masCostoso;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int contarPaquetes() {
        return paquetes.size();
    }

    public int contarClientes() {
        return clientes.size();
    }

    public int contarServicios() {
        return catalogoServicios.size();
    }

    public ArrayList<PaqueteEvento> getPaquetes() {
        return paquetes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }
}
