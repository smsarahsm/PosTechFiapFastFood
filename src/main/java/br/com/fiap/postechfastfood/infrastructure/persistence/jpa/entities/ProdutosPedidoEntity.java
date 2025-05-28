package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities;

import br.com.fiap.postechfastfood.domain.models.PedidoModel;
import br.com.fiap.postechfastfood.domain.models.ProdutoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedidos_produtos")
@IdClass(ProdutosPedidoEntityId.class)
public class ProdutosPedidoEntity implements Serializable {

    @Id
    @JoinColumn(name = "cd_pedido", nullable = false)
    @ManyToOne(optional = false)
    private PedidoEntity pedido;

    @Id
    @JoinColumn(name = "cd_produto", nullable = false)
    @ManyToOne(optional = false)
    private ProdutoEntity produto;

    @Column(name = "vl_qtd", nullable = false)
    private int vlQuantidadeProduto;

    @Override
    public String toString() {
        return "ProdutosPedidoEntity{" +
                "pedido=" + pedido +
                ", produto=" + produto +
                ", vlQuantidadeProduto=" + vlQuantidadeProduto +
                '}';
    }
}
