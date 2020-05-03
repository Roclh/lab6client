package com.wrappers;

public class Location {
    public Location(Integer x, Float y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private Integer x;
    private Float y;
    private Float z;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getZ() {
        return z;
    }

    public void setZ(Float z) {
        this.z = z;
    }
}
