class Conta {
    public int numero;
    public String tipo;
    public double saldo;

    public Conta(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}

