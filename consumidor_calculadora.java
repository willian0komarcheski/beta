package aula01;

public class consumidor_calculadora {

	public static void main(String[] args) {
		calculadora calc = new calculadora();
		calculadora c = new calculadora();
		calc.n1 = 11;
		calc.n2 = 10;
		System.out.println(calc.somar(calc.n1, calc.n2));
		System.out.println(calc);
		System.out.println(c);
	}

}
