package Notridame.com.br.Gs.model.model;

public enum TipoSintoma {
    DOR_DE_CABECA(1),
    FEBRE(2),
    PRESSAO_ALTA(3),
    NAUSEAS(2),
    TOSSE(1),
    FADIGA(1),
    DOR_ABDOMINAL(2),
    DOR_ARTICULACOES(2),
    DIFICULDADE_RESPIRATORIA(3),
    INSONIA(1),
    OUTRO(1);

    private final int pontuacao;

    TipoSintoma(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPontuacao(int intensidade) {
        return pontuacao * intensidade;
    }
}
