package com.javarush.khmelov.questions.laptop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Option {
    private String text;
    private Integer nextStep;
    private String result;
    private Boolean restart;
    private Boolean end;
}
