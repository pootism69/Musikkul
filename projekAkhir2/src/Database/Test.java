/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Database db = new Database();
        String sql = "SongID = 5 && PlaylistID = 6";
        ResultSet rs = db.getDBWhere("playlistsong", sql);   
        
        if(db.checkDBInt("song", "SongID", 11)){
            System.out.println("exist");
        } else {
            System.out.println("nope");
        }
    }
    
}
