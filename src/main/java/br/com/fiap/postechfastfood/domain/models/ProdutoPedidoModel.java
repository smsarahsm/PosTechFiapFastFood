package br.com.fiap.postechfastfood.domain.models;

import java.util.UUID;

public class ProdutoPedidoModel {
    private PedidoModel pedidoModel;
    private ProdutoModel produtoModel;
    private int vlQuantidadeProduto;

    public ProdutoPedidoModel() {
    }

    public ProdutoPedidoModel(ProdutoModel produtoModel, PedidoModel pedidoModel, int vlQuantidadeProduto) {
        this.produtoModel = produtoModel;
        this.pedidoModel = pedidoModel;
        this.vlQuantidadeProduto = vlQuantidadeProduto;
    }

    public PedidoModel getPedidoModel() {
        return pedidoModel;
    }

    public void setPedidoModel(PedidoModel pedidoModel) {
        this.pedidoModel = pedidoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public int getVlQuantidadeProduto() {
        return vlQuantidadeProduto;
    }

    public void setVlQuantidadeProduto(int vlQuantidadeProduto) {
        this.vlQuantidadeProduto = vlQuantidadeProduto;
    }

//    public static class Builder {
//        private PedidoModel pedidoModel;
//        private ProdutoModel produtoModel;
//        private int vlQuantidadeProduto;
//
//        public Builder setCdProduto(UUID cdProduto) {
//            this.cdProduto = cdProduto;
//            return this;
//        }
//
//        public Builder vlQuantidadeProduto(int vlQuantidadeProduto) {
//            this.vlQuantidadeProduto = vlQuantidadeProduto;
//            return this;
//        }
//
//        public ProdutoPedidoModel build() {
//            return new ProdutoPedidoModel(cdProduto, vlQuantidadeProduto);
//        }
//    }
}
