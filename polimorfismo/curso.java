package polimorfismo;

public abstract class curso implements Intercurso {
//Classes abstratas não podem ser utilizadas para contruir objetos
//Somente podem servir como SUPER CLASSES
	public String nome_curso;
	public int carga_horaria;
	public double valor_parcela;
	
	public void salvar() {
		System.out.println("Salvando");
	}
	
	public void delete() {
		System.out.println("Excluindo");
	}
	
	public void find_one() {
		System.out.println("Localizando");
	}
}
