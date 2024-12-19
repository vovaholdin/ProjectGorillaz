package com.javarush.khmelov.questions.laptop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Option {
    private String text;
    private Integer nextStep;
    private String result;
    private Boolean restart;
    private Boolean end;
}
