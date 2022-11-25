package com.stack.competences;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Repository
public class EquipeRestRepository {

    private final RestTemplate restTemplate = new RestTemplate();

    public void addCompetenceToEquipe(Competence competences) {
        String url = "http://localhost:3000/api/equipes/"+competences.getEquipeId()+"/competences";
        System.out.println("url = " + url);
        restTemplate.put(
                url
                , competences, Void.class);
    }

    public void removeCompetenceToEquipe(Competence competences) {
        String url = "http://localhost:3000/api/equipes/"+competences.getEquipeId()+"/competences/"+competences.getId();
        restTemplate.delete(
                url
                , competences, Void.class);
    }


}
