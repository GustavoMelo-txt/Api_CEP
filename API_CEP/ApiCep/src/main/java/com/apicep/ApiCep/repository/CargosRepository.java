package com.apicep.ApiCep.repository;

import com.apicep.ApiCep.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargosRepository extends JpaRepository<CargosModel, Long>  {
    
}