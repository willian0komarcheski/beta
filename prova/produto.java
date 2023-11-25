package prova;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class produto {
    public int codigo;
    public String nome;
    public double preco_sugerido;
    public double custo_armazenagem;

    public produto (int codigo, String nome, double preco_sugerido, double custo_armazenagem){
        this.codigo = codigo;
        this.nome = nome;
        this.preco_sugerido = preco_sugerido;
        this.custo_armazenagem =custo_armazenagem;
    }


    public void delete() {
        String sql = "DELETE FROM produto WHERE codigo = ?";

        try (Connection connection = liga.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, codigo);
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

    public double  calcular_preco_total() {
        return preco_sugerido + custo_armazenagem;
    }
}
