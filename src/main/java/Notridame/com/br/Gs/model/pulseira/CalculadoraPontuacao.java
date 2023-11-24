package Notridame.com.br.Gs.model.pulseira;

import Notridame.com.br.Gs.model.model.TipoSintoma;

public class CalculadoraPontuacao {

    public static int calcularPontuacaoTotal(int idade, TipoSintoma tipoSintoma, int intensidadeSintoma) {
        int pontuacaoIdade = calcularPontuacaoIdade(idade);
        int pontuacaoSintomas = calcularPontuacaoSintomas(tipoSintoma, intensidadeSintoma);

        return pontuacaoIdade + pontuacaoSintomas;
    }

    private static int calcularPontuacaoIdade(int idade) {
        if (idade > 60 || idade < 10) {
            return 3;
        }
        return 0;
    }

    private static int calcularPontuacaoSintomas(TipoSintoma tipoSintoma, int intensidadeSintoma) {
        int pontuacao = 0;

        switch (tipoSintoma) {
            case DOR_DE_CABECA:
                pontuacao += 1;
                break;
            case FEBRE:
                pontuacao += 2;
                break;
            case PRESSAO_ALTA:
                pontuacao += 3;
                break;
            case NAUSEAS:
                pontuacao += 2;
                break;
            case TOSSE:
                pontuacao += 1;
                break;
            case FADIGA:
                pontuacao += 1;
                break;
            case DOR_ABDOMINAL:
                pontuacao += 2;
                break;
            case DOR_ARTICULACOES:
                pontuacao += 2;
                break;
            case DIFICULDADE_RESPIRATORIA:
                pontuacao += 3;
                break;
            case INSONIA:
                pontuacao += 1;
                break;
            case OUTRO:
                pontuacao += 1;
                break;
        }

        if (intensidadeSintoma >= 3 && intensidadeSintoma <= 7) {
            pontuacao += 1;
        } else if (intensidadeSintoma > 7) {
            pontuacao += 2;
        }

        return pontuacao;
    }
}