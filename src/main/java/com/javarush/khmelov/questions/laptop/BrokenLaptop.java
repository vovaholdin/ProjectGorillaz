package com.javarush.khmelov.questions.laptop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrokenLaptop {
    private int id;
    private String question;
    private String correctAnswer;
    private String wrongAnswer;
}
