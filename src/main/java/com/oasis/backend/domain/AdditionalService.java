package com.oasis.backend.domain;

public class AdditionalService {
    private int additionalServiceId;
    private String description;
    private int price;

    public int getAdditionalServiceId() {
        return additionalServiceId;
    }

    public void setAdditionalServiceId(int additionalServiceId) {
        this.additionalServiceId = additionalServiceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
