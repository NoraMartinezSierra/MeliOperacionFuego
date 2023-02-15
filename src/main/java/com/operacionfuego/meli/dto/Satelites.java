package com.operacionfuego.meli.dto;

import java.util.List;

public class Satelites {

    private String name;
    private Double distance;
    private List<String> message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Satelites{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", message=" + message +
                '}';
    }
}
