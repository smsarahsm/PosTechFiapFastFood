package br.com.fiap.postechfasfood.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
public class PagamentoVO {
    private UUID cdPagamento;
    private UUID cdPedido;
    private double vlPagamento;
    private LocalDateTime dhPagamento;
    private LocalDateTime dhAtualizacao;
    private String tpStatus;
}
