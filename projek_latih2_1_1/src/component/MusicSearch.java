package component;

import model.Model_Music;

public class MusicSearch extends javax.swing.JPanel {

    public MusicSearch() {
        initComponents();
        init();
    }

    public void init() {
       
    }
    
    public void init(String no, String title, String time) {
        listMusic1.removeAllItems();
        listMusic1.addItem(new Model_Music(no, title, time));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMusic1 = new component.ListMusic<>();

        setBackground(new java.awt.Color(19, 19, 44));

        listMusic1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(listMusic1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(listMusic1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.ListMusic<String> listMusic1;
    // End of variables declaration//GEN-END:variables
}
