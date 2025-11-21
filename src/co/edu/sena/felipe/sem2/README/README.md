# 📚 Semana 02 - Clases y Objetos Avanzados

**Estudiante:** Felipe  
**Ficha:** [3228973]

**Dominio:** Sistema de Gestión de Eventos y Catering  
**Fecha:** Noviembre 2024

---

## 🎯 Objetivo

Expandir el sistema de gestión de eventos agregando nuevas clases, implementando relaciones entre objetos y utilizando colecciones con `ArrayList`.

---

## 📦 Estructura del Proyecto
```
semana-02/
├── README.md
├── Cliente.java             (De semana-01, copiado)
├── CateringEvent.java       (De semana-01, copiado)
├── Servicio.java           ⭐ NUEVA CLASE 1
├── PaqueteEvento.java      ⭐ NUEVA CLASE 2
├── GestoraEventos.java     ⭐ CLASE GESTORA CON ARRAYLIST
└── Main.java               ⭐ MAIN COMPLETO
```

---

## 🆕 Ejercicio 1: Nuevas Clases (30 puntos)

### Clase 1: `Servicio.java`

**Descripción:** Representa servicios adicionales que se pueden contratar para un evento (fotografía, música, decoración, etc.)

**Atributos:**
- `idServicio` (String): Identificador único
- `nombreServicio` (String): Nombre del servicio
- `categoria` (String): Categoría ("Entretenimiento", "Decoración", "Técnico", "Personal")
- `precioBase` (double): Precio base del servicio
- `descripcion` (String): Descripción detallada
- `disponible` (boolean): Disponibilidad del servicio

**Métodos de Negocio:**
1. `calcularPrecioPorHoras(int horas)`: Calcula precio según horas contratadas
2. `aplicarDescuento(double porcentaje)`: Aplica descuento al precio
3. `mostrarInformacion()`: Muestra datos completos del servicio
4. `cambiarDisponibilidad(boolean estado)`: Cambia disponibilidad
5. `obtenerResumen()`: Retorna resumen breve

---

### Clase 2: `PaqueteEvento.java`

**Descripción:** Representa un paquete completo que incluye un evento base más servicios adicionales.

**Atributos:**
- `idPaquete` (String): Identificador único
- `evento` (CateringEvent): **RELACIÓN** - Un paquete tiene un evento
- `servicios` (ArrayList<Servicio>): **RELACIÓN** - Un paquete tiene múltiples servicios
- `estadoPaquete` (String): Estado del paquete ("Cotizado", "Confirmado", "En Proceso", "Finalizado")
- `descuentoPaquete` (double): Descuento aplicado al paquete completo

**Métodos de Negocio:**
1. `agregarServicio(Servicio)`: Agrega un servicio al paquete
2. `eliminarServicio(String idServicio)`: Elimina un servicio
3. `calcularCostoTotal()`: Calcula costo total (evento + servicios)
4. `mostrarDetallePaquete()`: Muestra información completa
5. `cambiarEstado(String)`: Actualiza el estado del paquete
6. `contarServiciosPorCategoria(String)`: Cuenta servicios por categoría
7. `listarServicios()`: Lista todos los servicios

**Relaciones Implementadas:**
- ✅ Composición con `CateringEvent` (un paquete tiene un evento)
- ✅ Agregación con `Servicio` (un paquete tiene múltiples servicios)

---

## 📋 Ejercicio 2: Relaciones entre Objetos (25 puntos)

### Relaciones Implementadas:

1. **PaqueteEvento → CateringEvent** (Composición)
```java
   private CateringEvent evento;
```
- Un paquete **contiene** un evento de catering
- El evento es parte esencial del paquete

2. **PaqueteEvento → Servicio** (Agregación)
```java
   private ArrayList<Servicio> servicios;
```
- Un paquete **tiene** múltiples servicios adicionales
- Los servicios pueden existir independientemente

3. **CateringEvent → Cliente** (Asociación)
```java
   private Cliente cliente;
```
- Un evento está asociado a un cliente
- Herencia de semana-01

4. **GestoraEventos → PaqueteEvento, Cliente, Servicio** (Agregación)
```java
   private ArrayList<PaqueteEvento> paquetes;
   private ArrayList<Cliente> clientes;
   private ArrayList<Servicio> catalogoServicios;
```
- La gestora administra colecciones de objetos

---

## 📚 Ejercicio 3: Uso de ArrayList (20 puntos)

### Clase Gestora: `GestoraEventos.java`

**ArrayLists implementados:**
1. `ArrayList<PaqueteEvento> paquetes`: Gestiona todos los paquetes de eventos
2. `ArrayList<Cliente> clientes`: Gestiona todos los clientes registrados
3. `ArrayList<Servicio> catalogoServicios`: Catálogo de servicios disponibles

**Operaciones con ArrayList:**

#### CRUD Completo:
- ✅ **Create**: `agregarPaquete()`, `agregarCliente()`, `agregarServicioACatalogo()`
- ✅ **Read**: `buscarPaquete()`, `buscarCliente()`, `mostrarTodosPaquetes()`, `mostrarTodosClientes()`
- ✅ **Update**: Métodos en las clases individuales
- ✅ **Delete**: `eliminarPaquete()`, `eliminarServicio()`

#### Operaciones Avanzadas:
```java
// Búsqueda
public PaqueteEvento buscarPaquete(String idPaquete);
public ArrayList<Servicio> buscarServiciosPorCategoria(String categoria);

// Conteo
public int contarPaquetes();
public int contarClientes();

// Iteración
public void mostrarTodosPaquetes();
public void mostrarCatalogoServicios();

// Análisis
public double calcularIngresoTotal();
public PaqueteEvento obtenerPaqueteMasCostoso();
public void mostrarEstadisticasPorEstado();
```

---

## 🚀 Ejercicio 4: Main Completo (25 puntos)

### Estructura del Main:
```
PARTE 1: Registro de Clientes (3 clientes)
PARTE 2: Catálogo de Servicios (5 servicios)
PARTE 3: Crear Eventos Base (3 eventos)
PARTE 4: Crear Paquetes Completos (4 paquetes con servicios)
PARTE 5: Detalle de Paquetes
PARTE 6: Operaciones con ArrayList
         - Mostrar todos los paquetes
         - Buscar paquetes específicos
         - Buscar servicios por categoría
         - Eliminar servicios de paquetes
PARTE 7: Sistema de Fidelización (contratar múltiples eventos)
PARTE 8: Información de Clientes
