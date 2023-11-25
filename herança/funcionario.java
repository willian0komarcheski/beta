import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

public class funcionario {
    public String cpf;
    public String nome;
    public String email;
    public double salario;
    public String aniversario;
    public String telefone;
    public String departamento;

    public funcionario(String cpf, String nome, String email, double salario, String aniversario, String telefone, String departamento){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.aniversario = aniversario;
        this.telefone = telefone;
        this.departamento = departamento;
    }

    public boolean idexiste() {
        String sql = "SELECT COUNT(*) FROM funcionario WHERE cpf = ?";
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

    public void achar( String... columns) {
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
    }

    public void salvar() {
        boolean x = idexiste();
        if(x) {
            String sql = "UPDATE funcionario SET nome = ?, email = ?, salario = ?, aniversario = ?, telefone = ?, departamento = ? WHERE cpf = ?";

            try (Connection connection = ligaçao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(0, cpf);
                statement.setString(1, nome);
                statement.setString(2, email);
                statement.setDouble(3, salario);
                statement.setString(4, aniversario);
                statement.setString(5, telefone);
                statement.setString(6, departamento);
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
                    String sql = "INSERT INTO funcionario (cpf, nome, email, salario, aniversario, telefone, departamento) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    try (Connection connection = ligaçao.getConnection();
                        PreparedStatement statement = connection.prepareStatement(sql)) {
        
                        statement.setString(1, cpf);
                        statement.setString(2, nome);
                        statement.setString(3, email);
                        statement.setDouble(4, salario);
                        statement.setString(5, aniversario);
                        statement.setString(6, telefone);
                        statement.setString(7, departamento);
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
                String sql = "DELETE FROM funcionario WHERE cpf = ?";
        
                try (Connection connection = ligaçao.getConnection();
                     PreparedStatement statement = connection.prepareStatement(sql)) {
        
                    statement.setString(1, cpf);
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
