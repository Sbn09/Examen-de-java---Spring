package com.example.demo.controller;

import com.example.demo.dao.ReponseUtilisateurDao;
import com.example.demo.models.ReponsePossible;
import com.example.demo.models.ReponseUtilisateur;
import com.example.demo.security.AppUserDetails;
import com.example.demo.security.IsUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reponse-utilisateur")
public class ReponseUtilisateurController {

    @Autowired
    ReponseUtilisateurDao reponseUtilisateurDao;

    @GetMapping("/liste")
    public List<ReponseUtilisateur> getAllReponseUtilisateur() {
        return reponseUtilisateurDao.findAll();
    }

    @IsUser
    @PostMapping("")
    public ResponseEntity<ReponseUtilisateur> add(@RequestBody @Valid ReponseUtilisateur reponseUtilisateur, @AuthenticationPrincipal AppUserDetails userDetails ) {
        reponseUtilisateur.setId(null);
        reponseUtilisateurDao.save(reponseUtilisateur);
        return new ResponseEntity<>(reponseUtilisateur, HttpStatus.CREATED);
    }
}
