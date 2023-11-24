package Notridame.com.br.Gs.DAO;

import Notridame.com.br.Gs.conexao.ConnectionManager;
import Notridame.com.br.Gs.model.HistoricoMedico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {

    public static List<String> getHistoricoMedico(String cpfUsuarioLogado) {
        List<String> historicoList = new ArrayList<>();

        ConnectionManager connectionManager = new ConnectionManager();

        String query = "SELECT " +
                "a.nome_alergia, " +
                "m.nome_medicamento, " +
                "hf.nome_doenca, " +
                "hm.id_historico_familiar, " +
                "hm.id_medicamento, " +
                "hm.id_alergia, " +
                "hm.cpf_paciente " +
                "FROM " +
                "tb_historico_medico hm " +
                "JOIN " +
                "tb_alergia a ON hm.id_alergia = a.id_alergia " +
                "JOIN " +
                "tb_medicamento m ON hm.id_medicamento = m.id_medicamento " +
                "JOIN " +
                "tb_historico_familiar hf ON hm.id_historico_familiar = hf.id_historico_familiar " +
                "WHERE " +
                "hm.cpf_paciente = ? ";


        try (Connection dbConnection = connectionManager.getConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {

            preparedStatement.setString(1, cpfUsuarioLogado);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomeAlergia = resultSet.getString("nome_alergia");
                String nomeMedicamento = resultSet.getString("nome_medicamento");
                String doencaFamilia = resultSet.getString("nome_doenca");

                // Adiciona as informações a uma lista
                historicoList.add("Nome da Alergia: " + nomeAlergia +
                        "\nNome do Medicamento: " + nomeMedicamento +
                        "\nDoença da Família: " + doencaFamilia +
                        "\n------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historicoList;
    }

    public void adicionarHistoricoMedico(HistoricoMedico historicoMedico) {
    }
}
