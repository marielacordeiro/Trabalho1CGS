package ControleAquisicoes;
public class Administrador extends Usuario
{
    public Administrador(int id, String nome) {
        super(id, nome);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public String getNome() {
        return super.getNome();
    }
}
