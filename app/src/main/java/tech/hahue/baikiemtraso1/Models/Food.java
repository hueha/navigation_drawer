package tech.hahue.baikiemtraso1.Models;

import tech.hahue.baikiemtraso1.R;

public class Food {
    private String name;
    private int price;
    private int images;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
        this.images = R.drawable.food_demo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
