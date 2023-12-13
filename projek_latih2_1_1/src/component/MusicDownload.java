package component;

import javax.swing.JPanel;
import model.Model_Music;

public class MusicDownload extends javax.swing.JPanel {
    bottomMenu panelBottom;
    public MusicDownload() {
        initComponents();
        init();
        
    }
    

    public void init() {
        //Masih manual
        //rencananya buat variabel yang bakal nyimpen judul lagu, artist, dll (menyesuaikan sama model).Nanti variabel itu bakal jadi parameter atau nggak langsung ke database bisa.
        listMusicDownload1.addItem(new Model_Music("1", "Peace Of Mind (feat. Vargas & Lagola)", "03:00"));
        listMusicDownload1.addItem(new Model_Music("2", "Heaven", "04:37"));
        listMusicDownload1.addItem(new Model_Music("3", "SOS (feat. Aloe Blacc)", "02:37"));
        
       
       
    }
    public void init(bottomMenu bm){
        this.panelBottom = bm;
        
    }
    
    public void init(String no, String title, String time) {
        listMusicDownload1.addItem(new Model_Music(no, title, time));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMusicDownload1 = new component.ListMusicDownload<>();

        setBackground(new java.awt.Color(19, 19, 44));

        listMusicDownload1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMusicDownload1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listMusicDownload1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(listMusicDownload1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listMusicDownload1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMusicDownload1MouseClicked
       int index =  listMusicDownload1.getSelectedIndex();
       int maxIndex = listMusicDownload1.getModel().getSize() - 1;
       
       if (index != -1){
          String s = listMusicDownload1.getData().getName();
          panelBottom.getlb_Title().setText(s);
           
       }
       if(index == maxIndex){
           String s = listMusicDownload1.getData().getName();
           panelBottom.getlb_Title().setText(s);
       }
          
           
      
    }//GEN-LAST:event_listMusicDownload1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.ListMusicDownload<String> listMusicDownload1;
    // End of variables declaration//GEN-END:variables
}
