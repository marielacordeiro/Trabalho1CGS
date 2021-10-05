package ControleAquisicoes;
public class Funcionario extends Usuario
{
    Departamento departamento;

    public Funcionario(String id, String nome, Departamento departamento) {
        super(id, nome);
        this.departamento = departamento;
    }
    
    public String getId() {
        return super.getId();
    }

    public String getNome() {
        return super.getNome();
    }

    public String getDepartamento() {
        return this.departamento.nome;
    }
}
