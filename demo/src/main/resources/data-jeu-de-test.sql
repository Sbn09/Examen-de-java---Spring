INSERT INTO utilisateur (email, password, administrateur) VALUES
("a@a.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 0) ,
("b@b.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 1 ) ,
("c@c.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 0 );

INSERT INTO quizz (nom, niveau, createur_id) VALUES
("pokemon", 1, 1) ,
("manga", 3, 1) ,
("serie 90", 4, 2);

INSERT INTO categorie (nom) VALUES
("Culture G"),
("Culture geek"),
("Geographie"),
("Japon"),
("Serie");

INSERT INTO categorie_quizz (quizz_id, categorie_id) VALUES
(1, 2),
(1, 4),
(1, 5),
(2, 2),
(1, 2);

-- INSERT INTO question (nom) VALUES
-- ("Quel est la première lettre de l'alphabet ?"),
-- ("Pourquoi Noémie s'appelle-t-elle Noémie ?"),
-- ("Pourquoi le ciel est bleu ?"),
-- ("Pourquoi l'eau ça mouille ?");

INSERT INTO question (nom, quizz_id) VALUES
("Quel est la première lettre de l'alphabet ?", 1),
("Pourquoi Noémie s'appelle-t-elle Noémie ?", 1),
("Pourquoi le ciel est bleu ?", 2),
("Pourquoi l'eau ça mouille ?", 3);

-- INSERT INTO question_quizz (quizz_id, question_id) VALUES
-- (1, 2),
-- (1, 4),
-- (3, 1),
-- (2, 2),
-- (2, 3);

INSERT INTO reponse_possible (texte, vrai_faux, question_id) VALUES
("A", 1, 1),
("B", 0, 1),
("C", 0, 1),

("Parce que ses parents ont choisi", 0, 2),
("Parce que c'était beau", 0, 2),
("Parce que c'était le prénom de la grand-mère", 1, 2),

("Parce que", 0, 3),
("Parce que c'est on voit bien le bleu", 1, 3),

("Parce que c'est de l'eau", 1, 4),
("Parce que c'est mouillé", 0, 4);


INSERT INTO reponse_utilisateur (reponse_possible_id, utilisateur_id) VALUES
(1, 1),
(2 ,1),
(3, 2),
(4, 1),
(5, 2);