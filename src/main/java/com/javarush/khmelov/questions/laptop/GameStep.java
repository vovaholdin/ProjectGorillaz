package com.javarush.khmelov.questions.laptop;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameStep {
    private int id;
    private String question;
    private List<Option> options;
}
