package com.example.spring_111;

import com.example.spring_111.service.QuestionService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, URISyntaxException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
		QuestionService service = context.getBean(QuestionService.class);
		service.addQuestions();
		service.printAllQuestionsWithAnswers(System.out);
	}

}
