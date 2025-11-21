package co.edu.sena.felipe.sem2;

public class Cliente {

    private String idCliente;
    private String nombreCompleto;
    private String telefono;
    private String email;
    private String tipoCliente;      // "Personal" o "Corporativo"
    private int eventosContratados;
    private double descuento;        // Descuento por fidelidad (0.0 a 1.0)

    // CONSTRUCTOR
    public Cliente(String idCliente, String nombreCompleto, String telefono, String email) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
        this.tipoCliente = "Personal";  // Por defecto
        this.eventosContratados = 0;
        this.descuento = 0.0;
    }

    // Constructor sobrecargado con tipo de cliente
    public Cliente(String idCliente, String nombreCompleto, String telefono,
                   String email, String tipoCliente) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
        this.tipoCliente = tipoCliente;
        this.eventosContratados = 0;
        this.descuento = 0.0;
    }

    // MÉTODOS

    /**
     * Muestra toda la información del cliente
     */
    public void mostrarDatos() {
        System.out.println("════════════════════════════════════════════════");
        System.out.println("       INFORMACIÓN DEL CLIENTE         ");
        System.out.println("════════════════════════════════════════════════");
        System.out.println("ID Cliente: " + idCliente);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Tipo de Cliente: " + tipoCliente);
        System.out.println("Eventos Contratados: " + eventosContratados);
        System.out.println("Descuento por Fidelidad: " + (descuento * 100) + "%");
        System.out.println("Estado: " + (esClienteFrecuente() ? "CLIENTE FRECUENTE" : "CLIENTE REGULAR"));
        System.out.println("════════════════════════════════════════════════");
    }

    public void contratarEvento() {
        eventosContratados++;
        System.out.println("✓ Evento registrado para el cliente: " + nombreCompleto);

        // Aplicar descuento por fidelidad
        if (eventosContratados >= 10) {
            descuento = 0.15;  // 15% de descuento
            System.out.println("¡Felicidades! Ha alcanzado descuento del 15%");
        } else if (eventosContratados >= 5) {
            descuento = 0.10;  // 10% de descuento
            System.out.println("¡Ha alcanzado descuento del 10%!");
        } else if (eventosContratados >= 3) {
            descuento = 0.05;  // 5% de descuento
            System.out.println("¡Ha alcanzado descuento del 5%!");
        }
    }

    public boolean esClienteFrecuente() {
        return eventosContratados >= 3;
    }

    public double calcularPrecioConDescuento(double precioBase) {
        double precioFinal = precioBase - (precioBase * descuento);
        return precioFinal;
    }

    public void mostrarCalculoDescuento(double precioBase) {
        System.out.println("\n--- CÁLCULO DE PRECIO ---");
        System.out.println("Precio Base: $" + String.format("%,.0f", precioBase));
        System.out.println("Descuento Aplicado: " + (descuento * 100) + "%");
        System.out.println("Ahorro: $" + String.format("%,.0f", (precioBase * descuento)));
        System.out.println("Precio Final: $" + String.format("%,.0f", calcularPrecioConDescuento(precioBase)));
    }

    public boolean validarEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }

    public void cambiarTipoCliente(String nuevoTipo) {
        if (nuevoTipo.equals("Personal") || nuevoTipo.equals("Corporativo")) {
            this.tipoCliente = nuevoTipo;
            System.out.println("Tipo de cliente actualizado a: " + nuevoTipo);
        } else {
            System.out.println("Error: Tipo de cliente no válido");
        }
    }

    // GETTERS Y SETTERS

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public int getEventosContratados() {
        return eventosContratados;
    }

    public double getDescuento() {
        return descuento;
    }
}
