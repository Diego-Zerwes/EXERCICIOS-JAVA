
package telas;

import dao.CadastroContatoDao;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import model.CadastroContato;

/**
 *
 * @author difoz
 */
public class cadastro extends javax.swing.JFrame {
    int vInsUpdate = 0;
    
    public cadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("ID");

        txtId.setEditable(false);

        jLabel2.setText("Nome");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel3.setText("E-mail");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        jLabel4.setText("Endereço");

        txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEnderecoKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "E-mail", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseClicked(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel5.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        jLabel6.setText("Telefone");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addGap(88, 88, 88)
                        .addComponent(btnCadastrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnExcluir)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            txtEndereco.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoKeyPressed
         if(evt.getExtendedKeyCode() == evt.VK_ENTER){
            txtTelefone.requestFocus();
        }
    }//GEN-LAST:event_txtEnderecoKeyPressed

    private void btnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseClicked
         if (txtNome.getText().trim().isEmpty() 
        || txtEmail.getText().trim().isEmpty() 
        || txtEndereco.getText().trim().isEmpty()
        || txtTelefone.getText().trim().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "Dados Inválidos");
        txtNome.requestFocus();
    } else {
        CadastroContatoDao produtoDAO = new CadastroContatoDao();

        if (vInsUpdate == 0) { 
            CadastroContato produto = new CadastroContato(
                txtNome.getText(),
                txtTelefone.getText(), 
                txtEmail.getText(), 
                txtEndereco.getText()
            );

            try {
                produtoDAO.inserir(produto);
                atualizaTabela(produtoDAO);
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");

                int msgRetorno = JOptionPane.showConfirmDialog(null, 
                    "Deseja limpar os campos?", 
                    "Confirmação", 
                    JOptionPane.YES_NO_OPTION); 
                
                if (msgRetorno == JOptionPane.YES_OPTION) {
                    limparCampos();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
            }

        } else { 
            jTable1.setValueAt(txtId.getText(), jTable1.getSelectedRow(), 0);
            jTable1.setValueAt(txtNome.getText(), jTable1.getSelectedRow(), 1);
            jTable1.setValueAt(txtEmail.getText(), jTable1.getSelectedRow(), 2);
            jTable1.setValueAt(txtEndereco.getText(), jTable1.getSelectedRow(), 3);           
            jTable1.setValueAt(txtTelefone.getText(), jTable1.getSelectedRow(), 4);

            CadastroContato contato = new CadastroContato(
                Integer.parseInt(txtId.getText()),
                txtNome.getText(),
                txtTelefone.getText(), 
                txtEmail.getText(), 
                txtEndereco.getText()
            );

            try {
                produtoDAO.alterar(contato);
                limparCampos();
                vInsUpdate = 0;
                jTable1.setEnabled(true);
                btnCadastrar.setText("Cadastrar");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
            }
        }
    }
    }//GEN-LAST:event_btnCadastrarMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(jTable1.getSelectedRow() != -1){
          int msgRetorno = JOptionPane.showConfirmDialog(null, 
                                      "Confirme para remover o cadastro", 
                                      "Confirmação", 
                                      JOptionPane.YES_NO_OPTION); 
                if (msgRetorno == JOptionPane.YES_OPTION) {
                    int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());

                    CadastroContatoDao contatoDAO = new CadastroContatoDao();
                    contatoDAO.excluirId(id);
                    DefaultTableModel tbcadastro = (DefaultTableModel) jTable1.getModel();
                    tbcadastro.removeRow(jTable1.getSelectedRow());  
                    limparCampos();
                } 
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Cadastro para excluir!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txtEmail.getText())))
        {
            JOptionPane.showMessageDialog(null, "Por favor, digite um e-mail válido", "Error", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        CadastroContatoDao cadastroPDao = new CadastroContatoDao();        
        buscarNome(cadastroPDao);
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       if((jTable1.getSelectedRow() != -1) && (vInsUpdate == 0) && (evt.getClickCount() == 2)){
        txtId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());    // ID
        txtNome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());  // Nome
        txtTelefone.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()); // Telefone
        txtEmail.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()); // Email
        txtEndereco.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString()); // Endereço
           
           vInsUpdate = 1;
           jTable1.enable(false);
           btnCadastrar.setText("Alterar");
           txtId.setEnabled(false);
        }   
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         CadastroContatoDao CadastroContato = new CadastroContatoDao();
        atualizaTabela(CadastroContato);
    }//GEN-LAST:event_formWindowOpened

    private void limparCampos()
    {

        this.txtId.setEnabled(true);
        this.txtId.setText("");
        this.txtNome.setText("");
        this.txtEmail.setText(null);
        this.txtEndereco.setText(null);
        this.txtTelefone.setText(null);
    }
    
    private void atualizaTabela(CadastroContatoDao cadastroCont)
    {
        

                try
                {
                    limparTabela();
                    ArrayList<CadastroContato> listaCadastros;
                    listaCadastros = cadastroCont.consultar();      
                    DefaultTableModel modeloTabela = (DefaultTableModel) jTable1.getModel();

                    for(CadastroContato cadastroP : listaCadastros)
                    {
                        modeloTabela.addRow(new String[]{Integer.toString(cadastroP.getIdAgenda()), 
                                                                            cadastroP.getNome(), 
                                                                            cadastroP.getTelefone(), 
                                                                            cadastroP.getEmail(),
                                                                            cadastroP.getEndereco()});
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
    
    private void buscarNome(CadastroContatoDao cadastroCDao)
    {
     
     
            try
            {

                limparTabela();

                ArrayList<CadastroContato> listaCadastrosStr;
                listaCadastrosStr = cadastroCDao.consultar(txtBuscar.getText());           
                DefaultTableModel modeloTabela = (DefaultTableModel) jTable1.getModel();

                for(CadastroContato cadastroP : listaCadastrosStr)
                {
                    modeloTabela.addRow(new String[]{Integer.toString(    cadastroP.getIdAgenda()), 
                                                                            cadastroP.getNome(), 
                                                                            cadastroP.getTelefone(), 
                                                                            cadastroP.getEmail(),
                                                                            cadastroP.getEndereco()});
                }

            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
