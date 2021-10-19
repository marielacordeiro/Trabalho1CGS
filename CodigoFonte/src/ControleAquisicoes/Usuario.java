package ControleAquisicoes;

public class Usuario {
    private static int nextId = 0;
    protected int id;
    protected String nome;
    protected boolean isAdmin;
    protected Departamento departamento;

    public Usuario(String nome, boolean isAdmin, Departamento departamento) {
        this.id = nextId++;
        this.nome = nome;
        this.isAdmin = isAdmin;
        this.departamento = departamento;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Identificador: " + id;
    }
}