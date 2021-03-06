/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao.desktop;

import br.edu.ifnmg.logicaaplicacao.Produto;
import br.edu.ifnmg.logicaaplicacao.ProdutoRepositorio;
import br.edu.ifnmg.logicaaplicacao.RepositorioFactory;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edlaine
 */
public class ProdutoBuscar extends javax.swing.JInternalFrame {
    ProdutoRepositorio repositorio;
    Produto produto;
    
    Usuario usuario;
    /**
     * Creates new form ProdutoBuscar
     */
    public ProdutoBuscar(Usuario u) {
        this.usuario = u;
        this.repositorio = RepositorioFactory.getProdutoRepositorio();
        
        this.produto = new Produto();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();

        setClosable(true);
        setTitle("Buscar Produto");
        setToolTipText("Buscar Produto.");

        lblNome.setText("Nome do Produto:");

        txtNome.setToolTipText("Insira o nome do produto.");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setToolTipText("Clique para efetuar uma BUSCA!");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNovo.setText("NOVO PRODUTO");
        btnNovo.setToolTipText("Clique para cadastrar um NOVO PRODUTO!");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.setToolTipText("Clique para LIMPAR os filtros da busca.");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor Unitário", "Qnt Estoque", "Login Usuário", "Und. Compra", "Und. Venda", "Finalidade", "Aplicação", "Status", "Versão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultado.setToolTipText("Informações dos produtos.");
        tblResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultado);
        if (tblResultado.getColumnModel().getColumnCount() > 0) {
            tblResultado.getColumnModel().getColumn(0).setResizable(false);
            tblResultado.getColumnModel().getColumn(1).setResizable(false);
            tblResultado.getColumnModel().getColumn(2).setResizable(false);
            tblResultado.getColumnModel().getColumn(3).setResizable(false);
            tblResultado.getColumnModel().getColumn(4).setResizable(false);
            tblResultado.getColumnModel().getColumn(5).setResizable(false);
            tblResultado.getColumnModel().getColumn(6).setResizable(false);
            tblResultado.getColumnModel().getColumn(7).setResizable(false);
            tblResultado.getColumnModel().getColumn(8).setResizable(false);
            tblResultado.getColumnModel().getColumn(9).setResizable(false);
            tblResultado.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnBuscar)
                        .addGap(36, 36, 36)
                        .addComponent(btnNovo)
                        .addGap(29, 29, 29)
                        .addComponent(btnLimpar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNovo)
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        // adicionando o que foi escrito no campo
        produto.setNome(txtNome.getText());
        //fazendo a bsuca no rep com o filtro
        List<Produto> resultado = repositorio.Buscar(produto);
        //criou um modelo vazio
        DefaultTableModel modelo = new DefaultTableModel();
        //adicionando as colunas
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Valor Unitário");
        modelo.addColumn("Qnt Estoque");
        modelo.addColumn("Login Usuário");
        modelo.addColumn("Und. Compra");
        modelo.addColumn("Und. Venda");
        modelo.addColumn("Finalidade");
        modelo.addColumn("Aplicação");
        modelo.addColumn("Status");
        modelo.addColumn("Versão");
        
        //adicionando as linhas
        for(Produto p : resultado){
            Vector linha = new Vector();
            linha.add(p.getId());
            linha.add(p.getNome());
            linha.add("R$ " + p.getValorUnitario());
            linha.add(p.getEstoque());
            linha.add(p.getUsuario().getLogin());
            linha.add(p.getUnidcompra());
            linha.add(p.getUnidvenda());
            linha.add(p.getFinalidade());
            linha.add(p.getAplicacao());
            linha.add(p.getStatus());
            linha.add(p.getVersion());            
            
            modelo.addRow(linha);
        }
        
        //adicionando os dados na tabela
        tblResultado.setModel(modelo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente limpar a busca?", "Confirmação", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION){
            txtNome.setText("");
        
            //criou um modelo vazio
            DefaultTableModel modelo = new DefaultTableModel();
            //adicionando as colunas
            modelo.addColumn("ID");
            modelo.addColumn("Nome");
            modelo.addColumn("Valor Unitário");
            modelo.addColumn("Qnt Estoque");
            modelo.addColumn("Login Usuário");
            modelo.addColumn("Und. Compra");
            modelo.addColumn("Und. Venda");
            modelo.addColumn("Finalidade");
            modelo.addColumn("Aplicação");
            modelo.addColumn("Status");
            modelo.addColumn("Versão");
            
            //adicionando os dados na tabela
            tblResultado.setModel(modelo);
            
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tblResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMouseClicked
        // TODO add your handling code here:
        int linha = tblResultado.getSelectedRow();
        Long id = Long.parseLong(tblResultado.getValueAt(linha, 0).toString());
        
        Produto p = repositorio.Abrir(id);
        
        ProdutoEditar tela = new ProdutoEditar(p,usuario);
        this.getParent().add(tela);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tblResultadoMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        ProdutoEditar tela = new ProdutoEditar(new Produto(), usuario);
        this.getParent().add(tela);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
