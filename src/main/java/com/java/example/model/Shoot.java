package com.java.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString()
public class Shoot {

    private int matchId;
    private int distance;
    private Player player;

}
