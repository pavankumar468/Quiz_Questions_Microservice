package com.telsuko.questionservice.controller;

import java.util.*;
import com.telsuko.questionservice.model.Question;
import com.telsuko.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping("Questions/addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("Questions/getAllQuestions")
    public  ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("Questions/getQuestionsByCategory")
    public ResponseEntity<List<Question>> getQuestionsByCategory(){
        return questionService.getQuestionsByCategory();
    }

}
