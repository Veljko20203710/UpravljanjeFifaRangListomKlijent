/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

import controller.Controller;
import domain.Confederation;
import domain.Selection;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import ui.listeners.ListenerDeleteSelection;
import ui.table.ModelTableRangList;

/**
 *
 * @author Veljko
 */
public class FrmViewRangList extends javax.swing.JFrame {

    /**
     * Creates new form FrmViewRangList
     */
    private int tableSize = 5;
    private int startPosition = 0;
    private List<Selection> allSelections;
    private List<Selection> selectionsByConfederation;
    private ResourceBundle resourceBundle;
    private Locale locale;
    private final Logger LOGGER = Logger.getLogger(FrmViewRangList.class);

    public FrmViewRangList() {
        initComponents();
        prepareView();
        readSelections();
        setTable();
        initListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLblTableSize = new javax.swing.JLabel();
        comboTableSize = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRangList = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        JLblForward = new javax.swing.JLabel();
        JLblBackward = new javax.swing.JLabel();
        panelInputConfederation = new ui.components.PanelInputComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JLblTableSize.setText("Prikaz broja reprezentacija:");

        comboTableSize.setModel(new javax.swing.DefaultComboBoxModel<>());
        comboTableSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTableSizeActionPerformed(evt);
            }
        });

        jTableRangList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableRangList);

        btnDelete.setText("jButton1");

        JLblForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Button-Forward-icon.png"))); // NOI18N
        JLblForward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLblForwardMouseClicked(evt);
            }
        });

        JLblBackward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Fast-backward-icon.png"))); // NOI18N
        JLblBackward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLblBackwardMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLblTableSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboTableSize, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JLblBackward)
                        .addGap(76, 76, 76)
                        .addComponent(btnDelete)
                        .addGap(66, 66, 66)
                        .addComponent(JLblForward)))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelInputConfederation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLblTableSize)
                    .addComponent(comboTableSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInputConfederation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLblBackward, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLblForward, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JLblBackwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLblBackwardMouseClicked
        if (startPosition - tableSize < 0) {
            return;
        }
        startPosition -= tableSize;
        setTable();
    }//GEN-LAST:event_JLblBackwardMouseClicked

    private void JLblForwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLblForwardMouseClicked
        if (startPosition + tableSize >= selectionsByConfederation.size()) {
            return;
        }
        startPosition += tableSize;
        setTable();
    }//GEN-LAST:event_JLblForwardMouseClicked

    private void comboTableSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTableSizeActionPerformed
        tableSize = (int) comboTableSize.getSelectedItem();
        startPosition = 0;
        setTable();
    }//GEN-LAST:event_comboTableSizeActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(FrmViewRangList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmViewRangList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmViewRangList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmViewRangList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmViewRangList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLblBackward;
    private javax.swing.JLabel JLblForward;
    private javax.swing.JLabel JLblTableSize;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<Integer> comboTableSize;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRangList;
    private ui.components.PanelInputComboBox panelInputConfederation;
    // End of variables declaration//GEN-END:variables

    public final void setTable() {
        ModelTableRangList modelTable = new ModelTableRangList(selectionsByConfederation, startPosition, tableSize);
        jTableRangList.setModel(modelTable);
    }

    private void readSelections() {
        try {
            allSelections = controller.Controller.getInstance().getRangList();
            selectionsByConfederation = allSelections;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    resourceBundle.getString("error"),
                    resourceBundle.getString("errorTitle"),
                    0);
            dispose();
            LOGGER.error(ex);
        }
    }

    private void prepareView() {
        setIcon();
        initResourceBundle();
        setText();
        initComboBoxes();
        setBtnDeleteEnabled();
    }

    private void setBtnDeleteEnabled() {
        try {
            btnDelete.setEnabled(Controller.getInstance().readAdministrator());
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    private void setText() {
        JLblTableSize.setText(resourceBundle.getString("numberSelection"));
        btnDelete.setText(resourceBundle.getString("btnDelete"));
        panelInputConfederation.getLblError().setText("");
        panelInputConfederation.getLblFieldText().setText(resourceBundle.getString("confederation"));
    }

    private void initComboBoxes() {
        initComboTable();
        initComboConfederation();
    }

    private void initComboTable() {
        comboTableSize.removeAllItems();
        comboTableSize.addItem(5);
        comboTableSize.addItem(10);
        comboTableSize.addItem(15);
    }

    private void initComboConfederation() {
        try {
            panelInputConfederation.getCbField().addItem(resourceBundle.getString("all"));
            List<Confederation> confederations = Controller.getInstance().getAllConfederations();
            panelInputConfederation.initialize(confederations);
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    private void setIcon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/ball.png")));
    }

    private void initResourceBundle() {
        locale = Controller.getLocale();
        resourceBundle = ResourceBundle.getBundle("resourceBundles.resourceBundle_FrmViewRangList_" + locale);
    }

    private void initListeners() {
        initBtnDeleteListener();
        initListenerComboBoxConfederation();
    }

    private void initBtnDeleteListener() {
        btnDelete.addActionListener(new ListenerDeleteSelection(this));
    }

    private void initListenerComboBoxConfederation() {
        panelInputConfederation.getCbField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelInputConfederation.getCbField().getSelectedIndex() == 0) {
                    selectionsByConfederation = allSelections;
                    setTable();
                } else {
                    Confederation confederation = (Confederation) panelInputConfederation.getCbField().getSelectedItem();
                    List<Selection> selectionByConfederation = getSelectionsByConfederation(confederation);
                    startPosition = 0;
                    ModelTableRangList modelTable = new ModelTableRangList(selectionByConfederation, startPosition, tableSize);
                    jTableRangList.setModel(modelTable);
                }
            }
        });
    }

    private List<Selection> getSelectionsByConfederation(Confederation confederation) {
        selectionsByConfederation = new LinkedList<>();
        for (Selection selection : allSelections) {
            if (selection.getConfederation().equals(confederation)) {
                selectionsByConfederation.add(selection);
            }
        }
        return selectionsByConfederation;
    }

    public JTable getjTableRangList() {
        return jTableRangList;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public int getStartPositon() {
        return startPosition;
    }

    public List<Selection> getSelections() {
        return selectionsByConfederation;
    }

    public void removeSelection(Selection selection) {
        selectionsByConfederation.remove(selection);
        allSelections.remove(selection);
        setTable();
    }
}
