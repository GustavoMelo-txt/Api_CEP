package com.apicep.ApiCep.servicer;

import com.apicep.ApiCep.model.*;
import com.apicep.ApiCep.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository ApiCepRepository;

    public List<UsuarioModel> listarTodos() {
        return ApiCepRepository.findAll();
    }

    public Optional<UsuarioModel> findByID(Long id) {
        return ApiCepRepository.findById(id);
    }

    public UsuarioModel salvar(UsuarioModel imagem) {
        return ApiCepRepository.save(imagem);
    }

    public void excluir(Long id) {
        ApiCepRepository.deleteById(id);
    }

    public Optional<UsuarioModel> buscarPorEmail(String email) {
        return ApiCepRepository.findByEmail(email);
    }
}