package com.enums;

public enum HairColor {
    GREEN,
    BLACK,
    PINK,
    YELLOW,
    ORANGE,
    WHITE;

    public static HairColor getRandomHairColor() {
        switch ((int) Math.floor(Math.random() * 6f)) {
            case 0:
                return GREEN;
            case 1:
                return BLACK;
            case 2:
                return PINK;
            case 3:
                return YELLOW;
            case 4:
                return ORANGE;
            default:
                return WHITE;
        }
    }
}
