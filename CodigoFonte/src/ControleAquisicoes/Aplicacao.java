package ControleAquisicoes;

import java.util.Scanner;

public class Aplicacao
{
    private Scanner in = new Scanner(System.in);
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

    public void mostraMenuFuncionario()
    {
        System.out.println("[0] - Encerrar menu");
        System.out.println("[1] - Solicitar Pedido");
        System.out.println("[x] - Trocar de Usuario");
    }

}
