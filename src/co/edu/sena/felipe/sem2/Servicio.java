package co.edu.sena.felipe.sem2;

/**
 * Clase que representa un servicio adicional que se puede contratar para un evento
 * Ejemplos: fotografía, música en vivo, decoración, bartender, etc.
 */
public class Servicio {
    // ATRIBUTOS
    private String idServicio;
    private String nombreServicio;
    private String categoria;  // "Entretenimiento", "Decoración", "Técnico", "Personal"
    private double precioBase;
    private String descripcion;
    private boolean disponible;

    // CONSTRUCTOR
    public Servicio(String idServicio, String nombreServicio, String categoria, double precioBase) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.categoria = categoria;
        this.precioBase = precioBase;
        this.descripcion = "Sin descripción";
        this.disponible = true;
    }

    // Constructor completo
    public Servicio(String idServicio, String nombreServicio, String categoria,
                    double precioBase, String descripcion) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.categoria = categoria;
        this.precioBase = precioBase;
        this.descripcion = descripcion;
        this.disponible = true;
    }

    // MÉTODOS DE NEGOCIO

    /**
     * Calcula el precio del servicio según el número de horas contratadas
     */
    public double calcularPrecioPorHoras(int horas) {
        if (horas <= 0) {
            System.out.println("Error: El número de horas debe ser mayor a 0");
            return 0;
        }
        return precioBase * horas;
    }

    /**
     * Aplica un descuento al precio base del servicio
     */
    public double aplicarDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 1) {
            System.out.println("Error: El descuento debe estar entre 0 y 1");
            return precioBase;
        }
        return precioBase - (precioBase * porcentajeDescuento);
    }

    /**
     * Muestra la información completa del servicio
     */
    public void mostrarInformacion() {
        System.out.println("════════════════════════════════════════════════");
        System.out.println("       INFORMACIÓN DEL SERVICIO");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("ID Servicio: " + idServicio);
        System.out.println("Nombre: " + nombreServicio);
        System.out.println("Categoría: " + categoria);
        System.out.println("Precio Base: $" + String.format("%,.0f", precioBase));
        System.out.println("Descripción: " + descripcion);
        System.out.println("Estado: " + (disponible ? "DISPONIBLE" : "NO DISPONIBLE"));
        System.out.println("════════════════════════════════════════════════");
    }

    /**
     * Cambia la disponibilidad del servicio
     */
    public void cambiarDisponibilidad(boolean estado) {
        this.disponible = estado;
        System.out.println("Servicio " + nombreServicio + " ahora está: " +
                (estado ? "DISPONIBLE" : "NO DISPONIBLE"));
    }

    /**
     * Obtiene información resumida del servicio
     */
    public String obtenerResumen() {
        return nombreServicio + " (" + categoria + ") - $" + String.format("%,.0f", precioBase);
    }

    // GETTERS Y SETTERS
    public String getIdServicio() {
        return idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
