package co.edu.sena.felipe.sem4;

/**
 * SEMANA 4: CLASES ABSTRACTAS E INTERFACES
 *
 * CLASE ABSTRACTA: ServicioAdicional
 * Define la estructura básica para todos los servicios adicionales
 * No se pueden crear objetos directamente de esta clase
 */
public abstract class ServicioAdicional {
    // ATRIBUTOS COMUNES
    protected String idServicio;
    protected String nombreServicio;
    protected double precioBase;
    protected boolean disponible;

    // CONSTRUCTOR
    public ServicioAdicional(String idServicio, String nombreServicio, double precioBase) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precioBase = precioBase;
        this.disponible = true;
    }

    // MÉTODO ABSTRACTO (debe ser implementado por las clases hijas)
    public abstract double calcularCosto();

    // MÉTODO ABSTRACTO
    public abstract String obtenerDescripcion();

    // MÉTODO ABSTRACTO
    public abstract String getCategoria();

    // MÉTODO CONCRETO (compartido por todos)
    public void mostrarInformacion() {
        System.out.println("════════════════════════════════════════════════");
        System.out.println("Servicio: " + nombreServicio);
        System.out.println("Categoría: " + getCategoria());
        System.out.println("Descripción: " + obtenerDescripcion());
        System.out.println("Precio: $" + String.format("%,.0f", calcularCosto()));
        System.out.println("Estado: " + (disponible ? "✓ DISPONIBLE" : "✗ NO DISPONIBLE"));
        System.out.println("════════════════════════════════════════════════");
    }

    // MÉTODO CONCRETO
    public void cambiarDisponibilidad() {
        this.disponible = !this.disponible;
        System.out.println("Servicio " + nombreServicio + " ahora está: " +
                (disponible ? "DISPONIBLE" : "NO DISPONIBLE"));
    }

    // GETTERS
    public String getIdServicio() { return idServicio; }
    public String getNombreServicio() { return nombreServicio; }
    public double getPrecioBase() { return precioBase; }
    public boolean isDisponible() { return disponible; }

    // SETTERS
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}