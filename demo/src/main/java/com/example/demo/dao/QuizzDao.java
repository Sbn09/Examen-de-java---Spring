package com.example.demo.dao;

import com.example.demo.models.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizzDao extends JpaRepository<Quizz, Integer> {

}
