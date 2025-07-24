package br.com.fiap.postechfastfood_old.infrastructure.persistence.jpa.entities;


import br.com.fiap.postechfastfood_old.domain.enums.TipoStatusPedidoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedidos")
public class PedidoEntity {

    @Id
    @Column(name = "cd_pedido", nullable = false, unique = true)
    private UUID cdPedido;

    @Column(name = "cd_doc_cliente")
    private String cdDocCliente;

    @Column(name = "cd_doc_funcionario")
    private String cdDocFuncionario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tx_status", nullable = false)
    private TipoStatusPedidoEnum txStatus;

    @Column(name = "nr_pedido", nullable = false)
    private int nrPedido;

    @Column(name = "dh_criacao_pedido")
    private LocalDateTime dhCriacaoPedido;

    @Column(name = "dh_ult_atualizacao")
    private LocalDateTime dhUltAtualizacao;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ProdutosPedidoEntity> produtosPedidoEntities;

    @Override
    public String toString() {
        return "PedidoEntity{" +
                "cdPedido=" + cdPedido +
                ", cdDocCliente='" + cdDocCliente + '\'' +
                ", cdDocFuncionario='" + cdDocFuncionario + '\'' +
                ", txStatus=" + txStatus +
                ", nrPedido=" + nrPedido +
                ", dhCriacaoPedido=" + dhCriacaoPedido +
                ", dhUltAtualizacao=" + dhUltAtualizacao +
                '}';
    }
}
