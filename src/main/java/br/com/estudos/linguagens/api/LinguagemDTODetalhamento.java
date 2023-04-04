package br.com.estudos.linguagens.api;

public record LinguagemDTODetalhamento(String id, String title, String image, int ranking) {
    public LinguagemDTODetalhamento(Linguagem linguagem) {
        this(linguagem.getId(), linguagem.getTitle(), linguagem.getImage(), linguagem.getRanking());
    }
}
