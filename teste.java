package aula01;
import java.util.Scanner;

public class teste {

	public static void main(String[] args) {
		ContaPoupanca cliente = new ContaPoupanca();
		cliente.Banco = "itau";
		cliente.Agencia = "264";
		cliente.Conta = "58623";
		cliente.depositar(100);
		while(1!=0) {
		System.out.println("1-depositar\n2-sacar\n3-consultar");
		Scanner scanner = new Scanner(System.in);
		int valor = scanner.nextInt();
		System.out.println(valor);
		if(valor == 1) 
			{
			System.out.println("\ndigite o valor a depositar\n");
			valor = scanner.nextInt();
			cliente.depositar(valor);
			}
		else if(valor == 2) 
			{
			System.out.println("\ndigite o valor a sacar\n");
			valor = scanner.nextInt();
			cliente.depositar(valor);
			}
		else if(valor == 3)
			{
			System.out.println(cliente.depositar(0));
			}
		}
	}
}
