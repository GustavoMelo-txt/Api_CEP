package com.apicep.ApiCep.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "funcionarios_por_cargo")

@Getter
@Setter

@NoArgsConstructor
public class FuncionariosCargosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Date data_inicio;

    @Column(nullable = false)
    private Date data_fim;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private FuncionariosModel funcionarios;
    
    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private CargosModel cargos;
}