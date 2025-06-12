package com.apicep.ApiCep.servicer;

import com.apicep.ApiCep.model.*;
import com.apicep.ApiCep.repository.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargosService {
    @Autowired
    private CargosRepository cargosRepository;

    public List<CargosModel> listarTodos() {
        return cargosRepository.findAll();
    }

    public Optional<CargosModel> findByID(Long id) {
        return cargosRepository.findById(id);
    }

    public CargosModel salvar(CargosModel imagem) {
        return cargosRepository.save(imagem);
    }

    public void excluir(Long id) {
        cargosRepository.deleteById(id);
    }
}