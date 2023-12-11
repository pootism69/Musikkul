/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


/**
 *
 * @author ASUS
 */
import jobme.pk.PlayerFrame;
import Model.Musik;
import Model.Playlist;
import jaco.mp3.player.MP3Player;
import java.io.File;
import javax.swing.JFileChooser;
import jobme.pk.FileTypeFilter;
public class ControllerMusik {
    PlayerFrame Frame;
    Playlist PlayList;
     MP3Player player;
    // Define File For Song
    File songFile;
    // Define Current Directory Like If We Use JFileChooser then where it statys.
    String currentDirectory = "home.user"; // I am using home.user this will call file chooser in user documents.
    // Here I define currentPath of the running app class

    public ControllerMusik(PlayerFrame Frame, Playlist PlayList) {
        this.Frame = Frame;
        this.PlayList = PlayList;
    }
    
    public void load(){
        JFileChooser openFileChooser = new JFileChooser(currentDirectory);
        openFileChooser.setFileFilter(new FileTypeFilter(".mp3", "Open MP3 Files Only!"));
        int result = openFileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            songFile = openFileChooser.getSelectedFile();
            player.addToPlayList(songFile);
            player.skipForward();
            currentDirectory = songFile.getAbsolutePath();
            Frame.getSongNameDisplay().setText("Playing Now... | " + songFile.getName());
        }
    }
    
    public void play(){
        
    }
    
    
    
    
    
}
