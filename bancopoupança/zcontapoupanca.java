
public class zcontapoupanca {
	public String numero;
	public String tipo;
	public double saldo;
	
	
	public zcontapoupanca(String numero, String tipo) {
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = 0.0;
		
	}
	
	public void sacar( double valor){
		if(saldo >= valor) {
		saldo -= valor;
		System.out.println("o seu saldo restante é: " + saldo);
			}
		else{
			System.out.println("o seu saldo é insuficiente, o seu saldo atual é:" + saldo);
			};
	}
	
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("o seu saldo atual é: " + saldo);
	}
	
	public void mostrar() {
		System.out.println("Saldo da conta " + numero + " (" + tipo + "): R$" + saldo);
	}
}
