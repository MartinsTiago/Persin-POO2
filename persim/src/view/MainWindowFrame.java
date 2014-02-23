package view;

import config.Path;
import control.StickyNotesControl;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
//import javax.swing.JOptionPane;

public class MainWindowFrame extends javax.swing.JFrame {

    public MainWindowFrame() {
        setMainWindowConfigurations();
        setDesktopConfigurations();
    }

    public void setMainWindowConfigurations () {
        this.initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Path.getImagePath("persimlogo.png")));
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(tela.width, tela.height);
        this.setVisible(true);

    }

    public void setDesktopConfigurations () {
        this.stickyNotes = StickyNotesControl.buildStickyNotesIFrames();
        for (StickyNotesIFrame stickyNotesIFrame : stickyNotes) {
            this.desktopPane.add(stickyNotesIFrame);
        }
        this.calframe = new CalendarIFrame();
        this.desktopPane.add(this.calframe);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
     void initComponents() {

        //jMenuItem2 = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        //jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>
     
    //Atributos declarados
    private CalendarIFrame calframe;
    public List<StickyNotesIFrame> stickyNotes;
    
    // Variables declaration - do not modify
    public javax.swing.JDesktopPane desktopPane;
    public javax.swing.JMenuBar menuBar;
    // End of variables declaration
}
