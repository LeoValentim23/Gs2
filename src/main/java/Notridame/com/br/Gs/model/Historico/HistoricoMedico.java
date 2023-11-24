package Notridame.com.br.Gs.model.Historico;

public class HistoricoMedico {

    private String nomeAlergia;
    private String nomeMedicamento;
    private String doencaFamilia;


    public HistoricoMedico(String nomeAlergia, String nomeMedicamento, String doencaFamilia ) {
        this.nomeAlergia = nomeAlergia;
        this.nomeMedicamento = nomeMedicamento;
        this.doencaFamilia = doencaFamilia;


    }


    public String getNomeAlergia() {
        return nomeAlergia;
    }



    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public String getDoencaFamilia() {
        return doencaFamilia;
    }




}


