package com.example.spring_111.service;

import com.example.spring_111.dao.QuestionDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.List;

import static com.example.spring_111.util.QuestionWithAnswersUtil.getQuestionWithAnswersFromLine;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private QuestionDao questionDao;

    @InjectMocks
    private QuestionServiceImpl sut = new QuestionServiceImpl(questionDao, "/example.csv");

    @Test
    void shouldAddQuestionsFromFile() throws IOException, URISyntaxException {
        //when
        sut.addQuestions();

        //then
        verify(questionDao, times(3)).addQuestion(any());
    }

    @Test
    void shouldPrintAllQuestions() {
        //given
        var question = getQuestionWithAnswersFromLine("question,answer");
        when(questionDao.getAllQuestions()).thenReturn(List.of(question));
        var printStream = mock(PrintStream.class);

        //when
        sut.printAllQuestionsWithAnswers(printStream);

        //then
        verify(questionDao, times(1)).getAllQuestions();
        verify(printStream, times(1)).println(question);
    }
}