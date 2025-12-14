package co.edu.sena.felipe.sem5;



/**
 * SEMANA 5: MANEJO DE EXCEPCIONES
 * Excepciones personalizadas para el sistema de catering
 */

// EXCEPCIÓN 1: Fecha no válida
class FechaNoValidaException extends Exception {

    public FechaNoValidaException(String mensaje) {
        super("❌ ERROR DE FECHA: " + mensaje);
    }
}

// EXCEPCIÓN 2: Capacidad excedida
class CapacidadExcedidaException extends Exception {
    private int capacidadMaxima;
    private int cantidadSolicitada;

    public CapacidadExcedidaException(int capacidadMaxima, int cantidadSolicitada) {
        super("❌ CAPACIDAD EXCEDIDA: Se solicitaron " + cantidadSolicitada +
                " invitados pero la capacidad máxima es " + capacidadMaxima);
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public int getCantidadSolicitada() { return cantidadSolicitada; }
}

// EXCEPCIÓN 3: Presupuesto insuficiente
class PresupuestoInsuficienteException extends Exception {
    private double presupuestoCliente;
    private double costoEvento;
    private double diferencia;

    public PresupuestoInsuficienteException(double presupuestoCliente, double costoEvento) {
        super("❌ PRESUPUESTO INSUFICIENTE: El cliente tiene $" +
                String.format("%,.0f", presupuestoCliente) +
                " pero el evento cuesta $" + String.format("%,.0f", costoEvento));
        this.presupuestoCliente = presupuestoCliente;
        this.costoEvento = costoEvento;
        this.diferencia = costoEvento - presupuestoCliente;
    }

    public double getPresupuestoCliente() { return presupuestoCliente; }
    public double getCostoEvento() { return costoEvento; }
    public double getDiferencia() { return diferencia; }
}

// EXCEPCIÓN 4: Servicio no disponible
class ServicioNoDisponibleException extends Exception {
    private String nombreServicio;
    private String fechaSolicitada;

    public ServicioNoDisponibleException(String nombreServicio, String fechaSolicitada) {
        super("❌ SERVICIO NO DISPONIBLE: " + nombreServicio +
                " no está disponible para la fecha " + fechaSolicitada);
        this.nombreServicio = nombreServicio;
        this.fechaSolicitada = fechaSolicitada;
    }

    public String getNombreServicio() { return nombreServicio; }
    public String getFechaSolicitada() { return fechaSolicitada; }
}

// EXCEPCIÓN 5: Datos inválidos
class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String campo, String razon) {
        super("❌ DATOS INVÁLIDOS: El campo '" + campo + "' es inválido. Razón: " + razon);
    }
}