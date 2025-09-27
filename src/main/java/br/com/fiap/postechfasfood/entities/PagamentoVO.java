package br.com.fiap.postechfasfood.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoVO {
    private String cdPagamento;
    private String cdPedido;
    private double vlPagamento;
    private LocalDateTime dhPagamento;
    private LocalDateTime dhAtualizacao;
    private String tpStatus;

    public PagamentoVO() {
    }

    public String getCdPagamento() {
        return cdPagamento;
    }

    public void setCdPagamento(String cdPagamento) {
        this.cdPagamento = cdPagamento;
    }

    public String getCdPedido() {
        return cdPedido;
    }

    public void setCdPedido(String cdPedido) {
        this.cdPedido = cdPedido;
    }

    public double getVlPagamento() {
        return vlPagamento;
    }

    public void setVlPagamento(double vlPagamento) {
        this.vlPagamento = vlPagamento;
    }

    public LocalDateTime getDhPagamento() {
        return dhPagamento;
    }

    public void setDhPagamento(LocalDateTime dhPagamento) {
        this.dhPagamento = dhPagamento;
    }

    public LocalDateTime getDhAtualizacao() {
        return dhAtualizacao;
    }

    public void setDhAtualizacao(LocalDateTime dhAtualizacao) {
        this.dhAtualizacao = dhAtualizacao;
    }

    public String getTpStatus() {
        return tpStatus;
    }

    public void setTpStatus(String tpStatus) {
        this.tpStatus = tpStatus;
    }
}
