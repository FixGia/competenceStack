package com.stack.competences;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
@Slf4j
public class CompetenceServiceImpl implements CompetenceService{

    private final CompetenceRepo competenceRepo;
    private final EquipeRestRepository equipeRestRepository;

    public CompetenceServiceImpl(CompetenceRepo competenceRepo, EquipeRestRepository equipeRestRepository) {
        this.competenceRepo = competenceRepo;
        this.equipeRestRepository = equipeRestRepository;
    }

    @Override
    public Competence recupererCompetence(String id) {
        return competenceRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public Competence creerCompetence(Competence competence) {

       var newCompetence = competenceRepo.save(competence);

        equipeRestRepository.addCompetenceToEquipe(newCompetence);
        return newCompetence;

    }

    public void ajouterCompetenceAEquipe(String id) {

        Optional<Competence> competence = competenceRepo.findById(id);
        equipeRestRepository.addCompetenceToEquipe(competence.get());

    }

    public void retirerCompetenceAEquipe(Competence competence){

        competenceRepo.findById(competence.getId());
        equipeRestRepository.removeCompetenceToEquipe(competence);
    }

    @Override
    public Iterable<Competence> recupererToutesCompetence() {

      return competenceRepo.findAll();

    }

    @Override
    public void supprimerCompetence(String id) {
        competenceRepo.deleteById(id);
    }

    @Override
    public void updateCompetence(String id, Competence competence) {
        Optional<Competence> competenceToUpdate = competenceRepo.findById(id);

        if(competenceToUpdate.isPresent()) {

            competenceToUpdate.get().setNom(competence.getNom());
            competenceToUpdate.get().setDescription(competence.getDescription());
            competenceToUpdate.get().setEquipeId(competence.getEquipeId());

            log.info("Service : update Competence{} - OK", competenceToUpdate.get().getNom());
        }
        else log.error("Service : update Competence{} - FAIL", competenceRepo.findById(id).get().getNom());

    }

}

