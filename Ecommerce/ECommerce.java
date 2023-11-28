public class ECommerce {
    private ProvedorPagamento provedorPagamento;

    // Injeção de dependência através do construtor
    public ECommerce(FabricaProvedorPagamento fabricaProvedorPagamento) {
        this.provedorPagamento = fabricaProvedorPagamento.criarProvedorPagamento();
    }

    public void pagar(double valor) {
        provedorPagamento.pagar(valor);
    }
}


// A classe ECommerce pode trocar facilmente entre diferentes provedores de pagamento,
//  tornando o sistema de pagamento flexível. Isso é feito através da injeção de uma 
//  fábrica concreta no construtor, que permite alterar o provedor de pagamento em tempo de execução.