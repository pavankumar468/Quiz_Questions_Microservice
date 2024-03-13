package com.telsuko.questionservice.service;

import com.telsuko.questionservice.dao.QuestionRepo;
import com.telsuko.questionservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionrepo;
    public ResponseEntity<Question> addQuestion(Question question) {

        return new ResponseEntity<>(questionrepo.save(question), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getAllQuestions() {

        try{
            return new ResponseEntity<>(questionrepo.findAll(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(null),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory() {
        try{
            return new ResponseEntity<>(questionrepo.findByCategory(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList(null),HttpStatus.BAD_REQUEST);
    }
}
