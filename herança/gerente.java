

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

public class gerente extends funcionario{
    public double gratificacao;
    public gerente(String cpf, String nome, String email, double salario, String aniversario, String telefone, String departamento, double gratificacao){
        super(cpf, nome, email, salario, aniversario, telefone, departamento);
        this.gratificacao = gratificacao;
    }

    public boolean idexiste() {
        String sql = "SELECT COUNT(*) FROM gerente WHERE cpf = ?";
        try (Connection connection = ligaçao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*public void achar( String... columns) {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";

        try (Connection connection = ligaçao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
             
            statement.setString(1, cpf);
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
    }*/

    public void salvar() {
        boolean x = idexiste();
        if(x) {
            String sql = "UPDATE gerente SET gratificacao = ? WHERE cpf = ?";

            try (Connection connection = ligaçao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(2, cpf);
                statement.setDouble(1, gratificacao);
                super.salvar();
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
                    String sql = "INSERT INTO gerente (cpf, gratificacao) VALUES (?, ?)";

                    try (Connection connection = ligaçao.getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, cpf);
                        statement.setDouble(2, gratificacao);
                        super.salvar();
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
                String sql = "DELETE FROM gerente WHERE cpf = ?";
        
                try (Connection connection = ligaçao.getConnection();
                     PreparedStatement statement = connection.prepareStatement(sql)) {
        
                    statement.setString(1, cpf);
                    super.delete();
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
