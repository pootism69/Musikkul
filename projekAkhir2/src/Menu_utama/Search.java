
package Menu_utama;

/**
 *
 * @author Adrian Aditya P
 */
import Database.Database;
import component.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Model_Music;



public class Search extends javax.swing.JPanel {

   
    private DefaultListModel<String> listModel;
    private DefaultListModel<Model_Music> listMusic;
    Database db = new Database();
    boolean check;
    Model_Music ms;
    
    public Search() {
        listModel = new DefaultListModel<>();
        listMusic = new DefaultListModel<>();
        
        initComponents();
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tx_searchSong = new javax.swing.JTextField();
        lb_Search = new javax.swing.JLabel();
        lb_searchField = new javax.swing.JLabel();
        lb_whatSong = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MusicListSearch = new javax.swing.JList<>();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(19, 19, 44));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tx_searchSong.setBackground(new java.awt.Color(22, 27, 61));
        tx_searchSong.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        tx_searchSong.setForeground(new java.awt.Color(255, 255, 255));
        tx_searchSong.setText("Song Title - Song Artist");
        tx_searchSong.setBorder(null);
        tx_searchSong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tx_searchSongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tx_searchSongFocusLost(evt);
            }
        });
        jPanel1.add(tx_searchSong, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 410, 60));

        lb_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/material-symbols_search.png"))); // NOI18N
        lb_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_SearchMouseClicked(evt);
            }
        });
        jPanel1.add(lb_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, -1, -1));

        lb_searchField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SearchField.png"))); // NOI18N
        jPanel1.add(lb_searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 209, -1, -1));

        lb_whatSong.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lb_whatSong.setForeground(new java.awt.Color(255, 255, 255));
        lb_whatSong.setText("What song do you want to download?");
        jPanel1.add(lb_whatSong, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        MusicListSearch.setBackground(new java.awt.Color(19, 19, 44));
        MusicListSearch.setForeground(new java.awt.Color(255, 255, 255));
        MusicListSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MusicListSearchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MusicListSearch);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1090, 300));

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void lb_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_SearchMouseClicked
       listModel.clear();
        String title = tx_searchSong.getText();
       

        if(title.equals("Song Title - Song Artist")){
            
        }else if(title.equals("")){
            
        }else{
           try {
               check = false;
               String sql = " name = '" + title + "' OR artist = '" + title +"';";
               
               ResultSet rs = db.getDBWhere("song", sql);
               
               while(rs.next()){
                   listModel.addElement(rs.getString("name"));
                   ms = new Model_Music();
                   ms.setName(rs.getString("name"));
                   ms.setPenyanyi(rs.getString("artist"));
                   ms.setNo(rs.getInt("songID"));
                   ms.setLink(rs.getString("Link_Lagu"));
                   listMusic.addElement(ms);
               }
               MusicListSearch.setModel(listModel);
           } catch (SQLException ex) {
               Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
        
    }//GEN-LAST:event_lb_SearchMouseClicked

    private void tx_searchSongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tx_searchSongFocusGained
        String pass = tx_searchSong.getText();
        if(pass.equals("Song Title - Song Artist")){
            tx_searchSong.setText("");
        }
    }//GEN-LAST:event_tx_searchSongFocusGained

    private void tx_searchSongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tx_searchSongFocusLost
        String pass=tx_searchSong.getText();
        if(pass.equals("") || pass.equals("Song Title - Song Artist")){
            tx_searchSong.setText("Song Title - Song Artist");
        }
    }//GEN-LAST:event_tx_searchSongFocusLost

    private void MusicListSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MusicListSearchMouseClicked
        try {
            check = false;
            int selectedIndex = MusicListSearch.getSelectedIndex();
            
            //mekanisme memindahkan lagu ke download berdasarkan judul lagu yang sudah dipilih
            ResultSet rs = db.getDB("usersong");
            while(rs.next()){
                if(rs.getInt("userID") == Database.getIDAccUser()){
                    if(rs.getInt("SongID") == listMusic.getElementAt(selectedIndex).getNo()){
                        check = true;
                    }
                }
            }
            if (!check){
                String Dir = db.Download(listMusic.getElementAt(selectedIndex).getLink(), listMusic.getElementAt(selectedIndex).getName());
                db.insertMusicToUser(Database.getIDAccUser(), listMusic.getElementAt(selectedIndex).getNo(), Dir);
                listMusic.getElementAt(selectedIndex).setDirectory("./src/Music/" + listMusic.getElementAt(selectedIndex).getName() + ".mp3");
                JOptionPane.showMessageDialog(null, "song successfully downloaded");
            } else{
                JOptionPane.showMessageDialog(null, "song already added");;
            }
            
            
            //ketika berhasil
            
        } catch(Exception e){
            e.printStackTrace();
        }

        
    }//GEN-LAST:event_MusicListSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> MusicListSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Search;
    private javax.swing.JLabel lb_searchField;
    private javax.swing.JLabel lb_whatSong;
    private javax.swing.JTextField tx_searchSong;
    // End of variables declaration//GEN-END:variables
}
