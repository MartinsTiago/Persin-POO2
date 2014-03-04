package view;

import control.DisciplinaControl;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

public abstract class CadastroEventoIFrame extends javax.swing.JInternalFrame {

    public CadastroEventoIFrame() {
        initComponents();
        this.setupIframeConfigs();
        this.dataChooser.setDateFormatString("dd/MM/yyyy");
        this.setupDiscChooser();
    }

    public CadastroEventoIFrame(Date date) {
        initComponents();
        this.setupIframeConfigs();
        this.dataChooser.setDateFormatString("dd/MM/yyyy");
        this.dataChooser.setDate(date);
    }
    private void setupDiscChooser(){
        this.discChooser.setModel(new DefaultComboBoxModel(DisciplinaControl.getDisciplinas().toArray()));
    }

    public void setupIframeConfigs(){
        this.setTitle("Criar Eventos");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setClosable(true);
        if (DisciplinaControl.getDisciplinas().isEmpty()){
            this.avaliativoChoose.setEnabled(false);
        }
    }

    public abstract void clearAllFields();

    @SuppressWarnings("unchecked")

    public void initComponents() {

    }

    public void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public abstract void avaliativoChooseActionPerformed(java.awt.event.ActionEvent evt);

    public void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser dataChooser;
    public javax.swing.JComboBox discChooser;
    public javax.swing.JCheckBox avaliativoChoose;
    // End of variables declaration//GEN-END:variables
}
