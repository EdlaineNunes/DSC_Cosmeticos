/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemacomercial.apresentacao.desktop;

import br.edu.ifnmg.logicaaplicacao.Funcao;
import br.edu.ifnmg.logicaaplicacao.Genero;
import br.edu.ifnmg.logicaaplicacao.RepositorioFactory;
import br.edu.ifnmg.logicaaplicacao.Status;
import br.edu.ifnmg.logicaaplicacao.Usuario;
import br.edu.ifnmg.logicaaplicacao.UsuarioRepositorio;
import javax.swing.JOptionPane;

/**
 *
 * @author edlaine
 */
public class UsuarioEditar extends javax.swing.JInternalFrame {

    Usuario usuario;
    UsuarioRepositorio repositorio;
    /**
     * Creates new form UsuarioEditar
     */
    public UsuarioEditar(Usuario u) {
        this.usuario = u;
        this.repositorio = RepositorioFactory.getUsuarioRepositorio();
        initComponents();
        
        this.setComponentes();
    }

    private void setComponentes(){
        this.lblIDUsuario.setText(this.usuario.getId().toString());
        this.txtCPF.setText(this.usuario.getCpf());
        this.txtNome.setText(this.usuario.getNome());
        this.txtLogin.setText(this.usuario.getLogin());
        this.txtSenha.setText(this.usuario.getSenha());
        this.cbxGenero.setSelectedItem(this.usuario.getSexo().name());
        this.cbxFuncao.setSelectedItem(this.usuario.getFuncao().name());
        this.cbxStatus.setSelectedItem(this.usuario.getStatus().name());
    }
    
    private void getComponentes(){
        this.usuario.setCpf(this.txtCPF.getText());
        this.usuario.setNome(this.txtNome.getText());
        this.usuario.setLogin(this.txtLogin.getText());
        this.usuario.setSenha(String.valueOf(this.txtSenha.getPassword()));
        this.usuario.setSexo(Genero.valueOf(this.cbxGenero.getSelectedItem().toString()));
        this.usuario.setFuncao(Funcao.valueOf(this.cbxFuncao.getSelectedItem().toString()));
        this.usuario.setStatus(Status.valueOf(this.cbxStatus.getSelectedItem().toString()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblFuncao = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        cbxGenero = new javax.swing.JComboBox<>();
        cbxFuncao = new javax.swing.JComboBox<>();
        cbxStatus = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        lblIDUsuario = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();
        txtCPF = new javax.swing.JFormattedTextField();

        setClosable(true);
        setTitle("Editar Usuário");
        setToolTipText("Editar Usuário.");

        lblLogin.setText("Login:");

        lblSenha.setText("Senha:");

        lblID.setText("ID:");

        lblNome.setText("Nome:");

        lblCPF.setText("CPF:");

        lblGenero.setText("Gênero:");

        lblFuncao.setText("Função:");

        lblStatus.setText("Status:");

        txtNome.setToolTipText("Nome do Usuário.");

        txtLogin.setToolTipText("Login do Usuário.");

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Transgênero", "Outro" }));
        cbxGenero.setToolTipText("Gênero do Usuário.");

        cbxFuncao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atendente", "Caixa", "Gerente" }));
        cbxFuncao.setToolTipText("Função atual do Usuário.");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        cbxStatus.setToolTipText("Status atual do Usuário.");

        btnSalvar.setText("SALVAR");
        btnSalvar.setToolTipText("Clique para SALVAR os dados de Usuário.");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtSenha.setToolTipText("Senha do Usuário.");

        lblIDUsuario.setText("0");
        lblIDUsuario.setToolTipText("ID do Usuário.");

        btnRemover.setText("REMOVER");
        btnRemover.setToolTipText("Clique para REMOVER o Usuário atual.");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        bntCancelar.setText("CANCELAR");
        bntCancelar.setToolTipText("Clique para CANCELAR a operação.");
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###'.###'.###'-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(37, 37, 37)
                        .addComponent(btnRemover)
                        .addGap(42, 42, 42)
                        .addComponent(bntCancelar)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblID)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblIDUsuario))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblLogin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtLogin))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCPF)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCPF))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNome))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSenha)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSenha))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblStatus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblFuncao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxFuncao, 0, 406, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblGenero)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblIDUsuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncao)
                    .addComponent(cbxFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnRemover)
                    .addComponent(bntCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente salvar os dados do Usuário?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){
            this.getComponentes();
            if(repositorio.Salvar(this.usuario)){
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
        if(JOptionPane.showConfirmDialog(this, "Deseja realmente remover o usuário atual?", "Confirmação", JOptionPane.YES_NO_OPTION)
            == JOptionPane.YES_OPTION){
            if(repositorio.Apagar(this.usuario)){
                JOptionPane.showMessageDialog(this, "Usuário removido com sucesso!","Sucesso!",
                    JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Aconteceu um problema ao remover os dados!","Erro!",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Operação Cancelada!","Informação!",
            JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }//GEN-LAST:event_bntCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxFuncao;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIDUsuario;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
