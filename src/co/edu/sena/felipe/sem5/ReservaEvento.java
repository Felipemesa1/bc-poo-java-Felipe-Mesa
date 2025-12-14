package co.edu.sena.felipe.sem5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ReservaEvento {
    private String idReserva;
    private String nombreCliente;
    private String tipoEvento;
    private int numeroInvitados;
    private String fecha;
    private double presupuestoCliente;
    private double costoEstimado;
    private boolean confirmada;

    private static final int CAPACIDAD_MAXIMA = 500;
    private static final int INVITADOS_MINIMOS = 10;

    public ReservaEvento(String idReserva) {
        this.idReserva = idReserva;
        this.confirmada = false;
    }

    public void establecerFecha(String fecha) throws FechaNoValidaException {
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new FechaNoValidaException("La fecha no puede estar vacía");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaEvento = LocalDate.parse(fecha, formatter);
            LocalDate fechaActual = LocalDate.now();

            if (fechaEvento.isBefore(fechaActual)) {
                throw new FechaNoValidaException(
                        "La fecha " + fecha + " ya pasó. Debe ser una fecha futura");
            }

            if (fechaEvento.isBefore(fechaActual.plusDays(7))) {
                throw new FechaNoValidaException(
                        "Se requieren al menos 7 días de anticipación");
            }

            this.fecha = fecha;
            System.out.println("✓ Fecha establecida: " + fecha);

        } catch (DateTimeParseException e) {
            throw new FechaNoValidaException(
                    "Formato incorrecto. Use el formato: YYYY-MM-DD (ej: 2025-06-15)");
        }
    }

    public void establecerInvitados(int numeroInvitados)
            throws CapacidadExcedidaException, DatosInvalidosException {

        if (numeroInvitados < INVITADOS_MINIMOS) {
            throw new DatosInvalidosException("Número de invitados",
                    "Debe ser al menos " + INVITADOS_MINIMOS + " invitados");
        }

        if (numeroInvitados > CAPACIDAD_MAXIMA) {
            throw new CapacidadExcedidaException(CAPACIDAD_MAXIMA, numeroInvitados);
        }

        this.numeroInvitados = numeroInvitados;
        System.out.println("✓ Número de invitados: " + numeroInvitados);
    }

    public void establecerCliente(String nombreCliente) throws DatosInvalidosException {
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new DatosInvalidosException("Nombre del cliente",
                    "No puede estar vacío");
        }

        if (nombreCliente.trim().length() < 3) {
            throw new DatosInvalidosException("Nombre del cliente",
                    "Debe tener al menos 3 caracteres");
        }

        this.nombreCliente = nombreCliente.trim();
        System.out.println("✓ Cliente: " + this.nombreCliente);
    }

    public void establecerTipoEvento(String tipoEvento) throws DatosInvalidosException {
        String[] tiposValidos = {"Boda", "Cumpleaños", "Corporativo", "Graduación", "Otro"};
        boolean esValido = false;

        for (String tipo : tiposValidos) {
            if (tipo.equalsIgnoreCase(tipoEvento)) {
                esValido = true;
                this.tipoEvento = tipo;
                break;
            }
        }

        if (!esValido) {
            throw new DatosInvalidosException("Tipo de evento",
                    "Debe ser: Boda, Cumpleaños, Corporativo, Graduación u Otro");
        }

        System.out.println("✓ Tipo de evento: " + this.tipoEvento);
    }

    public void verificarPresupuesto(double presupuestoCliente, double costoEstimado)
            throws PresupuestoInsuficienteException {

        this.presupuestoCliente = presupuestoCliente;
        this.costoEstimado = costoEstimado;

        if (presupuestoCliente < costoEstimado) {
            throw new PresupuestoInsuficienteException(presupuestoCliente, costoEstimado);
        }

        System.out.println("✓ Presupuesto suficiente");
        System.out.println("  Presupuesto: $" + String.format("%,.0f", presupuestoCliente));
        System.out.println("  Costo: $" + String.format("%,.0f", costoEstimado));
    }

    public void confirmarReserva() {
        if (fecha == null || nombreCliente == null || tipoEvento == null) {
            System.out.println("✗ No se puede confirmar: faltan datos");
            return;
        }

        this.confirmada = true;
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║     ✓ RESERVA CONFIRMADA EXITOSAMENTE         ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        mostrarResumen();
    }

    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN DE RESERVA ---");
        System.out.println("ID: " + idReserva);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Tipo: " + tipoEvento);
        System.out.println("Fecha: " + fecha);
        System.out.println("Invitados: " + numeroInvitados);
        System.out.println("Presupuesto: $" + String.format("%,.0f", presupuestoCliente));
        System.out.println("Costo: $" + String.format("%,.0f", costoEstimado));
        System.out.println("Estado: " + (confirmada ? "CONFIRMADA ✓" : "PENDIENTE"));
        System.out.println("──────────────────────────────────────────────────\n");
    }

    public String getIdReserva() { return idReserva; }
    public String getNombreCliente() { return nombreCliente; }
    public String getTipoEvento() { return tipoEvento; }
    public int getNumeroInvitados() { return numeroInvitados; }
    public String getFecha() { return fecha; }
    public boolean isConfirmada() { return confirmada; }
}