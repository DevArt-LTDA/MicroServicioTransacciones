package com.DevArt.Transacciones.repository;

import com.DevArt.Transacciones.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventariosRepository extends JpaRepository<Inventario, Integer> {
    List<Inventario> findByRutProgramador(String rutProgramador);

    List<Inventario> findByHoraDisponible(int horaDisponible);

    List<Inventario> findByEstado(boolean estado);

    List<Inventario> findById(int id);
}
