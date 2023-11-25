import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ligaçao {
    private static Connection connection;

    private ligaçao() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Configurar e estabelecer a conexão com o banco de dados
                String url = "jdbc:mysql://localhost:3306/trampo";
                String username = "root";
                String password = "eu odeio banco de dados123";
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                // Verificar se a conexão está fechada e reabri-la se necessário
                if (connection.isClosed()) {
                    String url = "jdbc:mysql://localhost:3306/trampo";
                    String username = "root";
                    String password = "eu odeio banco de dados123";
                    connection = DriverManager.getConnection(url, username, password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}