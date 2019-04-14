package br.senac.sp.ui;

import br.senac.ui.produtos.Produtos;
import br.senac.ui.vendas.RelatorioVendas;
import br.senac.ui.vendas.TelaVenda;
import br.senac.ui.cliente.TelaEditarCliente;
import br.senac.ui.cliente.ManipulacaoCliente;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * Tela Principal
 */
public class Menu extends javax.swing.JFrame {

    private TelaEditarCliente editarCliente = null;
    private ManipulacaoCliente manipulacaoCliente = null;
    private Produtos produtos = null;
    private TelaVenda vendas = null;
    private RelatorioVendas relatorioVvendas = null;
    /**
     * Construtor
     */
    public Menu() {

        initComponents();
// abre janela no meio da tela
        this.setLocationRelativeTo(null);
    }

    /**
     * Metodos de abertura das telas
     */
    public ManipulacaoCliente getManipulacaoCliente() {
        return manipulacaoCliente;
    }

    public void setManipulacaoCliente(ManipulacaoCliente manipulacaoCliente) {
        this.manipulacaoCliente = manipulacaoCliente;
    }

    public TelaEditarCliente getEditarCliente() {
        return editarCliente;
    }

    public void setEditarCliente(TelaEditarCliente editarCliente) {
        this.editarCliente = editarCliente;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public TelaVenda getVenda() {
        return vendas;
    }

    public void setVenda(TelaVenda venda) {
        this.vendas = vendas;
    }

    /*
    * Código de contruçãos dos componentes do GUI Builder
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jSplitPane1 = new javax.swing.JSplitPane();
        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenu();
        menuClienteAcao = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        menuManipularProdutosAcao = new javax.swing.JMenuItem();
        MenuVendas = new javax.swing.JMenu();
        menuAcaoVenda = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setBackground(new java.awt.Color(130, 189, 87));

        jDesktopPane.setAutoscrolls(true);
        jDesktopPane.setEnabled(false);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1169, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        jMenu1.setText("Arquivo");
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator2);

        jMenu3.setText("jMenu3");
        jMenu1.add(jMenu3);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        menuClientes.setText("Clientes");

        menuClienteAcao.setText("Manipular Cliente");
        menuClienteAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteAcaoActionPerformed(evt);
            }
        });
        menuClientes.add(menuClienteAcao);

        jMenuBar1.add(menuClientes);

        menuProdutos.setText("Produtos");

        menuManipularProdutosAcao.setText("Manipular Produtos");
        menuManipularProdutosAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManipularProdutosAcaoActionPerformed(evt);
            }
        });
        menuProdutos.add(menuManipularProdutosAcao);

        jMenuBar1.add(menuProdutos);

        MenuVendas.setText("Vendas");

        menuAcaoVenda.setText("Tela de Vendas");
        menuAcaoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcaoVendaActionPerformed(evt);
            }
        });
        MenuVendas.add(menuAcaoVenda);
        MenuVendas.add(jSeparator3);

        jMenuItem7.setText("Relatorio de Vendas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MenuVendas.add(jMenuItem7);

        jMenuBar1.add(MenuVendas);

        jMenu6.setText("Ajuda");

        jMenuItem8.setText("Sobre");
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuClienteAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteAcaoActionPerformed
        // TODO add your handling code here:
        // Verifica se não há uma janela de manipulação de clientes visivel

        if (manipulacaoCliente == null || !manipulacaoCliente.isDisplayable()) {
            manipulacaoCliente = new ManipulacaoCliente();
            jDesktopPane.add(manipulacaoCliente);
            this.openFrameInCenter(manipulacaoCliente);

        }
        manipulacaoCliente.toFront();

    }//GEN-LAST:event_menuClienteAcaoActionPerformed

    /*
    * Menu de manipulação de Produtos
     */
    private void menuManipularProdutosAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManipularProdutosAcaoActionPerformed
        if (produtos == null || !produtos.isDisplayable()) {
            produtos = new Produtos();
            jDesktopPane.add(produtos);
            this.openFrameInCenter(produtos);

        }
        produtos.toFront();
    }//GEN-LAST:event_menuManipularProdutosAcaoActionPerformed

    /*
    * Abre janela de Vendas no menu Principal
     */
    private void menuAcaoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcaoVendaActionPerformed
        if (vendas == null || !vendas.isDisplayable()) {
            vendas = new TelaVenda();
            jDesktopPane.add(vendas);
            this.openFrameInCenter(vendas);

        }
        vendas.toFront();
    }//GEN-LAST:event_menuAcaoVendaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        if (relatorioVvendas == null || !relatorioVvendas.isDisplayable()) {
            relatorioVvendas = new RelatorioVendas();
            jDesktopPane.add(relatorioVvendas);
            this.openFrameInCenter(relatorioVvendas);

        }
        relatorioVvendas.toFront();
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    /*
    *  Método de Criação de frame Centralizado na tela
     */
    private void openFrameInCenter(JInternalFrame jif) {
        Dimension desktopSize = jDesktopPane.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);

    }

    //Abre um internal frame centralizado na tela
    /**
     * Método de inicialização da classe e do sistema
     *
     * @param args
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Menu().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuVendas;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuItem menuAcaoVenda;
    private javax.swing.JMenuItem menuClienteAcao;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenuItem menuManipularProdutosAcao;
    private javax.swing.JMenu menuProdutos;
    // End of variables declaration//GEN-END:variables

}
