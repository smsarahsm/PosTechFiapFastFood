package br.com.fiap.postechfastfood.domain.models;

import br.com.fiap.postechfastfood.domain.enums.TipoPessoaEnum;

public class PessoaModel {

    private String cdDocPessoa;
    private String nmPessoa;
    private TipoPessoaEnum tpPessoa;
    private String dsEmail;

    public PessoaModel() {}

    public PessoaModel(String cdDocPessoa, String nmPessoa, TipoPessoaEnum tpPessoa, String dsEmail) {
        this.cdDocPessoa = cdDocPessoa;
        this.nmPessoa = nmPessoa;
        this.tpPessoa = tpPessoa;
        this.dsEmail = dsEmail;
    }

    public String getCdDocPessoa() {
        return cdDocPessoa;
    }

    public PessoaModel setCdDocPessoa(String cdDocPessoa) {
        this.cdDocPessoa = cdDocPessoa;
        return this;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public PessoaModel setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
        return this;
    }

    public TipoPessoaEnum getTpPessoa() {
        return tpPessoa;
    }

    public PessoaModel setTpPessoa(TipoPessoaEnum tpPessoa) {
        this.tpPessoa = tpPessoa;
        return this;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public PessoaModel setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
        return this;
    }

    public static class Builder {
        private String cdDocPessoa;
        private String nmPessoa;
        private TipoPessoaEnum tpPessoa;
        private String dsEmail;

        public Builder setCdDocPessoa(String cdDocPessoa) {
            this.cdDocPessoa = cdDocPessoa;
            return this;
        }

        public Builder setNmPessoa(String nmPessoa) {
            this.nmPessoa = nmPessoa;
            return this;
        }

        public Builder setTpPessoa(TipoPessoaEnum tpPessoa) {
            this.tpPessoa = tpPessoa;
            return this;
        }

        public Builder setDsEmail(String dsEmail) {
            this.dsEmail = dsEmail;
            return this;
        }

        public PessoaModel build() {
            return new PessoaModel(cdDocPessoa, nmPessoa, tpPessoa, dsEmail);
        }
    }
}
