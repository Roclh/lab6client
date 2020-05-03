package com.wrappers;

import com.enums.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *  Класс, хранящий в себе параметры объекта типа Person
 *  Для создания уникального id используется hashCode()
 */

public class Person implements Comparable<Person>, Serializable {
    private long id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Float height;
    private EyeColor eyeColor;
    private HairColor hairColor;
    private Country nationality;
    private Location location;

    public Person() {
        this.name = "Test";
        this.id = this.hashCode();
        this.creationDate = LocalDateTime.now();
        this.coordinates = new Coordinates((long) 1, 1);
        this.height = 1f;
        this.eyeColor = EyeColor.BLUE;
        this.hairColor = HairColor.BLACK;
        this.nationality = Country.INDIA;
        this.location = new Location(1, 1f, 1f);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Float getHeight() {
        return height;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "APerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }

    /**Так как класс Person является элементом коллекции PriorityQueue, то он обязан имплементировать интерфейс Comparable
     *
     */
    @Override
    public int compareTo(Person p) {
        if (this.getId() > p.getId()) return 1;
        else if (this.getId() == p.getId()) return 0;
        else return -1;
    }


}
