package br.com.fiap.postechfasfood.entities;

public class ItensPedidoVO {
    private ProdutoVO produto;
    private int vlQuantidade;

    public ItensPedidoVO() {
    }

    public ItensPedidoVO(ProdutoVO produto, int vlQuantidade) {
        this.produto = produto;
        this.vlQuantidade = vlQuantidade;
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
        private ProdutoVO produto;
        private int vlQuantidade;

        public Builder setCdProduto(ProdutoVO produto) {
            this.produto = produto;
            return this;
        }

        public Builder vlQuantidade(int vlQuantidade) {
            this.vlQuantidade = vlQuantidade;
            return this;
        }

        public ItensPedidoVO build() {
            return new ItensPedidoVO(produto, vlQuantidade);
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
