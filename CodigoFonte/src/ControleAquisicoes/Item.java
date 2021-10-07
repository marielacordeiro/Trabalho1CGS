package ControleAquisicoes;
public class Item
{
    private int idItem;
    private String descricao;
    private double valor;
    private int quantidade;

    public Item(int idItem, String descricao, double valor, int quantidade)
    {
        this.idItem = idItem;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }
}
