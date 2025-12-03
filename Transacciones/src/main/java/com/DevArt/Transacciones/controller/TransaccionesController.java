package com.DevArt.Transacciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DevArt.Transacciones.model.Transacciones;
import com.DevArt.Transacciones.service.TransaccionesService;

@RestController
@RequestMapping("/api/v1/transacciones")
public class TransaccionesController {

    @Autowired
    private TransaccionesService transaccionesService;

    @PostMapping
    public ResponseEntity<Transacciones> crearTransaccion(@RequestBody Transacciones transaccion) {
        try {
            Transacciones nueva = transaccionesService.crearTransaccion(transaccion);
            return ResponseEntity.ok(nueva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Transacciones>> listarTodas() {
        return ResponseEntity.ok(transaccionesService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacciones> buscarPorId(@PathVariable("id") Long id) {
        Optional<Transacciones> trans = transaccionesService.obtenerPorId(id);
        return trans.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{rut}")
    public ResponseEntity<List<Transacciones>> buscarPorUsuario(@PathVariable("rut") String rut) {
        return ResponseEntity.ok(transaccionesService.obtenerPorRut(rut));
    }

    //Borrar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable("id") Long id) {
        try {
            transaccionesService.eliminarTransaccion(id);
            return ResponseEntity.ok("Transacción eliminada correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Transacción no encontrada.");
        }
    }


}
