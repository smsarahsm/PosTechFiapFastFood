package br.com.fiap.postechfasfood.externals.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemMercadoPagoDTO {
    private String title;
    @JsonProperty("unit_price")
    private double unitPrice;
    private int quantity;
    @JsonProperty("unit_measure")
    private String unitMeasure;
    @JsonProperty("total_amount")
    private double totalAmount;


    public ItemMercadoPagoDTO(String title, double unitPrice, int quantity, String unitMeasure, double totalAmount) {
        this.title = title;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.unitMeasure = unitMeasure;
        this.totalAmount = totalAmount;
    }

    public ItemMercadoPagoDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", unitMeasure='" + unitMeasure + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
