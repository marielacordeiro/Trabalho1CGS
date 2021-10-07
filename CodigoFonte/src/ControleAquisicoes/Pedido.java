package ControleAquisicoes;
import java.util.ArrayList;

public class Pedido
{
    private ArrayList<Item> itens;
    private Funcionario funcSolicitante;
    private Departamento departSolicitante;
    private String dataPedido;
    private String dataConclusao;
    private String status;

    public Pedido(Funcionario funcSolicitante, String dataPedido) {
        this.itens = new ArrayList<>();
        this.funcSolicitante = funcSolicitante;
        this.dataPedido = dataPedido;
        this.status = "ABERTO";
        this.departSolicitante = funcSolicitante.getDepartamento();
    }

    public ArrayList<Item> getItens()
    {
        return this.itens;
    }

    public String getDataPedido()
    {
        return this.DataPedidoc;
    }

    public String getDataConclusao()
    {
        return this.dataConclusao;
    }

    public String getStatus()
    {
        return this.status;
    }

    public double getValorTotal()
    {
        double valor = 0;
        for(Item item : itens) {
            valor += Item.getValorTotal();
        }
        return valor;
    }
}
