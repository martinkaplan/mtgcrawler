package cz.crawler.gui;

import cz.crawler.Crawler;
import cz.crawler.ProjectProperties;
import cz.crawler.dtb.DBConnector;
import cz.crawler.dtb.entity.MtgCard;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Marty
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener, WindowListener {

    PanelCard pm = new PanelCard();
    Crawler crawler = Crawler.getInstance();
    Dimension dim = new Dimension(500, 500);
    DBConnector dbconn = DBConnector.getInstance();
    Timer timer;
    ProjectProperties prop = ProjectProperties.getInstance();

    private void applicationExit() {
        prop.store();
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaaaa");
    }

    class RemindTask extends TimerTask {

        public void run() {
//
//            int pom = Integer.parseInt(jTextFieldMultiverseId.getText());
//            pom++;
//
//            prop.setIntProperty(ProjectProperties.I_LASTCARDID, pom);
//            jTextFieldMultiverseId.setText("" + pom);
//
//            if (MAX_UNIVERSE_ID < pom) {
//                System.out.println("Maximalni universe ID !! " + pom);
//                applicationExit();
//            }
//            jButtonSetCardActionPerformed(null);
//
//            jButtonSaveToDtbActionPerformed(null);
            jLabelDtbState.setText("" + dbconn.isAlive());
        }
    }
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        jPanelCard.add(pm, BorderLayout.CENTER);
        setSize(dim);
        setPreferredSize(dim);
        jTextFieldMultiverseId.setText(prop.getIntProperty(ProjectProperties.I_LASTCARDID) + "");

        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 3000, 3000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanelUpper = new javax.swing.JPanel();
        jTextFieldMultiverseId = new javax.swing.JTextField();
        jButtonSetCard = new javax.swing.JButton();
        jButtonSaveToDtb = new javax.swing.JButton();
        jPanelLowwer = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelDtbState = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelCard.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelCard, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        jTextFieldMultiverseId.setText("1");

        jButtonSetCard.setText("Nastav");
        jButtonSetCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetCardActionPerformed(evt);
            }
        });

        jButtonSaveToDtb.setText("Ulož do databaze");
        jButtonSaveToDtb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveToDtbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUpperLayout = new javax.swing.GroupLayout(jPanelUpper);
        jPanelUpper.setLayout(jPanelUpperLayout);
        jPanelUpperLayout.setHorizontalGroup(
            jPanelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
            .addGroup(jPanelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelUpperLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextFieldMultiverseId, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonSetCard)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonSaveToDtb)
                    .addContainerGap(176, Short.MAX_VALUE)))
        );
        jPanelUpperLayout.setVerticalGroup(
            jPanelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUpperLayout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addGroup(jPanelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldMultiverseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSetCard)
                        .addComponent(jButtonSaveToDtb))
                    .addContainerGap()))
        );

        jPanel2.add(jPanelUpper);

        jButtonExit.setText("Konec");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jLabel1.setText("Dtb:");

        jLabelDtbState.setText("jLabel2");

        javax.swing.GroupLayout jPanelLowwerLayout = new javax.swing.GroupLayout(jPanelLowwer);
        jPanelLowwer.setLayout(jPanelLowwerLayout);
        jPanelLowwerLayout.setHorizontalGroup(
            jPanelLowwerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLowwerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabelDtbState)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addComponent(jButtonExit)
                .addContainerGap())
        );
        jPanelLowwerLayout.setVerticalGroup(
            jPanelLowwerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLowwerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelLowwerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExit)
                    .addComponent(jLabelDtbState))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanelLowwer);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
    applicationExit();
}//GEN-LAST:event_jButtonExitActionPerformed

private void jButtonSetCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetCardActionPerformed
    try {
        pm.setCard(MtgCard.getCard(Integer.parseInt(jTextFieldMultiverseId.getText().trim())));
    } catch (Exception e) {
    }
}//GEN-LAST:event_jButtonSetCardActionPerformed

    private void jButtonSaveToDtbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveToDtbActionPerformed
        try {
            dbconn.insertCard(pm.getCard());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSaveToDtbActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonSaveToDtb;
    private javax.swing.JButton jButtonSetCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDtbState;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCard;
    private javax.swing.JPanel jPanelLowwer;
    private javax.swing.JPanel jPanelUpper;
    private javax.swing.JTextField jTextFieldMultiverseId;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        applicationExit();
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
}
