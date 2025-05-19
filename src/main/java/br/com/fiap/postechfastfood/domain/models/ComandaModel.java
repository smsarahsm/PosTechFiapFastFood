package br.com.fiap.postechfastfood.domain.models;

import br.com.fiap.postechfastfood.domain.enums.TipoProdutoStatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandaModel {

    private  UUID cdPedido;
    private  String cdDocCliente;
    private String cdDocFuncionario;
    private TipoProdutoStatusEnum txStatus;
    private int nrPedido;
    private LocalDateTime dhCriacaoPedido;
    private LocalDateTime dhUltAtualizacao;

    public ComandaModel() {}

    public ComandaModel(UUID cdPedido, String cdDocCliente, String cdDocFuncionario, TipoProdutoStatusEnum txStatus, int nrPedido, LocalDateTime dhCriacaoPedido, LocalDateTime dhUltAtualizacao) {
        this.cdPedido = cdPedido;
        this.cdDocCliente = cdDocCliente;
        this.cdDocFuncionario = cdDocFuncionario;
        this.txStatus = txStatus;
        this.nrPedido = nrPedido;
        this.dhCriacaoPedido = dhCriacaoPedido;
        this.dhUltAtualizacao = dhUltAtualizacao;
    }

    public UUID getCdPedido() {
        return cdPedido;
    }
    public void setCdPedido(UUID cdPedido) {
        this.cdPedido = cdPedido;
    }

    public String getCdDocCliente() {
        return cdDocCliente;
    }
    public void setCdDocCliente(String cdDocCliente) {
        this.cdDocCliente = cdDocCliente;
    }
    public String getCdDocFuncionario() {
        return cdDocFuncionario;
    }
    public void setCdDocFuncionario(String cdDocFuncionario) {
        this.cdDocFuncionario = cdDocFuncionario;
    }
    public TipoProdutoStatusEnum getTxStatus() {
        return txStatus;
    }
    public void setTxStatus(TipoProdutoStatusEnum txStatus) {
        this.txStatus = txStatus;
    }
    public int getNrPedido() {
        return nrPedido;
    }
    public void setNrPedido(int nrPedido) {
        this.nrPedido = nrPedido;
    }
    public LocalDateTime getDhCriacaoPedido() {
        return dhCriacaoPedido;
    }
    public void setDhCriacaoPedido(LocalDateTime dhCriacaoPedido) {
        this.dhCriacaoPedido = dhCriacaoPedido;
    }
    public LocalDateTime getDhUltAtualizacao() {
        return dhUltAtualizacao;
    }
    public void setDhUltAtualizacao(LocalDateTime dhUltAtualizacao) {
        this.dhUltAtualizacao = dhUltAtualizacao;
    }

    public static class Builder {
        private UUID cdPedido;
        private String cdDocCliente;
        private String cdDocFuncionario;
        private TipoProdutoStatusEnum txStatus;
        private int nrPedido;
        private LocalDateTime dhCriacaoPedido;
        private LocalDateTime dhUltAtualizacao;

        public Builder setCdPedido(UUID cdPedido) {
            this.cdPedido = cdPedido;
            return this;
        }

        public Builder setCdDocCliente(String cdDocCliente) {
            this.cdDocCliente = cdDocCliente;
            return this;
        }

        public Builder setCdDocFuncionario(String cdDocFuncionario) {
            this.cdDocFuncionario = cdDocFuncionario;
            return this;
        }

        public Builder setTxStatus(TipoProdutoStatusEnum txStatus) {
            this.txStatus = txStatus;
            return this;
        }

        public Builder setNrPedido(int nrPedido) {
            this.nrPedido = nrPedido;
            return this;
        }

        public Builder setDhCriacaoPedido(LocalDateTime dhCriacaoPedido) {
            this.dhCriacaoPedido = dhCriacaoPedido;
            return this;
        }

        public Builder setDhUltAtualizacao(LocalDateTime dhUltAtualizacao) {
            this.dhUltAtualizacao = dhUltAtualizacao;
            return this;
        }

        public ComandaModel build() {
            return new ComandaModel(cdPedido, cdDocCliente, cdDocFuncionario, txStatus, nrPedido, dhCriacaoPedido, dhUltAtualizacao);
        }
    }

}


