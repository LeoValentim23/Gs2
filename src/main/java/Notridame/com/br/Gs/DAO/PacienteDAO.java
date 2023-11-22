package Notridame.com.br.Gs.DAO;

import Notridame.com.br.Gs.conexao.ConnectionManager;
import Notridame.com.br.Gs.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {

    public static boolean inserirNoBancoDeDados(Paciente paciente, ConnectionManager connectionManager) {
        try (Connection dbConnection = connectionManager.getConnection()) {
            String query = "INSERT INTO tb_paciente (cpf_paciente, nome_paciente, idade_paciente, sexo_paciente, plano_saude_paciente, endereco_paciente, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {
                preparedStatement.setString(1, paciente.getCpf());
                preparedStatement.setString(2, paciente.getNome());
                preparedStatement.setInt(3, paciente.getIdade());
                preparedStatement.setString(4, paciente.getSexo());
                preparedStatement.setInt(5, paciente.getPlanoSaude());
                preparedStatement.setString(6, paciente.getEndereco());
                preparedStatement.setString(7, paciente.getSenha());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}