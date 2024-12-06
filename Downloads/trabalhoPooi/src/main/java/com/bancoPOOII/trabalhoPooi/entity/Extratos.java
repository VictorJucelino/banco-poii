
package com.bancoPOOII.trabalhoPooi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Extratos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int id_conta;
    private String data_hora;
    private String tipo;
    private double quantia;
    private double saldo;

}
