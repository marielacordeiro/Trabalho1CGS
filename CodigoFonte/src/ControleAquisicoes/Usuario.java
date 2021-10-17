package ControleAquisicoes;
public class Usuario
{
    protected int id;
    protected String nome;
    protected boolean isAdmin;

    public Usuario(int id, String nome, boolean isAdmin) {
        this.id = id;
        this.nome = nome;
        this.isAdmin = isAdmin;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}