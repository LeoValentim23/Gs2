package Notridame.com.br.Gs.DAO;

import Notridame.com.br.Gs.conexao.ConnectionManager;
import Notridame.com.br.Gs.model.Historico.HistoricoSintomas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoMedicoDAO {

    public static List<String> getHistoricoSintomas(String cpfUsuarioLogado) {
        List<String> historicoList = new ArrayList<>();

        ConnectionManager connectionManager = new ConnectionManager();

        String query = "SELECT p.cpf_paciente, a.id_urgencia, u.nome_urgencia, a.tipo_sintoma, a.intensidade_sintoma " +
                "FROM tb_atendimento a " +
                "JOIN tb_paciente p ON a.cpf_paciente = p.cpf_paciente " +
                "JOIN tb_urgencia u ON a.id_urgencia = u.id_urgencia " +
                "WHERE p.cpf_paciente = ? ";

        try (Connection dbConnection = connectionManager.getConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {

            preparedStatement.setString(1, cpfUsuarioLogado);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String cpfPaciente = resultSet.getString("cpf_paciente");
                String nomeUrgencia = resultSet.getString("nome_urgencia");
                String tipoSintoma = resultSet.getString("tipo_sintoma");
                String intensidadeSintoma = resultSet.getString("intensidade_sintoma");

                // Adiciona as informações a uma lista
                historicoList.add("CPF do Paciente: " + cpfPaciente +
                        "\nNome da Urgência: " + nomeUrgencia +
                        "\nTipo de Sintoma: " + tipoSintoma +
                        "\nIntensidade do Sintoma: " + intensidadeSintoma +
                        "\n------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historicoList;
    }

    public void adicionarHistoricoSintomas(HistoricoSintomas historicoSintomas) {
    }
}
