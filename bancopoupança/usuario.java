import java.util.ArrayList;
import java.util.List;

class Usuario {
    public String cpf;
    public String nome;
    public String email;
    public List<Conta> contas;

    public Usuario(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void mostrarContas() {
        for (Conta conta : contas) {
            System.out.println("Número: " + conta.numero + ", Tipo: " + conta.tipo + ", Saldo: " + conta.saldo);
        }
    }
}
