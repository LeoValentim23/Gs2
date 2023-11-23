package Notridame.com.br.Gs.DAO;

import Notridame.com.br.Gs.conexao.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessoTriagemDAO {

    public static String obterEnderecoDoPaciente(String cpfUsuarioLogado) {
        String endereco = null;

        try (Connection conexao = ConnectionManager.getConnection();
             PreparedStatement ps = conexao.prepareStatement("SELECT endereco_paciente FROM tb_PACIENTE WHERE cpf_paciente = ?")) {

            ps.setString(1, cpfUsuarioLogado);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    endereco = rs.getString("endereco_paciente");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    public static int obterIdadeDoPaciente(String cpfUsuarioLogado) {
        int idade = 0;

        try (Connection conexao = ConnectionManager.getConnection();
             PreparedStatement ps = conexao.prepareStatement("SELECT idade_paciente FROM tb_PACIENTE WHERE cpf_paciente = ?")) {

            ps.setString(1, cpfUsuarioLogado);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idade = rs.getInt("idade_paciente");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idade;
    }
}