package com.apicep.ApiCep.repository;

import com.apicep.ApiCep.model.*;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosCargosRepository extends JpaRepository<FuncionariosCargosModel, Long> {
    
    List<FuncionariosCargosModel> findByCargoId(Long cargoId);
    
    List<FuncionariosCargosModel> findByFuncionariosId(Long funcionariosId);
    Optional<FuncionariosCargosModel> findById(Long id);
    
}