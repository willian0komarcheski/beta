public class FabricaCartaoCredito implements FabricaProvedorPagamento {
    @Override
    public ProvedorPagamento criarProvedorPagamento() {
        return new CartaoCredito();
    }
}