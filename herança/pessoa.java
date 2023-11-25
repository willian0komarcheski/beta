import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pessoa {
    public int id;
    public String cpf;
    public String nome;
    public String email;

    public pessoa(int id, String cpf, String nome, String email){
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public boolean idexiste() {
        String sql = "SELECT COUNT(*) FROM pessoa WHERE id = ?";
        try (Connection connection = ligacao.getConnection();
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

    public void salvar() {
        if(idexiste()) {
            String sql = "UPDATE pessoa SET cpf = ?, nome = ?, email = ? WHERE id = ?";

            try (Connection connection = ligacao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, cpf);
                statement.setString(2, nome);
                statement.setString(3, email);
                statement.setInt(4, id);
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
                    String sql = "INSERT INTO pessoa (id, cpf, nome, email) VALUES (?, ?, ?, ?)";

                    try (Connection connection = ligacao.getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql)) {
        
                        statement.setInt(1, id);
                        statement.setString(2, cpf);
                        statement.setString(3, nome);
                        statement.setString(4, email);
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
                String sql = "DELETE FROM pessoa WHERE id = ?";
        
                try (Connection connection = ligacao.getConnection();
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
