package co.edu.sena.felipe.sem6;

public class ClienteVIP {
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

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public int getEventosContratados() { return eventosContratados; }
    public double getDescuento() { return descuento; }
}