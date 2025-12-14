package co.edu.sena.felipe.sem6;

/**
 * Clase EventoCompleto para usar en colecciones
 */
class EventoCompleto {
    private String id;
    private String nombre;
    private String tipo;
    private String fecha;
    private String ubicacion;
    private int invitados;
    private double costo;

    public EventoCompleto(String id, String nombre, String tipo, String fecha,
                          String ubicacion, int invitados, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.invitados = invitados;
        this.costo = costo;
    }

    public void mostrarInfo() {
        System.out.println("\n--- EVENTO: " + nombre + " ---");
        System.out.println("ID: " + id);
        System.out.println("Tipo: " + tipo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Invitados: " + invitados);
        System.out.println("Costo: $" + String.format("%,.0f", costo));
    }

    // GETTERS
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public String getFecha() { return fecha; }
    public String getUbicacion() { return ubicacion; }
    public int getInvitados() { return invitados; }
    public double getCosto() { return costo; }

    // SETTERS
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setCosto(double costo) { this.costo = costo; }
}

/**
 * Clase ClienteVIP para LinkedHashMap
 */
class ClienteVIP {
    private String id;
    private String nombre;
    private String telefono;
    private int eventosContratados;
    private double descuento;

    public ClienteVIP(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.eventosContratados = 0;
        this.descuento = 0;
    }

    public void contratarEvento() {
        eventosContratados++;

        if (eventosContratados >= 10) {
            descuento = 20;
        } else if (eventosContratados >= 5) {
            descuento = 15;
        } else if (eventosContratados >= 3) {
            descuento = 10;
        }
    }

    public void mostrarInfo() {
        System.out.println("\n👑 CLIENTE VIP: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Eventos Contratados: " + eventosContratados);
        System.out.println("Descuento: " + descuento + "%");
    }

    // GETTERS
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public int getEventosContratados() { return eventosContratados; }
    public double getDescuento() { return descuento; }
}