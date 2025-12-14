package co.edu.sena.felipe.sem4;

import java.util.ArrayList;

public class ServicioDJ extends ServicioAdicional implements Reservable, Calificable {

    private int horasContratadas;
    private boolean incluyeLuces;
    private boolean incluyeSonido;
    private String fechaReserva;
    private String clienteReserva;
    private ArrayList<Integer> calificaciones;

    public ServicioDJ(String idServicio, int horasContratadas,
                      boolean incluyeLuces, boolean incluyeSonido) {
        super(idServicio, "DJ Profesional", 300000);
        this.horasContratadas = horasContratadas;
        this.incluyeLuces = incluyeLuces;
        this.incluyeSonido = incluyeSonido;
        this.fechaReserva = null;
        this.clienteReserva = null;
        this.calificaciones = new ArrayList<>();
    }

    @Override
    public double calcularCosto() {
        double costo = precioBase * horasContratadas;
        if (incluyeLuces) {
            costo += 400000;
        }
        if (incluyeSonido) {
            costo += 600000;
        }
        return costo;
    }

    @Override
    public String obtenerDescripcion() {
        return "DJ por " + horasContratadas + " horas " +
                (incluyeLuces ? "+ Luces " : "") +
                (incluyeSonido ? "+ Sonido profesional" : "");
    }

    @Override
    public String getCategoria() {
        return "Entretenimiento Musical";
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
            System.out.println("✓ DJ reservado para " + cliente + " el " + fecha);
        } else {
            System.out.println("✗ DJ no disponible para esa fecha");
        }
    }

    @Override
    public void cancelarReserva() {
        this.fechaReserva = null;
        this.clienteReserva = null;
        System.out.println("✓ Reserva de DJ cancelada");
    }

    @Override
    public void agregarCalificacion(int estrellas) {
        if (estrellas >= 1 && estrellas <= 5) {
            calificaciones.add(estrellas);
            System.out.println("✓ DJ calificado con " + estrellas + " estrellas");
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

    public int getHorasContratadas() { return horasContratadas; }
    public boolean isIncluyeLuces() { return incluyeLuces; }
    public boolean isIncluyeSonido() { return incluyeSonido; }
}