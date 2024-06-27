package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")


public class Quizz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    protected Integer id;

    @NotBlank
    @NotNull
    @Length(min = 3, max = 50)
    @Column( length = 50)
    protected String nom;

    @Min(1)
    @Max(50)
    protected int niveau;

    @ManyToOne(optional = false)
    protected Utilisateur createur;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "categorie_quizz",
            joinColumns = @JoinColumn(name = "quizz_id"),
            inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    protected List<Categorie> listeCategorie;

//    @ManyToMany
//    @JoinTable(name = "question_quizz",
//            joinColumns = @JoinColumn(name = "quizz_id"),
//            inverseJoinColumns = @JoinColumn(name = "question_id"))
//    protected List<Question> listeQuestion;


}
