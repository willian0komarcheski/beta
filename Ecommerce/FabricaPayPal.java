public class FabricaPayPal implements FabricaProvedorPagamento {
    @Override
    public ProvedorPagamento criarProvedorPagamento() {
        return new PayPal();
    }
}
