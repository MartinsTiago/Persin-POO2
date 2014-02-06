package br.ufu.facom.persim.view;

import br.ufu.facom.persim.config.Path;
import br.ufu.facom.persim.control.StickyNotesControl;
import br.ufu.facom.persim.model.StickyNote;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class StickyNotesIFrame extends JInternalFrame {

    private volatile int screenX = 0;
    private volatile int screenY = 0;
    private volatile int myX = 0;
    private volatile int myY = 0;
    private JTextArea message;
    private StickyNote stk;
    private static Color[] colorArray = new Color[] {
        new Color(255,204,240),
        new Color(137,207,240),
        new Color(255, 255, 153),
        new Color(204, 255, 153),
        new Color(204, 255, 255),
        new Color(255, 153, 153)
    };
    private static int index = 0;

    public StickyNotesIFrame() {
        this.setupIframeConfigs();
    }
    
    public StickyNotesIFrame(StickyNote stk) {
        this.stk = stk;
        this.setLocation(this.stk.getXpos(), this.stk.getYpos());
        this.setupIframeConfigs();
        this.message.setText(this.stk.getText());
    }

    private void setupIframeConfigs() {
        
        this.setVisible(true);
        this.setSize(170, 180);
        this.setOpaque(false);
        ImageIcon iconeX = new ImageIcon(Path.getImagePath("x.png"));
        Image img = iconeX.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        iconeX = new ImageIcon(img);
        JLabel lb = new JLabel(iconeX);

        this.getContentPane().setLayout(null);
        this.getContentPane().add(lb);
        lb.setBounds(this.getSize().width-28, 3, 15, 15);
        this.setBackground(new Color(0, 0, 0, 0));
        this.getContentPane().setBackground(colorArray[index]);
        index++;
        index = index%colorArray.length;
        this.message = new JTextArea();
        this.message.setBounds(5, 20, this.getSize().width-25,this.getSize().height-35);
        this.message.setBackground(new Color(0,0,0,0));
        this.message.setBorder(null);
        this.message.setLineWrap(true);
        this.getContentPane().add(this.message);
        this.message.setEditable(false);
        this.setVisible(true);

        lb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                deleteStickyNote();
                closeThisFrame();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);


        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
        MouseListener listener = new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                screenX = e.getXOnScreen();
                screenY = e.getYOnScreen();

                myX = getX();
                myY = getY();                    
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                updateStickyNotePostion();
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        
        MouseMotionListener motion = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getXOnScreen() - screenX;
                int deltaY = e.getYOnScreen() - screenY;

                setLocation(myX + deltaX, myY + deltaY);
            }

            @Override
            public void mouseMoved(MouseEvent e) {}
        };
        
        this.addMouseListener(listener);
        this.addMouseMotionListener(motion);
        this.message.addMouseListener(listener);
        this.message.addMouseMotionListener(motion);
    }

    private void closeThisFrame() {
        this.dispose();
    }
    
    private void updateStickyNotePostion(){
        this.stk.setXpos(this.getLocation().x);
        this.stk.setYpos(this.getLocation().y);
        StickyNotesControl.updateStickyNotePositionInfo(this.stk);
    }
    
    private void deleteStickyNote(){
        StickyNotesControl.delete(this.stk);
    }

    public StickyNote getStk() {
        return stk;
    }

    public void setStk(StickyNote stk) {
        this.stk = stk;
    }
    
    
}
