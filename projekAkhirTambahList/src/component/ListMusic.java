package component;

import Method.JOption;
import model.Model_Music;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class ListMusic<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;

    public ListMusic() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int clickedIndex = locationToIndex(me.getPoint());
                    playIndex = clickedIndex;
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
                ItemMusic item = new ItemMusic(data);
                item.setPlay(index == playIndex);
                item.setDownload(index == playIndex);
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
}
