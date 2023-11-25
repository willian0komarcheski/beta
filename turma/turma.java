package turma;

import java.util.ArrayList;

public class turma {
	public ArrayList<estudante> sala = new ArrayList<estudante>();
	public professor professor = new professor();
	
	public ArrayList<String> lista_turma() {
		ArrayList<String> amostra_turma = new ArrayList<String>();
		for(int i = 0; i < this.sala.size(); i++) {
			amostra_turma.add(this.sala.get(i).nome);
			
		}
	return amostra_turma;
	}
}
