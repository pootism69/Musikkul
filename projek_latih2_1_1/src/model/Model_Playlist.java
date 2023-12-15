package model;

import javax.swing.Icon;

public class Model_Playlist {

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

    public Model_Playlist(Icon image, String title) {
        this.image = image;
        this.title = title;
        
        
    }

    public Model_Playlist() {
    }

    private Icon image;
    private String title;
    
}
