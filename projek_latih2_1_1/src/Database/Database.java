
package Database;
import model.Model_Music;

import java.sql.*;
/**
 *
 * @author ASUS
 */
public class Database {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mp3player";
    private static Database instance;
    private int IDAccUser;
    private int IDAccKon;

    public int getIDAccUser() {
        return IDAccUser;
    }

    public void setIDAccUser(int IDAccUser) {
        this.IDAccUser = IDAccUser;
    }

    public int getIDAccKon() {
        return IDAccKon;
    }

    public void setIDAccKon(int IDAccKon) {
        this.IDAccKon = IDAccKon;
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
                        setIDAccKon(resultset.getInt("userID"));
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
    
    public boolean InsertMusic(Model_Music music) throws SQLException, ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            if (!checkDBInt("song", "songID", music.getID() )){
                String sql = "INSERT INTO song" + " (SongID, name, duration, artist, genre, times_played, Link_Lagu, Link_Gambar, Lirik)"
                        + " VALUES(?,?,?,?,?,?,?,?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, music.getID());
                st.setString(2, music.getNama());
                st.setInt(3, music.getTime());
                st.setString(4, music.getPenyanyi());
                st.setString(5, music.getGenre());
                st.setInt(6, 0);
                st.setString(7, music.getLink());
                st.setString(9, music.getLirik());
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
    
    public ResultSet getPlaylistSong(int ID){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL,"root", "" );
            //cek untuk akun admin
            String sql = "SELECT * FROM song AS s JOIN playlistsong AS ps ON s.songID = ps.songID WHERE PlaylistID =" + ID + ";";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeQuery();
            ResultSet rs = st.executeQuery();
            return rs;
         } catch(Exception e ){
             e.printStackTrace();
         }
         
         return null;
    }
    
    public boolean createPlaylist(String nama, int playlistID, int userID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(JDBC_URL, "root","");
            
            if (!checkDBString("playlist", "name",nama)){
                String sql = "INSERT INTO playlist"
                        + " (nama, playlistID, userID) " 
                        + "VALUES (?,?,?);";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, nama);
                st.setInt(2, playlistID);
                st.setInt(3, userID);
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
    
    
    
    
}