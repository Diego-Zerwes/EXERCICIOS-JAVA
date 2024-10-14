
package telas;

import dao.TarefasDao;
import javax.swing.*;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Tarefas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class telaTarefas extends javax.swing.JFrame {
        int vInsUpdate = 0;

    public telaTarefas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSituacao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Tarefas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nome");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel2.setText("Descrição");

        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyPressed(evt);
            }
        });

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataKeyPressed(evt);
            }
        });

        jLabel3.setText("Data de Vencimento");

        jLabel4.setText("Situação");

        jSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Concluida" }));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Situação", "Data de Vencimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });

        jLabel5.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(584, 584, 584)
                                .addComponent(btnSalvar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            txtDescricao.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            txtData.requestFocus();
        }
    }//GEN-LAST:event_txtDescricaoKeyPressed

    private void txtDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            jSituacao.requestFocus();
        }
    }//GEN-LAST:event_txtDataKeyPressed

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        if ((txtNome.getText().trim().isEmpty()) 
        || (txtDescricao.getText().trim().isEmpty())
        || (txtData.getText() == null) 
        || (jSituacao.getSelectedItem() == null)) {
        JOptionPane.showMessageDialog(null, "Dados Inválidos");
        txtNome.requestFocus();
    } else {
        if (vInsUpdate == 0) { 
            Object situacaoSelecionada = jSituacao.getSelectedItem();
            Date dataSelecionada = (Date) txtData.getValue();
            Tarefas produto = new Tarefas(
                txtNome.getText(),
                txtDescricao.getText(), 
                dataSelecionada,
                situacaoSelecionada.toString()
            );

            TarefasDao tarefasDAO = new TarefasDao();
            tarefasDAO.inserir(produto);

            TarefasDao CadastroTarefas = new TarefasDao();
            atualizaTabela(CadastroTarefas);

            JOptionPane.showMessageDialog(null, "Cadastro efetuado:\n" +  
                "ID: " + txtId.getText() + "\n" +
                "Nome: " + txtNome.getText() + "\n" +
                "Descrição: " + txtDescricao.getText() + "\n" +
                "Data: " + txtData.getText() + "\n" +
                "Situação: " + jSituacao.getSelectedItem() + "\n");

            int msgRetorno = JOptionPane.showConfirmDialog(null, 
                                  "Deseja limpar os campos?", 
                                  "Confirmação", 
                                  JOptionPane.YES_NO_OPTION); 
            if (msgRetorno == JOptionPane.YES_OPTION) {
                limparCampos();
            }
        } else {
            jTable1.setValueAt(txtId.getText(), jTable1.getSelectedRow(), 0); 
            jTable1.setValueAt(txtNome.getText(), jTable1.getSelectedRow(), 1);
            jTable1.setValueAt(txtDescricao.getText(), jTable1.getSelectedRow(), 2);
            jTable1.setValueAt(txtData.getText(), jTable1.getSelectedRow(), 3);           
            jTable1.setValueAt(jSituacao.getSelectedItem(), jTable1.getSelectedRow(), 4);

            try {
                String dataString = txtData.getText();  
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                Date dataVencimento = sdf.parse(dataString); 
                String nome = txtNome.getText();
                String descricao = txtDescricao.getText();
                String situacao = jSituacao.getSelectedItem().toString();
                Tarefas tarefa = new Tarefas(nome, descricao, dataVencimento, situacao);
                TarefasDao alterProduto = new TarefasDao();
                alterProduto.alterar(tarefa);

                limparCampos();
                vInsUpdate = 0;

                jTable1.enable(true);
                btnSalvar.setText("Cadastrar");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro no formato da data. Use o formato 'yyyy-MM-dd'.");
            }
        }
    }
     
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          TarefasDao CadastroTarefas = new TarefasDao();
        atualizaTabela(CadastroTarefas);
    }//GEN-LAST:event_formWindowOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if((jTable1.getSelectedRow() != -1) && (vInsUpdate == 0) && (evt.getClickCount() == 2)){
           txtId.setText(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
           txtNome.setText(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
           txtDescricao.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
           txtData.setText(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
           jSituacao.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
           
           vInsUpdate = 1;
           jTable1.enable(false);
           btnSalvar.setText("Alterar");
           txtId.setEnabled(false);
        }  
    }//GEN-LAST:event_jTable1MouseClicked
    private void limparCampos()
    {
        this.txtNome.setText("");
        this.txtDescricao.setText(null);
         if (txtData instanceof JFormattedTextField) {
        ((JFormattedTextField)txtData).setValue(null); 
    } else {
        this.txtData.setText("");  
    }
    
    this.jSituacao.setSelectedIndex(-1);   
    }
    private void atualizaTabela(TarefasDao cadastroTarefa)
    {
        

                try
                {
                    limparTabela();
                    ArrayList<Tarefas> listaCadastros;
                    listaCadastros = cadastroTarefa.consultar();      
                    DefaultTableModel modeloTabela = (DefaultTableModel) jTable1.getModel();

                    for(Tarefas cadastroT : listaCadastros)
                    {
                       
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                        String dataFormatada = (cadastroT.getDataVencimento() != null) ? sdf.format(cadastroT.getDataVencimento()) : ""; 

                       
                        modeloTabela.addRow(new String[]{Integer.toString(cadastroT.getIdTarefa()), 
                                                                            cadastroT.getNome(), 
                                                                            cadastroT.getDescricao(), 
                                                                            dataFormatada,
                                                                            cadastroT.getSituacao()});
                        
                    }
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
                }
     
    }
    
    private void limparTabela()
    {
        while(jTable1.getRowCount() > 0) 
        {
            DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
            dm.getDataVector().removeAllElements();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaTarefas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaTarefas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaTarefas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaTarefas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaTarefas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jSituacao;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
