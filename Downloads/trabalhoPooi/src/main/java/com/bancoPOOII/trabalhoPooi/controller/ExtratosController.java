package com.bancoPOOII.trabalhoPooi.controller;

import com.bancoPOOII.trabalhoPooi.dto.ExtratosDTO;
import com.bancoPOOII.trabalhoPooi.entity.Extratos;
import com.bancoPOOII.trabalhoPooi.service.ExtratosService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extratos")
@RequiredArgsConstructor // Lombok
public class ExtratosController {
    public final ExtratosService extratosService;
    
    @GetMapping("/buscar-extratos")
    public List<Extratos> buscarTodosExtratos() {
        return extratosService.listarExtratos();
    }

    // Endpoint para criar um novo extrato
    @PostMapping
    public ResponseEntity<Extratos> criarExtrato(@RequestBody ExtratosDTO extratosDTO) {
        Extratos novoExtrato = extratosService.cadastrarExtrato(extratosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoExtrato);
    }

    
    @GetMapping("/buscar-por-conta/{numeroConta}")
    public List<Extratos> buscarExtratosPorNumeroConta(@PathVariable int numeroConta) {
        return extratosService.listarExtratosPorNumeroConta(numeroConta);
    }

}

