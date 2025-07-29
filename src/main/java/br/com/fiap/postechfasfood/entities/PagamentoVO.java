package br.com.fiap.postechfasfood.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PagamentoVO {
    @JsonProperty("qr_data")
    private String qrData;

    public PagamentoVO(String qrData) {
        this.qrData = qrData;
    }

    public PagamentoVO() {
    }

    public String getQrData() {
        return qrData;
    }

    public void setQrData(String qrData) {
        this.qrData = qrData;
    }

    public static class Builder {
        private String qrData;

        public Builder setQrData(String qrData){
            this.qrData = qrData;
            return this;
        }

        public PagamentoVO build() {
            return new PagamentoVO(qrData);
        }
    }
}
