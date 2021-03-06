/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao.desktop;

import br.edu.ifnmg.logicaaplicacao.Produto;
import br.edu.ifnmg.logicaaplicacao.ProdutoAplicacao;
import br.edu.ifnmg.logicaaplicacao.ProdutoFinalidade;
import br.edu.ifnmg.logicaaplicacao.ProdutoRepositorio;
import br.edu.ifnmg.logicaaplicacao.RepositorioFactory;
import br.edu.ifnmg.logicaaplicacao.Status;
import br.edu.ifnmg.logicaaplicacao.UnidadeCompra;
import br.edu.ifnmg.logicaaplicacao.UnidadeVenda;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author edlaine
 */
public class ProdutoEditar extends javax.swing.JInternalFrame {
    ProdutoRepositorio repositorio;
    Produto produto;
    Usuario usuario;
    /**
     * Creates new form ProdutoEditar
     */
    public ProdutoEditar( Produto p , Usuario u) {
        this.repositorio = RepositorioFactory.getProdutoRepositorio();
        
        this.produto = p;
        this.usuario = u;
        initComponents();
        
        this.setComponentes();
    }

    private void setComponentes(){      
        if (this.produto.getId() > 0) {
            
            this.lblIDProduto.setText(this.produto.getId().toString());
            this.txtNome.setText(this.produto.getNome());
            this.txtValorUnitario.setText(this.produto.getValorUnitario().toString());
            this.lblEstoqueQnt.setText(String.valueOf( this.produto.getEstoque()));


            this.txtUsuario.setText(this.produto.getUsuario().getLogin());

            this.cbxStatus.setSelectedItem(this.produto.getStatus().name());
            this.cbxUnidCompra.setSelectedItem(this.produto.getUnidcompra().name());
            this.cbxUnidVenda.setSelectedItem(this.produto.getUnidvenda().name());
            this.txtRazaoCompra.setText(String.valueOf( this.produto.getRazaocompra() ));
            this.txtRazaoVenda.setText(String.valueOf( this.produto.getRazaovenda() ));
            this.cbxFinalidade.setSelectedItem(this.produto.getFinalidade().name());
            this.cbxAplicacao.setSelectedItem(this.produto.getAplicacao().name());
        }
    }
    
    private void getComponentes(){
        this.produto.setNome(this.txtNome.getText());
        this.produto.setValorUnitario(new BigDecimal( this.txtValorUnitario.getText() ));
        this.produto.setEstoque(Integer.parseInt( this.lblEstoqueQnt.getText() ), null);
        
        // o usuário eu já tenho
        this.produto.setUsuario(usuario);
        this.txtUsuario.setText( this.produto.getUsuario().getLogin() );
              
        
        this.produto.setStatus(Status.valueOf(this.cbxStatus.getSelectedItem().toString()));
        this.produto.setUnidcompra(UnidadeCompra.valueOf(this.cbxUnidCompra.getSelectedItem().toString()));
        this.produto.setUnidvenda(UnidadeVenda.valueOf(this.cbxUnidVenda.getSelectedItem().toString()));
        
        this.produto.setRazaocompra(Integer.parseInt(this.txtRazaoCompra.getText().toString()));
        this.produto.setRazaovenda(Integer.parseInt(this.txtRazaoVenda.getText().toString()));
        
        this.produto.setFinalidade(ProdutoFinalidade.valueOf(this.cbxFinalidade.getSelectedItem().toString()));
        this.produto.setAplicacao(ProdutoAplicacao.valueOf(this.cbxAplicacao.getSelectedItem().toString()));
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        lblIDProduto = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblValorUnitario = new javax.swing.JLabel();
        lblEstoque = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        lblUnidCompra = new javax.swing.JLabel();
        cbxUnidCompra = new javax.swing.JComboBox<>();
        lblUnidVenda = new javax.swing.JLabel();
        cbxUnidVenda = new javax.swing.JComboBox<>();
        lblRazaoCompra = new javax.swing.JLabel();
        lblRazaoVenda = new javax.swing.JLabel();
        lblFinalidade = new javax.swing.JLabel();
        lblAplicacao = new javax.swing.JLabel();
        cbxAplicacao = new javax.swing.JComboBox<>();
        cbxFinalidade = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblEstoqueQnt = new javax.swing.JLabel();
        txtRazaoCompra = new javax.swing.JFormattedTextField();
        txtRazaoVenda = new javax.swing.JFormattedTextField();
        txtValorUnitario = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Editar Produto");
        setToolTipText("Editar Produto.");

        lblID.setText("ID:");

        lblIDProduto.setText("0");
        lblIDProduto.setToolTipText("ID do Produto.");

        lblNome.setText("Nome:");

        txtNome.setToolTipText("Insira o nome do produto.");

        lblValorUnitario.setText("Valor Unitário: R$");

        lblEstoque.setText("Qnt. Estoque:");

        lblUsuario.setText("Login Usuário :");
        lblUsuario.setToolTipText("Login do Usuário.");

        lblStatus.setText("Status:");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        cbxStatus.setToolTipText("Selecione um STATUS para o produto.");

        lblUnidCompra.setText("Unidade de Compra:");

        cbxUnidCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Caixa", "Fardo", "Dúzia", "Outro  " }));
        cbxUnidCompra.setToolTipText("Selecione a unidade de compra.");

        lblUnidVenda.setText("Unidade de Venda:");

        cbxUnidVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidade", "Caixa", "Fardo", "Dúzia", "Outro  " }));
        cbxUnidVenda.setToolTipText("Selecione a unidade de venda.");

        lblRazaoCompra.setText("Razão de Compra:");

        lblRazaoVenda.setText("Razão de Venda:");

        lblFinalidade.setText("Finalidade:");

        lblAplicacao.setText("Aplicação:");

        cbxAplicacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pele", "Lábios", "Capilar", "Dentes", "Genitálias", "Outro " }));
        cbxAplicacao.setToolTipText("Selecione a APLICAÇÃO do produto.");

        cbxFinalidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limpar", "Perfumar", "Proteger", "Outro" }));
        cbxFinalidade.setToolTipText("Selecione a FINALIDADE do produto.");

        btnSalvar.setText("SALVAR");
        btnSalvar.setToolTipText("Clique para SALVAR.");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnRemover.setText("REMOVER");
        btnRemover.setToolTipText("Clique para REMOVER.");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.setToolTipText("Clique para CANCELAR.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblEstoqueQnt.setText("0");
        lblEstoqueQnt.setToolTipText("Quantidade disponível em estoque.");

        txtRazaoCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtRazaoCompra.setToolTipText("Insira a razão de compra.");

        txtRazaoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtRazaoVenda.setToolTipText("Insira a razão de venda.");

        txtValorUnitario.setToolTipText("Digite o valor unitário.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUnidCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxUnidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(lblUnidVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblIDProduto)
                                .addGap(32, 32, 32)
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblValorUnitario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorUnitario))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblRazaoCompra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtRazaoCompra))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblEstoque)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblEstoqueQnt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(41, 41, 41)
                                            .addComponent(lblUsuario))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblFinalidade)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbxFinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblAplicacao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbxAplicacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblStatus)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(lblRazaoVenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRazaoVenda)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(303, 303, 303))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblIDProduto)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorUnitario)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstoque)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstoqueQnt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnidCompra)
                    .addComponent(cbxUnidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidVenda)
                    .addComponent(cbxUnidVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazaoCompra)
                    .addComponent(lblRazaoVenda)
                    .addComponent(txtRazaoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinalidade)
                    .addComponent(lblAplicacao)
                    .addComponent(cbxAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRemover)
                    .addComponent(btnSalvar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente salvar os dados do Produto?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){
            this.getComponentes();
            if(repositorio.Salvar(this.produto)){
                JOptionPane.showMessageDialog(this, "Sucesso ao salvar!","Informação!",JOptionPane.INFORMATION_MESSAGE);
                this.setComponentes();
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao salvar!","ERRO!",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Operação Cancelada","Informação!",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente remover o produto atual?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){
            if(repositorio.Apagar(this.produto)){

                JOptionPane.showMessageDialog(this, "Produto removido com sucesso!","Sucesso!",
                    JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Aconteceu um problema ao remover os dados!","Erro!",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Operação Cancelada!","Informação!",
            JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxAplicacao;
    private javax.swing.JComboBox<String> cbxFinalidade;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JComboBox<String> cbxUnidCompra;
    private javax.swing.JComboBox<String> cbxUnidVenda;
    private javax.swing.JLabel lblAplicacao;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblEstoqueQnt;
    private javax.swing.JLabel lblFinalidade;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDProduto;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRazaoCompra;
    private javax.swing.JLabel lblRazaoVenda;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUnidCompra;
    private javax.swing.JLabel lblUnidVenda;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRazaoCompra;
    private javax.swing.JFormattedTextField txtRazaoVenda;
    private javax.swing.JLabel txtUsuario;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
