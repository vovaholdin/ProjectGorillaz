package com.javarush.khmelov.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StatisticUser {
    private int score;
    private int lose;
    private int win;
}
