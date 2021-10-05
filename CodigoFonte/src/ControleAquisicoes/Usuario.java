package ControleAquisicoes;
public class Usuario
{
    protected String id;
    protected String nome;

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
