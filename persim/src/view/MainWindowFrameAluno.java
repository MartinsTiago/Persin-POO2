/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import control.DatabaseConfigControl;
import javax.swing.JOptionPane;

/**
 *
 * @author araujot
 */
public final class MainWindowFrameAluno extends MainWindowFrame {
    
    public MainWindowFrameAluno() {
        super();
    }

    
    @Override
    public void setMainWindowConfigurations () {
        initComponents();
        super.setMainWindowConfigurations ();
        this.setTitle("PERSIM - Personal Student Info. Manager");
    }
    
    @Override
    public void setDesktopConfigurations () {
        super.setDesktopConfigurations();
    }
    
    @Override
    public void initComponents() {
        super.initComponents();
        
        periodoMenu = new javax.swing.JMenu();
        novoPeriodoMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        disciplinaMenu = new javax.swing.JMenuItem();
        criarMenu = new javax.swing.JMenu();
        eventoMenu = new javax.swing.JMenuItem();
        lembreteMenuItem = new javax.swing.JMenuItem();
        
        
        periodoMenu.setText("Periodo");

        novoPeriodoMenuItem.setText("Novo Periodo");
        novoPeriodoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoPeriodoMenuItemActionPerformed(evt);
            }
        });
        periodoMenu.add(novoPeriodoMenuItem);

        jMenuItem1.setText("Estatísticas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        periodoMenu.add(jMenuItem1);

        disciplinaMenu.setText("Disciplina");
        disciplinaMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinaMenuActionPerformed(evt);
            }
        });
        periodoMenu.add(disciplinaMenu);

        menuBar.add(periodoMenu);

        criarMenu.setText("Criar");

        eventoMenu.setText("Evento");
        eventoMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventoMenuActionPerformed(evt);
            }
        });
        criarMenu.add(eventoMenu);

        lembreteMenuItem.setText("Lembrete");
        lembreteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lembreteMenuItemActionPerformed(evt);
            }
        });
        criarMenu.add(lembreteMenuItem);

        menuBar.add(criarMenu);
        
    }
    
    private void novoPeriodoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        int resp = JOptionPane.showConfirmDialog(this, "Deseja começar um novo período?"
                + " Você irá perder todos os dados deste período.", "Novo período",
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
        if (resp == 0){
            DatabaseConfigControl.resetDB();
            this.desktopPane.removeAll();
            this.setDesktopConfigurations();
            this.desktopPane.repaint();
        }
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Não implementado para versão gratuita!", "Ops!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void disciplinaMenuActionPerformed(java.awt.event.ActionEvent evt) {
        this.cadDisc = new CadastroDisciplinaAluno();
        this.desktopPane.add(this.cadDisc);
        this.cadDisc.setVisible(true);
    }
    
    private void eventoMenuActionPerformed(java.awt.event.ActionEvent evt) {
        this.eventFrame = new CadastroEventoIFrame();//instancia a classe iFrmCliente
        desktopPane.add(this.eventFrame);//adiciona o cliente no seu JdesktopPane
        this.eventFrame.setLocation(400, 0);//colocar a tela iFrmCliente na posiÃ§Ã£o(0,0)
        this.eventFrame.setVisible(true);//deixa visÃ­vel
    }
    
    private void lembreteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.stickyFrame = new CadastroStickyNotesIFrame(this.stickyNotes);
        desktopPane.add(this.stickyFrame);
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindowFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindowFrameAluno().setVisible(true);
            }
        });
    }
    
    private CadastroDisciplina cadDisc;
    private CadastroEventoIFrame eventFrame;
    private CadastroStickyNotesIFrame stickyFrame;
    
    private javax.swing.JMenuItem eventoMenu;
    private javax.swing.JMenu criarMenu;
    private javax.swing.JMenuItem disciplinaMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem lembreteMenuItem;
    private javax.swing.JMenuItem novoPeriodoMenuItem;
    private javax.swing.JMenu periodoMenu;
}
