package br.ufu.facom.persim.view;

import br.ufu.facom.persim.config.Path;
import br.ufu.facom.persim.control.AudioFilePlayer;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Notifications {
    
    public static final String ATENTION_ICON = "atention.png";
    public static final String ERROR_ICON = "error.png";
    
    public static void showMessage(String header, String message, String type) {
        
        final JFrame frame = new JFrame();
        frame.setSize(300, 150);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        JLabel headingLabel = new JLabel(header);
        ImageIcon headingIcon = new ImageIcon(Path.getImagePath(type));
        Image newImg = headingIcon.getImage().getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
        headingIcon = new ImageIcon(newImg);
        headingLabel.setIcon(headingIcon); // --- use image icon you want to be as heading image.
        headingLabel.setOpaque(false);
        frame.add(headingLabel, constraints);
        constraints.gridx++;
        constraints.weightx = 0f;
        constraints.weighty = 0f;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        JButton cloesButton = new JButton("X");
        cloesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        cloesButton.setMargin(new Insets(1, 4, 1, 4));
        cloesButton.setFocusable(false);
        frame.add(cloesButton, constraints);
        constraints.gridx = 0;
        constraints.gridy++;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        JLabel messageLabel = new JLabel(message);
        frame.add(messageLabel, constraints);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
        Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar
        frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight());
        playSound();
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }
    
    public static synchronized void playSound() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AudioFilePlayer audio = new AudioFilePlayer();
                audio.play(Path.getAudioPath("notification.wav"));
            }
        });
        
        thread.start();
    }
}
