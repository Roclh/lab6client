package com.enums;

public enum EyeColor {
    RED,
    BLUE,
    YELLOW;

    public static EyeColor getRandomEyeColor(){
        switch((int)Math.floor(Math.random()*3f)){
            case 0:
                return RED;
            case 1:
                return BLUE;
            default:
                return YELLOW;

        }
    }
}

