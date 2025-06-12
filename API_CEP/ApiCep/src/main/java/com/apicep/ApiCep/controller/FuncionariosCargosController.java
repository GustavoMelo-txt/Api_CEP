package com.apicep.ApiCep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apicep.ApiCep.model.*;
import com.apicep.ApiCep.servicer.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/funcionarios-por-cargos")
@CrossOrigin(origins = "*")
public class FuncionariosCargosController {
    @Autowired
    private funcionariosCargoService funcionarioscargosService;

    @PostMapping
    public FuncionariosCargosModel salvar(@RequestBody FuncionariosCargosModel funcionarioscargosModel) {
        return funcionarioscargosService.salvar(funcionarioscargosModel);
    }

    @GetMapping
    public List<FuncionariosCargosModel> listarTodos() {
        return funcionarioscargosService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosCargosModel> detalharPorId(@PathVariable Long id) {
        Optional<FuncionariosCargosModel> funcionarioCargo = funcionarioscargosService.findByID(id);
    
        if (funcionarioCargo.isPresent()) {
            return ResponseEntity.ok(funcionarioCargo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/por-cargo")
    public ResponseEntity<List<FuncionariosCargosModel>> filtrarPorCargo(
        @RequestParam Long cargoId 
    ) {
        List<FuncionariosCargosModel> registros = funcionarioscargosService.filtrarPorCargo(cargoId);
        
        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(registros);
    }

     @GetMapping("/por-funcionarios")
    public ResponseEntity<List<FuncionariosCargosModel>> filtrarPorFuncionarios(
        @RequestParam Long funcionariosId 
    ) {
        List<FuncionariosCargosModel> registros = funcionarioscargosService.filtrarPorCargo(funcionariosId);
        
        if (registros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(registros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (funcionarioscargosService.findByID(id).isPresent()) {
            funcionarioscargosService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosCargosModel> update(@PathVariable Long id, @RequestBody FuncionariosCargosModel funcionarioscargosModel) {
        if (funcionarioscargosService.findByID(id).isPresent()) {
            funcionarioscargosModel.setId(id);
            return ResponseEntity.ok(funcionarioscargosService.salvar(funcionarioscargosModel));
        }
        return ResponseEntity.notFound().build();
    }
}