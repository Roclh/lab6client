package com.enums;

/**
 * Класс перечисление, который содержит в себе возможные страны
 *
 *
 * */


public enum Country {
    INDIA,
    VATICAN,
    NORTH_AMERICA,
    JAPAN;

    public static Country getRandomCountry(){
        switch((int)Math.floor(Math.random()*4f)){
            case 0:
                return INDIA;
            case 1:
                return VATICAN;
            case 2:
                return NORTH_AMERICA;
            default:
                return JAPAN;

        }
    }

}

