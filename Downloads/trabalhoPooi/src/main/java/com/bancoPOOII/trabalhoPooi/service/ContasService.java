
package com.bancoPOOII.trabalhoPooi.service;

import com.bancoPOOII.trabalhoPooi.dto.ContasDTO;
import com.bancoPOOII.trabalhoPooi.entity.Contas;
import com.bancoPOOII.trabalhoPooi.repository.ContasRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ContasService {
    public final ContasRepository contasRepository;
    
    public List<Contas> listarContas(){
         return contasRepository.findAll();
    }
    
    public Contas cadastrarConta(ContasDTO body) {
    // Criar a entidade Contas com os valores do DTO
    Contas conta = new Contas();
    conta.setNome(body.getNome());
    conta.setTipo(body.getTipo());
    conta.setSaldo(body.getSaldo());
    conta.setLimite(body.getLimite());
    conta.setRendimento(body.getRendimento());

    // Salvei a conta, pra gerar o ID
    Contas contaSalva = contasRepository.save(conta);

    // Depois atualizo o número da conta com base no ID que foi gerado
    contaSalva.setNumero(contaSalva.getId() + 1000);

    /* Salvo novamente (atualizando) para salvar o número como 
    o valor da conta + 1000 (só pra seguir um método pra definir
    um valor fixo pro número da cont, sem precisar o funcionário informar)*/
    return contasRepository.save(contaSalva);
}
    
    //APAGAR: Buscar o dado e depois apagr ele, como explicado na videoaula
    public Optional <Contas> buscarContaPeloId (int id){
        return contasRepository.findById(id);
    }
    
    public void apagarConta(Contas conta){
        contasRepository.delete(conta);
    }
    
    public Contas atualizarConta(int id, ContasDTO body) {
    Contas conta = contasRepository.findById(id).orElseThrow(() -> 
        new IllegalArgumentException("Conta não encontrada para o ID: " + id)
    );
    

    // Atualiza os campos da conta com os valores do DTO
    conta.setNumero(body.getNumero());
    conta.setNome(body.getNome());
    conta.setTipo(body.getTipo());
    conta.setSaldo(body.getSaldo());
    conta.setLimite(body.getLimite());
    conta.setRendimento(body.getRendimento());

    return contasRepository.save(conta);
    }
    
    public Optional<Contas> buscarContaPeloNumero(int numero) {
        return contasRepository.findByNumero(numero);
    }
}

