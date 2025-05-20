package br.com.fiap.postechfastfood.domain.models;

import br.com.fiap.postechfastfood.domain.enums.TipoStatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PedidoModel {

    private UUID cdPedido;
    private String cdDocCliente;
    private String cdDocFuncionario;
    private TipoStatusPedidoEnum txStatus;
    private int nrPedido;
    private LocalDateTime dhCriacaoPedido;
    private LocalDateTime dhUltAtualizacao;
    private List<ProdutoPedidoModel> lsProdutoPedido;

    public PedidoModel() {
    }

    public PedidoModel(UUID cdPedido, String cdDocCliente, String cdDocFuncionario, TipoStatusPedidoEnum txStatus, int nrPedido, LocalDateTime dhCriacaoPedido, LocalDateTime dhUltAtualizacao, List<ProdutoPedidoModel> lsProdutoPedido) {
        this.cdPedido = cdPedido;
        this.cdDocCliente = cdDocCliente;
        this.cdDocFuncionario = cdDocFuncionario;
        this.txStatus = txStatus;
        this.nrPedido = nrPedido;
        this.dhCriacaoPedido = dhCriacaoPedido;
        this.dhUltAtualizacao = dhUltAtualizacao;
        this.lsProdutoPedido = lsProdutoPedido;
    }

    public UUID getCdPedido() {
        return cdPedido;
    }

    public void setCdPedido(UUID cdPedido) {
        this.cdPedido = cdPedido;
    }

    public String getcdDocCliente() {
        return cdDocCliente;
    }

    public void setcdDocCliente(String cdDocCliente) {
        this.cdDocCliente = cdDocCliente;
    }

    public String getCdDocFuncionario() {
        return cdDocFuncionario;
    }

    public void setCdDocFuncionario(String cdDocFuncionario) {
        this.cdDocFuncionario = cdDocFuncionario;
    }

    public TipoStatusPedidoEnum getTxStatus() {
        return txStatus;
    }

    public void setTxStatus(TipoStatusPedidoEnum txStatus) {
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

    public List<ProdutoPedidoModel> getLsProdutoPedido() {
        return lsProdutoPedido;
    }

    public void setLsProdutoPedido(List<ProdutoPedidoModel> lsProdutoPedido) {
        this.lsProdutoPedido = lsProdutoPedido;
    }

    public static class Builder {
        private UUID cdPedido;
        private String cdDocCliente;
        private String cdDocFuncionario;
        private TipoStatusPedidoEnum txStatus;
        private int nrPedido;
        private LocalDateTime dhCriacaoPedido;
        private LocalDateTime dhUltAtualizacao;
        private List<ProdutoPedidoModel> lsProdutoPedido;

        public Builder setCdPedido(UUID cdPedido) {
            this.cdPedido = cdPedido;
            return this;
        }

        public Builder setcdDocCliente(String cdDocCliente) {
            this.cdDocCliente = cdDocCliente;
            return this;
        }

        public Builder setCdDocFuncionario(String cdDocFuncionario) {
            this.cdDocFuncionario = cdDocFuncionario;
            return this;
        }

        public Builder setTxStatus(TipoStatusPedidoEnum txStatus) {
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

        public Builder setLsProdutoPedido(List<ProdutoPedidoModel> lsProdutoPedido) {
            this.lsProdutoPedido = lsProdutoPedido;
            return this;
        }

        public PedidoModel build() {
            return new PedidoModel(cdPedido, cdDocCliente, cdDocFuncionario, txStatus, nrPedido, dhCriacaoPedido, dhUltAtualizacao, lsProdutoPedido);
        }
    }

}


