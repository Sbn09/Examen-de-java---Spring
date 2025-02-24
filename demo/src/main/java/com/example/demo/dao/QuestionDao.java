package com.example.demo.dao;

import com.example.demo.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {


}
