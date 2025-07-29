package br.com.fiap.postechfasfood.externals.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MercadoPagoExternalApiRequestDTO {
    @JsonProperty("external_reference")
    private String externalReference;
    private String title;
    private String description;
    @JsonProperty("notification_url")
    private String notificationUrl;
    @JsonProperty("total_amount")
    private int totalAmount;
    private List<ItemMercadoPagoDTO> items;

    public MercadoPagoExternalApiRequestDTO(String externalReference,
                                            String title,
                                            String description,
                                            String notificationUrl,
                                            int totalAmount,
                                            List<ItemMercadoPagoDTO> items
                                            ) {
        this.externalReference = externalReference;
        this.title = title;
        this.description = description;
        this.notificationUrl = notificationUrl;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public MercadoPagoExternalApiRequestDTO() {
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

    public List<ItemMercadoPagoDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemMercadoPagoDTO> items) {
        this.items = items;
    }
}
