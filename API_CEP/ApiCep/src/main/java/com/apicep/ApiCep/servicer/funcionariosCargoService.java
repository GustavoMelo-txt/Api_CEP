package com.apicep.ApiCep.servicer;

import com.apicep.ApiCep.model.*;
import com.apicep.ApiCep.repository.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class funcionariosCargoService {
    @Autowired
    private FuncionariosCargosRepository funcionarioscargosRepository;

    public List<FuncionariosCargosModel> listarTodos() {
        return funcionarioscargosRepository.findAll();
    }

    public Optional<FuncionariosCargosModel> findByID(Long id) {
        return funcionarioscargosRepository.findById(id);
    }

    public List<FuncionariosCargosModel> filtrarPorCargo(Long cargoId) {
        return funcionarioscargosRepository.findByCargoId(cargoId);
    }

    public FuncionariosCargosModel salvar(FuncionariosCargosModel cargo) {
        return funcionarioscargosRepository.save(cargo);
    }

      public List<FuncionariosCargosModel> filtrarPorFuncionarios(Long funcionariosId) {
        return funcionarioscargosRepository.findByFuncionariosId(funcionariosId);
    }

     public FuncionariosCargosModel salvar(FuncionariosCargosModel funcionarios) {
        return funcionarioscargosRepository.save(funcionarios);
    }

    public void excluir(Long id) {
        funcionarioscargosRepository.deleteById(id);
    }

    
}