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
        Funcionario f1 = new Funcionario(1, "Paula", d1);
        Funcionario f2 = new Funcionario(2, "Alfredo", d2);
        Funcionario f3 = new Funcionario(3, "Amanda", d3);
        Funcionario f4 = new Funcionario(4, "Francisco", d4);
        Funcionario f5 = new Funcionario(5, "Lucas", d5);
        Funcionario f6 = new Funcionario(6, "Coraline", d1);
        Funcionario f7 = new Funcionario(7, "Augusta", d2);
        Funcionario f8 = new Funcionario(8, "Catarina", d3);
        Funcionario f9 = new Funcionario(9, "Cláudio", d4);
        Funcionario f10 = new Funcionario(10, "Mauro Lúcio", d5);
        Funcionario f11 = new Funcionario(11, "Adalberto", d5);
        Funcionario f12 = new Funcionario(12, "Henrique", d4);
        Funcionario f13 = new Funcionario(13, "Jasmin", d3);
        Funcionario f14 = new Funcionario(14, "Luiza", d2);
        Funcionario f15 = new Funcionario(15, "Alice", d1);
        Funcionario f16 = new Funcionario(16, "Sergio", d5);
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
