package com.example.spring_111.service;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

public interface QuestionService {

    void addQuestions() throws IOException, URISyntaxException;

    void printAllQuestionsWithAnswers(PrintStream printStream);
}
