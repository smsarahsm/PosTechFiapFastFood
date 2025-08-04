package br.com.fiap.postechfasfood.entities;


import br.com.fiap.postechfasfood.types.TipoPessoaEnum;

public class PessoaVO {

    private String cdDocPessoa;
    private String nmPessoa;
    private TipoPessoaEnum tpPessoa;
    private String dsEmail;

    public PessoaVO() {
    }

    public PessoaVO(String cdDocPessoa, String nmPessoa, TipoPessoaEnum tpPessoa, String dsEmail) {
        this.cdDocPessoa = cdDocPessoa;
        this.nmPessoa = nmPessoa;
        this.tpPessoa = tpPessoa;
        this.dsEmail = dsEmail;
    }

    public String getCdDocPessoa() {
        return cdDocPessoa;
    }

    public PessoaVO setCdDocPessoa(String cdDocPessoa) {
        this.cdDocPessoa = cdDocPessoa;
        return this;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public PessoaVO setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
        return this;
    }

    public TipoPessoaEnum getTpPessoa() {
        return tpPessoa;
    }

    public PessoaVO setTpPessoa(TipoPessoaEnum tpPessoa) {
        this.tpPessoa = tpPessoa;
        return this;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public PessoaVO setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
        return this;
    }

    public static class Builder {
        private String cdDocPessoa;
        private String nmPessoa;
        private TipoPessoaEnum tpPessoa;
        private String dsEmail;

        public PessoaVO.Builder setCdDocPessoa(String cdDocPessoa) {
            this.cdDocPessoa = cdDocPessoa;
            return this;
        }

        public PessoaVO.Builder setNmPessoa(String nmPessoa) {
            this.nmPessoa = nmPessoa;
            return this;
        }

        public PessoaVO.Builder setTpPessoa(TipoPessoaEnum tpPessoa) {
            this.tpPessoa = tpPessoa;
            return this;
        }

        public PessoaVO.Builder setDsEmail(String dsEmail) {
            this.dsEmail = dsEmail;
            return this;
        }

        public PessoaVO build() {
            return new PessoaVO(cdDocPessoa, nmPessoa, tpPessoa, dsEmail);
        }
    }
}
