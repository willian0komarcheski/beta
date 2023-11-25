package polimorfismo;
import java.util.ArrayList;

public class polimorfismo {
    private ArrayList<Intercurso> cursos;

    public polimorfismo() {
        cursos = new ArrayList<>();
    }

    public void adicionarCurso(Intercurso curso) {
        cursos.add(curso);
    }

    public double getValorTotal() {
        double valorTotal = 0;
        for (Intercurso curso : cursos) {
            valorTotal += curso.getValorParcela();
        }
        return valorTotal;
    }
}