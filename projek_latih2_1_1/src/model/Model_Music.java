package model;

import java.io.File;

public class Model_Music {
    private String no;
    private String name;
    private int time;
    
    File fileMusik;

    public Model_Music(String no, String name, int time, String nama, String penyanyi, String album, String genre, String lirik, String link, String directory) {
        this.no = no;
        this.name = name;
        this.time = time;
        this.nama = nama;
        this.penyanyi = penyanyi;
        this.album = album;
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
    private int ID;

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
   
    
    public Model_Music(String no, String name, int time) {
        this.no = no;
        this.name = name;
        this.time = time;
    }

    public Model_Music() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
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

    public File getFileMusik() {
        return fileMusik;
    }

    public void setFileMusik(File fileMusik) {
        this.fileMusik = fileMusik;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    
}
