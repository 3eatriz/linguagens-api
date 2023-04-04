package br.com.estudos.linguagens.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinguagemService {
    @Autowired
    private LinguagemRepository repository;

    public Linguagem findById(String id){
        Optional<Linguagem> opt = repository.findById(id);
        return opt.orElseThrow();
    }
}
