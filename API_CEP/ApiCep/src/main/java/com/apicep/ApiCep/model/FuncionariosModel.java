package com.apicep.ApiCep.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "funcionarios")

@Getter
@Setter

@NoArgsConstructor
public class FuncionariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(nullable = false)
    private String cep;
    
    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(nullable = false, length = 255)
    private String bairro;

    @Column(nullable = false, length = 255)
    private String cidade;

    @Column(nullable = false, length = 255)
    private String estado;

    @OneToMany(mappedBy = "funcionarios") 
    private List<FuncionariosCargosModel> funcionarios = new ArrayList<>();
}