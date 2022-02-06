/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Aluno;
import Classes.AlunoDAO;
import Classes.Curso;
import Classes.CursoDAO;
import Classes.MatriculaCurso;
import Classes.MatriculaCursoDAO;
import Classes.Usuario;
import Classes.UsuarioDAO;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emanoel
 */
public class InterfaceRelatório extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterfaceRelatório
     */
    
    ArrayList<?> array = null;

    int tipo;
    String[][] dadosLinhas;
    String colunas[];
    JTextField jtf = null;
    JInternalFrame frame;
    
    public InterfaceRelatório() {
        initComponents();
    }
    
    public InterfaceRelatório(int tipo) {
        this.tipo = tipo;
        if (tipo==0){
            AlunoDAO alunoDAO = new AlunoDAO();
            array = (ArrayList<Aluno>)alunoDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Matricula", "Nome", "CPF", "Email", "CEP", "Cidade", "UF"};
        }
        if (tipo==1){
            CursoDAO cursoDAO = new CursoDAO();
            array = (ArrayList<Curso>) cursoDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Codigo", "Nome", "Carga Hor.", "Nome Prof."};
        }
        if (tipo==2){
            MatriculaCursoDAO matriculaDAO = new MatriculaCursoDAO();
            array = (ArrayList<MatriculaCurso>) matriculaDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Codigo", "Mat. Aluno", "Cod. Curso", "Data Mat."};
        }
        if (tipo==3){
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            array = (ArrayList<Usuario>) usuarioDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Login", "Nome", "Email"};
        }
        initComponents();
    }
    
    public InterfaceRelatório(int tipo, JTextField jtf) {
        this.tipo = tipo;
        this.jtf = jtf;
        if (tipo==0){
            AlunoDAO alunoDAO = new AlunoDAO();
            array = (ArrayList<Aluno>)alunoDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Matricula", "Nome", "CPF", "Email", "CEP", "Cidade", "UF"};
        }
        if (tipo==1){
            CursoDAO cursoDAO = new CursoDAO();
            array = (ArrayList<Curso>) cursoDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Codigo", "Nome", "Carga Hor.", "Nome Prof."};
        }
        if (tipo==2){
            MatriculaCursoDAO matriculaDAO = new MatriculaCursoDAO();
            array = (ArrayList<MatriculaCurso>) matriculaDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Codigo", "Mat. Aluno", "Cod. Curso", "Data Mat."};
        }
        if (tipo==3){
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            array = (ArrayList<Usuario>)usuarioDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Login", "Nome", "Email"};
        }
        initComponents();
    }
    
    public InterfaceRelatório(int tipo, JInternalFrame frame) {
        this.tipo = tipo;
        if (tipo==0){
            AlunoDAO alunoDAO = new AlunoDAO();
            array = (ArrayList<Aluno>)alunoDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Matricula", "Nome", "CPF", "Email", "CEP", "Cidade", "UF"};
            this.frame = (InterfaceCadastroAluno)frame;
        }
        if (tipo==1){
            CursoDAO cursoDAO = new CursoDAO();
            array = (ArrayList<Curso>) cursoDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Codigo", "Nome", "Carga Hor.", "Nome Prof."};
            this.frame = (InterfaceCadastroCurso)frame;
        }
        if (tipo==2){
            MatriculaCursoDAO matriculaDAO = new MatriculaCursoDAO();
            array = (ArrayList<MatriculaCurso>) matriculaDAO.listarDados();
            this.dadosLinhas = preencher(array);
            this.colunas = new String[]{"Codigo", "Mat. Aluno", "Cod. Curso", "Data Mat."};
            this.frame = (InterfaceCadastroMatricula)frame;
        }
        initComponents();
    }
    
    
    private String[][] preencher(ArrayList<?> array){
        String[][] dadosLinhas = null;
        if (this.tipo==0) {
            ArrayList<Aluno> arrayAlunos = (ArrayList<Aluno>)array;
            dadosLinhas = new String[(arrayAlunos.size())][7];
            for (int i = 0; i < arrayAlunos.size(); i++) {
                dadosLinhas[i][0] = String.valueOf(arrayAlunos.get(i).getNumMatricula());
                dadosLinhas[i][1] = arrayAlunos.get(i).getNome();
                dadosLinhas[i][2] = arrayAlunos.get(i).getCpf();
                dadosLinhas[i][3] = arrayAlunos.get(i).getEmail();
                dadosLinhas[i][4] = arrayAlunos.get(i).getCep();
                dadosLinhas[i][5] = arrayAlunos.get(i).getCidade();
                dadosLinhas[i][6] = arrayAlunos.get(i).getUF();
            }
        }
        if (this.tipo==1) {
            ArrayList<Curso> arrayCurso = (ArrayList<Curso>)array;
            dadosLinhas = new String[(arrayCurso.size())][4];
            for (int i = 0; i < arrayCurso.size(); i++) {
                dadosLinhas[i][0] = String.valueOf(arrayCurso.get(i).getCod());
                dadosLinhas[i][1] = arrayCurso.get(i).getNome();
                dadosLinhas[i][2] = String.valueOf(arrayCurso.get(i).getCargaHoraria());
                dadosLinhas[i][3] = arrayCurso.get(i).getNomeProf();
            }
        }
        if (this.tipo==2) {
            ArrayList<MatriculaCurso> arrayMatriculaCurso = (ArrayList<MatriculaCurso>)array;
            dadosLinhas = new String[(arrayMatriculaCurso.size())][4];
            for (int i = 0; i < arrayMatriculaCurso.size(); i++) {
                dadosLinhas[i][0] = String.valueOf(arrayMatriculaCurso.get(i).getCod());
                dadosLinhas[i][1] = String.valueOf(arrayMatriculaCurso.get(i).getNumMatriculaAluno());
                dadosLinhas[i][2] = String.valueOf(arrayMatriculaCurso.get(i).getCodigoCurso());
                dadosLinhas[i][3] = arrayMatriculaCurso.get(i).getDataMatricula();
            }
        }
        if (this.tipo==3) {
            ArrayList<Usuario> arrayUsuario = (ArrayList<Usuario>)array;
            dadosLinhas = new String[(arrayUsuario.size())][3];
            for (int i = 0; i < arrayUsuario.size(); i++) {
                dadosLinhas[i][0] = arrayUsuario.get(i).getLogin();
                dadosLinhas[i][1] = arrayUsuario.get(i).getNome();
                dadosLinhas[i][2] = arrayUsuario.get(i).getEmail();
            }
        }
        return dadosLinhas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtRelatorio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jbOK = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jtRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtRelatorio);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Código:");

        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });
        jtfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyTyped(evt);
            }
        });

        jbOK.setText("OK");
        jbOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOKActionPerformed(evt);
            }
        });

        jbFechar.setText("Voltar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("(Digite para filtrar os dados.)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbExcluir)
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbOK, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbFechar, jbOK});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbFechar)
                    .addComponent(jbOK)
                    .addComponent(jbExcluir)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOKActionPerformed
        if (jtf==null){
            if (frame == null ){
                this.dispose();
            }
            else{
                try {
                    if (this.tipo == 0) {
                        InterfaceCadastroAluno form = (InterfaceCadastroAluno) this.frame;
                        form.completar(jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 0).toString(), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 1).toString()), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 2).toString()), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 3).toString()), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 4).toString()), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 5)).toString(), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 6).toString()) );
                        this.dispose();
                    }
                    if (this.tipo == 1) {
                        InterfaceCadastroCurso form = (InterfaceCadastroCurso) this.frame;
                        form.completar(jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 0).toString(), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 1).toString()), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 2).toString()), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 3).toString()));
                        this.dispose();
                    }
                    if (this.tipo == 2) {
                        InterfaceCadastroMatricula form = (InterfaceCadastroMatricula) this.frame;
                        form.completar(jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 0).toString(), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 1).toString()), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 2).toString()), (jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 3).toString()));
                        this.dispose();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Nenhum Valor selecionado!");
                    return;
                }
            }
        }
        else{
            try {
                jtf.setText(jtRelatorio.getValueAt(jtRelatorio.getSelectedRow(), 0).toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nenhum Valor selecionado!");
                return;
            }
            this.dispose();
        }
    }//GEN-LAST:event_jbOKActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        DefaultTableModel model = new DefaultTableModel(this.dadosLinhas, this.colunas);
        jtRelatorio.setModel(model);
    }//GEN-LAST:event_formInternalFrameActivated

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jtfCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyTyped
        
    }//GEN-LAST:event_jtfCodigoKeyTyped

    private void jtfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyReleased
        if (tipo==0) {
            AlunoDAO alunoDAO = new AlunoDAO();
            if (!jtfCodigo.getText().isEmpty()) {
                try {
                    ArrayList array = alunoDAO.pesquisarAluno(Integer.parseInt(jtfCodigo.getText()));
                    String dadosLinhas2[][];
                    dadosLinhas2 = preencher(array);
                    DefaultTableModel model = new DefaultTableModel(dadosLinhas2, this.colunas);
                    jtRelatorio.setModel(model);
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "Valor Inválido!");
                    jtfCodigo.setText("");
                }
            } else {
                DefaultTableModel model = new DefaultTableModel(this.dadosLinhas, this.colunas);
                jtRelatorio.setModel(model);
            }
        }
        if (tipo==1) {
            CursoDAO cursoDAO = new CursoDAO();
            if (!jtfCodigo.getText().isEmpty()) {
                try {
                    ArrayList array = cursoDAO.pesquisarCurso(Integer.parseInt(jtfCodigo.getText()));
                    String dadosLinhas2[][];
                    dadosLinhas2 = preencher(array);
                    DefaultTableModel model = new DefaultTableModel(dadosLinhas2, this.colunas);
                    jtRelatorio.setModel(model);
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "Valor Inválido!");
                    jtfCodigo.setText("");
                }
            } else {
                DefaultTableModel model = new DefaultTableModel(this.dadosLinhas, this.colunas);
                jtRelatorio.setModel(model);
            }
        }
        if (tipo==2) {
            MatriculaCursoDAO matriculaDAO = new MatriculaCursoDAO();
            if (!jtfCodigo.getText().isEmpty()) {
                ArrayList array = null;
                try {
                    array = matriculaDAO.pesquisarMatriculaCurso(Integer.parseInt(jtfCodigo.getText()));
                    String dadosLinhas2[][];
                    dadosLinhas2 = preencher(array);
                    DefaultTableModel model = new DefaultTableModel(dadosLinhas2, this.colunas);
                    jtRelatorio.setModel(model);
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "Valor Inválido!");
                    jtfCodigo.setText("");
                }
            } else {
                DefaultTableModel model = new DefaultTableModel(this.dadosLinhas, this.colunas);
                jtRelatorio.setModel(model);
            }
        }
        if (tipo==3) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (!jtfCodigo.getText().isEmpty()) {
                ArrayList array = null;
                try {
                    array = usuarioDAO.pesquisarUsuario(jtfCodigo.getText());
                    String dadosLinhas2[][];
                    dadosLinhas2 = preencher(array);
                    DefaultTableModel model = new DefaultTableModel(dadosLinhas2, this.colunas);
                    jtRelatorio.setModel(model);
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "Valor Inválido!");
                    jtfCodigo.setText("");
                }
            } else {
                DefaultTableModel model = new DefaultTableModel(this.dadosLinhas, this.colunas);
                jtRelatorio.setModel(model);
            }
        }        
    }//GEN-LAST:event_jtfCodigoKeyReleased

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        if (tipo==0) {
            if (jtRelatorio.getSelectedRow() != -1) {
            AlunoDAO alunoDAO = new AlunoDAO();
            int linha = this.jtRelatorio.getSelectedRow();
            int cod = Integer.parseInt(jtRelatorio.getValueAt(linha, 0).toString());
                try {
                    boolean excluirAluno = alunoDAO.excluirAluno(cod);
                    DefaultTableModel model = (DefaultTableModel) jtRelatorio.getModel();
                    model.removeRow(linha);
                } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(this, "Seleção inválida.");
                } catch(IllegalArgumentException erro){
                JOptionPane.showMessageDialog(this, "Seleção inválida.");     
                } catch (Exception erro){
                JOptionPane.showMessageDialog(this, "Seleção inválida.");
                }
        }else {
              JOptionPane.showMessageDialog(this, "Selecione um aluno para excluir.");  
            }
        }
        if (tipo==1) {
            if (jtRelatorio.getSelectedRow() != -1) {
            CursoDAO cursoDAO = new CursoDAO();
            int linha = this.jtRelatorio.getSelectedRow();
            int cod = Integer.parseInt(jtRelatorio.getValueAt(linha, 0).toString());
                try {
                    boolean excluirCurso = cursoDAO.excluirCurso(cod);
                    DefaultTableModel model = (DefaultTableModel) jtRelatorio.getModel();
                    model.removeRow(linha);
                } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(this, "Seleção inválida.");
                } catch(IllegalArgumentException erro){
                JOptionPane.showMessageDialog(this, "Seleção inválida.");     
                } catch (Exception erro){
                JOptionPane.showMessageDialog(this, "Seleção inválida.");
                }
        }else {
              JOptionPane.showMessageDialog(this, "Selecione um curso para excluir.");  
            }
        }
        if (tipo==2) {
            if (jtRelatorio.getSelectedRow() != -1) {
            MatriculaCursoDAO matriculacursoDAO = new MatriculaCursoDAO();
            int linha = this.jtRelatorio.getSelectedRow();
            int cod = Integer.parseInt(jtRelatorio.getValueAt(linha, 0).toString());
                try {
                    boolean excluirMatriculaCurso = matriculacursoDAO.excluirMatriculaCurso(cod);
                    DefaultTableModel model = (DefaultTableModel) jtRelatorio.getModel();
                    model.removeRow(linha);
                } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(this, "Seleção inválida.");
                } catch(IllegalArgumentException erro){
                JOptionPane.showMessageDialog(this, "Seleção inválida.");     
                } catch (Exception erro){
                JOptionPane.showMessageDialog(this, "Seleção inválida.");
                }
        }else {
              JOptionPane.showMessageDialog(this, "Selecione uma matricula para excluir.");  
            }
        }
            if (tipo==3) {
            if (jtRelatorio.getSelectedRow() != -1) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            int linha = this.jtRelatorio.getSelectedRow();
            String login = jtRelatorio.getValueAt(linha, 0).toString();
                try {
                    boolean excluirUsuario = usuarioDAO.excluirUsuario(login);
                    DefaultTableModel model = (DefaultTableModel) jtRelatorio.getModel();
                    model.removeRow(linha);
                } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(this, "Seleção inválida.");
                } catch(IllegalArgumentException erro){
                JOptionPane.showMessageDialog(this, "Seleção inválida.");     
                } catch (Exception erro){
                JOptionPane.showMessageDialog(this, "Seleção inválida.");
                }
        }else {
              JOptionPane.showMessageDialog(this, "Selecione uma usuario para excluir.");  
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbOK;
    private javax.swing.JTable jtRelatorio;
    private javax.swing.JTextField jtfCodigo;
    // End of variables declaration//GEN-END:variables
}
