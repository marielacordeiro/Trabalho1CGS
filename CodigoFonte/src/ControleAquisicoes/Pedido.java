package ControleAquisicoes;

import java.util.ArrayList;

public class Pedido {
    protected static int count = 1;
    private int idPedido;
    private ArrayList<Item> itens;
    private Usuario funcSolicitante;
    private Departamento departSolicitante;
    private String dataPedido;
    private String dataConclusao;
    private String status;

    public Pedido(Usuario funcSolicitante, String dataPedido) {
        this.idPedido = count;
        this.itens = new ArrayList<Item>();
        this.funcSolicitante = funcSolicitante;
        this.dataPedido = dataPedido;
        this.status = "ABERTO";
        this.departSolicitante = funcSolicitante.getDepartamento();
        count++;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }

    public String getDataPedido() {
        return this.dataPedido;
    }

    public String getDataConclusao() {
        return this.dataConclusao;
    }

    public String getStatus() {
        return this.status;
    }

    public Usuario getFuncSolicitante() {
        return this.funcSolicitante;
    }

    public Departamento getDepartSolicitante() {
        return this.departSolicitante;
    }

    public double getValorTotal() {
        double valor = 0;
        for (Item item : itens) {
            valor += item.getValorTotal();
        }
        return valor;
    }

    public void setStatus(String status) {
        if (status.equals("ABERTO") || status.equals("APROVADO") || status.equals("REPROVADO")) {
            this.status = status;
        }
    }

    public void setDataConclusao(String dataConclusao) {
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
        for (Item item : this.itens) {
            if (item.getId() == idItem) {
                Item removido = item;
                this.itens.remove(item);
                return removido;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", itens=" + itens + ", funcSolicitante=" + funcSolicitante
                + ", departSolicitante=" + departSolicitante + ", dataPedido='" + dataPedido + '\''
                + ", dataConclusao='" + dataConclusao + '\'' + ", valorTotal='" + this.getValorTotal() + '\''
                + ", status='" + status + '\'' + '}';
    }

}
