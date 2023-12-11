package Model;
import java.util.ArrayList;

public class Playlist {
    private String nama;
    private int jumlahLagu;
    private ArrayList<Musik> musik;

    public Playlist(String nama, int jumlahLagu, Musik musik) {
        this.nama = nama;
        this.jumlahLagu = jumlahLagu;
        this.musik.add(musik);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahLagu() {
        return jumlahLagu;
    }

    public void setJumlahLagu(int jumlahLagu) {
        this.jumlahLagu = jumlahLagu;
    }

    public ArrayList<Musik> getMusik() {
        return musik;
    }

    public void setMusik(Musik musik) {
        this.musik.add(musik);
    }

}