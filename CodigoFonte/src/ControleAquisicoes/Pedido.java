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
}
