package ControleAquisicoes;
public class Item
{
    private int idItem;
    private String descricao;
    private double valor;

    public Item(int idItem, String descricao, double valor)
    {
        this.idItem = idItem;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Item " + this.idItem + " [ Descrição: " + this.descricao + ", Valor unitário: R$ " + this.valor + 
        ", Quantidade: " + this.quantidade + ", Valor total: R$ " + this.valor*this.quantidade + " ]";
    }
}
