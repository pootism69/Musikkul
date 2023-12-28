package component;

import model.Model_Music;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMusicDownload<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;
    Model_Music data1;
    
    public ListMusicDownload() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    playIndex = locationToIndex(me.getPoint());
                    repaint();
                }
            }
        });
    }

    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Model_Music data;
                if (o instanceof Model_Music) {
                    data = (Model_Music) o;
                } else {
                    data = new Model_Music("1", "No Music", "00:00", "");
                }
                ItemMusicDownload item = new ItemMusicDownload(data);
                item.setPlay(index == playIndex);
                setData(data);
                return item;
            }
            
        };
         
    }
    
    public void addItem(Model_Music data) {
        model.addElement(data);
    }
    
    void removeAllItems() {
        model.clear();
        repaint();
    }
    public void setData(Model_Music data){
        this.data1 = data;
    }
    public Model_Music getData(){
        return data1;
    }
}
