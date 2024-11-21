package acadinioBox.modolodeCanecção;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModulloConexao {
    private static final String url = "jdbc:mysql://localhost:3306/kinggymbrox?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "Prof@dm1n";

    // Renomeado para getConnection
    public static Connection getConnection() throws SQLException {
        try {
            // Registra o driver JDBC manualmente
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado!", e);
        }
        return DriverManager.getConnection(url, user, password);
    }

    public static String testConnection() {
        try (Connection connection = getConnection()) {
            return "Conexão bem-sucedida!";
        } catch (SQLException e) {
            return "Erro de conexão: " + e.getMessage();
        }
    }
}