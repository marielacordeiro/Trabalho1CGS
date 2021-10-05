package ControleAquisicoes;
import java.util.ArrayList;

public class Pedido
{
    private ArrayList<Item> listaItem;
    private String dataInic;
    private String dataConcl;
    private String status;
    private double valorTotal;

    public Pedido()
    {
        listaItem = new ArrayList<>();
        status = "NAO DEFINIDO";

    }
}
