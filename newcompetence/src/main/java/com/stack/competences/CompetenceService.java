package com.stack.competences;


public interface CompetenceService {

  Competence recupererCompetence(String id);

  Competence creerCompetence(Competence competence);

  Iterable<Competence> recupererToutesCompetence();

  void supprimerCompetence(String id);

  void updateCompetence(String id, Competence competence);

  void ajouterCompetenceAEquipe(String id);

  void retirerCompetenceAEquipe(Competence competence);

}
