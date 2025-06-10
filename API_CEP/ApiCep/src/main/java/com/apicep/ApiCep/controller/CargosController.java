package com.apicep.ApiCep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/cargos")
@CrossOrigin(origins = "*")
public class CargosController {
    @Autowired
    private CargosService cargosService;

    @PostMapping
    public CargosModel salvar(@RequestBody CargosModel cargosModel) {
        return cargosService.salvar(cargosModel); // Salva no banco
    }

    @GetMapping
    public List<CargosModel> listarTodos() {
        return cargosService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (cargosService.findByID(id).isPresent()) {
            cargosService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargosModel> update(@PathVariable Long id, @RequestBody CargosModel cargosModel) {
        if (cargosService.findByID(id).isPresent()) {
            cargosModel.setId(id);
            return ResponseEntity.ok(cargosService.salvar(cargosModel));
        }
        return ResponseEntity.notFound().build();
    }
}