package com.DevArt.Transacciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {


    @Id
    @Column(name = "id", length = 255, unique = true, nullable = false)
    private int id;

    @Column(name = "rut_programador", nullable = true, length = 255)
    private String rutProgramador;
    
    @Column(name = "horas_disponibles", nullable = true, length = 100)
    private int  horaDisponible;
    
    @Column(name = "Estado", nullable = true, length = 100)
    private boolean estado;
}
