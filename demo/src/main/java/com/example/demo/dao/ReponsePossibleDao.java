package com.example.demo.dao;


import com.example.demo.models.ReponsePossible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReponsePossibleDao extends JpaRepository<ReponsePossible, Integer> {
}
