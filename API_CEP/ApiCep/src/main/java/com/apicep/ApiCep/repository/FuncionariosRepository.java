package com.apicep.ApiCep.repository;

import com.apicep.ApiCep.model.FuncionariosModel;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long>  {
   List<FuncionariosModel> findByFuncionariosId(Long funcionariosId);
    
    Optional<FuncionariosModel> findById(Long id);

    Optional<FuncionariosModel> findByEmail(String email);
}