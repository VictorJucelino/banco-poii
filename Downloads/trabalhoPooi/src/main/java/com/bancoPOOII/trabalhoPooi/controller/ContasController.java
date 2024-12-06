
package com.bancoPOOII.trabalhoPooi.controller;
import com.bancoPOOII.trabalhoPooi.dto.ContasDTO;
import com.bancoPOOII.trabalhoPooi.entity.Contas;
import com.bancoPOOII.trabalhoPooi.service.ContasService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/contas")
@RequiredArgsConstructor // Lombok, aprendi :D
public class ContasController {
    public final ContasService contasService;
    
    @GetMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }
    
    @PostMapping
    public ResponseEntity <Contas> criarConta(@RequestBody ContasDTO body){
        return ResponseEntity
                .status(HttpStatusCode.valueOf(201)) // significa created
                .body(contasService.cadastrarConta(body));
    }
    
    @GetMapping("/buscar-contas")
    public List<Contas>buscarEListarTodasAsContas(){ // (R) Read os dados
        return contasService.listarContas();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarConta(@PathVariable("id") int id) {
        Optional<Contas> conta = contasService.buscarContaPeloId(id);
        if (conta.isPresent()) {
            contasService.apagarConta(conta.get());
            return ResponseEntity
                    .status(HttpStatusCode.valueOf(204)) // No Content
                    .build();
        }
        return ResponseEntity
                .status(HttpStatusCode.valueOf(404)) // Not Found
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contas> atualizarConta(@PathVariable("id") int id, @RequestBody ContasDTO body) {
        Optional<Contas> contaExistente = contasService.buscarContaPeloId(id);
        if (contaExistente.isPresent()) {
            Contas contaAtualizada = contasService.atualizarConta(id, body);
            return ResponseEntity.ok(contaAtualizada);
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).build(); // Not Found
    }
    
    @GetMapping("/buscar-por-numero/{numero}")
    public ResponseEntity<Contas> buscarContaPorNumero(@PathVariable int numero) {
        Optional<Contas> conta = contasService.buscarContaPeloNumero(numero);
        if (conta.isPresent()) {
            return ResponseEntity.ok(conta.get());
        }
        return ResponseEntity.status(404).build();
    }

}
