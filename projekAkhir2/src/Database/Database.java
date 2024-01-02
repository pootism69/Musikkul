
package Database;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import model.Model_Music;

import java.sql.*;
/**
 *
 * @author ASUS
 */
public class Database {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mp3player";
    private static Database instance;
    private  static int IDAccUser;
    private  static int IDAccKon;

    public static int getIDAccUser() {
        return IDAccUser;
    }

    public static  void setIDAccUser(int IDAccUser) {
         Database.IDAccUser = IDAccUser;
    }

    public static int getIDAccKon() {
        return Database.IDAccKon;
    }

    public static void setIDAccKon(int IDAccKon) {
        Database.IDAccKon = IDAccKon;
    }
    
    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }
    
    public int loginDB(String EX, String pass){
        int check = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL,"root", "" );
            //cek untuk akun admin
            String sql = "SELECT ID,nama,password FROM admin"
                    + " WHERE nama=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, EX);
            ResultSet resultset = st.executeQuery();
            
            if (resultset.next()){
                if (resultset.getString("password").equals(pass)){
                    check = 1; // Jika Username/Email dan password benar
                    setIDAccKon(resultset.getInt("ID"));
                } else {
                    check = 0; //kalau salah
                }
            } else{
                sql = "SELECT userID,nama,password FROM user"
                    + " WHERE nama=?;";
                st = con.prepareStatement(sql);
                st.setString(1, EX);
                
                resultset = st.executeQuery();
                if(resultset.next()){
                    if(resultset.getString("password").equals(pass)){
                        check = 2; //jika username dan password benar akun user
                        System.out.println(resultset.getInt("userID"));
                        Database.setIDAccUser(resultset.getInt("userID"));
                    } else {
                        check = 0; //jika salah
                    
                } 
            }  
        }
        } catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }
    
    public boolean checkDBString(String table, String column, String x){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            String sql = " SELECT " + column + " FROM " + table
                    + " WHERE " + column +"=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,x);
            ResultSet resultset = st.executeQuery();
            
            //check jika result ada row
            if(resultset.next()){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkDBInt(String table, String column, int x){
        try{
            String y = Integer.toHexString(x);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            String sql = " SELECT " + column + " FROM " + table
                    + " WHERE " + column +"=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,y);
            ResultSet resultset = st.executeQuery();
            
            //check jika result ada row
            if(resultset.next()){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updatePassDB(int ID, String pass){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            String sql = "UPDATE user "
                    + "SET password=? "
                    + "WHERE userID=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, pass);
            st.setInt(2, ID);
            st.executeUpdate();
            return true;
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean insertRegDB(String username, String pass, int ID) throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            if (!checkDBString("user", "nama", username)){
                String sql = "INSERT INTO user"
                        + " (nama, password,userID) " 
                        + "VALUES (?,?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, username);
                st.setString(2, pass);
                st.setInt(3, ID);
                st.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ResultSet getDB(String table){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            String sql = "SELECT * FROM " + table;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet resultset = st.executeQuery();
            
            return resultset;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean InsertMusic(Model_Music music, int ID) throws SQLException, ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            if (!checkDBInt("song", "songID", ID )){
                String sql = "INSERT INTO song" + " (SongID, name, duration, artist, genre, times_played, Link_Lagu, Lirik, Link_Gambar)"
                        + " VALUES(?,?,?,?,?,?,?,?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, ID);
                st.setString(2, music.getName());
                st.setInt(3, music.getTime());
                st.setString(4, music.getPenyanyi());
                st.setString(5, music.getGenre());
                st.setInt(6, 0);
                st.setString(7, music.getLink());
                st.setString(8, music.getLirik());
                st.setString(9, "-");
                st.executeUpdate();
                return true;
                
                
                
                
                
                
            } else {
            }
        } catch (Error e){
            e.printStackTrace();;
        }
        return false;
    }
    
    public ResultSet getUserMusic(int ID) throws ClassNotFoundException{
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL,"root", "" );
            //cek untuk akun admin
            String sql = "SELECT * FROM song AS s JOIN usersong AS us ON s.songID = us.songID WHERE userID =" + ID + ";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeQuery();
            ResultSet rs = st.executeQuery();
            return rs;
         } catch(Exception e ){
             e.printStackTrace();
         }
         
         return null;
    }
    
    public ResultSet getPlaylist(int ID){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL,"root", "" );
            String sql = "SELECT * FROM playlist WHERE userID =" + ID +";";
             PreparedStatement st = con.prepareStatement(sql);
            st.executeQuery();
            ResultSet rs = st.executeQuery();
            return rs;
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    

    public boolean createPlaylist(String nama, int userID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            if (!checkDBString("playlist", "name",nama)){
                String sql = "INSERT INTO playlist"
                        + " (name, userID) " 
                        + "VALUES (?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, nama);
                st.setInt(2, userID);
                st.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean insertMusicToPlaylist(int playlistID, int MusicID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            
                String sql = "INSERT INTO playlistsong"
                        + " (playlistID, songID) " 
                        + "VALUES (?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, playlistID);
                st.setInt(2, MusicID);
                st.executeUpdate();
                return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean deleteMusic(int ID){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(JDBC_URL, "root","");
             
             if(this.checkDBInt("song", "songID", ID)){
                 String sql = "DELETE FROM song WHERE songID =" + ID + ";";
                 PreparedStatement st = con.prepareStatement(sql);
                 st.executeUpdate();
                 return true;
             }
             
             
         } catch (Exception e){
             e.printStackTrace();
         }
         return false;
         
     }
    
     public boolean insertMusicToUser(int userID, int MusicID, String LocDir){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            
                String sql = "INSERT INTO usersong"
                        + " (userID, SongID, local_Dir) " 
                        + "VALUES (?,?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, userID);
                st.setInt(2, MusicID);
                st.setString(3, LocDir);
                st.executeUpdate();
                return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     
      public ResultSet getDBWhere(String table, String Where){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            String sql = "SELECT * FROM " + table + " WHERE " + Where;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet resultset = st.executeQuery();
            
            return resultset;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
      
      public String Download (String url, String nama) throws MalformedURLException, IOException{
        URLConnection conn = new URL(url).openConnection();
        InputStream is = conn.getInputStream();
        String LocDir = "./src/Music/" + nama + ".mp3";

        try (OutputStream outstream = new FileOutputStream(new File(LocDir))) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) > 0) {
                outstream.write(buffer, 0, len);
            }
            return LocDir;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
      
      public boolean editSong(Model_Music ms, int IDawal){
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root", "");
            
            String sql = "UPDATE song SET SongID = ?, name = ?, duration = ?, artist = ?, genre = ?, "
                    + "times_played = ?, Link_Lagu = ?, Link_Gambar = ?, Lirik = ?  WHERE SongID = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, ms.getNo());
            st.setString(2, ms.getName());
            st.setInt(3,ms.getTime() );
            st.setString(4, ms.getPenyanyi());
            st.setString(5, ms.getGenre());
            st.setInt(6, 0);
            st.setString(7,ms.getLink());
            st.setString(8, "-");
            st.setString(9, ms.getLirik());
            st.setInt(10, IDawal);
            st.executeUpdate();
            return true;
              
      }catch (Exception e){
          e.printStackTrace();
      }
       return false;   
      
     
      
}
}
