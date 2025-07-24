package br.com.fiap.postechfasfood.entities;

import java.util.List;

public class PagamentoVO {
    private String externalReference;
    private String title;
    private String description;
    private String notificationUrl;
    private int totalAmount;
    private List<ItensPedidoVO> items;
    private String qrCode;

    public PagamentoVO(String externalReference, String title, String description, String notificationUrl, int totalAmount) {
        this.externalReference = externalReference;
        this.title = title;
        this.description = description;
        this.notificationUrl = notificationUrl;
        this.totalAmount = totalAmount;
    }

    public PagamentoVO() {
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ItensPedidoVO> getItems() {
        return items;
    }

    public void setItems(List<ItensPedidoVO> items) {
        this.items = items;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
