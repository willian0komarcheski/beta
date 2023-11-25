package polimorfismo;

import java.util.ArrayList;
import java.util.function.IntConsumer;

public class consumidor_inter_cursos {

	public static void main(String[] args) {
		ArrayList<Intercurso> cursos = new ArrayList<Intercurso>();
		//Instanciar um bacharelado
		bacharelado BSI = new bacharelado();
		BSI.nome_curso="BSI";
		BSI.carga_horaria = 3600;
		BSI.valor_parcela = 1200;
		
		//Instanciar um bacharelado com laboratorio
		bacharelado_laboratorio ODONTO = new bacharelado_laboratorio();
		ODONTO.nome_curso = "Odonto";
		ODONTO.carga_horaria = 4000;
		ODONTO.valor_parcela = 5000;
		ODONTO.custo_lab = 1000;
		
		bacharelado_laboratorio VETERINARIA = new bacharelado_laboratorio();
		VETERINARIA.nome_curso="Vet";
		VETERINARIA.carga_horaria = 3800;
		VETERINARIA.valor_parcela = 2500;
		VETERINARIA.custo_lab = 800;
		
		
		//Adicionar um curso na lista de cursos
		cursos.add(BSI);
		cursos.add(ODONTO);
		cursos.add(VETERINARIA);
		
		System.out.println(cursos.size());
		for(int i=0;i<cursos.size();i++) {
			System.out.println(cursos.get(i).gGetNome_do_Curso());
		}
		
	}

}
