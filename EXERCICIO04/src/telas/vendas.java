/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package telas;

import dao.CadastroProdutoDao;
import dao.VendaProdutoDao;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import model.CadastroProduto;
import model.VendaProduto;

/**
 *
 * @author difoz
 */
public class vendas extends javax.swing.JInternalFrame {
    int vInsUpdate = 0;
    private CadastroProduto produtoAtual;
  
    public vendas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscarVenda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jValorTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaCarrinho = new javax.swing.JTable();
        btnComprar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Buscar");

        txtBuscarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarVendaActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Valor Total");

        jValorTotal.setEditable(false);
        jValorTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTabelaCarrinho);
        if (jTabelaCarrinho.getColumnModel().getColumnCount() > 0) {
            jTabelaCarrinho.getColumnModel().getColumn(0).setResizable(false);
            jTabelaCarrinho.getColumnModel().getColumn(1).setResizable(false);
            jTabelaCarrinho.getColumnModel().getColumn(2).setResizable(false);
            jTabelaCarrinho.getColumnModel().getColumn(3).setResizable(false);
        }

        btnComprar.setText("Comprar");
        btnComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar Compra");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnComprar)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprar)
                    .addComponent(btnCancelar))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarVendaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       if((jTable1.getSelectedRow() != -1) && (vInsUpdate == 0) && (evt.getClickCount() == 2)){
        String idProduto = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String nomeProduto = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String valorProduto = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String estoqueDisponivel = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String quantidadeCompra = JOptionPane.showInputDialog(this, "Digite a quantidade desejada:", "Quantidade", JOptionPane.PLAIN_MESSAGE);

        if (quantidadeCompra != null && !quantidadeCompra.isEmpty()) {
            try {
                int quantidade = Integer.parseInt(quantidadeCompra);
                int estoque = Integer.parseInt(estoqueDisponivel);
                
                if (quantidade > 0 && quantidade <= estoque) {
                    double valorUnitario = Double.parseDouble(valorProduto.replace(",", "."));
                    double valorTotal = valorUnitario * quantidade;

                    DefaultTableModel modeloTabelaCompra = (DefaultTableModel) jTabelaCarrinho.getModel();
                    modeloTabelaCompra.addRow(new Object[]{
                        idProduto,
                        nomeProduto,
                        quantidade,
                        valorTotal
                    });
                    
                    atualizaValorTotal();

                    this.produtoAtual = new CadastroProduto();
                    produtoAtual.setIdProduto(Integer.parseInt(idProduto));
                    produtoAtual.setNome(nomeProduto);
                    produtoAtual.setQuantidade(estoque - quantidade); 
                    produtoAtual.setValor(valorUnitario);
                } else {
                    JOptionPane.showMessageDialog(this, "Quantidade solicitada inválida ou maior que o estoque disponível!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para a quantidade!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
         limparTabelaCarrinho(); 
    JOptionPane.showMessageDialog(this, "Carrinho limpo!", "Cancelar", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMouseClicked
       if (this.produtoAtual != null) {
        CadastroProdutoDao updateDao = new CadastroProdutoDao();
        updateDao.alterar(produtoAtual);
        
        jTable1.setValueAt(produtoAtual.getQuantidade(), jTable1.getSelectedRow(), 2);
        
        VendaProduto venda = new VendaProduto();
        venda.setQuantVendida(produtoAtual.getQuantidade()); 
        venda.setValorTotal(atualizaValorTotal()); 
        venda.setIdProduto(produtoAtual.getIdProduto()); 

        VendaProdutoDao vendaDao = new VendaProdutoDao();
        vendaDao.inserir(venda);
        
        JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
        this.produtoAtual = null;
        limparTabelaCarrinho();
        JOptionPane.showMessageDialog(this, "Carrinho limpo!", "Cancelar", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um produto e adicione ao carrinho antes de comprar.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnComprarMouseClicked
public void atualizaTabela (CadastroProdutoDao cadastroProd)
    {
                try
                {
                    limparTabela();
                    ArrayList<model.CadastroProduto> listaCadastros;
                    listaCadastros = cadastroProd.consultar();      
                    DefaultTableModel modeloTabela = (DefaultTableModel) jTable1.getModel();

                    for(model.CadastroProduto cadastroP : listaCadastros)
                    {
                        modeloTabela.addRow(new String[]{Integer.toString(cadastroP.getIdProduto()), 
                                                                            cadastroP.getNome(), 
                                                                            String.valueOf(cadastroP.getQuantidade()), 
                                                                            String.valueOf(cadastroP.getValor())});
                    }

                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
                }
     
    }

public void limparTabela()
    {
        while(jTable1.getRowCount() > 0) 
        {
            DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
            dm.getDataVector().removeAllElements();
        }
    }
public void limparTabelaCarrinho() {
    DefaultTableModel modeloCarrinho = (DefaultTableModel) jTabelaCarrinho.getModel();
    modeloCarrinho.setRowCount(0); 

    jValorTotal.setText("0.00"); 
}

private double  atualizaValorTotal() {
    double total = 0.0;
    DefaultTableModel modeloTabela2 = (DefaultTableModel) jTabelaCarrinho.getModel();

    for (int i = 0; i < modeloTabela2.getRowCount(); i++) {
        Object valorObj = modeloTabela2.getValueAt(i, 3);  

        if (valorObj instanceof String) {
            try {
                String valorStr = ((String) valorObj).replace(",", ".");
                total += Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Erro ao calcular o valor total: formato inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (valorObj instanceof Number) {
            total += ((Number) valorObj).doubleValue();
        }
    }

    DecimalFormat df = new DecimalFormat("#,##0.00");
    String valorFormatado = df.format(total);

    jValorTotal.setText(valorFormatado);
    return total;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabelaCarrinho;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jValorTotal;
    private javax.swing.JTextField txtBuscarVenda;
    // End of variables declaration//GEN-END:variables
}
