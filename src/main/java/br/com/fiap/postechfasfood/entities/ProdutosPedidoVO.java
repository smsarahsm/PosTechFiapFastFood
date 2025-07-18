package br.com.fiap.postechfasfood.entities;

public class ProdutosPedidoVO {
    private PedidoVO pedido;
    private ProdutoVO produto;
    private int vlQuantidade;

    public ProdutosPedidoVO() {
    }

    public ProdutosPedidoVO(PedidoVO pedido, ProdutoVO produto, int vlQuantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.vlQuantidade = vlQuantidade;
    }

    public PedidoVO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoVO pedido) {
        this.pedido = pedido;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    public int getVlQuantidade() {
        return vlQuantidade;
    }

    public void setVlQuantidade(int vlQuantidade) {
        this.vlQuantidade = vlQuantidade;
    }

    public static class Builder {
        private PedidoVO pedido;
        private ProdutoVO produto;
        private int vlQuantidade;

        public Builder setPedido(PedidoVO pedido) {
            this.pedido = pedido;
            return this;
        }

        public Builder setProduto(ProdutoVO produto) {
            this.produto = produto;
            return this;
        }

        public Builder vlQuantidade(int vlQuantidade) {
            this.vlQuantidade = vlQuantidade;
            return this;
        }

        public ProdutosPedidoVO build() {
            return new ProdutosPedidoVO(pedido, produto, vlQuantidade);
        }
    }
}
