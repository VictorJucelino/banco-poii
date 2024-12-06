
package com.bancoPOOII.trabalhoPooi.repository;

import com.bancoPOOII.trabalhoPooi.entity.Contas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContasRepository extends JpaRepository<Contas, Integer> {
    Optional<Contas> findTopByOrderByIdDesc();
    Optional<Contas> findByNumero(int numero);
}


