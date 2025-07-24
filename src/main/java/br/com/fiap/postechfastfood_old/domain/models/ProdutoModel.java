package br.com.fiap.postechfastfood_old.domain.models;

import br.com.fiap.postechfastfood_old.domain.enums.TipoCategoriaProdutoEnum;

import java.util.UUID;

public class ProdutoModel {

    private UUID cdProduto;
    private String nmProduto;
    private String dsDescricao;
    private double vlPreco;
    private boolean snAtivo;
    private TipoCategoriaProdutoEnum tpCategoria;

    public ProdutoModel() {
    }

    public ProdutoModel(UUID cdProduto, String nmProduto, String dsDescricao, double vlPreco, boolean snAtivo,
                        TipoCategoriaProdutoEnum tpCategoria) {
        this.cdProduto = cdProduto;
        this.nmProduto = nmProduto;
        this.dsDescricao = dsDescricao;
        this.vlPreco = vlPreco;
        this.snAtivo = snAtivo;
        this.tpCategoria = tpCategoria;
    }

    public UUID getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(UUID cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getNmProduto() {
        return nmProduto;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public double getVlPreco() {
        return vlPreco;
    }

    public void setVlPreco(double vlPreco) {
        this.vlPreco = vlPreco;
    }

    public void setSnAtivo(boolean snAtivo) {
        this.snAtivo = snAtivo;
    }

    public boolean getSnAtivo() {
        return snAtivo;
    }

    public TipoCategoriaProdutoEnum getTpCategoria() {
        return tpCategoria;
    }

    public void setTpCategoria(TipoCategoriaProdutoEnum tpCategoria) {
        this.tpCategoria = tpCategoria;
    }

    public static class Builder {
        private UUID cdProduto;
        private String nmProduto;
        private String dsDescricao;
        private double vlPreco;
        private boolean snAtivo;
        private TipoCategoriaProdutoEnum tpCategoria;

        public Builder setCdProduto(UUID cdProduto) {
            this.cdProduto = cdProduto;
            return this;
        }

        public Builder setNmProduto(String nmProduto) {
            this.nmProduto = nmProduto;
            return this;
        }

        public Builder setDsDescricao(String dsDescricao) {
            this.dsDescricao = dsDescricao;
            return this;
        }

        public Builder setVlPreco(double vlPreco) {
            this.vlPreco = vlPreco;
            return this;
        }

        public Builder setSnAtivo(boolean snAtivo) {
            this.snAtivo = snAtivo;
            return this;
        }

        public Builder setTpCategoria(TipoCategoriaProdutoEnum tpCategoria) {
            this.tpCategoria = tpCategoria;
            return this;
        }

        public ProdutoModel build() {return new ProdutoModel(cdProduto, nmProduto, dsDescricao, vlPreco, snAtivo, tpCategoria);}
    }

    @Override
    public String toString() {
        return "ProdutoModel{" +
                "cdProduto=" + cdProduto +
                ", nmProduto='" + nmProduto + '\'' +
                ", dsDescricao='" + dsDescricao + '\'' +
                ", vlPreco=" + vlPreco +
                ", snAtivo=" + snAtivo +
                ", tpCategoria=" + tpCategoria +
                '}';
    }
}
