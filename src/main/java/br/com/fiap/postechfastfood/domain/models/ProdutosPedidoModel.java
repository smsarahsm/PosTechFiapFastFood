package br.com.fiap.postechfastfood.domain.models;

import br.com.fiap.postechfastfood.domain.enums.TipoCategoriaProdutoEnum;

import java.util.List;
import java.util.UUID;

//TODO Não Utilizar
public class ProdutosPedidoModel {
    private PedidoModel pedido;
    private ProdutoModel produto;
    private int vlQuantidade;

    public ProdutosPedidoModel() {
    }

    public ProdutosPedidoModel(PedidoModel pedido, ProdutoModel produto, int vlQuantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.vlQuantidade = vlQuantidade;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public int getVlQuantidade() {
        return vlQuantidade;
    }

    public void setVlQuantidade(int vlQuantidade) {
        this.vlQuantidade = vlQuantidade;
    }

    public static class Builder {
        private PedidoModel pedido;
        private ProdutoModel produto;
        private int vlQuantidade;

        public Builder setPedido(PedidoModel pedido) {
            this.pedido = pedido;
            return this;
        }

        public Builder setProduto(ProdutoModel produto) {
            this.produto = produto;
            return this;
        }

        public Builder vlQuantidade(int vlQuantidade) {
            this.vlQuantidade = vlQuantidade;
            return this;
        }

        public ProdutosPedidoModel build() {
            return new ProdutosPedidoModel(pedido, produto, vlQuantidade);
        }
    }
}
