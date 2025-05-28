package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedidos_produtos")
public class ProdutoPedidoEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "cd_pedido", nullable = false)
    private PedidoEntity pedido;

    @Id
    @ManyToOne
    @JoinColumn(name = "cd_produto", nullable = false)
    private ProdutoEntity produto;

    @Column(name = "vl_qtd", nullable = false)
    private int vlQuantidadeProduto;


}
