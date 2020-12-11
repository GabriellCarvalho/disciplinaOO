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
public class Disciplina {
    private String nome;
    private int semestre;
    private String horario;
    private Professor professor;
    private Aluno[] alunos; 

    public Disciplina(){
        this.nome = "";
        this.semestre = 0;
        this.horario = "";
        this.professor = new Professor();
        this.alunos = new Aluno[10];
        for(int i=0;i<=9;i++)
            this.alunos[i] = new Aluno();
    }
    
    public Disciplina(int numAlunos){
        this.nome = "";
        this.semestre = 0;
        this.horario = "";
        this.professor = new Professor();
        this.alunos = new Aluno[numAlunos];
        for(int i=0;i<numAlunos;i++)
            this.alunos[i]= new Aluno();
    }
    
    public void preencher(){
        Scanner ler = new Scanner(System.in);
        System.out.println("***** Preenchendo disciplina *****");
        System.out.print("Nome: ");
        this.nome = ler.next();
        System.out.print("Semestre: ");
        this.semestre = ler.nextInt();
        System.out.print("Horario: ");
        this.horario = ler.next();
        this.getProfessor().preencher();
        int aux = this.getAlunos().length;
        for(int i=0;i<aux;i++)
            this.getAlunos()[i].preencher();
    }
    
    public void imprimir(){
        System.out.println("----- Dados da disciplina -----");
        System.out.println("Nome: "+ this.nome);
        System.out.println("Semestre: "+ this.semestre);     
        System.out.println("Horario: "+ this.horario);
        this.getProfessor().imprimir();
        int aux = this.getAlunos().length;
        for(int i=0;i<aux;i++)
            this.getAlunos()[i].imprimir();
        System.out.println("-------------------------------");
    }
    
    public void copiar(Disciplina outro){
        this.nome = outro.getNome();
        this.semestre = outro.getSemestre();
        this.horario = outro.getHorario();
        this.professor = outro.getProfessor();
        this.alunos = outro.getAlunos();
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
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return the alunos
     */
    public Aluno[] getAlunos() {
        return alunos;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }
    
    
    
}
