package br.com.fiap.postechfasfood.entities;


import br.com.fiap.postechfasfood.types.TipoStatusPedidoEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PedidoVO {

    private UUID cdPedido;
    private String cdDocCliente;
    private String cdDocFuncionario;
    private TipoStatusPedidoEnum txStatus;
    private int nrPedido;
    private LocalDateTime dhCriacaoPedido;
    private LocalDateTime dhUltAtualizacao;
    private List<ItensPedidoVO> itens;

    public PedidoVO() {
    }

    public PedidoVO(UUID cdPedido, String cdDocCliente, String cdDocFuncionario, TipoStatusPedidoEnum txStatus, int nrPedido, LocalDateTime dhCriacaoPedido, LocalDateTime dhUltAtualizacao, List<ItensPedidoVO> itens) {
        this.cdPedido = cdPedido;
        this.cdDocCliente = cdDocCliente;
        this.cdDocFuncionario = cdDocFuncionario;
        this.txStatus = txStatus;
        this.nrPedido = nrPedido;
        this.dhCriacaoPedido = dhCriacaoPedido;
        this.dhUltAtualizacao = dhUltAtualizacao;
        this.itens = itens;
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

    public List<ItensPedidoVO> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedidoVO> itens) {
        this.itens = itens;
    }

    public static class Builder {
        private UUID cdPedido;
        private String cdDocCliente;
        private String cdDocFuncionario;
        private TipoStatusPedidoEnum txStatus;
        private int nrPedido;
        private LocalDateTime dhCriacaoPedido;
        private LocalDateTime dhUltAtualizacao;
        private List<ItensPedidoVO> itens;

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

        public Builder setItens(List<ItensPedidoVO> itens){
            this.itens = itens;
            return this;
        }

        public PedidoVO build() {
            return new PedidoVO(cdPedido, cdDocCliente, cdDocFuncionario, txStatus, nrPedido, dhCriacaoPedido, dhUltAtualizacao, itens);
        }
    }

    @Override
    public String toString() {
        return "PedidoModel{" +
                "cdPedido=" + cdPedido +
                ", cdDocCliente='" + cdDocCliente + '\'' +
                ", cdDocFuncionario='" + cdDocFuncionario + '\'' +
                ", txStatus=" + txStatus +
                ", nrPedido=" + nrPedido +
                ", dhCriacaoPedido=" + dhCriacaoPedido +
                ", dhUltAtualizacao=" + dhUltAtualizacao +
                ", itens=" + itens +
                '}';
    }
}


