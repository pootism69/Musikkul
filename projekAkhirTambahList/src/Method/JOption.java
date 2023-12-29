
package Method;

import javax.swing.JPanel;
import javax.swing.JOptionPane;


public class JOption {
    public void warning( JPanel panel, String s) {
        
            JOptionPane.showMessageDialog(panel, s , "Message", JOptionPane.WARNING_MESSAGE);
            return;
    }

    
}
