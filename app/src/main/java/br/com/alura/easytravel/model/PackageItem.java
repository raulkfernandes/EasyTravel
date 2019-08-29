package br.com.alura.easytravel.model;

import java.math.BigDecimal;

public class PackageItem {
    private final String image;
    private final String destination;
    private final int stay;
    private final BigDecimal price;

    public PackageItem(String image, String destination, int stay, BigDecimal price) {
        this.image = image;
        this.destination = destination;
        this.stay = stay;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public String getImage() {
        return image;
    }

    public int getStay() {
        return stay;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
