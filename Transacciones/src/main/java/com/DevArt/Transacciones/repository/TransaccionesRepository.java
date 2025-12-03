package com.DevArt.Transacciones.repository;

import com.DevArt.Transacciones.model.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//Cambio repository 
@Repository
public interface TransaccionesRepository extends JpaRepository<Transacciones, Long> {
    List<Transacciones> findByUsuarioRut(String usuarioRut);

    List<Transacciones> findByTipo(String tipo);

    List<Transacciones> findByAprobado(Boolean aprobado);

}