package br.com.fiap.postechfastfood.infrastructure.persistence.jpa.entities;

import br.com.fiap.postechfastfood.domain.enums.TipoPessoaEnum;
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
@Table(name = "tb_Comandas")
public class ComandaEntity {

    @Id
    @Column(name = "cd_pedido", nullable = false, unique = true)
    private String cdPedido;
    @Column(name = "st_pedido", nullable = false)
    private String stPedido;
}
