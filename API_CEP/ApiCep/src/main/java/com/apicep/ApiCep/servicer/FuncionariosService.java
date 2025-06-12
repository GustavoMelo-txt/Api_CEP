package com.apicep.ApiCep.servicer;

import com.apicep.ApiCep.model.*;
import com.apicep.ApiCep.repository.FuncionariosCargosRepository;
import com.apicep.ApiCep.repository.FuncionariosRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionariosService {
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    public List<FuncionariosModel> listarTodos() {
        return funcionariosRepository.findAll();
    }

    public Optional<FuncionariosModel> findByID(Long id) {
        return funcionariosRepository.findById(id);
    }

    public List<FuncionariosModel> filtrarPorFuncionarios(Long funcionariosId) {
        return funcionariosRepository.findByFuncionariosId(funcionariosId);
    }

    public FuncionariosModel salvar(FuncionariosModel funcionarios) {
        return funcionariosRepository.save(funcionarios);
    }

    public void excluir(Long id) {
        funcionariosRepository.deleteById(id);
    }

    public Optional<FuncionariosModel> buscarPorEmail(String email) {
        return funcionariosRepository.findByEmail(email);
    }

}