package com.stack.competences;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepo extends MongoRepository<Competence, String> {
}
