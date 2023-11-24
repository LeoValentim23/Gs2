package Notridame.com.br.Gs.model.Historico;

public class HistoricoSintomas {
    private String cpfPaciente;
    private int idUrgencia;
    private String nomeUrgencia;
    private String tipoSintoma;
    private String intensidadeSintoma;

    // Construtor, getters e setters

    public HistoricoSintomas(String cpfPaciente, int idUrgencia, String nomeUrgencia, String tipoSintoma, String intensidadeSintoma) {
        this.cpfPaciente = cpfPaciente;
        this.idUrgencia = idUrgencia;
        this.nomeUrgencia = nomeUrgencia;
        this.tipoSintoma = tipoSintoma;
        this.intensidadeSintoma = intensidadeSintoma;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public int getIdUrgencia() {
        return idUrgencia;
    }

    public void setIdUrgencia(int idUrgencia) {
        this.idUrgencia = idUrgencia;
    }

    public String getNomeUrgencia() {
        return nomeUrgencia;
    }

    public void setNomeUrgencia(String nomeUrgencia) {
        this.nomeUrgencia = nomeUrgencia;
    }

    public String getTipoSintoma() {
        return tipoSintoma;
    }

    public void setTipoSintoma(String tipoSintoma) {
        this.tipoSintoma = tipoSintoma;
    }

    public String getIntensidadeSintoma() {
        return intensidadeSintoma;
    }

    public void setIntensidadeSintoma(String intensidadeSintoma) {
        this.intensidadeSintoma = intensidadeSintoma;
    }
}
