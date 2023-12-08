package Model;

public class Musik{
    private String nama;
    private String penyanyi;
    private String album;
    private String genre;
    private Lirik lirik;
    private String link;
    private String directory;

    public Musik(String nama, String penyanyi, String album, String genre, Lirik lirik, String link, String directory) {
        this.nama = nama;
        this.penyanyi = penyanyi;
        this.album = album;
        this.genre = genre;
        this.lirik = lirik;
        this.link = link;
        this.directory = directory;
    }

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

    public Lirik getLirik() {
        return lirik;
    }

    public void setLirik(Lirik lirik) {
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

    
    
    
}
