package ControleAquisicoes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


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

    public List<Pedido> pedidosEntreDuasDatas(LocalDate dataInicial, LocalDate dataFinal){
        List<Pedido> pedidosEntreDatas = listaPedidos.stream().filter(p -> p.getDataPedido().isAfter(dataInicial) && p.getDataPedido().isBefore(dataFinal)).collect(Collectors.toList());
        return pedidosEntreDatas;
    }

    public List<Pedido> buscarPedidosFuncionario(Funcionario funcionario) {
        List<Pedido> pedidosFuncionario = listaPedidos.stream().filter(p -> p.getFuncSolicitante() == funcionario).collect(Collectors.toList());
        return pedidosFuncionario;
    }

    public List<Pedido> buscarPedidosDescricaoItem(String descricao) {
        List<Pedido> pedidosDescricaoItem = listaPedidos.stream().filter(p -> p.getItens()
                                                        .stream().filter(i -> i.getDescricao()
                                                        .equals(descricao)).count() > 0).collect(Collectors.toList());
        return pedidosDescricaoItem;
    }

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

    public List<Pedido> pedidosUltimos30Dias(){
        LocalDate data30DiasAtras = LocalDate.now().minusDays(30);
        List<Pedido> pedidosDe30DiasAtras =  listaPedidos.stream().filter(p -> p.getDataPedido().isAfter(data30DiasAtras)).collect(Collectors.toList());
        return pedidosDe30DiasAtras;
    }

    public List<Pedido> valorTotalCategoria(){
        LocalDate dataDe30DiasAtras = LocalDate.now().minusDays(30);
        Collection<Pedido> listaPedidosEmAberto;
        List<Pedido> pedidosEmAberto = listaPedidosEmAberto.stream().filter(p -> p.getStatus().isAfter(dataDe30DiasAtras)).collect(Collectors.toList());
        return pedidosEmAberto;
    }
     // public String detalhePedidoMaiorAquisicao(){}

}
