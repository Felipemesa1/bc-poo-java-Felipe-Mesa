package co.edu.sena.felipe.sem1;

public class CateringEvent {
    // ATRIBUTOS
    private String eventCode;
    private String eventType;
    private int guestCount;
    private String fecha;
    private String ubicacion;
    private String tipoMenu;
    private double costoTotal;
    private Cliente cliente;  // RELACIÓN CON CLIENTE

    // Constructor original
    public CateringEvent(String eventCode, String eventType, int guestCount) {
        this.eventCode = eventCode;
        this.eventType = eventType;
        this.guestCount = guestCount;
        this.fecha = "Por definir";
        this.ubicacion = "Por definir";
        this.tipoMenu = asignarMenuPorDefecto(eventType);
        this.costoTotal = calcularCosto();
        this.cliente = null;
    }

    // Constructor completo
    public CateringEvent(String eventCode, String eventType, int guestCount,
                         String fecha, String ubicacion, String tipoMenu) {
        this.eventCode = eventCode;
        this.eventType = eventType;
        this.guestCount = guestCount;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.tipoMenu = tipoMenu;
        this.costoTotal = calcularCosto();
        this.cliente = null;
    }

    // Constructor con cliente
    public CateringEvent(String eventCode, String eventType, int guestCount,
                         String fecha, String ubicacion, String tipoMenu, Cliente cliente) {
        this.eventCode = eventCode;
        this.eventType = eventType;
        this.guestCount = guestCount;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.tipoMenu = tipoMenu;
        this.cliente = cliente;
        this.costoTotal = calcularCostoConDescuento();
    }

    // Asignar menú por defecto según tipo de evento
    private String asignarMenuPorDefecto(String tipoEvento) {
        switch (tipoEvento.toLowerCase()) {
            case "boda":
            case "matrimonio":
                return "Premium";
            case "evento corporativo":
            case "graduacion":
                return "Estándar";
            default:
                return "Básico";
        }
    }

    // Calcular costo del evento
    private double calcularCosto() {
        double costoPorPersona;
        switch (tipoMenu) {
            case "Premium":
                costoPorPersona = 60000;
                break;
            case "Estándar":
                costoPorPersona = 40000;
                break;
            case "Básico":
                costoPorPersona = 25000;
                break;
            default:
                costoPorPersona = 25000;
        }
        return guestCount * costoPorPersona;
    }

    // Calcular costo con descuento del cliente
    private double calcularCostoConDescuento() {
        double costoBase = calcularCosto();
        if (cliente != null) {
            return cliente.calcularPrecioConDescuento(costoBase);
        }
        return costoBase;
    }

    // Método original mejorado
    public void showInfo() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║          INFORMACIÓN DEL EVENTO                ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Código del Evento: " + this.eventCode);
        System.out.println("Tipo de Evento: " + this.eventType);
        System.out.println("Número de Invitados: " + this.guestCount);
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Ubicación: " + this.ubicacion);
        System.out.println("Tipo de Menú: " + this.tipoMenu);

        // Mostrar información del cliente si existe
        if (cliente != null) {
            System.out.println("\n--- CLIENTE ---");
            System.out.println("Nombre: " + cliente.getNombreCompleto());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("Tipo: " + cliente.getTipoCliente());
            System.out.println("Eventos Previos: " + cliente.getEventosContratados());
            System.out.println("Descuento: " + (cliente.getDescuento() * 100) + "%");
        }

        System.out.println("\nCosto Total: $" + String.format("%,.0f", this.costoTotal));
        mostrarMenu();
        asignarPersonal();
        System.out.println("════════════════════════════════════════════════\n");
    }

    // Mostrar detalles del menú
    private void mostrarMenu() {
        System.out.println("\n--- MENÚ " + tipoMenu.toUpperCase() + " ---");

        switch (tipoMenu) {
            case "Premium":
                System.out.println("• Entrada: Ensalada César");
                System.out.println("• Plato Fuerte: Salmón al horno con verduras");
                System.out.println("• Postre: Tiramisú");
                System.out.println("• Bebidas: Vino tinto, agua, jugo natural");
                break;
            case "Estándar":
                System.out.println("• Entrada: Crema de verduras");
                System.out.println("• Plato Fuerte: Pollo asado con papas");
                System.out.println("• Postre: Flan de caramelo");
                System.out.println("• Bebidas: Agua, jugo");
                break;
            case "Básico":
                System.out.println("• Entrada: Sopa del día");
                System.out.println("• Plato Fuerte: Arroz con pollo");
                System.out.println("• Postre: Gelatina");
                System.out.println("• Bebidas: Agua, gaseosa");
                break;
        }
    }

    // Asignar personal necesario
    private void asignarPersonal() {
        int meseros = guestCount / 20;
        if (meseros == 0) meseros = 1; // Mínimo 1 mesero
        int chefs = (guestCount < 100) ? 1 : 2;

        System.out.println("\n--- PERSONAL ASIGNADO ---");
        System.out.println("• Meseros: " + meseros);
        System.out.println("• Chefs: " + chefs);
    }

    // Asignar cliente al evento
    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
        this.costoTotal = calcularCostoConDescuento();
    }

    // Getters
    public String getEventCode() { return eventCode; }
    public String getEventType() { return eventType; }
    public int getGuestCount() { return guestCount; }
    public String getFecha() { return fecha; }
    public String getUbicacion() { return ubicacion; }
    public String getTipoMenu() { return tipoMenu; }
    public double getCostoTotal() { return costoTotal; }
    public Cliente getCliente() { return cliente; }

    // Setters
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
        this.costoTotal = calcularCostoConDescuento();
    }
}