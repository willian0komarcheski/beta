import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class ServiçoContratado {
    public int id;
    public Cliente cliente;
    public Serviço servico;
    public PrestadorServiço prestador;
    public String dataContrato;

    public ServiçoContratado(int id, Cliente cliente, Serviço servico, PrestadorServiço prestador, String dataContrato) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.prestador = prestador;
        this.dataContrato = dataContrato;
    }
    public boolean idexiste() {
        String sql = "SELECT COUNT(*) FROM ServiçoContratado WHERE id = ?";
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
        String sql = "SELECT * FROM ServiçoContratado WHERE id = ?";

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
            String sql = "UPDATE ServiçoContratado SET dataContrato = ? WHERE id = ?";

            try (Connection connection = ligaçao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, dataContrato);
                statement.setInt(2, id);
                int rowsUpdated = statement.executeUpdate();
                cliente.salvar();
                servico.salvar();
                prestador.salvar();
                connection.commit();
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
                    String sql = "INSERT INTO ServiçoContratado (id, datacontrato) VALUES (?, ?)";

                    try (Connection connection = ligaçao.getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql)) {
        
                        statement.setInt(1, id);
                        statement.setString(2, dataContrato);
                        int rowsInserted = statement.executeUpdate();
                        cliente.salvar();
                        servico.salvar();
                        prestador.salvar();
                        connection.commit();
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
                String sql = "DELETE FROM ServiçoContratado WHERE id = ?";
        
                try (Connection connection = ligaçao.getConnection();
                     PreparedStatement statement = connection.prepareStatement(sql)) {
        
                    statement.setInt(1, id);
                    int rowsDeleted = statement.executeUpdate();
                    cliente.delete();
                    servico.delete();
                    prestador.delete();
                    connection.commit();
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