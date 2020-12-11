/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classes.Aluno;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class FrAluno extends javax.swing.JFrame {

    private List<Aluno> lista;
    private Aluno alunoEditando;

    /**
     * Creates new form FrAluno
     */
    public FrAluno() {
        initComponents();
        this.lista = new ArrayList<>();
        this.alunoEditando = null;
        this.habilitarCampos(false);
        this.limparCampos();
        this.loadAluno();
    }

    public void habilitarCampos(boolean flag) {
        this.edtNome.setEnabled(flag);
        this.edtIdade.setEnabled(flag);
        this.edtSexo.setEnabled(flag);
        this.edtMatricula.setEnabled(flag);
        this.edtAnodeIngresso.setEditable(flag);
    }

    public void limparCampos() {
        this.edtNome.setText("");
        this.edtIdade.setText("");
        this.edtSexo.setText("");
        this.edtMatricula.setText("");
        this.edtAnodeIngresso.setText("");
    }

    public Aluno camposParaObjeto() {
        Aluno a = new Aluno();
        a.setNome(this.edtNome.getText());
        int i = 0;
        String idadeStr = this.edtIdade.getText();
        if (!idadeStr.isEmpty()) {
            i = Integer.parseInt(idadeStr);
        }
        a.setIdade(i);
        String sexoStr = this.edtSexo.getText();
        if (!sexoStr.isEmpty()) {
            a.setSexo(sexoStr.charAt(0));
        }
        a.setMatricula(this.edtMatricula.getText());
        String anoDeIngressoStr = this.edtAnodeIngresso.getText();
        int j = 0;
        if (!anoDeIngressoStr.isEmpty()) {
            j = Integer.parseInt(anoDeIngressoStr);
        }
        a.setAnoDeIngresso(j);
        return a;
    }

    public String imprimirListaAluno() {
        String listagemTotal = "";
        for (int i = 0; i <= this.lista.size() - 1; i++) {
            listagemTotal = listagemTotal + this.lista.get(i).imprimirParaString();
        }
        return listagemTotal;
    }

    public Aluno pesquisaAluno(String matricula) {
        for (int i = 0; i <= this.lista.size() - 1; i++) {
            if (this.lista.get(i).getMatricula().equals(matricula)) {
                return this.lista.get(i);
            }
        }
        return null;
    }

    public void objetoParaCampos(Aluno a) {
        this.edtNome.setText(a.getNome());
        this.edtSexo.setText(a.getSexo() + "");
        this.edtIdade.setText(a.getIdade() + "");
        this.edtMatricula.setText(a.getMatricula());
        this.edtAnodeIngresso.setText(a.getAnoDeIngresso() + "");
    }
    public String criarListaAlunosCSV(){
        String texto = "";
        Aluno a = new Aluno();
        texto = a.cabecalho();
        for(int i=0;i<this.lista.size();i++){
            Aluno b = this.lista.get(i);
            texto = texto + b.atributoToCSV();
        }
        return texto;
    }

    public void salvarAluno(String texto){
        FileWriter arq = null;
        try {
            arq = new FileWriter("registroAluno.csv");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(texto);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loadAluno(){
        FileReader f = null;
        try {
            f = new FileReader("RegistroAluno.csv");
            Scanner arquivoLido = new Scanner(f);
            arquivoLido.useDelimiter("\n");
            this.lista = new ArrayList<>();
            String linhaLida = arquivoLido.next();
            while(arquivoLido.hasNext()){
                linhaLida = arquivoLido.next();
                Aluno a = new Aluno();
                a.CSVtoAtributo(linhaLida);
                this.lista.add(a);
                this.edtListagem.setText(this.imprimirListaAluno());
                try {
                    f.close();
                } catch (IOException ex) {
                    Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtIdade = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        edtMatricula = new javax.swing.JTextField();
        lblMatricula = new javax.swing.JLabel();
        edtSexo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        edtAnodeIngresso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtListagem = new javax.swing.JTextArea();

        jPasswordField1.setText("jPasswordField1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Aluno");
        lblTitulo.setToolTipText("");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblNome.setText("Nome:");

        lblIdade.setText("Idade:");

        lblSexo.setText("Sexo:");

        lblMatricula.setText("Matricula:");

        jLabel1.setText("Ano de Ingesso:");

        edtListagem.setColumns(20);
        edtListagem.setRows(5);
        jScrollPane1.setViewportView(edtListagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMatricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtAnodeIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatricula)
                    .addComponent(edtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(edtAnodeIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        this.habilitarCampos(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        String matriculaEscolhida = JOptionPane.showInputDialog("Informe a matricula do aluno que deseja editar: ", "");
        this.alunoEditando = this.pesquisaAluno(matriculaEscolhida);
        if (this.alunoEditando == null) {
            JOptionPane.showMessageDialog(this, "*Não existe aluno com esta matricula*");
        } else {
            this.limparCampos();
            this.habilitarCampos(true);
            this.objetoParaCampos(this.alunoEditando);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        String matriculaEscolhida = JOptionPane.showInputDialog("Informe a matricula do aluno que deseja excluir: ", "");
        Aluno a = this.pesquisaAluno(matriculaEscolhida);
        if (a == null) {
            JOptionPane.showMessageDialog(this, "*Não existe aluno com esta matricula*");
        } else {
            this.lista.remove(a);
        }
        this.edtListagem.setText(this.imprimirListaAluno());
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if (this.alunoEditando == null) {
            Aluno a = new Aluno();
            a = this.camposParaObjeto();
            this.lista.add(a);
        } else {
            this.lista.remove(this.alunoEditando);
            this.alunoEditando = this.camposParaObjeto();
            this.lista.add(this.alunoEditando);
        }
        this.limparCampos();
        this.habilitarCampos(false);
        this.edtListagem.setText(this.imprimirListaAluno());
        String texto = this.criarListaAlunosCSV();
        this.salvarAluno(texto);
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtAnodeIngresso;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextArea edtListagem;
    private javax.swing.JTextField edtMatricula;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
