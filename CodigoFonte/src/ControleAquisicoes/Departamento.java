package ControleAquisicoes;

import java.util.ArrayList;

public class Departamento

{
    private String nome;
    private double valorMaximoPedido;
    private ArrayList<Funcionario> funcionarios;

    
    public Departamento(String nome, double valorMaximoPedido) {
        this.nome = nome;
        this.valorMaximoPedido = valorMaximoPedido;
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public void addFuncionario(Funcionario funcionario) throws IllegalArgumentException{

        //Valida se não estamos adicionando o mesmo funcionário novamente
        if(funcionarios.contains(funcionario)){
            throw new IllegalArgumentException();
        }

        this.funcionarios.add(funcionario);
    }

    public String getNome(){
        return this.nome;
    }

    public double getValorMaximoPedido(){
        return this.valorMaximoPedido;
    }

}
