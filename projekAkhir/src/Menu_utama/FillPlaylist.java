/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_utama;

import javax.swing.JPanel;
import model.Model_Playlist;

/**
 *
 * @author asus
 */
public class FillPlaylist extends javax.swing.JPanel {

    /**
     * Creates new form FillPlaylist
     */
    JPanel panel;
    Model_Playlist data;
    public FillPlaylist( Model_Playlist data, JPanel pn) {
        initComponents();
        this.panel = pn;
        this.data = data;
        L_playlistName.setText(data.getTitle().trim());
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFill = new javax.swing.JPanel();
        L_playlistName = new javax.swing.JLabel();
        musicDownload1 = new component.MusicDownload();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        pnFill.setBackground(new java.awt.Color(19, 19, 44));

        L_playlistName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 48)); // NOI18N
        L_playlistName.setForeground(new java.awt.Color(255, 255, 255));
        L_playlistName.setText("YOUR PLAYLIST");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/plus_1.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnFillLayout = new javax.swing.GroupLayout(pnFill);
        pnFill.setLayout(pnFillLayout);
        pnFillLayout.setHorizontalGroup(
            pnFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFillLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFillLayout.createSequentialGroup()
                        .addComponent(musicDownload1, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(63, Short.MAX_VALUE))
                    .addGroup(pnFillLayout.createSequentialGroup()
                        .addComponent(L_playlistName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(91, 91, 91))))
        );
        pnFillLayout.setVerticalGroup(
            pnFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFillLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_playlistName)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(musicDownload1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
        );

        add(pnFill, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_playlistName;
    private javax.swing.JLabel jLabel1;
    private component.MusicDownload musicDownload1;
    private javax.swing.JPanel pnFill;
    // End of variables declaration//GEN-END:variables
}
