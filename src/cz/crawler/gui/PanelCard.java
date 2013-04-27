/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelCard.java
 *
 * Created on 12.1.2013, 22:44:34
 */
package cz.crawler.gui;

import cz.crawler.dtb.entity.MtgCard;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Marty
 */
public class PanelCard extends javax.swing.JPanel {
private  MtgCard card = null;

    /** Creates new form PanelCard */
    public PanelCard() {
        initComponents();
    }
     public void setCard(MtgCard card) {
         this.card =card;
         updateGui();
     }

    public MtgCard getCard() {
        return card;
    }

    public void updateGui() {
        jLabelCardName.setText(card.getCardName());
        jLabelManCost.setText(card.getManaCost());
        jLabelConvertedManaCost.setText(card.getConvertedManaCost() + "");
        jLabelTypes.setText(card.getTypes());
        jTextAreaCardText.setText(card.getCardText());
        jLabelExpansion.setText(card.getExpansion());
        jLabelRarity.setText(card.getRarity());
        jLabelArtist.setText(card.getArtist());
        try {
            jPanelImage.removeAll();
            BufferedImage myPicture = ImageIO.read(new URL(card.getImageUrl()));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            jPanelImage.add(picLabel);
            repaint();
            invalidate();
        } catch (Exception e) {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelImage = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelCardName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelManCost = new javax.swing.JLabel();
        jLabelConvertedManaCost = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCardText = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabelExpansion = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabelRarity = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabelArtist = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabelTypes = new javax.swing.JLabel();

        jPanelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelImage.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Card name:"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabelCardName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCardName.setText("jLabel1");
        jPanel3.add(jLabelCardName, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Mana cost:"));
        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jLabelManCost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelManCost.setText("jLabel1");
        jPanel4.add(jLabelManCost);

        jLabelConvertedManaCost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelConvertedManaCost.setText("jLabel1");
        jPanel4.add(jLabelConvertedManaCost);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Card text:"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTextAreaCardText.setColumns(20);
        jTextAreaCardText.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        jTextAreaCardText.setRows(5);
        jTextAreaCardText.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaCardText);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Expansion:"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabelExpansion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelExpansion.setText("jLabel1");
        jPanel6.add(jLabelExpansion, java.awt.BorderLayout.CENTER);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Rarity:"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabelRarity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelRarity.setText("jLabel1");
        jPanel7.add(jLabelRarity, java.awt.BorderLayout.CENTER);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Artist:"));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabelArtist.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelArtist.setText("jLabel1");
        jPanel8.add(jLabelArtist, java.awt.BorderLayout.CENTER);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Types:"));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabelTypes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTypes.setText("jLabel1");
        jPanel9.add(jLabelTypes, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelArtist;
    private javax.swing.JLabel jLabelCardName;
    private javax.swing.JLabel jLabelConvertedManaCost;
    private javax.swing.JLabel jLabelExpansion;
    private javax.swing.JLabel jLabelManCost;
    private javax.swing.JLabel jLabelRarity;
    private javax.swing.JLabel jLabelTypes;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelImage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCardText;
    // End of variables declaration//GEN-END:variables
}
