package br.com.estudos.linguagens.api;

public record LinguagemDTOAtualizacao(String id, String title, String image, int ranking) {
    public LinguagemDTOAtualizacao(Linguagem linguagem) {
        this(linguagem.getId(), linguagem.getTitle(), linguagem.getImage(), linguagem.getRanking());
    }
}
