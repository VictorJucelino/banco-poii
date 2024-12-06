
package com.bancoPOOII.trabalhoPooi.dto;

import com.bancoPOOII.trabalhoPooi.entity.Contas;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExtratosDTO {
    private int id;
    private int id_conta;
    private Contas conta;
    private String dataHora;
    private String tipo;
    private double quantia;
    private double saldo;
}
