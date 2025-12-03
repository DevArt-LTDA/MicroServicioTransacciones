package com.DevArt.Transacciones.service;

import com.DevArt.Transacciones.client.TrabajadorClient;
import com.DevArt.Transacciones.model.Inventario;
import com.DevArt.Transacciones.repository.InventariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventariosService {

    @Autowired
    private InventariosRepository inventarios;

    @Autowired
    private TrabajadorClient trabajadorClient;

    public String registrarInventario(Inventario inventario) {
        String rut = inventario.getRutProgramador();

        Boolean existe = trabajadorClient.existeTrabajador(rut);
        if (Boolean.TRUE.equals(existe)) {
            inventarios.save(inventario);
            return "Inventario guardado correctamente.";
        } else {
            return "No se encontró un trabajador con el RUT: " + rut;
        }
    }

    public List<Inventario> obtenerTodos() {
        return inventarios.findAll();
    }

    public List<Inventario> buscarPorRut(String rut) {
        return inventarios.findByRutProgramador(rut);
    }

    // Buscar por horas disponibles general
    

    public List<Inventario> buscarPorHorasDisponibles(int horas) {
        return inventarios.findByHoraDisponible(horas);
    }

    public List<Inventario> buscarPorEstado(boolean estado) {
        return inventarios.findByEstado(estado);
    }
    public List<Inventario> buscarPorId(int id) {
        return inventarios.findById(id);
    }

}
