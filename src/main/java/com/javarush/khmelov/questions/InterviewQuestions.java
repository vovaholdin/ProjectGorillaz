package com.javarush.khmelov.questions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterviewQuestions {
    private int id;
    private String question;
    private String correctAnswer;
    private String wrongAnswer;
}
