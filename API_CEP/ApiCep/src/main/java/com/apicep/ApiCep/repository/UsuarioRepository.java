package com.apicep.ApiCep.repository;

import com.apicep.ApiCep.model.UsuarioModel;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>  {
    Optional<UsuarioModel> findByEmail(String email);
}