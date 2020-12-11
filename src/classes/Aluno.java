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
public class Aluno extends Pessoa{
    private String matricula;
    private int anoDeIngresso;
    
    public Aluno(){
        super();
        this.matricula = "00000";
        this.anoDeIngresso = 1000;
    }
    
    @Override
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        System.out.println("***** Preenchendo aluno *****");
        super.preencher();
        System.out.print("Matricula: ");
        this.matricula = ler.next();
        System.out.print("Ano de ingresso: ");
        this.anoDeIngresso = ler.nextInt();
    }
    
    @Override
    public void imprimir(){
        System.out.println("------- Dados do aluno -------");
        super.imprimir();
        System.out.println("Matricula: "+ this.matricula);
        System.out.println("Ano de ingresso: "+ this.anoDeIngresso);
        System.out.println("------------------------------");
    }
    public String imprimirParaString(){
        String saida = "";
        saida = "------- Dados do aluno -------\n"
        +"Nome: "+ super.nome+"\n"
        +"Sexo: "+ super.sexo+"\n"
        +"Idade: "+ super.idade+"\n"
        +"Matricula: "+ this.matricula+"\n"
        +"Ano de ingresso: "+ this.anoDeIngresso+"\n"
        +"------------------------------\n";
        return saida;
    }
    
    public void copiar(Aluno outro){
        super.copiar(outro);
        this.matricula = outro.getMatricula();
        this.anoDeIngresso = outro.getAnoDeIngresso();
    }
    
    public String cabecalho(){
        return "Nome;SExo;Idade;Matricula;Ano de ingresso;\n";
    }
    
    public String atributoToCSV(){
        String retorno = new String();
        retorno = super.nome + ";" + super.sexo + ";" + super.idade + ";" + this.matricula + ";"+ this.anoDeIngresso+";"+"\n";
        return retorno;
    }
    
    public void CSVtoAtributo(String csv){
        String vetor[] = csv.split(";");
        this.nome = vetor[0];
        this.sexo = vetor[1].charAt(0);
        this.idade = Integer.parseInt(vetor[2]);
        this.matricula = vetor[3];
        this.anoDeIngresso = Integer.parseInt(vetor[4]);
    }
    
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the anoDeIngresso
     */
    public int getAnoDeIngresso() {
        return anoDeIngresso;
    }

    /**
     * @param anoDeIngresso the anoDeIngresso to set
     */
    public void setAnoDeIngresso(int anoDeIngresso) {
        this.anoDeIngresso = anoDeIngresso;
    }

    
}
