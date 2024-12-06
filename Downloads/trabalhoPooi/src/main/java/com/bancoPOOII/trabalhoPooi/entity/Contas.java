
package com.bancoPOOII.trabalhoPooi.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int numero;

    private String nome;
    private String tipo;
    @Column(columnDefinition = "double default 0")
    private double saldo;

    @Column(columnDefinition = "double default 0")
    private double limite;

    @Column(columnDefinition = "double default 0")
    private double rendimento;
}
