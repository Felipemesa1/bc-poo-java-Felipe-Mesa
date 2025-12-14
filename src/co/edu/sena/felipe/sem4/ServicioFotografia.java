package co.edu.sena.felipe.sem4;

import java.util.ArrayList;

public class ServicioFotografia extends ServicioAdicional
        implements Personalizable, Reservable, Calificable {

    private int horasContratadas;
    private boolean incluyeAlbum;
    private String personalizacion;
    private String fechaReserva;
    private String clienteReserva;
    private ArrayList<Integer> calificaciones;

    public ServicioFotografia(String idServicio, int horasContratadas, boolean incluyeAlbum) {
        super(idServicio, "Fotografía Profesional", 200000);
        this.horasContratadas = horasContratadas;
        this.incluyeAlbum = incluyeAlbum;
        this.personalizacion = "";
        this.fechaReserva = null;
        this.clienteReserva = null;
        this.calificaciones = new ArrayList<>();
    }

    @Override
    public double calcularCosto() {
        double costo = precioBase * horasContratadas;
        if (incluyeAlbum) {
            costo += 500000;
        }
        return costo;
    }

    @Override
    public String obtenerDescripcion() {
        return "Sesión fotográfica de " + horasContratadas + " horas " +
                (incluyeAlbum ? "con álbum incluido" : "sin álbum");
    }

    @Override
    public String getCategoria() {
        return "Fotografía y Video";
    }

    @Override
    public void personalizarConCliente(String nombreCliente) {
        this.personalizacion = "Álbum personalizado para: " + nombreCliente;
        System.out.println("✓ Fotografía personalizada para " + nombreCliente);
    }

    @Override
    public String obtenerPersonalizacion() {
        return personalizacion.isEmpty() ? "Sin personalización" : personalizacion;
    }

    @Override
    public boolean verificarDisponibilidad(String fecha) {
        return fechaReserva == null || !fechaReserva.equals(fecha);
    }

    @Override
    public void reservar(String fecha, String cliente) {
        if (verificarDisponibilidad(fecha)) {
            this.fechaReserva = fecha;
            this.clienteReserva = cliente;
            System.out.println("✓ Fotografía reservada para " + cliente + " el " + fecha);
        } else {
            System.out.println("✗ Fecha no disponible");
        }
    }

    @Override
    public void cancelarReserva() {
        this.fechaReserva = null;
        this.clienteReserva = null;
        System.out.println("✓ Reserva cancelada");
    }

    @Override
    public void agregarCalificacion(int estrellas) {
        if (estrellas >= 1 && estrellas <= 5) {
            calificaciones.add(estrellas);
            System.out.println("✓ Calificación agregada: " + estrellas + " estrellas");
        } else {
            System.out.println("✗ Calificación debe estar entre 1 y 5");
        }
    }

    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;
        int suma = 0;
        for (int cal : calificaciones) {
            suma += cal;
        }
        return (double) suma / calificaciones.size();
    }

    @Override
    public int getCantidadCalificaciones() {
        return calificaciones.size();
    }

    public void mostrarEstadoReserva() {
        System.out.println("--- ESTADO DE RESERVA ---");
        if (fechaReserva != null) {
            System.out.println("Fecha: " + fechaReserva);
            System.out.println("Cliente: " + clienteReserva);
            System.out.println("Personalización: " + obtenerPersonalizacion());
        } else {
            System.out.println("Sin reserva activa");
        }
    }

    public int getHorasContratadas() { return horasContratadas; }
    public boolean isIncluyeAlbum() { return incluyeAlbum; }
    public String getFechaReserva() { return fechaReserva; }
    public String getClienteReserva() { return clienteReserva; }
}