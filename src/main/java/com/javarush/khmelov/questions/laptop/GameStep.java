package com.javarush.khmelov.questions.laptop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameStep {
    private int id;
    private String question;
    private List<Option> options;
}
