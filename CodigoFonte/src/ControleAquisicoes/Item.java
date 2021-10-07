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

    public int getId()
    {
        return this.idItem;
    }

    public String getDescricao()
    {
        return this.descricao;
    }

    public double getValor()
    {
        return this.valor;
    }

    public int getQuantidade()
    {
        return this.quantidade;
    }

    @Override
    public String toString() {
        return "Item " + this.idItem + " [ Descrição: " + this.descricao + ", Valor unitário: R$ " + this.valor + 
        ", Quantidade: " + this.quantidade + ", Valor total: R$ " + this.valor*this.quantidade + " ]";
    }
}
