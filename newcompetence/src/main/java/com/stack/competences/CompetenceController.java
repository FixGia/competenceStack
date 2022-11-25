package com.stack.competences;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {


    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @GetMapping("/all")
    public void getAllCompetence() {

         competenceService.recupererToutesCompetence();
    }

    @PostMapping("")
    public Competence createCompetence(@RequestBody Competence competence) {
        return competenceService.creerCompetence(competence);
    }

    @GetMapping("/{id}")
    public Competence getCompetence(@PathVariable String id) {
        return competenceService.recupererCompetence(id);
    }

    @PutMapping("")
    public void updateCompetence(@RequestBody Competence competence) {
        competenceService.updateCompetence(competence.getId(),competence);

    }

    @PostMapping("/ajouterCompetence/{id}")
    public void AddCompetenceToEquipe(@PathVariable String id) {

        competenceService.ajouterCompetenceAEquipe(id);
    }

    @PostMapping("supprimerCompetence")
    public void SupprimerCompetenceToEquipe(@RequestBody Competence competence){
        competenceService.retirerCompetenceAEquipe(competence);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetence(@PathVariable String id) {
        competenceService.supprimerCompetence(id);
    }

}