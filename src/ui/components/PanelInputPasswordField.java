/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

/**
 *
 * @author Veljko
 */
public class PanelInputPasswordField extends javax.swing.JPanel implements IValue{

    /**
     * Creates new form PanelInputPasswordField
     */
    public PanelInputPasswordField() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFieldText = new javax.swing.JLabel();
        lblFieldError = new javax.swing.JLabel();
        txtInputField = new javax.swing.JPasswordField();

        lblFieldText.setText("label");

        lblFieldError.setForeground(new java.awt.Color(255, 0, 0));
        lblFieldError.setText("label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFieldError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFieldText, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addGap(87, 87, 87)
                        .addComponent(txtInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFieldText)
                    .addComponent(txtInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFieldError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblFieldError;
    private javax.swing.JLabel lblFieldText;
    private javax.swing.JPasswordField txtInputField;
    // End of variables declaration//GEN-END:variables

    @Override
    public Object getValue() {
        return txtInputField.getText();
    }

    @Override
    public void initialize(Object initValue) {
        txtInputField.setText((String) initValue);
    }

    @Override
    public void setValue(Object value) {
         txtInputField.setText((String) value);
    }

    public javax.swing.JLabel getLblFieldError() {
        return lblFieldError;
    }

    public void setLblFieldError(javax.swing.JLabel lblFieldError) {
        this.lblFieldError = lblFieldError;
    }

    public javax.swing.JLabel getLblFieldText() {
        return lblFieldText;
    }

    public void setLblFieldText(javax.swing.JLabel lblFieldText) {
        this.lblFieldText = lblFieldText;
    }

    public javax.swing.JPasswordField getTxtInputField() {
        return txtInputField;
    }

    public void setTxtInputField(javax.swing.JPasswordField txtInputField) {
        this.txtInputField = txtInputField;
    }
    
    
}