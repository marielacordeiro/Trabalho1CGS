package ControleAquisicoes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private Scanner in;
    private List<Usuario> listaUsuarios;
    private List<Usuario> listaUsuariosAdmin;
    private List<Departamento> departamentos;
    private Usuario usuarioAtual;
    private Historico historico;

    public Aplicacao() {
        in = new Scanner(System.in);
        listaUsuarios = new ArrayList<>();
        listaUsuariosAdmin = new ArrayList<>();
        historico = new Historico();
        departamentos = new ArrayList<Departamento>();
    }

    public void inicializa() {
        // inicializa os funcionarios no departamento
        Departamento d1 = new Departamento("Financeiro", 1000000);
        departamentos.add(d1);
        Departamento d2 = new Departamento("RH", 100000);
        departamentos.add(d2);
        Departamento d3 = new Departamento("Engenharia", 500000);
        departamentos.add(d3);
        Departamento d4 = new Departamento("Administracao", 2000000);
        departamentos.add(d4);
        Departamento d5 = new Departamento("Marketing", 600000);
        departamentos.add(d5);
        Usuario u1 = new Usuario("Paula", true, d1);
        listaUsuariosAdmin.add(u1);
        Usuario u2 = new Usuario("Alfredo", true, d2);
        listaUsuariosAdmin.add(u2);
        Usuario u3 = new Usuario("Amanda", true, d3);
        listaUsuariosAdmin.add(u3);
        Usuario u4 = new Usuario("Francisco", true, d4);
        listaUsuariosAdmin.add(u4);
        Usuario u5 = new Usuario("Lucas", false, d5);
        listaUsuarios.add(u5);
        Usuario u6 = new Usuario("Coraline", false, d1);
        listaUsuarios.add(u6);
        Usuario u7 = new Usuario("Augusta", false, d2);
        listaUsuarios.add(u7);
        Usuario u8 = new Usuario("Catarina", false, d3);
        listaUsuarios.add(u8);
        Usuario u9 = new Usuario("Cláudio", false, d4);
        listaUsuarios.add(u9);
        Usuario u10 = new Usuario("Mauro Lúcio", false, d5);
        listaUsuarios.add(u10);
        Usuario u11 = new Usuario("Adalberto", false, d1);
        listaUsuarios.add(u11);
        Usuario u12 = new Usuario("Henrique", false, d2);
        listaUsuarios.add(u12);
        Usuario u13 = new Usuario("Jasmin", false, d3);
        listaUsuarios.add(u13);
        Usuario u14 = new Usuario("Luiza", false, d4);
        listaUsuarios.add(u14);
        Usuario u15 = new Usuario("Alice", false, d5);
        listaUsuarios.add(u15);
        Usuario u16 = new Usuario("Sergio", false, d1);
        listaUsuarios.add(u16);
    }

    private void menuFunc() {
        int op;
        do {
            mostraMenuFuncionario();
            op = leInteiro();
            switch (op) {
            case 0:
                System.out.println("Sistema Finalizado!");
                break;
            case 1:
                menuPrincipal();
                op = 0;
                break;
            case 2:
                realizarPedido(usuarioAtual);
                break;
            case 3:
                excluiPedido();
                break;
            default:
                System.out.println("Opção Inválida");
                break;
            }
        } while (op != 0);
    }

    private void menuAdm() {
        int op;
        do {
            mostraMenuAdm();
            op = leInteiro();
            switch (op) {
            case 0:
                System.out.println("Sistema Finalizado!");
                break;
            case 1:
                menuPrincipal();
                op = 0;
                break;
            case 2:
                realizarPedido(usuarioAtual);
                break;
            case 3:
                excluiPedido();
                break;
            case 4:
                pedidosEntreDuasDatas();
                break;
            case 5:
                buscarFuncionarioSolicitante();
                break;
            case 6:
                buscarDescricaoItem();
                break;
            case 7:
                break;
            case 8:
                System.out.println(historico.totalPedidos());
                break;
            case 9:
                historico.pedidosUltimos30Dias().forEach(System.out::println);
                break;
            case 10:
                System.out.println(historico.valorTotalCategoria());
                break;
            case 11:
                System.out.println(historico.detalhePedidoMaiorAquisicao());
                break;
            case 12:
                aprovaReprovaPedido();
                break;
            case 13:
                adicionaUsuario();
                break;
            default:
                System.out.println("Opção Inválida");
                break;
            }
        } while (op != 0);
    }

    public void menuPrincipal() {
        // Menu de selecao de usuario
        escolhaUsuario();
        int op = leInteiro();
        if (op == 1) {
            // escolhe o adm atual
            if (escolheAdm(listaUsuariosAdmin)) {
                System.out.format("Bem-vindo(a), %s%n", usuarioAtual.getNome());
                menuAdm();
            } else
                System.out.println("Usuário não encontrado");
        } else if (op == 2) {
            // escolhe o func atual
            if (escolheFunc(listaUsuarios)) {
                System.out.format("Bem-vindo(a), %s%n", usuarioAtual.getNome());
                menuFunc();
            } else
                System.out.println("Usuário não encontrado");
        }
    }

    private void pedidosEntreDuasDatas() {
        System.out.println("Informa a data inicial (yyyy-MM-dd): ");
        LocalDate dataInicial = LocalDate.parse(in.nextLine());
        System.out.println("Informe a data final: (yyyy-MM-dd)");
        LocalDate dataFinal = LocalDate.parse(in.nextLine());
        historico.pedidosEntreDuasDatas(dataInicial, dataFinal).forEach(System.out::println);
    }

    private void buscarDescricaoItem() {
        System.out.println("Informe a descrição do item: ");
        String descItem = in.nextLine();
        historico.buscarPedidosDescricaoItem(descItem).forEach(System.out::println);
    }

    private void buscarFuncionarioSolicitante() {
        System.out.println("Informe o funcionário solicitante: ");
        int idUsuario = in.nextInt();
        // ArrayList<Pedido> listaPedido = historico.BuscaPedidos(idUsuario);
        // System.out.println("Informe o funcionário solicitante: ");
        // int idUsuario = in.nextInt();
        // listaUsuarios.stream().filter(u -> u.getId() ==
        // idUsuario).forEach(System.out::println);

    }

    private boolean excluiPedido() {
        ArrayList<Pedido> listaPedido = historico.getListaPedidos();

        // Verifica se o array possui pedidos
        if (listaPedido.size() == 0) {
            System.out.println("Não há pedidos cadastrados");
            return false;
        }

        // Printa a lista de pedidos
        for (Pedido p : listaPedido)
            System.out.println(p);

        System.out.println("Informe o id do pedido para ser excluido");
        int id = in.nextInt();
        Pedido pedido = null;
        for (Pedido p : listaPedido) {
            if (p.getIdPedido() == id)
                pedido = p;
        }
        if (pedido == null) {
            System.out.println("Nenhum pedido encontrado com este Id");
            return false;
        }
        System.out.format("Você tem certeza que deseja excluir o pedido: %n%s%n", pedido);
        System.out.println("[1] - Não      [2] - Sim");
        int op = in.nextInt();
        switch (op) {
        case 1:
            return false;
        case 2:
            if (pedido.getFuncSolicitante().equals(usuarioAtual)) {
                Pedido ped = historico.visualizarPedido(id);
                if (ped.getStatus().equals("ABERTO")) {
                    listaPedido.remove(ped);
                    return true;
                }
            } else {
                System.out.println("Erro, Usuário solicitante deve ser o mesmo do pedido!");
                return false;
            }
        default:
            System.out.println("Opcão inválida!");
            return false;
        }
    }

    private void mostraMenuAdm() {
        System.out.println("[0] - Encerrar menu");
        System.out.println("[1] - Trocar de Usuário");
        System.out.println("[2] - Solicitar Pedido");
        System.out.println("[3] - Excluir Pedido");
        System.out.println("[4] - Listar todos os pedidos entre duas datas");
        System.out.println("[5] - Buscar pedidos por funcionário solicitante");
        System.out.println("[6] - Buscar pedidos pela descrição de um item");
        System.out.println("[7] - Visualizar os detalhes de um pedido para aprovar ou reprovar");
        System.out.println("[8] - Número de pedidos total, divididos entre aprovados e reprovados");
        System.out.println("[9] - Número de pedidos nos últimos 30 dias e seu valor médio");
        System.out.println("[10] - Valor total de cada categoria nos últimos 30 dias");
        System.out.println("[11] - Detalhes do pedido de aquisição de maior valor ainda aberto");
        System.out.println("[12] - Aprovar ou reprovar algum pedido em aberto");
        System.out.println("[13] - Adicionar novo usuário");
    }

    private boolean escolheAdm(List<Usuario> listaUsuarioAdmin) {
        System.out.println("-----Lista de administradores registrada-----");
        for (Usuario u : listaUsuarioAdmin) {
            System.out.println(u);
        }

        System.out.println("Escolha um identificador para realizar seu login: ");
        int id = in.nextInt();
        for (int i = 0; i < listaUsuarioAdmin.size(); i++) {
            if (id == listaUsuarioAdmin.get(i).getId()) {
                usuarioAtual = listaUsuarioAdmin.get(i);
                return true;
            }
        }
        return false;
    }

    private boolean escolheFunc(List<Usuario> listaUsuarios) {
        System.out.println("-----Lista de funcionários registrada-----");
        for (Usuario u : listaUsuarios) {
            System.out.println(u);
        }

        System.out.println("Escolha um identificador para realizar seu login: ");
        int id = in.nextInt();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (id == listaUsuarios.get(i).getId()) {
                usuarioAtual = listaUsuarios.get(i);
                return true;
            }
        }
        return false;

    }

    private void realizarPedido(Usuario usuarioAtual) {
        // Dados de Entrada do pedido
        System.out.println("Descrição do item: ");
        String descricao = in.nextLine();
        System.out.println("Valor unitário: ");
        double valorUni = in.nextDouble();
        System.out.println("Quantidade: ");
        int quant = leInteiro();

        // Local Date
        LocalDate date = LocalDate.now();
        // Criando pedido e item
        Pedido pedido = new Pedido(usuarioAtual, date);
        Item item = new Item(descricao, valorUni, quant);

        // Adicionando um item ao pedido
        pedido.addItem(item);

        // Adicionando um pedido ao historico
        historico.adicionarPedido(pedido);

        // Validacao do Valor maximo do pedido
        Departamento dpUsuario = usuarioAtual.getDepartamento();
        double valorMax = dpUsuario.getValorMaximoPedido();
        if (pedido.getValorTotal() < valorMax)
            System.out.format("Valor total do pedido: %s%n", pedido.getValorTotal());
        else
            System.out.println("Valor total do pedido excedido. Erro ao cadastrá-lo");
    }

    private void mostraMenuFuncionario() {
        System.out.println("[0] - Encerrar menu");
        System.out.println("[1] - Trocar de Usuário");
        System.out.println("[2] - Solicitar pedido");
        System.out.println("[3] - Excluir pedido");
    }

    private void escolhaUsuario() {
        System.out.println("Escolha entre Funcionário ou Administrador: ");
        System.out.println("[1] - Administrador");
        System.out.println("[2] - Funcionário");
    }

    private int leInteiro() {
        boolean ok = false;
        int numero = -1;
        while (!ok) {
            try {
                numero = in.nextInt();
                ok = true;
            } catch (Exception e) {
                System.out.println("Entrada invalida. Digite um numero inteiro");
            } finally {
                String aux = in.nextLine();
            }
        }
        return numero;
    }

    private boolean aprovaReprovaPedido() {
        ArrayList<Pedido> listaPedido = historico.getListaPedidos();

        if (listaPedido.size() == 0) {
            System.out.println("Não há pedidos cadastrados");
            return false;
        }

        System.out.println("Pedidos em aberto:");
        for (Pedido p : listaPedido) {
            if (p.getStatus().equalsIgnoreCase("aberto")) {
                System.out.println(p);
            }
        }

        System.out.println("Informe o id do pedido a ser aprovado ou reprovado");
        int id = in.nextInt();
        Pedido pedido = null;
        for (Pedido p : listaPedido) {
            if (p.getIdPedido() == id)
                pedido = p;
        }
        if (pedido == null) {
            System.out.println("Nenhum pedido encontrado com este Id");
            return false;
        }
        System.out.format("Você deseja aprovar ou reprovar o pedido: %n%s%n", pedido);
        System.out.println("[1] - Aprovar      [2] - Reprovar");
        int op = in.nextInt();
        switch (op) {
        case 1:
            if (pedido.getStatus().equalsIgnoreCase("aberto")) {
                pedido.setStatus("APROVADO");
                return true;
            } else {
                System.out.println("Erro, apenas pedidos abertos podem ser aprovados ou reprovados!");
                return false;
            }
        case 2:
            if (pedido.getStatus().equalsIgnoreCase("aberto")) {
                pedido.setStatus("REPROVADO");
                return true;
            } else {
                System.out.println("Erro, apenas pedidos abertos podem ser aprovados ou reprovados!");
                return false;
            }
        default:
            System.out.println("Opcão inválida!");
            return false;
        }
    }

    private boolean adicionaUsuario() {
        System.out.println("Digite o nome do novo usuário:");
        String nome = in.nextLine();

        boolean admin = false;
        System.out.println("O novo usuário é administrador?");
        System.out.println("[1] - Sim      [2] - Não");
        int op = in.nextInt();
        switch (op) {
        case 1:
            admin = true;
            break;
        case 2:
            admin = false;
            break;
        default:
            System.out.println("Opcão inválida!");
        }

        Departamento depart = null;
        System.out.println("Digite o departamento do novo usuário");
        System.out.println("[1] - Financeiro");
        System.out.println("[2] - RH");
        System.out.println("[3] - Engenharia");
        System.out.println("[4] - Administração");
        System.out.println("[5] - Marketing");
        op = in.nextInt();
        switch (op) {
        case 1:
            depart = this.departamentos.get(0);
            break;

        case 2:
            depart = this.departamentos.get(1);
            break;

        case 3:
            depart = this.departamentos.get(2);
            break;

        case 4:
            depart = this.departamentos.get(3);
            break;

        case 5:
            depart = this.departamentos.get(4);
            break;

        default:
            System.out.println("Opcão inválida!");
        }

        Usuario novo = new Usuario(nome, admin, depart);

        if (admin) {
            listaUsuariosAdmin.add(novo);
            return true;
        } else {
            listaUsuarios.add(novo);
            return true;
        }
    }

}
