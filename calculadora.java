package aula01;

public class calculadora {
	public double n1;
	public double n2;
	private double s;
	
	public double somar(double n1, double n2) {
		s = n1 + n2;
		return(s);
		
	}
	public double soma_zera(double n1, double n2) {
		zerar_n1();
		return (n1 + n2);
	}
		private void zerar_n1(){
	n1 = 0;
	}
	
}
