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
public class Professor extends Pessoa{
    private String cpf;
    
    public Professor(){
        super();
        this.cpf = "000.000.000-00";
    }
    
    @Override
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        System.out.println("***** Preenchendo profesor *****");
        super.preencher();
        System.out.print("Informe o cpf: ");
        this.cpf = ler.next();
    }
    
    @Override
    public void imprimir(){
        System.out.println("----- Dados do professor -----");
        super.imprimir();
        System.out.println("CPF: "+ this.cpf);
        System.out.println("------------------------------");
    }
    
    public String imprimirParaString(){
        String saida = "";
        saida = "----- Dados do professor -----\n"
        +"Nome: "+ super.nome +"\n" 
        +"Sexo: "+ super.sexo +"\n"
        +"Idade: "+ super.idade +"\n"
        +"CPF: "+ this.cpf +"\n"
        +"------------------------------\n";
        return saida;
    }
    
    
    public void copiar(Professor outro){
        super.copiar(outro);
        this.cpf = outro.getCpf();
    }
    
    public String cabecalho(){
        return "Nome;Sexo;Idade;CPF;\n";
    }
    
    public String atributoToCSV(){
        String retorno = "";
        retorno = super.nome + ";" + super.sexo + ";" + super.idade + ";" + this.cpf + ";"+"\n";
        return retorno;
    }
    public void CSVtoAtributo(String csv){
        String vetor[] = csv.split(";");
        this.nome = vetor[0];
        this.sexo = vetor[1].charAt(0);
        this.idade = Integer.parseInt(vetor[2]);
        this.cpf = vetor[3];
    }
    
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
