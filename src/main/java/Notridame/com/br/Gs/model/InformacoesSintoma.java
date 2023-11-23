package Notridame.com.br.Gs.model;

public class InformacoesSintoma {

    private TipoSintoma tipoSintoma;
    private int intensidadeSintoma;
    private Paciente paciente;

    public InformacoesSintoma(TipoSintoma tipoSintoma, int intensidadeSintoma) {
        this.tipoSintoma = tipoSintoma;
        this.intensidadeSintoma = intensidadeSintoma;
        this.paciente = paciente;
    }

    public TipoSintoma getTipoSintoma() {
        return tipoSintoma;
    }

    public int getIntensidadeSintoma() {
        return intensidadeSintoma;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
