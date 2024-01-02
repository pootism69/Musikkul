/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_utama;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Model_Artist;
import Database.Database;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Model_Music;


/**
 *
 * @author asus
 */
public class FillArtist extends javax.swing.JPanel {

    /**
     * Creates new form FillPlaylist
     * @param data
     */
    
    private DefaultListModel<Model_Music> listMusic;
    boolean check;
    Model_Music ms;
    private DefaultListModel<String> listModel;
    Database db = new Database();
    public FillArtist(Model_Artist data) throws SQLException {
        listModel = new DefaultListModel<>();
        String sql = "artist = '" + data.getTitle() + "' ;";
        
        ResultSet rs = db.getDBWhere("song", sql);
        listMusic = new DefaultListModel<>();
        check = false;
        
        while(rs.next()){
            listModel.addElement(rs.getString("name"));
            ms = new Model_Music();
            ms.setName(rs.getString("name"));
            ms.setPenyanyi(rs.getString("artist"));
            ms.setNo(rs.getInt("songID"));
            ms.setLink(rs.getString("Link_Lagu"));
            listMusic.addElement(ms);
        }
        
        initComponents();
        L_playlistName.setText(data.getTitle().trim());
        L_Description.setText(data.getDescription().trim());
        //perulangan buat ngambil lagu dari tabel 
        
        //Karena ini tidak berkaitan dengan MP3 (pemutaran lagu) jadi cuma nampilin judulnya aja
        
        
        MusicListofArtist.setModel(listModel);
        
        
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
        L_Description = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MusicListofArtist = new javax.swing.JList<>();

        setLayout(new java.awt.CardLayout());

        pnFill.setBackground(new java.awt.Color(19, 19, 44));
        pnFill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L_playlistName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 48)); // NOI18N
        L_playlistName.setForeground(new java.awt.Color(255, 255, 255));
        L_playlistName.setText("ARTIST NAME");
        pnFill.add(L_playlistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        L_Description.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        L_Description.setForeground(new java.awt.Color(255, 255, 255));
        L_Description.setText("Description");
        pnFill.add(L_Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Artisti(playlist).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        pnFill.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-370, 0, 710, 260));

        MusicListofArtist.setBackground(new java.awt.Color(19, 19, 44));
        MusicListofArtist.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        MusicListofArtist.setForeground(new java.awt.Color(255, 255, 255));
        MusicListofArtist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        MusicListofArtist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MusicListofArtistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MusicListofArtist);

        pnFill.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1220, 960));

        add(pnFill, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void MusicListofArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MusicListofArtistMouseClicked
        try {
            check = false;
            int selectedIndex = MusicListofArtist.getSelectedIndex();
            
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
                JOptionPane.showMessageDialog(null, "song successfully downloaded");;
            } else{
                JOptionPane.showMessageDialog(null, "song already added");;
            }
            
            
            //ketika berhasil
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_MusicListofArtistMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_Description;
    private javax.swing.JLabel L_playlistName;
    private javax.swing.JList<String> MusicListofArtist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnFill;
    // End of variables declaration//GEN-END:variables
}