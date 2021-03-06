/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao.desktop;

import br.edu.ifnmg.logicaaplicacao.RepositorioFactory;
import br.edu.ifnmg.logicaaplicacao.Transacao;
import br.edu.ifnmg.logicaaplicacao.TransacaoRepositorio;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edlaine
 */
public class TransacaoBuscar extends javax.swing.JInternalFrame {
    Transacao transacao;
    TransacaoRepositorio repositorio;
    Usuario usuario;
    /**
     * Creates new form TransacaoBuscar
     */
    public TransacaoBuscar(Usuario u) {
        this.transacao = new Transacao();
        
        this.repositorio = RepositorioFactory.getTransacaoRepositorio();
        
        this.usuario = u;
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

        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNovaTransacao = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();

        setClosable(true);
        setTitle("Buscar Transação");
        setToolTipText("Buscar Transação.");

        lblID.setText("ID da TRANSAÇÃO:");

        txtID.setToolTipText("Insira o ID da TRANSAÇÃO.");

        btnBuscar.setText("BUSCAR");
        btnBuscar.setToolTipText("Clique para efetuar uma BUSCA.");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNovaTransacao.setText("NOVA TRANSAÇÃO");
        btnNovaTransacao.setToolTipText("Clique para adicionar uma NOVA TRANSAÇÃO!");
        btnNovaTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaTransacaoActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.setToolTipText("Clique para LIMPAR a busca.");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transação", "Pessoa (ID)", "Pessoa (Nome)", "Valor Total R$", "Qnt de Itens", "Tipo", "Usuário (Login)", "Versão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultado.setToolTipText("Informações das Transações.");
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
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(lblID)
                .addGap(18, 18, 18)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnBuscar)
                .addGap(19, 19, 19)
                .addComponent(btnNovaTransacao)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNovaTransacao)
                    .addComponent(btnLimpar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        // adicionando o que foi escrito
        if(this.txtID.getText().length() > 0)
            this.transacao.setId(Long.parseLong( txtID.getText().toString() ));
        else this.transacao.setId(0L);
        //fazendo a bsuca no rep com o filtro
        List<Transacao> resultado = this.repositorio.Buscar(this.transacao);
        //criou um modelo vazio
        DefaultTableModel modelo = new DefaultTableModel();
        //adicionando as colunas
        modelo.addColumn("ID Transação");
        modelo.addColumn("Pessoa (ID)");
        modelo.addColumn("Pessoa (Nome)");
        modelo.addColumn("Valor Total R$");
        modelo.addColumn("Qnt de Itens");
        modelo.addColumn("Tipo");
        modelo.addColumn("Usuário (Login)");
        modelo.addColumn("Versão");
        
        //adicionando as linhas
        for(Transacao t : resultado){
            Vector linha = new Vector();
            linha.add(t.getId());
            linha.add(t.getPessoa().getId());
            linha.add(t.getPessoa().getNome());
            linha.add("R$ " + t.getValorTotal());
            linha.add(t.getItens().size());
            linha.add(t.getTipo());
            linha.add(t.getUsuario().getLogin());
            linha.add(t.getVersion());
            
            modelo.addRow(linha);
        }
        
        //adicionando os dados na tabela
        tblResultado.setModel(modelo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente limpar a busca", "Confirmação", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION){
            txtID.setText("");
            this.transacao.setId(0L);

            DefaultTableModel modelo = new DefaultTableModel();
            //adicionando as colunas
            modelo.addColumn("ID Transação");
            modelo.addColumn("Pessoa (ID)");
            modelo.addColumn("Pessoa (Nome)");
            modelo.addColumn("Valor Total R$");
            modelo.addColumn("Qnt de Itens");
            modelo.addColumn("Tipo");
            modelo.addColumn("Usuário (Login)");
            modelo.addColumn("Versão");

            tblResultado.setModel(modelo);
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnNovaTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaTransacaoActionPerformed
        // TODO add your handling code here:
        TransacaoNova tela = new TransacaoNova(new Transacao(), usuario);
        this.getParent().add(tela);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovaTransacaoActionPerformed

    private void tblResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMouseClicked
        // TODO add your handling code here:
        int linha = tblResultado.getSelectedRow();
        Long id = Long.parseLong(tblResultado.getValueAt(linha, 0).toString());
        
        Transacao t = repositorio.Abrir(id);
        
        TransacaoNova tela = new TransacaoNova(t, usuario);
        this.getParent().add(tela);
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tblResultadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovaTransacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
