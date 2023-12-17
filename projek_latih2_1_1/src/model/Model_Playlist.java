package model;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;

public class Model_Playlist {   
    private Icon image;
    private String title;
    private String nama;
    private int jumlahLagu;
    private ArrayList<Model_Music> musik;
    static int index;
    static String repeat;
    static String shuffle;

    public Model_Playlist(String nama, int jumlahLagu, ArrayList<Model_Music> musik) {
        this.nama = nama;
        this.jumlahLagu = jumlahLagu;
        this.musik = musik;
    }
     
    
    public Model_Playlist(Icon image, String title) {
        this.image = image;
        this.title = title;       
        
    }

    public Model_Playlist() {
    }

    

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
     public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void PlayPlaylist(){
        
    }
    
    public void NextPlaylist(){
        //sekarang indexnya apa, terus di tambah indexnya
        
    }

    public int getJumlahLagu() {
        return jumlahLagu;
    }

    public void setJumlahLagu(int jumlahLagu) {
        this.jumlahLagu = jumlahLagu;
    }

    public ArrayList<Model_Music> getMusik() {
        return musik;
    }

    public void setMusik(Model_Music musik) {
        this.musik.add(musik);
    }
    
    public void prevMusik(){
        //int sekarang dikurangin
    }
    
    public void playMusik(){
        //set index ke 0, play music, liat status dulu, kalo repeat == off maka kalo index sekarang >  length playlit langsung stop
        //kalo repeat == on kalo index sekarang > length playlist maka index ke 0 lagi.
    }
    
    public void ToggleRepeat(){
        //if repeat == on, repeat = off. else if repeat == off, repeat = on.    
        if (repeat == "on"){
            repeat = "off";
        }else{
            repeat  = "on";
        }
    }
    
    public void shuffle(){
        Random rand = new Random();
        
        int rand_int = rand.nextInt(musik.size());
    }

    
}
