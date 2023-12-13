package component;

import model.Model_Music;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

public class ItemMusic extends javax.swing.JPanel {

    public boolean isPlay() {
        return play;
    }

    private final Model_Music data;
    private boolean play;

    public void setPlay(boolean play) {
        this.play = play;
        if (play) {
            
        
            lbText.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14));
            lbText.setForeground(new Color(255, 0 , 214));
            
        } else {
            
            lbIcon.setText(data.getNo());
            lbText.setFont(new java.awt.Font("segoe UI Semibold", 0, 14));
            lbText.setForeground(new Color(255, 255, 255));
            
        }
       
    }

    public ItemMusic(Model_Music data) {
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
        lbdownload = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbIcon.setBackground(new java.awt.Color(19, 19, 44));
        lbIcon.setForeground(new java.awt.Color(255, 255, 255));
        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbText.setBackground(new java.awt.Color(19, 19, 44));
        lbText.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lbText.setText("Music Name");

        lbdownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/downloadicon_1.png"))); // NOI18N
        lbdownload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbdownloadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
                .addComponent(lbdownload)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbdownload)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbText)))
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbdownloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdownloadMouseClicked
        
    }//GEN-LAST:event_lbdownloadMouseClicked

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
    private javax.swing.JLabel lbdownload;
    // End of variables declaration//GEN-END:variables
}