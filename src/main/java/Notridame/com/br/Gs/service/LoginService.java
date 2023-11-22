package Notridame.com.br.Gs.service;

import Notridame.com.br.Gs.conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    private static ConnectionManager connectionManager = new ConnectionManager();

    public LoginService(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public static boolean verificarCadastro(String cpf, String senha) {
        try (Connection connection = connectionManager.getConnection()) {
            String sql = "SELECT cpf_paciente, senha FROM tb_paciente WHERE cpf_paciente = ? AND senha = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


