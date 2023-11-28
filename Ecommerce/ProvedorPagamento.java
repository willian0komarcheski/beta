// Interface comum para todos os provedores de pagamento
public interface ProvedorPagamento {
    void pagar(double valor);
}