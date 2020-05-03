package com.wrappers;

public class Coordinates {
    public Coordinates(Long x, float y) {
        this.x = x;
        this.y = y;
    }

    private Long x;
    private float y;

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}

