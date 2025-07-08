package br.com.fiap.postechfasfood.entities;

import java.util.List;

public class PedidoVO {

    private String cdDocCliente;
    private List<String> itens;

    public PedidoVO() {
    }

    public PedidoVO(String cdDocCliente, List<String> itens) {
        this.cdDocCliente = cdDocCliente;
        this.itens = itens;
    }

    public String getCdDocCliente() {
        return cdDocCliente;
    }

    public PedidoVO setCdDocCliente(String cdDocCliente) {
        this.cdDocCliente = cdDocCliente;
        return this;
    }

    public List<String> getItens() {
        return itens;
    }

    public PedidoVO setItens(List<String> itens) {
        this.itens = itens;
        return this;
    }

    public static class Builder {
        private String cdDocCliente;
        private List<String> itens;

        public PedidoVO.Builder setCdDocCliente(String cdDocCliente) {
            this.cdDocCliente = cdDocCliente;
            return  this;
        }

        public PedidoVO.Builder setItens(List<String> itens) {
            this.itens = itens;
            return this;
        }

        public PedidoVO build() { return new PedidoVO(cdDocCliente, itens); }
    }
}
