package Notridame.com.br.Gs.conexao;


import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class ConnectionManager {
    private static final String urlDeConexao = "jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL";
    private static final String login = "rm551201";
    private static final String senha = "141200";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(urlDeConexao, login, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}