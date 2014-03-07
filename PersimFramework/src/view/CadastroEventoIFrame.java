package view;

import model.Evento;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public abstract class CadastroEventoIFrame extends javax.swing.JInternalFrame {

    private javax.swing.JButton cancelBtn;
    private com.toedter.calendar.JDateChooser dataChooser;
    private JPanel datePanel = new JPanel(new FlowLayout((int) LEFT_ALIGNMENT));
    private JPanel descriptionPanel = new JPanel();
    private javax.swing.JTextPane descricaoText;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JScrollPane descricaoPanel;
    private JPanel savePanel = new JPanel();
    private javax.swing.JButton saveBtn;

    public abstract void addPanelsBeforeDescription(JInternalFrame frame);
    public abstract void addToDatePanel(JPanel panel);
    public abstract void saveToDB(Evento evento);

    public CadastroEventoIFrame() {
        initComponents();
        this.setupIframeConfigs();
        this.dataChooser.setDateFormatString("dd/MM/yyyy");
    }

    public CadastroEventoIFrame(Date date) {
        initComponents();
        this.setupIframeConfigs();
        this.dataChooser.setDateFormatString("dd/MM/yyyy");
        this.dataChooser.setDate(date);
    }


    private void setupIframeConfigs(){
        this.setTitle("Criar Eventos");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setClosable(true);
        this.descricaoText.addKeyListener(new LimitDigitsListener(200, this.descricaoText));
    }

    private void clearAllFields(){
        this.descricaoText.setText("");
        this.dataChooser.setDate(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        this.setSize(415, 430);
        descricaoLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        dataChooser = new com.toedter.calendar.JDateChooser();
        descricaoPanel = new javax.swing.JScrollPane();
        descricaoText = new javax.swing.JTextPane();

        setTitle("Criando Eventos");

        descricaoLabel.setText("Descrição:");

        dataLabel.setText("Data:");

        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Salvar");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        datePanel.add(dataLabel);
        datePanel.add(dataChooser);
        addToDatePanel(datePanel);
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.X_AXIS));
        descriptionPanel.add(descricaoLabel);
        descriptionPanel.add(descricaoText);
        this.add(datePanel);
        addPanelsBeforeDescription(this);
        savePanel.add(saveBtn);
        savePanel.add(cancelBtn);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(descriptionPanel);
        this.add(savePanel);
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            Evento evento = new Evento();
            String str = (new Timestamp(this.dataChooser.getDate().getTime())).toString().split(" ")[0];
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse(str);
            evento.setData(new Timestamp(dt.getTime()));
            evento.setDescricao(this.descricaoText.getText());
            saveToDB(evento);
            this.clearAllFields();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Campos com valores invalidos para criar novo evento.", "ops!", JOptionPane.OK_OPTION);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "O campo de data não foi preenchido!", "ops!", JOptionPane.OK_OPTION);
        }

    }

}
