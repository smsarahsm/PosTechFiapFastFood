package br.com.fiap.postechfasfood.gateways.entities;

import java.util.UUID;

import br.com.fiap.postechfasfood.types.TipoCategoriaProdutoEnum;

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
@Table(name = "tb_produtos")
public class ProdutoEntity {
    @Id
    @Column(name = "cd_produto", nullable = false, unique = true)
    private String cdProduto;
    @Column(name = "nm_produto", nullable = false)
    private String nmProduto;
    @Column(name = "ds_descricao", nullable = false)
    private String dsDescricao;
    @Column(name = "vl_preco", nullable = false)
    private double vlPreco;
    @Column(name = "sn_ativo")
    private boolean snAtivo;
    @Enumerated(EnumType.STRING)
    @Column(name = "tp_categoria", nullable = false)
    private TipoCategoriaProdutoEnum tpCategoria;
    //@OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
    //private List<ProdutoEntity> produtoEntities;

    @Override
    public String toString() {
        return "ProdutoEntity{" +
                "cdProduto=" + cdProduto +
                ", nmProduto='" + nmProduto + '\'' +
                ", dsDescricao='" + dsDescricao + '\'' +
                ", vlPreco=" + vlPreco +
                ", snAtivo=" + snAtivo +
                ", tpCategoria=" + tpCategoria +
                '}';
    }
}
