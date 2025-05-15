package br.com.fiap.postechfastfood.domain.models;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class PedidosModel {

    private  UUID cd_pedido;
    private  String cd_doc_cliente;
    private String cd_doc_funcionario;
    private TipoProdutoStatusEnum tx_status;
    private int nr_pedido;
    private LocalDateTime dh_criacao_pedido;
    private LocalDateTime dh_ult_atualizacao;

    public PedidosModel() {}

    public PedidosModel(UUID cd_pedido, String cd_doc_cliente, String cd_doc_funcionario, TipoProdutoStatusEnum tx_status, int nr_pedido, LocalDateTime dh_criacao_pedido, LocalDateTime dh_ult_atualizacao) {
        this.cd_pedido = cd_pedido;
        this.cd_doc_cliente = cd_doc_cliente;
        this.cd_doc_funcionario = cd_doc_funcionario;
        this.tx_status = tx_status;
        this.nr_pedido = nr_pedido;
        this.dh_criacao_pedido = dh_criacao_pedido;
        this.dh_ult_atualizacao = dh_ult_atualizacao;
    }

    public UUID getCd_pedido() {
        return cd_pedido;
    }
    public void setCd_pedido(UUID cd_pedido) {
        this.cd_pedido = cd_pedido;
    }

    public String getCd_doc_cliente() {
        return cd_doc_cliente;
    }
    public void setCd_doc_cliente(String cd_doc_cliente) {
        this.cd_doc_cliente = cd_doc_cliente;
    }
    public String getCd_doc_funcionario() {
        return cd_doc_funcionario;
    }
    public void setCd_doc_funcionario(String cd_doc_funcionario) {
        this.cd_doc_funcionario = cd_doc_funcionario;
    }
    public TipoProdutoStatusEnum getTx_status() {
        return tx_status;
    }
    public void setTx_status(TipoProdutoStatusEnum tx_status) {
        this.tx_status = tx_status;
    }
    public int getNr_pedido() {
        return nr_pedido;
    }
    public void setNr_pedido(int nr_pedido) {
        this.nr_pedido = nr_pedido;
    }
    public LocalDateTime getDh_criacao_pedido() {
        return dh_criacao_pedido;
    }
    public void setDh_criacao_pedido(LocalDateTime dh_criacao_pedido) {
        this.dh_criacao_pedido = dh_criacao_pedido;
    }
    public LocalDateTime getDh_ult_atualizacao() {
        return dh_ult_atualizacao;
    }
    public void setDh_ult_atualizacao(LocalDateTime dh_ult_atualizacao) {
        this.dh_ult_atualizacao = dh_ult_atualizacao;
    }

    public static class Builder {
        private UUID cd_pedido;
        private String cd_doc_cliente;
        private String cd_doc_funcionario;
        private TipoProdutoStatusEnum tx_status;
        private int nr_pedido;
        private LocalDateTime dh_criacao_pedido;
        private LocalDateTime dh_ult_atualizacao;

        public Builder setCd_pedido(UUID cd_pedido) {
            this.cd_pedido = cd_pedido;
            return this;
        }

        public Builder setCd_doc_cliente(String cd_doc_cliente) {
            this.cd_doc_cliente = cd_doc_cliente;
            return this;
        }

        public Builder setCd_doc_funcionario(String cd_doc_funcionario) {
            this.cd_doc_funcionario = cd_doc_funcionario;
            return this;
        }

        public Builder setTx_status(TipoProdutoStatusEnum tx_status) {
            this.tx_status = tx_status;
            return this;
        }

        public Builder setNr_pedido(int nr_pedido) {
            this.nr_pedido = nr_pedido;
            return this;
        }

        public Builder setDh_criacao_pedido(LocalDateTime dh_criacao_pedido) {
            this.dh_criacao_pedido = dh_criacao_pedido;
            return this;
        }

        public Builder setDh_ult_atualizacao(LocalDateTime dh_ult_atualizacao) {
            this.dh_ult_atualizacao = dh_ult_atualizacao;
            return this;
        }

        public PedidosModel build() {
            return new PedidosModel(cd_pedido, cd_doc_cliente, cd_doc_funcionario, tx_status, nr_pedido, dh_criacao_pedido, dh_ult_atualizacao);
        }
    }

}


