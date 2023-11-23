package Notridame.com.br.Gs.model;


public class Sintoma {
    private TipoSintoma tipo;
    private int intensidade;

    private int Idade;


    public Sintoma(TipoSintoma tipo, int intensidade) {
        this.tipo = tipo;
        this.intensidade = intensidade;
    }

    public TipoSintoma getTipo() {
        return tipo;
    }

    public int getIntensidade() {
        return intensidade;
    }
}
