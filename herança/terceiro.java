

public class terceiro extends funcionario{
    public boolean ativo;
    public boolean situacao;
    public terceiro(String cpf, String nome, String email, boolean ativo, boolean situacao){
        super(cpf, nome, email, 0.0, "", "", "");
        this.ativo = ativo;
        this.situacao = situacao;
    }
}
