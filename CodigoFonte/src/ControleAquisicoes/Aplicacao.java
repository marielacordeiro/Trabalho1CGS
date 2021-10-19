package ControleAquisicoes;

import java.util.Scanner;

public class Aplicacao
{
    private Scanner in;
    public Aplicacao()
    {
        in = new Scanner(System.in);
    }
    public void inicializa()
    {
        // inicializa os funcionarios no departamento
        Departamento d1 = new Departamento("Financeiro", 1000000);
        Departamento d2 = new Departamento("RH", 100000);
        Departamento d3 = new Departamento("Engenharia", 500000);
        Departamento d4 = new Departamento("Administracao", 2000000);
        Departamento d5 = new Departamento("Marketing", 600000);
        Usuario f1 = new Usuario("Paula", true);
        Usuario f2 = new Usuario("Alfredo", true);
        Usuario f3 = new Usuario("Amanda", true);
        Usuario f4 = new Usuario("Francisco", true);
        Usuario f5 = new Usuario("Lucas", false);
        Usuario f6 = new Usuario("Coraline", false);
        Usuario f7 = new Usuario("Augusta", false);
        Usuario f8 = new Usuario("Catarina", false);
        Usuario f9 = new Usuario("Cláudio", false);
        Usuario f10 = new Usuario("Mauro Lúcio", false);
        Usuario f11 = new Usuario("Adalberto", false);
        Usuario f12 = new Usuario("Henrique", false);
        Usuario f13 = new Usuario("Jasmin", false);
        Usuario f14 = new Usuario("Luiza", false);
        Usuario f15 = new Usuario("Alice", false);
        Usuario f16 = new Usuario("Sergio", false);
    }

    public void menu()
    {
        // Menu de selecao de usuario
         escolhaUsuario();
         int op = leInteiro();
         if (op == 1)
         {
             // menu de administrador
             mostraMenuAdm();
             op = leInteiro();
             switch (op)
             {
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
         else
         {
             // menu de funcionario
             mostraMenuFuncionario();
             op = leInteiro();
             switch (op)
             {
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

    public void mostraMenuAdm()
    {
        System.out.println("[0] - Encerrar menu");
        System.out.println("[1] - Solicitar Pedido");
        System.out.println("[2] - Listar todos os pedidos entre duas datas");
        System.out.println("[3] - Buscar pedidos por funcionário solicitante");
        System.out.println("[4] - Buscar pedidos pela descrição de um item");
        System.out.println("[5] - Visualizar os detalhes de um pedido");
        System.out.println("[x] - Trocar de Usuario");
    }

    public void mostraMenuFuncionario()
    {
        System.out.println("[0] - Encerrar menu");
        System.out.println("[1] - Solicitar Pedido");
        System.out.println("[x] - Trocar de Usuario");
    }

    private void escolhaUsuario()
    {
        System.out.println("Escolha entre Funcionário ou Administrador: ");
        System.out.println("[1] - Administrador");
        System.out.println("[2] - Funcionário");
    }

    private int leInteiro()
    {
        boolean ok = false;
        int numero = -1;
        while(!ok)
        {
            try
            {
                numero = in.nextInt();
                ok = true;
            }
            catch (Exception e)
            {
                System.out.println("Entrada invalida. Digite um numero inteiro");
            }
            finally
            {
                String aux = in.nextLine();
            }
        }
        return numero;
    }
}
