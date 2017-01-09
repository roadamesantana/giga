package giga.view.reg;

import giga.controller.EmailController;
import giga.controller.FornecedorController;
import giga.controller.TelefoneController;
import giga.model.Email;
import giga.model.Fornecedor;
import giga.model.Telefone;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ronald
 */
public class RegistrarFornecedorView extends javax.swing.JDialog {
    private Fornecedor fornecedor;
    private ArrayList<Telefone> telefones;
    private ArrayList<Email> emails;
    
    private TelefoneController tController;
    private EmailController eController;
    

    public RegistrarFornecedorView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        start();
        
        setLocationRelativeTo( null );
        
        setTitle("Novo Fornecedor");
    }
    
    public RegistrarFornecedorView(java.awt.Frame parent, boolean modal, Fornecedor fornecedor) {
        super(parent, modal);
        initComponents();
        start();
        
        setLocationRelativeTo( null );
        
        setTitle(fornecedor.getNome());
        
        txtNome.setText(fornecedor.getNome());
        txtDescricao.setText(fornecedor.getDescricao());
        txtCidade.setText(fornecedor.getCidade());
        txtEndereco.setText(fornecedor.getEndereco());
        txtBairro.setText(fornecedor.getBairro());
        txtNumero.setText(String.valueOf(fornecedor.getNumero()));
        telefones = fornecedor.getTelefones();
        emails = fornecedor.getEmails();
        
        for (Telefone tel : telefones) {
            ((DefaultListModel)lstTelefones.getModel()).addElement(tel);            
        }
        
        for (Email email : emails) {
            ((DefaultListModel)lstEmails.getModel()).addElement(email);
        }
        
        this.fornecedor = fornecedor;
    }
    
    private void start(){
        telefones = new ArrayList<>();
        emails = new ArrayList<>();
        
        tController = new TelefoneController();
        eController = new EmailController();
        
        lstTelefones.setModel(tController.getTelefonesListModel());
        lstEmails.setModel(eController.getEmailsListModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTelefones = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEmails = new javax.swing.JList<>();
        btnAddTelefone = new javax.swing.JButton();
        btnAddEmail = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Descrição");

        jLabel3.setText("Endereco");

        jLabel4.setText("Número");

        jLabel5.setText("Bairro");

        jLabel6.setText("Cidade");

        lstTelefones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstTelefones);

        jLabel7.setText("Telefones");

        jLabel8.setText("Emails");

        lstEmails.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstEmails);

        btnAddTelefone.setText("+");
        btnAddTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTelefoneActionPerformed(evt);
            }
        });

        btnAddEmail.setText("+");
        btnAddEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmailActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescricao)
                    .addComponent(txtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 57, Short.MAX_VALUE))
                            .addComponent(txtNumero)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCidade)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddEmail, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddTelefone)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddEmail)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTelefoneActionPerformed
        Telefone tel = tController.getTelefone();
        if ( null == tel ){
            return;
        }
        
        telefones.add(tel);
        
        ((DefaultListModel)lstTelefones.getModel()).addElement(tel);
    }//GEN-LAST:event_btnAddTelefoneActionPerformed

    private void btnAddEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmailActionPerformed
        Email email = eController.getEmail();
        if ( null == email ){
            return;
        }
        
        emails.add(email);
        
        ((DefaultListModel)lstEmails.getModel()).addElement(email.toString());
    }//GEN-LAST:event_btnAddEmailActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if ( null == fornecedor ){
            Fornecedor forn = new Fornecedor();
            forn.setNome(txtNome.getText());
            forn.setDescricao(txtDescricao.getText());
            forn.setCidade(txtCidade.getText());
            forn.setEndereco(txtEndereco.getText());
            forn.setBairro(txtBairro.getText());
            forn.setNumero(Integer.parseInt(txtNumero.getText()));
            forn.setEmails(emails);
            forn.setTelefones(telefones);
            
            FornecedorController.getInstancia().addFornecedor(forn);
        } else {
            fornecedor.setNome(txtNome.getText());
            fornecedor.setDescricao(txtDescricao.getText());
            fornecedor.setCidade(txtCidade.getText());
            fornecedor.setEndereco(txtEndereco.getText());
            fornecedor.setBairro(txtBairro.getText());
            fornecedor.setNumero(Integer.parseInt(txtNumero.getText()));
            fornecedor.setEmails(emails);
            fornecedor.setTelefones(telefones);
            FornecedorController.getInstancia().editarFornecedor(fornecedor);
        }
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmail;
    private javax.swing.JButton btnAddTelefone;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstEmails;
    private javax.swing.JList<String> lstTelefones;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
