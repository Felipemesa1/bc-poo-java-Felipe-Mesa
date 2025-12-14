package co.edu.sena.felipe.sem4;

public abstract class ServicioAdicional {
    protected String idServicio;
    protected String nombreServicio;
    protected double precioBase;
    protected boolean disponible;

    public ServicioAdicional(String idServicio, String nombreServicio, double precioBase) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precioBase = precioBase;
        this.disponible = true;
    }

    public abstract double calcularCosto();
    public abstract String obtenerDescripcion();
    public abstract String getCategoria();

    public void mostrarInformacion() {
        System.out.println("════════════════════════════════════════════════");
        System.out.println("Servicio: " + nombreServicio);
        System.out.println("Categoría: " + getCategoria());
        System.out.println("Descripción: " + obtenerDescripcion());
        System.out.println("Precio: $" + String.format("%,.0f", calcularCosto()));
        System.out.println("Estado: " + (disponible ? "✓ DISPONIBLE" : "✗ NO DISPONIBLE"));
        System.out.println("════════════════════════════════════════════════");
    }

    public void cambiarDisponibilidad() {
        this.disponible = !this.disponible;
        System.out.println("Servicio " + nombreServicio + " ahora está: " +
                (disponible ? "DISPONIBLE" : "NO DISPONIBLE"));
    }

    public String getIdServicio() { return idServicio; }
    public String getNombreServicio() { return nombreServicio; }
    public double getPrecioBase() { return precioBase; }
    public boolean isDisponible() { return disponible; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}