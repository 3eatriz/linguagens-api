package br.com.estudos.linguagens.api;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinguagemRepository extends MongoRepository<Linguagem, String>{    
    Optional<Linguagem> findById(String id);

    List<Linguagem> findAllByOrderByRankingAsc();
}
