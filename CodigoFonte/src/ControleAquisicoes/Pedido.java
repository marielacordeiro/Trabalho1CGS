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
        this.itens = new ArrayList<Item>();
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
        return this.dataPedido;
    }

    public String getDataConclusao()
    {
        return this.dataConclusao;
    }

    public String getStatus()
    {
        return this.status;
    }

    public Funcionario getFuncSolicitante()
    {
        return this.funcSolicitante;
    }

    public Departamento getDepartSolicitante()
    {
        return this.departSolicitante;
    }

    public double getValorTotal()
    {
        double valor = 0;
        for(Item item : itens) {
            valor += item.getValorTotal();
        }
        return valor;
    }

    public void setStatus(String status)
    {
        if(status.equals("ABERTO") || status.equals("APROVADO") || status.equals("REPROVADO")){
            this.status = status;
        }
    }

    public void setDataConclusao(String dataConclusao)
    {
        this.dataConclusao = dataConclusao;
    }

    public boolean addItem(Item item) {
        double valorPedido = this.getValorTotal();
        double valorMaxPedido = this.departSolicitante.getValorMaximoPedido();

        if (this.status.equals("ABERTO"))
            if (valorPedido + item.getValorTotal() <= valorMaxPedido)
                return itens.add(item);
        return false;
    }

    public Item removeItem(int idItem) {
        int i = 0;
        for (Item item : this.itens) {
            if (item.getId() == idItem)
                return this.itens.remove(i);
        }
        return null;
    }

}
