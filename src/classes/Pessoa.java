/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Pessoa {
    protected String nome;
    protected char sexo;
    protected int idade;
    
    protected Pessoa(){
        this.nome = "";
        this.sexo = ' ';
        this.idade = 0;
    }

    protected void imprimir(){
        System.out.println("Nome: "+ this.nome); 
        System.out.println("Sexo: "+ this.sexo);
        System.out.println("Idade: "+ this.idade);
    }
    
    protected void preencher(){
        Scanner ler = new Scanner(System.in);
        System.out.print("Nome: ");
        this.nome = ler.next();
        System.out.print("Sexo: ");
        this.sexo = ler.next().charAt(0);
        System.out.print("Idade: ");
        this.idade = ler.nextInt();
    }
    
    protected void copiar(Pessoa p){
        this.nome = p.getNome();
        this.sexo = p.getSexo();
        this.idade = p.getIdade();
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }


    
   
    
}
