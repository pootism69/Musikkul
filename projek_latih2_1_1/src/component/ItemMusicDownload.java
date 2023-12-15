package component;

import model.Model_Music;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import projek_latih2.NewJFrame;


public class ItemMusicDownload extends javax.swing.JPanel {

    public boolean isPlay() {
        return play;
    }

    private final Model_Music data;
    private boolean play;

    public void setPlay(boolean play) {
        this.play = play;
        if (play) {
           
            lbText.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14));
            lbText.setForeground(new Color(203, 30, 148));
            
        } else {
            
            lbIcon.setText(data.getNo());
            lbText.setFont(new java.awt.Font("segoe UI Semibold", 0, 14));
            lbText.setForeground(new Color(255, 255, 255));
            
        }
       
    }

    public ItemMusicDownload(Model_Music data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        lbText.setText(data.getName());
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbIcon.setBackground(new java.awt.Color(19, 19, 44));
        lbIcon.setForeground(new java.awt.Color(255, 255, 255));
        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbText.setBackground(new java.awt.Color(19, 19, 44));
        lbText.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbText.setText("Music Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbText)
                .addContainerGap(465, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(lbText)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       
    }//GEN-LAST:event_formMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(246, 246, 246));
        g2.fillRect(0, getHeight() - 2, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbText;
    // End of variables declaration//GEN-END:variables
}
