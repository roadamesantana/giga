package giga.view;

import javax.swing.JFrame;

/**
 * @author Ronald
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        
        setLocationRelativeTo( null );        
        setExtendedState( JFrame.MAXIMIZED_BOTH );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuFornecedor = new javax.swing.JMenuItem();
        jMenuPedido = new javax.swing.JMenuItem();
        jMenuProduto = new javax.swing.JMenuItem();
        jMenuTransportadora = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Giga");

        jMenuCadastros.setText("Cadastros");

        jMenuFornecedor.setText("Fornecedor");
        jMenuFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFornecedorActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuFornecedor);

        jMenuPedido.setText("Pedido");
        jMenuPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPedidoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuPedido);

        jMenuProduto.setText("Produto");
        jMenuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuProduto);

        jMenuTransportadora.setText("Transportadora");
        jMenuTransportadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTransportadoraActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuTransportadora);

        jMenuBar1.add(jMenuCadastros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuTransportadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTransportadoraActionPerformed
        TransportadorasView view = new TransportadorasView(this, true);
        view.setVisible(true);
    }//GEN-LAST:event_jMenuTransportadoraActionPerformed

    private void jMenuFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFornecedorActionPerformed
        FornecedoresView view = new FornecedoresView(this, true);
        view.setVisible(true);
    }//GEN-LAST:event_jMenuFornecedorActionPerformed

    private void jMenuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutoActionPerformed
        ProdutosView view = new ProdutosView(this, true);
        view.setVisible(true);
    }//GEN-LAST:event_jMenuProdutoActionPerformed

    private void jMenuPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPedidoActionPerformed
        PedidosView view = new PedidosView(this, true);
        view.setVisible(true);
    }//GEN-LAST:event_jMenuPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuFornecedor;
    private javax.swing.JMenuItem jMenuPedido;
    private javax.swing.JMenuItem jMenuProduto;
    private javax.swing.JMenuItem jMenuTransportadora;
    // End of variables declaration//GEN-END:variables
}
