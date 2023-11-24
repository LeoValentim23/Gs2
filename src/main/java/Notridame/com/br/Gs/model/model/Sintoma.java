package Notridame.com.br.Gs.model.model;


import Notridame.com.br.Gs.model.model.TipoSintoma;

public class Sintoma {
    private TipoSintoma tipo;
    private int intensidade;



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
