package com.bancoPOOII.trabalhoPooi.repository;

import com.bancoPOOII.trabalhoPooi.entity.Extratos;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtratosRepository extends JpaRepository<Extratos, Integer> {
    Optional<Extratos> findTopByOrderByIdDesc();
    List<Extratos> findByIdConta(int idConta);
}
