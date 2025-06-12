package com.apicep.ApiCep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicep.ApiCep.model.*;
import com.apicep.ApiCep.servicer.*;

import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionariosController {
    @Autowired
    private FuncionariosService apicepService;

    @PostMapping
    public FuncionariosModel salvar(@RequestBody FuncionariosModel apicepModel) {
        return apicepService.salvar(apicepModel);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<FuncionariosModel> usuario = apicepService.buscarPorEmail(loginRequest.getEmail());
        
        if (usuario.isEmpty() || !usuario.get().getSenha().equals(loginRequest.getSenha())) {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }

        return ResponseEntity.ok(usuario.get());
    }

    @GetMapping
    public List<FuncionariosModel> listarTodos() {
        return apicepService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (apicepService.findByID(id).isPresent()) {
            apicepService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosModel> update(@PathVariable Long id, @RequestBody FuncionariosModel apicepModel) {
        if (apicepService.findByID(id).isPresent()) {
            apicepModel.setId(id);
            return ResponseEntity.ok(apicepService.salvar(apicepModel));
        }
        return ResponseEntity.notFound().build();
    }
}