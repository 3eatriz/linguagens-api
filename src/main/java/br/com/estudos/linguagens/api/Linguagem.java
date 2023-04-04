package br.com.estudos.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pricipaisLinguagens")
public class Linguagem {
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;
    
    public Linguagem(){}

    public Linguagem(LinguagemDTOCadastro dto){
        this.title = dto.title();
        this.image = dto.image();
        this.ranking = dto.ranking();
    }
    
    public Linguagem(LinguagemDTOAtualizacao dto){
        this.title = dto.title();
        this.image = dto.image();
        this.ranking = dto.ranking();
    }

    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRanking() {
        return ranking;
    }

    public String getId() {
        return id;
    }

    

    public void setId(String id) {
        this.id = id;
    }

    public void atualizarInformacoes(LinguagemDTOAtualizacao dto) {
        if(dto.title() != null){
            this.title = dto.title();
        }
        
        if(dto.image() != null){
            this.image = dto.image();
        }

        if(dto.ranking() != 0){
            this.ranking = dto.ranking();
        }
    }
}