package component;

import model.Model_Music;

public class Music extends javax.swing.JPanel {

    public Music() {
        initComponents();
        init();
        
    }

    private void init() {
        //Masih manual
        //rencananya buat variabel yang bakal nyimpen judul lagu, artist, dll (menyesuaikan sama model).Nanti variabel itu bakal jadi parameter
        listMusic1.addItem(new Model_Music("1", "Peace Of Mind (feat. Vargas & Lagola)", "03:00", "E:\\lagu1.mp3"));
//        listMusic1.addItem(new Model_Music("2", "Heaven", "04:37"));
//        listMusic1.addItem(new Model_Music("3", "SOS (feat. Aloe Blacc)", "02:37"));
//        listMusic1.addItem(new Model_Music("4", "Bad Reputation (feat. Joe Janiak)", "03:25"));
//        listMusic1.addItem(new Model_Music("5", "Ain't A Thing", "03:03"));
//        listMusic1.addItem(new Model_Music("6", "Hold The line (feat. A R I Z O N A)", "02:51"));
//        listMusic1.addItem(new Model_Music("7", "Freak (feat. Bonn)", "02:59"));
//        listMusic1.addItem(new Model_Music("1", "Peace Of Mind (feat. Vargas & Lagola)", "03:00"));
//        listMusic1.addItem(new Model_Music("2", "Heaven", "04:37"));
//        listMusic1.addItem(new Model_Music("3", "SOS (feat. Aloe Blacc)", "02:37"));
//        listMusic1.addItem(new Model_Music("4", "Bad Reputation (feat. Joe Janiak)", "03:25"));
//        listMusic1.addItem(new Model_Music("5", "Ain't A Thing", "03:03"));
//        listMusic1.addItem(new Model_Music("6", "Hold The line (feat. A R I Z O N A)", "02:51"));
//        listMusic1.addItem(new Model_Music("7", "Freak (feat. Bonn)", "02:59"));
       
       
    }
    
    public void init(String no, String title, String time, String Directory) {
        listMusic1.addItem(new Model_Music(no, title, time, Directory));
    }
    
    public ListMusic getList(){
        return listMusic1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMusic1 = new component.ListMusic<>();

        setBackground(new java.awt.Color(19, 19, 44));

        listMusic1.setForeground(new java.awt.Color(255, 255, 255));
        listMusic1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMusic1MouseClicked(evt);
            }
        });

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

    private void listMusic1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMusic1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listMusic1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.ListMusic<String> listMusic1;
    // End of variables declaration//GEN-END:variables
}
