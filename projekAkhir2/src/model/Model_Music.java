package model;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class Model_Music {
    private int no;
    private String name;
    private int time;
    
    MP3Player player = new MP3Player();
    File fileMusik;
    
    public Model_Music(){
    
    };

    public Model_Music(int no, String name, int time, String penyanyi, String genre, String lirik, String link, String directory) {
        this.no = no;
        this.name = name;
        this.time = time;
        this.penyanyi = penyanyi;
        this.genre = genre;
        this.lirik = lirik;
        this.link = link;
        this.directory = directory;
    }
    private String nama;
    private String penyanyi;
    private String album;
    private String genre;
    private String lirik;
    private String link;
    private String directory;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyanyi() {
        return penyanyi;
    }

    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLirik() {
        return lirik;
    }

    public void setLirik(String lirik) {
        this.lirik = lirik;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
   
    
    public Model_Music(int no, String name, int time, String Directory) {
        this.no = no;
        this.name = name;
        this.time = time;
        this.directory = Directory;
        fileMusik = new File(Directory);
        player.addToPlayList(fileMusik);
       //String fileName = songFile.getName();
       String fileName = fileMusik.getName();
        // Aku gatau jTextFieldnya yg mana wkwkw, ditambahinnya d jFramenya aja
       //songNameDisplay.setText(fileName);
       setNama(fileName);
    }


    public int getNo() {
        return no;
    }
    public MP3Player getPlayer(){
        return player;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

       
    
}
