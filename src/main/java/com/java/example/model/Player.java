package com.java.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"shoots"})
public class Player {

    private String name;
    private List<Shoot> shoots;

    public Player(String name) {
        this.name = name;
        this.shoots = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

}
