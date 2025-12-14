package co.edu.sena.felipe.sem6;

import java.util.*;

/**
 * SEMANA 6: COLECCIONES AVANZADAS
 * Sistema completo de gestión con HashMap, TreeMap, LinkedHashMap
 */
public class SistemaGestionEventos {

    // HashMap: búsqueda rápida por ID
    private HashMap<String, EventoCompleto> eventosHashMap;

    // TreeMap: eventos ordenados por fecha
    private TreeMap<String, EventoCompleto> eventosOrdenados;

    // LinkedHashMap: mantiene orden de inserción
    private LinkedHashMap<String, ClienteVIP> clientesVIP;

    // ArrayList para servicios
    private ArrayList<String> serviciosDisponibles;

    // HashSet para evitar duplicados de ubicaciones
    private HashSet<String> ubicacionesUsadas;

    // CONSTRUCTOR
    public SistemaGestionEventos() {
        this.eventosHashMap = new HashMap<>();
        this.eventosOrdenados = new TreeMap<>();
        this.clientesVIP = new LinkedHashMap<>();
        this.serviciosDisponibles = new ArrayList<>();
        this.ubicacionesUsadas = new HashSet<>();

        inicializarServicios();
    }

    private void inicializarServicios() {
        serviciosDisponibles.add("Fotografía Profesional");
        serviciosDisponibles.add("DJ y Música");
        serviciosDisponibles.add("Decoración Floral");
        serviciosDisponibles.add("Video y Drone");
        serviciosDisponibles.add("Animación Infantil");
        serviciosDisponibles.add("Bartender Especializado");
    }

    // ========== OPERACIONES CON HASHMAP ==========

    /**
     * Agregar evento usando HashMap (búsqueda rápida)
     */
    public void agregarEvento(EventoCompleto evento) {
        eventosHashMap.put(evento.getId(), evento);
        eventosOrdenados.put(evento.getFecha() + "-" + evento.getId(), evento);
        ubicacionesUsadas.add(evento.getUbicacion());

        System.out.println("✓ Evento agregado: " + evento.getId());
    }

    /**
     * Buscar evento por ID (O(1) con HashMap)
     */
    public EventoCompleto buscarEventoPorId(String id) {
        return eventosHashMap.get(id);
    }

    /**
     * Verificar si existe un evento
     */
    public boolean existeEvento(String id) {
        return eventosHashMap.containsKey(id);
    }

    /**
     * Eliminar evento
     */
    public boolean eliminarEvento(String id) {
        EventoCompleto evento = eventosHashMap.remove(id);
        if (evento != null) {
            eventosOrdenados.remove(evento.getFecha() + "-" + id);
            System.out.println("✓ Evento eliminado: " + id);
            return true;
        }
        System.out.println("✗ Evento no encontrado: " + id);
        return false;
    }

    // ========== OPERACIONES CON TREEMAP (ORDENADO) ==========

    /**
     * Obtener eventos ordenados por fecha
     */
    public void mostrarEventosOrdenadosPorFecha() {
        System.out.println("\n📅 EVENTOS ORDENADOS POR FECHA:");
        System.out.println("─────────────────────────────────────────────────");

        if (eventosOrdenados.isEmpty()) {
            System.out.println("No hay eventos registrados");
            return;
        }

        int contador = 1;
        for (Map.Entry<String, EventoCompleto> entry : eventosOrdenados.entrySet()) {
            EventoCompleto evento = entry.getValue();
            System.out.println(contador + ". " + evento.getFecha() + " - " +
                    evento.getNombre() + " (" + evento.getTipo() + ")");
            contador++;
        }
    }

    /**
     * Obtener primer evento (el más próximo)
     */
    public EventoCompleto obtenerProximoEvento() {
        if (eventosOrdenados.isEmpty()) return null;
        return eventosOrdenados.firstEntry().getValue();
    }

    /**
     * Obtener último evento
     */
    public EventoCompleto obtenerUltimoEvento() {
        if (eventosOrdenados.isEmpty()) return null;
        return eventosOrdenados.lastEntry().getValue();
    }

    // ========== OPERACIONES CON LINKEDHASHMAP (CLIENTES VIP) ==========

    /**
     * Agregar cliente VIP (mantiene orden de registro)
     */
    public void agregarClienteVIP(ClienteVIP cliente) {
        clientesVIP.put(cliente.getId(), cliente);
        System.out.println("✓ Cliente VIP registrado: " + cliente.getNombre());
    }

    /**
     * Mostrar clientes VIP en orden de registro
     */
    public void mostrarClientesVIPEnOrden() {
        System.out.println("\n👑 CLIENTES VIP (Orden de Registro):");
        System.out.println("─────────────────────────────────────────────────");

        if (clientesVIP.isEmpty()) {
            System.out.println("No hay clientes VIP");
            return;
        }

        int posicion = 1;
        for (Map.Entry<String, ClienteVIP> entry : clientesVIP.entrySet()) {
            ClienteVIP cliente = entry.getValue();
            System.out.println(posicion + ". " + cliente.getNombre() +
                    " - " + cliente.getEventosContratados() + " eventos - " +
                    cliente.getDescuento() + "% descuento");
            posicion++;
        }
    }

    /**
     * Buscar cliente VIP por ID
     */
    public ClienteVIP buscarClienteVIP(String id) {
        return clientesVIP.get(id);
    }

    // ========== OPERACIONES CON HASHSET ==========

    /**
     * Verificar si una ubicación ya fue usada
     */
    public boolean ubicacionDisponible(String ubicacion) {
        return !ubicacionesUsadas.contains(ubicacion);
    }

    /**
     * Mostrar ubicaciones usadas
     */
    public void mostrarUbicacionesUsadas() {
        System.out.println("\n📍 UBICACIONES USADAS:");
        System.out.println("─────────────────────────────────────────────────");

        if (ubicacionesUsadas.isEmpty()) {
            System.out.println("Ninguna ubicación registrada");
            return;
        }

        int num = 1;
        for (String ubicacion : ubicacionesUsadas) {
            System.out.println(num + ". " + ubicacion);
            num++;
        }
    }

    // ========== OPERACIONES CON ARRAYLIST ==========

    /**
     * Mostrar servicios disponibles
     */
    public void mostrarServiciosDisponibles() {
        System.out.println("\n🎯 SERVICIOS DISPONIBLES:");
        System.out.println("─────────────────────────────────────────────────");

        for (int i = 0; i < serviciosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + serviciosDisponibles.get(i));
        }
    }

    /**
     * Agregar nuevo servicio
     */
    public void agregarServicio(String servicio) {
        if (!serviciosDisponibles.contains(servicio)) {
            serviciosDisponibles.add(servicio);
            System.out.println("✓ Servicio agregado: " + servicio);
        } else {
            System.out.println("✗ El servicio ya existe");
        }
    }

    // ========== ESTADÍSTICAS Y REPORTES ==========

    /**
     * Generar estadísticas completas
     */
    public void generarEstadisticas() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║         ESTADÍSTICAS DEL SISTEMA               ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        System.out.println("\n📊 RESUMEN GENERAL:");
        System.out.println("  • Total de Eventos: " + eventosHashMap.size());
        System.out.println("  • Clientes VIP: " + clientesVIP.size());
        System.out.println("  • Ubicaciones Diferentes: " + ubicacionesUsadas.size());
        System.out.println("  • Servicios Disponibles: " + serviciosDisponibles.size());

        if (!eventosHashMap.isEmpty()) {
            // Contar por tipo
            HashMap<String, Integer> eventosPorTipo = new HashMap<>();
            double costoTotal = 0;

            for (EventoCompleto evento : eventosHashMap.values()) {
                String tipo = evento.getTipo();
                eventosPorTipo.put(tipo, eventosPorTipo.getOrDefault(tipo, 0) + 1);
                costoTotal += evento.getCosto();
            }

            System.out.println("\n📋 EVENTOS POR TIPO:");
            for (Map.Entry<String, Integer> entry : eventosPorTipo.entrySet()) {
                System.out.println("  • " + entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("\n💰 INGRESOS TOTALES: $" + String.format("%,.0f", costoTotal));
            System.out.println("💵 PROMEDIO POR EVENTO: $" +
                    String.format("%,.0f", costoTotal / eventosHashMap.size()));
        }
    }

    /**
     * Buscar eventos por tipo
     */
    public ArrayList<EventoCompleto> buscarEventosPorTipo(String tipo) {
        ArrayList<EventoCompleto> resultado = new ArrayList<>();

        for (EventoCompleto evento : eventosHashMap.values()) {
            if (evento.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(evento);
            }
        }

        return resultado;
    }

    /**
     * Obtener evento más costoso
     */
    public EventoCompleto obtenerEventoMasCostoso() {
        if (eventosHashMap.isEmpty()) return null;

        EventoCompleto masCostoso = null;
        double costoMaximo = 0;

        for (EventoCompleto evento : eventosHashMap.values()) {
            if (evento.getCosto() > costoMaximo) {
                costoMaximo = evento.getCosto();
                masCostoso = evento;
            }
        }

        return masCostoso;
    }

    // GETTERS
    public int getTotalEventos() {
        return eventosHashMap.size();
    }

    public int getTotalClientesVIP() {
        return clientesVIP.size();
    }

    public int getTotalUbicaciones() {
        return ubicacionesUsadas.size();
    }
}