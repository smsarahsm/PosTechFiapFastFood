package br.com.fiap.postechfastfood.domain.models;


public class ComandaModel {

    private String cdPedido;
    private String stPedido;    

    public ComandaModel() {}

    public ComandaModel(String cdPedido, String stPedido) {
        this.cdPedido = cdPedido;
        this.stPedido = stPedido;
    }
    public String getCdPedido() {
        return cdPedido;
    }

    public ComandaModel setCdPedido(String cdPedido) {
        this.cdPedido = cdPedido;
        return this;
    }

    public String getStPedido() {
        return stPedido;
    }

    public ComandaModel setStPedido(String stPedido) {
        this.stPedido = stPedido;
        return this;
    }

    public static class Builder {
        private String cdPedido;
        private String stPedido;

        public Builder setCdPedido(String cdPedido) {
            this.cdPedido = cdPedido;
            return this;
        }

        public Builder setStPedido(String stPedido) {
            this.stPedido = stPedido;
            return this;
        }

        public ComandaModel build() {
            return new ComandaModel(cdPedido, stPedido);
        }
    }
}
