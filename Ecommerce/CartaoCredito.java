// Implementação do provedor de pagamento Cartão de Crédito
public class CartaoCredito implements ProvedorPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagando " + valor + " usando Cartão de Crédito.");
    }
}
