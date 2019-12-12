package com.example.android102intentofspinner;

public class Card {
    private String name;
    private int info;
    private int image;
    private int melody;

    public Card(String name, int info, int image, int melody) {
        this.name = name;
        this.info = info;
        this.image = image;
        this.melody = melody;
    }

    public String getName() {
        return name;
    }

    public int getInfo() {
        return info;
    }

    public int getImage() {
        return image;
    }

    public int getMelody() {
        return melody;
    }
}
