package br.com.estudos.linguagens.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

    @Autowired
    private LinguagemRepository repository;

    @Autowired
    private LinguagemService service;
    
    @GetMapping
    public ResponseEntity<List<Linguagem>> obterLinguagens(){
        List<Linguagem> linguagens = repository.findAllByOrderByRankingAsc();
        return ResponseEntity.ok(linguagens);
    }

    @PostMapping
    public ResponseEntity<LinguagemDTODetalhamento> cadastrarLinguagens(@RequestBody LinguagemDTOCadastro dto, UriComponentsBuilder uriBuilder){
        var linguagem = new Linguagem(dto);
        repository.save(linguagem);

        var uri = uriBuilder.path("/linguagens/{id}").buildAndExpand(linguagem.getId()).toUri();

        return ResponseEntity.created(uri).body(new LinguagemDTODetalhamento(linguagem));
    }

    @PutMapping
    public ResponseEntity<LinguagemDTOAtualizacao> atualizarLinguagem(@RequestBody LinguagemDTOAtualizacao dto){
        Linguagem linguagem = service.findById(dto.id());

        linguagem.atualizarInformacoes(dto);
        repository.save(linguagem);

        return ResponseEntity.ok(new LinguagemDTOAtualizacao(linguagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLinguagem(@PathVariable String id){
        var linguagem = service.findById(id);
        repository.delete(linguagem);

        return ResponseEntity.noContent().build();
    }
}
