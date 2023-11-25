package prova;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class produto_alto extends produto {
    public double valor_seguro;
    public String tipo_transporte;
    public produto_alto(int codigo, String nomem, double preco_sugerido, double custo_armazenagem, double valor_seguro, String tipo_transporte){
        super(codigo, nomem, preco_sugerido, custo_armazenagem);
        this.valor_seguro = valor_seguro;
        this.tipo_transporte = tipo_transporte;
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
    super.delete();
    }

    public double calcular_preco_finall(){
    return super.calcular_preco_total() + valor_seguro;
    }
}
