/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_utama;

import jaco.mp3.player.MP3Player;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import model.Model_Music;
import model.Model_Playlist;
import model.Model_User;
import Database.Database;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.nio.file.*;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class Download1 extends javax.swing.JPanel {

    /**
     * Creates new form Download
     */
    JPanel pn;
    
    MP3Player player = new MP3Player();
    private DefaultListModel<String> listModel;
    Model_User user = new Model_User(player);
    int j = 0;
    int i;
    Database db = new Database();
    private DefaultListModel<Model_Music> listMusic;
    Model_Music ms;
    public Download1(JPanel pn) throws ClassNotFoundException, SQLException, IOException {
        
        listModel = new DefaultListModel<>();
        listMusic = new DefaultListModel<>();
        ResultSet rs = db.getUserMusic(Database.getIDAccUser());
        while(rs.next()){
            Path path = Paths.get(rs.getString("local_Dir"));
            if (Files.notExists(path)) {
                String Dir = db.Download(rs.getString("Link_Lagu"), rs.getString("name"));
                JOptionPane.showMessageDialog(null, "song successfully downloaded");
              }
            user.addMusik(new Model_Music(rs.getInt("SongID"), rs.getString("name"), rs.getInt("duration"), rs.getString("local_Dir")));
            listModel.addElement(rs.getString("name"));//judul lagunya
        }
        this.pn = pn;
        initComponents();
       
        //Menampilkan daftar Playlist
       String sql = "userID = " + Database.getIDAccUser() + " ;";
       
       rs = db.getDBWhere("playlist", sql);
       while(rs.next()){
           mostPopular1.addImage(new Model_Playlist(new ImageIcon(getClass().getResource("/gambar/Playlist.png")), rs.getString("name"),rs.getInt("PlaylistID")), pn);
       }
        
      
        
        
        
   
        
        //memasukkan listmodel ke playlistlagu (JList)
        playlistLagu.setModel(listModel);
        
        

        
        
        
        
    }
    
   

    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bt_addPlaylist = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_playlist = new javax.swing.JLabel();
        mostPopular1 = new component.MostPopular();
        jPanel2 = new javax.swing.JPanel();
        bt_play = new javax.swing.JLabel();
        bt_pause = new javax.swing.JLabel();
        bt_stop = new javax.swing.JLabel();
        bt_backward = new javax.swing.JLabel();
        bt_forward = new javax.swing.JLabel();
        playlistLagu = new javax.swing.JList<>();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(19, 19, 44));

        bt_addPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/plus_1.png"))); // NOI18N
        bt_addPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_addPlaylistMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Download");

        lb_playlist.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lb_playlist.setForeground(new java.awt.Color(255, 255, 255));
        lb_playlist.setText("Playlist");

        jPanel2.setBackground(new java.awt.Color(4, 1, 32));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/play.png"))); // NOI18N
        bt_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_playMouseClicked(evt);
            }
        });
        jPanel2.add(bt_play, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        bt_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pause.png"))); // NOI18N
        bt_pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_pauseMouseClicked(evt);
            }
        });
        jPanel2.add(bt_pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        bt_stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/stop.png"))); // NOI18N
        bt_stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_stopMouseClicked(evt);
            }
        });
        jPanel2.add(bt_stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        bt_backward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/forward.png"))); // NOI18N
        bt_backward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_backwardMouseClicked(evt);
            }
        });
        jPanel2.add(bt_backward, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        bt_forward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/backward.png"))); // NOI18N
        bt_forward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_forwardMouseClicked(evt);
            }
        });
        jPanel2.add(bt_forward, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        playlistLagu.setBackground(new java.awt.Color(19, 19, 44));
        playlistLagu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        playlistLagu.setForeground(new java.awt.Color(255, 255, 255));
        playlistLagu.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lb_playlist))
                                .addGap(865, 865, 865)
                                .addComponent(bt_addPlaylist)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(mostPopular1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playlistLagu, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_playlist))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(bt_addPlaylist)))
                .addGap(10, 10, 10)
                .addComponent(mostPopular1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playlistLagu, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_addPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addPlaylistMouseClicked
       pn.removeAll();
       pn.add(new AddPlaylist(pn));
       pn.repaint();
       pn.revalidate();
    }//GEN-LAST:event_bt_addPlaylistMouseClicked

    private void bt_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseClicked
        int selectedIndex = playlistLagu.getSelectedIndex();
                
                if (selectedIndex != -1) {
                    if(selectedIndex > j){
                        playSelectedSongForward(selectedIndex);
                    }else if(selectedIndex < j){
                        playSelectedSongBackward( selectedIndex);
                    }else{
                        user.play();
                    }
                }
    }//GEN-LAST:event_bt_playMouseClicked

    private void bt_pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_pauseMouseClicked
        user.pause();
    }//GEN-LAST:event_bt_pauseMouseClicked

    private void bt_stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_stopMouseClicked
        user.stop();
    }//GEN-LAST:event_bt_stopMouseClicked

    private void bt_backwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_backwardMouseClicked
        if (j > 0){
            j--;
            playlistLagu.setSelectedIndex(j);
            user.skipBackward();
        }else{
            j = 0;
            playlistLagu.setSelectedIndex(j);
        }
        
        
        
    }//GEN-LAST:event_bt_backwardMouseClicked

    private void bt_forwardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_forwardMouseClicked
        int playlistSize = user.getMP3Player().getPlayList().size();
        
        if(j < playlistSize - 1){
            user.skipForward();
            j++;
            playlistLagu.setSelectedIndex(j);
        }else{
            j = playlistSize-1;
            playlistLagu.setSelectedIndex(j);
        }
            
    }//GEN-LAST:event_bt_forwardMouseClicked

        private void playSelectedSongForward(int selectedIndex) {
         // Dapatkan indeks lagu yang akan diputar
        int index = selectedIndex;

        // Atur pemutaran lagu sesuai indeks
        if (index != -1) {
            // Hentikan pemutaran yang sedang berlangsung
            user.stop();
            
            for (int i = j; i < index; i++) {
                 // Skip ke lagu yang dipilih
                user.skipForward();
                    
            }
                
            
            // Mulai pemutaran
            user.play();
            j = index;
            
        }
    }
    
    private void playSelectedSongBackward(int selectedIndex) {
        // Dapatkan indeks lagu yang akan diputar
        int index = selectedIndex;

        // Atur pemutaran lagu sesuai indeks
        if (index != -1) {
            // Hentikan pemutaran yang sedang berlangsung
            user.stop();
            int i = j;
            // Skip ke lagu yang dipilih
            while(i > index){
                user.skipBackward();
                i--;
                
            }
            

            // Mulai pemutaran
            user.play();
            j = index;
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bt_addPlaylist;
    private javax.swing.JLabel bt_backward;
    private javax.swing.JLabel bt_forward;
    private javax.swing.JLabel bt_pause;
    private javax.swing.JLabel bt_play;
    private javax.swing.JLabel bt_stop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_playlist;
    private component.MostPopular mostPopular1;
    private javax.swing.JList<String> playlistLagu;
    // End of variables declaration//GEN-END:variables

    
}
