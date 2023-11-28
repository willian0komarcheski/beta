// Implementação do provedor de pagamento PayPal
public class PayPal implements ProvedorPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagando " + valor + " usando PayPal.");
    }
}
