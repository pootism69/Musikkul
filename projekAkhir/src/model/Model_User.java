/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jaco.mp3.player.MP3Player;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Imran
 */
public class Model_User {
    MP3Player player = new MP3Player();
    File fileMusik;
    String currentDirectory = "home.user";        
    boolean repeat = false;
    int xMouse, yMouse;
    
    private static int id;
    private String username;
    private String password;
    String FileName;
    
    public String getFileName(){
        return FileName;
    }
    public Model_User(Model_Music music){
       //fileMusik = new File("E:\\lagu1.mp3");
       fileMusik = new File(music.getDirectory());
       player.addToPlayList(fileMusik);
       //String fileName = songFile.getName();
       String fileName = fileMusik.getName();
        // Aku gatau jTextFieldnya yg mana wkwkw, ditambahinnya d jFramenya aja
       //songNameDisplay.setText(fileName);
       this.FileName = fileName;
    }
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Model_User.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void play(){
        player.play();
    }
    
    public void stop(){
        player.stop();        
    }
    
    public void pause(){
        player.pause();
    }
    
    public void repeatSatuMusik(){
        if(repeat == false){
            repeat = true;
            player.setRepeat(repeat);
            
            //gatau image yg mana buat repeat banh, ditambahinnya d jFramenya aja
            //String image = currentPath+imagePath+"\\repeat_enabled.png";
            //repeatBtn.setIcon(new ImageIcon(image));
        }else if(repeat == true){
            repeat = false;
            player.setRepeat(repeat);
            
            //gatau image yg mana buat repeat banh, ditambahinnya d jFramenya aja
            //String image = currentPath+imagePath+"\\repeat.png";
            //repeatBtn.setIcon(new ImageIcon(image));            
        }
    }
    
    public void addSatuMusik(){
        JFileChooser openFileChooser = new JFileChooser(currentDirectory);
        openFileChooser.setFileFilter(new Model_Filter_Musik(".mp3", "Open MP3 Files Only!"));
        int result = openFileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            fileMusik = openFileChooser.getSelectedFile();
            player.addToPlayList(fileMusik);
            player.skipForward();
            currentDirectory = fileMusik.getAbsolutePath();
            //Gatau image jTextFieldnya buat nampilin Playing now
            //songNameDisplay.setText("Playing Now... | " + songFile.getName());
        }
    }
     
        
    
    
}
