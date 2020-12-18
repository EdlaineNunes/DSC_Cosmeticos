/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao.desktop;

import br.edu.ifnmg.logicaaplicacao.Pessoa;
import br.edu.ifnmg.logicaaplicacao.PessoaRepositorio;
import br.edu.ifnmg.logicaaplicacao.Produto;
import br.edu.ifnmg.logicaaplicacao.ProdutoRepositorio;
import br.edu.ifnmg.logicaaplicacao.RepositorioFactory;
import br.edu.ifnmg.logicaaplicacao.Transacao;
import br.edu.ifnmg.logicaaplicacao.TransacaoItem;
import br.edu.ifnmg.logicaaplicacao.TransacaoRepositorio;
import br.edu.ifnmg.logicaaplicacao.TransacaoTipo;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edlaine
 */
public class TransacaoNova extends javax.swing.JInternalFrame {
    Transacao transacao;
    TransacaoRepositorio repositorio;
    TransacaoTipo tipo;
    TransacaoItem item;
    Usuario usuario;
    Pessoa pessoa;
    PessoaRepositorio repopessoa;
    Produto produto;
    ProdutoRepositorio repoproduto;
    /**
     * Creates new form TransacaoNova
     */
    public TransacaoNova(Transacao t, Usuario u) {
        this.transacao = t;
        this.usuario = u;
        this.repositorio = RepositorioFactory.getTransacaoRepositorio();
        this.tipo = null;
        this.item = new TransacaoItem();
        
        this.pessoa = new Pessoa();
        this.repopessoa = RepositorioFactory.getPessoaRepositorio();
        
        this.produto = new Produto();
        this.repoproduto = RepositorioFactory.getProdutoRepositorio();
        
        initComponents();
        
        this.setComponentes();
    }
    
    private void preencherCampos(){
            this.lblIDTransacao.setText(this.transacao.getId().toString());
            this.txtIDPessoa.setText(this.transacao.getPessoa().getId().toString());
            this.lblNomePessoaTransacao.setText(this.transacao.getPessoa().getNome());
            this.lblCriacaoTransacao.setText(this.transacao.getCriacao().toString());
            this.cbxTransacaoTipo.setSelectedItem(this.transacao.getTipo().name());
            this.lblLoginUsuario.setText(this.transacao.getUsuario().getLogin()); 
    }
    
    private void atualizaItens(){
        DefaultTableModel modelo = new DefaultTableModel();
        //adicionando as colunas
        modelo.addColumn("Nome Produto");
        modelo.addColumn("Valor Unitário");
        modelo.addColumn("Quantidade");
                    
            
        //adicionando as linhas
        for(TransacaoItem i : this.transacao.getItens()){
            Vector linha = new Vector();
            linha.add(i.getProduto().getNome());
            linha.add("R$ " + i.getValorUnitario());
            linha.add(i.getQuantidade());          
            
            modelo.addRow(linha);
        }
        
        //adicionando os dados na tabela
        tblResultado.setModel(modelo);
    
    }
    
    private void limpaItens(){
        DefaultTableModel modelo = new DefaultTableModel();
        //adicionando as colunas
        modelo.addColumn("Nome Produto");
        modelo.addColumn("Valor Unitário");
        modelo.addColumn("Quantidade");
        
        //adicionando os dados na tabela
        tblResultado.setModel(modelo);
    }
    
    private void setComponentes(){ 
        if(this.transacao.getId() > 0){
            this.lblIDTransacao.setText(this.transacao.getId().toString());
            this.txtIDPessoa.setText(this.transacao.getPessoa().getId().toString());
            this.lblNomePessoaTransacao.setText(this.transacao.getPessoa().getNome());
            this.lblCriacaoTransacao.setText(this.transacao.getCriacao().toString());
            this.cbxTransacaoTipo.setSelectedItem(this.transacao.getTipo().name());
            this.lblLoginUsuario.setText(this.transacao.getUsuario().getLogin()); 
            this.lblValorTotal.setText(this.transacao.getValorTotal().toString());  
            
            DefaultTableModel modelo = new DefaultTableModel();
            //adicionando as colunas
            modelo.addColumn("Nome Produto");
            modelo.addColumn("Valor Unitário");
            modelo.addColumn("Quantidade");


            //adicionando as linhas
            for(TransacaoItem i : this.transacao.getItens()){
                Vector linha = new Vector();
                linha.add(i.getProduto().getNome());
                linha.add("R$ " + i.getValorUnitario());
                linha.add(i.getQuantidade());          

                modelo.addRow(linha);
            }

            //adicionando os dados na tabela
            tblResultado.setModel(modelo);
        }
    }
        
    public void calculoPreco(TransacaoItem i){
        this.item = i;
        this.item.setQuantidade(Integer.parseInt( this.txtQuantidade.toString() ));
        this.transacao.setValorTotal(BigDecimal.valueOf(
                Long.parseLong(
                        (this.item.getProduto().getValorUnitario()
                                .multiply(BigDecimal.valueOf(item.getQuantidade()))).toString())));
    
        this.lblValorTotal.setText(this.transacao.getValorTotal().toString());
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ID = new javax.swing.JLabel();
        lblIDTransacao = new javax.swing.JLabel();
        lblPessoa = new javax.swing.JLabel();
        lblNomePessoa = new javax.swing.JLabel();
        lblNomePessoaTransacao = new javax.swing.JLabel();
        btnValidarPessoa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblCriacao = new javax.swing.JLabel();
        lblCriacaoTransacao = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        lblInfo = new javax.swing.JLabel();
        lblNomeProduto = new javax.swing.JLabel();
        lblQnt = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        lblValorFinal = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRemoverTransacao = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        cbxTransacaoTipo = new javax.swing.JComboBox<>();
        lblUsuario = new javax.swing.JLabel();
        lblLoginUsuario = new javax.swing.JLabel();
        btnEditarQnt = new javax.swing.JButton();
        txtIDPessoa = new javax.swing.JFormattedTextField();
        txtQuantidade = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Editar Transação");
        setToolTipText("Editar Transação.");

        ID.setText("ID Transação:");

        lblIDTransacao.setText("0");
        lblIDTransacao.setToolTipText("ID Transação.");

        lblPessoa.setText("ID Pessoa:");

        lblNomePessoa.setText("Nome Pessoa:");

        lblNomePessoaTransacao.setToolTipText("Nome Pessoa.");

        btnValidarPessoa.setText("VALIDAR PESSOA");
        btnValidarPessoa.setToolTipText("Clique para validar as informações!");
        btnValidarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarPessoaActionPerformed(evt);
            }
        });

        lblCriacao.setText("Criação:");

        lblCriacaoTransacao.setToolTipText("Criação Transação.");

        txtNomeProduto.setToolTipText("Insira o nome do produto.");

        lblInfo.setText("Adicionar/Editar itens da Transação");

        lblNomeProduto.setText("Nome do Produto:");

        lblQnt.setText("Quantidade:");

        btnAdicionar.setText("ADICIONAR PRODUTO");
        btnAdicionar.setToolTipText("Clique para ADICIONAR o produto.");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Produto", "Valor Unitário", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultado.setToolTipText("Lista de Itens da Transação.");
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
        }

        btnRemover.setText("REMOVER PRODUTO");
        btnRemover.setToolTipText("Clique para REMOVER o produto da lista.");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        lblValorFinal.setText("PREÇO TOTAL: R$");

        lblValorTotal.setText("0.00");
        lblValorTotal.setToolTipText("Valor TOTAL.");

        btnFinalizar.setText("FINALIZAR TRANSAÇÃO");
        btnFinalizar.setToolTipText("Clique para FINALIZAR a transação!");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR ");
        btnCancelar.setToolTipText("Clique para CANCELAR operação!");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRemoverTransacao.setText("REMOVER TRANSAÇÃO");
        btnRemoverTransacao.setToolTipText("Clique para REMOVER a Transação!");

        lblTipo.setText("Tipo de Transação:");

        cbxTransacaoTipo.setModel(new DefaultComboBoxModel(TransacaoTipo.values()));

        lblUsuario.setText("Usuário (Login):");

        lblLoginUsuario.setToolTipText("Login do Usuário!");

        btnEditarQnt.setText("EDITAR QUANTIDADE");
        btnEditarQnt.setToolTipText("Clique para ATUALIZAR a quantidade.");
        btnEditarQnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarQntActionPerformed(evt);
            }
        });

        txtIDPessoa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtIDPessoa.setToolTipText("Insira o ID da Pessoa.");

        txtQuantidade.setToolTipText("Insira a quantidade.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFinalizar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblNomeProduto)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblQnt)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtQuantidade))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnAdicionar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEditarQnt)
                                    .addGap(26, 26, 26)
                                    .addComponent(btnRemover))
                                .addComponent(jScrollPane1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(lblInfo)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTransacaoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblCriacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCriacaoTransacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIDTransacao)
                                .addGap(35, 35, 35)
                                .addComponent(lblPessoa)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomePessoa)
                                .addGap(53, 53, 53)
                                .addComponent(lblNomePessoaTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnValidarPessoa)
                                .addGap(35, 35, 35))))))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblValorFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblValorTotal)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRemoverTransacao)
                        .addGap(67, 67, 67)
                        .addComponent(btnCancelar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID)
                    .addComponent(lblIDTransacao)
                    .addComponent(lblPessoa)
                    .addComponent(lblNomePessoa)
                    .addComponent(lblNomePessoaTransacao)
                    .addComponent(txtIDPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCriacao)
                    .addComponent(lblCriacaoTransacao)
                    .addComponent(btnValidarPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cbxTransacaoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario)
                    .addComponent(lblLoginUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeProduto)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQnt)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnRemover)
                    .addComponent(btnEditarQnt))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorFinal)
                    .addComponent(lblValorTotal))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRemoverTransacao)
                    .addComponent(btnFinalizar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarPessoaActionPerformed
        // TODO add your handling code here:
        if(this.txtIDPessoa.getText().length() > 0){    
            this.pessoa = repopessoa.Abrir(Long.parseLong(this.txtIDPessoa.getText().toString()));
            if(this.pessoa != null){
                JOptionPane.showConfirmDialog(this, "Pessoa validada com sucesso!", "Informação!", JOptionPane.INFORMATION_MESSAGE);
                this.txtIDPessoa.setText(this.pessoa.getId().toString());
                this.lblNomePessoaTransacao.setText(this.pessoa.getNome());
                this.lblLoginUsuario.setText(this.usuario.getLogin()); 

                this.transacao.setPessoa(pessoa);
                this.transacao.setUsuario(usuario);

            }else{
                JOptionPane.showMessageDialog(this, "ID Pessoa incorreto ou inexistente! Tente novamente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                this.txtIDPessoa.setText("");
            }
        }else
            JOptionPane.showMessageDialog(this, "Insira um ID no campo ID Pessoa!", "Erro!", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnValidarPessoaActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        if( !this.txtNomeProduto.getText().isEmpty() && 
                !this.txtQuantidade.getText().isEmpty() ){
            produto = repoproduto.buscaNomeProduto(this.txtNomeProduto.getText());
            if(produto != null){
                this.transacao.setTipo( (TransacaoTipo)this.cbxTransacaoTipo.getSelectedItem() );
                if( this.transacao.getTipo()  == TransacaoTipo.Venda || 
                        this.transacao.getTipo() == TransacaoTipo.Descarte ){
                    if(produto.getEstoque() >= Integer.parseInt(this.txtQuantidade.getText())){
                        int quantidade = Integer.parseInt(this.txtQuantidade.getText());
                        this.item = new TransacaoItem(transacao, produto, quantidade);
                        //adiciona na lista
                        this.transacao.add(item);
                        this.lblValorTotal.setText(this.transacao.getValorTotal().toString());
                        this.txtNomeProduto.setText("");
                        this.txtQuantidade.setText("");
                        atualizaItens();

                    }else{
                        JOptionPane.showMessageDialog(this, "Quantidade superior ao ESTOQUE!", "ERRO!" , JOptionPane.INFORMATION_MESSAGE);
                        this.txtQuantidade.setText("");
                    }
                }else{
                    int quantidade = Integer.parseInt(this.txtQuantidade.getText().toString());
                    this.item = new TransacaoItem(transacao, produto, quantidade);
                    //adiciona na lista
                    this.transacao.add(item);
                    this.lblValorTotal.setText(this.transacao.getValorTotal().toString());
                    this.txtNomeProduto.setText("");
                    this.txtQuantidade.setText("");
                    atualizaItens();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Produto não existente!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                this.txtNomeProduto.setText("");
                this.txtQuantidade.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Preencha o nome do produto e/ou a quantidade!", "Informação!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // TODO add your handling code here:               
        if( !this.txtNomeProduto.getText().isEmpty() && 
                !this.txtQuantidade.getText().isEmpty() ){
            if(JOptionPane.showConfirmDialog(this, "Deseja realmente REMOVER o produto?", "Confirmação",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                //verifico se está na lista
                for(TransacaoItem i : this.transacao.getItens()){
                    this.transacao.remove(i);
                    this.lblValorTotal.setText(this.transacao.getValorTotal().toString());
                    this.txtNomeProduto.setText("");
                    this.txtQuantidade.setText("");
                    atualizaItens();

                }
            }else{
                this.txtNomeProduto.setText("");
                this.txtQuantidade.setText("");
                JOptionPane.showMessageDialog(this, "Operaçãoo cancelada pelo Usuário","Cancelamento!",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Selecione o item que deseja REMOVER!", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void tblResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMouseClicked
        // TODO add your handling code here:
        int linha = tblResultado.getSelectedRow();
        String nome = tblResultado.getValueAt(linha, 0).toString();
        String qnt = tblResultado.getValueAt(linha, 2).toString();
        this.txtNomeProduto.setText(nome);
        this.txtQuantidade.setText(qnt);
        
    }//GEN-LAST:event_tblResultadoMouseClicked

    private void btnEditarQntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarQntActionPerformed
        // TODO add your handling code here:
        if( !this.txtNomeProduto.getText().isEmpty() && 
                !this.txtQuantidade.getText().isEmpty() ){
            if(JOptionPane.showConfirmDialog(this, "Deseja realmente EDITAR A QUANTIDADE do produto?", "Confirmação",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                //verifico se está na lista
                for(TransacaoItem i : this.transacao.getItens()){
                    this.transacao.remove(i);
                    this.lblValorTotal.setText(this.transacao.getValorTotal().toString());
                    this.txtQuantidade.setText("");
                    atualizaItens();
                }    
            } else{
                this.txtNomeProduto.setText("");
                this.txtQuantidade.setText("");
                JOptionPane.showMessageDialog(this, "Operaçãoo cancelada pelo Usuário","Cancelamento!",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Selecione o item que deseja ATUALIZAR A QUANTIDADE!", "Informação!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarQntActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Operação Cancelada!","Informação!",
            JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        this.transacao.setTipo(TransacaoTipo.valueOf( this.cbxTransacaoTipo.getSelectedItem().toString() ));
        
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar a Transacao de " + this.transacao.getTipo() + "?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){                          
            if(repositorio.Salvar(this.transacao)){
                JOptionPane.showMessageDialog(this, "Sucesso ao salvar!","Informação!",JOptionPane.INFORMATION_MESSAGE);
                
                for(TransacaoItem i: this.transacao.getItens()){
                    this.produto = this.repoproduto.Abrir(i.getProduto().getId());
                    this.produto.setEstoque(i.getQuantidade(), TransacaoTipo.valueOf(this.transacao.getTipo().name()));
                    this.repoproduto.Salvar(produto);
                    this.transacao.add(new TransacaoItem(transacao, produto, i.getQuantidade()));
                    this.produto = new Produto();
                }
                
                this.setComponentes();
                
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao salvar!","ERRO!",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Operação Cancelada","Informação!",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarQnt;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnRemoverTransacao;
    private javax.swing.JButton btnValidarPessoa;
    private javax.swing.JComboBox<TransacaoTipo> cbxTransacaoTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCriacao;
    private javax.swing.JLabel lblCriacaoTransacao;
    private javax.swing.JLabel lblIDTransacao;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblLoginUsuario;
    private javax.swing.JLabel lblNomePessoa;
    private javax.swing.JLabel lblNomePessoaTransacao;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblPessoa;
    private javax.swing.JLabel lblQnt;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblValorFinal;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JTable tblResultado;
    private javax.swing.JFormattedTextField txtIDPessoa;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
