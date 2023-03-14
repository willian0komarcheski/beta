package aula01;

public class consumidor_mao {
	public static void main(String[] args) {
		dedo d;
		d = new dedo();
		
		d.posicao = 1;
		mao m = new mao();
			m.lado = "Direito";
			
		m.dedos.add(d);
		
		d = new dedo();
		
		d.posicao = 2;
		m.dedos.add(d);
		
		d = new dedo();
		d.posicao = 3;
		m.dedos.add(d);
		
		for(int i = 0; i < m.dedos.size(); i++) 	
			{
			System.out.println(m.dedos.get(i).posicao);
			}
		
		System.out.println(m.dedos.size());
			
	}
}
