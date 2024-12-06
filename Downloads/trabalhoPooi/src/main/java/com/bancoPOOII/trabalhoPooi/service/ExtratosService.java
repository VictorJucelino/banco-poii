
package com.bancoPOOII.trabalhoPooi.service;

import com.bancoPOOII.trabalhoPooi.dto.ExtratosDTO;
import com.bancoPOOII.trabalhoPooi.entity.Extratos;
import com.bancoPOOII.trabalhoPooi.repository.ExtratosRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExtratosService {
    public final ExtratosRepository extratosRepository;

    // Listar todos os extratos
    public List<Extratos> listarExtratos() {
        return extratosRepository.findAll();
    }

    // Cadastrar um novo extrato
    public Extratos cadastrarExtrato(ExtratosDTO extratosDTO) {
        // Criar a entidade Extratos
        Extratos extrato = new Extratos();
        extrato.setId_conta(extratosDTO.getId_conta());
        extrato.setTipo(extratosDTO.getTipo());
        extrato.setQuantia(extratosDTO.getQuantia());
        extrato.setSaldo(extratosDTO.getSaldo());
        extrato.setData_hora(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")));

        // Salvar o extrato no banco
        return extratosRepository.save(extrato);
    }



    // Buscar extrato pelo ID
    public Optional<Extratos> buscarExtratoPeloId(int id) {
        return extratosRepository.findById(id);
    }
    // Buscar pelo numero da conta
    public List<Extratos> listarExtratosPorNumeroConta(int numeroConta) {
        return extratosRepository.findByIdConta(numeroConta);
    }

}
