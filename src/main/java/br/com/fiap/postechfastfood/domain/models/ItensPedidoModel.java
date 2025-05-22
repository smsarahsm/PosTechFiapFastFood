package br.com.fiap.postechfastfood.domain.models;

public class ItensPedidoModel {
    private ProdutoModel produto;
    private int vlQuantidade;

    public ItensPedidoModel() {
    }

    public ItensPedidoModel(ProdutoModel produto, int vlQuantidade) {
        this.produto = produto;
        this.vlQuantidade = vlQuantidade;
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
        private ProdutoModel produto;
        private int vlQuantidade;

        public Builder setCdProduto(ProdutoModel produto) {
            this.produto = produto;
            return this;
        }

        public Builder vlQuantidade(int vlQuantidade) {
            this.vlQuantidade = vlQuantidade;
            return this;
        }

        public ItensPedidoModel build() {
            return new ItensPedidoModel(produto, vlQuantidade);
        }
    }

    @Override
    public String toString() {
        return "ItensPedidoModel{" +
                "produto=" + produto +
                ", vlQuantidade=" + vlQuantidade +
                '}';
    }
}
