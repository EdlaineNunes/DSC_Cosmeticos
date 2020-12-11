/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao.desktop;

import br.edu.ifnmg.logicaaplicacao.Pessoa;
import br.edu.ifnmg.logicaaplicacao.PessoaFisica;
import br.edu.ifnmg.logicaaplicacao.PessoaFisicaRepositorio;
import br.edu.ifnmg.logicaaplicacao.PessoaRepositorio;
import br.edu.ifnmg.logicaaplicacao.PessoaTipo;
import br.edu.ifnmg.logicaaplicacao.RepositorioFactory;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edlaine
 */
public class PessoaFisicaBuscar extends javax.swing.JInternalFrame {
    PessoaFisicaRepositorio repositorio;
    PessoaFisica pfisica;
    /**
     * Creates new form PessoaFisicaEditar
     */
    public PessoaFisicaBuscar() {
        this.repositorio = RepositorioFactory.getPessoaFisicaRepositorio();
        this.pfisica = new PessoaFisica();
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
        bntBuscar = new javax.swing.JButton();
        btnNovaPFisica = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnTelefones = new javax.swing.JButton();
        btnEmails = new javax.swing.JButton();

        setTitle("Buscar Pessoa Física");

        lblNome.setText("Nome:");

        bntBuscar.setText("BUSCAR");
        bntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarActionPerformed(evt);
            }
        });

        btnNovaPFisica.setText("NOVO CADASTRO");
        btnNovaPFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPFisicaActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF", "RG", "Nome", "Gênero", "Status", "Versão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblResultado);

        btnTelefones.setText("Buscar Telefones");
        btnTelefones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelefonesActionPerformed(evt);
            }
        });

        btnEmails.setText("Buscar Emails");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(bntBuscar)
                .addGap(26, 26, 26)
                .addComponent(btnNovaPFisica)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTelefones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntBuscar)
                            .addComponent(btnNovaPFisica)
                            .addComponent(btnLimpar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnTelefones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnEmails)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaPFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPFisicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovaPFisicaActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente limpar a busca", "Confirmação", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION){
            txtNome.setText("");
        
            //criou um modelo vazio
            DefaultTableModel modelo = new DefaultTableModel();
            //adicionando as colunas
            modelo.addColumn("ID");
            modelo.addColumn("CPF");
            modelo.addColumn("RG");
            modelo.addColumn("Nome");
            modelo.addColumn("Gênero");
            modelo.addColumn("Status");
            modelo.addColumn("Versão");
            
            //adicionando os dados na tabela
            tblResultado.setModel(modelo);
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void bntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarActionPerformed
        // adicionando o que foi escrito no campo
        pfisica.setNome(txtNome.getText());
        //fazendo a bsuca no rep com o filtro
        List<PessoaFisica> resultado = repositorio.Buscar(pfisica);
        //criou um modelo vazio
        DefaultTableModel modelo = new DefaultTableModel();
        //adicionando as colunas
        modelo.addColumn("ID");
        modelo.addColumn("CPF");
        modelo.addColumn("RG");
        modelo.addColumn("Nome");
        modelo.addColumn("Gênero");
        modelo.addColumn("Status");
        modelo.addColumn("Versão");
        
        //adicionando as linhas
        for(PessoaFisica p : resultado){
            Vector linha = new Vector();
            linha.add(p.getId());
            linha.add(p.getCpf());
            linha.add(p.getRg());
            linha.add(p.getNome());
            linha.add(p.getGenero());
            linha.add(p.getStatus());
            linha.add(p.getVersao());
            
            modelo.addRow(linha);
        }
        
        //adicionando os dados na tabela
        tblResultado.setModel(modelo);

    }//GEN-LAST:event_bntBuscarActionPerformed

    private void btnTelefonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelefonesActionPerformed
        // TODO add your handling code here:
        PessoaTelefone tela = new PessoaTelefone();
        tela.getParent().add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_btnTelefonesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscar;
    private javax.swing.JButton btnEmails;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovaPFisica;
    private javax.swing.JButton btnTelefones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
