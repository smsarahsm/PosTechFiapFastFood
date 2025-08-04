package br.com.fiap.postechfasfood.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoVO {
    private UUID cdPagamento;
    private UUID cdPedido;
    private double vlPagamento;
    private LocalDateTime dhPagamento;
    private LocalDateTime dhAtualizacao;
    private String tpStatus;

    public PagamentoVO() {
    }

    public UUID getCdPagamento() {
        return cdPagamento;
    }

    public void setCdPagamento(UUID cdPagamento) {
        this.cdPagamento = cdPagamento;
    }

    public UUID getCdPedido() {
        return cdPedido;
    }

    public void setCdPedido(UUID cdPedido) {
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
