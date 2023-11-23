package Notridame.com.br.Gs.DAO;

import Notridame.com.br.Gs.conexao.ConnectionManager;
import Notridame.com.br.Gs.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessoTriagemDAO {

    private static Notridame.com.br.Gs.model.Paciente Paciente;

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
    public static void inserirHistorico(String cpfPaciente, String tipoSintoma, int intensidadeSintoma, int nivelUrgencia) {
        String sql = "INSERT INTO tb_atendimento (cpf_paciente, tipo_sintoma, intensidade_sintoma, id_urgencia) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConnectionManager.getConnection();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, cpfPaciente);
            ps.setString(2, tipoSintoma);
            ps.setInt(3, intensidadeSintoma);
            ps.setInt(4, nivelUrgencia);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Paciente obterPacientePorCpf(String cpfPaciente) {
        return Paciente;
    }
}
