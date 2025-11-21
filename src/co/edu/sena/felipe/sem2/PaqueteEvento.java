package co.edu.sena.felipe.sem2;

import java.util.ArrayList;

/**
 * Clase que representa un paquete de evento completo
 * Incluye el evento base más servicios adicionales contratados
 * RELACIÓN: Tiene un CateringEvent y múltiples Servicios
 */
public class PaqueteEvento {
    // ATRIBUTOS
    private String idPaquete;
    private CateringEvent evento;              // RELACIÓN: Un paquete tiene UN evento
    private ArrayList<Servicio> servicios;     // RELACIÓN: Un paquete tiene MÚLTIPLES servicios
    private String estadoPaquete;              // "Cotizado", "Confirmado", "En Proceso", "Finalizado"
    private double descuentoPaquete;

    // CONSTRUCTOR
    public PaqueteEvento(String idPaquete, CateringEvent evento) {
        this.idPaquete = idPaquete;
        this.evento = evento;
        this.servicios = new ArrayList<>();
        this.estadoPaquete = "Cotizado";
        this.descuentoPaquete = 0.0;
    }

    // Constructor con descuento
    public PaqueteEvento(String idPaquete, CateringEvent evento, double descuentoPaquete) {
        this.idPaquete = idPaquete;
        this.evento = evento;
        this.servicios = new ArrayList<>();
        this.estadoPaquete = "Cotizado";
        this.descuentoPaquete = descuentoPaquete;
    }

    // MÉTODOS DE NEGOCIO

    /**
     * Agrega un servicio adicional al paquete
     */
    public void agregarServicio(Servicio servicio) {
        if (servicio.isDisponible()) {
            servicios.add(servicio);
            System.out.println("✓ Servicio '" + servicio.getNombreServicio() +
                    "' agregado al paquete " + idPaquete);
        } else {
            System.out.println("✗ El servicio '" + servicio.getNombreServicio() +
                    "' no está disponible");
        }
    }

    /**
     * Elimina un servicio del paquete por su ID
     */
    public boolean eliminarServicio(String idServicio) {
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getIdServicio().equals(idServicio)) {
                Servicio removido = servicios.remove(i);
                System.out.println("✓ Servicio '" + removido.getNombreServicio() +
                        "' eliminado del paquete");
                return true;
            }
        }
        System.out.println("✗ Servicio no encontrado en el paquete");
        return false;
    }

    /**
     * Calcula el costo total del paquete (evento + todos los servicios)
     */
    public double calcularCostoTotal() {
        double costoEvento = evento.getCostoTotal();
        double costoServicios = 0;

        for (Servicio servicio : servicios) {
            costoServicios += servicio.getPrecioBase();
        }

        double subtotal = costoEvento + costoServicios;
        double total = subtotal - (subtotal * descuentoPaquete);

        return total;
    }

    /**
     * Muestra el detalle completo del paquete
     */
    public void mostrarDetallePaquete() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║          DETALLE DEL PAQUETE                   ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("ID Paquete: " + idPaquete);
        System.out.println("Estado: " + estadoPaquete);
        System.out.println();

        // Mostrar información del evento
        System.out.println("--- EVENTO BASE ---");
        System.out.println("Código: " + evento.getEventCode());
        System.out.println("Tipo: " + evento.getEventType());
        System.out.println("Invitados: " + evento.getGuestCount());
        System.out.println("Costo Evento: $" + String.format("%,.0f", evento.getCostoTotal()));

        // Mostrar servicios adicionales
        System.out.println("\n--- SERVICIOS ADICIONALES (" + servicios.size() + ") ---");
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios adicionales contratados");
        } else {
            double totalServicios = 0;
            for (Servicio servicio : servicios) {
                System.out.println("• " + servicio.obtenerResumen());
                totalServicios += servicio.getPrecioBase();
            }
            System.out.println("Subtotal Servicios: $" + String.format("%,.0f", totalServicios));
        }

        // Mostrar totales
        double subtotal = evento.getCostoTotal();
        for (Servicio s : servicios) {
            subtotal += s.getPrecioBase();
        }

        System.out.println("\n--- RESUMEN DE COSTOS ---");
        System.out.println("Subtotal: $" + String.format("%,.0f", subtotal));
        if (descuentoPaquete > 0) {
            System.out.println("Descuento Paquete: " + (descuentoPaquete * 100) + "%");
            System.out.println("Ahorro: $" + String.format("%,.0f", (subtotal * descuentoPaquete)));
        }
        System.out.println("COSTO TOTAL: $" + String.format("%,.0f", calcularCostoTotal()));
        System.out.println("════════════════════════════════════════════════\n");
    }

    /**
     * Cambia el estado del paquete
     */
    public void cambiarEstado(String nuevoEstado) {
        String[] estadosValidos = {"Cotizado", "Confirmado", "En Proceso", "Finalizado", "Cancelado"};

        for (String estado : estadosValidos) {
            if (estado.equals(nuevoEstado)) {
                this.estadoPaquete = nuevoEstado;
                System.out.println("✓ Estado del paquete actualizado a: " + nuevoEstado);
                return;
            }
        }
        System.out.println("✗ Estado no válido");
    }

    /**
     * Cuenta la cantidad de servicios por categoría
     */
    public int contarServiciosPorCategoria(String categoria) {
        int contador = 0;
        for (Servicio servicio : servicios) {
            if (servicio.getCategoria().equalsIgnoreCase(categoria)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Lista todos los servicios del paquete
     */
    public void listarServicios() {
        System.out.println("\n--- SERVICIOS DEL PAQUETE " + idPaquete + " ---");
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios en este paquete");
        } else {
            for (int i = 0; i < servicios.size(); i++) {
                System.out.println((i + 1) + ". " + servicios.get(i).obtenerResumen());
            }
        }
    }

    // GETTERS Y SETTERS
    public String getIdPaquete() {
        return idPaquete;
    }

    public CateringEvent getEvento() {
        return evento;
    }

    public void setEvento(CateringEvent evento) {
        this.evento = evento;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public String getEstadoPaquete() {
        return estadoPaquete;
    }

    public void setEstadoPaquete(String estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }

    public double getDescuentoPaquete() {
        return descuentoPaquete;
    }

    public void setDescuentoPaquete(double descuentoPaquete) {
        this.descuentoPaquete = descuentoPaquete;
    }

    public int getCantidadServicios() {
        return servicios.size();
    }
}

