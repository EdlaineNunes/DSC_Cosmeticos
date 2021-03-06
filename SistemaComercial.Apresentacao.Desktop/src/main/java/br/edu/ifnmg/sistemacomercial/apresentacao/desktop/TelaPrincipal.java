/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao.desktop;

import br.edu.ifnmg.logicaaplicacao.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author edlaine
 */
public class TelaPrincipal extends javax.swing.JFrame {
    Usuario usuario;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal(Usuario u) {
        
        this.usuario = u;
        initComponents();
    }

    private TelaPrincipal() {
          
        this.usuario = new Usuario();
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

        Desktop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMBMenuGeral = new javax.swing.JMenuBar();
        JMSistema = new javax.swing.JMenu();
        JMISair = new javax.swing.JMenuItem();
        JMCadastros = new javax.swing.JMenu();
        JMIUsuario = new javax.swing.JMenuItem();
        JMIPessoaFisica = new javax.swing.JMenuItem();
        JMIPessoaJuridica = new javax.swing.JMenuItem();
        JMIProduto = new javax.swing.JMenuItem();
        jMContatos = new javax.swing.JMenu();
        JMITelefone = new javax.swing.JMenuItem();
        JMIEmails = new javax.swing.JMenuItem();
        JMTransacao = new javax.swing.JMenu();
        JMIBuscarTransacao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COSMÉTICOS E CIA - C&C ");

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 80)); // NOI18N
        jLabel1.setText("Cosméticos e Cia");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setText("C&C");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Desenvolvido por: Edlâine Rodrigues Nunes");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Sob as orientações do Profº Drº Petrônio Cândido");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("DESENVOLVIMENTO DE SISTEMAS CORPORATIVOS");

        Desktop.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desktop.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(520, 520, 520))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                        .addGroup(DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(DesktopLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15)))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(56, 56, 56))))
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopLayout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(33, 33, 33))
        );

        jMBMenuGeral.setBackground(new java.awt.Color(204, 204, 255));

        JMSistema.setText("Sistema");

        JMISair.setText("SAIR");
        JMISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMISairActionPerformed(evt);
            }
        });
        JMSistema.add(JMISair);

        jMBMenuGeral.add(JMSistema);

        JMCadastros.setText("Cadastros");

        JMIUsuario.setText("Usuário");
        JMIUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIUsuarioActionPerformed(evt);
            }
        });
        JMCadastros.add(JMIUsuario);

        JMIPessoaFisica.setText("Pessoa Física");
        JMIPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIPessoaFisicaActionPerformed(evt);
            }
        });
        JMCadastros.add(JMIPessoaFisica);

        JMIPessoaJuridica.setText("Pessoa Jurídica");
        JMIPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIPessoaJuridicaActionPerformed(evt);
            }
        });
        JMCadastros.add(JMIPessoaJuridica);

        JMIProduto.setText("Produto");
        JMIProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIProdutoActionPerformed(evt);
            }
        });
        JMCadastros.add(JMIProduto);

        jMBMenuGeral.add(JMCadastros);

        jMContatos.setText("Contatos");

        JMITelefone.setText("Telefones");
        JMITelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMITelefoneActionPerformed(evt);
            }
        });
        jMContatos.add(JMITelefone);

        JMIEmails.setText("Emails");
        JMIEmails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIEmailsActionPerformed(evt);
            }
        });
        jMContatos.add(JMIEmails);

        jMBMenuGeral.add(jMContatos);

        JMTransacao.setText("Transações");

        JMIBuscarTransacao.setText("Buscar Transações");
        JMIBuscarTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIBuscarTransacaoActionPerformed(evt);
            }
        });
        JMTransacao.add(JMIBuscarTransacao);

        jMBMenuGeral.add(JMTransacao);

        setJMenuBar(jMBMenuGeral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIUsuarioActionPerformed
        // TODO add your handling code here:
        UsuarioBuscar tela = new UsuarioBuscar();
        Desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_JMIUsuarioActionPerformed

    private void JMIPessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIPessoaFisicaActionPerformed
        // TODO add your handling code here:
        PessoaFisicaBuscar tela = new PessoaFisicaBuscar();
        Desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_JMIPessoaFisicaActionPerformed

    private void JMIPessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIPessoaJuridicaActionPerformed
        // TODO add your handling code here:
        PessoaJuridicaBuscar tela = new PessoaJuridicaBuscar();
        Desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_JMIPessoaJuridicaActionPerformed

    private void JMITelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMITelefoneActionPerformed
        // TODO add your handling code here:
        PessoaTelefoneTela tela = new PessoaTelefoneTela();
        Desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_JMITelefoneActionPerformed

    private void JMIEmailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIEmailsActionPerformed
        // TODO add your handling code here:
        PessoaEmailTela tela = new PessoaEmailTela();
        Desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_JMIEmailsActionPerformed

    private void JMISairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMISairActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, usuario.getNome() + " deseja realmente SAIR do Sistema?", "Confirmação!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Saiu com sucesso!", "Exit!", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false); 
        }else
            JOptionPane.showMessageDialog(this, "Operação Cancelada", "INFORMAÇÃO!", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_JMISairActionPerformed

    private void JMIProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIProdutoActionPerformed
        // TODO add your handling code here:
        ProdutoBuscar tela = new ProdutoBuscar(usuario);
        Desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_JMIProdutoActionPerformed

    private void JMIBuscarTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIBuscarTransacaoActionPerformed
        // TODO add your handling code here:
        TransacaoBuscar tela = new TransacaoBuscar(usuario);
        Desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_JMIBuscarTransacaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenu JMCadastros;
    private javax.swing.JMenuItem JMIBuscarTransacao;
    private javax.swing.JMenuItem JMIEmails;
    private javax.swing.JMenuItem JMIPessoaFisica;
    private javax.swing.JMenuItem JMIPessoaJuridica;
    private javax.swing.JMenuItem JMIProduto;
    private javax.swing.JMenuItem JMISair;
    private javax.swing.JMenuItem JMITelefone;
    private javax.swing.JMenuItem JMIUsuario;
    private javax.swing.JMenu JMSistema;
    private javax.swing.JMenu JMTransacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMBMenuGeral;
    private javax.swing.JMenu jMContatos;
    // End of variables declaration//GEN-END:variables
}
