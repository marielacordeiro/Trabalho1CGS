package ControleAquisicoes;

import java.util.ArrayList;

public class Historico
{
    private ArrayList<Pedido> listaPedidos;

    public Historico() {
        listaPedidos = new ArrayList<Pedido>();
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido != null)
            listaPedidos.add(pedido);
    }

    // public String listarPedidosEntreDuasDatas(){}
    // public Usuario buscarPedidosFuncionario(){}
    // public Pedido buscarPelaDescricao(){}
    // public String visualizarPedido(){}

    public String totalPedidos() {
        if (listaPedidos.size() == 0)
            return "Nenhum pedido registrado neste histórico.";

        int totalAbertos = 0, totalAprovados = 0, totalReprovados = 0;
        
        for (Pedido p: listaPedidos) {
            if (p.getStatus().equals("APROVADO"))
                totalAprovados++;
            else if (p.getStatus().equals("REPROVADO"))
                totalReprovados++;
            else
                totalAbertos++;
        }

        int percentualAbertos = totalAbertos * 100 / listaPedidos.size();
        int percentualAprovados = totalAprovados * 100 / listaPedidos.size();
        int percentualReprovados = totalReprovados * 100 / listaPedidos.size();

        return "Total de pedidos: " + listaPedidos.size() + 
               " || Abertos: " + totalAbertos + " (" + percentualAbertos + 
               "%) || Aprovados: " + totalAprovados + " (" + percentualAprovados +
               "%) || Reprovados: " + totalReprovados + " (" + percentualReprovados + "%)";
    }

    // public String pedidosUltimos30Dias(){}
    // public double valorTotalCategoria(){}
    // public String detalhePedidoMaiorAquisicao(){}

}
