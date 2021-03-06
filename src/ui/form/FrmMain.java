/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

import controller.Controller;
import exceptions.ServerException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author Veljko
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    private Locale locale;
    private final Logger LOGGER = Logger.getLogger(FrmMain.class);
    private ResourceBundle resourceBundle;

    public FrmMain() {
        initResourceBundle();
        initComponents();
        prepareView();
        selectLanguage();
        initListeners();
        initAuthorization();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        lblImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuNew = new javax.swing.JMenu();
        jMenuItemNewMatch = new javax.swing.JMenuItem();
        jMenuItemNewSelection = new javax.swing.JMenuItem();
        jMenuView = new javax.swing.JMenu();
        jMenuItemViewRangList = new javax.swing.JMenuItem();
        jMenuViewSelection = new javax.swing.JMenuItem();
        jMenuChange = new javax.swing.JMenu();
        jMenuItemChangeSelection = new javax.swing.JMenuItem();
        jMenuCalculateRangList = new javax.swing.JMenu();
        jMenuItemCalculate = new javax.swing.JMenuItem();
        jMenuUsers = new javax.swing.JMenu();
        jMenuItemAll = new javax.swing.JMenuItem();
        jMenuItemChangeLanguage = new javax.swing.JMenu();
        jCheckBoxSerbian = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuEnglish = new javax.swing.JCheckBoxMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenuItem9.setText("jMenuItem9");

        jMenuItem3.setText("jMenuItem3");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Form");
        getContentPane().setLayout(null);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Webp.net-resizeimage.png"))); // NOI18N
        getContentPane().add(lblImage);
        lblImage.setBounds(0, -60, 670, 370);

        jMenuNew.setText("New");

        jMenuItemNewMatch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNewMatch.setText("Match");
        jMenuNew.add(jMenuItemNewMatch);

        jMenuItemNewSelection.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNewSelection.setText("Selection");
        jMenuNew.add(jMenuItemNewSelection);

        jMenuBar1.add(jMenuNew);

        jMenuView.setText("View");

        jMenuItemViewRangList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemViewRangList.setText("Rang List");
        jMenuView.add(jMenuItemViewRangList);

        jMenuViewSelection.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuViewSelection.setText("Selection");
        jMenuView.add(jMenuViewSelection);

        jMenuBar1.add(jMenuView);

        jMenuChange.setText("Change");

        jMenuItemChangeSelection.setText("Selection");
        jMenuChange.add(jMenuItemChangeSelection);

        jMenuBar1.add(jMenuChange);

        jMenuCalculateRangList.setText("RangList");

        jMenuItemCalculate.setText("Calculate");
        jMenuCalculateRangList.add(jMenuItemCalculate);

        jMenuBar1.add(jMenuCalculateRangList);

        jMenuUsers.setText("Users");

        jMenuItemAll.setText("All");
        jMenuUsers.add(jMenuItemAll);

        jMenuBar1.add(jMenuUsers);

        jMenuItemChangeLanguage.setText("Change Language");

        jCheckBoxSerbian.setSelected(true);
        jCheckBoxSerbian.setText("jCheckBoxMenuItem2");
        jMenuItemChangeLanguage.add(jCheckBoxSerbian);

        jCheckBoxMenuEnglish.setSelected(true);
        jCheckBoxMenuEnglish.setText("jCheckBoxMenuItem3");
        jMenuItemChangeLanguage.add(jCheckBoxMenuEnglish);

        jMenuBar1.add(jMenuItemChangeLanguage);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrmMain dialog = new FrmMain();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuEnglish;
    private javax.swing.JCheckBoxMenuItem jCheckBoxSerbian;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCalculateRangList;
    private javax.swing.JMenu jMenuChange;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemAll;
    private javax.swing.JMenuItem jMenuItemCalculate;
    private javax.swing.JMenu jMenuItemChangeLanguage;
    private javax.swing.JMenuItem jMenuItemChangeSelection;
    private javax.swing.JMenuItem jMenuItemNewMatch;
    private javax.swing.JMenuItem jMenuItemNewSelection;
    private javax.swing.JMenuItem jMenuItemViewRangList;
    private javax.swing.JMenu jMenuNew;
    private javax.swing.JMenu jMenuUsers;
    private javax.swing.JMenu jMenuView;
    private javax.swing.JMenuItem jMenuViewSelection;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        setIconImage();
        setSize();
        readMenuNames();
    }

    private void setSize() {
        this.setSize(540, 320);
        this.setResizable(false);
    }

    private void setIconImage() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/ball.png")));
    }

    private void selectLanguage() {
        if (Controller.getLocale().equals(new Locale("en", "US"))) {
            jCheckBoxSerbian.setSelected(false);
        } else {
            jCheckBoxMenuEnglish.setSelected(false);
        }
    }

    private void initResourceBundle() {
        locale = Controller.getLocale();
        resourceBundle = ResourceBundle.getBundle("resourceBundles.ResourceBundle_FrmMain_" + locale);
    }

    public void readMenuNames() {
        jMenuNew.setText(resourceBundle.getString("jMenuNew"));
        jMenuView.setText(resourceBundle.getString("jMenuView"));
        jMenuItemNewMatch.setText(resourceBundle.getString("jMenuItemNewMatch"));
        jMenuItemChangeLanguage.setText(resourceBundle.getString("jMenuItemChangeLanguage"));
        jCheckBoxSerbian.setText(resourceBundle.getString("Serbian"));
        jCheckBoxMenuEnglish.setText(resourceBundle.getString("English"));
        jMenuItemNewSelection.setText(resourceBundle.getString("jMenuItemSelection"));
        jMenuViewSelection.setText(resourceBundle.getString("jMenuItemSelection"));
        jMenuChange.setText(resourceBundle.getString("JMenuChange"));
        jMenuItemChangeSelection.setText(resourceBundle.getString("jMenuItemChangeSelection"));
        jMenuCalculateRangList.setText(resourceBundle.getString("jMenuItemRangList"));
        jMenuItemCalculate.setText(resourceBundle.getString("jMenuItemCalculate"));
        jMenuUsers.setText(resourceBundle.getString("users"));
        jMenuItemAll.setText(resourceBundle.getString("all"));
        validate();
    }

    private void initListenerViewSelection() {
        jMenuViewSelection.addActionListener((ActionEvent e) -> {
            try {
                Controller.getInstance().getAllSelections();
                new FrmChooseSelection(ChooseSelectionMode.VIEW).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, resourceBundle.getString("errorSelection"), resourceBundle.getString("errorTitle"), 0);
            }
        });
    }

    private void initListenerCheckBoxEnglish() {
        jCheckBoxMenuEnglish.addActionListener((ActionEvent e) -> {
            try {
                Controller.getInstance().writeLanguage("en", "US");
                initResourceBundle();
                readMenuNames();
                jCheckBoxSerbian.setSelected(false);
            } catch (Exception ex) {
                LOGGER.error(ex);
            }
        });
    }

    private void initListenerCheckBoxSerbian() {
        jCheckBoxSerbian.addActionListener((ActionEvent e) -> {
            try {
                Controller.getInstance().writeLanguage("sr", "RS");
                initResourceBundle();
                readMenuNames();
                jCheckBoxMenuEnglish.setSelected(false);
            } catch (ServerException ex) {
                LOGGER.error(ex);
            } catch (Exception ex) {
                LOGGER.error(ex);
            }
        });
    }

    private void initListeners() {
        initListenerViewSelection();
        initListenerCheckBoxEnglish();
        initListenerCheckBoxSerbian();
        initListenerRangList();
        initListenernewSelection();
        initListenerNewMatch();
        initListenerChangeSelection();
        initListenerCalculateRangList();
        initListenerAllUsers();
    }

    private void initListenerRangList() {
        jMenuItemViewRangList.addActionListener((ActionEvent e) -> {
            try {
                Controller.getInstance().getRangList();
                new FrmViewRangList().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, resourceBundle.getString("errorRangList"), resourceBundle.getString("errorTitle"), 0);
            }
        });
    }

    private void initListenernewSelection() {
        jMenuItemNewSelection.addActionListener((ActionEvent e) -> {
            new FrmNewSelection().setVisible(true);
        });
    }

    private void initListenerNewMatch() {
        jMenuItemNewMatch.addActionListener((ActionEvent e) -> {
            new FrmNewMatch().setVisible(true);
        });
    }

    private void initListenerChangeSelection() {
        jMenuItemChangeSelection.addActionListener((ActionEvent e) -> {
            try {
                Controller.getInstance().getAllSelections();
                new FrmChooseSelection(ChooseSelectionMode.EDIT).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, resourceBundle.getString("errorSelection"), resourceBundle.getString("errorTitle"), 0);
            }
        });
    }

    private void initListenerCalculateRangList() {
        jMenuItemCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Controller.getInstance().calculateRangList();
                    new FrmViewRangList().setVisible(true);
                } catch (Exception ex) {

                }
            }
        });
    }

    private void initAuthorization() {
        try {
            jMenuUsers.setEnabled(Controller.getInstance().readAdministrator());
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    private void initListenerAllUsers() {
        jMenuItemAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmAllUsers().setVisible(true);
            }
        });
    }

}
