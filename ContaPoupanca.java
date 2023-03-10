package aula01;

public class ContaPoupanca {
	public String Banco, Agencia, Conta;
	private double Saldo;


public double depositar(double valor) {
	this.Saldo += valor;
	return this.Saldo;
	}
}