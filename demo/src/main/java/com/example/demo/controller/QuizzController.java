package com.example.demo.controller;

import com.example.demo.dao.QuizzDao;
import com.example.demo.models.Quizz;
import com.example.demo.security.AppUserDetails;
import com.example.demo.security.IsAdmin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/quizz")
public class QuizzController {

    @Autowired
    QuizzDao QuizzDao;

    @GetMapping("/liste")
    public List<Quizz> getAllQuizz() {
        return QuizzDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quizz> get(@PathVariable int id){
        Optional<Quizz> optionalQuizz = QuizzDao.findById(id);
        if(optionalQuizz.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalQuizz.get(), HttpStatus.OK);
    }

    @IsAdmin
    @PostMapping("")
    public ResponseEntity<Quizz> add(@RequestBody @Valid Quizz quizz, @AuthenticationPrincipal AppUserDetails userDetails ) {
        quizz.setId(null);
        quizz.setCreateur(userDetails.getUtilisateur());
        QuizzDao.save(quizz);

        //quizz.setCreateur(null);
        return new ResponseEntity<>(quizz, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quizz> update(
        @PathVariable int id,
        @RequestBody @Valid Quizz quizz) {
        quizz.setId(id);

        Optional<Quizz> optionalQuizz = QuizzDao.findById(id);

        if(optionalQuizz.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        QuizzDao.save(quizz);
        return new ResponseEntity<>(quizz, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Quizz> delete(@PathVariable int id) {
        Optional<Quizz> optionalQuizz = QuizzDao.findById(id);

        if(optionalQuizz.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        QuizzDao.deleteById(id);
        return new ResponseEntity<>(optionalQuizz.get(), HttpStatus.OK);
    }

}