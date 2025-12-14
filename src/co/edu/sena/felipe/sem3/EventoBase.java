package co.edu.sena.felipe.sem3;

/**
 * SEMANA 3: HERENCIA Y POLIMORFISMO
 * Clase base que representa un evento genérico
 * Esta clase será heredada por tipos específicos de eventos
 */
public class EventoBase {
    // ATRIBUTOS COMUNES A TODOS LOS EVENTOS
    protected String codigo;
    protected String nombreEvento;
    protected int numeroInvitados;
    protected String fecha;
    protected String ubicacion;
    protected double costoBase;

    // CONSTRUCTOR
    public EventoBase(String codigo, String nombreEvento, int numeroInvitados,
                      String fecha, String ubicacion) {
        this.codigo = codigo;
        this.nombreEvento = nombreEvento;
        this.numeroInvitados = numeroInvitados;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.costoBase = calcularCostoBase();
    }

    // MÉTODO QUE SERÁ SOBRESCRITO (POLIMORFISMO)
    public double calcularCostoBase() {
        // Costo genérico: $30,000 por persona
        return numeroInvitados * 30000;
    }

    // MÉTODO QUE SERÁ SOBRESCRITO
    public String obtenerTipoEvento() {
        return "Evento Genérico";
    }

    // MÉTODO QUE SERÁ SOBRESCRITO
    public void mostrarDetallesEspecificos() {
        System.out.println("Este es un evento genérico sin detalles especiales");
    }

    // MÉTODO COMÚN PARA TODOS LOS EVENTOS
    public void mostrarInformacionGeneral() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║         INFORMACIÓN DEL EVENTO                 ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + obtenerTipoEvento());
        System.out.println("Nombre: " + nombreEvento);
        System.out.println("Fecha: " + fecha);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Invitados: " + numeroInvitados);
        System.out.println("Costo Base: $" + String.format("%,.0f", costoBase));
        System.out.println();
        mostrarDetallesEspecificos();
        System.out.println("════════════════════════════════════════════════\n");
    }

    // GETTERS
    public String getCodigo() { return codigo; }
    public String getNombreEvento() { return nombreEvento; }
    public int getNumeroInvitados() { return numeroInvitados; }
    public String getFecha() { return fecha; }
    public String getUbicacion() { return ubicacion; }
    public double getCostoBase() { return costoBase; }
}