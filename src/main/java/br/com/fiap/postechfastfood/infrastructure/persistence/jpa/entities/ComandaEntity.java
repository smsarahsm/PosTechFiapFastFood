package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_Pedidos")
public class ComandaEntity {

    @Id
    @Column(name = "cdPedido", nullable = false, unique = true)
    private UUID cdPedido;
    @Column(name = "cd_doc_cliente", nullable = false)
    private String cdDocCliente;
    @Column(name = "cd_doc_funcionario", nullable = false)
    private String cdDocFuncionario;
    @Enumerated(EnumType.STRING)
    @Column(name = "tx_status", nullable = false)
    private TipoProdutoStatusEnum txStatus;
    @Column(name = "nr_pedido", nullable = false)
    private int nrPedido;
    @Column(name = "dh_criacao_pedido", nullable = false)
    private LocalDateTime dhCriacaoPedido;
    @Column(name = "dh_ult_atualizacao", nullable = false)
    private LocalDateTime dhUltAtualizacao;
}
