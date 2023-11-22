package Notridame.com.br.Gs.service;

import Notridame.com.br.Gs.conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricoService {

    public static void getHistoricoMedico(String cpfUsuarioLogado) {

        ConnectionManager connectionManager = new ConnectionManager();

        String query = "SELECT nome_paciente, doenca_familia, alergias, nome_medicamento, id_historico_medico " +
                "FROM tb_historico_medico " +
                "JOIN tb_paciente ON tb_historico_medico.cpf_paciente = tb_paciente.cpf_paciente " +
                "WHERE tb_historico_medico.cpf_paciente = ?";

        try (Connection dbConnection = connectionManager.getConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {

            preparedStatement.setString(1, cpfUsuarioLogado);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomePaciente = resultSet.getString("nome_paciente");
                String doencaFamilia = resultSet.getString("doenca_familia");
                String alergias = resultSet.getString("alergias");
                String nomeMedicamento = resultSet.getString("nome_medicamento");
                int idHistoricoMedico = resultSet.getInt("id_historico_medico");

                System.out.println("Nome do Paciente: " + nomePaciente);
                System.out.println("Doença da Família: " + doencaFamilia);
                System.out.println("Alergias: " + alergias);
                System.out.println("Nome do Medicamento: " + nomeMedicamento);
                System.out.println("ID do Histórico Médico: " + idHistoricoMedico);
                System.out.println("------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}