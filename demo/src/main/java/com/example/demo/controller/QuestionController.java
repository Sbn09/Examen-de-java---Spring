package com.example.demo.controller;

import com.example.demo.dao.QuestionDao;
import com.example.demo.models.Question;
import com.example.demo.security.IsAdmin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionDao questionDao;


    @IsAdmin
    @PostMapping("")
    public ResponseEntity<Question> add(@RequestBody @Valid Question question) {
        question.setId(null);
        questionDao.save(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }
}
