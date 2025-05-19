package br.com.fiap.postechfastfood.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;

public class Model {

    private UUID cdPedido;
    private  String cd_doc_cliente;
    private String cd_doc_funcionario;
    private TipoProdutoStatusEnum tx_status;
    private int nr_pedido;
    private LocalDateTime dh_criacao_pedido;
    private LocalDateTime dh_ult_atualizacao;

    public Model(UUID cdPedido, String cd_doc_cliente, String cd_doc_funcionario, TipoProdutoStatusEnum tx_status, int nr_pedido, LocalDateTime dh_criacao_pedido, LocalDateTime dh_ult_atualizacao) {
        this.cdPedido = cdPedido;
        this.cd_doc_cliente = cd_doc_cliente;
        this.cd_doc_funcionario = cd_doc_funcionario;
        this.tx_status = tx_status;
        this.nr_pedido = nr_pedido;
        this.dh_criacao_pedido = dh_criacao_pedido;
        this.dh_ult_atualizacao = dh_ult_atualizacao;
    }
        
    public UUID getCdPedido() {
        return cdPedido;
    }

    public Model setCdPedido(UUID cdPedido) {
        this.cdPedido = cdPedido;
        return this;
    }
    public String getCd_doc_cliente() {
        return cd_doc_cliente;
    }
    public Model setCd_doc_cliente(String cd_doc_cliente) {
        this.cd_doc_cliente = cd_doc_cliente;
        return this;
    }
    public String getCd_doc_funcionario() {
        return cd_doc_funcionario;
    }
    public Model setCd_doc_funcionario(String cd_doc_funcionario) {
        this.cd_doc_funcionario = cd_doc_funcionario;
        return this;
    }
    public TipoProdutoStatusEnum getTx_status() {
        return tx_status;
    }
    public Model setTx_status(TipoProdutoStatusEnum tx_status) {
        this.tx_status = tx_status;
        return this;
    }
    public int getNr_pedido() {
        return nr_pedido;
    }
    public Model setNr_pedido(int nr_pedido) {
        this.nr_pedido = nr_pedido;
        return this;
    }
    public LocalDateTime getDh_criacao_pedido() {
        return dh_criacao_pedido;
    }
    public Model setDh_criacao_pedido(LocalDateTime dh_criacao_pedido) {
        this.dh_criacao_pedido = dh_criacao_pedido;
        return this;
    }
    public LocalDateTime getDh_ult_atualizacao() {
        return dh_ult_atualizacao;
    }
    public Model setDh_ult_atualizacao(LocalDateTime dh_ult_atualizacao) {
        this.dh_ult_atualizacao = dh_ult_atualizacao;
        return this;
    }

    public static class Builder {
        private UUID cdPedido;
        private String cd_doc_cliente;
        private String cd_doc_funcionario;
        private TipoProdutoStatusEnum tx_status;
        private int nr_pedido;
        private LocalDateTime dh_criacao_pedido;
        private LocalDateTime dh_ult_atualizacao;

        public Builder setCdPedido(UUID cdPedido) {
            this.cdPedido = cdPedido;
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


        public Model build() {
            return new Model(cdPedido, cd_doc_cliente, cd_doc_funcionario, tx_status, nr_pedido, dh_criacao_pedido, dh_ult_atualizacao);
        }
    }
}


