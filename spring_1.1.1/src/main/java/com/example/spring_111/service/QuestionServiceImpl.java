package com.example.spring_111.service;

import com.example.spring_111.dao.QuestionDao;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static com.example.spring_111.util.QuestionWithAnswersUtil.getQuestionWithAnswersFromLine;

@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private QuestionDao questionDao;

    private String questionPath;

    public void addQuestions() throws IOException, URISyntaxException {
        var uri = Objects.requireNonNull(getClass().getResource(questionPath)).toURI();
        Files.readAllLines(Paths.get(uri)).forEach(line -> questionDao.addQuestion(getQuestionWithAnswersFromLine(line)));
    }

    @Override
    public void printAllQuestionsWithAnswers(PrintStream printStream) {
        questionDao.getAllQuestions()
                .forEach(printStream::println);
    }
}
