package br.com.fiap.postechfasfood.entities;

import java.util.UUID;

public class ItensPedidoVO {
    private String cdProduto;
    private int vlQuantidade;

    public ItensPedidoVO() {
    }

    public ItensPedidoVO(String cdProduto, int vlQuantidade) {
        this.cdProduto = cdProduto;
        this.vlQuantidade = vlQuantidade;
    }

    public String getCdProduto() { return cdProduto; }

    public void setCdProduto(String cdProduto) { this.cdProduto = cdProduto; }

    public int getVlQuantidade() {
        return vlQuantidade;
    }

    public void setVlQuantidade(int vlQuantidade) {
        this.vlQuantidade = vlQuantidade;
    }


    public static class Builder {
        private String cdProduto;
        private int vlQuantidade;

        public Builder setCdProduto(String cdProduto) {
            this.cdProduto = cdProduto;
            return this;
        }

        public Builder vlQuantidade(int vlQuantidade) {
            this.vlQuantidade = vlQuantidade;
            return this;
        }

        public ItensPedidoVO build() {
            return new ItensPedidoVO(cdProduto, vlQuantidade);
        }
    }

    @Override
    public String toString() {
        return "ItensPedidoModel{" +
                "cdProduto=" + cdProduto +
                ", vlQuantidade=" + vlQuantidade +
                '}';
    }
}
