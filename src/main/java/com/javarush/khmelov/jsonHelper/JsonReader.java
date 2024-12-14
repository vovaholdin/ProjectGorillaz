package com.javarush.khmelov.jsonHelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.khmelov.questions.InterviewQuestions;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonReader {
    public List<InterviewQuestions> readQuestionsFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Получаем поток данных из resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.json");
        if (inputStream == null) {
            throw new IOException("File not found!");
        }

        // Преобразуем JSON непосредственно в List<Question>
        List<InterviewQuestions> questions = mapper.readValue(inputStream,
                mapper.getTypeFactory().constructCollectionType(List.class, InterviewQuestions.class));
        return questions;
    }
}
