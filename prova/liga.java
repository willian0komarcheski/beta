package prova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class liga {
    private static Connection connection;

    private liga() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/empresa";
                String username = "root";
                String password = "eu odeio banco de dados123";
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (connection.isClosed()) {
                    String url = "jdbc:mysql://localhost:3306/empresa";
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