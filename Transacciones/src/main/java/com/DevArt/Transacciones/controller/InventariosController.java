package com.DevArt.Transacciones.controller;

import com.DevArt.Transacciones.model.Inventario;
import com.DevArt.Transacciones.service.InventariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventarios")
public class InventariosController {

    @Autowired
    private InventariosService inventariosService;

    // Crear inventario con validación del trabajador
    @PostMapping
    public ResponseEntity<String> crearInventario(@RequestBody Inventario inventario) {
        String resultado = inventariosService.registrarInventario(inventario);

        if (resultado.contains("No se encontró")) {
            return ResponseEntity.status(404).body(resultado);
        }

        return ResponseEntity.ok(resultado);
    }
// Actualizar inventario
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarInventario(@PathVariable int id, @RequestBody Inventario inventario) {
        List<Inventario> lista = inventariosService.buscarPorId(id);
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("No se encontró un inventario con el ID: " + id);
        }
        inventario.setId(id);
        String resultado = inventariosService.registrarInventario(inventario);
        return ResponseEntity.ok(resultado);
    }

    // Obtener todos los inventarios
    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        List<Inventario> lista = inventariosService.obtenerTodos();
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("No hay inventarios registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    // Buscar por rut_programador
    @GetMapping("/rut/{rut}")
    public ResponseEntity<?> buscarPorRut(@PathVariable("rut") String rut) {
        List<Inventario> lista = inventariosService.buscarPorRut(rut);
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("No se encontraron inventarios para el RUT: " + rut);
        }
        return ResponseEntity.ok(lista);
    }

    // Buscar por horas disponibles all 

    @GetMapping("/horas")
    public ResponseEntity<?> buscarPorHorasDisponibles() {
        List<Inventario> lista = inventariosService.obtenerTodos();
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("No hay inventarios registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    // Buscar por todas las horas disponibles
    @GetMapping("/horas/{horas}")
    public ResponseEntity<?> buscarPorHorasDisponibles(@PathVariable("horas") int horas) {
        List<Inventario> lista = inventariosService.buscarPorHorasDisponibles(horas);
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("No se encontraron inventarios con " + horas + " horas disponibles.");
        }
        return ResponseEntity.ok(lista);
    }

    // Buscar estados all
    @GetMapping("/estado")
    public ResponseEntity<?> buscarPorEstado() {
        List<Inventario> lista = inventariosService.obtenerTodos();
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("No hay inventarios registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> buscarPorEstado(@PathVariable("estado") boolean estado) {
        List<Inventario> lista = inventariosService.buscarPorEstado(estado);
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("No se encontraron inventarios con estado: " + estado);
        }
        return ResponseEntity.ok(lista);
    }
}
