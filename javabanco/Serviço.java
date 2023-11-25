import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class Serviço {
    public int id;
    public String tipo;
    public double preco;

    public Serviço(int id, String tipo, double preco) {
        this.id = id;
        this.tipo = tipo;
        this.preco = preco;
    }
    public boolean idexiste() {
        String sql = "SELECT COUNT(*) FROM Serviço WHERE id = ?";
        try (Connection connection = ligaçao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void achar( String... columns) {
        String sql = "SELECT * FROM Serviço WHERE id = ?";

        try (Connection connection = ligaçao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
             
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                for (String column : columns) {
                    String value = resultSet.getString(column);
                    System.out.println(column + ": " + value);
                }
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvar() {
        boolean x = idexiste();
        if(x) {
            String sql = "UPDATE Serviço SET tipo = ?, preco = ? WHERE id = ?";

            try (Connection connection = ligaçao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, tipo);
                statement.setDouble(2, preco);
                statement.setInt(3, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Dados atualizados com sucesso!");
                } else {
                    System.out.println("Falha ao atualizar os dados.");
                }
                } catch (SQLException e) {
                e.printStackTrace();
                }
            }
            else    
                {
                    String sql = "INSERT INTO Serviço (id, tipo, preco) VALUES (?, ?, ?)";

                    try (Connection connection = ligaçao.getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql)) {
        
                        statement.setInt(1, id);
                        statement.setString(2, tipo);
                        statement.setDouble(3, preco);
                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Dados inseridos com sucesso!");
                        } else {
                            System.out.println("Falha ao inserir os dados.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            public void delete() {
                String sql = "DELETE FROM Serviço WHERE id = ?";
        
                try (Connection connection = ligaçao.getConnection();
                     PreparedStatement statement = connection.prepareStatement(sql)) {
        
                    statement.setInt(1, id);
                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Registro excluído com sucesso!");
                    } else {
                        System.out.println("Falha ao excluir o registro. O cliente não foi encontrado.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } 
}