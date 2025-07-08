package br.com.fiap.postechfasfood.gateways.entities;

import br.com.fiap.postechfasfood.entities.PessoaVO;
import br.com.fiap.postechfasfood.types.TipoPessoaEnum;
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
    public PessoaVO get() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}
