package com.exceptions;

public class SavePeopleException extends Exception {
    private String mes = "В файле сохранения нету такого id";

    @Override
    public String getMessage() {
        return mes;
    }
}
