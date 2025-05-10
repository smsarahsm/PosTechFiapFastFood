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
@Table(name = "tb_pessoas")
public class PessoaEntity {

    @Id
    @Column(name = "cd_doc_pessoa", nullable = false, unique = true)
    private String cdDocPessoa;
    @Column(name = "nm_pessoa", nullable = false)
    private String nmPessoa;
    @Enumerated(EnumType.STRING)
    @Column(name = "tp_pessoa", nullable = false)
    private TipoPessoaEnum tpPessoa;
    @Column(name = "ds_email", nullable = false)
    private String dsEmail;
}
