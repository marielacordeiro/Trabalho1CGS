package ControleAquisicoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private Scanner in;
    private List<Usuario> listaUsuarios;
    private List<Usuario> listaUsuariosAdmin;
    private Usuario usuarioAtual;

    public Aplicacao() {
        in = new Scanner(System.in);
        listaUsuarios = new ArrayList<>();
        listaUsuariosAdmin = new ArrayList<>();
    }

    public void inicializa() {
        // inicializa os funcionarios no departamento
        Departamento d1 = new Departamento("Financeiro", 1000000);
        Departamento d2 = new Departamento("RH", 100000);
        Departamento d3 = new Departamento("Engenharia", 500000);
        Departamento d4 = new Departamento("Administracao", 2000000);
        Departamento d5 = new Departamento("Marketing", 600000);
        Usuario u1 = new Usuario("Paula", true);
        listaUsuariosAdmin.add(u1);
        Usuario u2 = new Usuario("Alfredo", true);
        listaUsuariosAdmin.add(u2);
        Usuario u3 = new Usuario("Amanda", true);
        listaUsuariosAdmin.add(u3);
        Usuario u4 = new Usuario("Francisco", true);
        listaUsuariosAdmin.add(u4);
        Usuario u5 = new Usuario("Lucas", false);
        listaUsuarios.add(u5);
        Usuario u6 = new Usuario("Coraline", false);
        listaUsuarios.add(u6);
        Usuario u7 = new Usuario("Augusta", false);
        listaUsuarios.add(u7);
        Usuario u8 = new Usuario("Catarina", false);
        listaUsuarios.add(u8);
        Usuario u9 = new Usuario("Cláudio", false);
        listaUsuarios.add(u9);
        Usuario u10 = new Usuario("Mauro Lúcio", false);
        listaUsuarios.add(u10);
        Usuario u11 = new Usuario("Adalberto", false);
        listaUsuarios.add(u11);
        Usuario u12 = new Usuario("Henrique", false);
        listaUsuarios.add(u12);
        Usuario u13 = new Usuario("Jasmin", false);
        listaUsuarios.add(u13);
        Usuario u14 = new Usuario("Luiza", false);
        listaUsuarios.add(u14);
        Usuario u15 = new Usuario("Alice", false);
        listaUsuarios.add(u15);
        Usuario u16 = new Usuario("Sergio", false);
        listaUsuarios.add(u16);
    }

    public void menu() {
        // Menu de selecao de usuario
        escolhaUsuario();
        int op = leInteiro();
        if (op == 1) {
            // escolhe o adm atual
            escolheAdm(listaUsuariosAdmin);
            // menu de administrador
            mostraMenuAdm();
            op = leInteiro();
            switch (op) {
            case 0:
                break;
            case 1:
                // realizarPedido(usuarioAtual);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Opção Inválida");
                break;
            }
        } else {
            // escolhe o func atual
            escolheFunc(listaUsuarios);
            // menu de funcionario
            mostraMenuFuncionario();
            op = leInteiro();
            switch (op) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Opção Inválida");
                break;
            }
        }

    }

    public void mostraMenuAdm() {
        System.out.println("[0] - Encerrar menu");
        System.out.println("[1] - Solicitar Pedido");
        System.out.println("[2] - Listar todos os pedidos entre duas datas");
        System.out.println("[3] - Buscar pedidos por funcionário solicitante");
        System.out.println("[4] - Buscar pedidos pela descrição de um item");
        System.out.println("[5] - Visualizar os detalhes de um pedido");
        System.out.println("[x] - Trocar de Usuario");
    }

    public void escolheAdm(List<Usuario> listaUsuarioAdmin) {
        System.out.println("-----Lista de administradores registrada-----");
        for (Usuario u : listaUsuarioAdmin) {
            System.out.println(u);
        }

        System.out.println("Escolha um identificador para realizar seu login: ");
        int id = in.nextInt();
        for (int i = 0; i < listaUsuarioAdmin.size(); i++) {
            if (id == listaUsuarioAdmin.get(i).getId()) {
                usuarioAtual = listaUsuarioAdmin.get(i);
                System.out.println("Você está logado.");
                break;
            }
        }
    }

    public void escolheFunc(List<Usuario> listaUsuarios) {
        System.out.println("-----Lista de funcionários registrada-----");
        for (Usuario u : listaUsuarios) {
            System.out.println(u);
        }

        System.out.println("Escolha um identificador para realizar seu login: ");
        int id = in.nextInt();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (id == listaUsuarios.get(i).getId()) {
                usuarioAtual = listaUsuarios.get(i);
                System.out.println("Você está logado.");
                break;
            }
        }

    }

    // public boolean realizarPedido(Usuario usuarioAtual) {

    // }s
    // 8.

    // O sistema
    // deverá permitir
    // a um
    // administrador ver
    // estatísticas gerais contendo:8.1.
    // Número de
    // pedidos total, divididos
    // entre aprovados

    // e reprovados (com percentuais).
    // 8.2. Número de pedidos nos últimos 30 dias e seu valor médio.
    // 8.3. Valor total de cada categoria nos últimos 30 dias.
    // 8.4. Detalhes do pedido de aquisição de maior valor ainda aberto.

    // public void

    public void mostraMenuFuncionario() {
        System.out.println("[0] - Encerrar menu");
        System.out.println("[1] - Solicitar Pedido");
        System.out.println("[x] - Trocar de Usuario");
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
}
