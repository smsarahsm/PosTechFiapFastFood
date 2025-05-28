package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;
import br.com.fiap.postechfastfood.domain.enums.TipoPessoaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class ProdutoEntity {
    @Id
    @Column(name = "cd_produto", nullable = false, unique = true)
    private UUID cdProduto;
    @Column(name = "nm_produto", nullable = false)
    private String nmProduto;
    @Column(name = "ds_descricao", nullable = false)
    private String dsDescricao;
    @Column(name = "vl_preco", nullable = false)
    private double vlPreco;
    @Enumerated(EnumType.STRING)
    @Column(name = "tp_categoria", nullable = false)
    private TipoCategoriaProdutoEnum tpCategoria;
    @OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
    private List<ProdutosPedidoEntity> produtosPedidoEntities;

    @Override
    public String toString() {
        return "ProdutoEntity{" +
                "cdProduto=" + cdProduto +
                ", nmProduto='" + nmProduto + '\'' +
                ", dsDescricao='" + dsDescricao + '\'' +
                ", vlPreco=" + vlPreco +
                ", tpCategoria=" + tpCategoria +
                '}';
    }
}
