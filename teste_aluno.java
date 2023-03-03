package aula01;

public class teste_aluno {

	public static void main(String[] args) {
	//criar um objeto da classe aluno
	aluno Estudante = new aluno();
	Estudante.nome = "Pedro de Lara";
	Estudante.cpf = "888";
	Estudante.email = "plara@mail.com";
	Estudante.celular = "12345";
	
	System.out.println(Estudante.nome);
	System.out.println(Estudante.email);
	System.out.println(Estudante.celular);
	System.out.println(Estudante.cpf);
	}

}
